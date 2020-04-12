package com.gmail.tomahawkmissile2.magicraft.config;

import java.io.File;

import org.bukkit.inventory.ItemStack;

import com.gmail.tomahawkmissile2.magicraft.Main;
import com.gmail.tomahawkmissile2.magicraft.shop.ItemData;
import com.gmail.tomahawkmissile2.magicraft.utils.YamlManager;

public class ShopConfig {
	
	static YamlManager manager = new YamlManager(new File(Main.plugin.getDataFolder()+"/shop/worth.yml"));
	
	public ShopConfig() {}
	
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
	
	public synchronized static boolean addItem(ItemStack is, int quantity, double price, ItemData data) {
		if(get(is.getType().toString())==null) {
			String section = is.getType().toString();
			manager.createSection(section);
			set(section+".quantity", quantity);
			set(section+".price", price);
			
			String name;
			
			return true;
		} else {
			return false;
		}
	}
}
