/**
 * 
 */
package arrayList;

import java.util.Random;

/**
 * @author grahamw0
 *
 */
public class Driver {

  /**
   * @param args
   */
  public static void main(String[] args) {
    Random rand = new Random(666);
    ListArray list = new ListArray();
    for(int i = 0; i < 20; i++) {
      list.add(rand.nextInt());
    }
    //list.add(0);
    //list.add(0);
    //list.insertionSort();
    //list.partitionArrayExample(50);
    list.quickSortIterative();
    
    
    for(Comparable c : list.toArray()) {
      System.out.println(c + " ");
    }
    System.out.println("");
    System.out.println("Ryan is the man!!!!");

  }

}
