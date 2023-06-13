package edu.westga.cs6910.nim.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs6910.nim.model.ComputerPlayer;

/**
 * This test class test the ComputerPlayer constructor.
 * 
 * @author Deeksha Namani
 * @version 6/12/2023
 *
 */
public class ComputerPlayerWhenCreateComputerPlayer {
	private ComputerPlayer testComputerPlayer;

	@BeforeEach
	public void setUp() throws Exception {
		this.testComputerPlayer = new ComputerPlayer();
	}

	@Test
	public void testGetNameShouldReturnComputerPlayer() {
		String playerName = this.testComputerPlayer.getName();

		assertEquals("Simple computer", playerName);
	}

	@Test
	public void testGetSticksOnThisTurnShouldReturnZero() {
		int sticksOnThisTurn = this.testComputerPlayer.getSticksOnThisTurn();

		assertEquals(0, sticksOnThisTurn);
	}
}
