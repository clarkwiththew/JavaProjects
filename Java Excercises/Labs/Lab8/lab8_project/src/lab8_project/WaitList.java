package lab8_project;

import java.util.Collection;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * A representation on a waiting list. Works in a first-come first-serve basis.
 * @author anya
 */
public class WaitList<int> implements IWaitList<E> {

  protected Queue<E> content; // this is where we keep the contents
  
  /**
   * Creates a new empty WaitList.
   */
  public WaitList() {
    this.content = new ConcurrentLinkedQueue<>();
  }

  /**
   * Creates a new WaitList containing elements from the given Collection.
   * @param c elements from this Collection are added to the new WaitList
   */
  public WaitList(Collection<int> coln) {
    this.content = new ConcurrentLinkedQueue<>(coln);
  }   

  /**
   * Adds the specified element to this WaitList.
   * @param element the new element to be added to this WaitList
   */
  public void add(int el) {
    this.content.add(el);  
  }

  /**
   * Removes and returns the next element from this WaitList. The elements are
   * removed in first-in-first-out order. Returns null if this WaitList is empty.
   * @return the next element in this WaitList, or null if this WaitList is empty
   */
  public E remove() { // similar: return type is E
    return this.content.poll();
  }

  /**
   * Returns true if this WaitList contains element and false, otherwise.
   * @param element the element to test for membership in this WaitList
   * @return true if this WaitList contains element and false, otherwise
   */
  public boolean contains(E element) {
    return this.content.contains(element);
  }

  /**
   * Returns true if this WaitList contains all elements in the given
   * collection and false otherwise.
   * @param coln the Collection of elements to test for membership in this
   *     WaitList
   * @return true if this WaitList contains all elements in the given
   *     collection and false otherwise
   */
  public boolean containsAll(Collection<E> coln) {
    return this.content.containsAll(coln);
  }

  /**
   * Returns true if this WaitList has no elements, and false, otherwise.
   * @return true if this WaitList has no elements, and false, otherwise
   */
  public boolean isEmpty() {
    return this.content.isEmpty();
  }
  
  @Override
  public String toString() {
    return "WaitList:" + this.content;
  }

}