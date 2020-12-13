package lab8_project;

import java.util.Collection;
//import java.util.concurrent.ConcurrentLinkedQueue;

public interface IWaitList<E> {

  public void add(E element);


  public E remove() ;


  public boolean contains(E element) ;


  public boolean containsAll(Collection<E> coln) ;


  public boolean isEmpty() ;
  

}
