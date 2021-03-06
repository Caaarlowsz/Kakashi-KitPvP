package Kakashi.KitPvP.Guis;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class EventosGuis implements Listener {
	public static ArrayList<String> aocaixa;

	static {
		EventosGuis.aocaixa = new ArrayList<String>();
	}

	@EventHandler
	public void onBauKit(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (p.getItemInHand().getType().equals((Object) Material.ENDER_CHEST)
				&& p.getItemInHand().getItemMeta().hasDisplayName()
				&& p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§4§lKits")) {
			e.setCancelled(true);
			if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
				GuiKits.GuiKit(p);
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
			}
		}
	}

	@EventHandler
	public void onWarp(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (p.getItemInHand().getType().equals((Object) Material.COMPASS)
				&& p.getItemInHand().getItemMeta().hasDisplayName()
				&& p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§4§lWarps")) {
			e.setCancelled(true);
			if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
				GuiWarps.GuiWarp(p);
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
			}
		}
	}

	@EventHandler
	public void onLojas(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (p.getItemInHand().getType().equals((Object) Material.POTION)
				&& p.getItemInHand().getItemMeta().hasDisplayName()
				&& p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§4§lLojas")) {
			e.setCancelled(true);
			if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
				GuiLoja.GuiLojaKit(p);
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
			}
		}
	}
}