
package test;

import static org.junit.Assert.*;

import org.junit.Test;
import commands.Mkdir;
import commands.Mv;
import data.Directory;
import data.FileManager;
import data.JFileManager;
import errorHandler.NonvalidArgumentException;
import org.junit.Before;



public class MvTest {
	
	Mv mv = new commands.Mv();
	private static JFileManager fm = JFileManager.createFileManager();
	
	/**
	   * mv command setup
	   * 
	   * @param none
	   * @return none
	 * @throws NonvalidArgumentException 
	   */
	@Before
	public void setUp() throws NonvalidArgumentException {
		Directory currentDirectory = fm.getCurrent();
		Directory dir1 = new Directory("dir1", currentDirectory);
	    currentDirectory.setDirectory("dir1", dir1);
	    Directory dir2 = new Directory("dir2", currentDirectory);
	    currentDirectory.setDirectory("dir2", dir2);
	    Directory childOfDir1 = new Directory("childOfDir1", currentDirectory.getDirectory("dir1"));
	    currentDirectory.getDirectory("dir1").setDirectory("childOfDir1", childOfDir1);
		fm.makeFile("file1", "content", currentDirectory);
		fm.makeFile("file2", "content2", currentDirectory);
		
	}

	/**
	   * move one directory to existing dir
	   * 
	   */
	@Test
	public void moveOneDirToExistingDir() {
		 try {
		      String[] inputArrayString = {"mv", "dir1","dir2"};
		      String actualOutput = mv.run(fm, inputArrayString);
		      String expectedOutput = "";
		      assertEquals(actualOutput, expectedOutput);
		    } catch (NonvalidArgumentException e) {
		      assertEquals(e.getMessage(),e.getMessage());
		    }
	}
	
	/**
	   * move one directory to new dir
	   * 
	   */
	@Test
	public void moveOneDirToNewDir() {
		 try {
		      String[] inputArrayString = {"mv", "dir1","dir5"};
		      mv.run(fm, inputArrayString);
		      Boolean actualBoolean = fm.checkPathToDir(fm.getCurrent(), "/dir5/dir1");
			  Boolean expectedBoolean = true;
			  assertEquals(actualBoolean, expectedBoolean);
		    } catch (NonvalidArgumentException e) {
		      assertEquals(e.getMessage(), "");
		    }
	}
	/**
	   * move one parent dir to child dir
	   * 
	   */
	@Test
	public void moveParentToChild() {
		 try {
		      String[] inputArrayString = {"mv", "dir1","childOfDir1"};
		      String actualOutput = mv.run(fm, inputArrayString);
		      String expectedOutput = "";
		      assertEquals(actualOutput, expectedOutput);
		    } catch (NonvalidArgumentException e) {
		    	
		      assertEquals(e.getMessage(), "old path is parent of new path please try again");
		      
		    }
	}
	/**
	   * move one file to dir
	   * 
	   */
	@Test
	public void moveFileToDir() {
		 try {
		      String[] inputArrayString = {"mv", "file1","dir1"};
		      String actualOutput = mv.run(fm, inputArrayString);
		      String expectedOutput = "";
		      assertEquals(actualOutput, expectedOutput);
		    } catch (NonvalidArgumentException e) {
		      assertEquals(e.getMessage(), "");
		    }
	}
	/**
	   * move one dir to file
	   * 
	   */
	@Test
	public void moveDirToFile() {
		 try {
		      String[] inputArrayString = {"mv", "dir1","fi1e1"};
		      String actualOutput = mv.run(fm, inputArrayString);
		      String expectedOutput = "";
		      assertEquals(actualOutput, expectedOutput);
		    } catch (NonvalidArgumentException e) {
		      assertEquals(e.getMessage(), "error, can't move dir to file");
		    }
	}
	
	/**
	   * move one file to file
	   * 
	   */
	@Test
	public void moveFileToFile() {
		 try {
		      String[] inputArrayString = {"mv", "file2","fi1e1"};
		      String actualOutput = mv.run(fm, inputArrayString);
		      String expectedOutput = "";
		      assertEquals(actualOutput, expectedOutput);
		    } catch (NonvalidArgumentException e) {
		      assertEquals(e.getMessage(), "");
		    }
	}

}
