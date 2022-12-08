package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Test_revPolCalc {
  
  Calculator revPol;

  @BeforeEach
  @Test
  void test() {
    revPol = (Calculator) new RevPolCalc();
  }
  
  @Test
  void returnEvaluateTest() throws BadTypeException, InvalidExpressionException {
    String expression = "-5";
    
    assertEquals(revPol.evaluate(expression), -5f, "The result of the expression given.");
    
  }
  
  @Test
  void returnAddTest() throws BadTypeException, InvalidExpressionException {
    String expression = "5 6 +";
    
    assertEquals(revPol.evaluate(expression), 11f, "The result of the expression given.");
    
  }
  
  @Test
  void returnSubTest() throws BadTypeException, InvalidExpressionException {
    String expression = "5 6 -";
    
    assertEquals(revPol.evaluate(expression), -1f, "The result of the expression given.");
    
  }
  
  @Test
  void returnDivideTest() throws BadTypeException, InvalidExpressionException {
    String expression = "3 6 /";
    
    assertEquals(revPol.evaluate(expression), .5f, "The result of the expression given.");
    
  }
  
  @Test
  void returnMultiplyTest() throws BadTypeException, InvalidExpressionException {
    String expression = "3 6 *";
    
    assertEquals(revPol.evaluate(expression), 18f, "The result of the expression given.");
    
  }
  
  @Test
  void exceptionsTest() { // this test InvalidExpression and EmptyStack
    String expression = "3 6 (";
    
    assertThrows(InvalidExpressionException.class, () -> revPol.evaluate(expression), "The symbol used wasn't part of the listed operators");
    
    assertThrows(InvalidExpressionException.class, () -> revPol.evaluate("3 + 3"), "EmptyStack exception was caught and invlaid expression is thrown");
    
    assertThrows(InvalidExpressionException.class, () -> revPol.evaluate("3 3 3 +"), "The expression was invalid but empty stack exception is called");
    
    assertThrows(InvalidExpressionException.class, () -> revPol.evaluate("3 3 3"), "The expression was invalid as there was no operations being done to the numbers");

  }
  

  
  
  
  
  
  
  

}
