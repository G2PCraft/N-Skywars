package com.nekota.mc.skywars.Map;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;

public class ChestItemSet {
	private String name;
	private List<ItemStack> items;
	
	private File setFileRaw;
	private FileConfiguration setFile;
	public ChestItemSet(File setFile) throws FileNotFoundException, IOException, InvalidConfigurationException{
		this.setFileRaw = setFile;
		this.setFile.load(setFileRaw);
	}
	
	@SuppressWarnings("unchecked")
	public void initFromFile() {
		this.name = setFile.getString("Name");
		this.items = (List<ItemStack>) setFile.getList("Items");
	}
	
	public void saveChanges() throws IOException, NullPointerException {
		this.setFile.set("Name", this.name);
		this.setFile.set("Items", this.items);
		this.setFile.save(this.setFileRaw);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setItems(List<ItemStack> items) {
		this.items = items;
	}
	
	public String getName() {
		return this.name;
	}
	
	public List<ItemStack> getItems() {
		return this.items;
	}
}
