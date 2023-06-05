package edu.westga.cs6910.nim.model;

/**
 * HumanPlayer represents a human player in the game Nim.
 * 
 * @author CS6910
 * @version Summer 2023
 */
public class HumanPlayer implements Player {

	private String name;
	private int sticksToTake;
	private Pile thePile;

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
		this.name = name;
		this.sticksToTake = 0;
	}

	@Override	
	/**
	 * @see Player#setPileForThisTurn(Pile)
	 */

	public void setPileForThisTurn(Pile aPile) {
		this.thePile = aPile;

	}

	@Override
	/**
	 * @see Player#takeTurn(Pile)
	 */
	public void takeTurn() {

		this.thePile.removeSticks(this.sticksToTake);
	}

	@Override
	/**
	 * @see Player#setNumberSticksToTake()
	 */
	public void setNumberSticksToTake(int number) {
		this.sticksToTake = number;
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
		this.sticksToTake = 
				Math.min(this.thePile.getSticksLeft() - 1, Game.MAX_STICKS_PER_TURN);
	}

	@Override
	/**
	 * @see edu.westga.cs6910.nim.model.Player#getName()
	 */
	public String getName() {
		return this.name;
	}

	@Override	
	/**
	 * @see edu.westga.cs6910.nim.model.Player#getSticksOnThisTurn()
	 */

	public int getSticksOnThisTurn() {
		return this.sticksToTake;
	}
	
	@Override
	/**
	 * @see edu.westga.cs6910.nim.model.Player#getPileForThisTurn()
	 */

	public Pile getPileForThisTurn() {
		return this.thePile;
	}
}
