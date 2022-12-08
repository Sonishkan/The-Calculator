package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * This test file checks all the functionality of the Entry class.
 *
 * @author sonishkandel
 *
 */
class TestEntry {
  private Entry entry;


  ///////////////////////////// Test Constructors /////////////////////////////
  /**
   * (1) The tests (test1, test2, test3) are used for creating an entry object of Symbol, number and
   * string types they all test different constructors due to the different attribute types needed.
   * 
   */
  @Test /// to test for Symbol entry constructor
  void test1() {
    entry = new Entry(Symbol.DIVIDE);
  }

  @Test // to test for float entry constructor
  void test2() {
    entry = new Entry(5.0f);
  }

  //  @Test // to test for string entry constructor
  //  void test3() {
  //    entry = new Entry(" ");
  //  }

  @Test // to test for invalid entry constructor
  void test4() {
    entry = new Entry();
  }


  //////////////////////////////// Test Getters ////////////////////////////////
  /**
   * (2) testGetSymbol() is used to check that all the symbol enum constants are made this also
   * checks that it returns the correct symbol back, by testing getSymbol() method on entry.
   *
   * @throws BadTypeException is called if the getSymbol method is used on types excluding SYMBOL
   * 
   */
  @Test
  void testGetSymbol() throws BadTypeException {
    test1();
    entry = new Entry(Symbol.LEFT_BRACKET);
    assertEquals(entry.getSymbol(), Symbol.LEFT_BRACKET,
        "Making type as symbol to see if output is type");

    entry = new Entry(Symbol.RIGHT_BRACKET);
    assertEquals(entry.getSymbol(), Symbol.RIGHT_BRACKET,
        "Making type as symbol to see if output is type");

    entry = new Entry(Symbol.TIMES);
    assertEquals(entry.getSymbol(), Symbol.TIMES, "Making type as symbol to see if output is type");

    entry = new Entry(Symbol.DIVIDE);
    assertEquals(entry.getSymbol(), Symbol.DIVIDE,
        "Making type as symbol to see if output is type");

    entry = new Entry(Symbol.PLUS);
    assertEquals(entry.getSymbol(), Symbol.PLUS, "Making type as symbol to see if output is type");

    entry = new Entry(Symbol.MINUS);
    assertEquals(entry.getSymbol(), Symbol.MINUS, "Making type as symbol to see if output is type");

    entry = new Entry(Symbol.INVALID);
    assertEquals(entry.getSymbol(), Symbol.INVALID,
        "Making type as symbol to see if output is type");

  }

  /**
   * (3) testGetNum() is used to show return stack of number type entry object. The throws
   * badtypeexception had to be added to this test as it is required in a test that comes later on
   *
   * @throws BadTypeExceptionis called if the getValue method is used on types excluding NUMBER
   */
  @Test
  void testGetNum() throws BadTypeException {
    test2();
    assertEquals(entry.getValue(), 5.0f, "Initialising entry to hold a float, to check the type");
  }


  /**
   * (4) testGetString() is used to show return string of string type object. The reason for the
   * throws argument is the same as before badtypeexception had to be added to this test as it is
   * required in a test that comes later on
   *
   * @throws BadTypeException is called if the getString method is used on types excluding STRING
   */
  //  @Test
  //  void testGetString() throws BadTypeException {
  //    test3();
  //    assertEquals(entry.getString(), " ", "Initialising entry to hold a float, to check the type");
  //  }


  /**
   * (5) testGetType() is used to return the type of entry object constructed (String, Symbol,
   * Number).
   * 
   */
  @Test
  void testGetType() {
    test1();
    assertEquals(entry.getType(), Type.SYMBOL,
        "Making SYMBOL entry object to see if type is SYMBOL");
    test2();
    assertEquals(entry.getType(), Type.NUMBER,
        "Making NUMBER entry object to see if type is NUMBER");
    //    test3();
    //    assertEquals(entry.getType(), Type.STRING,
    //        "Making STRING entry object to see if type is STRING");
    test4();
    assertEquals(entry.getType(), Type.INVALID,
        "Making INVALID entry object to see if type is INVALID");


  }



  /////////////////////////// Test BadTypeExceptions ///////////////////////////

