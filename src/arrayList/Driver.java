
package arrayList;

import java.util.Random;

/**
 * Driver page for testing all of the array-based sorting algorithms.
 * 
 * @author Will Graham, Ryan Godfrey
 *
 */
public class Driver {
  public static void main(String[] args) {
    Random rand = new Random();
    long startTime;
    long endTime;
    ListArray list = new ListArray();
    for (int i = 0; i < 500000; i++) {
      list.add(rand.nextInt(Integer.MAX_VALUE));
    }

    startTime = System.currentTimeMillis();
    list.insertionSort();
    endTime = System.currentTimeMillis();
    System.out.println("Insertion took: " + ((endTime - startTime) * .001));

    list = new ListArray();
    for (int i = 0; i < 5000000; i++) {
      list.add(rand.nextInt(Integer.MAX_VALUE));
    }
    startTime = System.currentTimeMillis();
    list.bubbleSort();
    endTime = System.currentTimeMillis();
    System.out.println("Bubble took: " + ((endTime - startTime) * .001));

    list = new ListArray();
    for (int i = 0; i < 5000000; i++) {
      list.add(rand.nextInt(Integer.MAX_VALUE));
    }
    startTime = System.currentTimeMillis();
    list.quickSortRecursive();
    endTime = System.currentTimeMillis();
    System.out.println("QS Recurs. took: " + ((endTime - startTime) * .001));

    list = new ListArray();
    for (int i = 0; i < 5000000; i++) {
      list.add(rand.nextInt(Integer.MAX_VALUE));
    }
    startTime = System.currentTimeMillis();
    list.quickSortIterative();
    endTime = System.currentTimeMillis();
    System.out.println("QS Iter. took: " + ((endTime - startTime) * .001));

    list = new ListArray();
    for (int i = 0; i < 5000000; i++) {
      list.add(rand.nextInt(Integer.MAX_VALUE));
    }
    startTime = System.currentTimeMillis();
    list.mergeSort();
    endTime = System.currentTimeMillis();
    System.out.println("Merge took: " + ((endTime - startTime) * .001));

    list = new ListArray();
    for (int i = 0; i < 5000000; i++) {
      list.add(rand.nextInt(Integer.MAX_VALUE));
    }
    startTime = System.currentTimeMillis();
    list.bucketSort();
    endTime = System.currentTimeMillis();
    System.out.println("Bucket took: " + ((endTime - startTime) * .001));

    list = new ListArray();
    for (int i = 0; i < 5000000; i++) {
      list.add(rand.nextInt(Integer.MAX_VALUE));
    }
    startTime = System.currentTimeMillis();
    list.radixSort();
    endTime = System.currentTimeMillis();
    System.out.println("Radix took: " + ((endTime - startTime) * .001));


    /*
     * for(Comparable c : list.toArray()) { System.out.println(c + " "); }
     */
    System.out.println("");
    System.out.println("Ryan is the man!!!!");

  }

}
