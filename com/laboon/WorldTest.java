//Code written by Mike Byrne
//	mjb187@pitt.edu

import static org.junit.Assert.*;
import org.junit.Test;

// NOTE:
//	Though some of these tests implicitly test other aspects of the code (ex: the full/empty tests),
//	I designed these tests assuming that the rest of the program had been properly tested and verified.
//	The unit tests below are testing that the toString() method appropriately outputs these situations;
//	for example, the fullWorld test: I assume a full world is properly generated and then test that the
//	toString() method properly displays it (n*n Xs). It would not make sense to test percentages less
//	than zero or greater than 100 because the World object should handle that kind of input and never
//	get to the toString() method (though it doesn't look like your code checks for percentages >100).

public class WorldTest {
	
	//check that the grid display has the correct dimensions
	@Test
	public void testToString_dimensions() 
	{
		int n = 5;
		World test = new World(5, 1699, 30);
		
		String s = test.toString();
		//System.out.println(s);
		
		int count = 0;
		for(int i = 0; i < s.length(); i++)
		{
			if(s.charAt(i) == '.' || s.charAt(i) == 'X')
				count++;
		}
		
		//account for initial row header
		assertEquals(n*n, count);
	}
	
	//check that the grid displays empty worlds correctly
	@Test
	public void testToString_emptyWorld() 
	{
		int n = 5;
		World test = new World(5, 1699, 0);
		
		String s = test.toString();
		//System.out.println(s);
		
		int count = 0;
		for(int i = 0; i < s.length(); i++)
		{
			if(s.charAt(i) == '.')
				count++;
		}
		
		//account for initial row header
		assertEquals(n*n, count);
	}
	
	//check that the grid displays full worlds correctly
	@Test
	public void testToString_fullWorld() 
	{
		int n = 5;
		World test = new World(5, 1699, 100);
		
		String s = test.toString();
		//System.out.println(s);
		
		int count = 0;
		for(int i = 0; i < s.length(); i++)
		{
			if(s.charAt(i) == 'X')
				count++;
		}
		
		//account for initial row header
		assertEquals(n*n, count);
	}
	
	//check that the first iteration differs from the initial world
	@Test
	public void testToString_iteration() 
	{
		World test = new World(25, 1699, 30);
		
		String s1 = test.toString();

		test = test.iterate();
		
		String s2 = test.toString();
		
		//System.out.println(s1 + "\n\n" + s2);
		assertNotEquals(s1, s2);
	}

	//check that the initial world setup matches the expected string
	@Test
	public void testToString_expectedInitial() 
	{
		World test = new World(5, 1699, 30);
		
		String s = test.toString();
		String c = "  01234\n0 X.X..\n1 .X...\n2 X....\n3 X.X..\n4 ..XX.\n";
		
		//System.out.println(s);
		assertEquals(s, c);
	}
	
	//check that the initial world setup matches the expected string
	@Test
	public void testToString_expectedIterated() 
	{
		World test = new World(5, 1699, 30);
		
		for(int i = 0; i < 42; i++)
		{
			test = test.iterate();
		}
		
		String s = test.toString();
		String c = "  01234\n0 .....\n1 .....\n2 .....\n3 .....\n4 .....\n";
		
		//System.out.println(s);
		assertEquals(s, c);
	}
	
	//check that two identical worlds produce the same results initially
	@Test
	public void testToString_sameInitial() 
	{
		World test1 = new World(25, 1699, 30);
		World test2 = new World(25, 1699, 30);
		
		String s1 = test1.toString();
		String s2 = test2.toString();
		
		//System.out.println(s1 + "\n\n" + s2);
		assertEquals(s1, s2);
	}
	
	//check that two identical worlds produce the same results after some iterations
	@Test
	public void testToString_sameIterated() 
	{
		World test1 = new World(25, 1699, 30);
		World test2 = new World(25, 1699, 30);
		
		for(int i = 0; i < 42; i++)
		{
			test1 = test1.iterate();
			test2 = test2.iterate();
		}
		
		String s1 = test1.toString();
		String s2 = test2.toString();
		
		//System.out.println(s1 + "\n\n" + s2);
		assertEquals(s1, s2);
	}
	
	//check that two different worlds produce different results after initially
	@Test
	public void testToString_differentInitial() 
	{
		World test1 = new World(25, 1699, 30);
		World test2 = new World(25, 1337, 30);
		
		String s1 = test1.toString();
		String s2 = test2.toString();
		
		//System.out.println(s1 + "\n\n" + s2);
		assertNotEquals(s1, s2);
	}
	
	//check that two different worlds produce different results after some iterations
	@Test
	public void testToString_differentIterated() 
	{
		World test1 = new World(25, 1699, 30);
		World test2 = new World(25, 1337, 30);
		
		for(int i = 0; i < 42; i++)
		{
			test1 = test1.iterate();
			test2 = test2.iterate();
		}
		
		String s1 = test1.toString();
		String s2 = test2.toString();
		
		//System.out.println(s1 + "\n\n" + s2);
		assertNotEquals(s1, s2);
	}

}
