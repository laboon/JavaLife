package com.laboon;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Random;

public class ToStringTest {

	World w;
	Random r;

	/*If a world of size zero is created, the toString() method
	 * should return a string of size 3, because it will not execute any
	 * of its for loops. Thus, the only characters in the string returned
	 * from the toString() method will be two (2) spaces and one (1) newline
	 * character.
	 */
	@Test
	public void testZeroLengthWorld() {
		w = new World(0, 2, 50);
		
		String testString = w.toString();
		
		assertEquals(testString.length(), 3);
	}
	
	/*Two worlds constructed with identical conditions should return
	 * strings of the same length upon invocation of their respective
	 * toString() methods. World size was limited to 200 maximum
	 * so as not to destroy my PC with a 999999 by 999999 world.
	 */
	@Test
	public void testStringLength() {
		
		r = new Random();
		
		int size = r.nextInt(200);
		int seed = r.nextInt(10);
		int pct = r.nextInt(100);
		
		w = new World(size, seed, pct);
		World w2 = new World(size, seed, pct);
		
		assertEquals(w.toString().length(), w2.toString().length());
		
	}
	
	/* Similar to the last test, to worlds constructed with identical
	 * conditions should return identical strings upon invocation of their
	 * respective toString() methods; this test checks the value of the strings
	 * rather than their length.
	 */
	@Test
	public void testStringValue() {
		r = new Random();
		
		int size = r.nextInt(200);
		int seed = r.nextInt(10);
		int pct = r.nextInt(100);
		
		w = new World(size, seed, pct);
		World w2 = new World(size, seed, pct);
		
		assertEquals(w.toString(), w2.toString());
	}
	
	/* Two worlds constructed with different sizes should never return
	 * strings of the same length when their respective toString() methods
	 * are invoked, even with all other conditions being equal.
	 * In this test, w can only have size 0-99 while w2 has a size between 100-200.
	 */
	@Test
	public void testDifferentSizes() {
		r = new Random();
		
		int size = r.nextInt(100);
		int size2 = size + 100;
		
		int seed = r.nextInt(10);
		int pct = r.nextInt(100);
		
		w = new World(size, seed, pct);
		World w2 = new World(size2, seed, pct);
		
		assertNotEquals(w.toString().length(), w2.toString().length());
	}
	
	/* A world created with proper arguments (positive integers) should
	 * never return a null when its toString() method is invoked.
	 */
	@Test
	public void testNotNull() {
		r = new Random();
		
		int size = r.nextInt(200);
		int seed = r.nextInt(10);
		int pct = r.nextInt(100);
		
		w = new World(size, seed, pct);
		
		assertNotNull(w.toString());
	}


}