  /**
   * (6) Used to test the BadTypeExeception for method getValue(). This is why the throws was needed
   * in previous get. Tests We test in normal conditions then move to when the type of entry isnt
   * compatible with the getValue() method
   *
   * @throws BadTypeException is thrown due to getValue() being called on a string and symbol entry
   *         object
   */
  @Test // one for get stack, when not number
  void testGetValueBad() throws BadTypeException {
    test2();
    assertEquals(entry.getValue(), 5.0f, "Initialising entry to hold a float, to check the type");

    //    test3();
    //    assertThrows(BadTypeException.class, () -> entry.getValue(),
    //        "Initialising entry to hold String & running getValue method on it");

    test1();
    assertThrows(BadTypeException.class, () -> entry.getValue(),
        "Initialising entry to hold Symbol & running getValue method on it");

    test4();
    assertThrows(BadTypeException.class, () -> entry.getValue(),
        "Initialising invalid type entry & running getValue method on it");

  }

  /**
   * (7) Used to test the BadTypeException for the getString() method. We test when entry is of type
   * string and then when it is of type number and symbol.
   *
   * @throws BadTypeException is thrown due to getString() being called on entry objects that aren't
   *         of type string
   */
  //  @Test // one for get string, when not string
  //  void testGetStringBad() throws BadTypeException {
  //    test3();
  //    assertEquals(entry.getString(), " ", "Initialising entry to hold a float, to check the type");
  //
  //    test2();
  //    assertThrows(BadTypeException.class, () -> entry.getString(),
  //        "Initialising entry to hold float & running getString method on it");
  //
  //    test1();
  //    assertThrows(BadTypeException.class, () -> entry.getString(),
  //        "Initialising entry to hold Symbol & running getString method on it");
  //
  //    test4();
  //    assertThrows(BadTypeException.class, () -> entry.getString(),
  //        "Initialising invalid type entry & running getString method on it");
  //
  //
  //  }

  /**
   * (8) Used to test the getSymbol() method. We initially test entry when it is of type symbol.
   * Then we test when it is of type number and string. As the method is only compatible with symbol
   * type entry it should throw badtypeexeception when entry type differs
   *
   * @throws BadTypeException is thrown as getSymbol() is only compatible with symbol type entry
   *         objects
   */
  @Test // one for get symbol, when not symbol enum
  void testGetSymbolBad() throws BadTypeException {
    test1();
    assertEquals(entry.getSymbol(), Symbol.DIVIDE,
        "Initialising entry to hold a symbol enum, to check the type");

    test2();
    assertThrows(BadTypeException.class, () -> entry.getSymbol(),
        "Initialising entry to hold float & running getSymbol method on it");

    //    test3();
    //    assertThrows(BadTypeException.class, () -> entry.getSymbol(),
    //        "Initialising entry to hold Symbol & running getSymbol method on it");

    test4();
    assertThrows(BadTypeException.class, () -> entry.getSymbol(),
        "Initialising invalid type entry & running getSymbol method on it");


  }


  /**
   * The tests below are for testing if 2 entry objects are equal to each other. test 9 checks with
   * floats test 10 checks with string test 11 checks with symbols test 12 checks with invalid
   * 
   */
  @Test // test 9
  void testEqualsFloat() {


    entry = new Entry(5.0f);
    Entry entry2 = new Entry(5.0f);

    assertEquals(entry.equals(entry2), Boolean.TRUE,
        "When Initialising 2 entry objects with the same constructor and parameter value, the "
            + "equals method should return True");


    entry2 = new Entry(6.0f);
    assertEquals(entry.equals(entry2), Boolean.FALSE,
        "When Initialising 2 entry objects with the same constructor and different parameter "
            + "value, the equals method should return False");

    //    entry2 = new Entry("hello");
    //    assertEquals(entry.equals(entry2), Boolean.FALSE,
    //        "When Initialising 2 entry objects with different constructors, the equals method "
    //            + "should return False");


    entry2 = new Entry(Symbol.DIVIDE);
    assertEquals(entry.equals(entry2), Boolean.FALSE,
        "When Initialising 2 entry objects with different constructors, the equals method "
            + "should return False");

    entry2 = new Entry();
    assertEquals(entry.equals(entry2), Boolean.FALSE,
        "When Initialising 2 entry objects with different constructors, the equals method "
            + "should return False");
  }

