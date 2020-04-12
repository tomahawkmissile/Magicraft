package com.gmail.tomahawkmissile2.magicraft.command;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.gmail.tomahawkmissile2.magicraft.registry.Permissions;
import com.gmail.tomahawkmissile2.magicraft.registry.Strings;
import com.gmail.tomahawkmissile2.magicraft.ui.UI;

import net.md_5.bungee.api.ChatColor;

public class CommandHandler implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(cmd.getName().equalsIgnoreCase("magicraft")) {
				if(com.gmail.tomahawkmissile2.magicraft.command.Command.HELP.isValidCommand(cmd.getName(), args)||
						com.gmail.tomahawkmissile2.magicraft.command.Command.HELP2.isValidCommand(cmd.getName(), args)) {
					if(p.hasPermission(Permissions.HELP) || p.isOp()) {
						this.sendHelp(p);
					} else {
						p.sendMessage(Strings.PERMISSION_ERROR);
						p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 0.5f, 0.5f);
					}
				} else if(com.gmail.tomahawkmissile2.magicraft.command.Command.GUI.isValidCommand(cmd.getName(), args)) {
					if(p.hasPermission(Permissions.GUI_USE) || p.hasPermission(Permissions.GUI_ALL) || p.isOp()) {
						new UI().open(p);
						
					} else {
						p.sendMessage(Strings.PERMISSION_ERROR);
						p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 0.5f, 0.5f);
					}
					
				} else {
					p.sendMessage(Strings.INVALID_ARGS);
				}
				//TODO: add commands
				return true;
			}
		}
		return false;
	}
	public void sendHelp(Player player) {
		if(player.isOp()) {
			player.sendMessage(" ");
			player.sendMessage(ChatColor.DARK_AQUA + "-= Magicraft Help Page =-");
			player.sendMessage(ChatColor.GOLD + "---------------------------");
			player.sendMessage(ChatColor.AQUA + "+ /magicraft : show this page");
			player.sendMessage(ChatColor.BLUE + "+ /magicraft help: also show this page");
			player.sendMessage(ChatColor.AQUA + "+ /magicraft gui: open the gui");
			player.sendMessage(ChatColor.BLUE + "+ /magicraft reload <config | list> : reload or list the configs");
			player.sendMessage(ChatColor.AQUA + "+ /magicraft enchant <enchantment | list> <level> : use the custom enchantments");
			player.sendMessage(ChatColor.BLUE + "+ /magicraft eco give <player> <amount> : pay a player or faction");
			player.sendMessage(ChatColor.AQUA + "+ /magicraft registry <create | delete | add | remove | change> <tag> [newTag]");
			player.sendMessage(" ");
		} else {
			player.sendMessage(" ");
			player.sendMessage(ChatColor.DARK_AQUA + "-= Magicraft Help Page =-");
			player.sendMessage(ChatColor.GOLD + "---------------------------");
			player.sendMessage(ChatColor.AQUA + "+ /magicraft : show this page");
			player.sendMessage(ChatColor.BLUE + "+ /magicraft help: also show this page");
			player.sendMessage(ChatColor.AQUA + "+ /magicraft gui: open the gui");
			player.sendMessage(" ");
		}
	}
}
