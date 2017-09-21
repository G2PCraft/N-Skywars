package com.nekota.mc.skywars.Command.Commands;

import org.bukkit.command.CommandSender;

import net.md_5.bungee.api.ChatColor;

public class CommandVersion {
	public static void handle(CommandSender sender) {
		sender.sendMessage(ChatColor.GREEN + "N-Skywars 1.0.0-SNAPSHOT " + ChatColor.GOLD + "Made with LOVE by Unity41");
	}
}
