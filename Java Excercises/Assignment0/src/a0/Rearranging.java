package a0;

// **********************************************************
// Assignment0:
// UTOR user_name: wangj930
// UT Student #: 1006390031
// Author: Junheng Wang
//
//
// Honor Code: I pledge that this program represents my own
// program code and that I have coded on my own. I received
// help from no one in designing and debugging my program.
// I have also read the plagarism section in the course info
// sheet of CSC B07 and understand the consequences. Note that
// we will be running all your quizzes and assignments for plagarism
// check starting sometime in November of 2020. If you do not complete this honor
// code, we will give you no credit and award you 0% for this component.


/*
 * 
 */
public class Rearranging {
  /*
   * TODO: You are asked to complete the method rearranging. This method takes in as input an array
   * of ints and returns back nothing (void). You cannot change the function signature of this
   * method.
   */
  public static void rearranging(int[] items) {
    // start with three thresholds firstPos, i, and lastPos representing
    // negative, zero and positive thresholds respectively.

    // get the size of array, store at n
    int n = items.length;

    // first and last positions
    int firstPos = 0;
    int lastPos = n - 1;
    // loop through array

    for (int i = 0; i < n; i++) {
      // we want to stop if the ith position, or zero threshold,
      // is greater than the last position,
      // since we are done sorting, as all to the right
      // of lastPos are positive and left of i are not positive
      if (i > lastPos) {
        break;
      }

      // if we find a negative item, we swap with the first position,
      // then increment the sorted negative threshold of firstPos
      if (items[i] < 0) {

        swap(firstPos, i, items);
        firstPos++;

      }
      // if the item is greater than 0:
      if (items[i] > 0) {
        // we swap the element at index lastPos with i, since positive
        // numbers are sorted at the right
        swap(lastPos, i, items);
        // we increase the range of sorted positive elements
        // by decreasing the lastPos.
        lastPos--;
        // since we do not have information on whether the zero was moved
        // in the swap, we will not increment the zero threshold.
        i--;
      }


    }
  }

  private static void swap(int i, int j, int[] items) {
    // holder exists to contain variable that gets replaced
    int holder = items[i];
    // replace the two
    items[i] = items[j];
    // replace with holder
    items[j] = holder;
  }

  public static void main(String[] args) {
    // tests
    int[] items = {-6, 5, 7, 0, 3, 4, 2, -1};
    // int [] items={6,0,-5};
    // int [] items={1,0,5};

    Rearranging.rearranging(items);
    for (int item : items) {
      System.out.println(item);
    }
  }
}
