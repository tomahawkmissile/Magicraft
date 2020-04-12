package com.gmail.tomahawkmissile2.magicraft.spawners;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.gmail.tomahawkmissile2.magicraft.config.SpawnerConfig;
import com.gmail.tomahawkmissile2.magicraft.registry.Permissions;
import com.gmail.tomahawkmissile2.magicraft.registry.Strings;
import com.gmail.tomahawkmissile2.magicraft.spawners.utils.EntityManager;
import com.gmail.tomahawkmissile2.magicraft.spawners.utils.ItemStackManager;
import com.gmail.tomahawkmissile2.magicraft.utils.EconomyManager;
import com.gmail.tomahawkmissile2.magicraft.utils.InventoryManager;

import net.md_5.bungee.api.ChatColor;

public class SpawnerUI implements Listener {
	
	static Inventory inv = Bukkit.createInventory(null, 36, "Enchantment Menu");
	InventoryManager utils = new InventoryManager(inv);
	
	String base = Strings.SPAWNER_CONFIG_BASE;
	
	public void set() {
		utils.setItem(Material.FLINT, ChatColor.DARK_GRAY+"Bat"+ChatColor.WHITE+" - "+ChatColor.GOLD+"$"+SpawnerConfig.get(base+".bat"), 1, 0, (short) 0);
		utils.setItem(Material.FEATHER, ChatColor.YELLOW+"Chicken"+ChatColor.WHITE+" - "+ChatColor.GOLD+"$"+SpawnerConfig.get(base+".chicken"), 1, 1, (short) 0);
		utils.setItem(Material.LEATHER, ChatColor.GRAY+"Cow"+ChatColor.WHITE+" - "+ChatColor.GOLD+"$"+SpawnerConfig.get(base+".cow"), 1, 2, (short) 0);
		utils.setItem(Material.RED_MUSHROOM, ChatColor.RED+"Mooshroom"+ChatColor.WHITE+" - "+ChatColor.GOLD+"$"+SpawnerConfig.get(base+".mushroom_cow"), 1, 3, (short) 0);
		utils.setItem(Material.PORKCHOP, ChatColor.LIGHT_PURPLE+"Pig"+ChatColor.WHITE+" - "+ChatColor.GOLD+"$"+SpawnerConfig.get(base+".pig"), 1, 4, (short) 0);
		utils.setItem(Material.RABBIT_FOOT, ChatColor.GOLD+"Rabbit"+ChatColor.WHITE+" - "+ChatColor.GOLD+"$"+SpawnerConfig.get(base+".rabbit"), 1, 5, (short) 0);
		utils.setItem(Material.WHITE_WOOL, ChatColor.WHITE+"Sheep"+ChatColor.WHITE+" - "+ChatColor.GOLD+"$"+SpawnerConfig.get(base+".sheep"), 1, 6, (short) 0);
		utils.setItem(Material.INK_SAC, ChatColor.BLUE+"Squid"+ChatColor.WHITE+" - "+ChatColor.GOLD+"$"+SpawnerConfig.get(base+".squid"), 1, 7, (short) 0);
		utils.setItem(Material.EMERALD, ChatColor.GREEN+"Villager"+ChatColor.WHITE+" - "+ChatColor.GOLD+"$"+SpawnerConfig.get(base+".villager"), 1, 8, (short) 0);
		utils.setItem(Material.SPIDER_EYE, ChatColor.DARK_BLUE+"Cave Spider"+ChatColor.WHITE+" - "+ChatColor.GOLD+"$"+SpawnerConfig.get(base+".cave_spider"), 1, 9, (short) 0);
		utils.setItem(Material.ENDER_PEARL, ChatColor.DARK_PURPLE+"Enderman"+ChatColor.WHITE+" - "+ChatColor.GOLD+"$"+SpawnerConfig.get(base+".enderman"), 1, 10, (short) 0);
		utils.setItem(Material.COD, ChatColor.AQUA+"Polar Bear"+ChatColor.WHITE+" - "+ChatColor.GOLD+"$"+SpawnerConfig.get(base+".polar_bear"), 1, 11, (short) 0);
		utils.setItem(Material.STRING, ChatColor.LIGHT_PURPLE+"Spider"+ChatColor.WHITE+" - "+ChatColor.GOLD+"$"+SpawnerConfig.get(base+".spider"), 1, 12, (short) 0);
		utils.setItem(Material.GOLDEN_SWORD, ChatColor.GOLD+"Zombie Pigman"+ChatColor.WHITE+" - "+ChatColor.GOLD+"$"+SpawnerConfig.get(base+".pig_zombie"), 1, 13, (short) 0);
		utils.setItem(Material.BLAZE_ROD, ChatColor.RED+"Blaze"+ChatColor.WHITE+" - "+ChatColor.GOLD+"$"+SpawnerConfig.get(base+".blaze"), 1, 14, (short) 0);
		utils.setItem(Material.GUNPOWDER, ChatColor.GREEN+"Creeper"+ChatColor.WHITE+" - "+ChatColor.GOLD+"$"+SpawnerConfig.get(base+".creeper"), 1, 15, (short) 0);
		utils.setItem(Material.CHORUS_FRUIT, ChatColor.LIGHT_PURPLE+"Endermite"+ChatColor.WHITE+" - "+ChatColor.GOLD+"$"+SpawnerConfig.get(base+".endermite"), 1, 16, (short) 0);
		utils.setItem(Material.GHAST_TEAR, ChatColor.WHITE+"Ghast - "+ChatColor.GOLD+"$"+SpawnerConfig.get(base+".ghast"), 1, 17, (short) 0);
		utils.setItem(Material.PRISMARINE_SHARD, ChatColor.DARK_AQUA+"Guardian"+ChatColor.WHITE+" - "+ChatColor.GOLD+"$"+SpawnerConfig.get(base+".guardian"), 1, 18, (short) 0);
		utils.setItem(Material.MAGMA_CREAM, ChatColor.DARK_RED+"Magma Cube"+ChatColor.WHITE+" - "+ChatColor.GOLD+"$"+SpawnerConfig.get(base+".magma_cube"), 1, 19, (short) 0);
		utils.setItem(Material.SHULKER_SHELL, ChatColor.DARK_PURPLE+"Shulker"+ChatColor.WHITE+" - "+ChatColor.GOLD+"$"+SpawnerConfig.get(base+".shulker"), 1, 20, (short) 0);
		utils.setItem(Material.STONE, ChatColor.GRAY+"Silverfish"+ChatColor.WHITE+" - "+ChatColor.GOLD+"$"+SpawnerConfig.get(base+".silverfish"), 1, 21, (short) 0);
		utils.setItem(Material.BOW, ChatColor.WHITE+"Skeleton - "+ChatColor.GOLD+"$"+SpawnerConfig.get(base+".skeleton"), 1, 22, (short) 0);
		utils.setItem(Material.SLIME_BALL, ChatColor.GREEN+"Slime"+ChatColor.WHITE+" - "+ChatColor.GOLD+"$"+SpawnerConfig.get(base+".slime"), 1, 23, (short) 0);
		utils.setItem(Material.STICK, ChatColor.LIGHT_PURPLE+"Witch"+ChatColor.WHITE+" - "+ChatColor.GOLD+"$"+SpawnerConfig.get(base+".witch"), 1, 24, (short) 0);
		utils.setItem(Material.COAL, ChatColor.DARK_GRAY+"Wither Skeleton"+ChatColor.WHITE+" - "+ChatColor.GOLD+"$"+SpawnerConfig.get(base+".wither_skeleton"), 1, 25, (short) 0);
		utils.setItem(Material.ROTTEN_FLESH, ChatColor.DARK_RED+"Zombie"+ChatColor.WHITE+" - "+ChatColor.GOLD+"$"+SpawnerConfig.get(base+".zombie"), 1, 26, (short) 0);
		utils.setItem(Material.SADDLE, ChatColor.YELLOW+"Horse"+ChatColor.WHITE+" - "+ChatColor.GOLD+"$"+SpawnerConfig.get(base+".horse"), 1, 27, (short) 0);
		utils.setItem(Material.COOKED_COD, ChatColor.WHITE+"Ocelot - "+ChatColor.GOLD+"$"+SpawnerConfig.get(base+".ocelot"), 1, 28, (short) 0);
		utils.setItem(Material.NAME_TAG, ChatColor.GRAY+"Wolf"+ChatColor.WHITE+" - "+ChatColor.GOLD+"$"+SpawnerConfig.get(base+".wolf"), 1, 29, (short) 0);
		utils.setItem(Material.IRON_INGOT, ChatColor.WHITE+"Iron Golem - "+ChatColor.GOLD+"$"+SpawnerConfig.get(base+".iron_golem"), 1, 30, (short) 0);
		utils.setItem(Material.SNOWBALL, ChatColor.WHITE+"Snow Golem"+ChatColor.WHITE+" - "+ChatColor.GOLD+"$"+SpawnerConfig.get(base+".snowman"), 1, 31, (short) 0);
		utils.setItem(Material.WHEAT_SEEDS, ChatColor.GREEN+"Parrot"+ChatColor.WHITE+" - "+ChatColor.GOLD+"$"+SpawnerConfig.get(base+".parrot"), 1, 32, (short) 0);
		
		//utils.setItem(Material.SPAWNER, ChatColor.GRAY+"None"+ChatColor.WHITE+" - "+ChatColor.GOLD+"$"+SpawnerConfig.get(base+".none"), 1, 34, (short) 0);
		utils.setItem(Material.BARRIER, ChatColor.RED+"Close", 1, 35, (short) 0);
	}
	public void open(Player player) {
		if(player.hasPermission(Permissions.GUI_USE)) {
			set();
			player.openInventory(inv);
		} else
			player.sendMessage(Strings.PERMISSION_ERROR);
			player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 0.5f, 0.5f);
	}
	private void giveSpawner(Player player, EntityType type) {
		ItemStack spawner = new ItemStack(Material.SPAWNER);
		ItemMeta itemmeta = spawner.getItemMeta();
		itemmeta.setDisplayName(ChatColor.WHITE+"Monster Spawner");
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GRAY+EntityManager.getStringByEntityType(type));
		itemmeta.setLore(lore);
		spawner.setItemMeta(itemmeta);
		if(player.getGameMode()==GameMode.SPECTATOR) {
			player.sendMessage(ChatColor.RED+"Error: "+ChatColor.DARK_RED+"You cannot be in spectator mode to receive a spawner.");
			player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 0.5f, 0.5f);
		} else {
			player.getInventory().addItem(spawner);
		}
	}
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		Player player = (Player) e.getWhoClicked();
		if(!e.getInventory().equals(inv)) 
			return;
		if(e.getRawSlot()<e.getView().getTopInventory().getSize()) {
			ItemStack item = e.getCurrentItem();
			if(item==null||item.getType()==Material.AIR||(!item.hasItemMeta()))
				return;
			e.setCancelled(true);
			player.closeInventory();
			if(ItemStackManager.convertItemStackToEntityType(item)==null) return;
			EntityType t = ItemStackManager.convertItemStackToEntityType(item);
			String s = SpawnerConfig.get(base+"."+(t.toString().toLowerCase().equals("unknown")?"none":t.toString().toLowerCase())).toString();
			if(player.getGameMode()!=GameMode.CREATIVE) {
				if(EconomyManager.hasEnough(player, s)) {
					this.giveSpawner(player, t);
					EconomyManager.subtract(player, s);
				} else {
					player.sendMessage(Strings.BALANCE_INSUFFICIENT);
					player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 0.5f, 0.5f);
				}
			} else if(player.getGameMode()==GameMode.CREATIVE || player.hasPermission("magicraft.spawner.priceExempt")) {
				this.giveSpawner(player, t);
			}	
		}
	}
}
