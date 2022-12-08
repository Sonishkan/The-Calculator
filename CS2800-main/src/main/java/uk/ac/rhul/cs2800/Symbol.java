package uk.ac.rhul.cs2800;

/**
 * Enum class to hold a list of symbols that the entry object can represent.
 *
 * @author sonishkandel
 *
 */
public enum Symbol {

  /**
   * Left bracket enum constant with its symbol as string value.
   */
  LEFT_BRACKET("("),

  /**
   * Right bracket enum constant with its symbol as string value.
   */
  RIGHT_BRACKET(")"),
  
  /**
   * Times enum constant with its symbol as string value.
   */
  TIMES("*"),
  
  /**
   * Divide enum constant with its symbol as string value.
   */
  DIVIDE("/"),
  
  /**
   * Plus enum constant with its symbol as string value.
   */
  PLUS("+"),
  
  /**
   * Minus enum constant with its symbol as string value.
   */
  MINUS("-"),
  
  /**
   * Invalid enum constant with its symbol as string value.
   */
  INVALID("INVALID");

  private final String value;

  /**
   * Constructor for the Symbol enum constants. The value stored is used for the custom toString()
   * method
   *
   * @param value is the value stored in the enum constants
   */
  Symbol(final String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return value;
  }

}
