
package test;

import static org.junit.Assert.*
;

import org.junit.Test;

import org.junit.Before;

import errorHandler.NonvalidArgumentException;
import commands.History;



public class HistoryTest {
	
	History history=new History();
    
	private MockFileManager MockFM;
	
	@Before
	/**
	   * HistoryTest setup
	   * 
	   * @param none
	   * @return none
	   */
	public void setUp() {
		MockFM = new MockFileManager();
		MockFM.inputHistory.add("testcommand1");
		MockFM.inputHistory.add("testcommand2");
		MockFM.inputHistory.add("testcommand3");
		MockFM.inputHistory.add("testcommand4");
	}
	
	@Test
	/**
	   * Test history with float 
	   * 
	   * @param none
	   * @return none
	   */
	public void FloatInput() throws NonvalidArgumentException {
		try {
		String []inputArrayString= {"history", "4.20420"};
	    String actualOutput = history.run(MockFM, inputArrayString);
	    String expectedOutput="error, not a valid argument";
	    assertEquals(actualOutput, expectedOutput);
	    fail();
		} catch  (NonvalidArgumentException e) {
			 assertEquals(e.getMessage(), "error, not a valid argument");
		}
	}
	
	@Test
	/**
	   * Test history with string
	   * 
	   * @param none
	   * @return none
	   */
	public void StringInput() throws NonvalidArgumentException {
		try {
		String []inputArrayString= {"history", "testing"};
	    String actualOutput = history.run(MockFM, inputArrayString);
	    String expectedOutput="error, not a valid argument";
	    assertEquals(actualOutput, expectedOutput);
	    fail();
		} catch  (NonvalidArgumentException e) {
			 assertEquals(e.getMessage(), "error, not a valid argument");
		}
	}
	
	@Test
	/**
	   * Test history with number greater than total amount of commands
	   * 
	   * @param none
	   * @return none
	   */
	public void validinputbig() throws NonvalidArgumentException {
		String []inputArrayString= {"history", "10"};
		MockFM.inputHistory.add("history 10");
		String actualOutput = history.run(MockFM, inputArrayString);
		String expectedOutput="1. testcommand1\n" + 
				"2. testcommand2\n" + 
				"3. testcommand3\n" + 
				"4. testcommand4\n" + 
				"5. history 10\n";
		assertEquals(actualOutput, expectedOutput);
		}
	
	@Test
	/**
	   * Test history with number less than total amount of commands
	   * 
	   * @param none
	   * @return none
	   */
	public void validinputsmall() throws NonvalidArgumentException {
		String []inputArrayString= {"history", "2"};
		MockFM.inputHistory.add("history 2");
		String actualOutput = history.run(MockFM, inputArrayString);
		System.out.println(actualOutput);
		String expectedOutput="4. testcommand4\n" + 
				"5. history 2\n";
		assertEquals(actualOutput, expectedOutput);
	}

}
