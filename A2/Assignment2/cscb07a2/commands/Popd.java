
package commands;

import data.*;
import errorHandler.NonvalidArgumentException;
import java.util.EmptyStackException;



public class Popd implements Command {

  /**
   * Removes the top most directory from the directory stack and makes it the current working
   * directory. If there is no directory onto the stack, then give appropriate error message
   *
   * @param fm the fileManager where the command is executed
   * @param args No input required
   * @return New line if no error is encountered. Error otherwise if directory is not found or stack
   *         is empty
   * @throws NonvalidArgumentException
   */

  public String run(data.FileManager fm, String[] args) throws NonvalidArgumentException {
    String output = "";

    if (args.length > 1)
      throw new NonvalidArgumentException("error, popd doesn't need extra argument.");

    try {
      Directory dir_popped = fm.popStack();
      fm.setCurrent(dir_popped);
    } catch (EmptyStackException e) {
      throw new NonvalidArgumentException("error, could not make directory");
    }

    return output;
  }
}
