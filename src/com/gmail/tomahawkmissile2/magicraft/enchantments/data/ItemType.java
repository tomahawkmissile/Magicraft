package com.gmail.tomahawkmissile2.magicraft.enchantments.data;

import com.gmail.tomahawkmissile2.magicraft.enchantments.MagicItem;

public enum ItemType {
	TOOL, SWORD, BOW, HELMET, CHESTPLATE, LEGGINGS, BOOTS, NONE, ARMOR, PICKAXE, AXE, SHOVEL, HOE;
	
	public static ItemType getItemType(MagicItem item, boolean specific) {
		switch(item.getItem().getType()) {
		case WOODEN_PICKAXE:
		case STONE_PICKAXE:
		case IRON_PICKAXE:
		case GOLDEN_PICKAXE:
		case DIAMOND_PICKAXE:
			if(specific)
				return ItemType.PICKAXE;
			else
				return ItemType.TOOL;
		case WOODEN_AXE:
		case STONE_AXE:
		case IRON_AXE:
		case GOLDEN_AXE:
		case DIAMOND_AXE:
			if(specific)
				return ItemType.AXE;
			else
				return ItemType.TOOL;
		case WOODEN_SHOVEL:
		case STONE_SHOVEL:
		case IRON_SHOVEL:
		case GOLDEN_SHOVEL:
		case DIAMOND_SHOVEL:
			if(specific)
				return ItemType.SHOVEL;
			else
				return ItemType.TOOL;
		case WOODEN_HOE:
		case STONE_HOE:
		case IRON_HOE:
		case GOLDEN_HOE:
		case DIAMOND_HOE:
			if(specific)
				return ItemType.HOE;
			else
				return ItemType.TOOL;
		case WOODEN_SWORD:
		case STONE_SWORD:
		case IRON_SWORD:
		case GOLDEN_SWORD:
		case DIAMOND_SWORD:
			return ItemType.SWORD;
		case BOW:
			return ItemType.BOW;
		case LEATHER_HELMET:
		case CHAINMAIL_HELMET:
		case IRON_HELMET:
		case GOLDEN_HELMET:
		case DIAMOND_HELMET:
			if(specific)
				return ItemType.HELMET;
			else
				return ItemType.ARMOR;
		case LEATHER_CHESTPLATE:
		case CHAINMAIL_CHESTPLATE:
		case IRON_CHESTPLATE:
		case GOLDEN_CHESTPLATE:
		case DIAMOND_CHESTPLATE:
			if(specific)
				return ItemType.CHESTPLATE;
			else
				return ItemType.ARMOR;
		case LEATHER_LEGGINGS:
		case CHAINMAIL_LEGGINGS:
		case IRON_LEGGINGS:
		case GOLDEN_LEGGINGS:
		case DIAMOND_LEGGINGS:
			if(specific)
				return ItemType.LEGGINGS;
			else
				return ItemType.ARMOR;
		case LEATHER_BOOTS:
		case CHAINMAIL_BOOTS:
		case IRON_BOOTS:
		case GOLDEN_BOOTS:
		case DIAMOND_BOOTS:
			if(specific)
				return ItemType.BOOTS;
			else
				return ItemType.ARMOR;
		default:
			return NONE;
		}
	}
}
