package com.gmail.tomahawkmissile2.magicraft.utils;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class LoreManager {

	ItemStack is;
	
	public LoreManager(ItemStack is) {
		this.is = is;
	}
	public void addLore(String s) {
		ItemMeta m = is.getItemMeta();
		List<String> lore;
		if(!m.hasLore())
			lore = new ArrayList<String>();
		else
			lore = m.getLore();
		lore.add(s);
		m.setLore(lore);
		is.setItemMeta(m);
	}
	public void removeLore(String s) {
		ItemMeta m = is.getItemMeta();
		if(!m.hasLore())
			return;
		List<String> lore = m.getLore();
		lore.remove(s);
		m.setLore(lore);
		is.setItemMeta(m);
	}
	public boolean hasLoreElement(String s) {
		if(is.getItemMeta().getLore().contains(s))
			return true;
		return false;
	}
	public void clearLore() {
		ItemMeta m = is.getItemMeta();
		if(!m.hasLore())
			return;
		List<String> newLore = m.getLore();
		for(String s : newLore) {
			newLore.remove(s);
		}
		m.setLore(newLore);
		is.setItemMeta(m);
	}
	public List<String> getLore() {
		ItemMeta m = is.getItemMeta();
		if(!m.hasLore())
			return null;
		return is.getItemMeta().getLore();
	}
}
