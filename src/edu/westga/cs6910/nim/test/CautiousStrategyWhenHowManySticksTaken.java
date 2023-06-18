package edu.westga.cs6910.nim.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs6910.nim.model.strategy.CautiousStrategy;
import edu.westga.cs6910.nim.model.strategy.NumberOfSticksStrategy;

/**
 * This class test the CautionStrategy class method howManySticks.
 * 
 * @author Deeksha Namani
 * @version 6/18/2023
 *
 */
public class CautiousStrategyWhenHowManySticksTaken {
	private NumberOfSticksStrategy testStrategy;

	@BeforeEach
	public void setUp() throws Exception {
		this.testStrategy = new CautiousStrategy();
	}

	@Test
	public void testHowManySticksWithPileSize1() {
		int pileSize = 1;
		int expectedSticksToTake = 1;
		int actualSticksToTake = this.testStrategy.howManySticks(pileSize);
		assertEquals(expectedSticksToTake, actualSticksToTake);
	}

	@Test
	public void testHowManySticksWithPileSize5() {
		int pileSize = 5;
		int expectedSticksToTake = 1;
		int actualSticksToTake = this.testStrategy.howManySticks(pileSize);
		assertEquals(expectedSticksToTake, actualSticksToTake);
	}
	
	@Test
	public void testHowManySticksWithPileSize10() {
		int pileSize = 10;
		int expectedSticksToTake = 1;
		int actualSticksToTake = this.testStrategy.howManySticks(pileSize);
		assertEquals(expectedSticksToTake, actualSticksToTake);
	}

}
