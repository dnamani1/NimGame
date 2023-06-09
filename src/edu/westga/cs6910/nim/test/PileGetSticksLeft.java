package edu.westga.cs6910.nim.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.nim.model.Pile;

/**
 * This test class is to test the getSticksLeft method of the Pile class.
 * 
 * @author Deeksha Namani
 * @version 6/9/2023
 *
 */
public class PileGetSticksLeft {

	@Test
	public void testWith1StickPileShouldHave1StickLeft() {
		Pile oneStickPile = new Pile(1);
		assertEquals(1, oneStickPile.getSticksLeft());
	}
	
	@Test
	public void testWith5StickPileShouldHave5StickLeft() {
		Pile fiveStickPile = new Pile(5);
		assertEquals(5, fiveStickPile.getSticksLeft());
	}
	
	@Test
	public void testWith10StickPileShouldHave10StickLeft() {
		Pile tenStickPile = new Pile(10);
		assertEquals(10, tenStickPile.getSticksLeft());
	}

}
