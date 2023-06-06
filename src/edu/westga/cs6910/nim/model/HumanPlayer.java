package edu.westga.cs6910.nim.model;

/**
 * HumanPlayer represents a human player in the game Nim.
 * 
 * @author CS6910
 * @version Summer 2023
 */
public class HumanPlayer extends AbstractPlayer {

	/**
	 * Creates a new ComputerPlayer with the specified name.
	 * 
	 * @param name
	 *            this Player's name
	 * 
	 * @requires name != null
	 * @ensure name().equals(name) && sticksRemoved() == 0
	 */
	public HumanPlayer(String name) {
		super(name);
	}

	@Override
	/**
	 * Implements Player's setNumberSticksToTake() to set the number
	 * of sticks to the maximum allowed for this turn.
	 * 
	 * @ensure  sticksOnThisTurn() == 
	 * 					Math.min(pileForThisTurn.sticksLeft()-1, 
	 * 							 Game.MAX_STICKS_PER_TURN)
	 * 
	 * @see Player#setNumberSticksToTake()
	 */
	public void setNumberSticksToTake() {
		super.setNumberSticksToTake(Math.min(super.getPileForThisTurn().getSticksLeft() - 1, Game.MAX_STICKS_PER_TURN));
	}

}
