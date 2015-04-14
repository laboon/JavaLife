import org.junit.*;
import static org.junit.Assert.*;

public class CellUT {
			
	/////////////////
	// STATE TESTS //
	/////////////////
	
	// Tests that state() will return ALIVE 
	// if the current state of the cell is ALIVE
	@Test
	public void testStateAlive() {
		Cell cell = new Cell(State.ALIVE, 0, 0);
		assertEquals(State.ALIVE, cell.state());
	}
	// Tests that state() will return DEAD 
	// if the current state of the cell is DEAD
	@Test
	public void testStateDead() {
		Cell cell = new Cell(State.DEAD, 100, 1);
		assertEquals(State.DEAD, cell.state());
	}
	
	
	///////////////////
	// ISALIVE TESTS //
	///////////////////	
	
	// Tests that isAlive() will return true 
	// if the current state of the cell is ALIVE
	@Test
	public void testIsAlive_Alive() {
		Cell cell = new Cell(State.ALIVE, 1, 99);
		assertTrue(cell.isAlive());
	}
	
	// Tests that isAlive() will return false 
	// if the current state of the cell is DEAD
	@Test
	public void testIsAlive_Dead() {
		Cell cell = new Cell(State.DEAD, 0, 199);
		assertFalse(cell.isAlive());
	}
	
	
	///////////////////
	// ITERATE TESTS //
	///////////////////	
	
	// Tests that iterate(int numNeighbors) will 
	// return DEAD if numNeighbors is 0 and 
	// the current state of the cell is ALIVE
	@Test
	public void testIterate_Alive_0_nb() {
		Cell cell = new Cell(State.ALIVE, 5, 5);
		assertEquals(State.DEAD, cell.iterate(0));		
	}
	
	// Tests that iterate(int numNeighbors) will 
	// return DEAD if numNeighbors is 1 and 
	// the current state of the cell is ALIVE
	@Test
	public void testIterate_Alive_1_nb() {
		Cell cell = new Cell(State.ALIVE, 5, 5);
		assertEquals(State.DEAD, cell.iterate(1));		
	}
	
	// Tests that iterate(int numNeighbors) will 
	// return ALIVE if numNeighbors is 2 and 
	// the current state of the cell is ALIVE
	@Test
	public void testIterate_Alive_2_nb() {
		Cell cell = new Cell(State.ALIVE, 5, 5);
		assertEquals(State.ALIVE, cell.iterate(2));		
	}
		
	// Tests that iterate(int numNeighbors) will 
	// return ALIVE if numNeighbors is 3 and 
	// the current state of the cell is ALIVE
	@Test
	public void testIterate_Alive_3_nb() {
		Cell cell = new Cell(State.ALIVE, 5, 5);
		assertEquals(State.ALIVE, cell.iterate(3));		
	}
	
	// Tests that iterate(int numNeighbors) will 
	// return DEAD if numNeighbors is 4 and 
	// the current state of the cell is ALIVE
	@Test
	public void testIterate_Alive_4_nb() {
		Cell cell = new Cell(State.ALIVE, 5, 5);
		assertEquals(State.DEAD, cell.iterate(4));		
	}
	
	// Tests that iterate(int numNeighbors) will 
	// return null if numNeighbors is -8 (invalid) 
	// and the current state of the cell is ALIVE
	@Test
	public void testIterate_Alive_n8_nb() {
		Cell cell = new Cell(State.ALIVE, 5, 5);
		assertEquals(null, cell.iterate(-8));		
	}
		
	// Tests that iterate(int numNeighbors) will 
	// return null if numNeighbors is 20 (invalid) 
	// and the current state of the cell is ALIVE
	@Test
	public void testIterate_Alive_20_nb() {
		Cell cell = new Cell(State.ALIVE, 5, 5);
		assertEquals(null, cell.iterate(20));	
	}
	
	// Tests that iterate(int numNeighbors) will 
	// return DEAD if numNeighbors is 0 and 
	// the current state of the cell is DEAD
	@Test
	public void testIterate_Dead_0_nb() {
		Cell cell = new Cell(State.DEAD, 5, 5);
		assertEquals(State.DEAD, cell.iterate(0));		
	}
		
	// Tests that iterate(int numNeighbors) will 
	// return DEAD if numNeighbors is 2 and 
	// the current state of the cell is DEAD
	@Test
	public void testIterate_Dead_2_nb() {
		Cell cell = new Cell(State.DEAD, 5, 5);
		assertEquals(State.DEAD, cell.iterate(2));		
	}
	
	// Tests that iterate(int numNeighbors) will 
	// return ALIVE if numNeighbors is 3 and 
	// the current state of the cell is DEAD
	@Test
	public void testIterate_Dead_3_nb() {
		Cell cell = new Cell(State.DEAD, 5, 5);
		assertEquals(State.ALIVE, cell.iterate(3));		
	}
	
	// Tests that iterate(int numNeighbors) will 
	// return DEAD if numNeighbors is 4 and 
	// the current state of the cell is DEAD
	@Test
	public void testIterate_Dead_4_nb() {
		Cell cell = new Cell(State.DEAD, 5, 5);
		assertEquals(State.DEAD, cell.iterate(4));		
	}
	
	// Tests that iterate(int numNeighbors) will 
	// return null if numNeighbors is -15 (invalid) 
	// and the current state of the cell is DEAD
	@Test
	public void testIterate_Dead_n15_nb() {
		Cell cell = new Cell(State.DEAD, 5, 5);
		assertEquals(null, cell.iterate(-15));		
	}
	
	// Tests that iterate(int numNeighbors) will 
	// return null if numNeighbors is 15 (invalid) 
	// and the current state of the cell is DEAD
	@Test
	public void testIterate_Dead_15_nb() {
		Cell cell = new Cell(State.DEAD, 5, 5);
		assertEquals(null, cell.iterate(15));		
	}
	
	// Tests that iterate(int numNeighbors) will 
	// return null if numNeighbors is 5 and
	// the current state of the cell is null
	@Test
	public void testIterate_null_5_nb() {
		Cell cell = new Cell(null, 5, 5);
		assertEquals(null, cell.iterate(5));		
	}
	
	
	///////////////////////
	// GETSTATEREP TESTS //
	///////////////////////
	
	// Tests that getStateRep() will return
	// the character '.' if the current state
	// of the cell is DEAD
	@Test
	public void testGetStateRep_Alive() {
		Cell cell = new Cell(State.DEAD, 5, 5);
		assertEquals('.', cell.getStateRep());		
	}
	
	// Tests that getStateRep() will return
	// the character 'X' if the current state
	// of the cell is ALIVE
	@Test
	public void testGetStateRep_Dead() {
		Cell cell = new Cell(State.DEAD, 5, 5);
		assertEquals('.', cell.getStateRep());	
	}
	
	// Tests that getStateRep() will return
	// the character '?' if the current state
	// of the cell is null
	@Test
	public void testGetStateRep_Null() {
		Cell cell = new Cell(null, 5, 5);
		assertEquals('?', cell.getStateRep());		
	}	
}
