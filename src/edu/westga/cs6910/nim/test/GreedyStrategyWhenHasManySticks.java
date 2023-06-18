package edu.westga.cs6910.nim.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs6910.nim.model.Game;
import edu.westga.cs6910.nim.model.strategy.GreedyStrategy;

/**
 * This test class test GreedyStategy method.
 * 
 * @author Deeksha Namani
 * @version 6/18/2023
 *
 */
public class GreedyStrategyWhenHasManySticks {
	private GreedyStrategy testStrategy;

	@BeforeEach
	public void setUp() throws Exception {
		this.testStrategy = new GreedyStrategy();
	}

	@Test
    public void testHowManySticks_WithPileSize1_Returns1() {
        int pileSize = 1;
        int expected = 1;
        
        int result = this.testStrategy.howManySticks(pileSize);
        
        assertEquals(expected, result);
    }
    
	 @Test
	    public void shouldReturnMaxSticksWhenPileSizeIsGreaterThanMaxSticks() {
	        int pileSize = 7;
	        int expected = Game.MAX_STICKS_PER_TURN;
	        
	        int result = this.testStrategy.howManySticks(pileSize);
	        
	        assertEquals(expected, result);
	    }

	    @Test
	    public void shouldReturnPileSizeWhenPileSizeIsLessThanOrEqualToMaxSticks() {
	        int pileSize = 5;
	        int expected = 3;

	        int result = this.testStrategy.howManySticks(pileSize);

	        assertEquals(expected, result);
	    }

}
