package Kakashi.KitPvP;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SendMSG implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		final StringBuilder sb = new StringBuilder();
		for (int i = 1; i < args.length; ++i) {
			sb.append(args[i]).append(" ");
		}
		final String motivo = sb.toString().trim();

		if (cmd.getName().equalsIgnoreCase("sendmsg")) {
			Player t = Bukkit.getPlayer(args[0]);

			if (args.length < 2) {
				sender.sendMessage("§cUse /sendmsg <Player> Mensagem");
				return true;
			}

			t.sendMessage(motivo);
			sender.sendMessage("§aVoce --> " + t.getName() + " : §f " + motivo);

		}

		return false;
	}

}
