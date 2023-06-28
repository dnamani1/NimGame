package edu.westga.cs6910.nim.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        this.theGame = new Game((HumanPlayer) this.humanPlayer, (ComputerPlayer) this.computerPlayer, 7);
    }

    @Test
    public void testGetCurrentPlayerReturnsHumanPlayerWhenGameStarts() {
        this.theGame.startNewGame(this.humanPlayer, 7);
        Player expected = this.humanPlayer;
        Player actual = this.theGame.getCurrentPlayer();

        assertEquals(expected, actual);
    }

    @Test
    public void testGetCurrentPlayerReturnsHumanPlayerWithName() {
        this.theGame.startNewGame(this.humanPlayer, 7);
        Player actual = this.theGame.getCurrentPlayer();

        assertEquals("Deeksha", actual.getName());
    }

    @Test
    public void testGetCurrentPlayerReturnsComputerPlayerWhenStartNewGame() {
        this.theGame.startNewGame(this.computerPlayer, 7);
        Player expected = this.computerPlayer;
        Player actual = this.theGame.getCurrentPlayer();

        assertEquals(expected, actual);
    }

    @Test
    public void testGetCurrentPlayerReturnsComputerPlayerWithName() {
        this.theGame.startNewGame(this.computerPlayer, 7);
        Player actual = this.theGame.getCurrentPlayer();

        assertEquals("Simple computer", actual.getName());
    }

}
