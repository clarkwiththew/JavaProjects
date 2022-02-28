
package errorHandler;

public class Validator {

  /**
   * Check num args.
   *
   * @param argLength the arg length
   * @param args the args
   * @return true, if successful
   */
  public static <E> boolean checkNumArgs(int argLength, E [] args) {
    if (args.length == argLength) {
      return true;
    }
    return false;
  }

  /**
   * Check file name.
   *
   * @param fileName the file name
   * @return true, if successful
   */
  public static boolean checkFileName(String fileName) {
    if (fileName.matches(".*[ /.!@#$%^&*(){}~|<>?].*")) {// be careful
      return true;
    }
    return false;
  }

  /**
   * Check quote.
   *
   * @param args the args
   * @return true, if successful
   */
  public static boolean checkQuote(String[] args) {
    int quoteCount = 0;
    for (int i = 1; i < args.length; i++) {
      quoteCount += args[i].split("\"", -1).length - 1;

    }
    if (quoteCount == 2) {
      return true;
    }
    return false;

  }

  /**
   * precondition:
   * this function works on the assumption that the equals method has been overriden correctly 
   * in the class E.
   * 
   * Checks if is equal.
   * 
   * We override 
   * @param a the a
   * @param b the b
   * @return true, if is equal
   */
  public static <E> boolean isEqual(E a, E b) {
    return (a.equals(b)) ;
      }
}
