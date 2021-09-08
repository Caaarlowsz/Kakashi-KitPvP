package Kakashi.KitPvP.Comandos;

import org.bukkit.command.*;
import org.bukkit.entity.*;

import Kakashi.KitPvP.Sistemas.*;

import org.bukkit.*;

public class Status implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (!cmd.getName().equalsIgnoreCase("status")) {
            return false;
        }
        if (args.length == 0) {
            p.sendMessage("§7Seus Status:");
            p.sendMessage("§4        ");
            p.sendMessage("§4Rank: " + KillsDeathsRankXp.getRank(p));
            p.sendMessage("§4Xp: §5" + KillsDeathsRankXp.getXp(p));
            p.sendMessage("§4Kills: §5" + KillsDeathsRankXp.getKills(p));
            p.sendMessage("§4Deaths: §5" + KillsDeathsRankXp.getDeaths(p));
            return true;
        }
        final Player t = Bukkit.getPlayer(args[0]);
        if (t == null) {
            p.sendMessage(API.jogadoroff);
            return true;
        }
        p.sendMessage("§7Status De: §c" + t.getDisplayName());
        p.sendMessage("§4        ");
        p.sendMessage("§4Rank: " + KillsDeathsRankXp.getRank(t));
        p.sendMessage("§4Xp: §5" + KillsDeathsRankXp.getXp(t));
        p.sendMessage("§4Kills: §5" + KillsDeathsRankXp.getKills(t));
        p.sendMessage("§4Deaths: §5" + KillsDeathsRankXp.getDeaths(t));
        return true;
    }
}
