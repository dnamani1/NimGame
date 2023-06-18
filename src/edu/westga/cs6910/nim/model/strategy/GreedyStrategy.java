package edu.westga.cs6910.nim.model.strategy;

/**
 * This class implements the greedy game-play strategy for the 1-Pile Nim game.
 * According to the game's rules, the player select largest number of sticks
 * possible. This class ensure that if this strategy can leave exactly 1. stick,
 * it will do so.
 * 
 * @author Deeksha Namani
 * @version 6/18/2023
 */
public class GreedyStrategy implements NumberOfSticksStrategy {

	/**
	 * Determines the number of sticks to take from the pile.
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
        
        int sticksToTake = pileSize - 1;
        
        if (sticksToTake == 1) {
            return 1;
        }
        
        return sticksToTake;
    }

}
