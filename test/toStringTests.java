/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import com.laboon.*;

/**
 *
 * @author micha_000
 */
public class toStringTests {
    
    //Creates a new world with a 10 by 10 grid, checks to see if the first row
    //displays the correct number of columns
    @Test
    public void checkingColumnValues10() 
    {
        World world = new World (10, 4, 30);
        
        String firstRow = world.toString().split("\n")[0];
        assertEquals(firstRow, "  0123456789");
    }    

    //Creates a new world with a 15 by 15 grid, checks to see if the first row
    //displays the correct number of columns
    @Test
    public void checkingColumnValues15() 
    {
        World world = new World (15, 4, 30);
        
        String firstRow = world.toString().split("\n")[0];
        assertEquals(firstRow, "  012345678901234");
    }          
    
    //Creates a new world with a 20 by 20 grid, checks to see if the first row
    //displays the correct number of columns    
    @Test
    public void checkingColumnValues20() 
    {
        World world = new World (20, 4, 30);
        
        String firstRow = world.toString().split("\n")[0];
        assertEquals(firstRow, "  01234567890123456789");
    }    
      
    //Creates a new world with a 1 by 1 grid, checks to see if the original and
    //modified toString methods are equal. 
    @Test
    public void checkingMap1()
    {
        World world = new World (1, 5, 30);
        
        assertEquals(world.toString(), world.toStringOriginal());        
    }

    //Creates a new world with a 10 by 10 grid, checks to see if the original and
    //modified toString methods are equal.     
    @Test
    public void checkingMap10()
    {
        World world = new World (10, 5, 30);
        
        assertEquals(world.toString(), world.toStringOriginal());        
    }    

    //Creates a new world with a 30 by 30 grid, checks to see if the original and
    //modified toString methods are equal.     
    @Test
    public void checkingMap30()
    {
        World world = new World (30, 6, 40);
        
        assertEquals(world.toString(), world.toStringOriginal());        
    }    

    //Creates a new world with a 1 by 1 grid, checks to see if the original and
    //modified toString methods are equal.     
    @Test
    public void checkingMap100()
    {
        World world = new World (100, 6, 40);
        
        assertEquals(world.toString(), world.toStringOriginal());        
    }            

    
    //Creates a new world with a 100 by 100 grid, checks to see if the original and
    //modified toString methods are equal with an empty map     
    @Test
    public void checkingMapEmpty()
    {
        World world = new World (100, 6, 0);
        
        assertEquals(world.toString(), world.toStringOriginal());        
    }    

    //Creates a new world with a 100 by 100 grid, checks to see if the original and
    //modified toString methods are equal with a full map
    @Test
    public void checkingMapFull()
    {
        World world = new World (30, 6, 100);
        
        assertEquals(world.toString(), world.toStringOriginal());        
    }    

    //Creates a new world with a 30 by 30 grid, checks to see if the original and
    //modified toString methods are equal with a map initially 20% full.
    //Goes through a 1000 iteration comparing the original and modified toString Methods
    @Test
    public void checkingMapIterate()
    {
        World world = new World (30, 6, 20);
        
        assertEquals(world.toString(), world.toStringOriginal());  
        
        for(int i = 0; i < 1000; i++)
        {
            world = world.iterate();
            assertEquals(world.toString(), world.toStringOriginal());  
        }
    }        

    
}
