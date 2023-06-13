package edu.westga.cs6910.nim.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs6910.nim.model.ComputerPlayer;
import edu.westga.cs6910.nim.model.Pile;

/**
 * This test class test the taketurn for ComputerPlayer.
 * 
 * @author Deeksha Namani
 * @version 6/13/2023
 */
public class ComputerPlayerWhenTakeTurn {
	private ComputerPlayer testComputerPlayer;
    private Pile testPile;

	@BeforeEach
	public void setUp() throws Exception {
		this.testComputerPlayer = new ComputerPlayer();
        this.testPile = new Pile(5);
        this.testComputerPlayer.setPileForThisTurn(this.testPile);
	}
	
	@Test
    public void testTakeTurnShouldRemoveOneStickFromPile() {
        this.testComputerPlayer.setNumberSticksToTake();
        this.testComputerPlayer.takeTurn();

        assertEquals(4, this.testPile.getSticksLeft());
    }
	
	@Test
    public void testTakeTurnShouldRemoveNoSticksIfNumberSticksToTakeIsZero() {
        this.testComputerPlayer.setNumberSticksToTake(0);
        this.testComputerPlayer.takeTurn();

        assertEquals(5, this.testPile.getSticksLeft());
    }
	
	@Test
    public void testTakeTurnShouldRemoveAllSticksFromPile() {
        this.testComputerPlayer.setNumberSticksToTake(5);
        this.testComputerPlayer.takeTurn();

        assertEquals(0, this.testPile.getSticksLeft());
    }

}
