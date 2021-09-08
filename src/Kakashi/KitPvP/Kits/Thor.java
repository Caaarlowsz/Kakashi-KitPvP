package Kakashi.KitPvP.Kits;

import org.bukkit.event.player.*;

import Kakashi.KitPvP.*;
import Kakashi.KitPvP.Sistemas.*;

import org.bukkit.event.block.*;

import java.util.*;

import org.bukkit.entity.*;
import org.bukkit.*;
import org.bukkit.event.*;

public class Thor implements Listener
{
    @SuppressWarnings({ "rawtypes", "deprecation", "unchecked" })
	@EventHandler
    public void ThorKit(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (Habilidade.getAbility(p).equalsIgnoreCase("Thor") && (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && p.getItemInHand().getType() == Material.GOLD_AXE) {
            if (Cooldown.add(p)) {
                API.MensagemCooldown(p);
                return;
            }
            Cooldown.add(p, 5);
            final Location loc = p.getTargetBlock((HashSet)null, 30).getLocation();
            p.getWorld().strikeLightning(loc);
            e.setCancelled(true);
            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    p.sendMessage(API.fimcooldown);
                }
            }, 100L);
        }
    }
}
