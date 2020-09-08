package com.gmail.tomahawkmissile2.magicraft.enchantments;

import java.lang.reflect.Field;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.inventory.ItemStack;

import com.gmail.tomahawkmissile2.magicraft.Main;
import com.gmail.tomahawkmissile2.magicraft.enchantments.data.MagicEnchantmentType;
import com.gmail.tomahawkmissile2.magicraft.enchantments.list.InstantDeath;
import com.gmail.tomahawkmissile2.magicraft.enchantments.list.LifeSteal;

import net.md_5.bungee.api.ChatColor;

public class MagicEnchantment extends Enchantment {
	
	private MagicEnchantmentType type;
	private int level;
	
	@Override
	public boolean canEnchantItem(ItemStack is) {
		return true;
	}
	@Override
	public boolean conflictsWith(Enchantment other) {
		return false;
	}
	@Override
	public EnchantmentTarget getItemTarget() {
		switch(this.getType().getApplicants()) {
		case ARMOR:
			return EnchantmentTarget.ARMOR;
		case AXE:
		case PICKAXE:
		case SHOVEL:
		case TOOL:
		case HOE:
			return EnchantmentTarget.TOOL;
		case BOOTS:
			return EnchantmentTarget.ARMOR_FEET;
		case BOW:
			return EnchantmentTarget.BOW;
		case CHESTPLATE:
			return EnchantmentTarget.ARMOR_TORSO;
		case HELMET:
			return EnchantmentTarget.ARMOR_HEAD;
		case LEGGINGS:
			return EnchantmentTarget.ARMOR_LEGS;
		case SWORD:
			return EnchantmentTarget.WEAPON;
		case NONE:
		default:
			return null;
		}
	}
	@Override
	public int getMaxLevel() {
		return this.getType().getMaxLevel();
	}
	@Override
	public String getName() {
		return this.getType().getName();
	}
	@Override
	public int getStartLevel() {
		return 1;
	}
	@Override
	public boolean isTreasure() {
		return false;
	}
	@Override
	public boolean isCursed() {
		return false;
	}
	
	
	public MagicEnchantment(MagicEnchantmentType type, int level) {
		super(new NamespacedKey(Main.plugin, type.getName()));
		this.type=type;
		this.level=level;
	}
	public MagicEnchantment(MagicEnchantmentType type) {
		super(new NamespacedKey(Main.plugin, type.getName()));
		this.type=type;
		this.level=1;
	}
	public MagicEnchantmentType getType() {
		return type;
	}
	public int getLevel() {
		return level;
	}
	public String getApplicableString() {
		return ChatColor.GRAY+type.getName()+level;
	}
	
	public static void registerAllMagicEnchantments() {
		for(MagicEnchantmentType t:MagicEnchantmentType.values()) {
			try {
				MagicEnchantment me = new MagicEnchantment(t);
				try {
					Field f = Enchantment.class.getDeclaredField("acceptingNew");
					f.setAccessible(true);
					f.set(null, true);
				} catch(Exception e) {
					e.printStackTrace();
				}
				try {
					Enchantment.registerEnchantment(me);
				} catch(IllegalArgumentException e) {
					e.printStackTrace();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		Main.plugin.getServer().getPluginManager().registerEvents(new InstantDeath(), Main.plugin);
		Main.plugin.getServer().getPluginManager().registerEvents(new LifeSteal(), Main.plugin);
	}
}
