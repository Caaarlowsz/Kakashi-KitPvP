package Kakashi.KitPvP.Comandos;

import java.util.*;
import org.bukkit.event.player.*;

import Kakashi.KitPvP.Sistemas.*;

import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.command.*;

public class StaffChat implements Listener, CommandExecutor
{
    public static ArrayList<String> staff;
    
    static {
        StaffChat.staff = new ArrayList<String>();
    }
    
    @SuppressWarnings("deprecation")
	@EventHandler
    public void onChat(final PlayerChatEvent e) {
        final Player p = e.getPlayer();
        if (this.isStaffChatting(p)) {
            Bukkit.broadcast(ChatColor.GRAY + "[§cStaff" + ChatColor.GRAY + "]§9 " + p.getDisplayName() + "§4 \u27a1 " + "§f" + e.getMessage().replaceAll("&", "§"), "kitpvp.staff");
            e.setCancelled(true);
        }
    }
    
    @SuppressWarnings("deprecation")
	public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }
        final Player p = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("sc")) {
            if (p.hasPermission("kitpvp.staff")) {
                if (this.isStaffChatting(p)) {
                    StaffChat.staff.remove(p.getName());
                    p.sendMessage(ChatColor.RED + "Voc\u00ea saiu do chat da staff. §4✗");
                    Player[] onlinePlayers;
                    for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
                        final Player online = onlinePlayers[i];
                        if (this.isStaffChatting(p) && (online.hasPermission("kitpvp.staff") || this.isStaffChatting(online))) {
                            online.sendMessage(ChatColor.GRAY + "[§cStaff" + ChatColor.GRAY + "]§9 O Jogador: " + p.getDisplayName() + " §cSaiu no Chat da Staff");
                        }
                    }
                }
                else {
                    StaffChat.staff.add(p.getName());
                    p.sendMessage(ChatColor.GREEN + "Voc\u00ea entrou no chat da staff. §2✔");
                    Player[] onlinePlayers2;
                    for (int length2 = (onlinePlayers2 = Bukkit.getOnlinePlayers()).length, j = 0; j < length2; ++j) {
                        final Player online = onlinePlayers2[j];
                        if (this.isStaffChatting(p) && (online.hasPermission("kitpvp.staff") || this.isStaffChatting(online))) {
                            online.sendMessage(ChatColor.GRAY + "[§cStaff" + ChatColor.GRAY + "]§9 O Jogador: " + p.getDisplayName() + " §4Entrou no Chat da Staff");
                        }
                    }
                }
            }
            else {
                p.sendMessage(API.semperm);
            }
        }
        return true;
    }
    
    public boolean isStaffChatting(final Player player) {
        return StaffChat.staff.contains(player.getName());
    }
}