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
package a0;

import java.lang.Math;

public class Cfiltering {
  // this is a 2d matrix i.e. user*movie
  private int userMovieMatrix[][];
  // this is a 2d matrix i.e. user*movie
  private float userUserMatrix[][];

  /**
   * Default Constructor.
   */
  public Cfiltering() {
    // this is 2d matrix of size 1*1
    userMovieMatrix = new int[1][1];
    // this is 2d matrix of size 1*1
    userUserMatrix = new float[1][1];
  }


  /**
   * Constructs an object which contains two 2d matrices, one of size users*movies which will store
   * integer movie ratings and one of size users*users which will store float similarity scores
   * between pairs of users.
   * 
   */
  public Cfiltering(int numberOfUsers, int numberOfMovies) {
    // construct the user matrix with numberOfUsers*numberOfUsers size
    userUserMatrix = new float[numberOfUsers][numberOfUsers];
    // construct the movie matrix with numberOfUsers*numberOfMovies size
    userMovieMatrix = new int[numberOfUsers][numberOfMovies];

  }

  /**
   * The purpose of this method is to populate the UserMovieMatrix. As input parameters it takes in
   * a rowNumber, columnNumber and a rating value. The rating value is then inserted in the
   * UserMovieMatrix at the specified rowNumber and the columnNumber.
   * 
   */
  public void populateUserMovieMatrix(int rowNumber, int columnNumber, int ratingValue) {
    // insert ratingValue into the userMovieMatrix at the specified indices.
    userMovieMatrix[rowNumber][columnNumber] = ratingValue;
  }


  /**
   * Helper function to calculate the similarity score of two users given two user indices and
   * number of movies.
   * 
   */
  public float similarOfTwoHelper(int userA, int userB, int numMovie) {
    float score = 0;
    int total = 0;
    // loop through the userMovieMatrix for the given users
    for (int i = 0; i < numMovie; i++) {
      // get the difference of the two users for each movie rating
      int diff = userMovieMatrix[userA][i] - userMovieMatrix[userB][i];
      // square the difference
      int square = diff * diff;
      // add to the running total
      total += square;

    }
    // calculate the square root, then using the formula for score,
    // calculate similarity score
    score = (float) (1 / (1 + Math.sqrt(total)));
    return score;
  }

  /**
   * Determines how similar each pair of users is based on their ratings. This similarity value is
   * represented with with a float value between 0 and 1, where 1 is perfect/identical similarity.
   * Stores these values in the userUserMatrix.
   * 
   */
  public void calculateSimilarityScore(int numUsers, int numMovies) {
    // this will be the similarity score of each of the users
    float simVal = 0;
    // loop through rows for each user
    for (int i = 0; i < numUsers; i++) {
      // loop through columns for each user
      for (int j = 0; j < numUsers; j++) {
        // similarity score is changed by helper function
        simVal = this.similarOfTwoHelper(i, j, numMovies);
        // we write the simVal to fill the user matrix
        userUserMatrix[i][j] = simVal;
        // by symmetry, so we write the same
        userUserMatrix[j][i] = simVal;

      }
    }

  }

  /**
   * Prints out the similarity scores of the userUserMatrix, with each row and column representing
   * each/single user and the cell position (i,j) representing the similarity score between user i
   * and user j.
   * 
   */

  public void printUserUserMatrix(int userNum) {
    // formats the print exactly
    System.out.print("\n");
    System.out.print("\n");
    System.out.println("userUserMatrix is:");
    // loop through the user matrix
    for (int i = 0; i < userNum; i++) {
      // prints outer bracket
      System.out.print("[");
      for (int j = 0; j < userNum; j++) {
        // prints to the correct decimal places
        System.out.print(String.format("%.4f", (userUserMatrix[i][j])));
        // prints separator comma if not last element
        if (j != userNum - 1) {
          System.out.print(", ");
        }


      }
      // prints outer bracket
      System.out.println("]");

    }
  }


  /**
   * This helper function finds and returns the greatest value in the user matrix
   * 
   */
  public float getMax(int userNum) {
    // set initial value to smallest value, to be increased
    float maxVal = 0;
    // loop through the user matrix
    for (int i = 0; i < userNum; i++) {

      for (int j = 0; j < userNum; j++) {
        // if you reach a value that is greater than the current greatest
        if (userUserMatrix[i][j] > maxVal) {
          // if that value is not equal to itself
          if (i != j) {
            // switch the current greatest with the current value
            maxVal = userUserMatrix[i][j];
          }
        }
      }

    }
    // return the maximum value
    return maxVal;
  }

