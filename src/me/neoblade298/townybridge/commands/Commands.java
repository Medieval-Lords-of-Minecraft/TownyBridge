package me.neoblade298.townybridge.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.neoblade298.neocore.bukkit.util.BukkitUtil;


public class Commands implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lbl, String[] args) {
		BukkitUtil.msg(sender, "&cYou're not on the Towny server! Type /hub to return to server selector!");
		return true;
	}
}
