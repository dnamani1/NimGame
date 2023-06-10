package edu.westga.cs6910.nim.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs6910.nim.model.ComputerPlayer;
import edu.westga.cs6910.nim.model.Game;
import edu.westga.cs6910.nim.model.HumanPlayer;
import edu.westga.cs6910.nim.model.Player;

/**
 * This test class test the startNewGame method in Game class.
 * 
 * @author Deeksha Namani
 * @version 6/10/2023
 *
 */
class GameWhenStartNewGame {
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
    public void testStartNewGameSetCorrectFirstPlayer() {
        this.theGame.startNewGame(this.humanPlayer);
        
        assertEquals(this.humanPlayer,this.theGame.getCurrentPlayer());
    }
	
	@Test
    public void testStartNewGameResetsPileSizeToInitialValue() {
        this.theGame.getPile().removeSticks(3);
        this.theGame.startNewGame(this.humanPlayer);

        assertEquals(Game.INITIAL_PILE_SIZE, this.theGame.getSticksLeft());
    }
	
	@Test
    public void testStartNewGameChangesCurrentPlayer() {
        this.theGame.startNewGame(this.computerPlayer);

        assertEquals(this.computerPlayer, this.theGame.getCurrentPlayer());
    }
	
	@Test
	public void testStartNewGameResetsGameOverState() {
	    this.theGame.getPile().removeSticks(1);
	    this.theGame.startNewGame(humanPlayer);
	    
	    assertEquals(false, this.theGame.isGameOver());
	}

}
