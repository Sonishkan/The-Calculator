package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Test_opStack {
  OpStack opStack;

  @BeforeEach
  @Test
  void test1() {
    opStack = new OpStack();
    assertNotEquals(opStack.opStack, null, "The construction of a RhulStack opStack");
    assertEquals(opStack.opStack.getClass(), RhulStack.class, "Checking that opStack.opstack is of type RhulStack");
  }

  @Test
  void isEmptyTest() {
    assertEquals(opStack.isEmpty(), true, "New object has no elements in the stack, therefore the size of stack is empty.");
  }

  @Test
  void pushTest() {
    Symbol symbol = Symbol.DIVIDE;
    opStack.push(symbol);
    assertEquals(opStack.opStack.size, 1, "Symbol added to stack means size = 1");

  }
  
  @Test
  void pushThenisEmptyTest() {
    isEmptyTest();
    pushTest();
    assertEquals(opStack.isEmpty(), false, "As element is pushed into the stack, the size is no longer 0 - thus stack is not empty");
  }
  
  @Test
  void emptyPopTest() {
    assertThrows(EmptyStackException.class, () -> opStack.pop(), "You cannot pop when size is 0");
  }
  
  @Test
  void pushThenPop() throws BadTypeException {
    isEmptyTest();
    pushTest();
    assertEquals(opStack.isEmpty(), false, " stack has element, therefore not empty.");
    assertEquals(opStack.pop(), Symbol.DIVIDE, "pushing a symbol onto the stack");
    isEmptyTest();
    
    
    
    
  }
  

}
