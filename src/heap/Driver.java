/**
 * 
 */
package heap;

import java.util.Random;

import arrayList.ListArray;

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
    ListArray array = new ListArray();
    for(int i = 0; i < 50; i++) {
      array.add(rand.nextInt(101));
    }
    array = Heap.heapSort(array);
    for(Comparable c : array.toArray()) {
      System.out.print(c + " ");
    }
    

  }

}
