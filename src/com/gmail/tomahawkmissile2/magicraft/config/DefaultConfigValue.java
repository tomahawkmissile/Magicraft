package com.gmail.tomahawkmissile2.magicraft.config;

import net.md_5.bungee.api.ChatColor;

public enum DefaultConfigValue {

	MINIMUM_BALANCE("eco.minimum_balance","0"),
	
	SPAWN_LOCATION("spawn.location","UNSET"),
	SPAWN_WORLD("spawn.location.world","UNSET"),
	SPAWN_X("spawn.location.x","UNSET"),
	SPAWN_Y("spawn.location.y","UNSET"),
	SPAWN_Z("spawn.location.z","UNSET"),
	SPAWN_YAW("spawn.location.yaw","UNSET"),
	SPAWN_PITCH("spawn.location.pitch","UNSET"),
	
	MESSAGE_PERMISSION_ERROR("messages.permissions.error",ChatColor.RED+"Error: "+ChatColor.DARK_RED+"You do not have permission."),
	MESSAGE_BALANCE_INSUFFICIENT("messages.economy.balance.insufficient",ChatColor.RED+"Error: "+ChatColor.DARK_RED+"You do not have sufficient funds."),
	MESSAGE_SPAWN_EGG_ERROR("messages.spawner.egg.error",ChatColor.RED+"Error: "+ChatColor.DARK_RED+"You cannot change spawner types like this."),
	
	MESSAGE_REGISTRY_CREATE_EXISTS("messages.registry.create.exists",ChatColor.RED+"Error: "+ChatColor.DARK_RED+"That registry already exists."),
	MESSAGE_REGISTRY_CREATE_SUCCESS("messages.registry.create.success",ChatColor.DARK_GREEN+"Registry created successfully."),
	MESSAGE_REGISTRY_DELETE_SUCCESS("messages.registry.delete.success",ChatColor.DARK_GREEN+"Registry deleted successfully."),
	MESSAGE_REGISTRY_DELETE_FAIL("messages.registry.delete.fail",ChatColor.RED+"Error: "+ChatColor.DARK_RED+"That registry does not exist."),
	MESSAGE_REGISTRY_REMOVE_SUCCESS("messages.registry.remove.success",ChatColor.DARK_GREEN+"Register deleted successfully."),
	MESSAGE_REGISTRY_REMOVE_FAIL("messages.registry.remove.fail",ChatColor.RED+"Error: "+ChatColor.DARK_RED+"That register does not exist."),
	
	SPAWNER_REFUND("spawners.refund.enabled", "false");
	
	private final String path;
	private final String value;
	DefaultConfigValue(String path,String value) {
		this.path=path;
		this.value=value;
	}
	public String getPath() {
		return path;
	}
	public String getValue() {
		return value;
	}
}
