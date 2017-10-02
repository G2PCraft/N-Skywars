package com.nekota.mc.skywars.Map;

import java.io.File;
import java.io.IOException;

import com.nekota.mc.skywars.Main;
import com.nekota.mc.skywars.Exception.SkywarsException;
import com.nekota.mc.skywars.Util.Global;

public class MapManager {
	private static Main main;

	public MapManager(Main main) {
		MapManager.main = main;
	}

	public static void createNewMap(String name) throws SkywarsException, IOException {
		if (isMapExist(name)) {
			throw new SkywarsException("Map name already used");
		} else {
			new File(main.getDataFolder(), Global.FOLDER_NAME_MAPS + "\\" + name + ".yml").createNewFile();
		}
	}

	public static boolean isMapExist(String name) {
		return new File(main.getDataFolder(), Global.FOLDER_NAME_MAPS + "\\" + name + ".yml").exists();
	}

}
