// **********************************************************

// *********************************************************
package test;

import static org.junit.Assert.*;
import org.junit.Test;
import commands.Tree;
import commands.SaveJShell;
import commands.Search;
import data.Directory;
import data.FileManager;
import errorHandler.NonvalidArgumentException;
import org.junit.Before;

/**
 * @author Junheng Wang, Hyun Woo (Eddie) Shin, Ivanhoe Chou, Ethan Anada
 */

public class TreeTest {

  Tree tree = new Tree();
  private MockFileManager MockFM;	

  /**
   * 
   * Tree command set up
   */

  @Before
  public void setUp() {
    MockFM = new MockFileManager();
  }

  @Test
  public void NoInput() throws NonvalidArgumentException {
    try {
      String[] inputArrayString = {"tree", "test"};
      String actualOutput = tree.run(MockFM, inputArrayString);
      String expectedOutput = "error with arguments, only 1 argument expected";
      assertEquals(actualOutput, expectedOutput);
      fail();
    } catch (NonvalidArgumentException e) {
      assertEquals(e.getMessage(), "error with arguments, only 1 argument expected");
    }
  }

  @Test
  public void ValidInput() throws NonvalidArgumentException {
    String[] inputArrayString = {"tree"};
    String actualOutput = tree.run(MockFM, inputArrayString);
    String expectedOutput = "/\n";
    assertEquals(actualOutput, expectedOutput);
  }

  @Test
  /**
   * Extra arguments put in
   */
  public void extraArg() throws NonvalidArgumentException {
    try {
      String[] inputArrayString = {"tree", "test"};
      String actualOutput = tree.run(MockFM, inputArrayString);
      String expectedOutput = "error with arguments, only 1 argument expected";
      assertEquals(actualOutput, expectedOutput);
      fail();
    } catch (NonvalidArgumentException e) {
      assertEquals(e.getMessage(), "error with arguments, only 1 argument expected");
    }
  }
  

  @Test
  public void testwithdir() throws NonvalidArgumentException {
	Directory temp1 = new Directory("temp1", MockFM.getCurrent());
	MockFM.getCurrent().setDirectory("temp1", temp1);
    String[] inputArrayString = {"tree"};
    String actualOutput = tree.run(MockFM, inputArrayString);
    String expectedOutput = "/\n" + 
    		"  temp1\n";
    assertEquals(actualOutput, expectedOutput);
  }

}
