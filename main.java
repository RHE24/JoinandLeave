package me.tv15dsi.JoinandLeave;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin {
	
	public void onEnable() {
		getLogger().info("JoinandLeave loaded!");
	}
	public void onDisable() {
		getLogger().info("JoinandLeave stopped!");
	}
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		
		return false;
	}
}
