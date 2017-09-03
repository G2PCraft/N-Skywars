package com.nekota.mc.skywars;

public class Game {
	private String roomName;
	private int player;
	private int minPlayer;
	private int maxPlayer;
	private GameState gameState;


	public Game(String roomName,int minPlayer, int maxPlayer) {
		this.roomName = roomName;
		this.player = 0;
		this.minPlayer = minPlayer;
		this.maxPlayer = maxPlayer;
		this.gameState = GameState.WAITING;
	}
	
	// only for test purpose. delete it when release.
	public void setPlayerNum(int num) {
		this.player = num;
	}
	
	public void setState(GameState state) {
		this.gameState = state;
	}
	
	public String getRoomName() {
		return roomName;
	}
	
	public int getPlayerNum() {
		return player;
	}
	
	public int getMinPlayerValue() {
		return minPlayer;
	}
	
	public int getMaxPlayerValue() {
		return maxPlayer;
	}
	
	public GameState getState() {
		return this.gameState;
	}
	
	public String toString() {
		return new String("Game{name='" + roomName + "',state=" + gameState + ",player=" + player + "}");
	}
	
	public void shutdown() {
		
	}
}
