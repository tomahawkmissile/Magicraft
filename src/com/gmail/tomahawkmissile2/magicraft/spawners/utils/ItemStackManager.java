package com.gmail.tomahawkmissile2.magicraft.spawners.utils;

import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;

public class ItemStackManager {

	public static EntityType convertItemStackToEntityType(ItemStack item) {
		switch(item.getType()) {
		case FLINT:
			return EntityType.BAT;
		case FEATHER:
			return EntityType.CHICKEN;
		case LEATHER:
			return EntityType.COW;
		case RED_MUSHROOM:
			return EntityType.MUSHROOM_COW;
		case PORKCHOP:
			return EntityType.PIG;
		case RABBIT_FOOT:
			return EntityType.RABBIT;
		case WHITE_WOOL:
			return EntityType.SHEEP;
		case INK_SAC:
			return EntityType.SQUID;
		case EMERALD:
			return EntityType.VILLAGER;
		case SPIDER_EYE:
			return EntityType.CAVE_SPIDER;
		case ENDER_PEARL:
			return EntityType.ENDERMAN;
		case COD:
			return EntityType.POLAR_BEAR;
		case STRING:
			return EntityType.SPIDER;
		case GOLDEN_SWORD:
			return EntityType.PIG_ZOMBIE;
		case BLAZE_ROD:
			return EntityType.BLAZE;
		case GUNPOWDER:
			return EntityType.CREEPER;
		case CHORUS_FRUIT:
			return EntityType.ENDERMITE;
		case GHAST_TEAR:
			return EntityType.GHAST;
		case PRISMARINE_SHARD:
			return EntityType.GUARDIAN;
		case MAGMA_CREAM:
			return EntityType.MAGMA_CUBE;
		case SHULKER_SHELL:
			return EntityType.SHULKER;
		case STONE:
			return EntityType.SILVERFISH;
		case BOW:
			return EntityType.SKELETON;
		case SLIME_BALL:
			return EntityType.SLIME;
		case STICK:
			return EntityType.WITCH;
		case COAL:
			return EntityType.WITHER_SKELETON;
		case ROTTEN_FLESH:
			return EntityType.ZOMBIE;
		case SADDLE:
			return EntityType.HORSE;
		case COOKED_COD:
			return EntityType.OCELOT;
		case NAME_TAG:
			return EntityType.WOLF;
		case IRON_INGOT:
			return EntityType.IRON_GOLEM;
		case SNOWBALL:
			return EntityType.SNOWMAN;
		case WHEAT_SEEDS:
			return EntityType.PARROT;
		case SPAWNER:
			return EntityType.UNKNOWN;
		default:
			break;
		}
		return null;
	}
}
