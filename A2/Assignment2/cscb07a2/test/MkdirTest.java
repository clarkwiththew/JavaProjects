
package test;

import static org.junit.Assert.*;

import org.junit.Test;

import commands.Mkdir;
import data.JFileManager;
import errorHandler.NonvalidArgumentException;
import org.junit.Before;


public class MkdirTest {

    Mkdir mkdir = new Mkdir();
    private MockFileManager MockFM;
    private static JFileManager fm = JFileManager.createFileManager();

    
    /**
       * Mkdir command set up
       */
    
    @Before
    public void setUp() {
        MockFM = new MockFileManager();
    }
    
    @Test
    public void onedir() {
        try {
            String[] inputArrayString = {"mkdir", "dir1"};
            String actualOutput = mkdir.run(MockFM, inputArrayString);
            String expectedOutput = "";
            assertEquals(actualOutput, expectedOutput);
          } catch (NonvalidArgumentException e) {
            assertEquals(e.getMessage(), e.getMessage());
          }
    }

    @Test
    /**
       * Multiple directories as path.
       */
    public void multiplepaths() {
        try {
            String[] inputArrayString = {"mkdir", "dir1", "dir2"};
            String actualOutput = mkdir.run(MockFM, inputArrayString);
            String expectedOutput = "";
            assertEquals(actualOutput, expectedOutput);
          } catch (NonvalidArgumentException e) {
            assertEquals(e.getMessage(), e.getMessage());
          }
    
    }
    
    @Test
    /**
       * Invalid dir name.
       */
    public void invalidDirName() {
        try {
            String[] inputArrayString = {"mkdir", ".."};
            String actualOutput = mkdir.run(MockFM, inputArrayString);
            String expectedOutput = "error nonvalid arguments, directory name is invalid";
            assertEquals(actualOutput, expectedOutput);
          } catch (NonvalidArgumentException e) {
            assertEquals(e.getMessage(), e.getMessage());
          }
    }
    
    @Test
    /**
       * Invalid path.
       */
    public void invalidPath() {
        try {
            String[] inputArrayString = {"mkdir", "dir1", "dir1/../dir2"};
            String actualOutput = mkdir.run(fm, inputArrayString);
            String expectedOutput = "";
            assertEquals(actualOutput, expectedOutput);
          } catch (NonvalidArgumentException e) {
            assertEquals(e.getMessage(), "error with arguments, nonvalid path");
          }
    
    }
}
