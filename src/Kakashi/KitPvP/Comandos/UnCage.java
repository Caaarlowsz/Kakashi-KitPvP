package Kakashi.KitPvP.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class UnCage implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		Player t = Bukkit.getPlayer(args[0]);
		
		if(cmd.getName().equalsIgnoreCase("uncage")){
			if(p.hasPermission("flame.staff")){
				
				if(args.length == 1){
					Admin.hacks.remove(t.getName());
					p.sendMessage("§cVocê liberou o jogador: " + t.getName());
					t.sendMessage("§4O Staff: §f" + p.getName()+ " §2Liberou Você §7[§4§l!§7]");
				 
				}else{
					p.sendMessage("§cEscreva: /uncage <jogador> §2✔");
				}
			
				
			}else{
				p.sendMessage("§cVocê não tem permissão para usar esse comando §4✗");
			}
		}
		
		return false;
	}
	
	
	
	

}
