package Kakashi.KitPvP.Kits;

import org.bukkit.event.block.*;
import org.bukkit.entity.*;
import org.bukkit.*;

import java.util.*;
import org.bukkit.event.*;
import org.bukkit.event.player.*;

import Kakashi.KitPvP.*;
import Kakashi.KitPvP.Sistemas.*;

import org.bukkit.event.entity.*;

public class TimeLord implements Listener
{
    public static ArrayList<String> playercongelados;
    
    static {
        TimeLord.playercongelados = new ArrayList<String>();
    }
    
    @EventHandler
    public void onTimerLord(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (Habilidade.getAbility(p).equalsIgnoreCase("TimeLord") && (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && p.getInventory().getItemInHand().getType() == Material.WATCH) {
            if (Cooldown.add(p)) {
                API.MensagemCooldown(p);
                return;
            }
            Cooldown.add(p, 15);
            p.sendMessage(String.valueOf(API.preffix) + "�f�lVoc\u00ea congelou");
            for (final Entity pertos : p.getNearbyEntities(5.0, 5.0, 5.0)) {
                TimeLord.playercongelados.add(((Player)pertos).getName());
                ((Player)pertos).sendMessage(String.valueOf(API.preffix) + "�aVoc\u00ea foi congelado por um timelord");
                ((Player)pertos).playSound(pertos.getLocation(), Sound.WITHER_SPAWN, 1.0f, 1.0f);
                Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
                    @Override
                    public void run() {
                        TimeLord.playercongelados.remove(((Player)pertos).getName());
                        ((Player)pertos).sendMessage(String.valueOf(API.preffix) + "�aVoc\u00ea n\u00e3o esta mais congelado");
                    }
                }, 160L);
            }
            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    p.sendMessage(API.fimcooldown);
                }
            }, 400L);
        }
    }
    
    @EventHandler
    public void onTimerLordado(final PlayerMoveEvent e) {
        final Player p = e.getPlayer();
        if (TimeLord.playercongelados.contains(p.getName())) {
            e.setTo(p.getLocation());
        }
    }
    
    @EventHandler
    public void TirarTimelord(final EntityDamageByEntityEvent e) {
        if (!(e.getEntity() instanceof Player)) {
            return;
        }
        if (!(e.getDamager() instanceof Player)) {
            return;
        }
        final Player p = (Player)e.getEntity();
        final Player s = (Player)e.getDamager();
        if (Habilidade.getAbility(s).equalsIgnoreCase("TimeLord") && s.getInventory().getItemInHand() != null) {
            TimeLord.playercongelados.remove(p.getName());
        }
    }
}