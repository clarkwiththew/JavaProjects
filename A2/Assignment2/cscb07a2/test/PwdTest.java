
package test;

import static org.junit.Assert.*;

import org.junit.Test;

import commands.Pushd;
import commands.Pwd;
import data.FileManager;
import errorHandler.NonvalidArgumentException;
import org.junit.Before;



public class PwdTest {
	
	Pwd pwd = new Pwd();
	private MockFileManager MockFM;

	/**
	   * Pwd command set up
	   */
	
	@Before
	public void setUp() {
		MockFM = new MockFileManager();
	}
	
	/**
	   * 
	   * Extra parameter
	   */
	  @Test
	  public void extraparam() throws NonvalidArgumentException {
		  try {
			  String []inputArrayString= {"pwd", "test"};
			  String actualOutput = pwd.run(MockFM, inputArrayString);
			  String expectedOutput= "error with arguments, invalid arguments given";
			  assertEquals(actualOutput, expectedOutput);
			  fail();
		 } catch (NonvalidArgumentException e) {
			 assertEquals(e.getMessage(), "error with arguments, invalid arguments given");
		 }
	  }
	
	/**
	   * 
	   * Testing the pwd method. Does not take any user input 
	   */
	  @Test
	  public void test() throws NonvalidArgumentException {
		  String []inputArrayString= {"pwd"};
		  String actualOutput = pwd.run(MockFM, inputArrayString);

		  assertEquals(actualOutput, "/\n");
	  }
	  
//	    assertEquals(pwd.run(MockFM, ""), "\n");
//	    MockFM.currentDirectory = "test 1";
//	    assertEquals(pwd.run(MockFM, ""), "test 1\n");
//	    assertEquals(pwd.run(MockFM, "some params"), "test 1\n");
//	  }

}
