import org.junit.*;
import static org.junit.Assert.*;

public class WorldUT {
	
	////////////////////
	// TOSTRING TESTS //
	////////////////////
	
	// Tests that in a 10 * 10 world of 30 percent aliveness,
	// 10 rows of cells with 10 cells in each row will be printed out
	@Test
	public void test_toString_interior_value() 
	{		
		World myWorld = new World(10, 5, 30);
		String expectedValue = "  0123456789\n" + 
							   "0 ...XXX..XX\n" + 
							   "1 .X..X..XXX\n" + 
							   "2 X.X..X..XX\n" + 
							   "3 ...XX.....\n" +
							   "4 ..........\n" +
							   "5 XXX.XX.X..\n" +
							   "6 ..XX.....X\n" +
							   "7 ........X.\n" +
							   "8 .......X..\n" +
							   "9 .XXXX.X...\n";
		assertEquals(expectedValue, myWorld.toString());		
	}
	
	// Tests that in a 1*1 world of 20 percent aliveness,
	// only one cell will be printed out
	@Test
	public void test_toString_world_size_one() 
	{
		World myWorld = new World(1, 7, 20);
		String expectedValue = "  0\n" + 
							   "0 .\n";
		assertEquals(expectedValue, myWorld.toString());
	}
	
	// Tests that in a 6*6 world of 0 percent aliveness, 
	// each cell will be printed out as "."
	@Test
	public void test_toString_zero_percent() 
	{
		World myWorld = new World(6, 9, 0);
		String expectedValue = "  012345\n" + 
							   "0 ......\n" +
							   "1 ......\n" +
							   "2 ......\n" +
							   "3 ......\n" +
							   "4 ......\n" +
							   "5 ......\n";
		assertEquals(expectedValue, myWorld.toString());		
	}
	
	// Tests that in a 8*8 world of 100 percent aliveness, 
	// each cell will be printed out as "X"
	@Test
	public void test_toString_full_percent() 
	{
		World myWorld = new World(8, 11, 100);
		String expectedValue = "  01234567\n" + 
							   "0 XXXXXXXX\n" + 
							   "1 XXXXXXXX\n" + 
							   "2 XXXXXXXX\n" + 
							   "3 XXXXXXXX\n" + 
							   "4 XXXXXXXX\n" + 
							   "5 XXXXXXXX\n" + 
							   "6 XXXXXXXX\n" + 
							   "7 XXXXXXXX\n";		
		assertEquals(expectedValue, myWorld.toString());		
	}
	
	// Tests that in a 0*0 world of 10 percent aliveness, 
	// an empty string will be printed out
	@Test
	public void tes_toString_world_size_zero() 
	{
		World myWorld = new World(0, 19, 10);
		String expectedValue = "  \n";
		assertEquals(expectedValue, myWorld.toString());		
	}
	
	// Tests that passing in a negative number (invalid) 
	// for the aliveness percentage  will result in an 
	// invalid World and so print out a null string
	@Test
	public void test_toString_negative_percent() 
	{
		World myWorld = new World(0, 4, -17);
		String expectedValue = null;
		assertEquals(expectedValue, myWorld.toString());	
	}
	
	
	///////////////////
	// ITERATE TESTS //
	///////////////////
	
	// Tests that after iterating a 10*10 world of 30 percent 
	// aliveness, the new world coming out matches the expected world
	@Test
	public void test_iterate_world_size_ten() 
	{				
		World myWorld = new World(10, 5, 30);	
		String expectedWorld = "  0123456789\n" + 
							   "0 .X....X..X\n" + 
							   "1 .XX...XX..\n" + 
							   "2 XXX..X.X..\n" +
							   "3 ...XX....X\n" + 
							   "4 .XX..X....\n" + 
							   "5 XXX.X.....\n" + 
							   "6 X.XXX...XX\n" + 
							   "7 ........X.\n" + 
							   "8 ..XX...X..\n" + 
							   "9 ..X...XXX.\n";
		assertEquals(expectedWorld, myWorld.iterate().toString());	
	}
	
	// Tests that after iterating a 0*0 world of 40 percent 
	// aliveness, the new world coming out matches the expected world
	@Test
	public void test_iterate_world_size_zero() 
	{				
		World myWorld = new World(0, 99, 40);	
		String expectedWorld = "  \n";			
		assertEquals(expectedWorld, myWorld.iterate().toString());	
	}
	
	// Tests that after iterating a 4*4 world of 100 percent 
	// aliveness, the new world coming out matches the expected world
	@Test
	public void test_iterate_world_full_percent() 
	{				
		World myWorld = new World(4, 1, 100);	
		String expectedWorld = "  0123\n" + 
							   "0 ....\n" +
							   "1 ....\n" +
							   "2 ....\n" +
							   "3 ....\n";
		assertEquals(expectedWorld, myWorld.iterate().toString());	
	}
	
	// Tests that after iterating a 2*2 world of 0 percent 
	// aliveness, the new world coming out matches the expected world
	@Test
	public void test_iterate_world_zero_percent() 
	{				
		World myWorld = new World(2, 71, 0);	
		String expectedWorld = "  01\n" +
							   "0 ..\n" +
							   "1 ..\n";					  
		assertEquals(expectedWorld, myWorld.iterate().toString());	
	}
}
