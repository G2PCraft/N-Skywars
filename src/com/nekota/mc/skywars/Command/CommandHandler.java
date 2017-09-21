package com.nekota.mc.skywars.Command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.nekota.mc.skywars.Main;

public class CommandHandler implements CommandExecutor{
	private Main main;
	
	public CommandHandler(Main main){
		this.main = main;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
		if (!(sender instanceof Player)) {
			main.getMessageCenter().send(sender, "");
			return true;
		}
		return false;
	}

}
