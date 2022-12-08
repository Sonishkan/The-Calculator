package uk.ac.rhul.cs2800;

import java.util.EmptyStackException;

/**
 * NumStack uses a RhulStack of floats, this is because reverse 
 * polish notation only uses a Stack of numeric values. 
 * 
 * @author sonishkandel
 *
 */
public class NumStack {

  protected RhulStack numStack;

  /**
   * Constructor for OpStack. Field opStack is of type RhulStack which only holds Symbols.
   */
  public NumStack() {
    this.numStack = new RhulStack();
  }

  /**
   * Checks the size field of RhulStack to see if numStack is empty.
   * 
   * @return boolean depending on if the stack is empty or not
   */
  public boolean isEmpty() {

    if (numStack.size == 0) {
      return true;
    }

    return false;
  }

  /**
   * This method handles the user trying to push a float onto the stack.
   * It uses the RhulStack method push(), to push a entry object using the num param.
   * @param num this is the number that the user added to the stack
   */
  public void push(float num) {
    this.numStack.push(new Entry(num));

  }

  /**
   * This method pops the latest float of the stack and then returns.
   * 
   * @return float that was just popped out of the stack
   * @throws BadTypeException this exception was used in the getters of entry so it needs to be 
   *         thrown again
   * @throws EmptyStackException this exception is thrown if the size of the stack is not greater
   *         than 0, as there is nothing to pop.
   * 
   */
  public float pop() throws BadTypeException {
    if (isEmpty() == false) {
      Entry top = this.numStack.pop();
      return top.getValue();

    } else {
      throw new EmptyStackException();
    }
  }

}
