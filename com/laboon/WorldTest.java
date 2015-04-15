package com.laboon;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

public class WorldTest {

  /**
   * Test that the right number of rows and columns were displayed
   */
  @Test
  public void verifyNumberOfRowsAndColumns() {
    World world = new World(5, 51234, 60);
    String str = world.toString();

    assertThat(str, startsWith("  01234\n"));
    int newLineCounter = 0;
    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      if (c == '\n') {
        newLineCounter++;
      }
    }
    assertEquals(6, newLineCounter);
  }


  /**
   * Test that row numbers greater than 10 are truncated to the "ones'" place.
   */
  @Test
  public void verifyRowAndColumnLabels() {
    World world = new World(13, 51234, 60);
    String str = world.toString();
    assertThat(str, not(containsString("13")));
  }


  /**
   * Test that the right number of "alive" cells were displayed.
   */
  @Test
  public void verifyNumberOfLivingCells() {
    World world = new World(5, 51234, 60);
    String str = world.toString();

    int numLivingInWorld = 0;
    for (int i = 0; i < world._size; i++) {
      for (int j = 0; j < world._size; j++) {
        if (world._world[i][j].isAlive()) {
          numLivingInWorld++;
        }
      }
    }

    int numLivingInString = 0;
    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      if (c == 'X' || c == 'x') {
        numLivingInString++;
      }
    }

    assertEquals(numLivingInWorld, numLivingInString);
  }
}

