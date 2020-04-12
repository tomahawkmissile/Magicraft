package com.gmail.tomahawkmissile2.magicraft.economy;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class Shop {

	String name;
	Player owner;
	List<Player> managers;
	int tier;
	
	List<Inventory> stock;
	
	public Shop(String name, Player owner, List<Player> managers, int tier) {
		super();
		this.name = name;
		this.owner = owner;
		this.managers = managers;
		this.tier = tier;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Player getOwner() {
		return owner;
	}
	public void setOwner(Player owner) {
		this.owner = owner;
	}
	public List<Player> getManagers() {
		return managers;
	}
	public void addManager(Player player) {
		managers.add(player);
	}
	public void removeManager(Player player) {
		if(managers.contains(player)) {
			managers.remove(player);
		}
	}
	public void setManagers(List<Player> managers) {
		this.managers = managers;
	}
	public int getTier() {
		return tier;
	}
	public void setTier(int tier) {
		this.tier = tier;
	}
	
	public void addInventory(String name,int size) {
		stock.add(Bukkit.createInventory(null, size, name));
	}
	public void removeInventory(Inventory i) {
		if(stock.contains(i)) {
			stock.remove(i);
		}
	}
	/*
	public Inventory getInventory(String name) {
		for(Inventory inv:stock) {
			
		}
	}
	*/
}
