// *********************************************************
package commands;

import data.*;
import errorHandler.NonvalidArgumentException;
import errorHandler.Validator;

/**
 */
public class Exit implements Command {

  /**
   * Exit the shell.
   *
   * @param fm the fileManager where the command is executed
   * @param args The command to exit
   * @return Empty string, showing a successful exit
   * @throws NonvalidArgumentException the nonvalid argument exception
   */
  public String run(FileManager fm, String[] args) throws NonvalidArgumentException {
    if (Validator.checkNumArgs(1, args)) {
      System.exit(0);
    } else {
      throw new NonvalidArgumentException("error with arguments, only 1 argument expected");
    }
    return "";
  }


}

