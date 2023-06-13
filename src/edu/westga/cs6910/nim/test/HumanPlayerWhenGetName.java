package edu.westga.cs6910.nim.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs6910.nim.model.HumanPlayer;

/**
 * This test class test the getName of the HumanPlayer.
 * 
 * @author Deeksha Namani
 * @version 6/12/2023
 *
 */
public class HumanPlayerWhenGetName {
	private HumanPlayer testHumanPlayer;

	@BeforeEach
	public void setUp() throws Exception {
		this.testHumanPlayer = new HumanPlayer("Deeksha");
	}
	
	@Test
    public void testShouldReturnPlayerName() {
        assertEquals("Deeksha", this.testHumanPlayer.getName());
    }

    @Test
    public void testShouldReturnUpdatedPlayerName() {
        this.testHumanPlayer = new HumanPlayer("Akshay");

        assertEquals("Akshay", this.testHumanPlayer.getName());
    }

    @Test
    public void testShouldReturnEmptyStringForEmptyName() {
        this.testHumanPlayer = new HumanPlayer("");

        assertEquals("", this.testHumanPlayer.getName());
    }


}
