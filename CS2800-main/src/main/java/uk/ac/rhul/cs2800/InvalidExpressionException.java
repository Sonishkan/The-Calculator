package uk.ac.rhul.cs2800;

/**
 * This exception occurs when the expression is invalid in some way.
 * One way could be if a symbol in the expression isn't valid for that calculation. 
 *
 * @author sonishkandel
 *
 */
public class InvalidExpressionException extends Exception {


  private static final long serialVersionUID = 1L;

  /**
   * This constructor sends the exception message.
   * 
   * @param message error message that is used for the exception
   */
  public InvalidExpressionException(String message) {
    super(message);
  }



}

