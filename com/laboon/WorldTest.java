import java.util.Random;
import static org.junit.Assert.*;
import org.junit.Test;

public class WorldTest
{
	@Test
	// Set all cells in a [20][20] board to be dead and then check to see if the board is displayed correctly.  
    public void worldToStringBoardTest1()
    {
        Cell[][] cells = new Cell[20][20];
        
        for (int i = 0; i < cells.length; ++i)
        {
            for (int j = 0; j < cells[i].length; ++j)
            {
                cells[i][j] = new Cell(State.DEAD, j, i);
            }
        }
        
        World deadWorld = new World(cells, new Random());
        String expected = "  01234567890123456789\n"
                        + "0 ....................\n"
                        + "1 ....................\n"
                        + "2 ....................\n"
                        + "3 ....................\n"
                        + "4 ....................\n"
                        + "5 ....................\n"
                        + "6 ....................\n"
                        + "7 ....................\n"
                        + "8 ....................\n"
                        + "9 ....................\n"
                        + "0 ....................\n"
                        + "1 ....................\n"
                        + "2 ....................\n"
                        + "3 ....................\n"
                        + "4 ....................\n"
                        + "5 ....................\n"
                        + "6 ....................\n"
                        + "7 ....................\n"
                        + "8 ....................\n"
                        + "9 ....................\n";
        
        assertEquals(expected, deadWorld.toString());
    }
	
	@Test
    // Set all cells in a [10][10] board to be all alive and check to see if the board is displayed correctly.  
	// This is also to test a different size board than the first test.
    public void worldToStringBoardTest2()
    {
        Cell[][] cells = new Cell[10][10];
        
        for (int i = 0; i < cells.length; ++i)
        {
            for (int j = 0; j < cells[i].length; ++j)
            {
                cells[i][j] = new Cell(State.ALIVE, j, i);
            }
        }
        
        World aliveWorld = new World(cells, new Random());
        String expected = "  0123456789\n"
                        + "0 XXXXXXXXXX\n"
                        + "1 XXXXXXXXXX\n"
                        + "2 XXXXXXXXXX\n"
                        + "3 XXXXXXXXXX\n"
                        + "4 XXXXXXXXXX\n"
                        + "5 XXXXXXXXXX\n"
                        + "6 XXXXXXXXXX\n"
                        + "7 XXXXXXXXXX\n"
                        + "8 XXXXXXXXXX\n"
                        + "9 XXXXXXXXXX\n";
        
        assertEquals(expected, aliveWorld.toString());
    }
	
	@Test
	// Created a new World that had a board size of 50x50 and checked to make sure the column 
	// header for the first row contained 5 iterations of the numbers "0123456789".  
	public void largeNumRowsTest()
	{
		World newWorld = new World(50, 1500, 15);
		String expectedRowHeader = "01234567890123456789012345678901234567890123456789";
		assertTrue(newWorld.toString().contains(expectedRowHeader));
	}
	
	@Test
	// Used a set random seed and tested to see if it outputted the correct board.
	public void randomWorldGenerateTest()
	{
		World newWorld = new World(5, 1500, 15);
		String expected =  "  01234\n"
				 		+  "0 .....\n"
				 		+  "1 .XX..\n"
				 		+  "2 .....\n"
				 		+  "3 .X..X\n"
				 		+  "4 .....\n";
		assertEquals(newWorld.toString(), expected);
	}
	
	@Test
	// Used the same set random seed above and tested to see if after one iteration the program outputted the correct board.
	public void randomWorldIterateTest()
	{
		World newWorld = new World(5, 1500, 15);
		String expected =  "  01234\n"
				 		+  "0 .....\n"
				 		+  "1 .....\n"
				 		+  "2 XXX..\n"
				 		+  "3 .....\n"
				 		+  "4 .....\n";
		newWorld = newWorld.iterate();
		
		assertEquals(newWorld.toString(), expected);
	}
	
	@Test
	// Used the same arguments to initialize two different worlds and checked to make sure both created the same board.
	public void multipleInitsTest()
	{
		World newWorldA = new World(5, 1500, 15);
		World newWorldB = new World(5, 1500, 15);
		
		assertEquals(newWorldA.toString(), newWorldB.toString());
	}
	
	@Test
	// Used two different arguments to intitialize two different worlds and check to make sure both created different boards.  
	public void differentInitsTest()
	{
		World newWorldA = new World(5, 1500, 15);
		World newWorldB = new World(5, 5019, 15);
		
		assertNotEquals(newWorldA.toString(), newWorldB.toString());
	}
}