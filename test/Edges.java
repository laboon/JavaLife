import static org.junit.Assert.*;
import org.junit.*;
import static org.mockito.Mockito.*;
import java.util.*;
import java.io.*;

public class Edges
{
    //Test two files to make sure they are equal
    //These files were generated with 0% live tiles
    //output_edgeA.txt used:    > java JavaFile 10 0 0 0
    //output_edge2A.txt used:   > java JavaFile 10 0 0 0
    //These files should always be equal
    public void edge0() throws Exception
    {
        BufferedReader inFile = new BufferedReader(new FileReader("misc/output_edgeA.txt"));
        StringBuilder before = new StringBuilder();
        while (inFile.ready())
            before.append(inFile.read());

        inFile = new BufferedReader(new FileReader("misc/output_edge2A.txt"));
        StringBuilder after = new StringBuilder();
        while (inFile.ready())
            after.append(inFile.read());

        inFile.close();

        assertTrue(before.toString().equals(after.toString()));
    }

    //Test two files to make sure they are equal
    //These files were generated with 0% live tiles
    //output_edgeB.txt used:    > java JavaFile 10 0 100 0
    //output_edge2B.txt used:   > java JavaFile 10 0 100 0
    //These files should always be equal
    public void edge1() throws Exception
    {
        BufferedReader inFile = new BufferedReader(new FileReader("misc/output_edgeB.txt"));
        StringBuilder before = new StringBuilder();
        while (inFile.ready())
            before.append(inFile.read());

        inFile = new BufferedReader(new FileReader("misc/output_edge2B.txt"));
        StringBuilder after = new StringBuilder();
        while (inFile.ready())
            after.append(inFile.read());

        inFile.close();

        assertTrue(before.toString().equals(after.toString()));
    }
}
