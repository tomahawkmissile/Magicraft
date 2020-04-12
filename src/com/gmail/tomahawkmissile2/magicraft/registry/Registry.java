package com.gmail.tomahawkmissile2.magicraft.registry;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gmail.tomahawkmissile2.magicraft.Main;
import com.gmail.tomahawkmissile2.magicraft.utils.YamlManager;

public class Registry {

public static final String MAIN = "main";
	
	private static List<Registry> subs = new ArrayList<Registry>();
	
	String name;
	
	public Registry(String name) {
		this.name=name;
	}
	public synchronized void finalize() {
		if(!subs.contains(this)) {
			subs.add(this);
		}
	}
	public void delete() {
		subs.remove(this);
	}
	public static Registry getByName(String name) {
		for(Registry r:subs) {
			if(r.getName()==name) {
				return r;
			}
		}
		return null;
	}
	public static List<Registry> getAll() {
		return subs;
	}
	public static Registry getRegistry(String name) {
		if(subs.contains(Registry.getByName(name))) {
			return Registry.getByName(name);
		}
		return null;
	}
	
	Map<Object,Object> registry = new HashMap<Object,Object>();

	public String getName() {
		return name;
	}
	public synchronized void addRegister(String title,Object e) {
		registry.putIfAbsent(title, e);
	}
	public synchronized void remRegister(String title) {
		registry.remove(title);
	}
	public synchronized void modRegister(String title,Object e) {
		if(registry.containsKey(title)) {
			registry.remove(title);
		}
		registry.putIfAbsent(title, e);
	}
	public synchronized Object getRegister(String title) {
		if(registry.containsKey(title)) {
			return registry.get(title);
		}
		return null;
	}
	public synchronized Object[] getAllRegisters() {
		return registry.keySet().toArray();
	}
	File root = new File(Main.plugin.getDataFolder()+"/registry");
	public void setRoot(File root) {
		this.root=root;
	}
	public static void saveAll() {
		for(Registry r:Registry.getAll()) {
			r.save();
		}
	}
	public static void loadAll() {
		for(Registry r:Registry.getAll()) {
			r.load();
		}
	}
	public void save() {
		File r = new File(root+"/"+this.getName()+".yml");
		YamlManager m = new YamlManager(r);
		if(r.exists()) {
			Object[] j = this.getAllRegisters();
			for(int i=0;i<j.length;i++) {
				m.writeYaml((String) j[i].toString(), this.getRegister((String) j[i].toString()));
			}
		} else {
			return;
		}
	}
	public void load() {
		File r = new File(root+"/"+this.getName()+".yml");
		if(r.exists()) {
			YamlManager m = new YamlManager(r);
			Object[] j = m.readKeys();
			for(int i=0;i<j.length;i++) {
				this.addRegister(j[i].toString(), m.readYaml((String) j[i]));
			}
		} else {
			return;
		}
	}
}
