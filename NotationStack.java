/**
* This is the NotationQueue class
*
*
* @author Fatima Mancia
*
*/
import java.util.ArrayList;
import java.io.*;
import java.util.*;
public class NotationStack<T> {
  ArrayList<T> array;
  int top = -1;
  int size;
  NotationStack(int size) {
    this.size = size;
    this.array = new ArrayList<T>(size);
  }
  /**
	 * isEmpty evaluates if the stack is empty.
   * 
	 * @return true if it is empty. If not return false.
	 *
	 */
  public boolean isEmpty() {
    if (top == -1) {
      return true;
    }
    else {
      return false;
    }
  }
  /**
	 * isFull evaluates if the stack is full.
   * 
	 * @return true if it is full. If not return false.
	 *
	 */
  public boolean isFull() {
    if ((top + 1) == size) {
      return true;
    }
    else {
      return false;
    }
  }
  /**
	 * pop deletes and returns the element at the top of the Stack
	 * @return the element at the top of the Stack
	 */
  public T pop() throws StackUnderflowException {
    if (top == -1) {
      throw new StackUnderflowException("The stack is Underflow");
    }
    return array.get(top--);
  }
  /**
	 * top returns the element at the top of the Stack, does not pop it off the Stack
	 * @return the element at the top of the Stack
	 */
  public T top() throws StackUnderflowException {
    if (top == -1) {
      throw new StackUnderflowException("The stack is Underflow");
    }
    else {
      return array.get(top);
    }
  }
  /**
	 * size number of elements in the Stack
	 * @return the number of elements in the Stack
	 */
  public int size() {
    return top + 1;
  }
  /**
	 * push adds an element to the top of the Stack
	 * @param e the element to add to the top of the Stack
	 * @return true if the add was successful, false if not
	 */
  public boolean push(T e) throws StackOverflowException {
    if (top + 1 == size) {
      throw new StackOverflowException("The stack is Overflow");
    }
    else {
      top++;
      if (array.size() > top) {
        array.set(top, e);
      }
      else {
        array.add(e);
      }
      return true;
    }
  }
  /**
	 * toString returns the elements of the Stack in a string from bottom to top, the beginning 
	 * of the String is the bottom of the stack
	 * @return an string which represent the Objects in the Stack from bottom to top
	 */
  public String toString() {
      String ans = "";
      for (int i = 0; i < top; i++) {
        ans += String.valueOf(array.get(i) + "");
      }
      ans += String.valueOf(array.get(top));
      return ans;
  }
  /**
	 * toString returns the string representation of the elements in the Stack, the beginning of the 
	 * string is the bottom of the stack
	 * Place the delimiter between all elements of the Stack
   * @param delimiter a String variable
	 * @return string representation of the Stack from bottom to top with elements 
	 * separated with the delimiter
	 */
  public String toString(String delimiter) {
    String ret = "";
    for (int i = 0; i < size(); i++){
      ret += array.get(i);
      if (i < (size() - 1)) {
        ret += delimiter;
      }
      System.out.println(ret);
    }
     
     return ret;
  }
  /**
	  * Fills the Stack with the elements of the ArrayList, First element in the ArrayList
	  * is the first bottom element of the Stack
	  * 
	  * @param list elements to be added to the Stack from bottom to top
	  */
  public void fill(ArrayList<T> list) {
    for (T e: list){
      try {
        push(e);
      }
      catch(Exception error) {

      }
    }
  }
}