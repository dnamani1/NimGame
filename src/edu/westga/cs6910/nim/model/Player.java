package edu.westga.cs6910.nim.model;

/**
 * Player defines the interface for players in the game Nim.
 * 
 * @author CS6910
 * @version Summer 2023
 */
public interface Player {
	/**
	 * Sets the specified Pile as the one from which sticks
	 * will be taken on this Player's next move.
	 * 
	 * @param aPile	the Pile to take from
	 * 
	 * @requires aPile != null && aPile.sticksLeft() > 1
	 */
	void setPileForThisTurn(Pile aPile);
	
	/**
	   * Sets the number of sticks this Player will take on its next turn
	   * to the specified value.
	   * 
	   * @param number		how many sticks to take
	   * @require 0 < number &&
	   * 		  number <= Math.min(aPile.sticksLeft()-1, Game.MAX_STICKS_PER_TURN)
	   * @ensure  sticksOnThisTurn() == number
	   */
	void setNumberSticksToTake(int number);
	
	/**
	 * Sets the number of sticks this Player will take on its next turn
	 * to a calculated or default value. 
	 * 
	 * @ensure  0 < sticksOnThisTurn() &&
	 * 			sticksOnThisTurn() <= Math.min(pileForThisTurn().sticksLeft()-1,
	 * 										   Game.MAX_STICKS_PER_TURN) 
	 */
	void setNumberSticksToTake();
	
	/**
	 * Removes 1 or more sticks from the specified Pile. The number of sticks
	 * to remove is the return value of sticksOnThisTurn().
	 * 
	 * @require pileForThisTurn() != null && pileForThisTurn().sticksLeft() > 1
	 * @ensure  pileForThisTurn().sticksLeft() == 
	 * 					pileForThisTurn().sticksLeft()@prev - sticksOnThisTurn()
	 */
	void takeTurn();

	/**
	 * Returns this Player's name.
	 * 
	 * @return the name
	 */
	String getName();

	/**
	 * Returns the number of sticks removed on this Player's most recent turn
	 * or, if this Player has not had a turn, 0.
	 * 
	 * @return how many sticks this Player took
	 */
	int getSticksOnThisTurn();
	
	/**
	 * Returns the Pile from which sticks will be removed in this turn.
	 * 
	 * @return	the Pile
	 */
	Pile getPileForThisTurn();
}
