package edu.westga.cs6910.nim.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs6910.nim.model.ComputerPlayer;
import edu.westga.cs6910.nim.model.Game;
import edu.westga.cs6910.nim.model.HumanPlayer;
import edu.westga.cs6910.nim.model.Player;

/**
 * This test class test the getCurrentPlayer method of the Game class.
 * 
 * @author Deeksha Namani
 * @version 6/11/2023
 */
public class GameWhenGetCurrentPlayer {
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
	public void testGetCurrentPlayerReturnsHumanPlayerWhenGameStarts() {
		Player expected = this.humanPlayer;
		Player actual = this.theGame.getCurrentPlayer();

		assertEquals(expected, actual, "getCurrentPlayer should return the human player when the game starts");
	}
	
	@Test
    public void testGetCurrentPlayerReturnsHumanPlayerWithNameDeeksha() {
        Player actual = this.theGame.getCurrentPlayer();

        assertEquals("Deeksha", actual.getName(), "getCurrentPlayer should return the human player with the correct name");
    }
	
	@Test
	public void testGetCurrentPlayerReturnsComputerPlayerAfterSwapWhoseTurn() {
	    this.theGame.swapWhoseTurn();
	    Player expected = this.computerPlayer;
	    Player actual = this.theGame.getCurrentPlayer();

	    assertEquals(expected, actual, "getCurrentPlayer should return the computer player after calling swapWhoseTurn");
	}

}
