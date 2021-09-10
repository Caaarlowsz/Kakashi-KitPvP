package Kakashi.KitPvP.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import Kakashi.KitPvP.Sistemas.API;

public class Tp implements CommandExecutor {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		if (!(sender instanceof Player)) {
			return true;
		}
		final Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("tp")) {
			if (p.hasPermission("kitpvp.tp")) {
				final Player t = Bukkit.getPlayer(args[0]);
				if (t == null) {
					p.sendMessage(API.jogadoroff);
					return true;
				}
				p.teleport((Entity) t);
				p.sendMessage(String.valueOf(API.preffix) + "§7Voc\u00ea se teleportou para: §c" + t.getName());
			} else {
				p.sendMessage(API.semperm);
			}
		}
		if (cmd.getName().equalsIgnoreCase("tphere")) {
			if (p.hasPermission("kitpvp.tp")) {
				if (args.length == 0) {
					p.sendMessage(String.valueOf(API.preffix) + "§7Escreva: /tp here <player> §2✔");
					return true;
				}
				final Player t = Bukkit.getPlayer(args[0]);
				if (t == null) {
					p.sendMessage(API.jogadoroff);
					return true;
				}
				t.teleport((Entity) p);
				p.sendMessage(String.valueOf(API.preffix) + "§7Voc\u00ea puxou: §c" + t.getName());
			} else {
				p.sendMessage(API.semperm);
			}
		}
		if (cmd.getName().equalsIgnoreCase("tpall")) {
			if (p.hasPermission("kitpvp.tp")) {
				Player[] onlinePlayers;
				for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
					final Player todos = onlinePlayers[i];
					todos.teleport((Entity) p);
				}
				p.sendMessage(String.valueOf(API.preffix) + "§7Voc\u00ea puxou todos os players para voc\u00ea §2✔");
				Bukkit.broadcastMessage("§c§lTodos Os Players Foram Puxados §7[§4§l!§7]");
			} else {
				p.sendMessage(API.semperm);
			}
		}
		return false;
	}
}
