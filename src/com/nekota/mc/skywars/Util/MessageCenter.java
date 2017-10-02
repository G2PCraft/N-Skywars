package com.nekota.mc.skywars.Util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.nekota.mc.skywars.Main;

public class MessageCenter {
	private static MessageFile enUSMessage;

	public MessageCenter(Main main) {
		enUSMessage = new MessageFile(Main.getInstance(), "messages_enUS.yml");
		// to be removed in future releases
	}

	public static void send(CommandSender sender, String messagePath, String... arguments) {
		int i = 0;
		String message = enUSMessage.getString(messagePath);
		Pattern regex = Pattern.compile("%%.*?%%");
		Matcher variables = regex.matcher(message);
		while (variables.find()) {
			message = message.replaceAll(variables.group(), arguments[i]);
			i++;
		}
		sender.sendMessage(message);
	}

	public String getPlayerLocale(Player player) {
		return "en-US";
	}

	public static void send(CommandSender sender, String messagePath) {
		send(sender, messagePath, "");
	}
	
	public static void send(Player player, String messagePath, String... arguments) {
		send((CommandSender) player, messagePath, arguments);
	}
	
	public static void send(Player player, String messagePath) {
		send((CommandSender) player, messagePath, "");
	}


}
