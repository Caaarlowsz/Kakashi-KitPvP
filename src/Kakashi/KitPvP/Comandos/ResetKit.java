package Kakashi.KitPvP.Comandos;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;

import com.github.caaarlowsz.kakashimc.kitpvp.KakashiPvP;
import Kakashi.KitPvP.Kits.C4;
import Kakashi.KitPvP.Kits.FlashBack;
import Kakashi.KitPvP.Sistemas.API;
import Kakashi.KitPvP.Sistemas.Cooldown;
import Kakashi.KitPvP.Sistemas.Habilidade;

public class ResetKit implements CommandExecutor {
	public static ArrayList<String> jaresetou;

	static {
		ResetKit.jaresetou = new ArrayList<String>();
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("resetkit")) {
			if (p.hasPermission("kitpvp.resetkit")) {
				if (ResetKit.jaresetou.contains(p.getName())) {
					p.sendMessage(String.valueOf(API.preffix) + "§cEspere um pouco para resetar de kit novamente §2✔");
					return true;
				}
				ResetKit.jaresetou.add(p.getName());
				p.sendMessage(String.valueOf(API.preffix) + "§aVoc\u00ea resetou seu kit §2✔");
				p.teleport(p.getWorld().getSpawnLocation());
				p.getInventory().clear();
				API.ItemServer(p);
				Habilidade.removeAbility(p);
				Cooldown.remove(p);
				p.setHealth(20.0);
				p.setFireTicks(0);
				p.setFoodLevel(20);
				p.setAllowFlight(false);
				p.setFlying(false);
				API.tirarArmadura(p);
				FlashBack.salvarinv.remove(p.getName());
				FlashBack.salvarlocal.remove(p.getName());
				p.setGameMode(GameMode.SURVIVAL);
				if (C4.bomba.containsKey(p.getName())) {
					final Item item = C4.bomba.get(p.getName());
					item.remove();
				}
				Bukkit.getScheduler().scheduleSyncDelayedTask(KakashiPvP.plugin, (Runnable) new Runnable() {
					@Override
					public void run() {
						ResetKit.jaresetou.remove(p.getName());
						p.sendMessage(
								String.valueOf(API.preffix) + "§aJ\u00e1 pode resetar seu kit novamente §7[§4§l!§7]");
					}
				}, 100L);
				return true;
			} else {
				p.sendMessage(API.semperm);
			}
		}
		return false;
	}
}
