package com.ynov.control;

public class PlayerDeadExeption extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Player deadPlayer;
	
	public PlayerDeadExeption(Player player)
	{
		deadPlayer=player;
	}
	
	public Player getDeadPlayer()
	{
		return this.deadPlayer;
	}
	
}
