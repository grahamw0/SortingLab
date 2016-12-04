
package heap;

import java.util.Random;

import arrayList.ListArray;

/**
 * Driver for package Heap in the SortingLab.
 * It is responsible for housing the main that will
 * call on the "heapSort" method. 
 * 
 * @author Ryan Godfrey, Will Graham
 *
 */
public class Driver {

  /**
   * Create random Integers that are to be inserted
   * into a heap.  Calling on the method "heapSort"
   * will create a new heap, insert the integers into the heap
   * and sift them properly.  When finished print the sifted heap.
   * @param args
   */
  public static void main(String[] args) { // Create random integers and add them to the array.
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
