package com.laboon.tests;

import java.util.Random;

import com.laboon.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

public class WorldTests
{

    @Test
    // Verify the toString() method queries each cell for its
    // state. 
    public void worldToStringCallsGetStateRepOnEachCell()
    {
        Cell[][] cells = {  
                            { mock(Cell.class), mock(Cell.class) },
                            { mock(Cell.class), mock(Cell.class) }
                         };
        
        World testSubject = new World(cells, new Random());
        
        testSubject.toString();
        
        for (Cell[] row : cells)
        {
            for (Cell c : row)
            {
                verify(c).getStateRep();
            }
        }
    }
    
    @Test
    // Verify toString() produces the correct result when the matrix is empty.
    public void worldWithEmptyCellArrayToStringProducesTwoSpacesAndNewLine()
    {
        World testSubject = new World(new Cell[0][0], new Random());
        String result = testSubject.toString();
        
        assertEquals("  \n", result);
    }
    
    @Test
    // Verify toString() produces the correct result when only one cell is in the matrix.
    public void worldWithCellArrayWithOneElementToStringProducesCorrectResult()
    {
        Cell[][] cells = { { new Cell(State.ALIVE, 0, 0) } };
        
        World testSubject = new World(cells, new Random());
        
        String expected = "  0\n" 
                        + "0 X\n";
        
        assertEquals(expected, testSubject.toString());
    }
    
    @Test
    // Verify toString() produces the correct result for dead/alive cells.
    public void worldWithMixedCellsToStringProducesCorrectResult()
    {
        Cell[][] cells = 
        {
            { new Cell(State.ALIVE, 0, 0), new Cell(State.DEAD, 0, 1) },
            { new Cell(State.ALIVE, 1, 0), new Cell(State.DEAD, 1, 1) }
        };
        
        World testSubject = new World(cells, new Random());
        String string = testSubject.toString();
        
        assertEquals("  01\n0 X.\n1 X.\n", string);        
    }
    
    @Test
    // Verify the row/column labels are correctly wrapped around 10. 
    public void worldToStringCorrectlyWrapsValuesAround10()
    {
        Cell[][] cells = new Cell[20][20];
        
        for (int i = 0; i < cells.length; ++i)
        {
            for (int j = 0; j < cells[i].length; ++j)
            {
                cells[i][j] = new Cell(State.DEAD, j, i);
            }
        }
        
        World testSubject = new World(cells, new Random());
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
        
        assertEquals(expected, testSubject.toString());
    }

}
