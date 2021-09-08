package Kakashi.KitPvP.Sistemas;

import org.bukkit.event.*;
import java.util.*;
import org.bukkit.entity.*;
import org.bukkit.*;

public class AdminVanish implements Listener
{
    public static ArrayList<Player> vanished;
    
    static {
        AdminVanish.vanished = new ArrayList<Player>();
    }
    
    @SuppressWarnings("deprecation")
	public static void makeVanished(final Player p) {
        Player[] onlinePlayers;
        for (int length = (onlinePlayers = Bukkit.getServer().getOnlinePlayers()).length, i = 0; i < length; ++i) {
            final Player player = onlinePlayers[i];
            if (!player.getName().equals(p.getName())) {
                player.hidePlayer(p);
            }
        }
        if (!AdminVanish.vanished.contains(p)) {
            AdminVanish.vanished.add(p);
        }
    }
    
    public static boolean isVanished(final Player p) {
        return AdminVanish.vanished.contains(p);
    }
    
    @SuppressWarnings("deprecation")
	public static void updateVanished() {
        Player[] onlinePlayers;
        for (int length = (onlinePlayers = Bukkit.getServer().getOnlinePlayers()).length, i = 0; i < length; ++i) {
            final Player p = onlinePlayers[i];
            if (isVanished(p)) {
                makeVanished(p);
            }
            else {
                makeVisible(p);
            }
        }
    }
    
    @SuppressWarnings("deprecation")
	public static void makeVisible(final Player p) {
        Player[] onlinePlayers;
        for (int length = (onlinePlayers = Bukkit.getServer().getOnlinePlayers()).length, i = 0; i < length; ++i) {
            final Player player = onlinePlayers[i];
            player.showPlayer(p);
        }
        if (AdminVanish.vanished.contains(p)) {
            AdminVanish.vanished.remove(p);
        }
    }
}