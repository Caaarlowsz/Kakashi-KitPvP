package Kakashi.KitPvP.Comandos;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import Kakashi.KitPvP.Main;
import Kakashi.KitPvP.Sistemas.API;

public class ClickTest implements CommandExecutor, Listener {
	public static ArrayList<String> emclicktest;
	public static ArrayList<String> fazendoclicktest;

	static {
		ClickTest.emclicktest = new ArrayList<String>();
		ClickTest.fazendoclicktest = new ArrayList<String>();
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (!(sender instanceof Player)) {
			p.sendMessage(API.semconsole);
			return true;
		}
		if (cmd.getName().equalsIgnoreCase("clicktest")) {
			if (ClickTest.fazendoclicktest.contains(p.getName())) {
				p.sendMessage(String.valueOf(API.preffix) + "§cVoc\u00ea j\u00e1 esta em clicktest §4✗ ");
				return true;
			}
			ClickTest.fazendoclicktest.add(p.getName());
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					p.sendMessage(String.valueOf(API.preffix) + "§7ClickTest iniciando em §4§l5§7s");
				}
			}, 0L);
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					p.sendMessage(String.valueOf(API.preffix) + "§7ClickTest iniciando em §4§l4§7s");
				}
			}, 20L);
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					p.sendMessage(String.valueOf(API.preffix) + "§7ClickTest iniciando em §4§l3§7s");
				}
			}, 40L);
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					p.sendMessage(String.valueOf(API.preffix) + "§7ClickTest iniciando em §4§l2§7s");
				}
			}, 60L);
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					p.sendMessage(String.valueOf(API.preffix) + "§7ClickTest iniciando em §4§l1§7s");
				}
			}, 80L);
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					p.sendMessage(String.valueOf(API.preffix) + "§7ClickTest iniciado");
					ClickTest.emclicktest.add(p.getName());
				}
			}, 100L);
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					if (p.getLevel() >= 200) {
						Bukkit.broadcast("§4§l" + p.getDisplayName()
								+ " §7Pode estar de macro quantidade de clicks no clicktest: §4§l" + p.getLevel(),
								"flame.staff");
						ClickTest.emclicktest.remove(p.getName());
						ClickTest.fazendoclicktest.remove(p.getName());
					}
					p.sendMessage(String.valueOf(API.preffix) + "§7ClickTest acabado quantidade de clicks §4§lABAIXO");
					p.sendMessage(String.valueOf(API.preffix) + "§7Quantidade de click(s) dado: §4§l" + p.getLevel());
					ClickTest.emclicktest.remove(p.getName());
					ClickTest.fazendoclicktest.remove(p.getName());
					p.setLevel(0);
				}
			}, 250L);
		}
		return false;
	}

	@EventHandler
	public void comandos(final PlayerCommandPreprocessEvent e) {
		final Player p = e.getPlayer();
		if (ClickTest.emclicktest.contains(p.getName()) && e.getMessage().startsWith("/")) {
			e.setCancelled(true);
			p.sendMessage(String.valueOf(API.preffix)
					+ "§7Voc\u00ea n\u00e3o pode digitar comandos quando estiver fazendo clicktest §4✗");
		}
	}

	@EventHandler
	public void click(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (ClickTest.emclicktest.contains(p.getName()) && e.getAction() == Action.LEFT_CLICK_AIR) {
			p.setLevel(p.getLevel() + 1);
		}
	}
}
