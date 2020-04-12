package com.gmail.tomahawkmissile2.magicraft.utils;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

@SuppressWarnings("deprecation")
public class InventoryManager {
	
	private static Inventory inv;
	
	public InventoryManager(Inventory inv) {
		InventoryManager.inv=inv;
	}
	public void setItem(Material m, String name, int amount, int slot, short durability) {
		ItemStack i=new ItemStack(m);
		ItemMeta mm=i.getItemMeta();
		mm.setDisplayName(name);
		i.setAmount(amount);
		i.setDurability(durability);
		i.setItemMeta(mm);
		inv.setItem(slot, i);
	}
	public void setItem(Material m, String name, int amount, int slot, short durability, String lore1) {
		ItemStack i=new ItemStack(m);
		ItemMeta mm=i.getItemMeta();
		mm.setDisplayName(name);
		i.setAmount(amount);
		i.setDurability(durability);
		List<String> lore = new ArrayList<String>();
		lore.add(lore1);
		mm.setLore(lore);
		i.setItemMeta(mm);
		inv.setItem(slot, i);
	}
	public void setItem(Material m, String name, int amount, int slot, short durability, String lore1, String lore2) {
		ItemStack i=new ItemStack(m);
		ItemMeta mm=i.getItemMeta();
		mm.setDisplayName(name);
		i.setAmount(amount);
		i.setDurability(durability);
		List<String> lore = new ArrayList<String>();
		lore.add(lore1);
		lore.add(lore2);
		mm.setLore(lore);
		i.setItemMeta(mm);
		inv.setItem(slot, i);
	}
	public void removeItem(ItemStack is) {
		if(inv.contains(is))
			inv.remove(is);
	}
	public void removeItem(int slot) {
		ItemStack[] iss=inv.getContents();
		inv.remove(iss[slot]);
	}
}
