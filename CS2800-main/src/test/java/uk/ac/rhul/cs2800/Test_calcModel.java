package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Test_calcModel {

  CalcModel calcModel;

  @BeforeEach
  void setUp() {
    calcModel = new CalcModel();
  }

  @Test
  void evaluateInfixTest() throws InvalidExpressionException, BadTypeException {
    String expression = "4 + 4";
    boolean infix = true;

    assertEquals(calcModel.evaulate(expression, infix), 8f, "result of the expression is 8");
  }

  @Test
  void evaluatePostfixTest() throws InvalidExpressionException, BadTypeException {
    String expression = "4 4 +";
    boolean infix = false;
    
    assertEquals(calcModel.evaulate(expression, infix), 8f, "as infix is false, postfix should be called");
  }

}
