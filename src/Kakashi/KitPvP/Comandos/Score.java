package Kakashi.KitPvP.Comandos;

import java.util.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;

import Kakashi.KitPvP.ScoreBoard.*;
import Kakashi.KitPvP.Sistemas.*;

public class Score extends ScoreBoard implements CommandExecutor
{
    public static ArrayList<String> temscore;
    public static ArrayList<String> ntemscore;
    
    static {
        Score.temscore = new ArrayList<String>();
        Score.ntemscore = new ArrayList<String>();
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("score")) {
            if (!Score.ntemscore.contains(p.getName())) {
                Score.ntemscore.add(p.getName());
                Score.temscore.remove(p.getName());
                p.sendMessage(String.valueOf(API.preffix) + "§a Score Adicionada §2✔");
            }
            else {
                Score.temscore.add(p.getName());
                Score.ntemscore.remove(p.getName());
                p.sendMessage(String.valueOf(API.preffix) + "§c Score Removida §4✗");
            }
        }
        return false;
    }
}
