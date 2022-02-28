
package test;

import static org.junit.Assert.*;
import org.junit.Test;
import commands.Ls;
import data.Directory;
import data.FileManager;
import errorHandler.NonvalidArgumentException;
import org.junit.Before;

// TODO: Auto-generated Javadoc


public class LsTest {

  /** The ls. */
  Ls ls = new Ls();

  /** The Mock FM. */
  private MockFileManager MockFM;

  /**
   * LsTest command set up.
   */

  @Before
  public void setUp() {
    // Initialize the MFS
    MockFM = new MockFileManager();
  }

  /**
   * Noparam.
   *
   * @throws NonvalidArgumentException the nonvalid argument exception
   */
  @Test
  public void noparam() throws NonvalidArgumentException {
    String[] inputArrayString = {"ls"};
    String actualOutput = ls.run(MockFM, inputArrayString);
    String expectedOutput = "";
    assertEquals(actualOutput, expectedOutput);
  }

  /**
   * paramTest.
   *
   * @throws NonvalidArgumentException the nonvalid argument exception
   */
  @Test
  public void paramTest() throws NonvalidArgumentException {
    try {
      Directory temp1 = new Directory("temp1", MockFM.getCurrent());
      MockFM.getCurrent().setDirectory("temp1", temp1);
      String[] inputArrayString = {"ls", "/"};
      String actualOutput = ls.run(MockFM, inputArrayString);
      String expectedOutput = "/:";
      assertEquals(actualOutput, expectedOutput);
    } catch (NonvalidArgumentException e) {
      assertEquals(e.getMessage(), e.getMessage());
    }
  }


  /**
   * Nonvalidinput.
   *
   * @throws NonvalidArgumentException the nonvalid argument exception
   */
  @Test
  /**
   * Nonvalid input
   */

  public void nonvalidinput() throws NonvalidArgumentException {
    try {
      String[] inputArrayString = {"ls", "test1"};
      String actualOutput = ls.run(MockFM, inputArrayString);
      String expectedOutput = "you have a nonvalid input, could not find the path";
      assertEquals(actualOutput, expectedOutput);
      fail();
    } catch (NonvalidArgumentException e) {
      assertEquals(e.getMessage(), "you have a nonvalid input, could not find the path");
    }
  }
  
  



}
