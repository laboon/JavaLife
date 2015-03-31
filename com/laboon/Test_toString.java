package com.laboon;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.util.Random;
import com.laboon.Cell;
import org.junit.Test;

public class Test_toString
{
	
	// A helper function
	public Random getRandomMock()
	{
		Random random = mock(Random.class);
    	when(random.nextInt()).thenReturn(1);
    	
    	return random;
	}
    
    World w;
    
    // Test with size 0 and the other parameters > 0 
    @Test
    public void test_toString1()
    {
        w = new World(0, 20, 80);
        assertEquals(w.toString(),"  \n");
        
    }
    
    // Test with size 0, seeds 0 and 0% of initially alive cells
    @Test
    public void test_toString2()
    {
        w = new World(0, 0, 0);
        assertEquals(w.toString(),"  \n");
        
    }
    
    // Test with size 10, seeds 0 and 0% of initially alive cells
    @Test
    public void test_toString3()
    {
        w = new World(10, 0, 100);
        assertEquals(w.toString(),"  0123456789\n0 XXXXXXXXXX\n1 XXXXXXXXXX\n2 XXXXXXXXXX\n3 XXXXXXXXXX\n4 XXXXXXXXXX\n5 XXXXXXXXXX\n6 XXXXXXXXXX\n7 XXXXXXXXXX\n8 XXXXXXXXXX\n9 XXXXXXXXXX\n");
        
    }
    
 // Test with size 10, 0 seeds and 0% of initially alive cells
    @Test
    public void test_toString4()
    {
        w = new World(10, 0, 0);
        assertEquals(w.toString(),"  0123456789\n0 ..........\n1 ..........\n2 ..........\n3 ..........\n4 ..........\n5 ..........\n6 ..........\n7 ..........\n8 ..........\n9 ..........\n");
        
    }
    
    
    //Test with fixed grid containing 100% alive cells
    @Test
    public void test_toString5()
    {
    	Cell[][] world = new Cell[10][10];
    	
    	for (int j = 0; j < 10; j++ )
    	{
			for (int k = 0; k < 10; k++)
			{
				world[j][k] = new Cell(State.ALIVE, j, k);
			}
		}
    	
    	w = new World(world, getRandomMock());
    	assertEquals(w.toString(),"  0123456789\n0 XXXXXXXXXX\n1 XXXXXXXXXX\n2 XXXXXXXXXX\n3 XXXXXXXXXX\n4 XXXXXXXXXX\n5 XXXXXXXXXX\n6 XXXXXXXXXX\n7 XXXXXXXXXX\n8 XXXXXXXXXX\n9 XXXXXXXXXX\n");
    }
    
    
    // Test with fixed grid containing 100% dead cells
    @Test
    public void test_toString6()
    {
    	Cell[][] world = new Cell[10][10];
    	
    	for (int j = 0; j < 10; j++ )
    	{
			for (int k = 0; k < 10; k++)
			{
				world[j][k] = new Cell(State.DEAD, j, k);
			}
		}
    	
    	w = new World(world, getRandomMock());
    	assertEquals(w.toString(),"  0123456789\n0 ..........\n1 ..........\n2 ..........\n3 ..........\n4 ..........\n5 ..........\n6 ..........\n7 ..........\n8 ..........\n9 ..........\n");
    }
    
    // Test with fixed grid containing 50% alive cells and 50% dead cells
    @Test
    public void test_toString7()
    {
    	Cell[][] world = new Cell[10][10];
    	
    	for (int j = 0; j < 10; j++ )
    	{
			for (int k = 0; k < 10; k++)
			{
				if (k % 2 == 0)
				{
					world[j][k] = new Cell(State.ALIVE, j, k);					
				}
				else
				{
					world[j][k] = new Cell(State.DEAD, j, k);
				}
			}
		}
    	
    	w = new World(world, getRandomMock());
    	assertEquals(w.toString(),"  0123456789\n0 X.X.X.X.X.\n1 X.X.X.X.X.\n2 X.X.X.X.X.\n3 X.X.X.X.X.\n4 X.X.X.X.X.\n5 X.X.X.X.X.\n6 X.X.X.X.X.\n7 X.X.X.X.X.\n8 X.X.X.X.X.\n9 X.X.X.X.X.\n");
    }
    
}
