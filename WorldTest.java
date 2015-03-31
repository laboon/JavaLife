import static org.junit.Assert.*;

import org.junit.Test;

public class WorldTest {

	@Test
	/*
	 * This test assures the create result for an empty string
	 */
	public void emptyWorldTest() {
		// Create a new empty world
		World w = new World(0, 2, 2);

		// Passing the empty world to the toString() method should result in a
		// string consisting of
		// a few spaces and a new line
		String s = "  " + "\n";
		assertEquals(s, w.toString());
	}

	@Test
	/*
	 * This test is checking that the header numbering is consistent each time a
	 * world of size 10x10 is constructed
	 */
	public void checkHeaderFormat() {
		// Create a new world
		World w = new World(10, 0, 0);

		// The numbering format across the header should be from 0-9
		String s = "  " + "0123456789\n";
		assertTrue(w.toString().contains(s));
	}

	@Test
	/*
	 * This test is checking that the row count is consistent each time a world
	 * of size 10x10 is constructed
	 */
	public void checkRowFormat() {
		// Create a new world 10x10
		World w = new World(10, 0, 0);

		// There should consist 11 rows due to the extra newline placed after
		// the game board
		String[] rows = w.toString().split("\n");
		assertEquals(rows.length, 11);
	}

	@Test
	/*
	 * This test checks whether for the parameters that produce the same random
	 * number, the correct output string is produced each time on one iteration
	 */
	public void correctOutputOneIteration() {
		// Create a new world
		World w = new World(5, 123456789, 50);

		// Passing the world to the toString() method should result in a string
		// consisting of
		// a one X in row 0, three X's in row 1, one X in row 3, and three X's
		// in row 4
		String s = "  01234\n0 .X.X.\n1 .XX..\n2 X...X\n3 ...X.\n4 X.X..\n";
		assertEquals(s, w.toString());
	}

	@Test
	/*
	 * By passing in the specific arguments 2, 3, 50 The same string is
	 * constructed each time
	 */
	public void reptivitiveIterationsTest() {
		// Create a new world
		World w = new World(2, 3, 0);

		// Passing the world to the toString() method should result in a
		// matrix with only periods and no 'Xs'
		// Calling w.iterate() in a for loop 100 times ensures this is the case
		// each time
		for (int i = 0; i < 100; i++) {
			w = w.iterate();
			String s = "  " + "01\n" + "0 ..\n" + "1 ..\n";
			assertEquals(s, w.toString());
		}
	}

	@Test
	/*
	 * This test assures the correct percentage alive is indeed being printed
	 * 75% of a 4x4 world is 12 'alive' cells or 12 X's
	 */
	public void percentALIVETest() {
		// Create a new world
		World w = new World(4, 0, 75);

		// Count the number of X's in the world
		String[] rows = w.toString().split("\n");
		int xCount = 0;
		for (String s : rows) {
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == 'X')
					xCount += 1;
			}
		}
		// 75% in this game board is 12 X's
		assertEquals(xCount, 12);
	}

	@Test
	/*
	 * This test checks whether the 4x4 world constructed produces the correct
	 * output string for 5 iterations
	 */
	public void correctOutputFiveIterations() {
		// Create a new world
		World w = new World(5, 123456789, 50);

		// Passing the world to the toString() method should result in following
		// string
		String s = "  01234\n0 .X.X.\n1 .XX..\n2 X...X\n3 ...X.\n4 X.X..\n";
		assertEquals(s, w.toString());

		// Iterate w 5 times and check correct output each time
		// One
		w = w.iterate();
		s = "  01234\n0 X..X.\n1 .XXXX\n2 XXXXX\n3 XX.X.\n4 .XXXX\n";
		assertEquals(s, w.toString());

		// Two
		// Unfortunately test here on out include only dead cells (tried
		// different possibilities)
		w = w.iterate();
		s = "  01234\n0 .....\n1 .....\n2 .....\n3 .....\n4 .....\n";
		assertEquals(s, w.toString());

		// Three
		w = w.iterate();
		assertEquals(s, w.toString());

		// Four
		w = w.iterate();
		assertEquals(s, w.toString());

		// Five
		w = w.iterate();
		assertEquals(s, w.toString());
	}
}
