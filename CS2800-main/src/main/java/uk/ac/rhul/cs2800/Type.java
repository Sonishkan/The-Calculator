package uk.ac.rhul.cs2800;

/**
 * ENUM class for list of the types an Entry can represent.
 *
 * @author sonishkandel
 *
 */
public enum Type {
  /**
   * Number enum constant with its symbol as string value.
   */
  NUMBER("NUMBER"),
  
  /**
   * Symbol enum constant with its symbol as string value.
   */
  SYMBOL("SYMBOL"),
  
  /**
   * Invalid enum constant with its symbol as string value.
   */
  INVALID("INVALID");

  private final String value;


  /**
   * Constructor for the enum constants. The value stored is used for the custom toString() method.
   *
   * @param text is the value stored in the enum constants
   */
  Type(final String text) {
    this.value = text;
  }

  @Override
  public String toString() {
    return value;
  }


}
