
package errorHandler;


/**
 * The Class CommandException.
 */

@SuppressWarnings("serial")
public abstract class CommandException extends Exception {
  
  /**
   * Instantiates a new command exception.
   *
   * @param message the message
   */
  public CommandException(String message) {
    super(message);
  }
}


