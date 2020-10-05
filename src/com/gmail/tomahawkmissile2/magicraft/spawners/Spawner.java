package com.gmail.tomahawkmissile2.magicraft.spawners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import com.gmail.tomahawkmissile2.magicraft.config.Config;
import com.gmail.tomahawkmissile2.magicraft.config.SpawnerConfig;
import com.gmail.tomahawkmissile2.magicraft.registry.Permissions;
import com.gmail.tomahawkmissile2.magicraft.registry.Strings;
import com.gmail.tomahawkmissile2.magicraft.spawners.data.SpawnerData;
import com.gmail.tomahawkmissile2.magicraft.spawners.utils.EntityManager;
import com.gmail.tomahawkmissile2.magicraft.spawners.utils.ItemStackManager;
import com.gmail.tomahawkmissile2.magicraft.utils.EconomyManager;
import com.gmail.tomahawkmissile2.magicraft.utils.InventoryManager;
import com.gmail.tomahawkmissile2.magicraft.utils.LoreManager;

public class Spawner implements Listener {

	static Inventory i = Bukkit.createInventory(null, 36, "Mobs");
	
	SpawnerData data;
	
	Block block;
	
	String base = Strings.SPAWNER_CONFIG_BASE;
	
	private void set() {
		InventoryManager utils = new InventoryManager(i);
		
		utils.setItem(Material.FLINT, ChatColor.DARK_GRAY+"Bat"+ChatColor.WHITE+" - "+ChatColor.GOLD+"$"+SpawnerConfig.get(base+".bat"), 1, 0, (short) 0);
		utils.setItem(Material.FEATHER, ChatColor.YELLOW+"Chicken"+ChatColor.WHITE+" - "+ChatColor.GOLD+"$"+SpawnerConfig.get(base+".chicken"), 1, 1, (short) 0);
		utils.setItem(Material.LEATHER, ChatColor.GRAY+"Cow"+ChatColor.WHITE+" - "+ChatColor.GOLD+"$"+SpawnerConfig.get(base+".cow"), 1, 2, (short) 0);
		utils.setItem(Material.RED_MUSHROOM, ChatColor.RED+"Mooshroom"+ChatColor.WHITE+" - "+ChatColor.GOLD+"$"+SpawnerConfig.get(base+".mushroom_cow"), 1, 3, (short) 0);
		utils.setItem(Material.PORKCHOP, ChatColor.LIGHT_PURPLE+"Pig"+ChatColor.WHITE+" - "+ChatColor.GOLD+"$"+SpawnerConfig.get(base+".pig"), 1, 4, (short) 0);
		utils.setItem(Material.RABBIT_FOOT, ChatColor.GOLD+"Rabbit"+ChatColor.WHITE+" - "+ChatColor.GOLD+"$"+SpawnerConfig.get(base+".rabbit"), 1, 5, (short) 0);
		utils.setItem(Material.WHITE_WOOL, ChatColor.WHITE+"Sheep"+ChatColor.WHITE+" - "+ChatColor.GOLD+"$"+SpawnerConfig.get(base+".sheep"), 1, 6, (short) 0);
		utils.setItem(Material.INK_SAC, ChatColor.BLUE+"Squid"+ChatColor.WHITE+" - "+ChatColor.GOLD+"$"+SpawnerConfig.get(base+".squid"), 1, 7, (short) 0);
		utils.setItem(Material.EMERALD, ChatColor.GREEN+"Villager"+ChatColor.WHITE+" - "+ChatColor.GOLD+"$"+SpawnerConfig.get(base+".villager"), 1, 8, (short) 0);
		utils.setItem(Material.SPIDER_EYE, ChatColor.DARK_BLUE+"Cave Spider"+ChatColor.WHITE+" - "+ChatColor.GOLD+"$"+SpawnerConfig.get(base+".cave_spider"), 1, 9, (short) 0);
		utils.setItem(Material.ENDER_PEARL, ChatColor.DARK_PURPLE+"Enderman"+ChatColor.WHITE+" - "+ChatColor.GOLD+"$"+SpawnerConfig.get(base+".enderman"), 1, 10, (short) 0);
		utils.setItem(Material.COD, ChatColor.AQUA+"Polar Bear"+ChatColor.WHITE+" - "+ChatColor.GOLD+"$"+SpawnerConfig.get(base+".polar_bear"), 1, 11, (short) 0);
		utils.setItem(Material.STRING, ChatColor.LIGHT_PURPLE+"Spider"+ChatColor.WHITE+" - "+ChatColor.GOLD+"$"+SpawnerConfig.get(base+".spider"), 1, 12, (short) 0);
		utils.setItem(Material.GOLDEN_SWORD, ChatColor.GOLD+"Zombie Pigman"+ChatColor.WHITE+" - "+ChatColor.GOLD+"$"+SpawnerConfig.get(base+".pig_zombie"), 1, 13, (short) 0);
		utils.setItem(Material.BLAZE_ROD, ChatColor.RED+"Blaze"+ChatColor.WHITE+" - "+ChatColor.GOLD+"$"+SpawnerConfig.get(base+".blaze"), 1, 14, (short) 0);
		utils.setItem(Material.GUNPOWDER, ChatColor.GREEN+"Creeper"+ChatColor.WHITE+" - "+ChatColor.GOLD+"$"+SpawnerConfig.get(base+".creeper"), 1, 15, (short) 0);
		utils.setItem(Material.CHORUS_FRUIT, ChatColor.LIGHT_PURPLE+"Endermite"+ChatColor.WHITE+" - "+ChatColor.GOLD+"$"+SpawnerConfig.get(base+".endermite"), 1, 16, (short) 0);
		utils.setItem(Material.GHAST_TEAR, ChatColor.WHITE+"Ghast - "+ChatColor.GOLD+"$"+SpawnerConfig.get(base+".ghast"), 1, 17, (short) 0);
		utils.setItem(Material.PRISMARINE_SHARD, ChatColor.DARK_AQUA+"Guardian"+ChatColor.WHITE+" - "+ChatColor.GOLD+"$"+SpawnerConfig.get(base+".guardian"), 1, 18, (short) 0);
		utils.setItem(Material.MAGMA_CREAM, ChatColor.DARK_RED+"Magma Cube"+ChatColor.WHITE+" - "+ChatColor.GOLD+"$"+SpawnerConfig.get(base+".magma_cube"), 1, 19, (short) 0);
		utils.setItem(Material.SHULKER_SHELL, ChatColor.DARK_PURPLE+"Shulker"+ChatColor.WHITE+" - "+ChatColor.GOLD+"$"+SpawnerConfig.get(base+".shulker"), 1, 20, (short) 0);
		utils.setItem(Material.STONE, ChatColor.GRAY+"Silverfish"+ChatColor.WHITE+" - "+ChatColor.GOLD+"$"+SpawnerConfig.get(base+".silverfish"), 1, 21, (short) 0);
		utils.setItem(Material.BOW, ChatColor.WHITE+"Skeleton - "+ChatColor.GOLD+"$"+SpawnerConfig.get(base+".skeleton"), 1, 22, (short) 0);
		utils.setItem(Material.SLIME_BALL, ChatColor.GREEN+"Slime"+ChatColor.WHITE+" - "+ChatColor.GOLD+"$"+SpawnerConfig.get(base+".slime"), 1, 23, (short) 0);
		utils.setItem(Material.STICK, ChatColor.LIGHT_PURPLE+"Witch"+ChatColor.WHITE+" - "+ChatColor.GOLD+"$"+SpawnerConfig.get(base+".witch"), 1, 24, (short) 0);
		utils.setItem(Material.COAL, ChatColor.DARK_GRAY+"Wither Skeleton"+ChatColor.WHITE+" - "+ChatColor.GOLD+"$"+SpawnerConfig.get(base+".wither_skeleton"), 1, 25, (short) 0);
		utils.setItem(Material.ROTTEN_FLESH, ChatColor.DARK_RED+"Zombie"+ChatColor.WHITE+" - "+ChatColor.GOLD+"$"+SpawnerConfig.get(base+".zombie"), 1, 26, (short) 0);
		utils.setItem(Material.SADDLE, ChatColor.YELLOW+"Horse"+ChatColor.WHITE+" - "+ChatColor.GOLD+"$"+SpawnerConfig.get(base+".horse"), 1, 27, (short) 0);
		utils.setItem(Material.COOKED_COD, ChatColor.WHITE+"Ocelot - "+ChatColor.GOLD+"$"+SpawnerConfig.get(base+".ocelot"), 1, 28, (short) 0);
		utils.setItem(Material.NAME_TAG, ChatColor.GRAY+"Wolf"+ChatColor.WHITE+" - "+ChatColor.GOLD+"$"+SpawnerConfig.get(base+".wolf"), 1, 29, (short) 0);
		utils.setItem(Material.IRON_INGOT, ChatColor.WHITE+"Iron Golem - "+ChatColor.GOLD+"$"+SpawnerConfig.get(base+".iron_golem"), 1, 30, (short) 0);
		utils.setItem(Material.SNOWBALL, ChatColor.WHITE+"Snow Golem"+ChatColor.WHITE+" - "+ChatColor.GOLD+"$"+SpawnerConfig.get(base+".snowman"), 1, 31, (short) 0);
		utils.setItem(Material.WHEAT_SEEDS, ChatColor.GREEN+"Parrot"+ChatColor.WHITE+" - "+ChatColor.GOLD+"$"+SpawnerConfig.get(base+".parrot"), 1, 32, (short) 0);
		
		//utils.setItem(Material.SPAWNER, ChatColor.GRAY+"None"+ChatColor.WHITE+" - "+ChatColor.GOLD+"$"+SpawnerConfig.get(base+".none"), 1, 34, (short) 0);
		utils.setItem(Material.BARRIER, ChatColor.RED+"Close", 1, 35, (short) 0);
	}
	private void openSpawnerUI(Player player) {
		set();
		player.openInventory(i);
	}
	private void setSpawner(EntityType entity) {
		if(block==null || entity==null)
			return;
		BlockState blockState = block.getState();
		CreatureSpawner spawner = (CreatureSpawner) blockState;
		if(entity==EntityType.UNKNOWN) {
			spawner.setSpawnedType(EntityType.DROPPED_ITEM);
		} else {
			spawner.setSpawnedType(entity);
		}
		blockState.update();
	}
	private EntityType getType() {
		CreatureSpawner spawner = (CreatureSpawner) block.getState();
		return spawner.getSpawnedType();
	}
	@EventHandler
	public void onSpawnerPlace(BlockPlaceEvent e) {
		Player player = e.getPlayer();
		if(player!=null) {
			ItemStack hand = player.getInventory().getItemInMainHand();
			if(e.getBlockPlaced().getType()==Material.SPAWNER && hand.getType()==Material.SPAWNER) {
				if(!hand.getItemMeta().hasLore()) {
					//LoreManager manager = new LoreManager(hand);
					//manager.addLore(ChatColor.GRAY+"None");
				} else {
					for(String s : hand.getItemMeta().getLore()) {
						EntityType mob = EntityManager.getEntityTypeByString(ChatColor.stripColor(s));
						if(mob!=null) {
							BlockState blockState = e.getBlock().getState();
						    CreatureSpawner spawner = ((CreatureSpawner) blockState);
						    spawner.setSpawnedType(mob);
						    blockState.update();
						}
					}
				}
				this.block = e.getBlockPlaced();
			}
		}
	}
	@EventHandler
	public void onSpawnerBreak(BlockBreakEvent e) {
		Player player = e.getPlayer();
		if(player !=null) {
			if(player.getInventory().getItemInMainHand().hasItemMeta() && player.getGameMode()==GameMode.SURVIVAL) {
				if(e.getBlock().getType()==Material.SPAWNER && e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getEnchants().containsKey(Enchantment.SILK_TOUCH)) {
					BlockState blockState = e.getBlock().getState();
			        CreatureSpawner spawner = (CreatureSpawner) blockState;
				    EntityType mob = spawner.getSpawnedType();
				    ItemStack spawnerItem = new ItemStack(Material.SPAWNER);
				    if(EntityManager.getStringByEntityType(mob).equals("None")) {
					    //e.getBlock().getLocation().getWorld().dropItem(e.getBlock().getLocation(), spawnerItem);
				    	player.sendMessage(Strings.SPAWNER_INVALID_TYPE);
				    	player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 0.5f, 0.5f);
				    } else {
				    	e.setExpToDrop(0);
					    LoreManager l = new LoreManager(spawnerItem);
					    l.addLore(ChatColor.GRAY+EntityManager.getStringByEntityType(mob));
					    e.getBlock().getLocation().getWorld().dropItem(e.getBlock().getLocation(), spawnerItem);
				    }
				    this.block = null;
				}
			} else if(player.getGameMode()==GameMode.CREATIVE) {
				if(e.getBlock().getType()==Material.SPAWNER) {
					BlockState blockState = e.getBlock().getState();
			        CreatureSpawner spawner = (CreatureSpawner) blockState;
				    EntityType mob = spawner.getSpawnedType();
				    ItemStack spawnerItem = new ItemStack(Material.SPAWNER);
				    if(EntityManager.getStringByEntityType(mob).equals("None")) {
					   // e.getBlock().getLocation().getWorld().dropItem(e.getBlock().getLocation(), spawnerItem);
				    	player.sendMessage(Strings.SPAWNER_INVALID_TYPE);
				    	player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 0.5f, 0.5f);
				    } else {
					    LoreManager l = new LoreManager(spawnerItem);
					    l.addLore(ChatColor.GRAY+EntityManager.getStringByEntityType(mob));
					    e.getBlock().getLocation().getWorld().dropItem(e.getBlock().getLocation(), spawnerItem);
				    }
				    this.block = null;
				}
			}
		}
	}
	@EventHandler
	public void onSpawnerClick(PlayerInteractEvent e) {
		Player player = (Player) e.getPlayer();
		Block block = e.getClickedBlock();
		if(player==null || block==null)
			return;
		if(block.getType()==Material.SPAWNER && e.getAction()==Action.RIGHT_CLICK_BLOCK && e.getHand()==EquipmentSlot.HAND) {
			if(!player.isSneaking()) {
				if(player.hasPermission(Permissions.SPAWNER_USE)) {
					e.setCancelled(true);
					this.openSpawnerUI(player);
					this.block = block;
				} else {
					player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 0.5f, 0.5f);
					player.sendMessage(Strings.PERMISSION_ERROR);
				}
			} else if(player.isSneaking() && player.getInventory().getItemInMainHand().getType()==Material.ZOMBIE_SPAWN_EGG) {
				e.setCancelled(true);
				player.sendMessage(Strings.SPAWN_EGG_ERROR);
			}
		}
	}
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		if(e.getInventory().equals(i)) {
			if(e.getRawSlot()<e.getView().getTopInventory().getSize()) {
				ItemStack item = e.getCurrentItem();
				Player player = (Player) e.getWhoClicked();
				if(item==null || item.getType()==Material.AIR || !item.hasItemMeta() || this.block==null || player==null)
					return;
				e.setCancelled(true);
				player.closeInventory();
				EntityType t = ItemStackManager.convertItemStackToEntityType(item);
				if(t==null) return;
				String s = SpawnerConfig.get(base+"."+(t.toString().toLowerCase().equals("unknown")?"none":t.toString().toLowerCase())).toString();
				if(!t.toString().equalsIgnoreCase(this.getType().toString())) {
					if(player.getGameMode()!=GameMode.CREATIVE) {
						String refund = "";
						double refundAmount = 0.0;
						if(Config.get("spawners.refund.enabled").toString().equals("true")) {
							refund = SpawnerConfig.get(base+"."+this.getType().toString().toLowerCase())==null?"0":SpawnerConfig.get(base+"."+this.getType().toString().toLowerCase()).toString();
							refundAmount = Double.parseDouble(s)-Double.parseDouble(refund);
						}
						if(EconomyManager.hasEnough(player, (Config.get("spawners.refund.enabled").toString().equals("true")?refundAmount+"":s))) {
							if(SpawnerConfig.get(base+"."+this.getType().toString().toLowerCase())==null) {
								
							} else if(refundAmount>0) {
								EconomyManager.refund(player, SpawnerConfig.get(base+"."+this.getType().toString().toLowerCase()).toString());
							}
							setSpawner(ItemStackManager.convertItemStackToEntityType(item));
							EconomyManager.subtract(player, s);
						} else {
							player.sendMessage(Strings.BALANCE_INSUFFICIENT);
							player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 0.5f, 0.5f);
							player.closeInventory();
						}
					} else if(player.getGameMode()==GameMode.CREATIVE || player.hasPermission("magicraft.spawner.priceExempt")) {
						setSpawner(ItemStackManager.convertItemStackToEntityType(item));
					}
				} else {
					player.closeInventory();
					player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 0.5f, 0.5f);
					player.sendMessage(Strings.SPAWNER_SET_TWICE);
				}
			}
		}
	}
}
