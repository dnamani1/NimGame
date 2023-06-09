package edu.westga.cs6910.nim.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.nim.model.Pile;

/**
 * This test class is to test the removeSticks method in the Pile class.
 * 
 * @author Deeksha Namani
 * @version 6/9/2023
 *
 */
public class PileWhenRemoveSticks {
	private Pile testPile;

	@BeforeEach
	public void setUp() throws Exception {
		this.testPile = new Pile(10);
	}
	
	@Test
	public void testRemove3SticksFrom10StickPileShouldHave7SticksLeft() {
		this.testPile.removeSticks(3);
		assertEquals(7, this.testPile.getSticksLeft());
	}

	@Test
	public void testRemove5SticksFrom10StickPileShouldHave5SticksLeft() {
		this.testPile.removeSticks(5);
		assertEquals(5, this.testPile.getSticksLeft());
	}

	@Test
	public void testRemove10SticksFrom10StickPileShouldHave0SticksLeft() {
		this.testPile.removeSticks(10);
		assertEquals(0, this.testPile.getSticksLeft());
	}
}
