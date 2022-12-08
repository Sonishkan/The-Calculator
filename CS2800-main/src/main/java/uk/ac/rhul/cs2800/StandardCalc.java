package uk.ac.rhul.cs2800;

import java.util.Scanner;

/**
 * Evaluates infix String expressions by converting to postfix.
 * @author sonishkandel
 *
 */
public class StandardCalc implements Calculator {

  private OpStack values = new OpStack();
  private RevPolCalc rpCalc = new RevPolCalc();


  /**
   * This method evaluates the infix expression, performs the necessary 
   * calculations and returns the result.
   * @param expression infix expression given to evaluate
   * @return the result of the calculation (float)
   * @throws InvalidExpressionException thrown when the expression given is invalid. Happens when 
   *     there is unrecognised operator/token or the stack isn't empty at the end of the evaluation.
   * @throws BadTypeException thrown when the popping from a stack doesn't give 
   *     the correct data type
   */
  public final float evaluate(String expression) 
      throws BadTypeException, InvalidExpressionException {
    String postFix = "";
    Symbol operator;
    String token;
    String operatorValue;
    Scanner scanner = new Scanner(expression);

    while (scanner.hasNext()) {

      if (scanner.hasNextFloat()) {

        token = scanner.next();
        postFix += " ";
        postFix += token;

        // removes the extra padding of spaces on either sides of the expression
        postFix = postFix.trim(); 

      } else {

        token = scanner.next();
        operator = returnSymbol(token);

        if (operator != Symbol.INVALID) {

          if (operator == Symbol.RIGHT_BRACKET) {

            operator = values.pop();

            while (operator != Symbol.LEFT_BRACKET) {
              operatorValue = operator.toString();
              postFix += " ";
              postFix += operatorValue;
              operator = values.pop();

            }

          } else if (!values.isEmpty() && (operator != Symbol.LEFT_BRACKET)) { // precedence check

            Symbol top = values.pop(); // top of stack

            if (lowerPrecedence(top, operator)) { // if top operator has lower precedence

              values.push(top);
              values.push(operator);

            } else { // if top operator has higher or same precedence, add to string first 

              operatorValue = top.toString();
              postFix += " ";
              postFix += operatorValue;
              values.push(operator);
            }

          } else { // if stack is empty then just push symbol
            values.push(operator);

          }
        } else {
          scanner.close();
          throw new InvalidExpressionException("Invalid operator found");
        }

      }
    }


    while (!values.isEmpty()) {


      operator = values.pop();

      operatorValue = operator.toString();

      if ((operator != (Symbol.LEFT_BRACKET)) && (operator != (Symbol.RIGHT_BRACKET))) {
        postFix += " ";
        postFix += operatorValue;
      }

    }

    scanner.close();
    return rpCalc.evaluate(postFix);
  }

  private Symbol returnSymbol(String symbol) {


    for (Symbol sym : Symbol.values()) {

      if (sym.toString().equals(symbol)) {
        return sym;
      }
    }

    return Symbol.INVALID;

  }

  private int getPrecedenceLevel(Symbol operator) throws InvalidExpressionException {

    switch (operator) {
      case LEFT_BRACKET:
      case RIGHT_BRACKET:
        return 0;
      case PLUS:
      case MINUS:
        return 1;
      case DIVIDE:
      case TIMES:
        return 2;

      default:
        throw new InvalidExpressionException("Operator unknown: " + operator);
    }
  }

  private boolean lowerPrecedence(Symbol operator1, Symbol operator2) 
      throws InvalidExpressionException {

    if (getPrecedenceLevel(operator1) >= getPrecedenceLevel(operator2)) {
      return false;
    }

    return true;
  }




}
