// **********************************************************

// *********************************************************
package commands;

import data.*;
import errorHandler.NonvalidArgumentException;


public class Rm implements Command {

  /**
   * Removes the input directory from the file system. 
   * Also removes all the children of the input directory
   *
   * @param fm the fm
   * @param args the args
   * @return the string
   * @throws NonvalidArgumentException the nonvalid argument exception
   */
  @Override
  public String run(FileManager fm, String[] args) throws NonvalidArgumentException {
    Directory currentDir = fm.getCurrent();
    Directory DirtoRemove;

    if (args.length != 2)
      throw new NonvalidArgumentException("error, invalid arguments count for rm command");

    if (args[1] == ".." || args[1] == ".")
      throw new NonvalidArgumentException(
          "error, invalid DIR path, can't remove parent of current dir or current dir itself");

    try {
      DirtoRemove = fm.pathToCurrent(currentDir, args[1]);
    } catch (Exception e) {
      throw new NonvalidArgumentException("error, invalid DIR path");
    }

    if (DirtoRemove == fm.getCurrent() || DirtoRemove == fm.getCurrent().getParentDir()
        || DirtoRemove == fm.getRoot()) {
      throw new NonvalidArgumentException(
          "error, invalid DIR path, the end directory is either .. or .");
    }

    String DirToRemoveName = DirtoRemove.getDirName();

    Directory ParentOfDirtoRemove = DirtoRemove.getParentDir();

    if (ParentOfDirtoRemove.containsDirectoryKey(DirToRemoveName))
      ParentOfDirtoRemove.removeDirectory(DirToRemoveName);
    else {
      throw new NonvalidArgumentException("something wrong with removing a directory in rm");
    }

    return "";
  }

}
