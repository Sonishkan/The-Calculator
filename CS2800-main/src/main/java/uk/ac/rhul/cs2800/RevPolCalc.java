package uk.ac.rhul.cs2800;

import java.util.EmptyStackException;
import java.util.Scanner;

/**
 * Evaluates Reverse Polish Notation.
 * 
 * @author sonishkandel
 *
 */
public class RevPolCalc implements Calculator {

  private NumStack values = new NumStack();


  /**
   * This method evaluates the postfix expression, performs the necessary calculation 
   * and returns the result.
   * 
   * @param expression this is the expression/calculation that needs to be evaluated
   * @return result this is the result of the expression
   * @throws BadTypeException used by the entry class so needs to be thrown here
   * @throws InvalidExpressionException this is thrown when the expression is deemed invlaid
   */
  public final float evaluate(String expression) 
      throws BadTypeException, InvalidExpressionException {
    float result;
    String token;
    String operator;
    float operand2;
    float operand1;
    Scanner reader = new Scanner(expression);

    try {

      while (reader.hasNext()) {
        if (reader.hasNextFloat()) {
          token = reader.next(); // each 'variable' in the expression
          values.push(Float.valueOf(token));
        } else {
          operand2 = values.pop();
          operand1 = values.pop();

          operator = reader.next();

          switch (operator) {
            case "+": {
              result = operand1 + operand2;
              values.push(result);
              break;
            }
            case "-": {
              result = operand1 - operand2;
              values.push(result);
              break;
            }
            case "/": {
              result = operand1 / operand2;
              values.push(result);
              break;
            }
            case "*": {
              result = operand1 * operand2;
              values.push(result);
              break;
            }
            default: {
              throw new InvalidExpressionException("Invalid operator found");
            }
          }

        }
      }
      reader.close();
      if (expression.equals("")) {
        throw new InvalidExpressionException("Empty Expression");
      }
      result = values.pop();

      if (!values.isEmpty()) { // stack should be empty after the final pop if expression is valid
        throw new InvalidExpressionException("Unbalanced expression");
      }

      return result;
    } catch (EmptyStackException e) {
      throw new InvalidExpressionException("Invalid expression given");

    }
  }


}
