package edu.rice.cs.plt.iter;

import junit.framework.TestCase;

import java.io.*;
import java.util.*;
import static edu.rice.cs.plt.iter.IterUtil.*;

/**
 * Tests for the IterUtil methods
 */
public class IterUtilTest extends TestCase {

  private void assertEquals(int expected, Integer actual) {
    assertEquals(expected, actual.intValue());
  }
  
  private void assertEquals(char expected, Character actual) {
    assertEquals(expected, actual.charValue());
  }
  

  public void testArrayIterable() {
    assertTrue(isEmpty(arrayIterable(new String[0])));
    assertTrue(isEmpty(arrayIterable(new boolean[0])));
    assertTrue(isEmpty(arrayIterable(new char[0])));
    assertTrue(isEmpty(arrayIterable(new byte[0])));
    assertTrue(isEmpty(arrayIterable(new short[0])));
    assertTrue(isEmpty(arrayIterable(new int[0])));
    assertTrue(isEmpty(arrayIterable(new long[0])));
    assertTrue(isEmpty(arrayIterable(new float[0])));
    assertTrue(isEmpty(arrayIterable(new double[0])));
    
    assertTrue(isEmpty(arrayIterable((Object) new String[0])));
    assertTrue(isEmpty(arrayIterable((Object) new boolean[0])));
    assertTrue(isEmpty(arrayIterable((Object) new char[0])));
    assertTrue(isEmpty(arrayIterable((Object) new byte[0])));
    assertTrue(isEmpty(arrayIterable((Object) new short[0])));
    assertTrue(isEmpty(arrayIterable((Object) new int[0])));
    assertTrue(isEmpty(arrayIterable((Object) new long[0])));
    assertTrue(isEmpty(arrayIterable((Object) new float[0])));
    assertTrue(isEmpty(arrayIterable((Object) new double[0])));
    try {
      arrayIterable(new Object());
      fail("Expected an IllegalArgumentException");
    }
    catch (IllegalArgumentException e) {}
    
    int[] ints = { 1, 1, 2, 3, 5 };
    Iterator<Integer> intIter = arrayIterable(ints).iterator();
    assertTrue(intIter.hasNext());
    assertEquals(1, intIter.next());
    assertTrue(intIter.hasNext());
    assertEquals(1, intIter.next());
    assertTrue(intIter.hasNext());
    assertEquals(2, intIter.next());
    assertTrue(intIter.hasNext());
    assertEquals(3, intIter.next());
    assertTrue(intIter.hasNext());
    assertEquals(5, intIter.next());
    assertFalse(intIter.hasNext());
  }
  
  public void testCharSequenceIterable() {
    assertTrue(isEmpty(charSequenceIterable("")));

    Iterator<Character> iter = charSequenceIterable("Happy day").iterator();
    assertTrue(iter.hasNext());
    assertEquals('H', iter.next());
    assertTrue(iter.hasNext());
    assertEquals('a', iter.next());
    assertTrue(iter.hasNext());
    assertEquals('p', iter.next());
    assertTrue(iter.hasNext());
    assertEquals('p', iter.next());
    assertTrue(iter.hasNext());
    assertEquals('y', iter.next());
    assertTrue(iter.hasNext());
    assertEquals(' ', iter.next());
    assertTrue(iter.hasNext());
    assertEquals('d', iter.next());
    assertTrue(iter.hasNext());
    assertEquals('a', iter.next());
    assertTrue(iter.hasNext());
    assertEquals('y', iter.next());
    assertFalse(iter.hasNext());
  }
  
  public void testReaderIterable() {
    assertTrue(isEmpty(readerIterable(new StringReader(""))));
    
    Iterator<Character> iter = readerIterable(new StringReader("Foo")).iterator();
    assertTrue(iter.hasNext());
    assertEquals('F', iter.next());
    assertTrue(iter.hasNext());
    assertEquals('o', iter.next());
    assertTrue(iter.hasNext());
    assertEquals('o', iter.next());
    assertFalse(iter.hasNext());
  }
  
  public void testInputStreamIterable() {
    assertTrue(isEmpty(inputStreamIterable(new ByteArrayInputStream(new byte[0]))));
    
    byte[] bytes = { 1, 15, 3 };
    Iterator<Byte> iter = inputStreamIterable(new ByteArrayInputStream(bytes)).iterator();
    assertTrue(iter.hasNext());
    assertEquals(1, (byte) iter.next());
    assertTrue(iter.hasNext());
    assertEquals(15, (byte) iter.next());
    assertTrue(iter.hasNext());
    assertEquals(3, (byte) iter.next());
    assertFalse(iter.hasNext());
  }
  
}