package com.laboon;
import static org.junit.Assert.*;

import org.junit.Test;

public class WorldTest {

	//ensures the string built is not null
	@Test
	public void toStringNulltest() {
		JavaLife JL = new JavaLife(10, 20, 25, 30);
		assertNotEquals(JL.toString(), null);
	}
	
}
