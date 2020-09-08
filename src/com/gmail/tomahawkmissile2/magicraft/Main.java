package com.gmail.tomahawkmissile2.magicraft;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.core.util.FileUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import com.gmail.tomahawkmissile2.magicraft.command.CommandHandler;
import com.gmail.tomahawkmissile2.magicraft.config.Config;
import com.gmail.tomahawkmissile2.magicraft.config.DefaultConfigValue;
import com.gmail.tomahawkmissile2.magicraft.config.EnchantmentConfig;
import com.gmail.tomahawkmissile2.magicraft.config.PlayerData;
import com.gmail.tomahawkmissile2.magicraft.config.SpawnerConfig;
import com.gmail.tomahawkmissile2.magicraft.enchantments.MagicEnchantment;
import com.gmail.tomahawkmissile2.magicraft.registry.Registry;
import com.gmail.tomahawkmissile2.magicraft.spawners.Spawner;
import com.gmail.tomahawkmissile2.magicraft.spawners.SpawnerUI;
import com.gmail.tomahawkmissile2.magicraft.ui.UI;
import com.gmail.tomahawkmissile2.magicraft.utils.FileManager;
import com.gmail.tomahawkmissile2.magicraft.utils.YamlManager;

import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;

public class Main extends JavaPlugin implements Listener {

	public static Main plugin;
	
	public static double version = 1.0;
	
	private static Economy econ = null;
    private static Permission perms = null;
    private static Chat chat = null;
	
	public void onEnable() {
		Main.plugin=this;
		
		if (!setupEconomy() ) {
            System.out.println("ERROR: Disabling magicraft due to missing Vault installation!");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        setupPermissions();
        setupChat();
		
		this.getServer().getPluginManager().registerEvents(this, this);
		
		this.getServer().getPluginManager().registerEvents(new Spawner(), this);
		this.getServer().getPluginManager().registerEvents(new UI(), this);
		this.getServer().getPluginManager().registerEvents(new SpawnerUI(), this);
		
		this.getCommand("magicraft").setExecutor(new CommandHandler());
		
		MagicEnchantment.registerAllMagicEnchantments();
		
		this.createCoreFiles();
		this.setUnsetConfigurations();
		
		Registry config = new Registry("config");
		config.setRoot(this.getDataFolder());
		config.finalize();
		
		for(File f:new File(this.getDataFolder()+"/registry").listFiles()) {
			String s = FileUtils.getFileExtension(f);
			if(s.contains(".yml")||s.contains(".yaml")) {
				new Registry(f.getName()).finalize();
			}
		}
		Registry.loadAll();
	}
	
	private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }
    
    private boolean setupChat() {
        RegisteredServiceProvider<Chat> rsp = getServer().getServicesManager().getRegistration(Chat.class);
        chat = rsp.getProvider();
        return chat != null;
    }
    
    private boolean setupPermissions() {
        RegisteredServiceProvider<Permission> rsp = getServer().getServicesManager().getRegistration(Permission.class);
        perms = rsp.getProvider();
        return perms != null;
    }
	
	public void onDisable() {
		Registry.saveAll();
	}
	private void createCoreFiles() {
		FileManager.createFolder(new File(this.getDataFolder()+"/"));
		FileManager.createFolder(new File(this.getDataFolder()+"/playerdata"));
		
		if(!new File(this.getDataFolder()+"/config.yml").exists()) {
			FileManager.createFile(new File(this.getDataFolder()+"/config.yml"));
			Config.setDefaults();
		}
		if(!new File(this.getDataFolder()+"/spawners.yml").exists()) {
			FileManager.createFile(new File(this.getDataFolder()+"/spawners.yml"));
			SpawnerConfig.setDefaults();
		}
		if(!new File(this.getDataFolder()+"/enchants.yml").exists()) {
			FileManager.createFile(new File(this.getDataFolder()+"/enchants.yml"));
			EnchantmentConfig.setDefaults();
		}
		if(!new File(this.getDataFolder()+"/registry").exists()) {
			FileManager.createFolder(new File(this.getDataFolder()+"/registry"));
		}
		if(!new File(this.getDataFolder()+"/shop").exists()) {
			FileManager.createFolder(new File(this.getDataFolder()+"/shop"));
		}
	}
	private void setUnsetConfigurations() {
		for(DefaultConfigValue v:DefaultConfigValue.values()) {
			if(Config.get(v.getPath())==null || Config.get(v.getPath()).equals("")) {
				Config.setDefault(v);
			}
		}
	}
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		if(e.getPlayer()!=null) {
			File f = new File(Main.plugin.getDataFolder()+"/playerdata/"+e.getPlayer().getUniqueId()+".yml");
			if(!f.exists()) {
				try {
					f.createNewFile();
					new PlayerData(e.getPlayer()).generate();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
	@EventHandler
	public void onPlayerLeave(PlayerQuitEvent e) {
		if(e.getPlayer()!=null) {
			PlayerData pd = new PlayerData(e.getPlayer());
			if(pd!=null) {
				YamlManager m = new YamlManager(pd.getFile());
				long date = System.currentTimeMillis();
				SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy HH:mm");    
				Date resultdate = new Date(date);
				m.writeYaml(PlayerData.LAST_SEEN, sdf.format(resultdate));
			}
		}
	}
	public static Economy getEconomy() {
        return econ;
    }
    
    public static Permission getPermissions() {
        return perms;
    }
    
    public static Chat getChat() {
        return chat;
    }
}
