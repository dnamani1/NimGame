package edu.westga.cs6910.nim.model.strategy;

/**
 * This class defines the common interface for all game-play algorithms for the
 * 1-Pile version of Nim.
 * 
 * @author Deeksha Namani
 * @version 6/18/2023
 */
public interface NumberOfSticksStrategy {

	/**
	 * This method determine the number of sticks to take from the pile.
	 * 
	 * @param pileSize the size of the pile.
	 * @precondition pileSize > 0
	 * @return the number of sticks to take from the pile.
	 */
	int howManySticks(int pileSize);
}
