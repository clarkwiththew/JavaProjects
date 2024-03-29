// **********************************************************

// *********************************************************
package data;

import java.util.ArrayList;
import java.util.Stack;
import errorHandler.NonvalidArgumentException;

/**
 */
public interface FileManager {

  public void setRoot(Directory new_root);

  /**
   * Get current Directory
   * 
   * 
   */
  public Directory getCurrent();

  /**
   * Set current Directory
   * 
   * @param path The path of the new directory
   * 
   */

  public void setCurrent(Directory newCurrent);

  /**
   * Get path
   * 
   * @param Directory The path of the directory
   * 
   */
  public String getPath();

  /**
   * Set path
   * 
   * @param String The new path
   * 
   */
  public void setPath(String newPath);


  /**
   * Add input history
   * 
   * @param string The users history
   * 
   */
  public void addInputHistory(String userInput);

  /**
   * Get input history
   * 
   * 
   */
  public ArrayList<String> getInputHistory();

  /**
   * 
   * Get stack Directory
   * 
   */
  public Stack<Directory> getDirectoryStack();

  /**
   * 
   * Merge Directory stack
   * 
   * @param Stack The new directory stack
   * 
   */
  public void mergeDirectoryStack(Stack<Directory> new_dirStack);

  /**
   * 
   * Merge current Directory
   * 
   * @param String input history
   * 
   */
  public void mergeInputHistory(ArrayList<String> input_history);

  /**
   * Get current full path
   * 
   * @param Directory current directory
   * 
   */
  public String getCurrentFullPath(Directory currentDir);


  /**
   * Push to stack
   * 
   * @param Directory directory
   * 
   */
  public void pushStack(Directory dir);

  /**
   * 
   * Pop from stack
   * 
   */
  public Directory popStack();

  /**
   * Path to current
   * 
   * @param Directory current directory
   * @param String path
   * @throws NonvalidArgumentException
   * 
   */
  public Directory pathToCurrent(Directory currentdir, String path)
      throws NonvalidArgumentException;

  /**
   * Current to root
   * 
   * @param Directory current directory
   * 
   */
  public Directory currentToRoot(Directory currentdir);

  /**
   * 
   * Save current to stack
   * 
   */
  public void saveCurrentToStack();

  /**
   * Path to file check
   * 
   * @param String path
   * @param Directory current directory
   * @throws NonvalidArgumentException
   * 
   */
  public boolean checkPathToFile(String path, Directory currentDir)
      throws NonvalidArgumentException;

  /**
   * Make file
   * 
   * @param String file name
   * @param String output
   * @param Directory current directory
   * @throws NonvalidArgumentException
   * 
   */
  public void makeFile(String fileName, String output, Directory currentDir)
      throws NonvalidArgumentException;

  /**
   * Redirection
   * 
   * @param fm the File Manager
   * @param String arguments
   * @param String output
   * @throws NonvalidArgumentException
   * 
   */
  public void redirection(FileManager fm, String args[], String output)
      throws NonvalidArgumentException;

  /**
   * Redirection checker
   * 
   * @param String arguments
   * 
   */
  public int redirectionChecker(String[] args);

  /**
   * 
   * Format redirect
   * 
   * @param String args
   * 
   */
  public String formatRedirect(String[] args);
  // public boolean checkPathToDir(Directory currentDir, String path);

  /**
   * 
   * Get root
   * 
   */
  public Directory getRoot();

  /**
   * 
   * Double quote to string
   * 
   * @param String the arguments
   * @throws NonvalidArgumentException
   * 
   */
  public String doubleQuotetoString(String[] args) throws NonvalidArgumentException;


  /**
   * Get current full path
   * 
   * @param Directory current directory
   * 
   */
  public boolean checkPathToDir(Directory currentdir, String string);


  // public void deleteFile(String oldpath, Directory newpath);


}
