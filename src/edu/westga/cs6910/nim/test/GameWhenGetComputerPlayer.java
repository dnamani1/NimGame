package edu.westga.cs6910.nim.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs6910.nim.model.ComputerPlayer;
import edu.westga.cs6910.nim.model.Game;
import edu.westga.cs6910.nim.model.HumanPlayer;
import edu.westga.cs6910.nim.model.Player;

/**
 * This test method test the getComputerPlayer for the game class.
 * 
 * @author Deeksha Namani
 * @version 6/11/2023
 *
 */
public class GameWhenGetComputerPlayer {

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
	public void testShouldReturnsComputerPlayer() {
		Player expected = this.computerPlayer;
		Player actual = this.theGame.getComputerPlayer();

		assertEquals(expected, actual);
	}

	@Test
	public void testShouldReturnsComputerPlayerWithName() {
		Player actual = this.theGame.getComputerPlayer();

		assertEquals("Simple computer", actual.getName());
	}

	@Test
	public void testShouldReturnSameAfterStartNewGameForGetComputerPlayers() {
		this.theGame.startNewGame(this.computerPlayer);
		Player expected = this.computerPlayer;
		Player actual = this.theGame.getComputerPlayer();

		assertEquals(expected, actual);
	}

}
