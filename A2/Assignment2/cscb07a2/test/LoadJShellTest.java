
package test;

import static org.junit.Assert.*;

import org.junit.Test;
import commands.LoadJShell;
import commands.SaveJShell;
import commands.Search;
import commands.Tree;
import data.FileManager;
import errorHandler.NonvalidArgumentException;
import org.junit.Before;


public class LoadJShellTest {

  LoadJShell loadJShell = new LoadJShell();
  private MockFileManager MockFM;

  /**
   * 
   * LoadJShell command set up
   */

  @Before
  public void setUp() {
    MockFM = new MockFileManager();
  }

  /**
   * Command without path argument
   */
  @Test
  public void noPathRprovided() {
    try {
      String[] inputArrayString = {"loadJShell"};
      String actualOutput = loadJShell.run(MockFM, inputArrayString);
      String expectedOutput = "error, file path must be provided";
      assertEquals(actualOutput, expectedOutput);
    } catch (NonvalidArgumentException e) {
      assertEquals(e.getMessage(), "error, file path must be provided");
    }
  }

  /**
   * Too many arguments
   */
  @Test
  public void tooManyArguments() {
    try {
      String[] inputArrayString = {"loadJShell", "/file/path", "extra_arg"};
      String actualOutput = loadJShell.run(MockFM, inputArrayString);
      String expectedOutput = "error, too many arguments for LoadJShell";
      assertEquals(actualOutput, expectedOutput);
    } catch (NonvalidArgumentException e) {
      assertEquals(e.getMessage(), "error, too many arguments for LoadJShell");
    }
  }

}
