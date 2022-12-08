package uk.ac.rhul.cs2800;

/**
 * This class handles the calling of the 2 evaluate methods.
 * @author sonishkandel
 *
 */
public class CalcModel {
  
  private final Calculator infix = new StandardCalc();
  private final Calculator postfix = new RevPolCalc();
  

  /**
   * This method calls the different method of evaluate.
   * @param expression the input given by the user to evaluate
   * @param infix this makes sure that the right evaluation method is called
   * @return result the answer to the expression (float)
   * @throws BadTypeException this is used for pop methods of the opStack and numstack
   * @throws InvalidExpressionException  the expression is invalid so cannot be evaluated
   */
  public float evaulate(String expression, boolean infix) 
      throws InvalidExpressionException, BadTypeException {
    
    if (infix) {
      return this.infix.evaluate(expression);
    }
    return this.postfix.evaluate(expression);
    
    
    
  }

}
