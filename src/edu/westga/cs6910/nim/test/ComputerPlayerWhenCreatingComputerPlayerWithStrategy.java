package edu.westga.cs6910.nim.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs6910.nim.model.ComputerPlayer;
import edu.westga.cs6910.nim.model.Game;
import edu.westga.cs6910.nim.model.Pile;
import edu.westga.cs6910.nim.model.strategy.CautiousStrategy;
import edu.westga.cs6910.nim.model.strategy.GreedyStrategy;
import edu.westga.cs6910.nim.model.strategy.NumberOfSticksStrategy;

/**
 * This class test the constructor of ComputerPlayer with parameter
 * 
 * @author Deeksha Namani
 * @version 6/18/2023
 */
public class ComputerPlayerWhenCreatingComputerPlayerWithStrategy {

	private ComputerPlayer cautiousPlayer;
	private ComputerPlayer greedyPlayer;

	@BeforeEach
	public void setUp() {
		NumberOfSticksStrategy cautiousStrategy = new CautiousStrategy();
		NumberOfSticksStrategy greedyStrategy = new GreedyStrategy();
		this.cautiousPlayer = new ComputerPlayer("Computer (Cautious)", cautiousStrategy);
		this.greedyPlayer = new ComputerPlayer("Computer (Greedy)", greedyStrategy);
		Pile pile = new Pile(10); 
		this.cautiousPlayer.setPileForThisTurn(pile);
		this.greedyPlayer.setPileForThisTurn(pile);
	}

	@Test
	public void testCautiousPlayerSetNumberSticksToTake() {
		this.cautiousPlayer.setNumberSticksToTake();

		assertEquals(1, this.cautiousPlayer.getSticksOnThisTurn());
	}

	@Test
	public void testGreedyPlayerSetNumberSticksToTake() {
		this.greedyPlayer.setNumberSticksToTake();

		assertEquals(Game.MAX_STICKS_PER_TURN, this.greedyPlayer.getSticksOnThisTurn());
	}

}
