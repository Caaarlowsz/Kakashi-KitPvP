package Kakashi.KitPvP.Warps;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.caaarlowsz.kakashimc.kitpvp.KakashiPvP;
import Kakashi.KitPvP.Sistemas.API;

public class SetWarp implements CommandExecutor {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("set") && p.hasPermission("kitpvp.set") && args.length == 0) {
			p.sendMessage(String.valueOf(API.preffix) + "§cEscreva: /set (challenge,fps,knock,main,mdr,rdm,spawn) §2✔");
			return true;
		}
		if (args[0].equalsIgnoreCase("challenge")) {
			KakashiPvP.getInstance().warps.set("challenge.x", (Object) p.getLocation().getX());
			KakashiPvP.getInstance().warps.set("challenge.y", (Object) p.getLocation().getY());
			KakashiPvP.getInstance().warps.set("challenge.z", (Object) p.getLocation().getZ());
			KakashiPvP.getInstance().warps.set("challenge.pitch", (Object) p.getLocation().getPitch());
			KakashiPvP.getInstance().warps.set("challenge.yaw", (Object) p.getLocation().getYaw());
			KakashiPvP.getInstance().warps.set("challenge.world", (Object) p.getLocation().getWorld().getName());
			KakashiPvP.getInstance().save();
			p.sendMessage(String.valueOf(API.preffix) + "§cVoce setou a warp §4Challenge");
			return true;
		}
		if (args[0].equalsIgnoreCase("fps")) {
			KakashiPvP.getInstance().warps.set("fps.x", (Object) p.getLocation().getX());
			KakashiPvP.getInstance().warps.set("fps.y", (Object) p.getLocation().getY());
			KakashiPvP.getInstance().warps.set("fps.z", (Object) p.getLocation().getZ());
			KakashiPvP.getInstance().warps.set("fps.pitch", (Object) p.getLocation().getPitch());
			KakashiPvP.getInstance().warps.set("fps.yaw", (Object) p.getLocation().getYaw());
			KakashiPvP.getInstance().warps.set("fps.world", (Object) p.getLocation().getWorld().getName());
			KakashiPvP.getInstance().save();
			p.sendMessage(String.valueOf(API.preffix) + "§cVoce setou a warp §4Fps");
			return true;
		}
		if (args[0].equalsIgnoreCase("knock")) {
			KakashiPvP.getInstance().warps.set("knock.x", (Object) p.getLocation().getX());
			KakashiPvP.getInstance().warps.set("knock.y", (Object) p.getLocation().getY());
			KakashiPvP.getInstance().warps.set("knock.z", (Object) p.getLocation().getZ());
			KakashiPvP.getInstance().warps.set("knock.pitch", (Object) p.getLocation().getPitch());
			KakashiPvP.getInstance().warps.set("knock.yaw", (Object) p.getLocation().getYaw());
			KakashiPvP.getInstance().warps.set("knock.world", (Object) p.getLocation().getWorld().getName());
			KakashiPvP.getInstance().save();
			p.sendMessage(String.valueOf(API.preffix) + "§cVoce setou a warp §4Knock");
			return true;
		}
		if (args[0].equalsIgnoreCase("main")) {
			KakashiPvP.getInstance().warps.set("main.x", (Object) p.getLocation().getX());
			KakashiPvP.getInstance().warps.set("main.y", (Object) p.getLocation().getY());
			KakashiPvP.getInstance().warps.set("main.z", (Object) p.getLocation().getZ());
			KakashiPvP.getInstance().warps.set("main.pitch", (Object) p.getLocation().getPitch());
			KakashiPvP.getInstance().warps.set("main.yaw", (Object) p.getLocation().getYaw());
			KakashiPvP.getInstance().warps.set("main.world", (Object) p.getLocation().getWorld().getName());
			KakashiPvP.getInstance().save();
			p.sendMessage(String.valueOf(API.preffix) + "§cVoce setou a warp §4Main");
			return true;
		}
		if (args[0].equalsIgnoreCase("mdr")) {
			KakashiPvP.getInstance().warps.set("mdr.x", (Object) p.getLocation().getX());
			KakashiPvP.getInstance().warps.set("mdr.y", (Object) p.getLocation().getY());
			KakashiPvP.getInstance().warps.set("mdr.z", (Object) p.getLocation().getZ());
			KakashiPvP.getInstance().warps.set("mdr.pitch", (Object) p.getLocation().getPitch());
			KakashiPvP.getInstance().warps.set("mdr.yaw", (Object) p.getLocation().getYaw());
			KakashiPvP.getInstance().warps.set("mdr.world", (Object) p.getLocation().getWorld().getName());
			KakashiPvP.getInstance().save();
			p.sendMessage(String.valueOf(API.preffix) + "§cVoce setou a warp §4Mdr");
			return true;
		}
		if (args[0].equalsIgnoreCase("rdm")) {
			KakashiPvP.getInstance().warps.set("rdm.x", (Object) p.getLocation().getX());
			KakashiPvP.getInstance().warps.set("rdm.y", (Object) p.getLocation().getY());
			KakashiPvP.getInstance().warps.set("rdm.z", (Object) p.getLocation().getZ());
			KakashiPvP.getInstance().warps.set("rdm.pitch", (Object) p.getLocation().getPitch());
			KakashiPvP.getInstance().warps.set("rdm.yaw", (Object) p.getLocation().getYaw());
			KakashiPvP.getInstance().warps.set("rdm.world", (Object) p.getLocation().getWorld().getName());
			KakashiPvP.getInstance().save();
			p.sendMessage(String.valueOf(API.preffix) + "§cVoce setou a warp §4Rdm");
			return true;
		}
		if (args[0].equalsIgnoreCase("spawn")) {
			KakashiPvP.getInstance().getConfig().set("spawn.x", (Object) p.getLocation().getX());
			KakashiPvP.getInstance().getConfig().set("spawn.y", (Object) p.getLocation().getY());
			KakashiPvP.getInstance().getConfig().set("spawn.z", (Object) p.getLocation().getZ());
			KakashiPvP.getInstance().getConfig().set("spawn.pitch", (Object) p.getLocation().getPitch());
			KakashiPvP.getInstance().getConfig().set("spawn.yaw", (Object) p.getLocation().getYaw());
			KakashiPvP.getInstance().getConfig().set("spawn.world", (Object) p.getLocation().getWorld().getName());
			KakashiPvP.getInstance().saveConfig();
			p.sendMessage(String.valueOf(API.preffix) + "§cVoce setou o §4Spawn");
			p.getWorld().setSpawnLocation(p.getLocation().getBlockX(), p.getLocation().getBlockY(),
					p.getLocation().getBlockZ());
			return true;
		}
		return false;
	}
}
