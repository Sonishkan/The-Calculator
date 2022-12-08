package uk.ac.rhul.cs2800;

/**
 * Creating a custom exception when calling methods on entry types that don't support it.
 *
 * @author sonishkandel
 *
 */
public class BadTypeException extends Exception {


  private static final long serialVersionUID = 1L;

  /**
   * This constructor sends the exception message.
   * 
   * @param message error message that is used for the exception
   */
  public BadTypeException(String message) {
    super(message);
  }



}
