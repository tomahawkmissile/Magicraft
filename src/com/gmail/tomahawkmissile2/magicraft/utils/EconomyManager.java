package com.gmail.tomahawkmissile2.magicraft.utils;

import org.bukkit.Sound;
import org.bukkit.entity.Player;

import com.gmail.tomahawkmissile2.magicraft.Main;
import com.gmail.tomahawkmissile2.magicraft.registry.Strings;

import net.md_5.bungee.api.ChatColor;

public class EconomyManager {
	
	private static void playNotEnough(Player player) {
		player.sendMessage(Strings.BALANCE_INSUFFICIENT);
	}
	private static void playEnough(Player player, double amount) {
		player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.5f, 1.5f);
		player.sendMessage(ChatColor.GREEN+"$"+amount+" has been taken from your account.");
	}
	private static void playRefund(Player player, double amount) {
		player.sendMessage(ChatColor.GREEN+"$"+amount+" has been refunded to you.");
		player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.5f, 1.5f);
	}
	
	public static boolean hasEnough(Player player, double amount) {
		if(Main.getEconomy().getBalance(player)>=amount)
			return true;
		return false;
	}
	public static boolean hasEnough(Player player, String amount) {
		if(Main.getEconomy().getBalance(player)>=Double.parseDouble(amount))
			return true;
		return false;
	}
	public static void subtract(Player player, double amount) {
		if(hasEnough(player, amount)) {
			Main.getEconomy().withdrawPlayer(player, amount);
			playEnough(player,amount);
		} else {
			playNotEnough(player);
		}
	}
	public static void subtract(Player player, String amount) {
		double d = Double.parseDouble(amount);
		if(hasEnough(player, d)) {
			playEnough(player,d);
			Main.getEconomy().withdrawPlayer(player, d);
		} else {
			playNotEnough(player);
		}
	}
	public static void add(Player player, double amount) {
		Main.getEconomy().depositPlayer(player, amount);
	}
	public static void add(Player player, String amount) {
		Main.getEconomy().depositPlayer(player, Double.parseDouble(amount));
	}
	public static void refund(Player player, String amount) {
		add(player, amount);
		playRefund(player, Double.parseDouble(amount));
	}
	public static void refund(Player player, double amount) {
		add(player, amount);
		playRefund(player, amount);
	}
}
