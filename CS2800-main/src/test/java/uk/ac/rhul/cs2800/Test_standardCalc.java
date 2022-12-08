package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class Test_standardCalc {

  Calculator standCalc;

  @BeforeEach
  @Test
  void test() {
    standCalc = (Calculator) new StandardCalc();
  }

  @Test
  void returnEvaluateTest() throws BadTypeException, InvalidExpressionException {
    String expression = "-5";

    assertEquals(standCalc.evaluate(expression), -5f, "The result of the expression");
  }

  @Test
  void returnAddTest() throws BadTypeException, InvalidExpressionException {
    String expression = "5 + 1";

    assertEquals(standCalc.evaluate(expression), 6f, "The result of adding 1 to 5 is 6");
  }

  @Test
  void returnSubTest() throws BadTypeException, InvalidExpressionException {
    String expression = "5 - 1";

    assertEquals(standCalc.evaluate(expression), 4f, "The result of 5 - 1 is 4");

  }

  @Test
  void returnDivideTest() throws BadTypeException, InvalidExpressionException {
    String expression = "4 / 2";

    assertEquals(standCalc.evaluate(expression), 2f, "The result of 4/2 is 2");

  }

  @Test
  void returnMultiplyTest() throws BadTypeException, InvalidExpressionException {
    String expression = "4 * 2";

    assertEquals(standCalc.evaluate(expression), 8f, "The result of 4*2 is 8");

  }

  @Test
  void returnNormalBracketTest() throws BadTypeException, InvalidExpressionException {
    String expression = "( 4 )";

    assertEquals(standCalc.evaluate(expression), 4f, "( 4 ) is the same thing as 4");


  }

  @Test
  void simpleBracketsTest() throws BadTypeException, InvalidExpressionException {
    String expression = "( 4 * 4 ) + 2";
    assertEquals(standCalc.evaluate(expression), 18f, "( 4 * 4 ) + 2 evaluates to 16 + 2 = 18");

    expression = "( 4 / 4 ) + 2";
    assertEquals(standCalc.evaluate(expression), 3f, "( 4 / 4 ) + 2 evaluates to 1 + 2 = 3");

  }

  @Test
  void simplePrecedenceTest() throws BadTypeException, InvalidExpressionException {
    String expression = "4 * 4 / 2 / 2";

    assertEquals(standCalc.evaluate(expression), 4f, "the multiplication should occure first then the division -> 4");
  }

  @Test
  void precedenceBracketsTest() throws BadTypeException, InvalidExpressionException {
    String expression = "4 * ( 4 / 2 ) / 2";
    assertEquals(standCalc.evaluate(expression), 4f, "the brackets should occure first then the multiplication then the division -> 4");

  }

  @Test
  void precedenceBrackets2Test() throws BadTypeException, InvalidExpressionException {
    String expression = "4 * ( 4 / 2 ) - 2";
    assertEquals(standCalc.evaluate(expression), 6f, "the brackets should occure first then the multiplication then the subtraction -> 6");

  }

  @Test
  void InvalidExpressionTest() throws BadTypeException, InvalidExpressionException {
    String expression = " ";
    assertThrows(InvalidExpressionException.class, () -> standCalc.evaluate(expression), "as the expression is empty, it is invalid");

    assertThrows(InvalidExpressionException.class, () -> standCalc.evaluate("()"), "the expression after standardcalc.evaluate, it is invalid");

    assertThrows(InvalidExpressionException.class, () -> standCalc.evaluate("( 3 + "), "as the expression isnt correctly defined, it is invalid");

    assertThrows(InvalidExpressionException.class, () -> standCalc.evaluate("(  + "), "as the expression isnt correctly defined, it is invalid");

    assertThrows(InvalidExpressionException.class, () -> standCalc.evaluate("( + )"), "there is an operator but no floats, it is invalid");


  }

}
