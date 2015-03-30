/*
 * Shelley Goldberg sag109@pitt.edu
 * Unit tests for World.toString()
 */

package com.laboon;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import java.util.Random;

public class toStringTest {

	
	@Mock
	Cell mockLive= Mockito.mock(Cell.class);
	Cell mockDead= Mockito.mock(Cell.class);
	Random mockRand= Mockito.mock(Random.class);
	
	Cell[][] test_world;//fill on a case by case basis
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(mockLive);
		MockitoAnnotations.initMocks(mockRand);	
	}
	
	/*
	 * helper method for making a world of all same state or alternating
	 */
	public Cell[][] makeWorld(int size, boolean alt, Cell mainCell)
	{
		test_world= new Cell[size][size];
		for(int i=0; i<size; i++){
			for(int j=0; j<size; j++){
				if(alt && (j%2)==0)
				{
					test_world[i][j] = mockDead;
				}
				else
				test_world[i][j] = mainCell;
			}
		}
		return test_world;
	}
	/*
	 * helper method to count the occurrences of a character in a String
	 */
	public int countChar(String s,char c){
		int count=0;
		for(int i=0; i<s.length(); i++)
		{
			if(s.charAt(i)==c)
				count++;
		}
		
		return count;
	}
	@Test
	/*
	 * tests exact output of 4x4 board of all dead
	 */
	public void testFourLive() {
		int size = 4;
		test_world= makeWorld(size,false, mockLive);
		World board = new World(test_world, mockRand);
		Mockito.doReturn('X').when(mockLive).getStateRep();
		String compare = "  0123\n0 XXXX\n1 XXXX\n2 XXXX\n3 XXXX\n";
		String boardStr= board.toString();
		
		assertEquals(boardStr, compare);
	}
	@Test
	/*
	 * tests exact output of 4x4 board of all live
	 */
	public void testFourDead() {
		int size = 4;
		test_world= makeWorld(size,false, mockDead);
		World board = new World(test_world, mockRand);
		Mockito.doReturn('.').when(mockDead).getStateRep();
		String compare = "  0123\n0 ....\n1 ....\n2 ....\n3 ....\n";
		String boardStr= board.toString();
		
		assertEquals(boardStr, compare);
	}
	
	@Test
	/*
	 * tests that X and . occur equally in 4x4 board of half live half dead
	 */
	public void testFourAlt(){
		int size = 4;
		test_world= makeWorld(size,true, mockLive);
		World board = new World(test_world, mockRand);
		Mockito.doReturn('.').when(mockDead).getStateRep();
		Mockito.doReturn('X').when(mockLive).getStateRep();
		String boardStr = board.toString();
		int DeadCount = countChar(boardStr, '.');
		int LiveCount = countChar(boardStr, 'X');
		assertEquals(DeadCount, LiveCount);
	}
	@Test
	/*
	 * tests exact output of a 10x10 board's top row indices
	 */
	public void testTenTop() {
		int size = 10;
		test_world = makeWorld(size, false, mockLive);
		World board = new World(test_world, mockRand);
		Mockito.doReturn('X').when(mockLive).getStateRep();
		String boardStr = board.toString();
		assertTrue(boardStr.substring(2, 13).equals("0123456789\n"));
	}
	
	@Test
	/*
	 * tests a 10x10 board's left indices by counting total 0s,
	 * to ensure no rollover to the next set of indices
	 */
	public void testTenLeft(){
		int size = 10;
		test_world = makeWorld(size, false, mockLive);
		World board = new World(test_world, mockRand);
		Mockito.doReturn('X').when(mockLive).getStateRep();
		String boardStr = board.toString();
		int countZero = countChar(boardStr,'0');
		assertEquals(countZero,2);
	}
	
	@Test
	/*
	 * tests exact output of an 11x11 board's top row indices
	 */
	public void testElevenTop() {
		int size = 11;
		test_world = makeWorld(size, false, mockLive);
		World board = new World(test_world, mockRand);
		Mockito.doReturn('X').when(mockLive).getStateRep();
		String boardStr = board.toString();
		assertTrue(boardStr.substring(2, 14).equals("01234567890\n"));
	}
	
	@Test
	/*
	 * tests a 11x11 board's left indices by counting total 0s,
	 * to ensure no rollover to the next set of indices
	 */
	public void testElevenLeft(){
		int size = 11;
		test_world = makeWorld(size, false, mockLive);
		World board = new World(test_world, mockRand);
		Mockito.doReturn('X').when(mockLive).getStateRep();
		String boardStr = board.toString();
		int countZero = countChar(boardStr,'0');
		int countOne = countChar(boardStr, '1');
		assertTrue(countZero == 4 && countOne == 2);
	}
	
	@Test
	/*
	 * tests the exact outup of a 50x50 board's top row indices
	 */
	public void testFiftyTop() {
		int size = 50;
		test_world = makeWorld(size, false, mockLive);
		World board = new World(test_world, mockRand);
		Mockito.doReturn('X').when(mockLive).getStateRep();
		String boardStr = board.toString();
		assertTrue(boardStr.substring(2, 53).equals("01234567890123456789012345678901234567890123456789\n"));
	}
	
	@Test
	/*
	 * tests a 50x50 board's left indicesleft indices by counting total 0s,
	 * to ensure no rollover to the next set of indices
	 */
	public void testFiftyLeft(){
		int size = 50;
		test_world = makeWorld(size, false, mockLive);
		World board = new World(test_world, mockRand);
		Mockito.doReturn('X').when(mockLive).getStateRep();
		String boardStr = board.toString();
		int countZero = countChar(boardStr,'0');
		int countOne = countChar(boardStr, '1');
		assertTrue(countZero == 10 && countOne == 10);
	}
	

}
