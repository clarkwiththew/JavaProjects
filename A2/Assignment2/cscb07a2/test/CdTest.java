
package test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;
import commands.Cd;
import commands.Mkdir;
import data.Directory;
import data.JFileManager;
import errorHandler.NonvalidArgumentException;

// TODO: Auto-generated Javadoc



public class CdTest {
	
	/** The cd. */
	Cd cd = new commands.Cd();

	private static JFileManager fm = JFileManager.createFileManager();
	

	
	
	  /**
  	 * Sets the up.
  	 */
  	@Before
	  public void setUp() throws NonvalidArgumentException {
			Directory currentDirectory = fm.getCurrent();
			Directory mockdir = new Directory("mockdir", currentDirectory);
		    currentDirectory.setDirectory("mockdir", mockdir);
	  }
	
	  
	  /**
  	 * Existing dir.
  	 *
  	 * @throws NonvalidArgumentException the nonvalid argument exception
  	 */
  	@Test
	  /**
	   * Testing changing to a directory that exists in the fm
	   */
	  public void ExistingDir() throws NonvalidArgumentException{
	    // cd should be able to change to testdir and return a newline
	    try {
	    	String []inputArrayString= {"cd", "mockdir"};
	    	String result = cd.run(fm, inputArrayString);
	    	assertEquals(result, "");
	    	// The new current directory should reflect the change
	    } catch (NonvalidArgumentException e) {
	      // This shouldn't cause an error
	      fail("Error when changing to a valid directory");
	    }
	  }
	  
	 
	  /**
  	 * No dir.
  	 *
  	 * @throws NonvalidArgumentException the nonvalid argument exception
  	 */
  	@Test
	  /**
	   * Testing changing to a directory that does not exist in the fm
	   */
	  public void NoDir() throws NonvalidArgumentException{
		    // cd should be able to change to testdir and return a newline
		    try {
		    	String []inputArrayString= {"cd", "mockdir1"};
		    	String result = cd.run(fm, inputArrayString);
		    	String expectedOutput = "error with arguments, could not find directory";
		    	assertEquals(result, expectedOutput);
		    } catch (NonvalidArgumentException e) {
		      // This shouldn't cause an error
		    assertEquals(e.getMessage(), e.getMessage());
		    } 
	  }
	  
	  
	  /**
  	 * Dot.
  	 *
  	 * @throws NonvalidArgumentException the nonvalid argument exception
  	 */
  	@Test
	  /**
	   * Testing staying in the same directory with . 
	   */
	  public void Dot() throws NonvalidArgumentException{
		    try {
		    	String []inputArrayString= {"cd", "."};
		    	String result = cd.run(fm, inputArrayString);
		    	String expectedOutput = "";
		    	assertEquals(result, expectedOutput);
		    } catch (NonvalidArgumentException e) {
		      // This shouldn't cause an error
		    assertEquals(e.getMessage(), e.getMessage());
		    } 
	  }
	  
  	/**
  	 * Dot dot.
  	 *
  	 * @throws NonvalidArgumentException the nonvalid argument exception
  	 */
  	@Test
	  /**
	   * Testing changing to the parent directory with ..
	  
	   */
	  public void DotDot() throws NonvalidArgumentException{
		    try {
		    	String []inputArrayString= {"cd", "mockdir1/.."};
		    	String result = cd.run(fm, inputArrayString);
		    	String expectedOutput = "";
		    	assertEquals(result, expectedOutput);
		    } catch (NonvalidArgumentException e) {
		      // This shouldn't cause an error
		    assertEquals(e.getMessage(), e.getMessage());
		    } 
	  }

}
