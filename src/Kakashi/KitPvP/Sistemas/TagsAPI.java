package Kakashi.KitPvP.Sistemas;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import com.github.caaarlowsz.kakashimc.kitpvp.KakashiPvP;
import Kakashi.KitPvP.NametagAPI;

public class TagsAPI {
	public static void setarTag(final Player p, final String tag) {
		new BukkitRunnable() {
			public void run() {
				p.setDisplayName(String.valueOf(tag) + p.getName());
				NametagAPI.setSuffix(p.getName(), tag);
			}
		}.runTaskAsynchronously((Plugin) KakashiPvP.getInstance());
	}
}
