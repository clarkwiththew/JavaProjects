package lab8_project;


public class UnfairWaitList<E> extends WaitList<E>{
public UnfairWaitList() {
  // TODO Auto-generated constructor stub
}
public void remove(E element) {  
  this.content.poll();
}
public void moveToBack(E element) {
  this.content.add(element);
}
}
