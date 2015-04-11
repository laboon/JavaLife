import static org.junit.Assert.*;

import org.junit.Test;


public class WorldUT {

	////////////////////
	// ITERATE TESTS //
	////////////////////
	
	
	
	////////////////////
	// TOSTRING TESTS //
	////////////////////
	
	// Tests that in a 10 * 10 world of 30 percent aliveness,
	// 10 rows of cells with 10 cells in each row will be printed out
	@Test
	public void test_interior_value() 
	{		
		World myWorld = new World(10, 5, 30);
		String expectedValue = "  0123456789\n0 ...XXX..XX\n1 .X..X..XXX\n2 X.X..X..XX\n3 ...XX.....\n4 ..........\n5 XXX.XX.X..\n6 ..XX.....X\n7 ........X.\n8 .......X..\n9 .XXXX.X...\n";
		assertEquals(expectedValue, myWorld.toString());		
	}
	
	// Tests that in a 1*1 world of 20 percent aliveness,
	// only one cell will be printed out
	@Test
	public void test_edge_size() 
	{
		World myWorld = new World(1, 7, 20);
		String expectedValue = "  0\n0 .\n";
		assertEquals(expectedValue, myWorld.toString());	
	}
	
	// Tests that in a 6*6 world of 0 percent aliveness, 
	// each cell will be printed out as "."
	@Test
	public void test_zero_percent() 
	{
		World myWorld = new World(6, 9, 0);
		String expectedValue = "  012345\n0 ......\n1 ......\n2 ......\n3 ......\n4 ......\n5 ......\n";
		assertEquals(expectedValue, myWorld.toString());		
	}
	
	// Tests that in a 8*8 world of 100 percent aliveness, 
	// each cell will be printed out as "X"
	@Test
	public void test_full_percent() 
	{
		World myWorld = new World(8, 11, 100);
		String expectedValue = "  01234567\n0 XXXXXXXX\n1 XXXXXXXX\n2 XXXXXXXX\n3 XXXXXXXX\n4 XXXXXXXX\n5 XXXXXXXX\n6 XXXXXXXX\n7 XXXXXXXX\n";		
		assertEquals(expectedValue, myWorld.toString());		
	}
}
