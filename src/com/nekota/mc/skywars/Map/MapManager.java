package com.nekota.mc.skywars.Map;

import java.io.File;
import java.io.IOException;

import com.nekota.mc.skywars.Main;
import com.nekota.mc.skywars.Exception.SkywarsException;

public class MapManager {
	private Main main;
	public MapManager(Main main) {
		this.main = main;
	}
	public void createNewMap(String name) throws SkywarsException, IOException {
		// 瞎写的。。脑子好用的时候再回来看。
		
		File mapFile = new File(main.getDataFolder(), "maps\\" + name + ".yml");
		if (mapFile.exists()) {
			throw new SkywarsException("Map name already used");
		} else {
			mapFile.createNewFile();
		}
	}
	
}
