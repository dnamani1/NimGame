package edu.westga.cs6910.nim.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs6910.nim.model.ComputerPlayer;
import edu.westga.cs6910.nim.model.Game;
import edu.westga.cs6910.nim.model.HumanPlayer;
import edu.westga.cs6910.nim.model.Player;

/**
 * This test class tests the isGameOver method of the Game class.
 * 
 * @author dnamani1
 */
public class GameWhenGetIsGameOver {

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
    public void testBeforeGameStartsIsNotOver() {
        assertEquals(false, this.theGame.isGameOver());
    }

    @Test
    public void testAfterRemovingAllButOneStickIsOver() {
        this.theGame.getPile().removeSticks(6);
        assertEquals(true, this.theGame.isGameOver());
    }

    @Test
    public void testAfterRemovingAllSticksIsOver() {
        this.theGame.getPile().removeSticks(7);
        assertEquals(true, this.theGame.isGameOver());
    }

}
