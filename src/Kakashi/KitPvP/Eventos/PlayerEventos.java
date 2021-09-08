package Kakashi.KitPvP.Eventos;

import org.bukkit.entity.*;
import org.bukkit.event.player.*;
import org.bukkit.*;
import org.bukkit.event.*;
import org.bukkit.event.server.*;

import Kakashi.KitPvP.Comandos.*;
import Kakashi.KitPvP.Sistemas.*;

public class PlayerEventos implements Listener
{
    @EventHandler
    public void onEntrar(final PlayerJoinEvent e) {
        final Player p = e.getPlayer();
        e.setJoinMessage("§7[§2+§7] §a" + p.getDisplayName());
        p.getInventory().clear();
        API.ItemServer(p);
        p.setHealth(20.0);
        p.setFireTicks(0);
        API.tirarArmadura(p);
        Habilidade.removeAbility(p);
        p.setFoodLevel(20);
        p.teleport(p.getWorld().getSpawnLocation());
        p.setGameMode(GameMode.SURVIVAL);
        Score.ntemscore.add(p.getName());
        p.sendMessage("§7BemVindo Ao: " + API.NomeServer);
        p.chat("/tag normal");
    }
    
    @EventHandler
    public void onSair(final PlayerQuitEvent e) {
        final Player p = e.getPlayer();
        e.setQuitMessage("§7[§4-§7] §c" + p.getDisplayName());
    }
    
    @EventHandler
    public void onCheio(final PlayerLoginEvent event) {
        final Player p = event.getPlayer();
        if (event.getResult() == PlayerLoginEvent.Result.KICK_FULL) {
            if (p.hasPermission("kitpvp.vip")) {
                event.setResult(PlayerLoginEvent.Result.ALLOWED);
            }
            else {
                event.setKickMessage("§cO Servidor Esta Cheio §4✗");
            }
        }
        else if (event.getResult() == PlayerLoginEvent.Result.KICK_WHITELIST) {
            event.setKickMessage("§cEstamos Em Manuten\u00e7\u00e3o! §4Para Sua Melhor Jogabilidade\n§cPorFavor Volte Mais Tarde");
        }
    }
    
    @EventHandler
    public void onRespawn(final PlayerRespawnEvent e) {
        final Player p = e.getPlayer();
        p.getInventory().clear();
        API.ItemServer(p);
        p.setHealth(20.0);
        p.setFireTicks(0);
        p.setFoodLevel(20);
        API.tirarArmadura(p);
        p.teleport(p.getWorld().getSpawnLocation());
        p.updateInventory();
        p.sendMessage("§7Voc\u00ea voltou para o spawn §2✔");
        Habilidade.removeAbility(p);
        API.tirarEfeitos(p);
    }
    
    
    
    @SuppressWarnings("deprecation")
	@EventHandler(priority = EventPriority.NORMAL)
    public void onColorandChangeChat(final PlayerChatEvent e) {
        final Player p = e.getPlayer();
        if(e.getMessage().equalsIgnoreCase("server lixo") || e.getMessage().equalsIgnoreCase("servidor lixo")){
        	e.setMessage("Amei esse servidor é o melhor do mundo <3");
        }
        
        if(e.getMessage().equalsIgnoreCase("sou hack")){
        	e.setMessage("Sou Um Lixo E Uso Hack Me Bani");
        }
        
        if(e.getMessage().contains(" ez ") || e.getMessage().contains(" iz ")){
        	e.setCancelled(true);
        	p.sendMessage("§cPor Favor Não Diga Isso! '<ez, iz>' ");
        }
        
        if (!p.hasPermission("kitpvp.chat")) {
            e.setFormat("§7(" + ChatColor.RESET + KillsDeathsRankXp.getRankPequeno(p) + "§7)" + ChatColor.RESET + "§7" + p.getDisplayName() + " §➡ §f " + e.getMessage());
        
            if(e.getMessage().contains(".net") || e.getMessage().contains(".com") || e.getMessage().contains(".com.br") || e.getMessage().contains(".pro") || e.getMessage().contains(".nu") || e.getMessage().contains(".tk")){
            	e.setCancelled(true);
            	p.sendMessage("§cVocê não pode divulgar IP´s nesse servidor §4✗");
            	p.sendMessage("§cVocê foi reportado a um staff §2✔ Nao Desloga...");
            	Bukkit.broadcast("§7" + p.getName() + " §4§lEsta Divulgando IP´s Mute-o §7[§4§l!§7]", "kitpvp.staff");
            }
            
        }
        else {
            e.setFormat(p.getDisplayName() + " §4➡ §f " + e.getMessage().replaceAll("&", "§"));
        
        
        }
        
     
        
    }
    
    @EventHandler
    private void onCommand(PlayerCommandPreprocessEvent e){
    	Player p = e.getPlayer();
    	
    	if(e.getMessage().contains("/me")){
    		if(p.hasPermission("kitpvp.staff")){
        		e.setCancelled(false);
        	}else{
        		p.sendMessage("§cVocê não tem permissão para usar esse comando §4✗");
        		e.setCancelled(true);
        	}
    		
    	}
    	
    }
    
    
    @EventHandler
    public void onMotd(final ServerListPingEvent e) {
        e.setMotd(String.valueOf(API.Motd) + "\n" + API.StatusMotd);
        e.setMaxPlayers(60);
    }
}
