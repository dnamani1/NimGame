package edu.westga.cs6910.nim.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs6910.nim.model.HumanPlayer;
import edu.westga.cs6910.nim.model.Pile;

/**
 * This test method test the HumanPlayer class method setPileFOrThisTurn method.
 * 
 * @author Deeksha Namani
 * @version 6/11/2023
 *
 */
public class HumanPlayerWhenSetPileForThisTurn {
	private HumanPlayer testHumanPlayer;
	
	@BeforeEach
	public void setUp() throws Exception {
		this.testHumanPlayer = new HumanPlayer("Deeksha");
	}
	
	@Test
	public void testShouldSetPileForThisTurn() {
		Pile thePile = new Pile(10);

		this.testHumanPlayer.setPileForThisTurn(thePile);

		assertEquals(thePile, this.testHumanPlayer.getPileForThisTurn());
	}



}
