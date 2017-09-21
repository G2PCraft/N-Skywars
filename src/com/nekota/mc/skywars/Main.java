package com.nekota.mc.skywars;

import org.bukkit.plugin.java.JavaPlugin;

import com.nekota.mc.skywars.Exception.SkywarsException;
import com.nekota.mc.skywars.Game.Game;
import com.nekota.mc.skywars.Game.GameManager;
import com.nekota.mc.skywars.Util.MessageCenter;
import com.nekota.mc.skywars.Util.ResourceChecker;

public class Main extends JavaPlugin{
	private MessageCenter messageCenter;
	private ResourceChecker resourceChecker;
	
	public void onEnable() {
		this.resourceChecker = new ResourceChecker(this);
		this.resourceChecker.checkAndReleaseFromJar();
		
		this.messageCenter = new MessageCenter(this);
		this.getLogger().info("NSkywars is now enabled.");
	}
	
	public void onDisable() {
		this.getLogger().info("NSkywars is now disabled.");
	}
	
	public MessageCenter getMessageCenter() {
		return this.messageCenter;
	}
	
	// For testing purposes.
	public static void main(String args[]) {
		try {
			GameManager manager = new GameManager();
			Game game1 = new Game("mini026a", 2, 16);
			Game game2 = new Game("mini172f", 2, 16);
			Game game3 = new Game("mini092c", 2, 16);
			Game game4 = new Game("mini113b", 2, 16);
			game1.setPlayerNum(6);
			game2.setPlayerNum(1);
			game3.setPlayerNum(0);
			game4.setPlayerNum(15);
			manager.registerGame(game1);
			manager.registerGame(game2);
			manager.registerGame(game3);
			manager.registerGame(game4);
			for (Object game : manager.getRegisteredGames()) {
				System.out.println(game.toString());
			}
			System.out.println("Test sort");
			manager.flush();
			System.out.println("Test finding best game");
			System.out.println("found game " + manager.findGame().toString());
			System.out.println("Test finish");
		} catch (SkywarsException e) {
			e.printStackTrace();
		}
	}
}
