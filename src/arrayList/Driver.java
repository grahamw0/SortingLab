
package arrayList;

import java.util.Random;

/**
 * Driver page for all of the array-based sorting algorithms.
 * 
 * @author Will Graham, Ryan Godfrey
 *
 */
public class Driver {

  /**
   * @param args
   */
  public static void main(String[] args) {
    Random rand = new Random(666);
    ListArray list = new ListArray();
    for(int i = 0; i < 5000000; i++) {
      list.add(rand.nextInt(Integer.MAX_VALUE));
    }
    /*list.add(8);
    list.add(2);
    list.add(5);
    list.add(0);
    list.add(1);
    list.add(7);
    list.add(4);
    list.add(10);
    list.add(6);
    list.add(3);
    list.add(9);*/
    //list.add(0);
    //list.add(0);
    //list.insertionSort();
    //list.partitionArrayExample(50);
    //list.quickSortRecursive();
    list.bucketSort(10000);
    //list.mergeSort();
    //list.radixSort();
    
    
    for(Comparable c : list.toArray()) {
      System.out.println(c + " ");
    }
    System.out.println("");
    System.out.println("Ryan is the man!!!!");

  }

}
