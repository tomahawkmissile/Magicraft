package com.gmail.tomahawkmissile2.magicraft.enchantments.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import com.gmail.tomahawkmissile2.magicraft.enchantments.data.MagicEnchantmentType;

public class ItemStackManager {

	public static ItemStack convertMagicEnchantmentToItemStack(MagicEnchantmentType type) {
		ItemStack item = null;
		switch(type) {
		case AIRSTRIKE:
			item = new ItemStack(Material.ELYTRA);
			break;
		case ANTIPOTION:
			item = new ItemStack(Material.MILK_BUCKET);
			break;
		case BLINDNESS:
			item = new ItemStack(Material.COAL_BLOCK);
			break;
		case CREEPER:
			item = new ItemStack(Material.TNT);
			break;
		case DOUBLE_JUMP:
			item = new ItemStack(Material.GOLDEN_BOOTS);
			break;
		case ELECTROCUTE:
			item = new ItemStack(Material.REDSTONE);
			break;
		case ENHANCED_DEATH:
			item = new ItemStack(Material.GOLD_INGOT);
			break;
		case FIRE_WALKER:
			item = new ItemStack(Material.FIRE_CHARGE);
			break;
		case GUN:
			item = new ItemStack(Material.BOW);
			break;
		case HEALTHBOOST:
			item = new ItemStack(Material.GOLDEN_APPLE);
			break;
		case INSTANT_DEATH:
			item = new ItemStack(Material.LAVA_BUCKET);
			break;
		case JUMP_BOOST:
			item = new ItemStack(Material.IRON_BOOTS);
			break;
		case LEVITATION:
			item = new ItemStack(Material.FEATHER);
			break;
		case LIFESTEAL:
			item = new ItemStack(Material.IRON_BARS);
			break;
		case LOCK_ON_ARROW:
			item = new ItemStack(Material.SPECTRAL_ARROW);
			break;
		case MISSILE:
			item = new ItemStack(Material.GUNPOWDER);
			break;
		case NAUSEA:
			item = new ItemStack(Material.POTION);
			break;
		case NIGHT_VISION:
			item = new ItemStack(Material.GOLDEN_CARROT);
			break;
		case NONE:
			item = new ItemStack(Material.BARRIER);
			break;
		case NO_NAMETAG:
			item = new ItemStack(Material.NAME_TAG);
			break;
		case POISON:
			item = new ItemStack(Material.SPIDER_EYE);
			break;
		case POTIONKEEPER:
			item = new ItemStack(Material.CHEST);
			break;
		case REGENERATION:
			item = new ItemStack(Material.APPLE);
			break;
		case SHOCK:
			item = new ItemStack(Material.ICE);
			break;
		case STRENGTH:
			item = new ItemStack(Material.ANVIL);
			break;
		case TELEPORTER:
			item = new ItemStack(Material.ENDER_PEARL);
			break;
		case WITHER:
			item = new ItemStack(Material.ROTTEN_FLESH);
			break;
		default:
			return item;
		}
		return item;
	}
	public static MagicEnchantmentType convertItemStackToMagicEnchantment(ItemStack item) {
		switch(item.getType()) {
		case ELYTRA:
			return MagicEnchantmentType.AIRSTRIKE;
		case MILK_BUCKET:
			return MagicEnchantmentType.ANTIPOTION;
		case COAL_BLOCK:
			return MagicEnchantmentType.BLINDNESS;
		case TNT:
			return MagicEnchantmentType.CREEPER;
		case GOLDEN_BOOTS:
			return MagicEnchantmentType.DOUBLE_JUMP;
		case REDSTONE:
			return MagicEnchantmentType.ELECTROCUTE;
		case GOLD_INGOT:
			return MagicEnchantmentType.ENHANCED_DEATH;
		case FIRE_CHARGE:
			return MagicEnchantmentType.FIRE_WALKER;
		case BOW:
			return MagicEnchantmentType.GUN;
		case GOLDEN_APPLE:
			return MagicEnchantmentType.HEALTHBOOST;
		case LAVA_BUCKET:
			return MagicEnchantmentType.INSTANT_DEATH;
		case IRON_BOOTS:
			return MagicEnchantmentType.JUMP_BOOST;
		case FEATHER:
			return MagicEnchantmentType.LEVITATION;
		case IRON_BARS:
			return MagicEnchantmentType.LIFESTEAL;
		case SPECTRAL_ARROW:
			return MagicEnchantmentType.LOCK_ON_ARROW;
		case GUNPOWDER:
			return MagicEnchantmentType.MISSILE;
		case POTION:
			return MagicEnchantmentType.NAUSEA;
		case GOLDEN_CARROT:
			return MagicEnchantmentType.NIGHT_VISION;
		case BARRIER:
			return MagicEnchantmentType.NONE;
		case NAME_TAG:
			return MagicEnchantmentType.NO_NAMETAG;
		case SPIDER_EYE:
			return MagicEnchantmentType.POISON;
		case CHEST:
			return MagicEnchantmentType.POTIONKEEPER;
		case APPLE:
			return MagicEnchantmentType.REGENERATION;
		case ICE:
			return MagicEnchantmentType.SHOCK;
		case ANVIL:
			return MagicEnchantmentType.STRENGTH;
		case ENDER_PEARL:
			return MagicEnchantmentType.TELEPORTER;
		case ROTTEN_FLESH:
			return MagicEnchantmentType.WITHER;
		default:
			return MagicEnchantmentType.NONE; 
		}
	}
}