  //  @Test // test 10
  //  void testEqualsString() {
  //
  //    // FLOAT tests
  //    entry = new Entry("Hello");
  //    Entry entry2 = new Entry("Hello");
  //
  //    assertEquals(entry.equals(entry2), Boolean.TRUE,
  //        "When Initialising 2 entry objects with the same constructor and parameter value, the"
  //            + " equals method should return True");
  //
  //
  //    entry2 = new Entry("world");
  //    assertEquals(entry.equals(entry2), Boolean.FALSE,
  //        "When Initialising 2 entry objects with the same constructor and different parameter"
  //            + " value, the equals method should return False");
  //
  //    entry2 = new Entry(10.0f);
  //    assertEquals(entry.equals(entry2), Boolean.FALSE,
  //        "When Initialising 2 entry objects with different constructors, the equals method"
  //            + " should return False");
  //
  //
  //    entry2 = new Entry(Symbol.DIVIDE);
  //    assertEquals(entry.equals(entry2), Boolean.FALSE,
  //        "When Initialising 2 entry objects with different constructors, the equals method"
  //            + " should return False");
  //
  //    entry2 = new Entry();
  //    assertEquals(entry.equals(entry2), Boolean.FALSE,
  //        "When Initialising 2 entry objects with different constructors, the equals method"
  //            + " should return False");
  //  }

  @Test // test 11
  void testEqualsSymbol() {

    entry = new Entry(Symbol.DIVIDE);
    Entry entry2 = new Entry(Symbol.DIVIDE);

    assertEquals(entry.equals(entry2), Boolean.TRUE,
        "When Initialising 2 entry objects with the same constructor and parameter value,"
            + " the equals method should return True");


    entry2 = new Entry(Symbol.LEFT_BRACKET);
    assertEquals(entry.equals(entry2), Boolean.FALSE,
        "When Initialising 2 entry objects with the same constructor and different parameter"
            + " value, the equals method should return False");

    //    entry2 = new Entry("hello");
    //    assertEquals(entry.equals(entry2), Boolean.FALSE,
    //        "When Initialising 2 entry objects with different constructors, the equals method"
    //            + " should return False");


    entry2 = new Entry(7.0f);
    assertEquals(entry.equals(entry2), Boolean.FALSE,
        "When Initialising 2 entry objects with different constructors, the equals method"
            + " should return False");

    entry2 = new Entry();
    assertEquals(entry.equals(entry2), Boolean.FALSE,
        "When Initialising 2 entry objects with different constructors, the equals method"
            + " should return False");
  }

  @Test // test 12
  void testEqualsInvalid() {

    entry = new Entry();
    Entry entry2 = new Entry();

    assertEquals(entry.equals(entry2), Boolean.TRUE,
        "When Initialising 2 entry objects with the same constructor and parameter value, the"
            + " equals method should return True");


    entry2 = new Entry(6.0f);
    assertEquals(entry.equals(entry2), Boolean.FALSE,
        "When Initialising 2 entry objects with the same constructor and different parameter value,"
            + " the equals method should return False");

    //    entry2 = new Entry("hello");
    //    assertEquals(entry.equals(entry2), Boolean.FALSE,
    //        "When Initialising 2 entry objects with different constructors, the equals method should "
    //            + "return False");


    entry2 = new Entry(Symbol.DIVIDE);
    assertEquals(entry.equals(entry2), Boolean.FALSE,
        "When Initialising 2 entry objects with different constructors, the equals method should "
            + "return False");

  }

  /**
   * This test is to make sure that the toString method only outputs the fields of the entry
   * constructor used.
   */
  @Test // test 13
  void testToString() {
    entry = new Entry(Symbol.MINUS);
    assertEquals(entry.toString(), "Entry [other=-, type=SYMBOL]",
        "Checking that the toString method is custom to the entry type");

    entry = new Entry();
    assertEquals(entry.toString(), "Entry [type=INVALID]",
        "Checking that the toString method is custom to the entry type");

    entry = new Entry(5.0f);
    assertEquals(entry.toString(), "Entry [number=5.0, type=NUMBER]",
        "Checking that the toString method is custom to the entry type");

    //    entry = new Entry("Hello World");
    //    assertEquals(entry.toString(), "Entry [str=Hello World, type=STRING]",
    //        "Checking that the toString method is custom to the entry type");
  }



}
