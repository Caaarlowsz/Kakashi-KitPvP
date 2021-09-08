package Kakashi.KitPvP.Comandos;

import java.util.*;
import org.bukkit.entity.*;

import Kakashi.KitPvP.Sistemas.*;

import org.bukkit.command.*;
import org.bukkit.*;

public class Ver implements CommandExecutor
{
    public static ArrayList<Player> emver;
    
    static {
        Ver.emver = new ArrayList<Player>();
    }
    
    public static boolean emInvisivel(final Player p) {
        return Ver.emver.contains(p);
    }
    
    public static void addInvisivel(final Player p) {
        Ver.emver.add(p);
    }
    
    public static void removerInvisivel(final Player p) {
        Ver.emver.remove(p);
    }
    
    @SuppressWarnings("deprecation")
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }
        final Player p = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("vis")) {
            if (p.hasPermission("kitpvp.staff")) {
                if (!emInvisivel(p)) {
                    addInvisivel(p);
                    p.sendMessage("§aVoc\u00ea ficou invisivel para todos os players §2✔");
                    p.setGameMode(GameMode.CREATIVE);
                    Player[] onlinePlayers;
                    for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
                        final Player todos = onlinePlayers[i];
                        todos.hidePlayer(p);
                    }
                }
                else {
                    removerInvisivel(p);
                    Player[] onlinePlayers2;
                    for (int length2 = (onlinePlayers2 = Bukkit.getOnlinePlayers()).length, j = 0; j < length2; ++j) {
                        final Player todos = onlinePlayers2[j];
                        todos.showPlayer(p);
                    }
                    p.setGameMode(GameMode.SURVIVAL);
                    p.sendMessage("§cVoc\u00ea ficou visivel para todos os players §2✔");
                }
            }
            else {
                p.sendMessage(API.semperm);
            }
        }
        return false;
    }
}
