package com.laboon;

import static org.junit.Assert.*;

import java.util.Random;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.mockito.Mockito.*;
import org.mockito.*;
import org.mockito.stubbing.OngoingStubbing;

public class WorldTest
{
    
    @Test
    /*
     * Test that calling World's toString() method is invoked 
     * appropriately as one would would expect
     */
    public void testToStringMethod()
    {
        String dummy = new String("dummy");
        World mockWorld = mock(World.class);
        when(mockWorld.toString()).thenReturn(dummy);
        
        assertTrue(mockWorld.toString().equals(dummy));
    }
    
    @Test
    /*
     * Test edge case that generating an empty world produces 
     * a String representing no meaningful content seeing as 
     * how there is nothing to represent
     */
    public void testEmptyWorld()
    {
        Cell[][] emptyCells = new Cell[0][0];
        Random rando = new Random();
        World w = new World(emptyCells, rando);
        
        String expectedReturn = "  \n";
        assertTrue(expectedReturn.equals(w.toString()));
    }
    
    @Test
    /*
     * Verify that when a world of dead cells is generated 
     * the toString() method will print a world of dead 
     * cells to represent that 
     */
    public void testWorldOfDeadCells()
    {
        Random rando = new Random();
        
        Cell deadCell = mock(Cell.class);
        when(deadCell.getStateRep()).thenReturn('X');
        Cell[][] worldToBe = {{deadCell, deadCell},
                              {deadCell, deadCell}};
        
        World deadWorld = new World(worldToBe, rando);
        
        String expectedWorld = "  01\n"+
                                "0 XX\n"+
                                "1 XX\n";
        
        assertTrue(expectedWorld.equals(deadWorld.toString()));
        
    }
    
    @Test
    /*
     * Verify that when a world of living cells is generated
     * the toString() method will return a string of living
     * cells to represent that
     */
    public void testWorldOfLivingCells()
    {
        Random rando = new Random();
        
        Cell livingCell = mock(Cell.class);
        when(livingCell.getStateRep()).thenReturn('.');
        Cell[][] worldToBe = {{livingCell, livingCell},
                              {livingCell, livingCell}};
        
        World livingWorld = new World(worldToBe, rando);
        
        String expectedWorld = "  01\n"+
                                "0 ..\n"+
                                "1 ..\n";
        
        assertTrue(expectedWorld.equals(livingWorld.toString()));
    }
    
    @Test
    /*
     * Verify that when a world created with both living
     * and dead cells will return the proper String when 
     * the toString() method is called
     */
    public void testWorldOfLivingAndDeadCells()
    {
        Random rando = new Random();
        
        Cell livingCell = mock(Cell.class);
        Cell deadCell = mock(Cell.class);
        
        when(livingCell.getStateRep()).thenReturn('.');
        when(deadCell.getStateRep()).thenReturn('X');

        Cell[][] worldToBe = {{livingCell, deadCell, livingCell, deadCell},
                              {deadCell, deadCell, livingCell, livingCell},
                              {deadCell, livingCell, deadCell, livingCell},
                              {livingCell, livingCell, deadCell, deadCell}};
        
        World livingDeadWorld = new World(worldToBe, rando);
        
        String expectedWorld = "  0123\n"+
                               "0 .X.X\n"+
                               "1 XX..\n"+
                               "2 X.X.\n"+
                               "3 ..XX\n";

        assertTrue(expectedWorld.equals(livingDeadWorld.toString()));
    }
    
    @Test
    /*
     * Verify whether the row labeling is for a world is
     * correct within the string of the World.  This will 
     * also confirm whether the edge case of having more 
     * than ten rows still appropriately wraps the numbering
     * around to start back over at 0
     */
    public void testRowsInString()
    {
        int randoSeed = 0;
        int boardSize = 100;
        int percentAlive = 10;
        
        World testWorld = new World(boardSize, randoSeed, percentAlive);
        
        String worldString = testWorld.toString();
        
        String[] worldRows = worldString.split("\n");
        
        //Test row numbering
        for(int i = 0; i < worldRows.length-1; i++)
        {
            int foundRow = Character.getNumericValue(worldRows[i+1].charAt(0));
            int expectedRow = i % 10;
            
            assertTrue(foundRow == expectedRow);
        }

    }
    
    @Test
    /*
     * Verify whether the column labeling is for a world is
     * correct within the string of the World.  This will 
     * also confirm whether the edge case of having more 
     * than ten columns still appropriately wraps the numbering
     * around to start back over at 0
     */
    public void testColumnsInString()
    {
        int randoSeed = 0;
        int boardSize = 100;
        int percentAlive = 10;
        
        World testWorld = new World(boardSize, randoSeed, percentAlive);
        
        String worldString = testWorld.toString();
        
        String[] worldRows = worldString.split("\n");
        
        //Test column numbering
        char[] columnNums = worldRows[0].substring(2).toCharArray();
        for(int i = 0; i < columnNums.length; i++)
        {
            int foundColumn = Character.getNumericValue(columnNums[i]);
            int expectedColumn = i % 10;
            assertTrue(foundColumn == expectedColumn);
        }        
        
    }
    
    
}
