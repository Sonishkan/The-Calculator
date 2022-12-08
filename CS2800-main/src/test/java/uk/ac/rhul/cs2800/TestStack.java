package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * This tests that the stack class behaves as it should, testing valid and invalid operations.
 * Before all the stack/array elements were of type int, but due to the specifications of the CW
 * this had to be changed to support using Entry objects instead. To do this the int array stack was
 * changed to be an ArrayList to support entry objects.
 *
 * @author sonishkandel
 */
class TestStack {
  private RhulStack rh;
  private Entry entry;

  // Test 1
  // creatign stack object
  @BeforeEach
  public void setup() {
    rh = new RhulStack();

  }

  // Test 2
  // test to show how size changes as different methods are called on stack
  @Test
  void testSize() {
    assertEquals(rh.size(), 0, "Test a newly created stack to see that it has size zero.");

    entry = new Entry(Symbol.MINUS);
    rh.push(entry);
    assertEquals(rh.size(), 1, "Test stack with one push to see if it has size one.");

    rh.top();
    assertEquals(rh.size(), 1, "To test that top doesn't decrease size of stack - size is zero");

    rh.pop();
    assertEquals(rh.size(), 0, "Test stack with push & pop to see if it has size zero.");

  }



  // Test 3
  // had to Refactor from int pushes to entry pushes. This meant that the int array had to be
  // changed to arraylist of entry objects
  @Test
  void testPush() {
    entry = new Entry(5.0f);
    rh.push(entry);
    assertEquals(rh.size(), 1,
        "Test that push adds entry object to stack thus increases the size of an empty stack.");
  }


  // Test 4
  // test check if pop is allowed when size == 0
  @Test
  void testEmptyPop() {
    assertThrows(EmptyStackException.class, () -> rh.pop(), "You cannot pop when size is 0.");

  }

  // Test 5
  // due to the refactor i had to change the output of pop() from int to entry.
  @Test
  void pushTwice() {
    Entry minus = new Entry(Symbol.MINUS);
    entry = new Entry(Symbol.DIVIDE);
    rh.push(minus);
    rh.push(entry);
    assertEquals(rh.size(), 2, "Pushing twice should give size 2.");
    assertEquals(rh.pop(), entry,
        "Pushing twice then popping should return the second thing pushed.");
    assertEquals(rh.pop(), minus,
        "Pushing twice then popping should return the first thing pushed.");
    assertEquals(rh.size(), 0, "Pushing twice then popping twice should give an empty stack.");
    assertThrows(EmptyStackException.class, () -> rh.pop(),
        "Push, push, pop, pop, pop should throw an exception.");
  }

  // Test 6
  // pop was changed due to the utilisation of ArrayList. This meant that removing the element
  // was possible.
  @Test
  void pushThenPop() {
    entry = new Entry(Symbol.DIVIDE);
    rh.push(entry);
    assertEquals(rh.size(), 1, "Pushing increases size by 1 (size == 1).");
    assertEquals(rh.pop(), entry, "Pushing a five then popping it should return 5.");
    assertEquals(rh.size(), 0, "Pushing then popping should give an empty stack (size == 0).");
    assertThrows(EmptyStackException.class, () -> rh.pop(),
        "Push, pop, pop should throw an exception.");

  }

  // Test 7
  // Test to show that there is no limit to the stack
  @Test
  void pushLots() {
    entry = new Entry(5.0f);
    for (int index = 0; index < 1000; index++) {
      rh.push(entry);
    }
    assertEquals(rh.size(), 1000, "Pushing should increase the size.");

  }

  // Test 8
  // test checks if top method works when size == 0
  @Test
  void testEmptyTop() {
    assertThrows(EmptyStackException.class, () -> rh.top(),
        "Stack is empty (size == 0) so throws emptystackexception");

  }

  // Test 9
  // The refactor from int to entry stack elements meant that top() had to be changed to return
  // Entry object.
  @Test
  void top() {
    Entry minus = new Entry(Symbol.MINUS);
    rh.push(minus);
    rh.push(entry);
    assertEquals(rh.top(), entry, "Latest push should be at the top");

    rh.pop();
    assertEquals(rh.top(), minus, "First push should be at the top due to the pop()");
    rh.pop();
    assertThrows(EmptyStackException.class, () -> rh.top(), "Stack is empty so there is no top");

  }



}
