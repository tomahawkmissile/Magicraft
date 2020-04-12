package com.gmail.tomahawkmissile2.magicraft.registry;

import net.md_5.bungee.api.ChatColor;

public class Strings {

	//Spawner
	
	public final static String SPAWNER_LIST = "spawner.list";
	public final static String SPAWNER_CONFIG_BASE = "prices";
	
	public final static String SPAWNER_SET_TWICE = ChatColor.RED+"Error: "+ChatColor.DARK_RED+"You cannot set the spawner to the same type twice.";
	public final static String SPAWNER_INVALID_TYPE = ChatColor.RED+"Error: "+ChatColor.DARK_RED+"That spawner cannot be mined because it has an invalid type. If you believe this is an error. Please contact an administrator.";
	
	//Error messages
	
	public final static String PERMISSION_ERROR = ChatColor.RED+"Error: "+ChatColor.DARK_RED+"You do not have permission.";
	public final static String BALANCE_INSUFFICIENT = ChatColor.RED+"Error: "+ChatColor.DARK_RED+"You do not have sufficient funds.";
	public final static String SPAWN_EGG_ERROR = ChatColor.RED+"Error: "+ChatColor.DARK_RED+"You cannot change spawner types like this.";

	public final static String INVALID_ARGS = ChatColor.RED+"Error: "+ChatColor.DARK_RED+"Invalid arguments.";
}
