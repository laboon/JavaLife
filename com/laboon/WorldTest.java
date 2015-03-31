/**
 * Created by steven on 3/31/15.
 */

package com.laboon;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


public class WorldTest {

    @Test
    public void testZero(){
    	World testWorld = new World(0,25,25);
    	String out =  testWorld.toString();
    	assertEquals("  \n", out);
    }

    @Test
    public void testSeed(){
    	World testWorld = new World(2,25,25);
    	String out =  testWorld.toString();
    	String expected = "  01\n0 ..\n1 ..";
    	assertEquals(expected, out);
    }

    @Test
    public void testDead(){
    	World testWorld = new World(2, 25, 0);
    	String out = testWorld.toString();
    	String expected = "  01\n0 ..\n1 ..";
    	assertEquals(expected, out);
    }

    @Test
    public void testAlive(){
    	World testWorld = new World(2,25,100);
    	String out = testWorld.toString();
    	String expected =   "01\n0 XX\n1 XX"
    	assertEquals(expected, out);
    }

}
