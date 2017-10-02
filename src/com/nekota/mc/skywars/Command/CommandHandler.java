package com.nekota.mc.skywars.Command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.nekota.mc.skywars.Command.Commands.CommandHelp;
import com.nekota.mc.skywars.Command.Commands.CommandMap;
import com.nekota.mc.skywars.Command.Commands.CommandVersion;
import com.nekota.mc.skywars.Util.MessageCenter;

public class CommandHandler implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
		if (!(sender instanceof Player)) {
			MessageCenter.send(sender, "command.only_for_players");
			return true;
		}
		switch (args.length) {
		case 0:
			CommandVersion.handle(sender);
			break;
		default:
			switch (args[0]) {
			case "help":
				CommandHelp.helpBase(sender);
				break;
			case "map":
				CommandMap.handle(sender, args);
				break;
			case "version":
				CommandVersion.handle(sender);
				break;
			case "test":
				// insert test functions here in order to perform in-game test
				break;
			}
		}
		return true;
	}

}
