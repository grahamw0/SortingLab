
package avlTree;

import java.util.Random;

import arrayList.ListArray;

/**
 * Driver for testing the TreeSort algorithm.
 * 
 * @author Ryan Godfrey, Will Graham
 *
 */
public class Driver {
  public static void main(String[] args) {
    Random rand = new Random();
    ListArray list = new ListArray();
    for (int i = 0; i < 500000; i++) {
      list.add(rand.nextInt());
    }

    list = AvlTree.treeSort(list);
  }

}
