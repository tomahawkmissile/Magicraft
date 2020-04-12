package com.gmail.tomahawkmissile2.magicraft.spawners.data;

import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;

public class SpawnerData {

	EntityType entity;
	Block block;
	
	public SpawnerData(EntityType entity, Block block) {
		this.entity = entity;
		this.block = block;
	}
	public EntityType getEntity() {
		return entity;
	}
	public Block getBlock() {
		return block;
	}
}
