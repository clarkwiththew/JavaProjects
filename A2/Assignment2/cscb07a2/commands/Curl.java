
// *********************************************************
package commands;

import data.FileManager;
import data.JFileManager;
import errorHandler.NonvalidArgumentException;
import errorHandler.Validator;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;




public class Curl implements Command {

  /**
   * Curl helper.
   *
   * @param siteName the site name
   * @return the input stream reader
   * @throws NonvalidArgumentException the nonvalid argument exception
   */
  private InputStreamReader curlHelper(String siteName) throws NonvalidArgumentException {
    URL urlFile = null;
    try {
      urlFile = new URL(siteName);
    } catch (IOException e) {
      throw new NonvalidArgumentException("invalid input, URL has problems");
    } catch (Exception e) {
      throw new NonvalidArgumentException("invalid input, could not reach site");
    }
    InputStreamReader stream = null;
    try {
      stream = new InputStreamReader(urlFile.openStream());

    } catch (IOException e) {
      throw new NonvalidArgumentException("invalid input, URL has problems");
    } catch (Exception e) {
      throw new NonvalidArgumentException("invalid input, could not reach site");
    }
    return stream;
  }

  /**
   * Run.
   *
   * @param fm the fm
   * @param args the args
   * @return the string
   * @throws NonvalidArgumentException the nonvalid argument exception
   */
  @Override
  public String run(FileManager fm, String[] args) throws NonvalidArgumentException {
    if (!Validator.checkNumArgs(2, args)) {
      throw new NonvalidArgumentException("error with arguments, only 2 arguments expected");
    }
    String output = "";
    String siteName = args[1];
    String newFile = siteName.substring(siteName.lastIndexOf('/') + 1);

    InputStreamReader stream = curlHelper(siteName);

    BufferedReader in = new BufferedReader(stream);
    String contents = "";
    String line;
    try {
      while ((line = in.readLine()) != null) {
        contents += line + "\n";
      }
    } catch (Exception e) {
      throw new NonvalidArgumentException("invalid input, could not reach site");
    }
    newFile = newFile.replace(".", "");
    fm.makeFile(newFile, contents, fm.getCurrent());
    return output;
  }
}


