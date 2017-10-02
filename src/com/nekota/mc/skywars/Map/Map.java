package com.nekota.mc.skywars.Map;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class Map {

	private String name;
	private Region border;
	private Region waitingRegion;
	private Location centerBlock;
	private List<Location> spawns;
	
	private int playersPerTeam;

	private File mapFileRaw;
	private FileConfiguration mapFile;

	private MapStatus mapStatus;

	public Map(File mapFile) throws FileNotFoundException, IOException, InvalidConfigurationException {
		this.mapFile = new YamlConfiguration();
		this.mapFileRaw = mapFile;
		this.mapFile.load(mapFileRaw);
		this.initFromFile();
	}

	private boolean isValueNull(String path) {
		return this.mapFile.get(path) == null;
	}

	@SuppressWarnings("unchecked")
	public void initFromFile() {
		// Name
		this.name = this.mapFile.getString("Name");
		// Border
		if (isValueNull("Border.Location1") || isValueNull("Border.Location2")) {
			this.mapStatus = MapStatus.LACK_BORDER;
			return;
		}
		Location borderLoc1 = (Location) this.mapFile.get("Border.Location1");
		Location borderLoc2 = (Location) this.mapFile.get("Border.Location2");
		this.border = new Region(borderLoc1, borderLoc2);
		// Waiting Region
		if (isValueNull("Waiting.Location1") || isValueNull("Waiting.Location2")) {
			this.mapStatus = MapStatus.LACK_WAITING;
			return;
		}
		borderLoc1 = (Location) this.mapFile.get("Waiting.Location1");
		borderLoc2 = (Location) this.mapFile.get("Waiting.Location2");
		this.waitingRegion = new Region(borderLoc1, borderLoc2);
		// Center Block
		if (isValueNull("Center")) {
			this.mapStatus = MapStatus.LACK_CENTER;
			return;
		}
		this.centerBlock = (Location) this.mapFile.get("Center");
		// Integer: Players Per Team
		if (isValueNull("PlayersPerTeam")) {
			this.mapStatus = MapStatus.LACK_PPT;
			return;
		}
		this.playersPerTeam = this.mapFile.getInt("PlayersPerTeam");
		// Location List: Spawnpoints
		if (isValueNull("Spawns")) {
			this.mapStatus = MapStatus.LACK_SPAWNPOINT;
			return;
		}
		this.spawns = (List<Location>) this.mapFile.getList("Spawns");
	}
	
	public void saveChanges() throws IOException, NullPointerException {
		this.mapFile.set("Name", this.getName());
		this.mapFile.set("Border.Location1", this.border.getLocation1());
		this.mapFile.set("Border.Location2", this.border.getLocation2());
		this.mapFile.set("Waiting.Location2", this.waitingRegion.getLocation2());
		this.mapFile.set("Waiting.Location2", this.waitingRegion.getLocation2());
		this.mapFile.set("Spawns", this.spawns);
		this.mapFile.set("Center", this.centerBlock);
		this.mapFile.set("PlayersPerTeam", this.playersPerTeam);
		this.mapFile.save(this.mapFileRaw);
	}

	
	public void setName(String name) {
		this.name = name;
	}

	public void setCenterBlock(Location block) {
		this.centerBlock = block;
	}

	public void setBorder(Region border) {
		this.border = border;
	}

	public void setPlayersPerTeam(int num) {
		this.playersPerTeam = num;
	}

	public void setWaitingRegion(Region region) {
		this.waitingRegion = region;
	}
	
	public void setStatus(MapStatus status) {
		this.mapStatus = status;
	}

	public String getName() {
		return this.name;
	}

	public Region getBorder() {
		return this.border;
	}

	public Region getWaitingRegion() {
		return this.waitingRegion;
	}

	public Location getCenterBlock() {
		return this.centerBlock;
	}

	public int getPlayersPerTeam() {
		return this.playersPerTeam;
	}
	
	public MapStatus getStatus() {
		return this.mapStatus;
	}

}
