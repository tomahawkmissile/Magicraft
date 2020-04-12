package com.gmail.tomahawkmissile2.magicraft.ui;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import com.gmail.tomahawkmissile2.magicraft.registry.Permissions;
import com.gmail.tomahawkmissile2.magicraft.registry.Strings;
import com.gmail.tomahawkmissile2.magicraft.spawners.SpawnerUI;
import com.gmail.tomahawkmissile2.magicraft.utils.InventoryManager;

import net.md_5.bungee.api.ChatColor;

public class UI implements Listener {

	static Inventory i = Bukkit.createInventory(null, 9, "Main Menu");
	InventoryManager m = new InventoryManager(i);
	
	public void set() {
		m.setItem(Material.SPAWNER, ChatColor.GOLD+"Spawners", 1, 0, (short) 0);
		//m.setItem(Material.ENCHANTED_BOOK, ChatColor.AQUA+"Custom Enchantments", 1, 1, (short) 0);
		//m.setItem(Material.EMERALD, ChatColor.GREEN+"Shop", 1, 2, (short) 0);
		//m.setItem(Material.GLOWSTONE_DUST, ChatColor.DARK_GREEN+"Particle Effects", 1, 3, (short) 0);
		
		m.setItem(Material.BARRIER, ChatColor.RED+"Close", 1, 8, (short) 0);
	}
	public void open(Player player) {
		set();
		player.openInventory(i);
	}
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		if(e.getInventory().equals(i)&&(e.getRawSlot()<e.getView().getTopInventory().getSize())) {
			Player player = (Player) e.getWhoClicked();
			if(player.hasPermission(Permissions.GUI_USE)) {
				ItemStack is = e.getCurrentItem();
				if(is==null||is.getType()==Material.AIR||!is.hasItemMeta())
					return;
				e.setCancelled(true);
				player.closeInventory();
				switch(is.getType()) {
				case ENCHANTED_BOOK:
					//TODO
					break;
				case SPAWNER:
					SpawnerUI spawnerui = new SpawnerUI();
					spawnerui.open(player);
					break;
				case EMERALD:
					ShopUI shopui = new ShopUI();
					shopui.open(player);
					break;
				case GLOWSTONE_DUST:
					//TODO
					break;
				default:
					break;
				}
			} else {
				player.sendMessage(Strings.PERMISSION_ERROR);
				player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 0.5f, 0.5f);
			}
		}
	}
}
