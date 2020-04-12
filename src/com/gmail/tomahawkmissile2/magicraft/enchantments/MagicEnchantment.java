package com.gmail.tomahawkmissile2.magicraft.enchantments;

import com.gmail.tomahawkmissile2.magicraft.enchantments.data.MagicEnchantmentType;

import net.md_5.bungee.api.ChatColor;

public class MagicEnchantment {

	private MagicEnchantmentType type;
	private int level;
	
	public MagicEnchantment(MagicEnchantmentType type, int level) {
		this.type=type;
		this.level=level;
	}
	public MagicEnchantmentType getType() {
		return type;
	}
	public int getLevel() {
		return level;
	}
	public String getApplicableString() {
		return ChatColor.GRAY+type.getName()+level;
	}
}
