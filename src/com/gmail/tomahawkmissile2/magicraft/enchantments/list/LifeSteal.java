package com.gmail.tomahawkmissile2.magicraft.enchantments.list;

import org.bukkit.Particle;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import com.gmail.tomahawkmissile2.magicraft.enchantments.MagicItem;
import com.gmail.tomahawkmissile2.magicraft.enchantments.data.MagicEnchantmentType;

public class LifeSteal implements Listener {
	
	@EventHandler
	public void onPlayerPvP(EntityDamageByEntityEvent e) {
		if(e.getDamager() instanceof Player && e.getEntity() instanceof Player) {
			MagicItem mi = new MagicItem(((Player)e.getDamager()).getInventory().getItemInMainHand());
			if(mi.hasMagicEnchantmentType(MagicEnchantmentType.LIFESTEAL)) {
				this.trigger((Player)e.getDamager(), (Player)e.getEntity(), mi.getMagicEnchantmentLevel(MagicEnchantmentType.LIFESTEAL));
			}
		}
	}
	
	public void trigger(Player attacker, LivingEntity defender, int level) {
		attacker.setHealth(attacker.getHealth()+((defender.getHealth()*level)/10));
		defender.getLocation().getWorld().spawnParticle(Particle.ENCHANTMENT_TABLE, defender.getLocation(), 50, 0, 0, 0, 0.1);
	}
}
