package Kakashi.KitPvP.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Kakashi.KitPvP.Sistemas.API;

public class TogglePvP implements CommandExecutor {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("pvp")) {
			if (p.hasPermission("kitpvp.staff")) {
				if (args.length == 0) {
					p.sendMessage(String.valueOf(API.preffix) + "§cEscreva: /pvp (on/off) §2✔");
					return true;
				}
				if (args[0].equalsIgnoreCase("on")) {
					Bukkit.getWorld("world").setPVP(true);
					Bukkit.broadcastMessage(String.valueOf(API.preffix) + "§aPvP Ativado §2✔ ");
				}
				if (args[0].equalsIgnoreCase("off")) {
					Bukkit.getWorld("world").setPVP(false);
					Bukkit.broadcastMessage(String.valueOf(API.preffix) + "§cPvP Desativado §4✗");
				}
			} else {
				p.sendMessage(API.semperm);
			}
		}
		return false;
	}
}
