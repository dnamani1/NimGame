package edu.westga.cs6910.nim.model.strategy;

import edu.westga.cs6910.nim.model.Game;

/**
 * Implementing this class such that it randomly chooses (with equal likelihood)
 * the number of sticks selected, according to the game's rules.
 * 
 * @author dnamani1
 * @version 6/18/2023
 */
public class RandomStrategy implements NumberOfSticksStrategy {

	/**
	 * Determines the number of sticks to take from the pile according to pile size.
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

		if (pileSize == 1) {
			return 1;
		}

		int maxSticks = Math.min(pileSize, Game.MAX_STICKS_PER_TURN);
		int randomSticks = (int) (Math.random() * maxSticks) + 1;

		if (randomSticks == pileSize && randomSticks > 1) {
			return randomSticks - 1;
		}

		return randomSticks;
	}

}
