package edu.westga.cs6910.nim.model;

/**
 * In Nim game a player is represents as AbstractPlayer,it have shared code and
 * defines abstract methods for unshared code. Subclasses HumanPlayer and
 * ComputerPlayer class extend this class to implement the unshared constructor
 * code and the abstract methods.
 * 
 * @author Deeksha Namani
 *
 * @version 6/5/2023
 */
public abstract class AbstractPlayer implements Player {
	private String name;
	private int sticksToTake;
	private Pile thePile;

	/**
	 * Creates a new player with the specified name.
	 * 
	 * @param name the player's name
	 * 
	 * @requires name != null
	 */
	public AbstractPlayer(String name) {
		this.name = name;
		this.sticksToTake = 0;
	}

	/**
	 * Sets the given Pile as the one from which sticks for this player's subsequent
	 * move will be taken.
	 * 
	 * @param aPile the Pile to take from
	 */
	public void setPileForThisTurn(Pile aPile) {
		this.thePile = aPile;
	}

	/**
	 * Remove number of sticks from the pile
	 */
	public void takeTurn() {
		if (this.thePile != null) {
			this.thePile.removeSticks(this.sticksToTake);
		}
	}

	/**
	 * This method sets the number of sticks next Player will take on upcoming move.
	 */
	@Override
	public void setNumberSticksToTake(int number) {
		this.sticksToTake = number;
	}

	/**
	 * Sets the number of sticks to take on the player's turn.
	 */
	public abstract void setNumberSticksToTake();

	/**
	 * This method returns the name of the player
	 * 
	 * @return the name of the player
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * This method returns the removed number of sticks by player's most recent
	 * turn.
	 * 
	 * @return the number of sticks removed on the player's most recent turn
	 */
	public int getSticksOnThisTurn() {
		return this.sticksToTake;
	}

	/**
	 * This method returns the pile from which sticks will be removed in present
	 * turn.
	 * 
	 * @return the pile from which sticks will be removed
	 */
	public Pile getPileForThisTurn() {
		return this.thePile;
	}
}
