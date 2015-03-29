import com.laboon.World;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Joshua Zwolan on 3/24/2015.
 *
 * NOTE: World.toString_OLD() is the old non-refactored method
 */
public class World_Test
{
    /*
    -   Default Values
    -   Used as Constants when the value is not being changed in Testing
     */
    final int SIZE =        50;
    final int SEED =        9001;
    final int PERCENT =     55;

    /**
     * The Following Tests the Default Values as defined Above
     */
    /*
    -   Test to Make Sure Size of 50, Seed of 9001, and Percent of 55 Works
    -   Uses Default Values for Size, Seed, and Percent
    -   Expected Results:   World.toString() results matches World.toString_OLD() results
     */
    @Test
    public void test_toString_CompareVersions_DEFAULT_VALUES()
    {
        World w = new World(SIZE, SEED, PERCENT);
        assertEquals(w.toString_OLD(), w.toString());
    }

    /**
     * The Following Tests ensure that changing the Size Works
     * No Iterations
     */
    /*
    -   Test to Make Sure Size of 25 Works
    -   Uses Default Values for Seed and Percent
    -   Expected Results:   World.toString() results matches World.toString_OLD() results
     */
    @Test
    public void test_toString_CompareVersions_Size_25()
    {
        World w = new World(25, SEED, PERCENT);
        assertEquals(w.toString_OLD(), w.toString());
    }

    /*
    -   Test to Make Sure Size of 0 Works -> Edge Case
    -   Uses Default Values for Seed and Percent
    -   Expected Results:   World.toString() results matches World.toString_OLD() results
     */
    @Test
    public void test_toString_CompareVersions_Size_0()
    {
        World w = new World(0, SEED, PERCENT);
        assertEquals(w.toString_OLD(), w.toString());
    }

    /*
    -   Test to Make Sure Size of 250 Works
    -   Uses Default Values for Seed and Percent
    -   Expected Results:   World.toString() results matches World.toString_OLD() results
     */
    @Test
    public void test_toString_CompareVersions_Size_250()
    {
        World w = new World(250, 13, 65);
        assertEquals(w.toString_OLD(), w.toString());
    }


    /**
     * The Following Tests ensure that changing the Size Works
     * Includes 1 Iteration
     */
    /*
    -   Test to Make Sure Size of 25 Works
    -   Uses Default Values for Seed and Percent
    -   Iterate Once to make sure Iterations does not effect Results of World.toString()
    -   Expected Results:   World.toString() results matches World.toString_OLD() results
     */
    @Test
    public void test_toString_CompareVersions_Size_25_Iteration()
    {
        World w = new World(25, SEED, PERCENT);
        w = w.iterate();
        assertEquals(w.toString_OLD(), w.toString());
    }

    /*
    -   Test to Make Sure Size of 0 Works -> Edge Case
    -   Uses Default Values for Seed and Percent
    -   Iterate Once to make sure Iterations does not effect Results of World.toString()
    -   Expected Results:   World.toString() results matches World.toString_OLD() results
     */
    @Test
    public void test_toString_CompareVersions_Size_0_Iteration()
    {
        World w = new World(0, SEED, PERCENT);
        w = w.iterate();
        assertEquals(w.toString_OLD(), w.toString());
    }

    /*
    -   Test to Make Sure Size of 250 Works
    -   Uses Default Values for Seed and Percent
    -   Iterate Once to make sure Iterations does not effect Results of World.toString()
    -   Expected Results:   World.toString() results matches World.toString_OLD() results
     */
    @Test
    public void test_toString_CompareVersions_Size_250_Iteration()
    {
        World w = new World(250, SEED, PERCENT);
        w = w.iterate();
        assertEquals(w.toString_OLD(), w.toString());
    }


    /**
     * The Following Tests ensure that changing the Percent Alive Works
     * No Iterations
     */
    /*
    -   Test to Make Sure Percent Alive of 65 Works
    -   Uses Default Values for Size and Seed
    -   Expected Results:   World.toString() results matches World.toString_OLD() results
     */
    @Test
    public void test_toString_CompareVersions_Alive_65()
    {
        World w = new World(SIZE, SEED, 65);
        assertEquals(w.toString_OLD(), w.toString());
    }

    /*
    -   Test to Make Sure Percent Alive of 0 Works -> Edge Case
    -   Uses Default Values for Size and Seed
    -   Expected Results:   World.toString() results matches World.toString_OLD() results
     */
    @Test
    public void test_toString_CompareVersions_Alive_0()
    {
        World w = new World(SIZE, SEED, 0);
        assertEquals(w.toString_OLD(), w.toString());
    }

    /*
    -   Test to Make Sure Percent Alive of 100 Works -> Edge Case
    -   Uses Default Values for Size and Seed
    -   Expected Results:   World.toString() results matches World.toString_OLD() results
     */
    @Test
    public void test_toString_CompareVersions_Alive_100()
    {
        World w = new World(SIZE, SEED, 100);
        assertEquals(w.toString_OLD(), w.toString());
    }


    /**
     * The Following Tests ensure that changing the Percent Alive Works
     * Includes 1 Iteration
     */
    /*
    -   Test to Make Sure Percent Alive of 65 Works
    -   Uses Default Values for Size and Seed
    -   Iterate Once to make sure Iterations does not effect Results of World.toString()
    -   Expected Results:   World.toString() results matches World.toString_OLD() results
     */
    @Test
    public void test_toString_CompareVersions_Alive_65_Iteration()
    {
        World w = new World(SIZE, SEED, 65);
        w = w.iterate();
        assertEquals(w.toString_OLD(), w.toString());
    }

    /*
    -   Test to Make Sure Percent Alive of 0 Works -> Edge Case
    -   Uses Default Values for Size and Seed
    -   Iterate Once to make sure Iterations does not effect Results of World.toString()
    -   Expected Results:   World.toString() results matches World.toString_OLD() results
     */
    @Test
    public void test_toString_CompareVersions_Alive_0_Iteration()
    {
        World w = new World(SIZE, SEED, 0);
        w = w.iterate();
        assertEquals(w.toString_OLD(), w.toString());
    }

    /*
    -   Test to Make Sure Percent Alive of 100 Works -> Edge Case
    -   Uses Default Values for Size and Seed
    -   Iterate Once to make sure Iterations does not effect Results of World.toString()
    -   Expected Results:   World.toString() results matches World.toString_OLD() results
     */
    @Test
    public void test_toString_CompareVersions_Alive_100_Iteration()
    {
        World w = new World(SIZE, SEED, 100);
        w = w.iterate();
        assertEquals(w.toString_OLD(), w.toString());
    }
}
