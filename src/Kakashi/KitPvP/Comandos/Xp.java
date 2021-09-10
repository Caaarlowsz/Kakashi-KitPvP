package Kakashi.KitPvP.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Kakashi.KitPvP.Sistemas.API;
import Kakashi.KitPvP.Sistemas.KillsDeathsRankXp;

public class Xp implements CommandExecutor {
	public static String simbonaosuavel;
	public static String sonumeros;
	public static String naousar;
	public static String semquantia;
	public static String sintaxedar;
	public static String sintaxedoar;

	static {
		Xp.simbonaosuavel = String.valueOf(API.preffix) + "§cSimbolo nao usavel §4✗";
		Xp.sonumeros = String.valueOf(API.preffix) + "§cSo e possivel usar numeros §4✗";
		Xp.naousar = String.valueOf(API.preffix) + "§cNao pode usar nome como doacao §4✗";
		Xp.semquantia = String.valueOf(API.preffix)
				+ "§cVoc\u00ea nao tem a quantia suficiente de xp que quer doar §4✗";
		Xp.sintaxedar = String.valueOf(API.preffix) + "§cEscreva: /xp dar <nome> <quantidade> §2✔";
		Xp.sintaxedoar = String.valueOf(API.preffix) + "§cEscreva: /xp doar <nome> <quantidade> §2✔";
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {

		if (label.equalsIgnoreCase("xp")) {
			if (args.length == 0) {

				if (sender instanceof Player) {
					Player p = (Player) sender;
					sender.sendMessage(String.valueOf(API.preffix) + "§7Xp: §4" + KillsDeathsRankXp.getXp(p));
				} else {
					sender.sendMessage(Xp.sintaxedar);
					sender.sendMessage(Xp.sintaxedoar);
				}
			}
			if (args.length == 1) {
				if (sender.hasPermission("flame.darxp")) {
					sender.sendMessage(Xp.sintaxedar);
				}
				sender.sendMessage(Xp.sintaxedoar);
				return true;
			}
			if (args.length == 2) {
				if (args[0].equalsIgnoreCase("dar")) {
					if (sender.hasPermission("flame.darxp")) {
						sender.sendMessage(Xp.sintaxedar);
					}
				} else if (args[0].equalsIgnoreCase("doar")) {
					sender.sendMessage(Xp.sintaxedoar);
				} else {
					if (sender.hasPermission("flame.darxp")) {
						sender.sendMessage(Xp.sintaxedar);
					}
					sender.sendMessage(Xp.sintaxedoar);
				}
				return true;
			}
			if (args.length == 3) {
				if (args[0].equalsIgnoreCase("dar")) {
					if (sender.hasPermission("flame.darxp")) {
						try {
							final int xp = Integer.valueOf(args[2]);
							final Player t = Bukkit.getPlayerExact(args[1]);
							if (t != null) {
								if (args[2].contains("-")) {
									sender.sendMessage(Xp.simbonaosuavel);
									return true;
								}
								KillsDeathsRankXp.adicionarXp(t, xp);
								sender.sendMessage(String.valueOf(API.preffix) + "§7Voc\u00ea deu §4" + xp
										+ "§7 Xp para o(a) §4" + t.getDisplayName());
								t.sendMessage(
										String.valueOf(API.preffix) + "§7Um(Uma) staffer te deu §4" + xp + " §7Xp");
							} else {
								sender.sendMessage(API.jogadoroff);
							}
						} catch (Exception e) {
							sender.sendMessage(Xp.sonumeros);
						}
					}
				} else if (args[0].equalsIgnoreCase("doar")) {
					try {
						final int xp = Integer.valueOf(args[2]);
						final Player t = Bukkit.getPlayerExact(args[1]);
						if (t != null) {
							if (args[2].contains("-")) {
								sender.sendMessage(Xp.simbonaosuavel);
								return true;
							}
							Player p = (Player) sender;
							if (KillsDeathsRankXp.getXp(p) >= xp) {
								KillsDeathsRankXp.adicionarXp(t, xp);
								KillsDeathsRankXp.removerXp(p, xp);
								t.sendMessage(String.valueOf(API.preffix) + "§7O(A) §e" + sender.getName()
										+ " §7te deu §4" + xp + " §7Xp");
								sender.sendMessage(String.valueOf(API.preffix) + "§7Voc\u00ea deu §4" + xp
										+ " §7Xp para o(a) §e" + t.getDisplayName());
							} else {
								sender.sendMessage(Xp.semquantia);
							}
						} else {
							sender.sendMessage(API.jogadoroff);
						}
					} catch (Exception e) {
						sender.sendMessage(Xp.sonumeros);
					}
				} else {
					if (sender.hasPermission("flame.darxp")) {
						sender.sendMessage(Xp.sintaxedar);
					}
					sender.sendMessage(Xp.sintaxedoar);
				}
				return true;
			}
			if (sender.hasPermission("flame.darxp")) {
				sender.sendMessage(Xp.sintaxedar);
			}
			sender.sendMessage(Xp.sintaxedoar);
		}
		return false;
	}
}
