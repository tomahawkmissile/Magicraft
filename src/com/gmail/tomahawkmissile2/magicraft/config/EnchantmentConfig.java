package com.gmail.tomahawkmissile2.magicraft.config;

import java.io.File;

import com.gmail.tomahawkmissile2.magicraft.Main;
import com.gmail.tomahawkmissile2.magicraft.utils.YamlManager;

public class EnchantmentConfig {
	
	static YamlManager manager = new YamlManager(new File(Main.plugin.getDataFolder()+"/enchants.yml"));

	public static void set(String path, Object value) {
		manager.writeYaml(path, value);
	}
	public static Object get(String path) {
		return manager.readYaml(path);
	}
	public static void setDefaults() {
		
		String base = "prices";
		
		manager.createSection(base);
		
		
	}
}
