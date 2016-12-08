
package heap;

import java.util.Random;

import arrayList.ListArray;

/**
 * Driver for testing the Heap Sort algorithm.
 * 
 * @author Ryan Godfrey, Will Graham
 *
 */
public class Driver {
  public static void main(String[] args) {
    Random rand = new Random();
    ListArray array = new ListArray();
    for (int i = 0; i < 500000; i++) {
      array.add(rand.nextInt(Integer.MAX_VALUE));
    }

    long start = System.currentTimeMillis();
    array = Heap.heapSort(array);
    long end = System.currentTimeMillis();
    System.out.println("Heap sort took: " + ((end - start) * .001));


  }

}
