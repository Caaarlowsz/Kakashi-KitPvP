package Kakashi.KitPvP.Eventos;

import org.bukkit.event.player.*;

import Kakashi.KitPvP.Sistemas.*;

import org.bukkit.*;
import org.bukkit.event.block.*;
import org.bukkit.entity.*;
import java.util.*;
import org.bukkit.event.*;

public class Bussola implements Listener
{
    @EventHandler
    public void onCompass(final PlayerInteractEvent event) {
        final Player p = event.getPlayer();
        if (Habilidade.getAbility(p) != "Nenhum" && p.getItemInHand().getType() == Material.COMPASS && (event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR)) {
            Boolean pesquisado = false;
            for (int i = 0; i < 1000; ++i) {
                final List<Entity> pertos = (List<Entity>)p.getNearbyEntities((double)i, 128.0, (double)i);
                for (final Object e : pertos) {
                    if (((Entity)e).getType().equals((Object)EntityType.PLAYER) && p.getLocation().distance(((Entity)e).getLocation()) > 0.0) {
                        p.setCompassTarget(((Entity)e).getLocation());
                        p.sendMessage(String.valueOf(API.preffix) + "§fBussola apontando para: §4" + ((Player)e).getName());
                        pesquisado = true;
                        break;
                    }
                }
                if (pesquisado) {
                    break;
                }
            }
            if (!pesquisado) {
                p.sendMessage(String.valueOf(API.preffix) + "§cNenhum jogador encontrado bussola apontando para o spawn§4✗");
                p.setCompassTarget(p.getWorld().getSpawnLocation());
            }
        }
    }
}
