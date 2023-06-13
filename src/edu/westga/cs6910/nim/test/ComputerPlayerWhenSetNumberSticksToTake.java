package edu.westga.cs6910.nim.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs6910.nim.model.ComputerPlayer;
import edu.westga.cs6910.nim.model.Pile;

/**
 * This test class test the Computer class method setNumberSticksToTake method.
 * 
 * @author Deeeksha Namani
 * @version 6/13/2023
 *
 */
public class ComputerPlayerWhenSetNumberSticksToTake {
	private ComputerPlayer testComputerPlayer;

	@BeforeEach
	public void setUp() throws Exception {
		this.testComputerPlayer = new ComputerPlayer();
	}
	
	 @Test
	    public void testShouldSetNumberSticksToTake() {
	        this.testComputerPlayer.setPileForThisTurn(new Pile(7));

	        this.testComputerPlayer.setNumberSticksToTake(3);

	        assertEquals(3, this.testComputerPlayer.getSticksOnThisTurn());
	    }

	    @Test
	    public void testShouldNotSetNumberSticksToTakeIfZero() {
	        this.testComputerPlayer.setPileForThisTurn(new Pile(7));
	        this.testComputerPlayer.setNumberSticksToTake(0);

	        assertEquals(0, this.testComputerPlayer.getSticksOnThisTurn());
	    }

	    @Test
	    public void testShouldSetNumberSticksToTakeToMaximumAllowed() {
	        this.testComputerPlayer.setPileForThisTurn(new Pile(7));
	        this.testComputerPlayer.setNumberSticksToTake(3);

	        assertEquals(3, this.testComputerPlayer.getSticksOnThisTurn());
	    }


}
      