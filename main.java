package me.tv15dsi.JoinandLeave;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin implements Listener{
	
	public void onEnable() {
		getLogger().info("JoinandLeave loaded!");
		PluginManager pm = getServer().getPluginManager();
		getConfig().options().copyDefaults(true);
		pm.registerEvents(this, this);
		saveConfig();
	}
	public void onDisable() {
		getLogger().info("JoinandLeave stopped!");
	}
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		return false;
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		Player player = e.getPlayer();
		ChatColor.getByChar("&0").compareTo(ChatColor.BLACK);
		ChatColor.getByChar("&1").compareTo(ChatColor.DARK_BLUE);
		ChatColor.getByChar("&2").compareTo(ChatColor.DARK_GREEN);
		ChatColor.getByChar("&3").compareTo(ChatColor.DARK_AQUA);
		ChatColor.getByChar("&4").compareTo(ChatColor.DARK_RED);
		ChatColor.getByChar("&5").compareTo(ChatColor.DARK_PURPLE);
		ChatColor.getByChar("&6").compareTo(ChatColor.GOLD);
		ChatColor.getByChar("&7").compareTo(ChatColor.GRAY);
		ChatColor.getByChar("&8").compareTo(ChatColor.DARK_GRAY);
		ChatColor.getByChar("&9").compareTo(ChatColor.BLUE);
		ChatColor.getByChar("&a").compareTo(ChatColor.GREEN);
		ChatColor.getByChar("&b").compareTo(ChatColor.AQUA);
		ChatColor.getByChar("&c").compareTo(ChatColor.RED);
		ChatColor.getByChar("&d").compareTo(ChatColor.LIGHT_PURPLE);
		ChatColor.getByChar("&e").compareTo(ChatColor.YELLOW);
		ChatColor.getByChar("&k").compareTo(ChatColor.MAGIC);
		ChatColor.getByChar("&l").compareTo(ChatColor.BOLD);
		ChatColor.getByChar("&m").compareTo(ChatColor.STRIKETHROUGH);
		ChatColor.getByChar("&n").compareTo(ChatColor.UNDERLINE);
		ChatColor.getByChar("&o").compareTo(ChatColor.STRIKETHROUGH);
		ChatColor.getByChar("&r").compareTo(ChatColor.RESET);
		e.setJoinMessage(ChatColor.WHITE + "[" + getConfig().getString("Server Name") + ChatColor.WHITE + "] " + getConfig().getString("Welcome Message").replace("&p", player.getName()));
	}
}
