package edu.westga.cs6910.nim.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs6910.nim.model.ComputerPlayer;


/**
 * This test class test the getName for the ComputerPlayer
 * 
 * @author Deeksha Namani
 * @version 6/13/2023
 *
 */
public class ComputerPlayerWhenGetName {
	private ComputerPlayer testComputerPlayer;

	@BeforeEach
	public void setUp() throws Exception {
		this.testComputerPlayer = new ComputerPlayer();
	}
	
	@Test
    public void testShouldReturnPlayerName() {
        assertEquals("Simple computer", this.testComputerPlayer.getName());
    }

}
