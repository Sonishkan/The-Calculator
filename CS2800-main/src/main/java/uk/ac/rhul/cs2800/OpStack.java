package uk.ac.rhul.cs2800;

import java.util.EmptyStackException;

/**
 * OpStack uses a RhulStack of symbols, this is then used for the shunting algorithm. 
 * @author sonishkandel
 */
public class OpStack {
  protected RhulStack opStack;


  /**
   * Constructor for OpStack. Field opStack is of type RhulStack which only holds Symbols.
   */
  public OpStack() {
    this.opStack = new RhulStack();
  }


  /**
   * Checking if the stack is empty using the RhulStack methods.
   * 
   * @return boolean depending on if the stack is empty or not
   */
  public boolean isEmpty() {

    if (opStack.size == 0) {
      return true;
    }

    return false;
  }


  /**
   * Push method for the OpStack. As the RhulStack uses entry type 
   * for push parameter, a symbol type entry object was used as a param for stack.
   * @param symbol this symbol param is added to the stack
   */
  public void push(Symbol symbol) {
    this.opStack.push(new Entry(symbol));

  }

  /**
   * This method pops the latest element of the stack and then returns it.
   * 
   * @return symbol that was just popped out of the stack
   * @throws BadTypeException this exception was used in the getters of entry so it needs to be 
   *         thrown again
   * @throws EmptyStackException this exception is thrown if the size of the stack is not greater
   *         than 0, as there is nothing to pop.
   */
  public Symbol pop() throws BadTypeException {
    if (isEmpty() == false) {
      Entry top = this.opStack.pop();
      return top.getSymbol();


    } else {
      throw new EmptyStackException();
    }


  }



}
