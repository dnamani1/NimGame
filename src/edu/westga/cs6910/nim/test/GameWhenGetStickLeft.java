package edu.westga.cs6910.nim.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs6910.nim.model.ComputerPlayer;
import edu.westga.cs6910.nim.model.Game;
import edu.westga.cs6910.nim.model.HumanPlayer;
import edu.westga.cs6910.nim.model.Player;

/**
 * This test class test the getStickleft method of Game class.
 * 
 * @author Deeksha Namani
 * @version 6/11/2023
 *
 */
public class GameWhenGetStickLeft {
	private Game theGame;
	private Player humanPlayer;
	private Player computerPlayer;

	@BeforeEach
	public void setUp() throws Exception {
		this.humanPlayer = new HumanPlayer("Deeksha");
		this.computerPlayer = new ComputerPlayer();
		this.theGame = new Game((HumanPlayer) this.humanPlayer, (ComputerPlayer) this.computerPlayer);
		this.theGame.startNewGame(this.humanPlayer);
	}
	
	@Test
	public void testGetSticksLeftInNewGame() {
		int expected = Game.INITIAL_PILE_SIZE;
		int actual = this.theGame.getSticksLeft();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetSticksLeftAfterHumanPlayerTakesTurn() {
	    this.theGame.swapWhoseTurn();
	    this.humanPlayer.setPileForThisTurn(this.theGame.getPile());
	    this.humanPlayer.setNumberSticksToTake(1);
	    int expected = Game.INITIAL_PILE_SIZE - 1;
	    this.humanPlayer.takeTurn();
	    int actual = this.theGame.getSticksLeft();
	    
	    assertEquals(expected, actual);
	}

	    
	    @Test
	    public void testGetSticksLeftAfterComputerPlayerTakesTurn() {
	        this.theGame.swapWhoseTurn();
	        this.computerPlayer.setPileForThisTurn(this.theGame.getPile());
		    this.computerPlayer.setNumberSticksToTake(1);
	        int expected = Game.INITIAL_PILE_SIZE - 1;
	        this.computerPlayer.takeTurn();
	        int actual = this.theGame.getSticksLeft();
	        
	        assertEquals(expected, actual);
	    }

}
