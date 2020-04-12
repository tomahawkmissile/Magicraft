package com.gmail.tomahawkmissile2.magicraft.config;

import java.io.File;

import com.gmail.tomahawkmissile2.magicraft.Main;
import com.gmail.tomahawkmissile2.magicraft.utils.YamlManager;

public class Config {

	static YamlManager manager = new YamlManager(new File(Main.plugin.getDataFolder()+"/config.yml"));

	public synchronized static void set(String path, Object value) {
		manager.writeYaml(path, value);
	}
	public synchronized static Object get(String path) {
		return manager.readYaml(path);
	}
	public synchronized static void setDefaults() {
		for(DefaultConfigValue val : DefaultConfigValue.values()) {
			manager.writeYaml(val.getPath(), val.getValue());
		}
	}
	public synchronized static void setDefault(DefaultConfigValue val) {
		manager.writeYaml(val.getPath(), val.getValue());
	}
}
