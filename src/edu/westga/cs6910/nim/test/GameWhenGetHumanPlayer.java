package edu.westga.cs6910.nim.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs6910.nim.model.ComputerPlayer;
import edu.westga.cs6910.nim.model.Game;
import edu.westga.cs6910.nim.model.HumanPlayer;
import edu.westga.cs6910.nim.model.Player;

/**
 * This test method test the getHumanPlayer method in Game class.
 * 
 * @author Deeksha Namani
 * @version 6/11/2023
 *
 */
public class GameWhenGetHumanPlayer {
	private Game theGame;
	private Player humanPlayer;
	private Player computerPlayer;

	@BeforeEach
	public void setUp() throws Exception {
		this.humanPlayer = new HumanPlayer("Deeksha");
		this.computerPlayer = new ComputerPlayer();
		this.theGame = new Game((HumanPlayer) this.humanPlayer, (ComputerPlayer) this.computerPlayer);
	}
	
	@Test
    public void testShouldReturnsHumanPlayer() {
        Player expected = this.humanPlayer;
        Player actual = this.theGame.getHumanPlayer();

        assertEquals(expected, actual);
    }
	
	@Test
    public void testShouldReturnsHumanPlayerWithNameDeeksha() {
        Player actual = this.theGame.getHumanPlayer();

        assertEquals("Deeksha", actual.getName());
    }

	 @Test
	    public void testShouldReturnSameAfterStartNewGameForGetHumanPlayers() {
	        this.theGame.startNewGame(this.humanPlayer);
	        Player expected = this.humanPlayer;
	        Player actual = this.theGame.getHumanPlayer();

	        assertEquals(expected, actual);
	    }

}
