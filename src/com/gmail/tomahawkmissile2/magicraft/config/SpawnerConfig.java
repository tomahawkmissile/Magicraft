package com.gmail.tomahawkmissile2.magicraft.config;

import java.io.File;

import com.gmail.tomahawkmissile2.magicraft.Main;
import com.gmail.tomahawkmissile2.magicraft.utils.YamlManager;

public class SpawnerConfig {
	
	static YamlManager manager = new YamlManager(new File(Main.plugin.getDataFolder()+"/spawners.yml"));

	public static void set(String path, Object value) {
		manager.writeYaml(path, value);
	}
	public static Object get(String path) {
		return manager.readYaml(path);
	}
	public static void setDefaults() {
		
		String base = "prices";
		
		manager.createSection(base);
		
		manager.writeYaml(base+".bat", "12000");
		manager.writeYaml(base+".chicken", "120000");
		manager.writeYaml(base+".cow", "150000");
		manager.writeYaml(base+".mushroom_cow", "250000");
		manager.writeYaml(base+".pig", "100000");
		manager.writeYaml(base+".rabbit", "100000");
		manager.writeYaml(base+".sheep", "125000");
		manager.writeYaml(base+".squid", "25000");
		manager.writeYaml(base+".villager", "300000");
		manager.writeYaml(base+".cave_spider", "50000");
		manager.writeYaml(base+".enderman", "175000");
		manager.writeYaml(base+".polar_bear", "25000");
		manager.writeYaml(base+".spider", "60000");
		manager.writeYaml(base+".pig_zombie", "300000");
		manager.writeYaml(base+".blaze", "225000");
		manager.writeYaml(base+".creeper", "225000");
		manager.writeYaml(base+".endermite", "12000");
		manager.writeYaml(base+".ghast", "200000");
		manager.writeYaml(base+".guardian", "210000");
		manager.writeYaml(base+".magma_cube", "175000");
		manager.writeYaml(base+".shulker", "45000");
		manager.writeYaml(base+".silverfish", "10000");
		manager.writeYaml(base+".skeleton", "150000");
		manager.writeYaml(base+".slime", "150000");
		manager.writeYaml(base+".witch", "300000");
		manager.writeYaml(base+".wither_skeleton", "175000");
		manager.writeYaml(base+".zombie", "100000");
		manager.writeYaml(base+".horse", "50000");
		manager.writeYaml(base+".ocelot", "15000");
		manager.writeYaml(base+".wolf", "80000");
		manager.writeYaml(base+".iron_golem", "550000");
		manager.writeYaml(base+".snowman", "110000");
		manager.writeYaml(base+".none", "1500");
		manager.writeYaml(base+".parrot", "35000");
	}
}
