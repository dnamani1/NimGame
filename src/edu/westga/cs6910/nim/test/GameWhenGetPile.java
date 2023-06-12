package edu.westga.cs6910.nim.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs6910.nim.model.ComputerPlayer;
import edu.westga.cs6910.nim.model.Game;
import edu.westga.cs6910.nim.model.HumanPlayer;
import edu.westga.cs6910.nim.model.Pile;

/**
 * This test class test the getPile method of Game class.
 * 
 * @author Deeksha Namani
 * @version 6/11/2023
 *
 */
public class GameWhenGetPile {
	private Game theGame;
    private HumanPlayer humanPlayer;
    private ComputerPlayer computerPlayer;

	@BeforeEach
	public void setUp() throws Exception {
		this.humanPlayer = new HumanPlayer("Deeksha");
		this.computerPlayer = new ComputerPlayer();
		this.theGame = new Game((HumanPlayer) this.humanPlayer, (ComputerPlayer) this.computerPlayer);
	}

	@Test
	public void testGetPileReturnsInitializedPile() {
		Pile thePile = this.theGame.getPile();
		assertEquals(Game.INITIAL_PILE_SIZE, thePile.getSticksLeft());
	}
	
	@Test
	public void testGetPileAfterGameStartReturnsNewPile() {
		this.theGame.startNewGame(this.humanPlayer);
		Pile thePile = this.theGame.getPile();

		assertEquals(Game.INITIAL_PILE_SIZE, thePile.getSticksLeft());
	}
	
	@Test
    public void testGetPileReturnsUpdatedPileAfterPlayerTakesTurn() {
        Pile initialPile = this.theGame.getPile();
        this.theGame.startNewGame(this.humanPlayer);
        this.theGame.play();
        Pile updatedPile = this.theGame.getPile();
        assertNotSame(initialPile, updatedPile);
    }

}
