package tests;

import com.laboon.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class WorldTests {

	/* Tests to make sure that the columns are numbered correctly */
	@Test
	public void testToString_columns() {
		String expectedColumns = "  012345678901234";
		World testWorld = new World(15, 0xDEADBEEF, 30);
		String worldState = testWorld.toString();
		String observedColumns = worldState.split("\n")[0];
		assertEquals(observedColumns, expectedColumns);
	}
	
	/* Tests to make sure that the rows are numbered correctly */
	@Test
	public void testToString_rows() {
		String expectedRows = "012345678901234";
		World testWorld = new World(15, 0xDEADBEEF, 30);
		String worldState = testWorld.toString();
		String[] lines = worldState.split("\n");
		String observedRows = "";
		for (int i = 1; i < lines.length; i++) {
			observedRows += lines[i].charAt(0);
		}
		assertEquals(observedRows, expectedRows);
	}
	
	/* Tests a 1x1 world to make sure it renders correctly */
	@Test
	public void testToString_smallBoard() {
		String expectedWorld = "  0\n0 .\n";
		World testWorld = new World(1, 0xDEADBEEF, 30);
		String observedWorld = testWorld.toString();
		assertEquals(observedWorld, expectedWorld);
	}
	
	/* Tests a 15x15 world to make sure it renders correctly */
	@Test
	public void testToString_largeBoard() {
		String expectedWorld = "  012345678901234\n" +
				"0 ...XX.X.XX...X.\n" +
				"1 .....X.XX...X..\n" +
				"2 ....XX.XX.X...X\n" +
				"3 ...XXXX.XX.XX..\n" +
				"4 X..X.X...X...X.\n" +
				"5 X...........XXX\n" +
				"6 ..X.XX..X......\n" +
				"7 .X..........X..\n" +
				"8 X..XXX....XX.X.\n" +
				"9 ..X...X..X....X\n" +
				"0 X.X..X....X....\n" +
				"1 X..X..XX..X....\n" +
				"2 .X..XX.....XXX.\n" +
				"3 XX.X.....X.XX..\n" +
				"4 .X......X.XXXX.\n";
		World testWorld = new World(15, 0xDEADBEEF, 30);
		String observedWorld = testWorld.toString();
		assertEquals(observedWorld, expectedWorld);
	}
	/* Tests a 10x10 world after 1 iteration to make sure it renders correctly */
	@Test
	public void testToString_singleIteration() {
		String expectedWorld = "  0123456789\n" +
				"0 ..X.X...XX\n" +
				"1 .X......X.\n" +
				"2 ..XXXX.X..\n" +
				"3 .....X.X.X\n" +
				"4 ...X.X...X\n" +
				"5 ..X..X...X\n" +
				"6 X.XX.XX..X\n" +
				"7 XX.X.X.X..\n" +
				"8 X.X..X.X.X\n" +
				"9 X.X.XXX...\n";
		World testWorld = new World(10, 0xDEADBEEF, 30);
		testWorld = testWorld.iterate();
		String observedWorld = testWorld.toString();
		assertEquals(observedWorld, expectedWorld);
	}
}
