package me.neoblade298.townybridge;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import me.neoblade298.neocore.NeoCore;
import me.neoblade298.neocore.instancing.InstanceType;
import me.neoblade298.townybridge.commands.Commands;
import me.neoblade298.townybridge.other.InstanceListener;
import me.neoblade298.townybridge.towny.TownyListener;

public class TownyBridge extends JavaPlugin implements Listener {
	private static TownyBridge inst;
	public static final int CHAT_TIMEOUT = 10000; // How long in ms before a cross-server chat expires
	
	public void onEnable() {
		inst = this;
		
		Bukkit.getServer().getLogger().info("TownyChatBridge Enabled");
		Bukkit.getPluginManager().registerEvents(this, this);
		// initCommands();
		
		if (NeoCore.getInstanceType() == InstanceType.TOWNY) {
			Bukkit.getPluginManager().registerEvents(new TownyListener(), this);
		}
		else {
			Bukkit.getPluginManager().registerEvents(new InstanceListener(), this);
			initCommands();
		}
		
	}
	
	public void onDisable() {
	    org.bukkit.Bukkit.getServer().getLogger().info("TownyChatBridge Disabled");
	    super.onDisable();
	}
	
	private void initCommands() {
		Commands cmds = new Commands();
	    this.getCommand("towny").setExecutor(cmds);
	    this.getCommand("town").setExecutor(cmds);
	    this.getCommand("nation").setExecutor(cmds);
	}
	
	public static TownyBridge inst() {
		return inst;
	}
}
