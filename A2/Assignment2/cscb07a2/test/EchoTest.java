
package test;

import static org.junit.Assert.*;


import org.junit.Test;
import org.junit.Before;
import commands.Echo;
import errorHandler.NonvalidArgumentException;

public class EchoTest {
	
	Echo echo = new commands.Echo();
	private MockFileManager MockFM;

	/**
	   * EchoTest command set up
	   */
	
	@Before
	public void setUp() {
		MockFM = new MockFileManager();
	}

	
	@Test
	/**
	   * EchoTest with an invalid input 
	   */
	public void NoQuotes() throws NonvalidArgumentException {
		try {
		String []inputArrayString= {"echo", "testing"};
	    String actualOutput = echo.run(MockFM,inputArrayString);
	    String expectedOutput= "hi\n";
	    assertEquals(actualOutput, expectedOutput);
		} catch (NonvalidArgumentException e) {
			 assertEquals(e.getMessage(), "error with input, you have an extra argument");
		}
	}
	
	
	@Test
	/**
	   * EchoTest with valid input
	   */
	public void ValidInput() throws NonvalidArgumentException {
		String []inputArrayString1= {"echo", "\"testing\""};
	    String actualOutput1 = echo.run(MockFM,inputArrayString1);
	    String expectedOutput1= "testing\n";
	    assertEquals(actualOutput1, expectedOutput1);
	}
}
