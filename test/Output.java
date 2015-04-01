import static org.junit.Assert.*;
import org.junit.*;
import static org.mockito.Mockito.*;
import java.util.*;
import java.io.*;

public class Output
{
    @Test
    //Tests that OutputA matches Output2A
    //Both are generated with the command:
    //> java JavaFile 25 0 10 1
    //Reads the files into memory as strings and runs .equals() on them
    public void same25() throws Exception
    {
        BufferedReader inFile = new BufferedReader(new FileReader("misc/outputA.txt"));
        StringBuilder before = new StringBuilder();
        while (inFile.ready())
            before.append(inFile.read());

        inFile = new BufferedReader(new FileReader("misc/output2A.txt"));
        StringBuilder after = new StringBuilder();
        while (inFile.ready())
            after.append(inFile.read());

        inFile.close();

        assertTrue(before.toString().equals(after.toString()));
    }

    @Test
    //Tests that OutputB matches Output2B
    //Both are generated with the command:
    //> java JavaFile 50 0 10 1
    //Reads the files into memory as strings and runs .equals() on them
    public void same50() throws Exception
    {
        BufferedReader inFile = new BufferedReader(new FileReader("misc/outputB.txt"));
        StringBuilder before = new StringBuilder();
        while (inFile.ready())
            before.append(inFile.read());

        inFile = new BufferedReader(new FileReader("misc/output2B.txt"));
        StringBuilder after = new StringBuilder();
        while (inFile.ready())
            after.append(inFile.read());

        inFile.close();

        assertTrue(before.toString().equals(after.toString()));
    }

    @Test
    //Tests that OutputC matches Output2C
    //Both are generated with the command:
    //> java JavaFile 100 0 10 1
    //Reads the files into memory as strings and runs .equals() on them
    public void same100() throws Exception
    {
        BufferedReader inFile = new BufferedReader(new FileReader("misc/outputC.txt"));
        StringBuilder before = new StringBuilder();
        while (inFile.ready())
            before.append(inFile.read());

        inFile = new BufferedReader(new FileReader("misc/output2C.txt"));
        StringBuilder after = new StringBuilder();
        while (inFile.ready())
            after.append(inFile.read());

        inFile.close();

        assertTrue(before.toString().equals(after.toString()));
    }
}
