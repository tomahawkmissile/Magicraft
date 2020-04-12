package com.gmail.tomahawkmissile2.magicraft.ui;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import com.gmail.tomahawkmissile2.magicraft.utils.InventoryManager;

import net.md_5.bungee.api.ChatColor;

public class ShopUI {

static Inventory inv = Bukkit.createInventory(null, 54, "Shop");
	
	InventoryManager m = new InventoryManager(inv);
	
	public void set() {
		
		
		m.setItem(Material.BARRIER, ChatColor.RED+"Close", 1, 53, (short) 0);
	}
	public void open(Player player) {
		set();
		player.openInventory(inv);
	}
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		if(!e.getInventory().equals(inv)) 
			return;
		ItemStack is = e.getCurrentItem();
		Player player = (Player) e.getWhoClicked();
		if(is==null||is.getType()==Material.AIR||(!is.hasItemMeta()))
			return;
		e.setCancelled(true);
		switch(is.getType()) {
		//TODO
		default:
			break;
		}
	}
}
