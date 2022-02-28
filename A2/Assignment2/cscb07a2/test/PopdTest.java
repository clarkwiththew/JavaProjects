
package test;

import static org.junit.Assert.*;

import org.junit.Test;
import commands.Popd;
import commands.Pushd;
import data.Directory;
import data.FileManager;
import errorHandler.NonvalidArgumentException;
import org.junit.Before;



public class PopdTest {
	
	Popd popd = new Popd();
    Pushd pushd = new Pushd();
    
	private MockFileManager MockFM;
  

  @Before
  /**
   * PopdTest command setup 
   */
  public void setUp() {
    // Initialize the MFS
    MockFM = new MockFileManager();
  }


  @Test
  /**
   * Extra argument in popd
   */
  public void extraArg() throws NonvalidArgumentException{
	  try {
		  String []inputArrayString= {"popd", "test"};
		  String actualOutput = popd.run(MockFM,inputArrayString);
		  String expectedOutput= "error, popd doesn't need extra argument.";
		  assertEquals(actualOutput, expectedOutput);
		  fail();
	  } catch (NonvalidArgumentException e) {
			 assertEquals(e.getMessage(), "error, popd doesn't need extra argument.");
	  }
  }
  
  @Test
  /**
   * Empty stack
   */
  public void empty() throws NonvalidArgumentException{
	  try {
		  String []inputArrayString= {"popd"};
		  String actualOutput = popd.run(MockFM,inputArrayString);
		  String expectedOutput= "error, could not make directory";
		  assertEquals(actualOutput, expectedOutput);
		  fail();
	  } catch (NonvalidArgumentException e) {
			 assertEquals(e.getMessage(), "error, could not make directory");
	  }
  }
  
  @Test
  /**
   * Push after pop
   */
  public void popPush() {
	  try {
		  Directory temp1 = new Directory("temp1", MockFM.getCurrent());
		  MockFM.getCurrent().setDirectory("temp1", temp1);
	      String[] inputArrayString = {"pushd", "./temp1"};
	      pushd.run(MockFM, inputArrayString);
	      String[] popdir = {"popd"};
	      assertEquals("", popd.run(MockFM, popdir));
	      //Check if its the same directory thats pushed
	      assertEquals(MockFM.getCurrent(), MockFM.popStack());
	    } catch (NonvalidArgumentException e) {
	      assertEquals(e.getMessage(), e.getMessage());
	    }
  }
 
  
}
