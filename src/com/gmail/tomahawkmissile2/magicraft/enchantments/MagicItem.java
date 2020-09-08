package com.gmail.tomahawkmissile2.magicraft.enchantments;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.inventory.ItemStack;

import com.gmail.tomahawkmissile2.magicraft.enchantments.data.ItemType;
import com.gmail.tomahawkmissile2.magicraft.enchantments.data.MagicEnchantmentType;
import com.gmail.tomahawkmissile2.magicraft.enchantments.utils.EnchantmentManager;
import com.gmail.tomahawkmissile2.magicraft.utils.LevelManager;
import com.gmail.tomahawkmissile2.magicraft.utils.LoreManager;

import net.md_5.bungee.api.ChatColor;

public class MagicItem {

	ItemStack item;
	
	public MagicItem(ItemStack item) {
		this.item = item;
	}
	public ItemStack getItem() {
		return item;
	}
	public int getAmount() {
		return item.getAmount();
	}
	@SuppressWarnings("deprecation")
	public short getDurability() {
		return item.getDurability();
	}
	public void applyMagicEnchantment(MagicEnchantment e) {
		if(hasMagicEnchantment(e))
			removeEnchantment(e);
		LoreManager m = new LoreManager(item);
		m.addLore(e.getApplicableString());
	}
	public void removeEnchantment(MagicEnchantment e) {
		LoreManager manager = new LoreManager(this.getItem());
		manager.removeLore(EnchantmentManager.convertMagicEnchantmentToString(e.getType()));
	}
	public boolean isEnchantable(MagicEnchantment e) {
		if(ItemType.getItemType(this, false)!=ItemType.NONE)
			return true;
		return false;
	}
	public void clear(ItemStack is) {
		LoreManager manager = new LoreManager(is);
		manager.clearLore();
	}
	public boolean hasMagicEnchantment(MagicEnchantment e) {
		for(MagicEnchantment me : this.getEnchantments())
			if(me==e)
				return true;
		return false;
	}
	public boolean hasMagicEnchantmentType(MagicEnchantmentType t) {
		for(MagicEnchantment me : this.getEnchantments())
			if(me.getType()==t)
				return true;
		return false;
	}
	public int getMagicEnchantmentLevel(MagicEnchantmentType t) {
		if(this.hasMagicEnchantmentType(t)) {
			for(MagicEnchantment me:this.getEnchantments()) {
				if(me.getType()==t) return me.getLevel();
			}
		}
		return 0;
	}
	
	public List<MagicEnchantment> getEnchantments() {
		List<MagicEnchantment> e = new ArrayList<MagicEnchantment>();;
		if(!item.hasItemMeta() || !item.getItemMeta().hasLore()) {
			return e;
		}
		List<String> ss = item.getItemMeta().getLore();
		if(ss==null)
			return e;
		for(String s : ss) {
			int level = LevelManager.getLevel(s);
			for(MagicEnchantmentType t : MagicEnchantmentType.values()) {
				if(ChatColor.stripColor(s).contains(t.getName())) {
					e.add(new MagicEnchantment(t,level));
				}
			}
		}
		return e;
	}
	public List<MagicEnchantmentType> getApplicableEnchantments() {
		List<MagicEnchantmentType> list = new ArrayList<MagicEnchantmentType>();
		for(MagicEnchantmentType t : MagicEnchantmentType.values()) {
			if(t.getApplicants()==ItemType.getItemType(this, false)) {
				list.add(t);
			}
		}
		return list;
	}
}
