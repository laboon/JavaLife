package com.laboon;

import static org.junit.Assert.*;

import org.junit.*;

public class WorldTest {
	
	//Tests what toString returns when you create an empty world
	@Test
	public void EmptyWorldTest(){
		World emptyWorld = new World(0, 3, 25);
		assertEquals(emptyWorld.toString(), "  \n");
	}
	
	//Tests a 10 x 10 world for correctly sized string representation
	@Test
	public void SmallWorldLengthTest(){
		int size = 10;
		World newWorld = new World(size, 3, 25);
		String worldString = newWorld.toString();
		assertEquals(worldString.length(), ((size + 1) * (size + 3)));
		//Add 1 to first side of expression to count the first row, which is just numbers
		//Add 3 to second side to count the newline and the displayed row numbers
	}
	
	//Tests a 100 x 100 world for correctly sized string representation
	@Test
	public void MediumWorldLengthTest(){
		int size = 100;
		World newWorld = new World(size, 3, 25);
		String worldString = newWorld.toString();
		assertEquals(worldString.length(), ((size + 1) * (size + 3)));
		//Add 1 to first side of expression to count the first row, which is just numbers
		//Add 3 to second side to count the newline and the displayed row numbers
	}
	
	//Tests a world that is MAX_INT by MAX_INT
	//Should not be allowed to do that
	@Test(expected=OutOfMemoryError.class)
	public void GiantWorldLengthTest(){
		int size = Integer.MAX_VALUE;
		World newWorld = new World(size, 3, 25);
		String worldString = newWorld.toString();
		assertEquals(worldString.length(), ((size + 1) * (size + 3)));
	}
}
