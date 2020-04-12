package com.gmail.tomahawkmissile2.magicraft.enchantments.list;

import org.bukkit.Bukkit;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class InstantDeath {
	public void trigger(Player attack, Player dead) {
		dead.setHealth(0);
		dead.getLocation().getWorld().spawnParticle(Particle.SMOKE_NORMAL, dead.getLocation(), 50, 0, 0, 0, 1);
		dead.getLocation().getWorld().playSound(dead.getLocation(), Sound.ENTITY_WITHER_SPAWN, 1, 1);
		Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED+"[Magicraft] "+ChatColor.DARK_GRAY+attack.getName()+" killed "+dead.getName()+" with instant death @ x="+
				dead.getLocation().getX()+" y="+dead.getLocation().getY()+" z="+dead.getLocation().getZ()+"!");
		for(Player p:Bukkit.getOnlinePlayers()) {
			p.getLocation().getWorld().playSound(p.getLocation(), Sound.ENTITY_WITHER_SPAWN, 1, 1);
		}
	}
}
