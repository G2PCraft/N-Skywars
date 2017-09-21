package com.nekota.mc.skywars.Util;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import com.nekota.mc.skywars.Main;

public class MessageCenter {
	private Main main;
	private FileConfiguration messageConfig;

	public MessageCenter(Main main) {
		try {
			this.main = main;
			// to be removed in future releases
			File messageFile = new File(main.getDataFolder(), "messages\\messages_enUS.yml");
			this.messageConfig = new YamlConfiguration();
			this.messageConfig.load(messageFile);
		} catch (IOException | InvalidConfigurationException e) {
			e.printStackTrace();
		}
	}

	public void send(CommandSender sender, String messagePath, String... arguments) {
		int i = 0;
		String message = messageConfig.getString(messagePath);
		Pattern regex = Pattern.compile("%%.*?%%");
		Matcher variables = regex.matcher(message);
		while (variables.find()) {
			message = message.replaceAll(variables.group(), arguments[i]);
			i++;
		}
	}

	public String getPlayerLocale(Player player) {
		return "en-US";
	}

	public void send(CommandSender sender, String messagePath) {
		this.send(sender, messagePath, "");
	}
	
	public void send(Player player, String messagePath, String... arguments) {
		this.send((CommandSender) player, messagePath, arguments);
	}
	
	public void send(Player player, String messagePath) {
		this.send((CommandSender) player, messagePath, "");
	}

}
