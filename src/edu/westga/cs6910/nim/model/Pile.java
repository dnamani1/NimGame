package edu.westga.cs6910.nim.model;

/**
 * A pile of sticks for playing Nim.
 * @author Deeksha Namani
 * @version 6/9/2023
 */
public class Pile {

	private int sticks;

	/**
	 * Creates a new Pile with the specified number of sticks.
	 * @param	sticks	The number of sticks in the Pile
	 * 
	 * @require sticks > 0
	 * @ensure sticksLeft() == sticks
	 */
	public Pile(int sticks) {
		this.sticks = sticks;
	}

	/**
	 * Reduces the number of sticks by the specified amount.
	 * @param	number	The number of sticks to be removed
	 * 
	 * @require number > 0 && number <= this.sticksLeft()
	 * @ensure this.sticksLeft() == sticksLeft() - number
	 */
	public void removeSticks(int number) {
		this.sticks -= number;
	}
	
	/**
	 * Returns the number of sticks remaining in this Pile.
	 * 
	 * @return the size of this Pile
	 */
	public int getSticksLeft() {
		return this.sticks;
	}
	
	/**
	 * Reset pile size to the initial size.
	 * @param initialSize of pile
	 */
	public void resetPile(int initialSize) {
        this.sticks = initialSize;
    }

	/**
	 * Returns a String representation of this Pile.
	 * 
	 * @return "Pile size: n", where n is the number of sticks in this Pile
	 */
	public String toString() {
		return "Pile size: " + this.sticks;
	}
}
