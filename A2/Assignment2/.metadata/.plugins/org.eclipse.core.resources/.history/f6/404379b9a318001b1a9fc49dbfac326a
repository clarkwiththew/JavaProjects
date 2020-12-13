package data;


public class File {

  // This Files's parent directory
  private Directory parent;

  public Directory getParent() {
    return parent;
  }

  // This File's name
  private String name;

  public String getName() {
    return name;
  }

  // This File's contents
  private String contents;

  public String getContents() {
    return contents;
  }

  // Create a new File which is not within another directory with no contents
  public File(String name) {
    this.name = name;
  }

  // Create a new File having a parent directory with no contents
  public File(String name, Directory parent) {
    new File(name);
    this.parent = parent;
  }


  // Create a new File having a parent directory and contents
  public File(String name, Directory parent, String contents) {
    new File(name);
    this.parent = parent;
    this.contents = contents;
  }

  // Overwrites File's contents
  public void overwriteContents(String contents) {
    this.contents = contents;
  }

  // Changes a File's name
  public void renameFile(String newname) {
    this.name = newname;
  }

  // Adds contents to a current File's contents
  public void appendContents(String contents) {
    this.contents = (this.contents + "\n" + contents);
  }

  // Returns this File's absolute path
  public String getPath() {
    // Initialise the result string to an empty string
    String result = "";
    // If this File has a parent directory, add its path to the result string
    if (parent != null) {
      result += parent.getPath();
    }

    return result;
  }

}
