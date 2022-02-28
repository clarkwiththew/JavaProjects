
package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import commands.Rm;
import data.*;
import errorHandler.NonvalidArgumentException;


public class RmTest {

  Rm rm = new Rm();

  private MockFileManager MockFM;

  /**
   * RM command set up
   */
  @Before
  public void setUp() {
    MockFM = new MockFileManager();
  }

//  /**
//   * Valid Path
//   */
//  @Test
//  public void validPath() throws NonvalidArgumentException {
//
//    String[] inputArrayString = {"rm", "./temp1"};
//    Directory temp1 = new Directory("temp1", MockFM.getCurrent());
//    MockFM.getCurrent().setDirectory("temp1", temp1);
//    String actualOutput = rm.run(MockFM, inputArrayString);
//    String expectedOutput = "";
//    assertEquals(actualOutput, expectedOutput);    
//  }

  /**
   * Invalid path input - the end directory from the path is ..
   */
  @Test
  public void invalidPathEndsWithDotDot() {
    try {
      String[] inputArrayString = {"rm", "./valid/path/.."};
      String actualOutput = rm.run(MockFM, inputArrayString);
      String expectedOutput = "error, invalid DIR path";
      assertEquals(actualOutput, expectedOutput);
    } catch (NonvalidArgumentException e) {
      assertEquals(e.getMessage(), "error, invalid DIR path, the end directory is either .. or .");
    }
  }
  

  /**
   * Invalid path input - the end directory from the path is .
   */
  @Test
  public void invalidPathEndsWithDot() {
    try {
      String[] inputArrayString = {"rm", "/valid/path/."};
      String actualOutput = rm.run(MockFM, inputArrayString);
      String expectedOutput = "error, invalid DIR path";
      assertEquals(actualOutput, expectedOutput);
    } catch (NonvalidArgumentException e) {
      assertEquals(e.getMessage(), "error, invalid DIR path, the end directory is either .. or .");
    }
  }

  /**
   * Invalid path input - tries to delete parent directory
   */
  @Test
  public void invalidPathParentDir() {
    try {
      String[] inputArrayString = {"rm", ".."};
      String actualOutput = rm.run(MockFM, inputArrayString);
      String expectedOutput = "error, invalid DIR path";
      assertEquals(actualOutput, expectedOutput);
    } catch (NonvalidArgumentException e) {
      assertEquals(e.getMessage(),
          "error, invalid DIR path, can't remove parent of current dir or current dir itself");
    }
  }

  /**
   * Invalid path input - tries to delete current directory
   */
  @Test
  public void invalidPathCurrentDir() {
    try {
      String[] inputArrayString = {"rm", "."};
      String actualOutput = rm.run(MockFM, inputArrayString);
      String expectedOutput = "error, invalid DIR path";
      assertEquals(actualOutput, expectedOutput);
    } catch (NonvalidArgumentException e) {
      assertEquals(e.getMessage(),
          "error, invalid DIR path, can't remove parent of current dir or current dir itself");
    }
  }

  /**
   * Too many arguments
   */
  @Test
  public void tooManyArguments() throws NonvalidArgumentException {
    try {
      String[] inputArrayString = {"rm", "arg1", "arg2", "arg3"};
      String actualOutput = rm.run(MockFM, inputArrayString);
      String expectedOutput = "error, invalid arguments count for rm command";
      assertEquals(actualOutput, expectedOutput);
    } catch (NonvalidArgumentException e) {
      assertEquals(e.getMessage(), "error, invalid arguments count for rm command");
    }
  }

}
