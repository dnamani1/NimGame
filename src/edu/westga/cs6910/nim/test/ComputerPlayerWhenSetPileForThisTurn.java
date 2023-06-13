package edu.westga.cs6910.nim.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs6910.nim.model.ComputerPlayer;
import edu.westga.cs6910.nim.model.Pile;

/**
 * This test class test the setPileForThisTurn method for computerPlayer.
 * 
 * @author Deeksha Namani
 * @version 6/13/2023
 *
 */
public class ComputerPlayerWhenSetPileForThisTurn {
	private ComputerPlayer testComputerPlayer;

	@BeforeEach
	public void setUp() throws Exception {
		this.testComputerPlayer= new ComputerPlayer();
	}
	
	@Test
	public void testShouldSetPileForThisTurn() {
		Pile thePile = new Pile(7);

		this.testComputerPlayer.setPileForThisTurn(thePile);

		assertEquals(thePile, this.testComputerPlayer.getPileForThisTurn());
	}
	
	@Test
	public void testSetPileForThisTurnShouldSetPileWithSticksLeftGreaterThan1() {
		Pile thePile = new Pile(3);

		this.testComputerPlayer.setPileForThisTurn(thePile);

		assertEquals(thePile, this.testComputerPlayer.getPileForThisTurn());
	}

	@Test
	public void testSetPileForThisTurnShouldNotSetPileWithSticksLeftEquals1() {
		Pile thePile = new Pile(1);

		this.testComputerPlayer.setPileForThisTurn(thePile);

		assertEquals(thePile, this.testComputerPlayer.getPileForThisTurn());
	}

}