  /**
   * This helper function finds and returns the number of max elements in the user matrix
   * 
   */

  public int getNumberMax(int userNum, float max) {
    // set initial value to zero
    int count = 0;
    // loop through the user matrix
    for (int i = 0; i < userNum; i++) {

      for (int j = 0; j < userNum; j++) {
        // if you find a greatest value
        if (userUserMatrix[i][j] == max) {
          // by symmetry, we only consider half the array
          if (i > j) {
            // increase the count
            count += 1;
          }
        }
      }

    }
    // return the count
    return count;
  }

  /**
   * This function finds and prints the most similar pair of users in the userUserMatrix.
   */
  public void findAndprintMostSimilarPairOfUsers(int userNum) {

    // make sure the formatting is correct
    System.out.print("\n");
    System.out.print("\n");

    System.out.println("The most similar pairs of users from above userUserMatrix are:");
    // variable to hold maximum score by calling helper function
    float highest = this.getMax(userNum);
    // calls helper function to get count of maximum score
    int simCount = this.getNumberMax(userNum, highest);
    // loop through the user matrix
    for (int i = 0; i < userNum; i++) {

      for (int j = 0; j < userNum; j++) {
        // if you find the highest element and index not repeated
        if (userUserMatrix[i][j] == highest && i > j) {
          // we want to print commas after each group, but not the last group
          // so we will decrease the count each time
          // and only not print at the last
          // print the user number, not the array index, so +1
          simCount--;
          if (simCount == 0) {
            System.out.println("User" + (i + 1) + " and User" + (j + 1));
          }
          if (simCount != 0) {
            // make sure to print the comma:

            System.out.println("User" + (i + 1) + " and User" + (j + 1) + ",");

          }


        }

      }

    }
    // print the similarity score
    System.out.println("with similarity score of " + String.format("%.4f", highest));

  }



  /**
   * Helper function: This function finds and returns the least value in the user matrix
   * 
   */
  public float getMin(int userNum) {
    // set initial value to greatest value, to be decreased
    float minVal = 1;
    // loop through the user matrix

    for (int i = 0; i < userNum; i++) {

      for (int j = 0; j < userNum; j++) {
        // if you reach a value that is less than the current least
        if (userUserMatrix[i][j] < minVal) {
          // if that value is not equal to itself

          if (i != j) {
            // switch the current least with the current value

            minVal = userUserMatrix[i][j];
          }
        }
      }

    }
    // return the least value

    return minVal;
  }

  /**
   * This helper function finds and returns the number of min elements in the user matrix
   * 
   */
  public int getNumberMin(int userNum, float min) {
    // set initial count to zero
    int count = 0;
    // loop through the user matrix
    for (int i = 0; i < userNum; i++) {

      for (int j = 0; j < userNum; j++) {
        // if you a minimum value in the array
        if (userUserMatrix[i][j] == min) {
          // we only look at the upper half of the array to not over count
          if (i > j) {
            // increase the amount we have counted
            count += 1;
          }
        }
      }

    }
    // return the count
    return count;
  }

  /**
   * This function finds and prints the most dissimilar pair of users in the userUserMatrix.
   * 
   */

  public void findAndprintMostDissimilarPairOfUsers(int userNum) {
    // make sure the formatting is correct

    System.out.print("\n");

    System.out.print("\n");

    System.out.println("The most dissimilar pairs of users from above userUserMatrix are:");
    // variable to hold minimum score by calling helper function

    float lowest = this.getMin(userNum);
    // variable to hold count of elements of
    // minimum score by calling helper function

    int simCount = this.getNumberMin(userNum, lowest);

    // loop through the user matrix

    for (int i = 0; i < userNum; i++) {

      for (int j = 0; j < userNum; j++) {
        // if you find the lowest element and
        // make sure index not repeated and only consider upper
        // half of array by symmetry

        if (userUserMatrix[i][j] == lowest && i > j) {
          // decrease the count after printing it
          // print the user number, not the array index, so +1

          simCount--;
          if (simCount == 0) {
            // if we are at the last element to print, do not print the comma
            System.out.println("User" + (i + 1) + " and User" + (j + 1));
          }
          if (simCount != 0) {
            // print the comma
            System.out.println("User" + (i + 1) + " and User" + (j + 1) + ",");

          }

        }

      }

    }
    // print the similarity score

    System.out.println("with similarity score of " + String.format("%.4f", lowest));


  }
}
