import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.Test;

import java.util.Random;

import com.laboon.World;
import com.laboon.Cell;
import com.laboon.State;

public class WorldTests {
	@Test
    // Verify that a World with size 0 and calling toString method does not
	// result in a null string
    public void sizeZeroIsNotNull() {
		Random rn = new Random();
        World world = new World(0, rn.nextInt(), rn.nextInt(100));
        
		String result = world.toString();
        
        assertNotNull(result);       
    }
	
	@Test
    // Verify that a World with size 0 and calling toString method does not
	// result in an empty string
    public void sizeZeroIsNotEmptyString() {
		Random rn = new Random();
        World world = new World(0, rn.nextInt(), rn.nextInt(100));
        
		String result = world.toString();
        
        assertFalse(result.equals(""));       
    }
	
	@Test
    // Verify that a World with size 0 and calling toString method does not call
	// Cell method getStateRep()
    public void sizeZeroIsNoCallToStateRep() {
		Random rn = new Random();
        World world = new World(0, rn.nextInt(), rn.nextInt(100));
        Cell cell = mock(Cell.class);
		
		world.toString();
        
        verify(cell, never()).getStateRep();
    }
	
	@Test
    // Verify that a World with size 0 and calling toString method results
	// in the expected result of "  \n"
    public void sizeZeroIsExpectedString() {
		Random rn = new Random();
        World world = new World(0, rn.nextInt(), rn.nextInt(100));
        
		String result = world.toString();
        
        assertTrue(result.equals("  \n"));
    }
	
	@Test
    // Verify that World with size 1 and calling toString method does not
	// result in a null string
    public void sizeOneIsNotNull() {
		Cell cell = mock(Cell.class);
		Cell[][] _world = new Cell[1][1];
		_world[0][0] = cell;
		World world = new World(_world, new Random());
		when(cell.getStateRep()).thenReturn('X');
        
		String result = world.toString();
        
        assertNotNull(result);       
    }
	
	@Test
    // Verify that World with size 1 and calling toString method does not
	// result in an empty string
    public void sizeOneIsNotEmptyString() {
		Cell cell = mock(Cell.class);
		Cell[][] _world = new Cell[1][1];
		_world[0][0] = cell;
		World world = new World(_world, new Random());
		when(cell.getStateRep()).thenReturn('X');
		
		String result = world.toString();
        
        assertFalse(result.equals(""));
    }
	
	@Test
    // Verify that World the result of calling the toString method is "  0\n0 X\n"
	// when any call to Cell's method getStateRep returns X
    public void sizeOneIsExpectedString() {
		Cell cell = mock(Cell.class);
		Cell[][] _world = new Cell[1][1];
		_world[0][0] = cell;
		World world = new World(_world, new Random());
		when(cell.getStateRep()).thenReturn('X');
		
		String result = world.toString();
        
        assertTrue(result.equals("  0\n0 X\n"));
    }
	
	@Test
    // Verify that a world with the method toString called twice would result in
	// the same string is returned being returned for both calls
    public void sameWorldHasTheSameString() {
		Cell cell = mock(Cell.class);
		Random rn = new Random();
		int size = rn.nextInt(10)+1;
		Cell[][] _world = new Cell[size][size];
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				_world[i][j] = cell;
			}
		}
        World world = new World(_world, new Random());
        
		when(cell.getStateRep()).thenReturn('X');
		
		String result1 = world.toString();
		String result2 = world.toString();
        
        assertTrue(result1.equals(result2));
    }
	
	@Test
    // Verify that two Worlds with the exact same cell table will result in the
	// same string is returned for the two worlds when toString is called
    public void twoWorldsWithSameArgumentsResultsInSameString() {
		Cell cell = mock(Cell.class);
		Random rn = new Random();
		int size = rn.nextInt(10)+1;
		Cell[][] _world = new Cell[size][size];
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				_world[i][j] = cell;
			}
		}
        World world1 = new World(_world, rn);
        World world2 = new World(_world, rn);
        
		when(cell.getStateRep()).thenReturn('X');
        
		String result1 = world1.toString();
		String result2 = world2.toString();
        
        assertTrue(result1.equals(result2));
    }
	
	@Test
	// Verify that the toString method returns spaces and newline characters and
	// no additional characters (than X, numbers, and newline character)
	public void hasSpacesAndNewLineChars() {
		Cell cell = mock(Cell.class);
		Random rn = new Random();
		int size = rn.nextInt(10)+1;
		Cell[][] _world = new Cell[size][size];
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				_world[i][j] = cell;
			}
		}
        World world = new World(_world, new Random());
        
		when(cell.getStateRep()).thenReturn('X');
		
		String result = world.toString();
		result = result.replaceAll("[^ X0-9\n]", "B");
		assertEquals(result.indexOf("B"), -1);
		assertTrue(result.indexOf(" ") > -1);
		assertTrue(result.indexOf("\n") > -1);
	}
	
	@Test
	// Verify that the toString method returns numbers in order and
	// no additional characters (than X, numbers, and newline character)
	public void hasNumbersInOrder() {
		Cell cell = mock(Cell.class);
		int size = 10;
		Cell[][] _world = new Cell[size][size];
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				_world[i][j] = cell;
			}
		}
        World world = new World(_world, new Random());
        
		when(cell.getStateRep()).thenReturn('X');
		
		String result = world.toString();
		result = result.replaceAll("[^ X0-9\n]", "B");
		assertEquals(result.indexOf("B"), -1);
		assertTrue(result.indexOf("0123456789") > -1);
	}
	
		@Test
	// Verify that the toString method returns numbers in order and
	// no additional characters (than X, numbers, and newline character)
	public void hasDoubleNumbersInOrder() {
		Cell cell = mock(Cell.class);
		int size = 20;
		Cell[][] _world = new Cell[size][size];
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				_world[i][j] = cell;
			}
		}
	    World world = new World(_world, new Random());
        
		when(cell.getStateRep()).thenReturn('X');
		
		String result = world.toString();
		result = result.replaceAll("[^ X0-9\n]", "B");
		assertEquals(result.indexOf("B"), -1);
		assertTrue(result.indexOf("01234567890123456789") > -1);
	}
	
	@Test
	// Verify that the toString method returns the correct number of Xs that
	// and no additional characters (than X, numbers, and newline character)
	public void hasCorrectNumberOfCells() {
		Cell cell = mock(Cell.class);
		int size = 10;
		Cell[][] _world = new Cell[size][size];
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				_world[i][j] = cell;
			}
		}
        World world = new World(_world, new Random());
        
		when(cell.getStateRep()).thenReturn('X');
		
		String result = world.toString();
		result = result.replaceAll("[^ X0-9\n]", "B");
		assertEquals(result.indexOf("B"), -1);
		result = result.replaceAll("[^X]", "");
		assertEquals(result.length(), size*size);
	}
	
	@Test
	// Verify that the toString method returns the expected string length of
	// (world size + 3) * (size + 1); the three is the number, space, and newline
	// character per line, the one is the first line of numbers
	public void correctLength() {
		Cell cell = mock(Cell.class);
		int size = 10;
		Cell[][] _world = new Cell[size][size];
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				_world[i][j] = cell;
			}
		}
        World world = new World(_world, new Random());
        
		when(cell.getStateRep()).thenReturn('X');
		
		String result = world.toString();
		int correct_length = (size + 3)*(size + 1);
		
		assertEquals(result.length(), correct_length);
	}
}