package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Tests the toString() method of the Symbol enum class.
 * Each test was created in the order shown
 * The development also followed in that order
 * Testing the toString() method also creates the enum constants
 * I had to write the stack for each constant myself
 *
 * @author sonishkandel
 *
 */
class TestSymbol {


  @Test
  void testLeftBracket() {
    assertEquals(Symbol.LEFT_BRACKET.toString(), "(", "To see if toString() prints '('");

  }

  @Test
  void testRightBracket() {
    assertEquals(Symbol.RIGHT_BRACKET.toString(), ")", "To see if toString() prints ')'");

  }

  @Test
  void testTimes() {
    assertEquals(Symbol.TIMES.toString(), "*", "To see if toString() prints '*'");

  }

  @Test
  void testDivide() {
    assertEquals(Symbol.DIVIDE.toString(), "/", "To see if toString() prints '/'");

  }

  @Test
  void testPlus() {
    assertEquals(Symbol.PLUS.toString(), "+", "To see if toString() prints '+'");

  }

  @Test
  void testMinus() {
    assertEquals(Symbol.MINUS.toString(), "-", "To see if toString() prints '-'");

  }

  @Test
  void testInvalid() {
    assertEquals(Symbol.INVALID.toString(), "INVALID", "To see if toString() prints 'INVALID'");

  }



}


