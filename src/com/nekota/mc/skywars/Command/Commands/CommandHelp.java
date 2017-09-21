package com.nekota.mc.skywars.Command.Commands;

import org.bukkit.command.CommandSender;

import com.nekota.mc.skywars.Main;

public class CommandHelp {
	public static void helpBase(CommandSender sender) {
		Main.getMessageCenter().send(sender, "command.usage.full");;
	}
	
	public static void helpEdit(CommandSender sender) {
		Main.getMessageCenter().send(sender, "command.usage.edit");;
	}
}
