package com.laboon;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.containsString;

import org.junit.Test;

public class WorldTest {
	
	/* Tests that a world of small size generates the proper numbered header */
	@Test
	public void testSmallNumberedHeader() {
		World w = new World(8, 345432, 25);
		String expectedNumberedHeader = "01234567";
		
		assertThat(w.toString(), containsString(expectedNumberedHeader));
	}

	/* Make sure that a world of arbitrary size contains the proper header */
	@Test
	public void testNumberedHeader() {
		World w = new World(23, 587946, 25);
		String expectedNumberedHeader = "01234567890123456789012";
		
		assertThat(w.toString(), containsString(expectedNumberedHeader));
	}
	
	/* Make sure there are proper row numbers for small boards */
	@Test
	public void testRowNumbersSmall() {
		World w = new World(5, 4567891, 25);
		String[] worldStrings = w.toString().split("\n");
		
		for(int i = 1; i < worldStrings.length; i++) {
			String firstChar = worldStrings[i].substring(0, 1);
			assertEquals(i - 1, Integer.parseInt(firstChar));
		}
	}
	
	/* Make sure there are proper row numbers for large rows */
	@Test
	public void testRowNumbersLarge() {
		World w = new World(20, 4567891, 25);
		String[] worldStrings = w.toString().split("\n");
		
		for(int i = 1; i < worldStrings.length; i++) {
			String firstChar = worldStrings[i].substring(0, 1);
			int expectedNumber = (i - 1) % 10;
			int actualNumber = Integer.parseInt(firstChar);
			
			assertEquals(expectedNumber, actualNumber);
		}
	}
	
	/* Test to make sure a randomly sized small board is initially generated properly */
	@Test
	public void testSmallBoardFirstIteration() {
		World w = new World(5, 4567891, 25);
		String expectedOutput = "  01234\n"
								+ "0 ..X..\n"
								+ "1 .....\n"
								+ "2 ....X\n"
								+ "3 X..X.\n"
								+ "4 .....\n";
		
		assertEquals(w.toString(), expectedOutput);
	}
	
	/* Test to make sure a randomly sized large board is initially generated properly */
	@Test
	public void testLargeBoardFirstIteration() {
		World w = new World(20, 4567891, 23);
		String expectedOutput = "  01234567890123456789\n"
								+ "0 ..X...........XX....\n"
								+ "1 ........X..XXX..X.X.\n"
								+ "2 ..X....X............\n"
								+ "3 .X..........X.....X.\n"
								+ "4 X...X.X.XX...X......\n"
								+ "5 ..X.......X...X....X\n"
								+ "6 ......X..........XX.\n"
								+ "7 XX................X.\n"
								+ "8 ..XXXX..XX...X..X...\n"
								+ "9 .....X.XX.....X.....\n"
								+ "0 ......X...X...X..X.X\n"
								+ "1 .......XX.X.......X.\n"
								+ "2 ....X..X...XX.XX..XX\n"
								+ "3 .X.X.....X.X.....X..\n"
								+ "4 ..X...XXXX....X....X\n"
								+ "5 ..X....X..XX.......X\n"
								+ "6 .X..X..X.XX.XX..X.X.\n"
								+ "7 X....XX.X...........\n"
								+ "8 .XX.........XX.X....\n"
								+ "9 ......XX..X..X......\n";
		
		assertEquals(w.toString(), expectedOutput);
	}
	
	/* Make sure we output the correct board after iteration */
	@Test
	public void testIteratedBoard() {
		World w = new World(20, 4567891, 25);
		String expectedOutput = "  01234567890123456789\n"
								+ "0 ......X.........XX..\n"
								+ "1 ........XXX.....X...\n"
								+ "2 ..........X.........\n"
								+ "3 ........XX..X.......\n"
								+ "4 X......X...X.XX...XX\n"
								+ "5 .XX..XXXX........X..\n"
								+ "6 .XXXX..X...X.....X..\n"
								+ "7 .XXXXX...X.XX....XX.\n"
								+ "8 X...XX.............X\n"
								+ "9 ......X...X.........\n"
								+ "0 ..X.................\n"
								+ "1 ..XXX..XXX..........\n"
								+ "2 X....XXXX...........\n"
								+ "3 X....XX............X\n"
								+ "4 ...X.X..X...........\n"
								+ "5 X...X.X..X....XX...X\n"
								+ "6 ...XX........XX.XX..\n"
								+ "7 ...XXXX...XXX.XXXX..\n"
								+ "8 XX...X.X...X....XXXX\n"
								+ "9 XX...X.X.X..X...XXXX\n";
		
		for(int i = 0; i < 13; i++) {
			w = w.iterate();
		}
		
		assertEquals(w.toString(), expectedOutput);
	}
}
