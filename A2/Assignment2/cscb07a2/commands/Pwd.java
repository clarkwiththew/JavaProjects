// **********************************************************

// *********************************************************
package commands;

import data.*;
import errorHandler.NonvalidArgumentException;
import errorHandler.Validator;


public class Pwd implements Command {


  /**
   * Print the current working directory (including the whole path)
   *
   * @param fm the fileManager where the command is executed
   * @return Whole path of current working directory (including itself)
   * @throws NonvalidArgumentException
   */
  public String run(FileManager fm, String[] args) throws NonvalidArgumentException {
    // if you have many arguments and you have second argument not a >
    if (!Validator.checkNumArgs(1, args) && (!(args[1].contains(">")))) {
      throw new NonvalidArgumentException("error with arguments, invalid arguments given");
    }
    String output = "";
    Directory currentDir = fm.getCurrent();

    if (currentDir.getDirName() == "/") {
      output = "/\n";
    } else {
      output = fm.getCurrentFullPath(currentDir) + "\n";
    }

    for (int i = 0; i < args.length; i++) {
      if (args[i].contains(">")) {
        fm.redirection(fm, args, output);
        return "";
      }
    }
    return output;

  }


}
