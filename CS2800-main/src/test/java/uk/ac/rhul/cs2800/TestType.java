package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Tests the toString() method of the Type enum class.
 *
 * @author sonishkandel
 */
class TestType {

  /*
   * Each test was created in the order that it is shown in The code also followed in that order
   * Testing the toString() method also created the enum constants I had to write the stack for each
   * constant myself.
   */

  @Test
  void testSymbol() {
    assertEquals(Type.SYMBOL.toString(), "SYMBOL", "to see if toString() prints 'SYMBOL'");

  }

  @Test
  void testNumber() {
    assertEquals(Type.NUMBER.toString(), "NUMBER", "to see if toString() prints 'NUMBER'");

  }

  //  @Test
  //  void testString() {
  //    assertEquals(Type.STRING.toString(), "STRING", "to see if toString() prints 'STRING'");
  //
  //  }

  @Test
  void testInvalid() {
    assertEquals(Type.INVALID.toString(), "INVALID", "to see if toString() prints 'INVALID'");

  }

}
