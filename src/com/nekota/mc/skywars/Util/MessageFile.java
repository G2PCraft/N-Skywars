package com.nekota.mc.skywars.Util;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import com.nekota.mc.skywars.Main;

import net.md_5.bungee.api.ChatColor;

public class MessageFile {
	private FileConfiguration messageConfig;
	public MessageFile(Main main, String fileName) {
		try {
			File messageFile = new File(main.getDataFolder(), "messages\\" + fileName);
			this.messageConfig = new YamlConfiguration();
			this.messageConfig.load(messageFile);
		} catch (IOException | InvalidConfigurationException e) {
			e.printStackTrace();
		}
	}
	
	public String getString(String key) {
		return ChatColor.translateAlternateColorCodes('&', this.messageConfig.getString(key));
	}
}
