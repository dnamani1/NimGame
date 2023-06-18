package edu.westga.cs6910.nim.model;

import edu.westga.cs6910.nim.model.strategy.NumberOfSticksStrategy;

/**
 * ComputerPlayer represents a very simple automated player in the game Nim. It
 * removes 1 stick at a time. This class was started by CS6910
 * 
 * @author Deeksha Namani
 * @version 6/5/2023
 */
public class ComputerPlayer extends AbstractPlayer {
	private NumberOfSticksStrategy theStrategy;

	/**
	 * Creates a new ComputerPlayer with a default name and strategy.
	 */
	public ComputerPlayer() {
		this("Simple computer", null);
	}

	/**
	 * Creates a new ComputerPlayer with the specified name.
	 * 
	 * @param name     of the computer.
	 * @param strategy to be use.
	 */
	public ComputerPlayer(String name, NumberOfSticksStrategy strategy) {
		super(name);
		this.theStrategy = strategy;
	}

	@Override
	/**
	 * Implements Player's setNumberSticksToTake() to set the number of sticks to 1.
	 * 
	 * @ensure sticksOnThisTurn() == 1
	 * 
	 * @see Player#setNumberSticksToTake()
	 */
	public void setNumberSticksToTake() {
		if (this.theStrategy != null) {
			int pileSize = this.getPileForThisTurn().getSticksLeft();
			int sticksToTake = this.theStrategy.howManySticks(pileSize);
			this.setNumberSticksToTake(sticksToTake);
		} else {
			this.setNumberSticksToTake(1);
		}
	}
}