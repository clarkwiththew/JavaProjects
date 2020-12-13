// **********************************************************
// Assignment2:
// Student1:
// UTORID user_name: wangj930
// UT Student #: 1006390031
// Author: Junheng Wang
//
// Student2:
// UTORID user_name: anadaeth
// UT Student #: 1003171907
// Author: Ethan Ananda
//
// Student3:
// UTORID user_name: shinhy22
// UT Student #: 997743615
// Author: Hyun Woo (Eddie) Shin
//
// Student4:
// UTORID user_name: chouivan
// UT Student #: 1003599732
// Author: Ivanhoe Chou
//
//
// Honor Code: I pledge that this program represents my own
// program code and that I have coded on my own. I received
// help from no one in designing and debugging my program.
// I have also read the plagiarism section in the course info
// sheet of CSC B07 and understand the consequences.
// *********************************************************
package test;

import static org.junit.Assert.*;
import org.junit.Test;
import commands.Ls;
import data.Directory;
import data.FileManager;
import errorHandler.NonvalidArgumentException;
import org.junit.Before;

// TODO: Auto-generated Javadoc
/**
 * The Class LsTest.
 *
 * @author Junheng Wang, Hyun Woo (Eddie) Shin, Ivanhoe Chou, Ethan Anada
 */

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
