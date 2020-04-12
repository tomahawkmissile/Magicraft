package com.gmail.tomahawkmissile2.magicraft.enchantments.data;

import com.gmail.tomahawkmissile2.magicraft.enchantments.MagicItem;

public enum MagicEnchantmentType {
	FIRE_WALKER ("Fire Walker",3,ItemType.BOOTS),
	INSTANT_DEATH("Instant Death",1,ItemType.SWORD),
	NAUSEA("Nausea",5,ItemType.SWORD),
	POISON("Poison",5,ItemType.SWORD),
	BLINDNESS("Blindness",5,ItemType.SWORD),
	STRENGTH("Strength",5,ItemType.ARMOR),
	REGENERATION("Regeneration",5,ItemType.ARMOR),
	LIFESTEAL("Lifesteal",5,ItemType.SWORD),
	HEALTHBOOST("Healthboost",5,ItemType.ARMOR),
	JUMP_BOOST("Jumpboost",3,ItemType.BOOTS),
	TELEPORTER("Teleporter",3,ItemType.ARMOR),
	CREEPER("Creeper",3,ItemType.ARMOR),
	SHOCK("Shock",5,ItemType.SWORD),
	AIRSTRIKE("Airstrike",5,ItemType.BOW),
	GUN("Gun",1,ItemType.BOW),
	DOUBLE_JUMP("Double Jump",1,ItemType.BOOTS),
	NIGHT_VISION("Night Vision",1,ItemType.HELMET),
	ELECTROCUTE("Electrocute",1,ItemType.SWORD),
	NO_NAMETAG("No Nametag",1,ItemType.HELMET),
	LEVITATION("Levitation",5,ItemType.SWORD),
	ENHANCED_DEATH("Enhanced Death",1,ItemType.ARMOR),
	WITHER("Wither",5,ItemType.SWORD),
	POTIONKEEPER("Potion Keeper",1,ItemType.ARMOR),
	LOCK_ON_ARROW("Lock on Arrow",1,ItemType.BOW),
	ANTIPOTION("Anti Potion",1,ItemType.ARMOR),
	MISSILE("Missile",5,ItemType.BOW), 
	SUPER_CRIT("Super Crit", 3,ItemType.AXE),
	NONE("None",0,ItemType.NONE);
	
	String name;
	int maxLevel;
	ItemType applicableTo;
	
	private MagicEnchantmentType(String name, int maxLevel, ItemType applicableTo) {
		this.name = name;
		this.maxLevel = maxLevel;
		this.applicableTo = applicableTo;
	}
	public String getName() {
		return name;
	}
	public int getMaxLevel() {
		return maxLevel;
	}
	public ItemType getApplicants() {
		return applicableTo;
	}
	public boolean isApplicableTo(MagicItem it) {
		for(MagicEnchantmentType t : it.getApplicableEnchantments())
			if(t==this)
				return true;
		return false;
	}
	public static MagicEnchantmentType getByName(String input) {
		for(MagicEnchantmentType t : MagicEnchantmentType.values())
			if(t.getName().equalsIgnoreCase(input))
				return t;
		return MagicEnchantmentType.NONE;
	}
}
