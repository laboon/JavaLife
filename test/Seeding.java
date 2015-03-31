import static org.junit.Assert.*;
import org.junit.*;
import static org.mockito.Mockito.*;
import java.util.*;
import java.io.*;

public class Seeding
{
    public void seed25() throws Exception
    {
        BufferedReader inFile = new BufferedReader(new FileReader("misc/outputA.txt"));
        StringBuilder before = new StringBuilder();
        while (inFile.ready())
            before.append(inFile.read());

        inFile = new BufferedReader(new FileReader("misc/output_seedA.txt"));
        StringBuilder after = new StringBuilder();
        while (inFile.ready())
            after.append(inFile.read());

        inFile.close();

        assertFalse(before.toString().equals(after.toString()));
    }

    @Test
    //Compares the output of two files to make sure they are not equal
    //Uses outputs generated with different seeds, should not ever be the same
    //output2A.txt used:         > java JavaLife 25 0 10 1
    //output_seed2A.txt used:    > java JavaLife 25 1 10 1
    public void seed25_2() throws Exception
    {
        BufferedReader inFile = new BufferedReader(new FileReader("misc/output2A.txt"));
        StringBuilder before = new StringBuilder();
        while (inFile.ready())
            before.append(inFile.read());

        inFile = new BufferedReader(new FileReader("misc/output_seed2A.txt"));
        StringBuilder after = new StringBuilder();
        while (inFile.ready())
            after.append(inFile.read());

        inFile.close();

        assertFalse(before.toString().equals(after.toString()));
    }

    @Test
    //Compares the output of two files to make sure they are not equal
    //Uses outputs generated with different seeds, should not ever be the same
    //outputB.txt used:         > java JavaLife 50 0 10 1
    //output_seedB.txt used:    > java JavaLife 50 1 10 1
    public void seed50() throws Exception
    {
        BufferedReader inFile = new BufferedReader(new FileReader("misc/outputB.txt"));
        StringBuilder before = new StringBuilder();
        while (inFile.ready())
            before.append(inFile.read());

        inFile = new BufferedReader(new FileReader("misc/output_seedB.txt"));
        StringBuilder after = new StringBuilder();
        while (inFile.ready())
            after.append(inFile.read());

        inFile.close();

        assertFalse(before.toString().equals(after.toString()));
    }

    @Test
    //Compares the output of two files to make sure they are not equal
    //Uses outputs generated with different seeds, should not ever be the same
    //output2B.txt used:         > java JavaLife 50 0 10 1
    //output_seed2B.txt used:    > java JavaLife 50 1 10 1
    public void seed50_2() throws Exception
    {
        BufferedReader inFile = new BufferedReader(new FileReader("misc/output2B.txt"));
        StringBuilder before = new StringBuilder();
        while (inFile.ready())
            before.append(inFile.read());

        inFile = new BufferedReader(new FileReader("misc/output_seed2B.txt"));
        StringBuilder after = new StringBuilder();
        while (inFile.ready())
            after.append(inFile.read());

        inFile.close();

        assertFalse(before.toString().equals(after.toString()));
    }

    @Test
    //Compares the output of two files to make sure they are not equal
    //Uses outputs generated with different seeds, should not ever be the same
    //outputC.txt used:         > java JavaLife 100 0 10 1
    //output_seedC.txt used:    > java JavaLife 100 1 10 1
    public void seed100() throws Exception
    {
        BufferedReader inFile = new BufferedReader(new FileReader("misc/outputC.txt"));
        StringBuilder before = new StringBuilder();
        while (inFile.ready())
            before.append(inFile.read());

        inFile = new BufferedReader(new FileReader("misc/output_seedC.txt"));
        StringBuilder after = new StringBuilder();
        while (inFile.ready())
            after.append(inFile.read());

        inFile.close();

        assertFalse(before.toString().equals(after.toString()));
    }

    @Test
    //Compares the output of two files to make sure they are not equal
    //Uses outputs generated with different seeds, should not ever be the same
    //output2C.txt used:         > java JavaLife 100 0 10 1
    //output_seed2C.txt used:    > java JavaLife 100 1 10 1
    public void seed100_2() throws Exception
    {
        BufferedReader inFile = new BufferedReader(new FileReader("misc/output2C.txt"));
        StringBuilder before = new StringBuilder();
        while (inFile.ready())
            before.append(inFile.read());

        inFile = new BufferedReader(new FileReader("misc/output_seed2C.txt"));
        StringBuilder after = new StringBuilder();
        while (inFile.ready())
            after.append(inFile.read());

        inFile.close();

        assertFalse(before.toString().equals(after.toString()));
    }
}
