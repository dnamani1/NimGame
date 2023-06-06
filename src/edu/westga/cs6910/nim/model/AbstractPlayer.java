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

	@Override
	public void setPileForThisTurn(Pile aPile) {
		this.thePile = aPile;
	}

	@Override
	public abstract void takeTurn();

	@Override
	public void setNumberSticksToTake(int number) {
		this.sticksToTake = number;
	}

	@Override
	public abstract void setNumberSticksToTake();

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public int getSticksOnThisTurn() {
		return this.sticksToTake;
	}

	@Override
	public Pile getPileForThisTurn() {
		return this.thePile;
	}
}
