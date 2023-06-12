package edu.westga.cs6910.nim.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs6910.nim.model.HumanPlayer;
import edu.westga.cs6910.nim.model.Pile;

/**
 * This test method test the setNUmberSticksToTake method.
 * 
 * @author Deeksha Namani
 * @version 6/12/2023
 *
 */
public class HumanPlayerWhenSetNumberSticksToTake {
	private HumanPlayer testHumanPlayer;
	
	@BeforeEach
	public void setUp() throws Exception {
		 this.testHumanPlayer = new HumanPlayer("Deeksha");
	}
	
	 @Test
	    public void testShouldSetNumberSticksToTake() {
	        this.testHumanPlayer.setPileForThisTurn(new Pile(7));

	        this.testHumanPlayer.setNumberSticksToTake(3);

	        assertEquals(3, this.testHumanPlayer.getSticksOnThisTurn());
	    }

	    @Test
	    public void testShouldNotSetNumberSticksToTakeIfZero() {
	        this.testHumanPlayer.setPileForThisTurn(new Pile(7));
	        this.testHumanPlayer.setNumberSticksToTake(0);

	        assertEquals(0, this.testHumanPlayer.getSticksOnThisTurn());
	    }

	    @Test
	    public void testShouldSetNumberSticksToTakeToMaximumAllowed() {
	        this.testHumanPlayer.setPileForThisTurn(new Pile(7));
	        this.testHumanPlayer.setNumberSticksToTake(3);

	        assertEquals(3, this.testHumanPlayer.getSticksOnThisTurn());
	    }
	       
}

