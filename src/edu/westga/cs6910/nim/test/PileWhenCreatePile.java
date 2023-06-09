package edu.westga.cs6910.nim.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.nim.model.Pile;

/**
 * This test class is to test the constructor of the Pile class.
 * 
 * @author Deeksha Namani
 * @version 6/9/2023
 *
 */
public class PileWhenCreatePile {

	@Test
	public void testShouldProducePileWith1Stick() {
		Pile oneStickPile = new Pile(1);
		assertEquals("Pile size: 1", oneStickPile.toString());
	}
	
	@Test
	public void testShouldProducePileWith5Sticks() {
		Pile fiveStickPile = new Pile(5);
		assertEquals("Pile size: 5", fiveStickPile.toString());
	}
	
	@Test
	public void testShouldProducePileWith10Sticks() {
		Pile tenStickPile = new Pile(10);
		assertEquals("Pile size: 10", tenStickPile.toString());
	}

}
