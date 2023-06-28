package edu.westga.cs6910.nim.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs6910.nim.model.ComputerPlayer;
import edu.westga.cs6910.nim.model.Game;
import edu.westga.cs6910.nim.model.HumanPlayer;
import edu.westga.cs6910.nim.model.Pile;

/**
 * This test class tests the getPile method of the Game class.
 * 
 * @author Deeksha Namani
 * @version 6/11/2023
 */
public class GameWhenGetPile {
    private Game theGame;
    private HumanPlayer humanPlayer;
    private ComputerPlayer computerPlayer;

    @BeforeEach
    public void setUp() throws Exception {
        this.humanPlayer = new HumanPlayer("Deeksha");
        this.computerPlayer = new ComputerPlayer();
        this.theGame = new Game(this.humanPlayer, this.computerPlayer, 10);
    }

    @Test
    public void testGetPileReturnsInitializedPile() {
        Pile thePile = this.theGame.getPile();
        assertEquals(10, thePile.getSticksLeft());
    }

    @Test
    public void testGetPileAfterGameStartReturnsNewPile() {
        this.theGame.startNewGame(this.humanPlayer, 10);
        Pile thePile = this.theGame.getPile();

        assertEquals(10, thePile.getSticksLeft());
    }

}
