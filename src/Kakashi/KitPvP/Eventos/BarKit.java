package Kakashi.KitPvP.Eventos;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import Kakashi.KitPvP.Sistemas.API;
import me.confuser.barapi.BarAPI;

public class BarKit implements Listener {
	@EventHandler
	public void aoBaterKit(final EntityDamageByEntityEvent e) {
		if (!(e.getEntity() instanceof Player)) {
			return;
		}
		if (!(e.getDamager() instanceof Player)) {
			return;
		}
		final Player t = (Player) e.getEntity();
		final Player p = (Player) e.getDamager();
		BarAPI.setMessage(p, "§f" + t.getName() + " §7\u27a1 Kit: §4" + API.getKit(t), 2);
	}
}
