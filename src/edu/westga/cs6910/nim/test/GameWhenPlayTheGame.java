package edu.westga.cs6910.nim.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs6910.nim.model.ComputerPlayer;
import edu.westga.cs6910.nim.model.Game;
import edu.westga.cs6910.nim.model.HumanPlayer;
import edu.westga.cs6910.nim.model.Player;

/**
 * This test class test the play method of the game class
 * 
 * @author Deeksha Namani
 * @version 6/10/2023
 *
 */
class GameWhenPlayTheGame {
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
	public void testPlaySwapsCurrentPlayer() {
		Player previousPlayer = this.theGame.getCurrentPlayer();
		this.theGame.play();
		Player currentPlayer = this.theGame.getCurrentPlayer();

		Player expected = (previousPlayer == this.humanPlayer) ? this.computerPlayer : this.humanPlayer;

		assertEquals(expected, currentPlayer);
	}
	
	@Test
	public void testPlayUpdatesGameOverStateWhenSticksLeftIs1() {
	    this.theGame.getPile().removeSticks(6);
	    this.theGame.play();
	    
	    assertEquals(true, this.theGame.isGameOver());
	}


}
