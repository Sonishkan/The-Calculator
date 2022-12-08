package uk.ac.rhul.cs2800;

import java.util.Objects;

/**
 * Entry is a container class for either a Float or a Symbol.
 *
 * @author sonishkandel
 *
 */
public class Entry {
  private float number;
  private Symbol other;
  private Type type;


  /**
   * Constructor for float type entry object.
   *
   * @param number the stack to be stored in the number type entry object
   */
  public Entry(float number) {
    this.type = Type.NUMBER;
    this.number = number;

  }

  /**
   * Constructor for symbol type entry object.
   *
   * @param other the stack to be stored in the symbol type entry object
   */
  public Entry(Symbol other) {
    this.type = Type.SYMBOL;
    this.other = other;
  }

  /**
   * Constructor for invlaid type entry object.
   */
  public Entry() {
    this.type = Type.INVALID;

  }

  /**
   * Used to get the type of said entry object. The type is instated when the constructor is called
   *
   * @return type constant from type enum class, output depends on the constructor used
   */
  public Type getType() {
    return type;
  }

  /**
   * Getting stack of entry if type is NUMBER.
   *
   * @return number the attribute used in the initialisation of the number type entry
   * @throws BadTypeException if entry type isn't number then cannot call getValue()
   */
  public float getValue() throws BadTypeException {
    if (type != Type.NUMBER) {
      throw new BadTypeException("Invalid number");
    }
    return number;
  }


  /**
   * Getting the Symbol of the entry object if type is SYMBOL.
   *
   * @return other the attribute used in the initialisation of the symbol type entry
   * @throws BadTypeException if the entry constructor isn't Symbol then it cannot be called by
   *         other entry types
   * 
   */
  public Symbol getSymbol() throws BadTypeException {
    if (type != Type.SYMBOL) {
      throw new BadTypeException("Invalid number");
    }
    return other;
  }


  @Override
  public int hashCode() {
    return Objects.hash(number, other, type);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Entry other = (Entry) obj;
    return Float.floatToIntBits(number) == Float.floatToIntBits(other.number)
        && this.other == other.other && type == other.type;
  }

  /**
   * This toString() method was generated through eclipse. I changed the setting so it doesn't print
   * out null values. As this didn't cover for number and other, I added similar code so the output
   * would be coherent to the type of entry object. The extra code I added checks that if type isn't
   * number then don't print out the number. The reason this had to be done was due to number never
   * being null so the eclipse generated code would still print the number even if it was a symbol
   * or string type entry. Therefore number would only be printed if the type of entry was number.
   * In doing all this only fields that were used in the constructor will be printed
   * out when the toString() method is called on any entry objects.
   *
   */

  @Override
  public String toString() {
    return "Entry [" + (type == Type.NUMBER ? "number=" + number + ", " : "")
        + (other != null ? "other=" + other + ", " : "")
        + (type != null ? "type=" + type : "") + "]";
  }



}
