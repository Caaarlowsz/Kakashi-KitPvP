package Kakashi.KitPvP.Comandos;

import org.bukkit.command.*;
import org.bukkit.entity.*;

import Kakashi.KitPvP.Sistemas.*;

public class Youtuber implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("youtuber")) {
            p.sendMessage(API.MSGYoutuber1);
            p.sendMessage(API.MSGYoutuber2);
            p.sendMessage(API.MSGYoutuber3);
        }
        return false;
    }
}
