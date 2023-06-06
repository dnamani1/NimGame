package edu.westga.cs6910.nim.model;

/**
 * ComputerPlayer represents a very simple automated player in the game Nim. It
 * removes 1 stick at a time. This class was started by CS6910
 * 
 * @author Deeksha Namani
 * @version 6/5/2023
 */
public class ComputerPlayer extends AbstractPlayer {
	private static final String NAME = "Simple computer";
	private int sticksToTake;
	private Pile thePile;

	/**
	 * Creates a new ComputerPlayer with the specified name.
	 * 
	 */
	public ComputerPlayer() {
		super(NAME);
	}

	@Override
	/**
	 * @see Player#takeTurn()
	 */
	public void takeTurn() {
		if (this.thePile != null) {
            this.thePile.removeSticks(this.sticksToTake);
        }
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
		if (this.thePile != null) {
            this.sticksToTake = 1;
        }
	}
	
	@Override
    public void setPileForThisTurn(Pile aPile) {
        this.thePile = aPile;
    }

}
