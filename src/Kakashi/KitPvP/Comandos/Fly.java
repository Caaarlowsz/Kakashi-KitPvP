package Kakashi.KitPvP.Comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Kakashi.KitPvP.Sistemas.API;

public class Fly implements CommandExecutor {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("fly")) {
			if (p.hasPermission("kitpvp.fly")) {
				if (args.length == 0) {
					if (!p.getAllowFlight()) {
						p.setAllowFlight(true);
						p.setFlying(true);
						p.sendMessage(String.valueOf(API.preffix) + "§aVoc\u00ea ativou seu fly §2✔");
					} else {
						p.setAllowFlight(false);
						p.setFlying(false);
						p.sendMessage(String.valueOf(API.preffix) + "§cVoc\u00ea desativou seu fly §4✗");
					}
				} else {
					final Player target = p.getServer().getPlayer(args[0]);
					if (target != null) {
						if (!target.getAllowFlight()) {
							target.setAllowFlight(true);
							target.setFlying(true);
							target.sendMessage(String.valueOf(API.preffix) + "§4O(A) jogador(a): §c"
									+ p.getDisplayName() + " §4ativou seu fly");
							p.sendMessage(String.valueOf(API.preffix) + "§4Voc\u00ea ativou o fly de: §c"
									+ target.getDisplayName());
						} else {
							target.setAllowFlight(false);
							target.setAllowFlight(false);
							target.setFlying(false);
							target.sendMessage(String.valueOf(API.preffix) + "§4O(A) jogador(a): §c"
									+ p.getDisplayName() + " §4desativou seu fly");
							p.sendMessage(String.valueOf(API.preffix) + "§4Voc\u00ea desativou o fly de: §c"
									+ target.getDisplayName());
						}
					} else {
						p.sendMessage(API.jogadoroff);
					}
				}
			} else {
				p.sendMessage(API.semperm);
			}
		}
		return false;
	}
}
