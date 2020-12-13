package lab7_project;


import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class FlightDataRecorderTest {
  FlightDataRecorder recorder;
  @Before
  public void initFlightDataRecorder() {
       this.recorder = new FlightDataRecorder();
  }
  
  @Test
  public void testFlightDataRecorder() {
    //recorder.getRecordedData();
    recorder.record(1.0);
    assertEquals((double)1.0,(double)recorder.getRecordedData().get(0),0);//(recorder.getRecordedData().get(0),0.0 );
 
  }

  @Test
  public void testRecord() {
    recorder.record(1.0);
    recorder.record(2.0);
    recorder.record(3.0);
    recorder.record(4.0);
    recorder.record(5.0);
    recorder.record(6.0);
    recorder.record(7.0);
    recorder.record(8.0);
    recorder.record(9.0);
    recorder.record(10.0);
    recorder.record(11.0);

    assertEquals((double)2.0,(double)recorder.getRecordedData().get(0),0);//(recorder.getRecordedData().get(0),0.0 );


   
    //assertEquals((double)2.0,(double)recorder.getRecordedData().get(1),0);//(recorder.getRecordedData().get(0),0.0 );

  }

  @Test
  public void testGetRecordedData() {
    
    recorder.record(1.0);
    recorder.record(2.0);
    recorder.record(3.0);


    assertEquals((double)3.0,(double)recorder.getRecordedData().get(2),0);//(recorder.getRecordedData().get(0),0.0 );
 
  }

  @Test
  public void testGetLastDataPoints() {
    recorder.record(3.0);
    recorder.record(5.0);
    recorder.record(3.0);
    recorder.record(6.0);
    recorder.record(54.0);
    recorder.record(6.0);
    recorder.record(88.0);
    recorder.record(8.0);
    recorder.record(77.0);
    recorder.record(10.0);
    recorder.record(24.0);
    recorder.record(23.0);


    assertEquals((double)23.0,(double)recorder.getLastDataPoints(10).get(0),0);
    //returns 1.0
    //assertEquals((double)1.0,(double)recorder.getLastDataPoints(10).get(9),0);
    //(recorder.getRecordedData().get(0),0.0 );
  
  }

  @Test
  public void testAverage() {
    recorder.record(1.0);
    recorder.record(2.0);
    recorder.record(3.0);
    // testFDR.record();
    assertEquals(recorder.average(), 2.0, 0);
    //System.out.println(recorder.average());
  }
  //record goes beyond capacity
  //to fix you can make if condition to see if it is beyond ten
  //then shift the array to the left using a for loop, setting last element to the new input.
  
  
  
  //testGetLastDataPoints, if the list overflows, 
  //function does not return the last inputted point as the first of the new list, 
  //when i try to get index zero of the list
  //problem is that they are decreasing tail value, but they never reset it once the user 
  //inputs more elements than the given capacity, the tail does not update properly.
  //when given and index of 10, which is the 11th input, the modulo function turns it into 0,
  //which is not correct. You can add if statements to check when the input exceeds capacity
  //and reset the tail. 
  
  //bug with average function. it does not return the average of 1,2,3, 
  //since it divides by the capacity. Instead it should divide by 
  //the number of elements currently in the array.
  //you can make a variable that increases everytime a new element is added to the array, 
  //and divide by that instead
  
  
}
