package com.laboon;
import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;


public class Test_toString {

	/*
	 * First will see that if a JavaLife is created
	 * with values it's toString() is not empty
	 */

	@Test
	public void NotEmptyTest() {
		JavaLife jl = new JavaLife(170, 50, 75, 100);
		assertNotEquals(jl.toString(),"");
	}
	
	/*
	 * This test creates two identical worlds and makes sure that their toString() is identical to one another
	 * This is important to know that copies can be made
	 */
	
	@Test
	public void SameTest() {
		World w=new World(4, 18, 26);
		World w2=new World(4,18,26);
		
		assertEquals(w.toString(),w2.toString());
	}
	/*
	 * This test creates two different worlds and makes sure that their toString() is not identical to one another
	 * This is important to know that different arguments produce different worlds
	 */
	
	@Test
	public void DifferentWorldTest() {
		World w=new World(7, 43, 33);
		World w2=new World(9,2,8);
		assertNotEquals(w.toString(),w2.toString());
	}
	/*
	 * Tests to see if 
	 * making world with the second constructor leads to the same output
	 * Results show this test as a failure.
	 */
	
	@Test
	public void SameWorldNewTest2()
	{
		Random m =new Random(15);
		Cell[][] c= new Cell[70][100];
		
		World w=new World(c, m);
		World w2=new World(c,m);
			
		assertTrue(w.toString().equals(w2.toString()));
	
	}
	/*
	 * Tests to see if 
	 * making world with the second constructor leads to the same output for both
	 * w2 was set to w so there should be no difference in the output.
	 * This leads me to deduce that the constructor is at fault and not the toString()
	 */
	
	@Test
	public void SameWorldCopyTest2()
	{
		Random m =new Random(15);
		Cell[][] c= new Cell[70][100];
		
		World w=new World(c, m);
		World w2=w;
			
		assertTrue(w.toString().equals(w2.toString()));
	
	}

}
