package com.gmail.tomahawkmissile2.magicraft.enchantments.list;

import org.bukkit.Particle;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

public class LifeSteal {
	public void trigger(Player attacker, LivingEntity defender, int level) {
		attacker.setHealth(attacker.getHealth()+((defender.getHealth()*level)/10));
		defender.getLocation().getWorld().spawnParticle(Particle.ENCHANTMENT_TABLE, defender.getLocation(), 50, 0, 0, 0, 0.1);
	}
}
