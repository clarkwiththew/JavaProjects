// **********************************************************

// *********************************************************
package data;

import java.util.HashMap;
import java.io.*;
import data.*;
/**
 * @author Junheng Wang, Hyun Woo (Eddie) Shin, Ivanhoe Chou, Ethan Anada
 */
/**
 * The Class directory.
 */
@SuppressWarnings("serial")
public class Directory implements Serializable {

  /** The parent dir. */
  private Directory parentDir;

  /** The dir name. */
  private String dirName;

  /** The full dir path. */
  private String fullDirPath;

  /** The directory map. */
  private HashMap<String, Directory> directoryMap = new HashMap<String, Directory>();

  /** The file map. */
  private HashMap<String, File> fileMap = new HashMap<String, File>();

  /**
   * Gets the parent's directory
   *
   * @return The parent's directory
   */
  public Directory getParentDir() {
    return parentDir;
  }

  /**
   * Gets the parent's directory name
   *
   * @return The parent's directory name
   */

  public String getParentDirName() {
    return parentDir.getDirName();
  }

  /**
   * Gets the directory name
   *
   * @return the directory name
   */
  public String getDirName() {
    return this.dirName;
  }

  /**
   * Instantiates a new directory.
   *
   * @param nameToAdd The name of the new directory to add
   */
  public Directory(String nameToAdd) {
    this.dirName = nameToAdd;
  }


  /**
   * Instantiates a new directory.
   *
   * @param nameToAdd The name of the new directory to add
   * @param parentToAdd The parent directory to add
   */
  public Directory(String nameToAdd, Directory parentToAdd) {
    this.dirName = nameToAdd;
    this.parentDir = parentToAdd;
  }

  /**
   * Contains file key.
   *
   * @param keyName The key name
   * @return true, if successful
   */
  // checks if a directory has a file
  public boolean containsFileKey(String keyName) {
    if (fileMap.containsKey(keyName)) {
      return true;
    }
    return false;
  }

  /**
   * Contains directory key.
   *
   * @param keyName The key name
   * @return true, if successful
   */
  // checks if a directory has a subdirectory
  public boolean containsDirectoryKey(String keyName) {
    if (directoryMap.containsKey(keyName)) {
      return true;
    }
    return false;
  }

  /**
   * Gets the directory key.
   *
   * @return the dir key
   */
  public String getDirKey() {
    String out = "";
    for (String key : directoryMap.keySet()) {
      out += key + "\n";
    }
    return out;
  }

  /**
   * Gets the file key.
   *
   * @return the file key
   */
  public String getFileKey() {
    String out = "";
    for (String key : fileMap.keySet()) {
      out += key + "\n";
    }
    return out;
  }

  // public void setDirectory(String nameOfDir, directory dirToAdd) throws nonvalidArgumentException
  // {
  // if (directoryMap.containsKey(nameOfDir)) {
  // throw new nonvalidArgumentException("directory already exists");
  // }
  // directoryMap.put(nameOfDir, dirToAdd);
  // dirToAdd.parentDir = this;
  // }


  /**
   * Sets the directory.
   *
   * @param nameOfDir The name of the directory
   * @param dirToAdd The name of the directory to add
   */
  public void setDirectory(String nameOfDir, Directory dirToAdd) {
    directoryMap.put(nameOfDir, dirToAdd);
    dirToAdd.parentDir = this;
  }

  // public directory getDirectory(String name) throws nonvalidArgumentException {
  // if (directoryMap.containsKey(name)) {
  // return directoryMap.get(name);
  // } else {
  // throw new nonvalidArgumentException("Directory does not exist");
  // }
  /**
   * Gets the directory.
   *
   * @param name The name of the directory
   * @return The directory
   */

  public Directory getDirectory(String name) {

    // get the subdirectory from current directory given name
    return directoryMap.get(name);

  }

  // public void setFile(String nameOfFile, file fileToAdd) throws nonvalidArgumentException {
  // if (fileMap.containsKey(nameOfFile)) {
  // throw new nonvalidArgumentException("file already exists");
  // } else {
  // fileMap.put(nameOfFile, fileToAdd);
  // }
  /**
   * Sets the file.
   *
   * @param nameOfFile The name of file
   * @param fileToAdd The file to add
   */
  // }
  public void setFile(String nameOfFile, File fileToAdd) {
    fileMap.put(nameOfFile, fileToAdd);
  }

  /**
   * Retrieve full path.
   *
   * @return The full path as a string
   */
//  public String retrieveFullPath() {
//    String path = "";
//    Directory temp = this;
//    
//    if (temp != null) {
//      while (temp.getDirName() != "/") {
//        path = temp.getDirName() + path;
//        path = "/" + path;
//        temp = temp.getParentDir();
//      }
//    }
//
//    return path;
//  }

  /**
   * Gets the file.
   *
   * @param nameOfFile The name of file
   * @return The file
   */

  public File getFile(String nameOfFile) {
    return fileMap.get(nameOfFile);
  }

  /**
   * Gets the sub-directory.
   * 
   * @param dirName The name of sub-directory
   * @return The directory
   */
  public Directory getSubdirectory(String dirName) {
    return directoryMap.get(dirName);
  }
  
  public void removeDirectory(String dirName) {
    directoryMap.remove(dirName);
  }
  
  public void removeFile(String fileName) {
	  fileMap.remove(fileName);
  }
  
  public HashMap<String, Directory> getDirectoryHashMap() {
    return this.directoryMap;
  }
  
  public HashMap<String, File> getFileHashMap() {
    return this.fileMap;
  }



}
