package com.laboon;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.Random;

public class WorldTest {

	//Testing a world with a size of 0 to see if the toString method produces the appropriate output.
	@Test
	public void testZeroSize() {
		World example = new World(0, 10, 50);
		String actual = example.toString();
		assertEquals("  \n", actual);
	}
	
	//Testing the world using the same seed which will make the sequence of random numbers the same from
	//run to run which will allow to test that output
	@Test
	public void testSeededWorld(){
		World example = new World (4, 10, 50);
		String actual = example.toString();
		String expected = "  0123\n0 X...\n1 X...\n2 .XX.\n3 .X..\n";
		assertTrue(expected.equals(actual));
	}
	
	//Creating a world of size 2 and using the String split method to split it around white space
	//the length of the split array should always be 5 regardless of the refactoring of toString
	@Test
	public void testSplit(){
		World example = new World (2, 10, 50);
		String result = example.toString();
		String [] splitResult = result.split(" ");
		assertEquals(5, splitResult.length);
	}
	
	//Testing the toString of a world where the percent of alive cells is 100%
	@Test
	public void testAliveWorld(){
		World example = new World (5, 10, 100);
		String actual = example.toString();
		String expected = "  01234\n0 XXXXX\n1 XXXXX\n2 XXXXX\n3 XXXXX\n4 XXXXX\n";
		assertEquals(expected, actual);
	}
	
	//Testing the toString of a fully dead world where everything should be a .
	@Test
	public void testDeadWorld(){
		World example = new World (5, 10, 0);
		String actual = example.toString();
		String expected = "  01234\n0 .....\n1 .....\n2 .....\n3 .....\n4 .....\n";
		assertEquals(expected, actual);
	}
	
	//Testing the toString on a world where the cell rows are alternating between dead or alive using
	//Mockito to mock away the Cell objects
	@Test
	public void testAlternatingWorld(){
		Cell living = Mockito.mock(Cell.class);
		when(living.getStateRep()).thenReturn('X');
		
		Cell dead = Mockito.mock(Cell.class);
		when(dead.getStateRep()).thenReturn('.');
		
		Cell[][] cells = new Cell [5][5];
		for (int i = 0; i < 5; i++){
			int remainder = i % 2;
			for (int j = 0; j < 5; j++){
				if (remainder == 0){
					cells[i][j] = dead;
				}
				else{
					cells[i][j] = living;
				}
			}	
		}
		
		World example = new World (cells, new Random(50));	
		String actual = example.toString();
		String expected = "  01234\n0 .....\n1 XXXXX\n2 .....\n3 XXXXX\n4 .....\n";
		assertEquals(expected, actual);
	}
}
