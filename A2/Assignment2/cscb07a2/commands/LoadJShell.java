
package commands;

import data.*;
import errorHandler.NonvalidArgumentException;
import java.io.*;


public class LoadJShell implements Command {


  /**
   * Load the contents of the FileName and reinitialize everything
   * that was saved previously into the FileName
   *
   * @param fm fileManager where the command is executed
   * @param args the name of the file to be loaded
   * @return the string
   * @throws NonvalidArgumentException the nonvalid argument exception
   */
  @SuppressWarnings("resource")
  public String run(FileManager fm, String[] args) throws NonvalidArgumentException {
    String output = "";
    if (args.length > 2)
      throw new NonvalidArgumentException("error, too many arguments for LoadJShell");
    
    if (args.length == 1)
      throw new NonvalidArgumentException("error, file path must be provided");
    
    FileInputStream fis;
    ObjectInputStream ois;

    try {
      fis = new FileInputStream(args[1]);
      ois = new ObjectInputStream(fis);
    } catch (Exception e) {
      throw new NonvalidArgumentException(
          "error, something wrong with loading previous session info");
    }

    JFileManager loaded = null;

    try {
      loaded = (JFileManager) ois.readObject();
    } catch (ClassNotFoundException e) {
      throw new NonvalidArgumentException(
          "error, something wrong with loading previous session info");
    } catch (IOException e) {
      throw new NonvalidArgumentException(
          "error, something wrong with loading previous session info");
    }
    try {
      if (loaded != null) {
        
        fm.setRoot(loaded.getRoot());
        fm.setCurrent(loaded.getCurrent());
        // System.out.println(loaded.getCurrent());
        // System.out.println(loaded.getCurrent().getParentDirName());
        fm.mergeDirectoryStack(loaded.getDirectoryStack());
        // System.out.println(fm == loaded);
        // System.out.println(fm.getInputHistory());
        // System.out.println(loaded.getInputHistory());
        fm.mergeInputHistory(loaded.getInputHistory());
        fis.close();
        ois.close();
        output = "previous session data is successfully loaded now.\n";
      } else {
        throw new NonvalidArgumentException(
            "error, something wrong with loading previous session info");
      }
    } catch (Exception e) {
      throw new NonvalidArgumentException(
          "error, something wrong with loading previous session info");
    }

    return output;
  }

}
