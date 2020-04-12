package com.gmail.tomahawkmissile2.magicraft.spawners.utils;

import org.bukkit.entity.EntityType;

public class EntityManager {

	public static String getStringByEntityType(EntityType type) {
		String s = null;
		switch(type) {
		case BAT:
			s = "Bat";
			break;
		case BLAZE:
			s = "Blaze";
			break;
		case CAVE_SPIDER:
			s = "Cave Spider";
			break;
		case CHICKEN:
			s = "Chicken";
			break;
		case COW:
			s = "Cow";
			break;
		case CREEPER:
			s = "Creeper";
			break;
		case ENDERMAN:
			s = "Enderman";
			break;
		case ENDERMITE:
			s = "Endermite";
			break;
		case GHAST:
			s = "Ghast";
			break;
		case GUARDIAN:
			s = "Guardian";
			break;
		case HORSE:
			s = "Horse";
			break;
		case IRON_GOLEM:
			s = "Iron Golem";
			break;
		case MAGMA_CUBE:
			s = "Magma Cube";
			break;
		case MUSHROOM_COW:
			s = "Mooshroom";
			break;
		case OCELOT:
			s = "Ocelot";
			break;
		case PIG:
			s = "Pig";
			break;
		case PIG_ZOMBIE:
			s = "Zombie Pigman";
			break;
		case POLAR_BEAR:
			s = "Polar Bear";
			break;
		case RABBIT:
			s = "Rabbit";
			break;
		case SHEEP:
			s = "Sheep";
			break;
		case SHULKER:
			s = "Shulker";
			break;
		case SILVERFISH:
			s = "Silverfish";
			break;
		case SKELETON:
			s = "Skeleton";
			break;
		case SLIME:
			s = "Slime";
			break;
		case SNOWMAN:
			s = "Snow Golem";
			break;
		case SPIDER:
			s = "Spider";
			break;
		case SQUID:
			s = "Squid";
			break;
		case VILLAGER:
			s = "Villager";
			break;
		case WITCH:
			s = "Witch";
			break;
		case WITHER_SKELETON:
			s = "Wither Skeleton";
			break;
		case WOLF:
			s = "Wolf";
			break;
		case ZOMBIE:
			s = "Zombie";
			break;
		case PARROT:
			s = "Parrot";
			break;
		case UNKNOWN:
			s = "None";
			break;
		default:
			s = "None";
			break;
		}
		return s;
	}
	public static EntityType getEntityTypeByString(String name) {
		if(name.equalsIgnoreCase("bat")) {
			return EntityType.BAT;
		} else if(name.equalsIgnoreCase("chicken")) {
			return EntityType.CHICKEN;
		} else if(name.equalsIgnoreCase("cow")) {
			return EntityType.COW;
		} else if(name.equalsIgnoreCase("mooshroom")) {
			return EntityType.MUSHROOM_COW;
		} else if(name.equalsIgnoreCase("pig")) {
			return EntityType.PIG;
		} else if(name.equalsIgnoreCase("rabbit")) {
			return EntityType.RABBIT;
		} else if(name.equalsIgnoreCase("sheep")) {
			return EntityType.SHEEP;
		} else if(name.equalsIgnoreCase("squid")) {
			return EntityType.SQUID;
		} else if(name.equalsIgnoreCase("villager")) {
			return EntityType.VILLAGER;
		} else if(name.equalsIgnoreCase("cave spider")) {
			return EntityType.CAVE_SPIDER;
		} else if(name.equalsIgnoreCase("enderman")) {
			return EntityType.ENDERMAN;
		} else if(name.equalsIgnoreCase("polar bear")) {
			return EntityType.POLAR_BEAR;
		} else if(name.equalsIgnoreCase("spider")) {
			return EntityType.SPIDER;
		} else if(name.equalsIgnoreCase("zombie pigman")) {
			return EntityType.PIG_ZOMBIE;
		} else if(name.equalsIgnoreCase("blaze")) {
			return EntityType.BLAZE;
		} else if(name.equalsIgnoreCase("creeper")) {
			return EntityType.CREEPER;
		} else if(name.equalsIgnoreCase("endermite")) {
			return EntityType.ENDERMITE;
		} else if(name.equalsIgnoreCase("ghast")) {
			return EntityType.GHAST;
		} else if(name.equalsIgnoreCase("guardian")) {
			return EntityType.GUARDIAN;
		} else if(name.equalsIgnoreCase("magma cube")) {
			return EntityType.MAGMA_CUBE;
		} else if(name.equalsIgnoreCase("shulker")) {
			return EntityType.SHULKER;
		} else if(name.equalsIgnoreCase("silverfish")) {
			return EntityType.SILVERFISH;
		} else if(name.equalsIgnoreCase("skeleton")) {
			return EntityType.SKELETON;
		} else if(name.equalsIgnoreCase("slime")) {
			return EntityType.SLIME;
		} else if(name.equalsIgnoreCase("witch")) {
			return EntityType.WITCH;
		} else if(name.equalsIgnoreCase("wither skeleton")) {
			return EntityType.WITHER_SKELETON;
		} else if(name.equalsIgnoreCase("zombie")) {
			return EntityType.ZOMBIE;
		} else if(name.equalsIgnoreCase("horse")) {
			return EntityType.HORSE;
		} else if(name.equalsIgnoreCase("ocelot")) {
			return EntityType.OCELOT;
		} else if(name.equalsIgnoreCase("wolf")) {
			return EntityType.WOLF;
		} else if(name.equalsIgnoreCase("iron golem")) {
			return EntityType.IRON_GOLEM;
		} else if(name.equalsIgnoreCase("snow golem")) {
			return EntityType.SNOWMAN;
		} else if(name.equalsIgnoreCase("parrot")) {
			return EntityType.PARROT;
		} else if(name.equalsIgnoreCase("none")) {
			return EntityType.UNKNOWN;
		}
		return null;
	}
}
