package Kakashi.KitPvP.Kits;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;

import Kakashi.KitPvP.Sistemas.API;
import Kakashi.KitPvP.Sistemas.Habilidade;

public class FisherMan implements Listener {
	@EventHandler
	public void onPlayerHitFishingrodscorpion(final PlayerFishEvent e) {
		final Player p = e.getPlayer();
		if (e.getCaught() instanceof Player) {
			final Player fisgado = (Player) e.getCaught();
			if (Habilidade.getAbility(p).equalsIgnoreCase("Fisherman")
					&& p.getItemInHand().getType() == Material.FISHING_ROD) {
				fisgado.teleport(p.getLocation());
				p.sendMessage(String.valueOf(API.preffix) + "�7Voce puxou o jogador �a" + fisgado.getDisplayName());
				fisgado.sendMessage(String.valueOf(API.preffix) + "�7�7Voce foi puxado por �a" + p.getDisplayName());
			}
		}
	}
}
