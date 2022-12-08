package uk.ac.rhul.cs2800;

/**
 * Allows the calculation of string expressions.
 * @author sonishkandel
 *
 */
public interface Calculator {
  /**
   * This method is called by other classes implementing the interface.
   * @param expression the expression given to evaluate
   * @return float is the result of evaluating the expression
   * @throws InvalidExpressionException when the expression is invalid then this is thrown
   * @throws BadTypeException thrown when the popping from a stack doesn't give 
   *     the correct data type
   */
  float evaluate(String expression) throws InvalidExpressionException, BadTypeException;
}
