package lab8_project;


public class BoundedWaitList<E> extends WaitList<E> {
  private int capacity;

  public BoundedWaitList(int capacity) {
    super();
    this.capacity = capacity;
  }

  public int getCapacity() {
    return capacity;
  }

  public void add(E element) {
    if (this.content.size() < capacity) {
      this.content.add(element);
    } else {
      System.out.println("Element cannot be added");
    }
  }

  @Override
  public String toString() {
    return "Bounded Waitlist: " + this.content;
  }
}
