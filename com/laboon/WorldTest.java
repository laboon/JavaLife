package com.laboon;

import org.junit.Test;
import java.util.Random;
import static org.junit.Assert.*;

//Created by Joey Gelpi 3/29/15

public class WorldTest
{
    /**
     * Testing of World.toString() method before and after refactoring
     */


    /**
     * Test a world with 0x0 dimensions
     */
    @Test
    public void testBlankWorld()
    {
        World world = new World(0, 0, 0);
        String w = world.toString();
        assertTrue(w.compareToIgnoreCase("  \n") == 0);
    }

    /**
     * Test column numbers with a small board of size 10x10
     */
    @Test
    public void testColumnNumbersSmall()
    {
        World world = new World(10, 0, 0);
        String w = world.toString();
        assertTrue(w.startsWith("  0123456789\n"));
    }

    /**
     * Test column numbers with a larger board of size 30x30
     */
    @Test
    public void testColumnNumbersLarge()
    {
        World world = new World(30, 0, 0);
        String w = world.toString();
        assertTrue(w.startsWith("  012345678901234567890123456789\n"));
    }

    /**
     * Test for all dead cells
     */
    @Test
    public void testAllCellsDead()
    {
        Cell[][] cells = new Cell[10][10];
        for (int i = 0; i < cells.length; i++)
        {
            for (int j = 0; j < cells.length; j++)
            {
                cells[i][j] = new Cell(State.DEAD, i, j);
            }
        }
        World world = new World(cells, new Random());
        String w = world.toString();

        int aliveCellsFound = 0;
        for (int i = 0; i < w.length(); i++)
        {
            if (w.charAt(i) == 'X')
                aliveCellsFound++;
        }
        assertTrue(aliveCellsFound == 0);
    }

    /**
     * Test for all alive cells
     */
    @Test
    public void testAllCellsAlive()
    {
        Cell[][] cells = new Cell[10][10];
        for (int i = 0; i < cells.length; i++)
        {
            for (int j = 0; j < cells.length; j++)
            {
                cells[i][j] = new Cell(State.ALIVE, i, j);
            }
        }
        World world = new World(cells, new Random());
        String w = world.toString();

        int aliveCellsFound = 0;
        for (int i = 0; i < w.length(); i++)
        {
            if (w.charAt(i) == 'X')
                aliveCellsFound++;
        }
        assertTrue(aliveCellsFound == 100);
    }

    /**
     * Tests board for accuracy with seed 412 at 10x10 size with 25% alive
     */
    @Test
    public void testRandomBoard()
    {
        World world = new World(10, 412, 25);
        String w = world.toString();
        String expected = "  0123456789\n"
                        + "0 .X.XXX....\n"
                        + "1 .X...XX..X\n"
                        + "2 .X.X.X....\n"
                        + "3 ...X.X....\n"
                        + "4 ....X...XX\n"
                        + "5 ..........\n"
                        + "6 XX........\n"
                        + "7 ..........\n"
                        + "8 ....X.....\n"
                        + "9 ..X.X..XX.\n";
        assertEquals(expected, w);
    }


}