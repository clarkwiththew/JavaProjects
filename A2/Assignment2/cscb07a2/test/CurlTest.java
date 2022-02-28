
package test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;
import commands.Curl;
import errorHandler.NonvalidArgumentException;



public class CurlTest {
	
	Curl curl = new commands.Curl();
	private MockFileManager MockFM;
	private String txturl;
	private String htmlurl;
	private String txtname;
	private String htmlname;
	private String badurl;
	
	 
	/**
	   * CurlTest command setup
	   * 
	   * @param none
	   * @return none
	   */
	
	@Before 
	public void setUp() {
		MockFM = new MockFileManager();
		txturl = "http://www.cs.cmu.edu/~spok/grimmtmp/073.txt";
		txtname = "073txt";
		htmlurl = "http://www.cs.utoronto.ca/~trebla/CSCB09-2020-Summer/l03/Lab03.html";
		badurl = "http://www.ub.edu/gilcub/SIMPLE/simple.html";
		
	}
	
	/**
	   * Create txt file with contents from working url
	   * 
	   * @param none
	   * @return none
	   */
	
	@Test
	public void txtfile() throws NonvalidArgumentException{
		try {
			  String []inputArrayString= {"curl", "txturl"};
			  String actualOutput = curl.run(MockFM, inputArrayString);
			  String expectedOutput= "\n";
			  assertEquals(actualOutput, expectedOutput);
			  fail();
		  } catch (NonvalidArgumentException e) {
				 assertEquals(e.getMessage(), "invalid input, URL has problems");
		  }
	}

	
	
	@Test
	/**
	   * Create html file with contents from working url
	   * 
	   * @param none
	   * @return none
	   */
	public void htmlurl() {
		try {
			  String []inputArrayString= {"curl", "htmlurl"};
			  String actualOutput = curl.run(MockFM, inputArrayString);
			  String expectedOutput= "\n";
			  assertEquals(actualOutput, expectedOutput);
			  fail();
		  } catch (NonvalidArgumentException e) {
				 assertEquals(e.getMessage(), "invalid input, URL has problems");
		  }
	}
	
	
	@Test
	/**
	   * Curl with an invalid url
	   * 
	   * @param none
	   * @return none
	   */
	public void badurl() {
		try {
			  String []inputArrayString= {"curl", "badurl"};
			  String actualOutput = curl.run(MockFM, inputArrayString);
			  String expectedOutput= "invalid input, URL has problems";
			  assertEquals(actualOutput, expectedOutput);
			  fail();
		  } catch (NonvalidArgumentException e) {
				 assertEquals(e.getMessage(), "invalid input, URL has problems");
		  }
	}
	
	
	
	@Test
	public void noinput() throws NonvalidArgumentException{
		try {
			  String []inputArrayString= {"curl"};
			  String actualOutput = curl.run(MockFM, inputArrayString);
			  String expectedOutput= "error with arguments, only 2 arguments expected";
			  assertEquals(actualOutput, expectedOutput);
			  fail();
		  } catch (NonvalidArgumentException e) {
				 assertEquals(e.getMessage(), "error with arguments, only 2 arguments expected");
		  }
	}
}
