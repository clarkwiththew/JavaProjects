
package test;

import static org.junit.Assert.*;

import org.junit.Test;


import commands.SaveJShell;
import data.Directory;
import data.FileManager;
import errorHandler.NonvalidArgumentException;
import org.junit.Before;



public class SaveJShellTest {

  SaveJShell saveJShell = new SaveJShell();
  private MockFileManager MockFM;

  /**
   * 
   * SaveJSHell command set up
   */

  @Before
  public void setUp() {
    MockFM = new MockFileManager();
  }

  /**
   * Invalid file path
   */
  @Test
  public void invalidFilePath() {
    try {
      String[] inputArrayString = {"saveJShell", "..//invalid//file/path/"};
      String actualOutput = saveJShell.run(MockFM, inputArrayString);
      String expectedOutput = "error, something wrong with creating file output";
      assertEquals(actualOutput, expectedOutput);
    } catch (Exception e) {
      assertEquals(e.getMessage(), "error, something wrong with creating file output");
    }
  }
  
  /**
   * No file path provided
   */
  @Test
  public void noFilePath() {
    try {
      String[] inputArrayString = {"saveJShell"};
      String actualOutput = saveJShell.run(MockFM, inputArrayString);
      String expectedOutput = "error, file path must be provided to save session data";
      assertEquals(actualOutput, expectedOutput);
    } catch (NonvalidArgumentException e) {
      assertEquals(e.getMessage(), "error, file path must be provided to save session data");
    }
    
  }

  /**
   * Too many arguments
   */
  @Test
  public void tooManyArguments() {
    try {
      String[] inputArrayString = {"saveJShell", "/file/path", "extra_arg"};
      String actualOutput = saveJShell.run(MockFM, inputArrayString);
      String expectedOutput = "error, invalid argument for saveJShell";
      assertEquals(actualOutput, expectedOutput);
    } catch (NonvalidArgumentException e) {
      assertEquals(e.getMessage(), "error, invalid argument for saveJShell");
    }
  }

}
