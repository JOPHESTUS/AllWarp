package us.jophest.allwarp;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class AllWarp extends JavaPlugin {
	Logger log = Logger.getLogger("Minecraft");
	PluginDescriptionFile pdfFile;
	public static AllWarp plugin;

	public void onEnable() {

	}

	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		// TODO Auto-generated method stub

		if (command.getName().equalsIgnoreCase("warpall")) {
			if (sender.hasPermission("warp.all")) {
				for (Player plr : Bukkit.getServer().getOnlinePlayers())
					if (!plr.hasPermission("warpall.excluded")){
						plr.performCommand("warp " + args[0]);
					}
				sender.sendMessage(ChatColor.GREEN + "Warped all players to " + args[0]);
				return true;
			}
		}
				

		return super.onCommand(sender, command, label, args);

	}

	public void onDisable() {

		pdfFile = this.getDescription();
		this.log.info(pdfFile.getName() + " is now disabled!");
	}
}