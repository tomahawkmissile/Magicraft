package com.gmail.tomahawkmissile2.magicraft.ui;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import com.gmail.tomahawkmissile2.magicraft.registry.Strings;
import com.gmail.tomahawkmissile2.magicraft.utils.InventoryManager;

import net.md_5.bungee.api.ChatColor;

public class EnchantUI implements Listener {
	
	static Inventory i = Bukkit.createInventory(null, 9, "Custom Enchantments");
	InventoryManager m = new InventoryManager(i);
	
	public void set() {
		m.setItem(Material.SPAWNER, ChatColor.GOLD+"Spawners", 1, 0, (short) 0);
		m.setItem(Material.ENCHANTED_BOOK, ChatColor.AQUA+"Custom Enchantments", 1, 1, (short) 0);
		m.setItem(Material.EMERALD, ChatColor.GREEN+"Shop", 1, 2, (short) 0);
		
		m.setItem(Material.BARRIER, ChatColor.RED+"Close", 1, 8, (short) 0);
	}
	public void open(Player player) {
		set();
		player.openInventory(i);
	}
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		if(e.getInventory().equals(i)) {
			Player player = (Player) e.getWhoClicked();
			if(player.hasPermission("magicraft.gui.use")) {
				ItemStack is = e.getCurrentItem();
				if(is==null||is.getType()==Material.AIR||!is.hasItemMeta())
					return;
				e.setCancelled(true);
				player.closeInventory();
				switch(is.getType()) {
				case ENCHANTED_BOOK:
					//EnchantmentUI enchantmentui = new EnchantmentUI();
					//enchantmentui.open(player);
					break;
				default:
					break;
				}
			} else {
				player.sendMessage(Strings.PERMISSION_ERROR);
			}
		}
	}
}
