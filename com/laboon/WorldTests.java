package com.laboon;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class WorldTests {
	Cell dead;
	Cell alive;
	
	@Before
	public void setUp() throws Exception {
		alive = mock(Cell.class);
		when(alive.getStateRep()).thenReturn('X');
		dead = mock(Cell.class);
		when(dead.getStateRep()).thenReturn('.');
	}

	/***
	 * For boards with more than 10 columns,
	 * the string representation should only index by single digit numbers
	 * (So after 9, indices should loop back to 0)
	 */
	@Test
	public void testNGreaterThanTen(){
		World bigWorld = new World(15, 42, 50);
		assertTrue(bigWorld.toString().contains("012345678901234"));
	}
	
	/***
	 * A board with all dead cells should contain not X's
	 */
	@Test
	public void testAllDead() {
		Cell[][] board = new Cell[3][3];
		fillBoard(board,dead);
		World deadWorld = new World(board, mock(Random.class)); 
		assertFalse(deadWorld.toString().contains("X"));
	}
	
	/***
	 * A board with all alive cells should contain not .'s
	 */
	@Test
	public void testAllAlive() {
		Cell[][] board = new Cell[3][3];
		fillBoard(board,alive);
		World livingWorld = new World(board, mock(Random.class)); 
		assertFalse(livingWorld.toString().contains("."));
	}

	private void fillBoard(Cell[][] board, Cell cell){
		for (int row = 0; row < board.length; row++ ){
			for (int col = 0; col < board.length; col++){
				board[row][col] = cell;
			}
		}
	}
	
	@After
	public void tearDown(){
		
	}
}