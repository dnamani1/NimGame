package edu.westga.cs6910.nim.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs6910.nim.model.HumanPlayer;
import edu.westga.cs6910.nim.model.Pile;

/**
 * This test class test the takTurn method for HumanPlayer.
 * 
 * @author Deeksha Namani
 * @version 6/12/2023
 *
 */
public class HumanPlayerWhenTakeTurn {
	private HumanPlayer testHumanPlayer;

	@BeforeEach
	public void setUp() throws Exception {
		this.testHumanPlayer = new HumanPlayer("Deeksha");
	}
	
	@Test
    public void testShouldRemoveSticksFromPile() {
        Pile pile = new Pile(5);
        this.testHumanPlayer.setPileForThisTurn(pile);
        this.testHumanPlayer.setNumberSticksToTake(3);

        this.testHumanPlayer.takeTurn();

        assertEquals(2, pile.getSticksLeft());
    }

	@Test
    public void stestShouldNotRemoveSticksIfNumberSticksToTakeIsZero() {
        Pile pile = new Pile(5);
        this.testHumanPlayer.setPileForThisTurn(pile);
        this.testHumanPlayer.setNumberSticksToTake(0);

        this.testHumanPlayer.takeTurn();

        assertEquals(0, this.testHumanPlayer.getSticksOnThisTurn());
        assertEquals(5, pile.getSticksLeft());
    }

	@Test
	public void testShouldUpdateSticksOnThisTurnAfterTakeTurn() {
	    Pile pile = new Pile(5);
	    this.testHumanPlayer.setPileForThisTurn(pile);
	    this.testHumanPlayer.setNumberSticksToTake(5);

	    this.testHumanPlayer.takeTurn();

	    assertEquals(5, this.testHumanPlayer.getSticksOnThisTurn());
	}
	

}
