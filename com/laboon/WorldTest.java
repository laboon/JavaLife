package com.laboon;

import static org.junit.Assert.*;

import org.junit.Test;

public class WorldTest {
	
	/*
	 * Tests that an empty world, when converted to a String,
	 * contains no living cells denoted with a "X".
	 */
	@Test
	public void testEmptyWorldString() {
		World emptyWorld = new World(10, 10, 0);
		
		String worldString = emptyWorld.toString();
		assertFalse("Living cell in empty world.", 
				worldString.contains("X"));
	}
	
	/*
	 * Tests that a full world, when converted to a String,
	 * contains no dead cells denoted with a ".".
	 */
	@Test
	public void testFullWorldString() {
		World emptyWorld = new World(10, 10, 100);
		
		String worldString = emptyWorld.toString();
		assertFalse("Dead cell in full world.", 
				worldString.contains("."));
	}
	
	/*
	 * Tests that the world size is correct. 
	 * That is, besides the line that labels the iteration, 
	 * the line length is always the size plus two, for the
	 * label characters at the line's beginning.
	 * The amount of lines should be the world size plus
	 * one, for the label line.
	 */
	@Test
	public void testWorldStringSize() {
		int worldSize = 15;
		World world = new World(worldSize, 10, 10);
		
		String worldString = world.toString();
		//Regex accounting for Unix or Windows style line endings
		String[] worldLines = worldString.split("\r\n|\n");
		assertEquals("Incorrect number of lines in world string.", 
				worldSize + 1, worldLines.length);
		for(String line: worldLines) {
			assertEquals("Incorrect line length in world string.", 
				worldSize + 2, line.length());
		}
	}
	
	/*
	 * Tests that there are a correct amount of spaces in the world.
	 */
	@Test
	public void testWorldSpacesAmount() {
		int worldSize = 20;
		World world = new World(worldSize, 5, 70);
		String worldString = world.toString();
		int count = 0;
		for(char cur: worldString.toCharArray()) {
			if(cur == 'X' | cur == '.') count++;
		}
		assertEquals("Incorrect amount of spaces in the world.",
				count, Math.pow(worldSize, 2), 0);
	}
}
