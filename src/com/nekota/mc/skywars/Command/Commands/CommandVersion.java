package com.nekota.mc.skywars.Command.Commands;

import org.bukkit.command.CommandSender;

import com.nekota.mc.skywars.Util.Global;

import net.md_5.bungee.api.ChatColor;

public class CommandVersion {
	public static void handle(CommandSender sender) {
		sender.sendMessage(ChatColor.GREEN + "N-Skywars " + Global.plugin_version + ChatColor.GOLD + " Made with LOVE by Unity41");
	}
}
