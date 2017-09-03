package com.nekota.mc.skywars;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.nekota.mc.skywars.Exception.SkywarsException;

public class GameManager {
	private Map<String, Game> registeredGames; // All registered games
	private List<Game> availableGames; // Available game list

	public GameManager() {
		this.registeredGames = new HashMap<String, Game>();
		this.availableGames = new ArrayList<Game>();
	}

	private void clearAvailableGameList() {
		this.availableGames.clear();
	}

	public void registerGame(Game game) throws SkywarsException {
		this.registerGame(game.getRoomName(), game);
	}

	public void registerGame(String name, Game game) throws SkywarsException {
		if (registeredGames.containsKey(name))
			throw new SkywarsException("The name already exists");
		this.registeredGames.put(name, game);
	}

	public void removeGame(String name) throws SkywarsException {
		if (registeredGames.containsKey(name))
			throw new SkywarsException("The name doesn't exist");
		Game game = this.getGame(name);
		game.shutdown();
		this.registeredGames.remove(name);
		if (this.availableGames.contains(game))
			this.availableGames.remove(game);
	}

	/*
	 * This method will do these things 1. remove started games 2. sort the game
	 * list by the number of players in each game
	 */
	public void flush() {
		this.clearAvailableGameList();
		for (Game game : this.getRegisteredGames()) {
			if (game.getState() != GameState.WAITING)
				continue;
			this.getAvailableGames().add(game);
		}
		Collections.sort(availableGames, new Comparator<Game>() {
			@Override
			public int compare(Game o1, Game o2) {
				return (o1.getPlayerNum() - o2.getPlayerNum());
			}
		});
		Collections.reverse(availableGames);
		// delete this later
		for (int i = 0; i < availableGames.size(); i++) {
			String id = availableGames.get(i).toString();
			System.out.println(id);
		}
	}

	public Game getGame(String name) {
		return this.registeredGames.get(name);
	}

	public Game[] getRegisteredGames() {
		Game[] games = new Game[registeredGames.values().size()];
		return registeredGames.values().toArray(games);
	}

	// using list we can keep the order
	public List<Game> getAvailableGames() {
		return this.availableGames;
	}

	// normally return the first game in the list
	public Game findGame() {
		return this.getAvailableGames().get(0);
	}
}
