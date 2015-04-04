package tests;

import com.laboon.*;

import org.junit.Test;
import static org.junit.Assert.*;

public class toStringTests {
	
    // make sure the string returned by toString is not null
    @Test
    public void toStringNotNullTest() {
        World world = new World(10, 1, 50);
        String str = world.toString();
        assertNotNull(str);
    }
    
    // make sure the string returned by toString is not empty
    @Test
    public void toStringNotEmptyTest() {
    	World world = new World(10, 1, 50);
    	String str = world.toString();
    	assertNotEquals(0, str.length());
    }
    
    // generate a world, and make sure the string returned by toString matches the expected output
    @Test
    public void worldToStringTest() {
    	World world = new World(10, 1, 50);
    	String match = "  0123456789\n" +
    			"0 ..XX.XXX.X\n" +
    			"1 ..X..X....\n" +
    			"2 .XX.....XX\n" +
    			"3 X.XX...X.X\n" +
    			"4 X..X..X.X.\n" +
    			"5 .X..XX.XX.\n" +
    			"6 X.....XX.X\n" +
    			"7 .XX.X..XX.\n" +
    			"8 ..XX.....X\n" +
    			"9 XX.X.XXXX.\n";
    	String str = world.toString();
    	assertEquals(match, str);
    }
    
    // generate a world with no living cells, and make sure the string returned by toString matches the expected output
    @Test
    public void deadWorldToStringTest() {
    	World world = new World(10, 1, 0);
    	String match = "  0123456789\n" +
    			"0 ..........\n" +
    			"1 ..........\n" +
    			"2 ..........\n" +
    			"3 ..........\n" +
    			"4 ..........\n" +
    			"5 ..........\n" +
    			"6 ..........\n" +
    			"7 ..........\n" +
    			"8 ..........\n" +
    			"9 ..........\n";
    	String str = world.toString();
    	assertEquals(match, str);
    }
    
    //generate a world with all living cells, and make sure the string returned by toString matches the expected output
    @Test
    public void thrivingWorldToStringTest() {
    	World world = new World(10, 1, 100);
    	String match = "  0123456789\n" +
    			"0 XXXXXXXXXX\n" +
    			"1 XXXXXXXXXX\n" +
    			"2 XXXXXXXXXX\n" +
    			"3 XXXXXXXXXX\n" +
    			"4 XXXXXXXXXX\n" +
    			"5 XXXXXXXXXX\n" +
    			"6 XXXXXXXXXX\n" +
    			"7 XXXXXXXXXX\n" +
    			"8 XXXXXXXXXX\n" +
    			"9 XXXXXXXXXX\n";
    	String str = world.toString();
    	assertEquals(match, str);
    }
    
