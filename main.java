package me.tv15dsi.JoinandLeave;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin implements Listener{
	
	public void onEnable() {
		getLogger().info("JoinandLeave loaded!");
		getLogger().info("JoinandLeave created by tv15dsi!");
		PluginManager pm = getServer().getPluginManager();
		getConfig().options().copyDefaults(true);
		pm.registerEvents(this, this);
		saveConfig();
	}
	public void onDisable() {
		getLogger().info("JoinandLeave stopped!");
		getLogger().info("JoinandLeave created by tv15dsi!");
	}
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		return false;
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		Player player = e.getPlayer();
		if(player.hasPlayedBefore() == false) {
			if(getConfig().getString("Newbie Notify") == "true") {
				e.setJoinMessage(ChatColor.WHITE + "[" + ChatColor.GOLD + getConfig().getString("Server Name") + ChatColor.WHITE + "] " + ChatColor.DARK_RED + getConfig().getString("Newbie Message"));
				e.setJoinMessage(ChatColor.WHITE + "[" + ChatColor.GOLD + getConfig().getString("Server Name") + ChatColor.WHITE + "] " + ChatColor.AQUA + getConfig().getString("Join Message").replace("&p", player.getName()));
			} else if(getConfig().getString("Newbie Notify") == "false") {
				e.setJoinMessage(ChatColor.WHITE + "[" + ChatColor.GOLD + getConfig().getString("Server Name") + ChatColor.WHITE + "] " + ChatColor.AQUA + getConfig().getString("Join Message").replace("&p", player.getName()));
			}else {
				e.setJoinMessage(ChatColor.WHITE + "[" + ChatColor.GOLD + getConfig().getString("Server Name") + ChatColor.WHITE + "] " + ChatColor.AQUA + getConfig().getString("Join Message").replace("&p", player.getName()));
				getConfig().set("Newbie Notify", "false");
			}
		}else if(player.hasPlayedBefore() == true) {
			e.setJoinMessage(ChatColor.WHITE + "[" + ChatColor.GOLD + getConfig().getString("Server Name") + ChatColor.WHITE + "] " + ChatColor.AQUA + getConfig().getString("Join Message").replace("&p", player.getName()));
		}
	}
	
	@EventHandler
	public void onPlayerleave(PlayerQuitEvent e) {
		Player player = e.getPlayer();
		e.setQuitMessage(ChatColor.WHITE + "[" + ChatColor.GOLD + getConfig().getString("Server Name") + ChatColor.WHITE + "] " + ChatColor.AQUA + getConfig().getString("Leave Message").replace("&p", player.getName()));
	}
}
