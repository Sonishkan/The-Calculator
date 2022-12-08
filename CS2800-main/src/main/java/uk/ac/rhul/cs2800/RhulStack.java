package uk.ac.rhul.cs2800;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;


/**
 * Creating a stack of entry objects.
 *
 * @author sonishkandel
 */
public class RhulStack {


  protected List<Entry> stack = new ArrayList<>();
  protected int size = 0;


  /**
   * Function returns the size of stack.
   *
   * @return size the number of elements in the stack
   */
  public int size() {
    return size;
  }


  /**
   * Adds the stack to the stack, increasing the size by 1.
   *
   * @param entry the entry object being pushed
   */
  public void push(Entry entry) {
    stack.add(entry);
    size += 1;
  }

  /**
   * Used to delete last entry pushed into the stack and then return said entry.
   *
   * @return top, returns the entry that was at the top of the stack
   */

  public Entry pop() {
    if (size == 0) {
      throw new EmptyStackException();
    }

    Entry top = stack.get(size - 1);
    stack.remove(size - 1);
    size -= 1;
    return top;
  }


  /**
   * Used to show the last stack pushed to the stack.
   *
   * @return top, returns the entry that is at the top of the stack (latest push)
   */
  public Entry top() {
    if (size == 0) {
      throw new EmptyStackException();
    }

    Entry top = stack.get(size - 1);

    return top;
  }

}
