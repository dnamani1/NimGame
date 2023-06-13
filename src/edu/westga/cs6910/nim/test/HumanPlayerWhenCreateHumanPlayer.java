package edu.westga.cs6910.nim.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs6910.nim.model.HumanPlayer;

/**
 * This test class test the constructor of the HumanPlayer class.
 * 
 * @author Deeksha Namani
 * @version 6/12/2023
 *
 */
public class HumanPlayerWhenCreateHumanPlayer {
	private HumanPlayer testHumanPlayer;

	@BeforeEach
	public void setUp() throws Exception {
		this.testHumanPlayer = new HumanPlayer("Deeksha");
	}
	
	@Test
    public void testShouldSetNameWhenCreatingHumanPlayer() {
        assertEquals("Deeksha", this.testHumanPlayer.getName());
    }

    @Test
    public void testShouldSetSticksOnThisTurnToZeroWhenCreatingHumanPlayer() {
        assertEquals(0, this.testHumanPlayer.getSticksOnThisTurn());
    }


}
