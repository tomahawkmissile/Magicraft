package com.gmail.tomahawkmissile2.magicraft.enchantments.utils;

import com.gmail.tomahawkmissile2.magicraft.enchantments.data.MagicEnchantmentType;

public class EnchantmentManager {
	
	public static String convertMagicEnchantmentToString(MagicEnchantmentType type) {
		String s = "None";
		switch(type) {
		case AIRSTRIKE:
			s="Airstrike";
			break;
		case ANTIPOTION:
			s="Anti Potion";
			break;
		case BLINDNESS:
			s="Blindness";
			break;
		case CREEPER:
			s="Creeper";
			break;
		case DOUBLE_JUMP:
			s="Double Jump";
			break;
		case ELECTROCUTE:
			s="Electrocute";
			break;
		case ENHANCED_DEATH:
			s="Enhanced Death";
			break;
		case FIRE_WALKER:
			s="Fire Walker";
			break;
		case GUN:
			s="Gun";
			break;
		case INSTANT_DEATH:
			s="Instant Death";
			break;
		case JUMP_BOOST:
			s="Jump Boost";
			break;
		case LEVITATION:
			s="Levitation";
			break;
		case LIFESTEAL:
			s="Lifesteal";
			break;
		case LOCK_ON_ARROW:
			s="Lock on Arrow";
			break;
		case MISSILE:
			s="Missile";
			break;
		case NAUSEA:
			s="Nausea";
			break;
		case NIGHT_VISION:
			s="Night Vision";
			break;
		case NO_NAMETAG:
			s="No Nametag";
			break;
		case POISON:
			s="Poison";
			break;
		case POTIONKEEPER:
			s="Potion Keeper";
			break;
		case REGENERATION:
			s="Regeneration";
			break;
		case SHOCK:
			s="Shock";
			break;
		case STRENGTH:
			s="Strength";
			break;
		case TELEPORTER:
			s="Teleporter";
			break;
		case HEALTHBOOST:
			s="Healthboost";
			break;
		case WITHER:
			s="Wither";
			break;
		default:
			break;
		}
		return s;
	}
	public static MagicEnchantmentType convertStringToMagicEnchantment(String s) {
		if(s.equalsIgnoreCase("airstrike")) {
			return MagicEnchantmentType.AIRSTRIKE;
		} else if(s.equalsIgnoreCase("anti potion")) {
			return MagicEnchantmentType.ANTIPOTION;
		} else if(s.equalsIgnoreCase("blindess")) {
			return MagicEnchantmentType.BLINDNESS;
		} else if(s.equalsIgnoreCase("creeper")) {
			return MagicEnchantmentType.CREEPER;
		} else if(s.equalsIgnoreCase("double jump")) {
			return MagicEnchantmentType.DOUBLE_JUMP;
		} else if(s.equalsIgnoreCase("electrocute")) {
			return MagicEnchantmentType.ELECTROCUTE;
		} else if(s.equalsIgnoreCase("enhanced death")) {
			return MagicEnchantmentType.ENHANCED_DEATH;
		} else if(s.equalsIgnoreCase("fire walker")) {
			return MagicEnchantmentType.FIRE_WALKER;
		} else if(s.equalsIgnoreCase("gun")) {
			return MagicEnchantmentType.GUN;
		} else if(s.equalsIgnoreCase("instant death")) {
			return MagicEnchantmentType.INSTANT_DEATH;
		} else if(s.equalsIgnoreCase("jump boost")) {
			return MagicEnchantmentType.JUMP_BOOST;
		} else if(s.equalsIgnoreCase("levitation")) {
			return MagicEnchantmentType.LEVITATION;
		} else if(s.equalsIgnoreCase("lifesteal")) {
			return MagicEnchantmentType.LIFESTEAL;
		} else if(s.equalsIgnoreCase("lock on arrow")) {
			return MagicEnchantmentType.LOCK_ON_ARROW;
		} else if(s.equalsIgnoreCase("missile")) {
			return MagicEnchantmentType.MISSILE;
		} else if(s.equalsIgnoreCase("nausea")) {
			return MagicEnchantmentType.NAUSEA;
		} else if(s.equalsIgnoreCase("night vision")) {
			return MagicEnchantmentType.NIGHT_VISION;
		} else if(s.equalsIgnoreCase("no nametag")) {
			return MagicEnchantmentType.NO_NAMETAG;
		} else if(s.equalsIgnoreCase("poison")) {
			return MagicEnchantmentType.POISON;
		} else if(s.equalsIgnoreCase("potion keeper")) {
			return MagicEnchantmentType.POTIONKEEPER;
		} else if(s.equalsIgnoreCase("regeneration")) {
			return MagicEnchantmentType.REGENERATION;
		} else if(s.equalsIgnoreCase("shock")) {
			return MagicEnchantmentType.SHOCK;
		} else if(s.equalsIgnoreCase("strength")) {
			return MagicEnchantmentType.STRENGTH;
		} else if(s.equalsIgnoreCase("teleporter")) {
			return MagicEnchantmentType.TELEPORTER;
		} else if(s.equalsIgnoreCase("healthboost")) {
			return MagicEnchantmentType.HEALTHBOOST;
		} else if(s.equalsIgnoreCase("wither")) {
			return MagicEnchantmentType.WITHER;
		}
		return MagicEnchantmentType.NONE;
	}
}
