package Kakashi.KitPvP.Comandos;

import org.bukkit.command.*;
import org.bukkit.entity.*;

import Kakashi.KitPvP.Sistemas.*;

public class Aplicar implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("aplicar")) {
            p.sendMessage(API.MSGAplicar1);
        }
        return false;
    }
}
