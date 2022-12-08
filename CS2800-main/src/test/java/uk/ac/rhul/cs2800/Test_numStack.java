package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Test_numStack {

  NumStack numStack;
  
  @BeforeEach
  @Test
  void test() {
    numStack = new NumStack();
    assertNotEquals(numStack.numStack, null, "In the constructor, numStack field has been initialised");
    assertEquals(numStack.numStack.getClass(), RhulStack.class, "Making sure that numStack field is of stack type");
  }
  
  @Test
  void isEmptyTest() {
    assertEquals(numStack.isEmpty(), true, "Stack has no elements thus is empty");
  }
  
  @Test
  void pushTest() {
    float num = 1.3f;
    numStack.push(num);
    assertEquals(numStack.numStack.size, 1, "Number added to stack means size has now increased by 1");
    
    
  }
  
  @Test
  void pushThenisEmptyTest() {
    isEmptyTest();
    pushTest();
    assertEquals(numStack.isEmpty(), false, "As element is pushed into the stack, the stack is no longer empty");
    
  }
  
  @Test
  void emptyPopTest() {
    assertThrows(EmptyStackException.class, () -> numStack.pop(), "You cannot pop when there is no elements in the stack");
  }
  
  @Test
  void pushThenPopTest() throws BadTypeException {
    isEmptyTest();
    pushTest();
    assertEquals(numStack.isEmpty(), false, " stack has element, therefore not empty.");
    assertEquals(numStack.pop(), 1.3f, "pushing 1.3 onto the stack, and popping should return 1.3");
    isEmptyTest();
    
  }

}
