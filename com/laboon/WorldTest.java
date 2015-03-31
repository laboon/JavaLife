package com.laboon;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class WorldTest {

	
	// Test the initial world seeded at 10
	@Test
	public void testInitialWorld() {
		
		World initial = new World(5, 10, 50);
		
		String stringifiedWorld = initial.toString();
		assertEquals(" 01234\n0 X...X\n1 ....X\n2 X..X.\n3 ....X\n4 .X.XX\n", stringifiedWorld);
	}
	
	// CORNER CASE: tests a world that has a negative size
	// exception should be NegativeArraySizeException thrown 
	@Test(expected=NegativeArraySizeException.class)
	public void testNegativeWorld() {
		
		World negativeWorld = new World(-1, 10, 50);
		String stringifiedNegWorld = negativeWorld.toString();
		
	}
	
	// EDGE CASE: tests to make sure the Cell is filled  
	// with X's to create a world that is alive and well
	@Test
	public void testAliveWorld() {
		
		Cell alive = mock(Cell.class);
		when(alive.getStateRep()).thenReturn('X');
		
		Cell[][] aliveCell = new Cell[2][2];
		World aliveWorld = new World(aliveCell, new Random(6));
		
		// filling the aliveWorld with all 'X'
		for (int i = 0; i < aliveCell.length; i++) {
			for (int j = 0; j < aliveCell.length; j++) {
				aliveCell[i][j] = alive;
			}
		}
		
		String checkWorld = aliveWorld.toString();
		assertFalse(checkWorld.contains("."));
	}
	
	@Test
	// EDGE CASE: tests to make sure the world is filled 
	// with .'s to to create a dead world
	public void testDeadWorld() {
		
		Cell dead = mock(Cell.class);
		when(dead.getStateRep()).thenReturn('.');
		
		Cell[][] deadCell = new Cell[2][2];
		World aliveWorld = new World(deadCell, new Random(6));
		
		// filling the aliveWorld with all 'X'
		for (int i = 0; i < deadCell.length; i++) {
			for (int j = 0; j < deadCell.length; j++) {
				deadCell[i][j] = dead;
			}
		}
		
		String checkWorld = aliveWorld.toString();
		assertFalse(checkWorld.contains("X"));
	}
	
	// test to see if the world contains the size string when a new 
	// world is created
	@Test
	public void testSizeStringInWorld() {
		
		World world = new World(25, 2, 15);
		String stringifiedWorld = world.toString();
		assertTrue(stringifiedWorld.contains("0123456789012345678901234"));
	}
	
	// test the number of X's and .' in a mixed World where the last
	// row is dead and the rest of the world is alive
	@Test
	public void deadAndAliveWorld() {
		
		int cellSize = 9;
		
		Cell alive = mock(Cell.class);
		when(alive.getStateRep()).thenReturn('X');
		
		Cell dead = mock(Cell.class);
		when(dead.getStateRep()).thenReturn('.');
		
		Cell[][] mixedCell = new Cell[cellSize][cellSize];
		World mixedWorld = new World(mixedCell, new Random(6));
		
		int aliveCount = 0;
		int deadCount = 0;
		// filling the mixedWorld with X's and .'s
		for (int i = 0; i < mixedCell.length; i++) {
			for (int j = 0; j < mixedCell.length; j++) {
				if (i < mixedCell.length-1) {
					mixedCell[i][j] = alive;
					aliveCount++;
				} else {
					mixedCell[i][j] = dead;
					deadCount++;
				}
			}
		}
		
		assertEquals(cellSize*(cellSize-1), aliveCount);
		assertEquals(cellSize, deadCount);
	}
}
