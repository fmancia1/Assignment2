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
public class NotationQueue<T> {
  int front = -1;
  int rear = -1;
  int capacity;
  // ArrayList<T> array;
  Object[] array;
  NotationQueue(int size) {
    capacity = size;
    array = new Object[capacity];
  }
  /**
	 * isEmpty evaluates if the queue is empty.
   * 
	 * @return true if it is empty. If not return false.
	 *
	 */
  public boolean isEmpty() {
    if (front == -1 && rear == -1) {
      return true;
    }
    else {
      return false;
    }
  }
  /**
	 * isFull evaluates if the queue is full.
   * 
	 * @return true if it is full. If not return false.
	 *
	 */
  public boolean isFull() {
    if (size() == capacity) {
      return true;
    }
    else {
      return false;
    }
  }
  /**
	 * dequeue deletes and returns the element at the front of the *queue 
   *
	 * @return the element at the front of the Queue
	 *
	 */
  public T dequeue() throws QueueUnderflowException {
    if(this.isEmpty()) {
      throw new QueueUnderflowException("The queue is already empty");
    }
    int pos;
    if (front == rear){
      pos = front;
      front = rear = -1;
    }
    else {
      pos = front++;
    }
    return (T) array[pos];
  }
  /**
	 * size number of elements in the Queue
	 * @return the number of elements in the Queue
	 */
  public int size() {
    if (rear > front)
      return rear - front + 1;
    else
      return capacity + rear - front + 1;
  }
  /**
	 * enqueue adds an element to the end of the Queue
	 * @param e the element to add to the end of the Queue
	 * @return true if the add was successful, false if not
	 */
  public boolean enqueue(T e) throws QueueOverflowException {
    if (isFull())
      throw new QueueOverflowException("Enqueue error: Queue is full");
    if(this.isEmpty()) {
      front = 0;
      rear = 0;
    }
    else {
      rear = ++rear % capacity;
    }
    array[rear] = (Object) e;
    return true;
  }
  /**
	 * toString returns the string representation of the elements in the Queue, 
	 * the beginning of the string is the front of the queue
	 * @return string representation of the Queue with elements
	 */
  public String toString() {
    if (this.isEmpty()) {
      return  "";
    }
    String ans = "";
    int i = front;
    while (true) {
      ans += array[i];
      i = i + 1 % capacity;
      if (i == rear) {
        ans += array[rear];
        break;
     }
    }
    return ans;
  }
  	/**
	 * toString returns the string representation of the elements in the Queue, the beginning of the string is the front of the queue
	 * Place the delimiter between all elements of the Queue
   * @param delimiter a String variable
	 * @return string representation of the Queue with elements separated with the delimiter
	 */
  public String toString(String delimiter) {
    String ret = "";
    int i = front;
    while (true) {
      ret += array[i];
      if (i != rear) {
        ret += delimiter;
      }
      i = i + 1 % capacity;
      if (i == rear) {
        ret += array[rear];
        break;
      }
     }
     return ret;
  }
  /**
	  * Fills the Queue with the elements of the ArrayList, First element in the ArrayList
	  * is the first element in the Queue
	  *
	  * @param list elements to be added to the Queue
	  */
  public void fill(ArrayList<T> list) {
    for (T e: list){
      try {
        enqueue(e);
      }
      catch(Exception error) {

      }
    }
  }
}