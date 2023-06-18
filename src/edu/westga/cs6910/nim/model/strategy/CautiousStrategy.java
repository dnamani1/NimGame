package edu.westga.cs6910.nim.model.strategy;

/**
 * This class is to implement the game-play strategy that always returns 1 as the
 * number of sticks to be taken from the Pile. 
 * @author Deeksha Namani
 * @version 6/18/2023
 */
public class CautiousStrategy implements NumberOfSticksStrategy {

	/**
	 * This method determine the number of sticks to take from the pile.
	 * 
	 * @param pileSize the size of the pile.
	 * @precondition pileSize > 0
	 * @return the number of sticks to take from the pile.
	 */
	@Override
	public int howManySticks(int pileSize) {
		if (pileSize <= 0) {
            throw new IllegalArgumentException("Pile size must be greater than 0");
        }
		return 1;
	}

}
