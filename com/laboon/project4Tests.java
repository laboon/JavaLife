package com.laboon;

import static org.junit.Assert.*;
import org.junit.Test;

public class project4Tests{
	
	@Test
	public void blankTest(){ //A blank world of size zero shouldn't have anything but the original spaces and the new line.
		World w=new World(0,0,0);
		String s=w.toString();
		assertEquals(s,"  \n");
	}
	
	@Test
	public void elevenTest(){//It should wrap around, and the last number should be a zero again.
		World w=new World(11,0,0);
		String s=w.toString();
		assertEquals(s.substring(0,14),"  01234567890\n"); //Have to check for the new line, or else it could have more after the 0.
	}
	
	@Test
	public void numberLineTest(){//Make sure that the program outputs a number next to the row.
		World w=new World(12,0,0);
		String s=w.toString();
		assertEquals(s.charAt(15),'0'); //This should wrap around and be the first number, a 0.
	}//Since this world is 12x12 instead of 11x11, there is a buffer between the zero in the previous test and the char being checked here.
	
	@Test
	public void aliveTest(){ //Test when everything is alive; There should be no blank spaces (.)
		World w=new World(11,0,100);
		String s=w.toString();
		assertEquals(s.contains("."),false);
	}
	
	@Test
	public void deadTest(){ //Test that there's no X's on the board.
		World w=new World(11,0,0);
		String s=w.toString();
		assertEquals(s.contains("X"),false);
	}
	
	@Test
	public void randomMapTest(){ //Test that it "randomly" places in the correct spots.
		World w=new World(10,0,25);
		String s=w.toString();
		assertEquals(s,"  0123456789\n"
				+ "0 ....X...X.\n"
				+ "1 .........X\n"
				+ "2 ..X...X..X\n"
				+ "3 ....X.....\n"
				+ "4 ........X.\n"
				+ "5 X.X.XXX...\n"
				+ "6 ..X.XX.X.X\n"
				+ "7 .........X\n"
				+ "8 ..X.X...X.\n"
				+ "9 X..XXX.XX.\n");
	}
	
}