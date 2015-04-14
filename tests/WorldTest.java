import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class WorldTest
{
    @Test
    public void testToString() throws Exception
    {
        World   testWorld_1 = new World(5, 1, 10),
                testWorld_2 = new World(5, 2, 10),
                testWorld_3 = new World(0, 1, 10),
                testWorld_4 = new World(5, 1, 100),
                testWorld_5 = new World(5, 1, 0),
                testWorld_6 = new World(11, 1, 10);

        String  expectedString_1 =  "  01234\n0 .....\n1 X.X..\n2 .....\n3 .....\n4 .....\n",
                expectedString_2 =  "  01234\n0 XXXXX\n1 XXXXX\n2 XXXXX\n3 XXXXX\n4 XXXXX\n",
                expectedString_3 =  "  01234\n0 .....\n1 .....\n2 .....\n3 .....\n4 .....\n",
                expectedString_4 =  "  01234567890\n0 .....X.X...\n1 ...........\n2 .......XX.X\n3 X..........\n" +
                                    "4 ....X......\n5 ...X.X.....\n6 X..........\n7 .X....X....\n8 ........XX.\n" +
                                    "9 .......X.X.\n0 ..........X\n";


        // Test 1: Matching Worlds
        assertEquals(testWorld_1.toString(), expectedString_1);

        // Test 2: Non-matching Worlds
        assertNotEquals(testWorld_2.toString(), expectedString_1);

        // Test 3: 0 sized World
        assertEquals(testWorld_3.toString(), "  \n");

        // Test 4: Full World
        assertEquals(testWorld_4.toString(), expectedString_2);

        // Test 5: Empty World
        assertEquals(testWorld_5.toString(), expectedString_3);

        // Test 6: World sized > 10
        assertEquals(testWorld_6.toString(), expectedString_4);
    }
}