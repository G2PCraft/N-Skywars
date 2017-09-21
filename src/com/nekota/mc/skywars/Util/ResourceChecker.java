package com.nekota.mc.skywars.Util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.nekota.mc.skywars.Main;

public class ResourceChecker {
	private Main main;
	private List<String> MESSAGE_FILE_NAME_LIST;
	private final String MESSAGE_FILE_FOLDER_NAME = "messages";
	private List<String> MESSAGE_FOLDER_NAME_LIST;
	public ResourceChecker(Main main) {
		this.main = main;
		this.MESSAGE_FILE_NAME_LIST = new ArrayList<String>();
		this.MESSAGE_FILE_NAME_LIST.add("messages_enUS.yml");
		this.MESSAGE_FILE_NAME_LIST.add("messages_zhCN.yml");
		this.MESSAGE_FOLDER_NAME_LIST = new ArrayList<String>();
		this.MESSAGE_FOLDER_NAME_LIST.add("maps");
		this.MESSAGE_FOLDER_NAME_LIST.add("messages");
		this.MESSAGE_FOLDER_NAME_LIST.add("games");
	}

	public void checkAndReleaseFromJar() {
		try {
			this.main.getLogger().info("Checking resource files...");
			this.checkFolder();
			this.checkConfigFile();
			this.checkMessageFile();
			this.main.getLogger().info("Checked all resources");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void checkFolder() {
		for (String folderName : MESSAGE_FOLDER_NAME_LIST) {
			File folderFile = new File(this.main.getDataFolder(), folderName);
			if (folderFile.exists()) {
				return;
			} else {
				folderFile.mkdirs();
			}
		}
	}
	
	private void checkMessageFile() throws IOException {
		int releasedCount = 0;
		for (String fileName : MESSAGE_FILE_NAME_LIST) {
			File messageFile = new File(this.main.getDataFolder(), MESSAGE_FILE_FOLDER_NAME + "\\" + fileName);
			if (messageFile.exists()) {
				return;
			} else {
				messageFile.createNewFile();
			}
			InputStream is = this.main.getResource(fileName);
			FileUtils.copyInputStreamToFile(is, messageFile);
			releasedCount++;
		}
		this.main.getLogger()
				.info("Detected lacked file. Released " + releasedCount + " message file(s) to plugin folder");
	}
	
	private void checkConfigFile() throws IOException {
		this.main.saveDefaultConfig();
	}
}
