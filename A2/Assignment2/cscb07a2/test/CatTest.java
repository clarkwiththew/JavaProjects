
package test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import data.JFileManager;
import errorHandler.NonvalidArgumentException;
import commands.Cat;


public class CatTest {

  Cat cat = new commands.Cat();
  private MockFileManager MockFM;


  /**
   * CatTest command setup
   * 
   * @param none
   * @return none
   */
  @Before
  public void setUp() {
    MockFM = new MockFileManager();

    try {
      MockFM.makeFile("fileA", "file info A", MockFM.current);
    } catch (NonvalidArgumentException e) {
      // TODO Auto-generated catch block
      fail();
    }
    try {
      MockFM.makeFile("fileB", "file info B", MockFM.current);
    } catch (NonvalidArgumentException e) {
      // TODO Auto-generated catch block
      fail();
    }
  }

  /**
   * CatTest with a single file
   * 
   * @param none
   * @return none
   * @throws NonvalidArgumentException
   */

  @Test
  public void SingleFile() throws NonvalidArgumentException {
    String[] inputArrayString = {"cat", "fileA"};
    String actualOutput = cat.run(MockFM, inputArrayString);
    String expectedOutput = "";
    assertEquals(actualOutput, expectedOutput);
  }

  /**
   * CatTest with a multiple files
   * 
   * @param none
   * @return none
   */

  @Test
  public void MultipleFile() throws NonvalidArgumentException {
    String[] inputArrayString = {"cat", "fileA", "fileB"};
    String actualOutput = cat.run(MockFM, inputArrayString);
    String expectedOutput = "";
    assertEquals(actualOutput, expectedOutput);
  }


  /**
   * CatTest with no file
   * 
   * @param none
   * @return none
   */
  @Test
  public void NoFile() {
    try {
      String[] inputArrayString = {"cat"};
      String actualOutput = cat.run(MockFM, inputArrayString);
      String expectedOutput = "Error, nonvalid input with args";
      assertEquals(actualOutput, expectedOutput);
      fail();
    } catch (NonvalidArgumentException e) {
      assertEquals(e.getMessage(), "Error, nonvalid input with args");
    }


  }

}
