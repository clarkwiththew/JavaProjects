
package commands;

import java.util.ArrayList;
import errorHandler.*;
import data.*;
// TODO: Auto-generated Javadoc

public class History implements Command {

  /** The hist. */
  private ArrayList<String> hist;

  /**
   * This command will print out recent commands, one command per line.
   *
   * @param fm the fileManager where the command is executed
   * @param splitInput Total amount of previous commands wanted to be displayed, or all the previous
   *        commands if no number is input
   * @return List of the last x previous commands given
   * @throws NonvalidArgumentException the nonvalid argument exception
   */
  private String historyHelper(FileManager fm, String[] splitInput)
      throws NonvalidArgumentException {
    hist = fm.getInputHistory();
    String output = "";
    int beginningIdx = 0;
    if (splitInput.length > 2)
      throw new NonvalidArgumentException("error with arguments, only 1 argument expected");
    else if (splitInput.length == 2) {
      try {
        int argInteger = Integer.parseInt(splitInput[1]);
        beginningIdx = Math.max(hist.size() - argInteger, 0);
      } catch (Exception e) {
        throw new NonvalidArgumentException("error, not a valid argument");
      }
    }
    for (int i = beginningIdx; i < hist.size(); i++)
      output += (i + 1) + ". " + hist.get(i) + "\n";
    return output;
  }



  /**
   * Run.
   *
   * @param fm the fm
   * @param splitInput the split input
   * @return the string
   * @throws NonvalidArgumentException the nonvalid argument exception
   */
  public String run(FileManager fm, String[] splitInput) throws NonvalidArgumentException {
    String outputString = "";
    if (fm.redirectionChecker(splitInput) == 1) {
      String outString = fm.formatRedirect(splitInput);
      outString = outString.trim();
      String[] holderString = outString.split("\\s+");
      outputString = historyHelper(fm, holderString);
      fm.redirection(fm, splitInput, outputString);
      return "";
    }
    return historyHelper(fm, splitInput);
  }
}
