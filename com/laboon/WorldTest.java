import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class WorldTest {


	
	//Creates a 10x10 grid and tests to see if the two toString methods return the same result.
	@Test
	public void testMap() {
		World bob = new World(10, 10, 50);
		
	
		StringBuilder first = new StringBuilder();
		first.append("  ");
		first.append(bob.toString());
		String second = bob.OriginaltoString();
		
		assertEquals(first.toString(), second);
		
	}
	
	//Creates a 20x20 grid and tests to see if the two toString methods return the same result.
	@Test
	public void testMap2() {
		World bob = new World(20, 10, 50);
		StringBuilder first = new StringBuilder();
		first.append("  ");
		first.append(bob.toString());
		String second = bob.OriginaltoString();
		assertEquals(first.toString(), second);
		
	}
	
	
	//Create a 50x50 grid and tests to see if the two toString methods return the same result.
	@Test
	public void testMap3() {
		World bob = new World(50, 10, 50);
		StringBuilder first = new StringBuilder();
		first.append("  ");
		first.append(bob.toString());
		String second = bob.OriginaltoString();
		assertEquals(first.toString(), second);
	}
	
	//Create a 100x100 grid and tests to see if the two toString methods return the same result.
		@Test
		public void testMap4() {
			World bob = new World(100, 10, 50);
			StringBuilder first = new StringBuilder();
			first.append("  ");
			first.append(bob.toString());
			String second = bob.OriginaltoString();
			assertEquals(first.toString(), second);
		}
	
	//Add the iterate function to see if the result is still the same.
	
	@Test
	public void testMapWithIteration() {
		World bob = new World(20, 10, 50);
		bob = bob.iterate();
		StringBuilder first = new StringBuilder();
		first.append("  ");
		first.append(bob.toString());
		String second = bob.OriginaltoString();
		assertEquals(first.toString(), second);
		
		
	}
	
	//Test the toString methods with an entirely empty map.
	@Test
	public void testEmptyMap() {
		World bob = new World(20, 10, 0);
		StringBuilder first = new StringBuilder();
		first.append("  ");
		first.append(bob.toString());
		String second = bob.OriginaltoString();
		assertEquals(first.toString(), second);
		
		
	}
	
	//Test the toString methods with an entirely full map.
		@Test
		public void testFullMap() {
			World bob = new World(20, 10, 100);
			StringBuilder first = new StringBuilder();
			first.append("  ");
			first.append(bob.toString());
			String second = bob.OriginaltoString();
			assertEquals(first.toString(), second);
			
			
		}
	
		//Test the toString methods with a large number of iterations.
		@Test
		public void testLotsIterations() {
			World bob = new World(20, 10, 0);
			
			for (int x = 0; x < 5000; x++){
				bob = bob.iterate();
			}
			
			StringBuilder first = new StringBuilder();
			first.append("  ");
			first.append(bob.toString());
			String second = bob.OriginaltoString();
			assertEquals(first.toString(), second);
			
			
		}
}
