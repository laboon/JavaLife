import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import java.util.Random;

public class toStringTest {

	//test that the size of a world is 0
	@Test
	public void zeroWorld() {
		World test = new World(0, 19, 20);
		String temp=test.toString();
		assertTrue(temp.compareToIgnoreCase(" \n")==0);
		
	}
	
	//test that the size of a world is small
	@Test
	public void smallWorld(){
		World test=new World(3,19,20);
		String temp=test.toString();
		
		assertTrue(temp.startsWith(" 012"));
	}
	
	//test that the size of a world is small
		@Test
		public void mediumWorld(){
			World test=new World(20,19,20);
			String temp=test.toString();
			
			assertTrue(temp.startsWith(" 01234567890123456789"));
		}
		
	
	//test that the size of a world is Max Int
	@Test(expected=OutOfMemoryError.class)
	public void MaxIntWorld(){
		int size = Integer.MAX_VALUE;
		World test = new World(size, 19, 20);
		String worldString = test.toString();
		}
	
	//test a initial world of alive percentage is 100 only has dead cells
	@Test
	public void allDead(){
		World test=new World(20,19,100);
		String temp=test.toString();
		assertFalse(temp.contains("."));
	}
	
	  //test a initial world of alive percentage is 0 only has alive cells
		@Test
		public void allAlive(){
			World test=new World(20,19,0);
			String temp=test.toString();
			
			assertFalse(temp.contains("X"));
		}
		
		//test a initial world of alive percentage is 100 only has dead cells
		@Test
		public void percentage110(){
			World test=new World(5,19,110);		
			String temp=test.toString();
			//System.out.println(temp);
			assertFalse(temp.contains("."));
		}
		
		
		//test a initial world of alive percentage is 100 only has dead cells
		@Test
		public void percentageNegative(){
			World test=new World(5,19,-10);		
			String temp=test.toString();
			System.out.println(temp);
			assertFalse(temp.contains("X"));
		}
		
		
		
}