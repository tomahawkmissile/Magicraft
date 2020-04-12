package com.gmail.tomahawkmissile2.magicraft.shop;

import java.util.List;

import com.gmail.tomahawkmissile2.magicraft.enchantments.MagicEnchantment;

public class ItemData {

	String name;
	List<String> lore;
	int durability;
	List<MagicEnchantment> enchants;
	
	public ItemData(String name, List<String> lore, int durability, List<MagicEnchantment> enchants) {
		this.name=name;
		this.lore=lore;
		this.durability=durability;
		this.enchants=enchants;
	}
}
