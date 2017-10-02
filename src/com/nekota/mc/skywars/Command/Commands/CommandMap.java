package com.nekota.mc.skywars.Command.Commands;

import java.io.IOException;

import org.bukkit.command.CommandSender;

import com.nekota.mc.skywars.Exception.SkywarsException;
import com.nekota.mc.skywars.Map.MapManager;
import com.nekota.mc.skywars.Util.MessageCenter;

public class CommandMap {
	public static void handle(CommandSender sender, String[] args) {
		switch (args[1]) {
		case "edit":
			CommandHelp.helpEdit(sender);
			break;
		case "create":
			if (args.length != 3) {
				MessageCenter.send(sender, "command.wrong_usage");
				return;
			}
			String mapToCreate = args[2];
			if (MapManager.isMapExist(mapToCreate)) {
				MessageCenter.send(sender, "command.map.exists", mapToCreate);
				return;
			}
			try {
				MapManager.createNewMap(mapToCreate);
				MessageCenter.send(sender, "command.map.create", mapToCreate);
			} catch (IOException | SkywarsException e) {
				MessageCenter.send(sender, "command.map.create-fail");
				e.printStackTrace();
			}
			break;
		}
	}
}
