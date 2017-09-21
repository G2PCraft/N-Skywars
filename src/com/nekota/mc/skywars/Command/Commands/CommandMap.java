package com.nekota.mc.skywars.Command.Commands;

import org.bukkit.command.CommandSender;

public class CommandMap {
	public static void handle(CommandSender sender, String[] args) {
		switch (args[1]) {
		case "edit":
			CommandHelp.helpEdit(sender);
			break;
		}
	}
}
