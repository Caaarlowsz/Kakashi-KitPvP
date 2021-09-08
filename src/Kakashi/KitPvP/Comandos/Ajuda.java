package Kakashi.KitPvP.Comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Ajuda
  implements Listener, CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    Player p = (Player)sender;
    if (cmd.getName().equalsIgnoreCase("ajuda")) {};
    p.sendMessage(" ");
    p.sendMessage("§aInformacoes do Servidor : §4§lKITPVP");
    p.sendMessage("§5§l§m---------------");
    p.sendMessage("§6§l   REGRAS      ");
    p.sendMessage("§7- §4NAO USAR HACK   ");
    p.sendMessage("§7- §4NAO FLOODAR   ");
    p.sendMessage("§7- §4NAO FORJAR ");
    p.sendMessage("§7- §4NAO PEDIR STAFF   ");
    p.sendMessage("§7- §4NAO ABUSAR DE BUGS   ");
    p.sendMessage("§7- §4SEM OFENÇA A STAFF  ");
    p.sendMessage("§7- §4SEM MAU USO DO REPORT   ");
    p.sendMessage("§7- §4NAO FAZER FORM MAIS DE UMA VEZ    ");
    p.sendMessage("§7- §4SEM PEDIR XP/VIPS/KITS   ");
    p.sendMessage("§5§l§m---------------");
    p.sendMessage("§5§lFORMULARIO PARA §d§lTRIAL");
   	p.sendMessage("§7        EM-BREVE"); 
    p.sendMessage("§5§l§m---------------");
    return false;
  }
}

