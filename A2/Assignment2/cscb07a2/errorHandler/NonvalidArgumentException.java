
package errorHandler;

/**
 * The Class nonvalidArgumentException.
 */
@SuppressWarnings("serial")
public class NonvalidArgumentException extends CommandException {

  /**
   * Instantiates a new nonvalid argument exception.
   *
   * @param message the message
   */
  public NonvalidArgumentException(String message) {
    super(message);
  }
}
