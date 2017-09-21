package com.nekota.mc.skywars.Map;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class Map {
	private FileConfiguration mapFile;
	public Map(File mapFile) throws FileNotFoundException, IOException, InvalidConfigurationException {
		this.mapFile = new YamlConfiguration();
		this.mapFile.load(mapFile);
	}
	
}
