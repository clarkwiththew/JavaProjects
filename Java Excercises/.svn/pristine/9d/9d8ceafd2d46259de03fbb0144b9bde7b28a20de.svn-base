package lab8_project;

public class Lab8 {

    public static void main(String[] args) {
      WaitList<Integer> wl1 = new WaitList<>();
      BoundedWaitList<Integer> wl2 = new BoundedWaitList<>(5);
      UnfairWaitList<Integer> wl3 = new UnfairWaitList<>();
      System.out.println(wl1); // []
      System.out.println(wl2); // []. Capacity 5
      System.out.println(wl3); // []
      
      for (int i = 0; i < 7; i++) {
        wl1.add(i);
        wl2.add(i);
        wl3.add(i);
      }
      System.out.println(wl1); // [0, 1, 2, 3, 4, 5, 6]
      System.out.println(wl2); // [0, 1, 2, 3, 4]. Capacity 5
      System.out.println(wl3); // [0, 1, 2, 3, 4, 5, 6]
      
      wl3.moveToBack(3);
      System.out.println(wl3); // [0, 1, 2, 4, 5, 6, 3]
      
      emptyWaitList(wl1); // []
      emptyWaitList(wl2); // []. Capacity 5
      emptyWaitList(wl3); // []

      System.out.println(wl1);
      System.out.println(wl2);
      System.out.println(wl3);
  }
    
    /* A generic method!
     * Empties the given IWaitList.
     */
    public static <E> void emptyWaitList(IWaitList<E> wl) {
      while (! wl.isEmpty()) {
        wl.remove();
      }
    }
  }
