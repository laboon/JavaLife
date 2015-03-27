package com.laboon;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


public class WorldTest {
    /**************************************
     * INITIAL CONFIGURATION STRING TESTS *
     **************************************/

    /**
     * Tests the initial configuration string for an initial World instance of size 0 and seed 0
     * with 0% of initial cells alive.
     */
    @Test
    public void testInitConfig0() {
        World world = new World(0, 0, 0);
        String initConfig = getInitConfig(world);
        assertEquals("  ", initConfig);
    }

    /**
     * Tests the initial configuration string for an initial World instance of size 5 and seed 5
     * with 5% of initial cells alive.
     */
    @Test
    public void testInitConfig5() {
        World world = new World(5, 5, 5);
        String initConfig = getInitConfig(world);
        assertEquals("  01234", initConfig);
    }

    /**
     * Tests the initial configuration string for a non-initial World instance of size 10 with 0% of
     * initial cells alive.
     */
    @Test
    public void testInitConfig10() {
        Cell[][] cells = new Cell[10][10];
        World world = new World(cells, new Random());
        initCells(cells, State.DEAD);
        String initConfig = getInitConfig(world);
        assertEquals("  0123456789", initConfig);
    }

    /**
     * Tests the initial configuration string for a non-initial World instance of size 20 with 100%
     * of initial cells alive.
     */
    @Test
    public void testInitConfig20() {
        Cell[][] cells = new Cell[20][20];
        World world = new World(cells, new Random());
        initCells(cells, State.ALIVE);
        String initConfig = getInitConfig(world);
        assertEquals("  01234567890123456789", initConfig);
    }

    /********************
     * ROW NUMBER TESTS *
     ********************/

    /**
     * Test all row numbers for an initial World instance of size 0 and seed 0 with 0% of initial
     * cells alive.
     */
    @Test
    public void testRowNumbers0() {
        World world = new World(0, 0, 0);
        String[] worldStrings = getWorldStrings(world);
        assertEquals(1, worldStrings.length);
    }

    /**
     * Test all row numbers for an initial World instance of size 5 and seed 5 with 5% of initial
     * cells alive.
     */
    @Test
    public void testRowNumbers5() {
        World world = new World(5, 5, 5);
        String[] worldStrings = getWorldStrings(world);
        assertRowNumbers(worldStrings);
    }

    /**
     * Test all row numbers for a non-initial World instance of size 10 with 0% of initial cells
     * alive.
     */
    @Test
    public void testRowNumbers10() {
        Cell[][] cells = new Cell[10][10];
        World world = new World(cells, new Random());
        initCells(cells, State.DEAD);
        String[] worldStrings = getWorldStrings(world);
        assertRowNumbers(worldStrings);
    }

    /**
     * Test all row numbers for a non-initial World instance of size 20 with 100% of initial cells
     * alive.
     */
    @Test
    public void testRowNumbers20() {
        Cell[][] cells = new Cell[20][20];
        World world = new World(cells, new Random());
        initCells(cells, State.ALIVE);
        String[] worldStrings = getWorldStrings(world);
        assertRowNumbers(worldStrings);
    }

    /************************
     * CELL STATE REP TESTS *
     ************************/

    /**
     * Tests to see if all cells are dead for an initial World instance of size 100 and seed 0
     * with 0% of initial cells alive (if the string representation of the World instance does not
     * contain an "X" or a "?" then all cells are dead).
     */
    @Test
    public void testAllDead() {
        World world = new World(100, 0, 0);
        String worldString = world.toString();
        assertFalse(worldString.contains("X"));
        assertFalse(worldString.contains("?"));
    }

    /**
     * Tests to see if all cells are alive for a non-initial World instance of size 100 with 0% of
     * initial cells alive (if the string representation of the World instance does not contain an
     * "." or a "?" then all cells are alive).
     */
    @Test
    public void testAllAlive() {
        Cell[][] cells = new Cell[100][100];
        World world = new World(cells, new Random());
        initCells(cells, State.ALIVE);
        String worldString = world.toString();
        assertFalse(worldString.contains("."));
        assertFalse(worldString.contains("?"));
    }

