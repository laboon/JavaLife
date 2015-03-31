import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class WorldTest {
	//Test Configuration
	//	 * * x
	//	 * x *
	//	 x * *
	Cell[][] world = new Cell[3][3];
	World w = new World(3, 56, 60);

	@Before
    public void setUp() {
		world[0][0] = new Cell(State.DEAD, 0, 0);
		world[0][1] = new Cell(State.DEAD, 0, 1);
		world[0][2] = new Cell(State.ALIVE, 0, 2);
		world[1][0] = new Cell(State.DEAD, 1, 0);
		world[1][1] = new Cell(State.ALIVE, 1, 1);
		world[1][2] = new Cell(State.DEAD, 1, 2);
		world[2][0] = new Cell(State.ALIVE, 2, 0);
		world[2][1] = new Cell(State.DEAD, 2, 1);
		world[2][2] = new Cell(State.DEAD, 2, 2);
	}	
	
	//Test getting the number of neighboring alive cells when a selected
	//cell is in somewhere in the middle of the world
	@Test
	public void testCellInMiddleOfWorld() {
		int x = w.getNumNeighbors(world, 1, 1);
		int y = 2;
		assertEquals(x, y);
	}
	
	//Test getting the number of neighboring alive cells when a selected
	//cell is in somewhere on the left edge of the world
	@Test
	public void testCellOnLeftEdgeOfWorld() {
		int x = w.getNumNeighbors(world, 1, 0);
		int y = 2;
		assertEquals(x, y);
	}

	//Test getting the number of neighboring alive cells when a selected
	//cell is in somewhere on the right edge of the world
	@Test
	public void testCellOnRightEdgeOfWorld() {
		int x = w.getNumNeighbors(world, 1, 2);
		int y = 2;
		assertEquals(x, y);
	}

	//Test getting the number of neighboring alive cells when a selected
	//cell is in somewhere on the top edge of the world
	@Test
	public void testCellOnTopEdgeOfWorld() {
		int x = w.getNumNeighbors(world, 0, 1);
		int y = 2;
		assertEquals(x, y);	
	}
	
	//Test getting the number of neighboring alive cells when a selected
	//cell is in somewhere on the bottom edge of the world
	@Test
	public void testCellOnBottomEdgeOfWorld() {
		int x = w.getNumNeighbors(world, 2, 1);
		int y = 2;
		assertEquals(x, y);	
	}
}