    //generate a large world, and make sure the string returned by toString matches the expected output
    @Test
    public void largeWorldToStringTest() {
    	World world = new World(50, 1, 50);
    	String match = "  01234567890123456789012345678901234567890123456789\n" +
                "0 ..XX.XXX.X..X..X.....XX.....XXX.XX...X.XX..X..X.X.\n" +
                "1 .X..XX.XX.X.....XX.X.XX.X..XX...XX.....XXX.X.XXXX.\n" +
                "2 .X...XXXXX...X...X..XX..X.X.XXX..X....XX.XX.......\n" +
                "3 .XX.X...X.X..X.X.X.X.XXX...X.XXXXX..XXX...XXXX.XX.\n" +
                "4 .X.XX.XXXX..X......X....X...X....XXXXXX.XX...X...X\n" +
                "5 XXX.X..X.X.X...X.X..XXX..XXX.XX..XXX.XX.XX.XX.....\n" +
                "6 .X.X.XX.XX.XXX.XX.XXX..X.X...XXX.XX...X.X.X.XX.X..\n" +
                "7 X.......X....X...XX..X..X.XX..X....XX.XXXXXX..X..X\n" +
                "8 XXX.XX..XXXX..XX..X...XX..X...XX.XX.X...X.X...XXX.\n" +
                "9 .XX.XXXX.XXXXXXXXXXXX....X.X.X..X.X.....XX..XX..X.\n" +
                "0 ..XX..X.X.X..X.XXX.XX.XX...XX.XX....X.X.X..XXXX.XX\n" +
                "1 ..XXX..XX.X.X...X..X.X.X.X..XX..X....XXXXX.X.XXXXX\n" +
                "2 .X.....X.XX...X..XX.XX...X..XXXX....X...XXXX..X...\n" +
                "3 ......X.XX..X..X..XXXX.XXXXXXXX.XXXXXX..X...X.XXXX\n" +
                "4 X.X..X.XXX..XX.X.X.X.......XX.X..X.X...XX.XXX.....\n" +
                "5 X...XXX.XXXX...XX.....X.XX..XXX..XX.XXXXXX.XX.X.X.\n" +
                "6 ..XXXXXXX.XX.XX...X...XX.....X.XXXX.XX.XX.X.....X.\n" +
                "7 XXX.X..X..XX...XX..X....XX..XX.XX...X..XX..XX...X.\n" +
                "8 .X..X.XXX...X.X....X..X.XX...XX..XX.XXXX.XX...XX..\n" +
                "9 XX.....XXX...X.X..XX..............XXX.X..X.....X..\n" +
                "0 XXX.X.XX.X.XXXX.X.XXXXX.X..X...XX...XXXXXX...XX...\n" +
                "1 .XXX....X..X.XX..XXX.X.XX.X.X..X.X..XXX..X..X..XX.\n" +
                "2 X....X.......X.X.....XXX.XX....XXXX.XXXXXX.X..XX.X\n" +
                "3 XXXXX..XXX..X.X..X.XXXX..X....X....X..XX...XXXXXX.\n" +
                "4 .X.X..XXX.XXXXXXXXX.XX...X.X..XXXXX..XXXX..X.X..XX\n" +
                "5 .X.XXXX.XX..XX..XX..X..X.XX.X..XXX.XX...X..X.XXXXX\n" +
                "6 XX.XX.XX...XXXX.X..XXXXX....X..XXX...X.XX..X.X....\n" +
                "7 X.XXXX.XXX.XXXXXX..X.X.XX......XX....XX..X..XX.X..\n" +
                "8 .X.XXX...XXXXX...XXX..X.XXX..X......XXX.XX..XX.XXX\n" +
                "9 .....X...X..XXXXXX.XXXX.XX...X..XX...X.X...XX..X..\n" +
                "0 X..X...XXXXX..X..XXX...X.XX.XX..XXXXX.X...XX......\n" +
                "1 .XX.X.X.XXX.XX..X.X..XX.XXX.XXXX.X.XX.XXXX.XX.X.XX\n" +
                "2 .XXX.XX..X.....X.XXXXX.......XXX.X....XX.X..XX..X.\n" +
                "3 X.XX..X.X.X.XX.XXXXXXXX.....XXX..X..X....XXXX.XXX.\n" +
                "4 .X..X.X.X..XX...XX..XX.....X...X....XXXXX.X.X.XXX.\n" +
                "5 ....X.X.X..XXX...XXXX....X.....X.XXX...XX..XX.X...\n" +
                "6 .XX...XXXXX..X..X..X...XX.X...XX..XXXXXXX.X..X...X\n" +
                "7 ..XXX.X...XX.X.X.XXXX.XXXXXX....X....XX..X.X...XXX\n" +
                "8 .XX.XX..X.X...X..XX.X.X..XXX....X.....XXX...XXXX.X\n" +
                "9 XXX..XX.XXXXXX.XXXXXXXXX..XX.XX.XXXXX....X.X..X...\n" +
                "0 X...XX..X...X..XXXXXX..X..XX..XX.X.X.....XXXXXXX.X\n" +
                "1 XXX.X.X..XX..X......X....XXXX.....XXX.X..X....X.X.\n" +
                "2 ....X...X...XX.XX.X.X.XX.XXX.XXXX.......X.......XX\n" +
                "3 XXXX.X.X.XX.X.XXXXXXXXX...XX.X..XXX..X..X......XX.\n" +
                "4 XX.XX.XXXXX.X.XX..XX..XX...X.X.X.XX.XX.XXXXX.X..X.\n" +
                "5 ....X.X.....XXX.XX.XXXX.XX....XX.XXXXX....XX.XX.XX\n" +
                "6 X.XX..X.XX.XXX..X..XXXX..XXXX.XXX..X.XX.XXXXXX.X.X\n" +
                "7 ..XXXX.XX...XX.XX..XXX.X.X.X.X...XX.X.XX.XXXXX.XXX\n" +
                "8 X...X.X....X.XX.XX.XXXXX.X.XXX...XX.X.X.X.X...XX.X\n" +
                "9 ..XXX.XX...X.X..X..X...X.XXX.X.X...X...XXX.XX...XX\n";
    	String str = world.toString();
    	assertEquals(match, str);
    }
    
    //generate a small world, and make sure the string returned by toString matches the expected output
    @Test
    public void smallWorldToStringTest() {
    	World world = new World(1, 1, 50);
    	String match = "  0\n" +
    			"0 .\n";
    	String str = world.toString();
    	assertEquals(match, str);
    }

    //generate an empty world, and make sure the string returned by toString matches the expected output
    @Test
    public void emptyWorldToStringTest() {
    	World world = new World(0, 1, 0);
    	String match = "  \n";			// what output should look like with size 0
    	String str = world.toString();
    	assertEquals(match, str);
    }
    
    //generate an empty world, then iterate it once, and make sure the string returned by toString matches the expected output
    //this ensures that the toString method correctly captures the representation of the world after it has changed
    @Test
    public void iterateWorldToStringTest() {
    	World world = new World(10, 1, 50);
    	World iter = world.iterate();
    	String match = "  0123456789\n" +
    			"0 X..X.....X\n" +
    			"1 X...XX.X.X\n" +
    			"2 ........XX\n" +
    			"3 ...X...X..\n" +
    			"4 X..X.XX...\n" +
    			"5 .X..XX....\n" +
    			"6 X.XXX....X\n" +
    			"7 .XX...XX..\n" +
    			"8 .....X...X\n" +
    			"9 XX...X....\n";
    	String str = iter.toString();
    	assertEquals(match, str);
    }
}