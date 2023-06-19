package edu.westga.cs6910.nim.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs6910.nim.model.ComputerPlayer;
import edu.westga.cs6910.nim.model.strategy.CautiousStrategy;
import edu.westga.cs6910.nim.model.strategy.GreedyStrategy;
import edu.westga.cs6910.nim.model.strategy.NumberOfSticksStrategy;

/**
 * This class test the ComputerPlayer setStrategy method.
 * 
 * @author Deeksha Namani
 * @version 6/18/2023
 *
 */
public class ComputerPlayerWhenSetStrategy {

private ComputerPlayer testComputerPlayer;
	
	@BeforeEach
	public void setUp() {
		this.testComputerPlayer = new ComputerPlayer("Computer", null);
	}

	@Test
	public void testSetStrategyShouldChangeStrategyToCautiousStrategy() {
		NumberOfSticksStrategy newStrategy = new CautiousStrategy();
		this.testComputerPlayer.setStrategy(newStrategy);
		
		assertEquals(newStrategy, this.testComputerPlayer.getStrategy());
	}
	
	@Test
	public void testSetStrategyShouldSetGreedyStrategy() {
		NumberOfSticksStrategy greedyStrategy = new GreedyStrategy();

		this.testComputerPlayer.setStrategy(greedyStrategy);

		assertEquals(greedyStrategy, this.testComputerPlayer.getStrategy());
	}

}
