
// *********************************************************
package commands;

import errorHandler.NonvalidArgumentException;
import errorHandler.Validator;
import data.*;
// TODO: Auto-generated Javadoc


public class Echo implements Command {

  /**
   * Run.
   *
   * @param indexAppend the index append
   * @param holderString the holder string
   * @param indexOverwrite the index overwrite
   * @param fileName the file name
   * @param fm the fm
   * @param args the args
   * @param output the output
   * @return the string
   * @throws NonvalidArgumentException the nonvalid argument exception
   */
  private void echoChecker(int indexAppend, String holderString, int indexOverwrite,
      String fileName, FileManager fm, String[] args, String output)
      throws NonvalidArgumentException {
    if (indexAppend != -1) {
      if (!(holderString.charAt(indexAppend - 1) == '\"'
          || (holderString.charAt(indexAppend - 1) == ' '
              && holderString.charAt(indexAppend - 2) == '\"'))) {
        throw new NonvalidArgumentException(
            "error with input, you have an nonvalid input before >>");
      }
    }

    else if (indexOverwrite != -1) {
      if (!(holderString.charAt(indexOverwrite - 1) == '\"'
          || (holderString.charAt(indexOverwrite - 1) == ' '
              && holderString.charAt(indexOverwrite - 2) == '\"'))) {
        throw new NonvalidArgumentException(
            "error with input, you have an nonvalid input before >");
      }
    }

    Directory currentDir;
    // if fileName is path
    if (fileName.contains("/")) {
      String[] pathHolder = fileName.split("/");
      String newFile = pathHolder[pathHolder.length - 1];
      // get the fileName
      newFile = newFile.trim();
      currentDir = fm.pathToCurrent(fm.getCurrent(), fileName);
    } else {
      currentDir = fm.getCurrent();
    }
    fm.redirection(fm, args, output);
  }

  /**
   * Run.
   *
   * @param fm the fm
   * @param args the args
   * @return the string
   * @throws NonvalidArgumentException the nonvalid argument exception
   */
  public String run(FileManager fm, String[] args) throws NonvalidArgumentException {
    if (args[1].charAt(0) != '\"') {
      throw new NonvalidArgumentException("error with input, you have an extra argument");
    }
    String fileName = "";
    String output = "";
    String holderString = "";
    for (int i = 1; i < args.length; i++) {
      holderString += args[i] + " ";
    }
    if (!Validator.checkQuote(args)) {
      throw new NonvalidArgumentException("error with input, you need 2 quotes surrounding input");
    }
    // we want to check if the user typed quotes in quotes, which is illegal
    holderString.trim();
    int firstQuote = holderString.indexOf("\"");
    int secQuote = holderString.indexOf("\"", firstQuote + 1);
    output = holderString.substring(firstQuote + 1, secQuote);
    int indexAppend = holderString.indexOf(">>", secQuote + 1);
    int indexOverwrite = -1;
    // if >> does not exist
    if (indexAppend == -1) {
      indexOverwrite = holderString.indexOf(">", secQuote + 1);
    }
    String[] quoteArray = holderString.split("\"");
    // output string for echo
    if (indexOverwrite == -1 && indexAppend == -1) {
      // if you have invalid inputs, throw error
      if (!quoteArray[0].isBlank() || !quoteArray[2].isBlank()) {
        throw new NonvalidArgumentException("error with input, invalid addition");
      }
      // print to screen
      return output + "\n";
    }
    echoChecker(indexAppend, holderString, indexOverwrite, fileName, fm, args, output);

    return "";
  }
}
