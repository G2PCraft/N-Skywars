package com.nekota.mc.skywars.Command.Commands;

import org.bukkit.command.CommandSender;

import com.nekota.mc.skywars.Main;

import net.md_5.bungee.api.ChatColor;

public class CommandVersion {
	public static void handle(CommandSender sender) {
		sender.sendMessage(ChatColor.GREEN + "N-Skywars " + Main.getVersionString() + ChatColor.GOLD + " Made with LOVE by Unity41");
	}
}
