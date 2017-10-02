package com.nekota.mc.skywars.Command.Commands;

import org.bukkit.command.CommandSender;

import com.nekota.mc.skywars.Util.MessageCenter;

public class CommandHelp {
	public static void helpBase(CommandSender sender) {
		MessageCenter.send(sender, "command.usage.full");;
	}
	
	public static void helpEdit(CommandSender sender) {
		MessageCenter.send(sender, "command.edit.help");
	}
}