    /**
     * Tests to see if all cells are correct for a non-initial World instance of size 2 with 50% of
     * initial cells alive.
     */
    @Test
    public void testMixedCells2() {
        Cell[][] cells = {
                {new Cell(State.DEAD, 0, 0), new Cell(State.ALIVE, 0, 1)},
                {new Cell(State.ALIVE, 1, 0), new Cell(State.DEAD, 1, 1)}
        };
        World world = new World(cells, new Random());
        String worldString = world.toString();
        assertEquals("  01\n0 .X\n1 X.\n", worldString);
    }

    /**
     * Tests to see if all cells are correct for an initial World instance of size 20 and seed 12345
     * with 25% of initial cells alive.
     */
    @Test
    public void testMixedCells20() {
        World world = new World(20, 12345, 25);
        String worldString = world.toString();
        assertEquals("  01234567890123456789\n0 .......XX.X..XX..X..\n1 X..X........X.X...XX\n2 ." +
                "...X.X......X......\n3 ...X.....X.XX.......\n4 XX....X..X......X...\n5 ..X...X.." +
                "..X..XX....\n6 X.XXX.........X.....\n7 ...X........X......X\n8 XX..............." +
                "XX.\n9 ......XX...X........\n0 .X............X..X..\n1 ..X....X.......X....\n2 ." +
                ".XX....X..XX...X...\n3 ..X......X.X...X.X..\n4 ......XX..X.X.XX....\n5 .XX.X.X.." +
                "....X.XX.X.\n6 X......XX..X...X....\n7 ............X.X..X..\n8 ...........X....." +
                ".XX\n9 .X.......X.....X....\n", worldString);
    }

    /***********************
     * MISCELLANEOUS TESTS *
     ***********************/

    /**
     * Tests the third iteration output for an initial World instance of size 5 and seed 12345 with
     * 25% of initial cells alive.
     */
    @Test
    public void testWorldIteration() {
        World world = new World(5, 12345, 25);
        for (int i = 0; i < 3; i++) {
            world = world.iterate();
        }
        String worldString = world.toString();
        assertEquals("  01234\n0 ...XX\n1 XX.XX\n2 ..X.X\n3 .X.X.\n4 ..X.X\n", worldString);
    }

    /**
     * Tests the output for an initial World instance of size 0 and seed 0 with 0% of initial cells
     * alive.
     */
    @Test
    public void testEmptyWorld() {
        World world = new World(0, 0, 0);
        String worldString = world.toString();
        assertEquals("  \n", worldString);
    }

    ////////////////////////////
    // PRIVATE HELPER METHODS //
    ////////////////////////////

    /**
     * Private helper method that returns a World instance's initial configuration string.
     *
     * @param world World instance.
     * @return Initial configuration string.
     */
    private String getInitConfig(World world) {
        return world.toString().split("\n")[0];
    }

    /**
     * Private helper method that sets the state of all cells.
     *
     * @param cells Cells living in the new world
     * @param state State of all cells
     */
    private void initCells(Cell[][] cells, State state) {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells.length; j++) {
                cells[i][j] = new Cell(state, i, j);
            }
        }
    }

    /**
     * Private helper method that splits a World instance string representation by "\n".
     *
     * @param world World instance.
     * @return World strings.
     */
    private String[] getWorldStrings(World world) {
        return world.toString().split("\n");
    }

    /**
     * Private helper method that asserts that a World's row numbers are correct.
     *
     * @param worldStrings World strings.
     */
    private void assertRowNumbers(String[] worldStrings) {
        for (int i = 1; i < worldStrings.length; i++) {
            int rowNumber = Character.getNumericValue(worldStrings[i].charAt(0));
            assertEquals((i - 1) % 10, rowNumber);
        }
    }
}
