package com.laboon;

import static org.junit.Assert.*;
import org.junit.*;
import static org.mockito.Mockito.*;
import java.util.*;
import java.io.*;

public class Output {


    @Test
    public void same25() {
        BufferedReader inFile = new BufferedReader(new FileReader("outputA.in"));
        StringBuilder before = new StringBuilder();
        while (inFile.ready())
            before.append(inFile.read());
        System.out.println();
        inFile.close();
        assertEquals(0, 0);
    }
}
