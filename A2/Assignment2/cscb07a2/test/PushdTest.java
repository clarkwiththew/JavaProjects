
package test;

import static org.junit.Assert.*;

import org.junit.Test;
import commands.Pushd;
import commands.Popd;
import data.Directory;
import errorHandler.NonvalidArgumentException;
import org.junit.Before;



public class PushdTest {

  Pushd pushd = new Pushd();
  Popd popd = new Popd();
  private MockFileManager MockFM;


  @Before
  /**
   * 
   * PushdTest command set up
   *
   */

  public void setUp() {
    // Initialize the MFS
    MockFM = new MockFileManager();
    Directory temp1 = new Directory("temp1", MockFM.getCurrent());
    MockFM.getCurrent().setDirectory("temp1", temp1);
  }

  @Test
  /**
   * No argument provided in pushd
   */
  public void noArg() throws NonvalidArgumentException {
    try {
      String[] inputArrayString = {"pushd"};
      String actualOutput = pushd.run(MockFM, inputArrayString);
      String expectedOutput = "";
      assertEquals(actualOutput, expectedOutput);
    } catch (NonvalidArgumentException e) {
      assertEquals(e.getMessage(), "error with arguments, only 1 arguement expected");
    }
  }

  @Test
  /**
   * Pushing to a directory that does not exist
   */

  public void pushToNonExistingDir() throws NonvalidArgumentException {
    try {
      String[] inputArrayString = {"pushd", "./nonExistDir"};
      String actualOutput = pushd.run(MockFM, inputArrayString);
      assertEquals(actualOutput, "");
    } catch (NonvalidArgumentException e) {
      assertEquals(e.getMessage(), "error with arguments, invalid directory");
    }
  }

  @Test
  /**
   * Push of a directory.
   */
  public void push() {
    try {
      String[] inputArrayString = {"pushd", "./temp1"};
      String actualOutput = pushd.run(MockFM, inputArrayString);
      String expectedOutput = "";
      assertEquals(actualOutput, expectedOutput);
    } catch (NonvalidArgumentException e) {
      assertEquals(e.getMessage(), "No error should be thrown");
    }
  }

}
