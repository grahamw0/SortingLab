
package avlTree;

import java.util.Random;

import arrayList.ListArray;

/**
 * Driver for package avlTree in the SortingLab.
 * It is responsible for housing the main that will
 * call on the "treeSort" method.  
 * @author Ryan Godfrey, Will Graham
 *
 */
public class Driver {

  /**
   * Create random Integers that are to be inserted
   * into a tree.  Calling on the method "treeSort"
   * will create a new tree, insert the integers into the tree
   * and sort them.  When finished print the sorted tree.  
   * @param args
   */
  public static void main(String[] args) { // Create random integers and add them to the ListArray.
    Random rand = new Random(666);
    ListArray list = new ListArray();
    for(int i = 0; i < 50; i++) {
      list.add(rand.nextInt());
    }
    list.add(0);
    list.add(0);
    list = AvlTree.treeSort(list);
    
    for(Comparable c : list.toArray()) {
      System.out.println(c + " ");
    }

  }

}
