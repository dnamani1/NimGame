package edu.westga.cs6910.nim.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs6910.nim.model.ComputerPlayer;
import edu.westga.cs6910.nim.model.Game;
import edu.westga.cs6910.nim.model.HumanPlayer;
import edu.westga.cs6910.nim.model.Player;

/**
 * This test class tests the getSticksLeft method of the Game class.
 * 
 * @author Deeksha Namani
 * @version 6/11/2023
 */
public class GameWhenGetStickLeft {
	private Game theGame;
	private Player humanPlayer;
	private Player computerPlayer;

	@BeforeEach
	public void setUp() throws Exception {
		this.humanPlayer = new HumanPlayer("Deeksha");
		this.computerPlayer = new ComputerPlayer();
		this.theGame = new Game((HumanPlayer) this.humanPlayer, (ComputerPlayer) this.computerPlayer, 7);
		this.theGame.startNewGame(this.humanPlayer, 7);
	}

	@Test
	public void testGetSticksLeftInNewGame() {
		int expected = 7;
		int actual = this.theGame.getSticksLeft();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetSticksLeftAfterHumanPlayerTakesTurn() {
	    this.humanPlayer.setPileForThisTurn(this.theGame.getPile());
	    this.humanPlayer.setNumberSticksToTake(1);
	    this.humanPlayer.takeTurn();
	    int expected = 6;
	    int actual = this.theGame.getSticksLeft();
	    
	    assertEquals(expected, actual);
	}

	@Test
	public void testGetSticksLeftAfterComputerPlayerTakesTurn() {
	    this.computerPlayer.setPileForThisTurn(this.theGame.getPile());
	    this.computerPlayer.setNumberSticksToTake(1);
	    this.computerPlayer.takeTurn();
	    int expected = 6;
	    int actual = this.theGame.getSticksLeft();
	    
	    assertEquals(expected, actual);
	}
}
