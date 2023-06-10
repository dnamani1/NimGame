package edu.westga.cs6910.nim.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs6910.nim.model.ComputerPlayer;
import edu.westga.cs6910.nim.model.Game;
import edu.westga.cs6910.nim.model.HumanPlayer;
import edu.westga.cs6910.nim.model.Player;

/**
 * This test class test the Game class constructor using toString.
 * 
 * @author Deeksha Namani
 * @version 6/10/2023
 *
 */
public class GameWhenCreateGame {
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
    public void testShouldSetHumanPlayer() {
        assertEquals(this.humanPlayer, this.theGame.getHumanPlayer());
    }
    
    @Test
    public void testShouldSetComputerPlayer() {
        assertEquals(this.computerPlayer, this.theGame.getComputerPlayer());
    }
    
    @Test
    public void testShouldSetInitialPileSize() {
        assertEquals(Game.INITIAL_PILE_SIZE, this.theGame.getSticksLeft());
    }
    
    @Test
    public void testShouldSetMaxSticksPerTurn() {    
        assertEquals(3, Game.MAX_STICKS_PER_TURN);
    }
    
    @Test
    public void testShouldSetCurrentPlayerToHumanPlayer() {
        this.theGame.startNewGame(this.humanPlayer);
        
        assertEquals(this.humanPlayer, this.theGame.getCurrentPlayer());
    }
    
    @Test
    public void testShouldSetCurrentPlayerToComputerPlayer() {
        this.theGame.startNewGame(this.computerPlayer);
        
        assertEquals(this.computerPlayer, this.theGame.getCurrentPlayer());
    }

	@Test
    public void testShouldReturnCorrectStringRepresentation() {
        String expected = " Pile size: " + Game.INITIAL_PILE_SIZE;
        String actual = this.theGame.toString();
        
        assertEquals(expected, actual);
    }

}
