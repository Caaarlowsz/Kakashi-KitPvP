package Kakashi.KitPvP.ScoreBoard;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;

import Kakashi.KitPvP.Sistemas.API;
import Kakashi.KitPvP.Sistemas.KillsDeathsRankXp;

public class ScoreBoard
{
    @SuppressWarnings("deprecation")
	public static void KitPvPScore(final Player p) {
        final String jogadoronline = String.valueOf(Bukkit.getServer().getOnlinePlayers().length) + "§7/§7" + Bukkit.getServer().getMaxPlayers();
        final SimpleScoreboard ftw = new SimpleScoreboard(API.NomeServer);
        ftw.addLinha("§3 ", 13);
        ftw.addLinha("§4➜ §cMatou: §7" + KillsDeathsRankXp.getKills(p), 12);
        ftw.addLinha("§4➜ §cMorreu: §7" + KillsDeathsRankXp.getDeaths(p), 11);
        ftw.addLinha("§7 ", 5);
        ftw.addLinha("§4➜ §cKit: §a" + API.getKit(p), 8);
        ftw.addLinha("§4➜ §cCoins: §7" + KillsDeathsRankXp.getXp(p), 3);
        ftw.addLinha("§4➜ §cJogadores: §7" + jogadoronline, 10);
        ftw.addLinha("§f ", 1);
        ftw.addLinha("§7/score", 0);
        
      
        ftw.setScoreboard(p);
        final Objective o = ftw.getScoreboard().registerNewObjective("health", "health");
        o.setDisplayName(ChatColor.GREEN + "\u2764");
        o.setDisplaySlot(DisplaySlot.BELOW_NAME);
    }
}
