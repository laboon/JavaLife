/*
 * Tests for World.toString() method
 * Virginia Mulky
 */

package com.laboon;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.Random;

/**
 *
 * @author Ginger
 */
public class WorldStringTest {
    private World testworld;
    private World zeroworld;
    private Cell[][] deadcells;
    private Cell[][] livecells;
    private Cell[][] unknowncells;
    private World deadworld;
    private World liveworld;
    private World unknownworld;
    private Random r;
      
    @Before
    public void setUp() {
            r = mock(Random.class);
            testworld = new World(5, 5, 10);
            zeroworld = new World(0, 0, 0);
            //set up some world cell arrays for all dead, all living, and all unknown
            //these will be used for later tests
            deadcells = new Cell[5][5];
            livecells = new Cell[5][5];
            unknowncells = new Cell[5][5];
            for (int j = 0; j < 5; j++ ) {
                    for (int k = 0; k < 5; k++) {
                            deadcells[j][k] = mock(Cell.class);           
                            when(deadcells[j][k].getStateRep()).thenReturn('.');
                            livecells[j][k] = mock(Cell.class);
                            when(livecells[j][k].getStateRep()).thenReturn('X');
                            unknowncells[j][k] = mock(Cell.class);
                            when(unknowncells[j][k].getStateRep()).thenReturn('?');
                            
                    }
            }
            deadworld = new World(deadcells, r);
            liveworld = new World(livecells, r);
            unknownworld = new World(unknowncells, r);
    }
    
    /*
    * Test that string returned is not null
    */
    @Test
    public void testNotNull()
    {
            String s = testworld.toString();
            assertNotNull(s);
    }
    
    /*
    * Test that the world string is as expected
    */
    @Test
    public void testWorldString()
    {
            String s = testworld.toString();
            assertEquals("  01234\n0 ....X\n1 X....\n2 .X...\n3 .....\n4 X.X..\n", s);
    }
    
    /*
    * Test that world with size zero only returns formatting
    */
    @Test
    public void testZeroSize()
    {
            String zero = zeroworld.toString();
            assertEquals("  \n", zero);
    }
    
    /*
    * Test that the dead array toString is all periods and formatted correctly
    */
    @Test
    public void testDeadString()
    {
            String dead = deadworld.toString();
            assertEquals("  01234\n0 .....\n1 .....\n2 .....\n3 .....\n4 .....\n", dead);
    }
    
    /*
    * Test that the live array toString is all X and formatted correctly
    */
    @Test
    public void testLiveString()
    {
            String live = liveworld.toString();
            assertEquals("  01234\n0 XXXXX\n1 XXXXX\n2 XXXXX\n3 XXXXX\n4 XXXXX\n", live);
    }
    
    /*
    * Test that the unknown array toString is all ? and formatted correctly
    */
    @Test
    public void testUnknownString()
    {
            String unknown = unknownworld.toString();
            assertEquals("  01234\n0 ?????\n1 ?????\n2 ?????\n3 ?????\n4 ?????\n", unknown);
    }
    

}
