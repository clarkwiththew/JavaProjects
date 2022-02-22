
package commands;

import data.*;
import errorHandler.NonvalidArgumentException;
import errorHandler.Validator;

public class Pushd implements Command {

  /**
   * Saves the current working directory by pushing onto directory stack and the changes the new
   * current working directory to DIR
   *
   * @param fm the fileManager where the command is executed
   * @param args Path of directory we want to change into
   * @return New line if no error is encountered. Error if no directory is found
   * @throws NonvalidArgumentException
   */
  public String run(FileManager fm, String[] args) throws NonvalidArgumentException {

    fm.saveCurrentToStack();

    if (args.length > 2 || Validator.isEqual(args.length, 1)) {
      throw new NonvalidArgumentException("error with arguments, only 1 arguement expected");
    }

    String path = args[1];

    try {
      Directory dirToAdd = fm.pathToCurrent(fm.getCurrent(), path);
      fm.setCurrent(dirToAdd);
    } catch (Exception e) {
      throw new NonvalidArgumentException("error with arguments, invalid directory");
    }
    return "";
  }



}
