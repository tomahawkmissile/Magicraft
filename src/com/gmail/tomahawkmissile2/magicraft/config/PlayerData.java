package com.gmail.tomahawkmissile2.magicraft.config;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.bukkit.entity.Player;
import com.gmail.tomahawkmissile2.magicraft.Main;
import com.gmail.tomahawkmissile2.magicraft.utils.YamlManager;

public class PlayerData {
	
	public static final String PLAYER_NAME = "general.name";
	public static final String PLAYER_UUID = "general.uuid";
	public static final String PLAYTIME = "general.time";
	public static final String LAST_SEEN = "general.last_seen";
	public static final String LAST_JOIN = "general.last_join";
	public static final String JOIN_DATE = "general.join_date";
	public static final String BANNED = "general.banned";
	public static final String OP = "general.op";
	public static final String IP = "general.ip";
	
	public static final String BALANCE = "economy.balance";
	
	
	private Player player;
	YamlManager m;
	
	public PlayerData(Player player) {
		this.player = player;
		m = new YamlManager(new File(Main.plugin.getDataFolder()+"/playerdata/"+player.getUniqueId().toString()+".yml"));
	}
	public void generate() {
		m.writeYaml(PLAYER_NAME, player.getName());
		m.writeYaml(PLAYER_UUID, player.getUniqueId().toString());
		m.writeYaml(PLAYTIME, 0.0D);
		m.writeYaml(LAST_SEEN, 0.0D);
		m.writeYaml(LAST_JOIN, 0.0D);
		long date = System.currentTimeMillis();
		SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy HH:mm");    
		Date resultdate = new Date(date);
		m.writeYaml(JOIN_DATE, sdf.format(resultdate));
		m.writeYaml(BANNED, player.isBanned());
		m.writeYaml(OP, player.isOp());
		m.writeYaml(IP, player.getAddress().getHostName());
	}
	public String read(String sector) {
		return (String) m.readYaml(sector);
	}
	public String findFromUuid() {
		return (String) m.readYaml(PlayerData.PLAYER_NAME);
	}
	public void delete() {
		new File(Main.plugin.getDataFolder()+"/playerdata/"+player.getUniqueId().toString()+".yml").delete();
	}
	public boolean exists() {
		return new File(Main.plugin.getDataFolder()+"/playerdata/"+player.getUniqueId().toString()+".yml").exists();
	}
	public File getFile() {
		return new File(Main.plugin.getDataFolder()+"/playerdata/"+player.getUniqueId().toString()+".yml");
	}
}
