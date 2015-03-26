package com.laboon;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class WorldTest {

	@Test
	public void testsmallgrid() {
		World w = new World(4, 4, 4);
		//System.out.println(w.toString());
		assertEquals(w.toString(),"  0123\n0 ..X.\n1 ....\n2 ....\n3 ....\n");	
	}
	
	@Test
	public void testallzeros() {
		World w = new World(0, 0, 0);
		//System.out.println(w.toString());
	    assertEquals(w.toString(),"  \n");	
	}
	
	@Test
	public void testamidgrid() {
		World w = new World(10, 20, 20);
		//System.out.println(w.toString());
	    assertEquals(w.toString(),"  0123456789\n0 ..X.X.....\n1 ..........\n2 ........XX\n3 ..X.....X.\n4 XX.XX...X.\n5 XX..X.X.X.\n6 ....X.....\n7 XX...XX...\n8 ...X...X..\n9 ..........\n");
	}

	@Test
	public void testallfull() {
		World w = new World(4, 0, 100);
		System.out.println(w.toString());
		assertEquals(w.toString(),"  0123\n0 XXXX\n1 XXXX\n2 XXXX\n3 XXXX\n");	
	}
	
	@Test
	public void testallempty() {
		World w = new World(4, 0, 0);
		System.out.println(w.toString());
		assertEquals(w.toString(),"  0123\n0 ....\n1 ....\n2 ....\n3 ....\n");	
	}

}
