/**
 * 
 */
package avlTree;

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
    ListArray list = new ListArray();
    for(int i = 0; i < 50000; i++) {
      list.add(rand.nextInt());
    }
    list.add(0);
    list.add(0);
    list = AvlTree.treeSort(list);
    
    for(Comparable c : list.toArray()) {
      System.out.print(c + " ");
    }

  }

}
