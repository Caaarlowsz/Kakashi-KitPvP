package Kakashi.KitPvP.Comandos;

import java.util.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;

import Kakashi.KitPvP.*;
import Kakashi.KitPvP.Sistemas.*;

import org.bukkit.*;

public class ClearChat implements CommandExecutor
{
    public static ArrayList<String> emcc;
    
    static {
        ClearChat.emcc = new ArrayList<String>();
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }
        final Player p = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("cc")) {
            if (p.hasPermission("kitpvp.staff")) {
                if (ClearChat.emcc.contains(p.getName())) {
                    p.sendMessage(String.valueOf(API.preffix) + "§cEspere para limpar o chat novamente §2✔");
                    return true;
                }
                for (int i = 0; i < 100; ++i) {
                    Bukkit.broadcastMessage(" ");
                }
                Bukkit.broadcastMessage("§e§lO CHAT FOI LIMPO §2✔");
                Bukkit.broadcast("§b" + p.getDisplayName() + " §7Limpou o chat", "kitpvp.clearchat");
                p.sendMessage(String.valueOf(API.preffix) + "§aVoc\u00ea limpou o chat §2✔");
                ClearChat.emcc.add(p.getName());
                Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
                    @Override
                    public void run() {
                        ClearChat.emcc.remove(p.getName());
                        p.sendMessage(String.valueOf(API.preffix) + "§aJ\u00e1 pode limpar o chat novamente §2✔");
                    }
                }, 140L);
            }
            else {
                p.sendMessage(API.semperm);
            }
        }
        return false;
    }
}
