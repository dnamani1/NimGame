package edu.westga.cs6910.nim.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs6910.nim.model.ComputerPlayer;
import edu.westga.cs6910.nim.model.Game;
import edu.westga.cs6910.nim.model.HumanPlayer;
import edu.westga.cs6910.nim.model.Player;

/**
 * This test class tests the getHumanPlayer method of the Game class.
 * 
 * @author Deeksha Namani
 * @version 6/11/2023
 */
public class GameWhenGetHumanPlayer {
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
    public void testShouldReturnHumanPlayer() {
        Player expected = this.humanPlayer;
        Player actual = this.theGame.getHumanPlayer();

        assertEquals(expected, actual);
    }

    @Test
    public void testShouldReturnHumanPlayerWithNameDeeksha() {
        Player actual = this.theGame.getHumanPlayer();

        assertEquals("Deeksha", actual.getName());
    }

    @Test
    public void testShouldReturnSameAfterStartNewGameForGetHumanPlayer() {
        this.theGame.startNewGame(this.humanPlayer, 7);
        Player expected = this.humanPlayer;
        Player actual = this.theGame.getHumanPlayer();

        assertEquals(expected, actual);
    }

}
