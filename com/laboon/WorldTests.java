package com.laboon;

import static org.junit.Assert.*;

import org.junit.Test;

public class WorldTests {

	@Test
	// Test printing a pretty standard world to a string
	public void standardWorldTest() {
		World testWorld = new World(20, 1, 20);
		String expected = "  01234567890123456789"+
							"\n0 ...X.X.X....X......."+
							"\n1 ..X......XX.XX......"+
							"\n2 X.......X.........X."+
							"\n3 X.....XX...XX.....X."+
							"\n4 ...X.....XX.....XX.."+
							"\n5 ......X.X..........."+
							"\n6 XX..X....X...X....X."+
							"\n7 ..X...........X...X."+
							"\n8 ...........X.......X"+
							"\n9 ...X...XX.....X..XX."+
							"\n0 .X..X..XX..........X"+
							"\n1 ...............X.X.."+
							"\n2 ...........XX....X.."+
							"\n3 .....X.X..X....XXX.."+
							"\n4 X...XX.....X........"+
							"\n5 .X.X.X...X.....XX..X"+
							"\n6 X....X....X..XX....."+
							"\n7 X...X..X..X.......X."+
							"\n8 ...X....X..X....X..."+
							"\n9 .....X.....X.X..X...";
		assert(testWorld.toString().equals(expected));
	}
	
	@Test
	// Test printing a tiny world (size = 1)
	public void tinyWorldTest() {
		World testWorld = new World(1, 1, 20);
		String expected = "  0"+
						  "\n0 .";
		assert(testWorld.toString().equals(expected));
	}
	
	@Test
	// Test printing a large world (size = 20)
	public void largeWorldTest() {
		World testWorld = new World(20, 1, 20);
		String expected =   "01234567890123456789"+
							"\n0 ...X.X.X....X......."+
							"\n1 ..X......XX.XX......"+
							"\n2 X.......X.........X."+
							"\n3 X.....XX...XX.....X."+
							"\n4 ...X.....XX.....XX.."+
							"\n5 ......X.X..........."+
							"\n6 XX..X....X...X....X."+
							"\n7 ..X...........X...X."+
							"\n8 ...........X.......X"+
							"\n9 ...X...XX.....X..XX."+
							"\n0 .X..X..XX..........X"+
							"\n1 ...............X.X.."+
							"\n2 ...........XX....X.."+
							"\n3 .....X.X..X....XXX.."+
							"\n4 X...XX.....X........"+
							"\n5 .X.X.X...X.....XX..X"+
							"\n6 X....X....X..XX....."+
							"\n7 X...X..X..X.......X."+
							"\n8 ...X....X..X....X..."+
							"\n9 .....X.....X.X..X...";
		assert(testWorld.toString().equals(expected));
	}
	
	@Test
	// Test printing an empty world (alive% = 0)
	public void emptyWorldTest() {
		World testWorld = new World(10, 1, 0);
		String expected = "  0123456789"+
							"\n0 .........."+
							"\n1 .........."+
							"\n2 .........."+
							"\n3 .........."+
							"\n4 .........."+
							"\n5 .........."+
							"\n6 .........."+
							"\n7 .........."+
							"\n8 .........."+
							"\n9 ..........";
		assert(testWorld.toString().equals(expected));
	}
	
	@Test
	// Test printing a super dense world (alive% = 100)
	public void denseWorldTest() {
		World testWorld = new World(10, 1 , 100);
		String expected = "  0123456789"+
							"\n0 XXXXXXXXXX"+
							"\n1 XXXXXXXXXX"+
							"\n2 XXXXXXXXXX"+
							"\n3 XXXXXXXXXX"+
							"\n4 XXXXXXXXXX"+
							"\n5 XXXXXXXXXX"+
							"\n6 XXXXXXXXXX"+
							"\n7 XXXXXXXXXX"+
							"\n8 XXXXXXXXXX"+
							"\n9 XXXXXXXXXX";
		assert(testWorld.toString().equals(expected));
		
	}

}
