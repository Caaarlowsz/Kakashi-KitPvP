package Kakashi.KitPvP.Comandos;

import org.bukkit.command.*;
import org.bukkit.entity.*;

import Kakashi.KitPvP.Sistemas.*;

import org.bukkit.*;

public class Gamemode implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (cmd.getName().equalsIgnoreCase("gm") || cmd.getName().equalsIgnoreCase("gamemode")) {
            if (sender instanceof ConsoleCommandSender) {
                System.out.println(API.semconsole);
                return true;
            }
            final Player p = (Player)sender;
            if (args.length == 0) {
                p.sendMessage(String.valueOf(API.preffix) + "§cEscreva: /gm,gamemode 0 | 1 §2✔");
            }
            else if (args.length == 1) {
                if (p.hasPermission("kitpvp.gm") || p.isOp()) {
                    if (args[0].equalsIgnoreCase("1") || args[0].equalsIgnoreCase("criativo")) {
                        p.setGameMode(GameMode.CREATIVE);
                        p.sendMessage(String.valueOf(API.preffix) + "§4Voce Entrou No Modo §eCriativo §2✔");
                    }
                    else if (args[0].equalsIgnoreCase("0") || args[0].equalsIgnoreCase("sobrevivencia")) {
                        p.setGameMode(GameMode.SURVIVAL);
                        p.sendMessage(String.valueOf(API.preffix) + "§4Voce Entrou No Modo §cSobrebivencia §2✔");
                    }
                    else if (args[0].equalsIgnoreCase("2") || args[0].equalsIgnoreCase("aventura")) {
                        p.setGameMode(GameMode.ADVENTURE);
                        p.sendMessage(String.valueOf(API.preffix) + "§4Voce Entrou No Modo §aAventura §2✔");
                    }
                    else {
                        p.sendMessage(API.jogadoroff);
                    }
                }
                else {
                    p.sendMessage(API.semperm);
                }
            }
        }
        return false;
    }
}
