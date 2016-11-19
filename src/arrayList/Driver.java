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
    Random rand = new Random();
    ListArray list = new ListArray();
    for(int i = 0; i < 20; i++) {
      list.add(rand.nextInt(100));
    }
    list.bubbleSort();
    
    for(Comparable c : list.toArray()) {
      System.out.print(c + " ");
    }

  }

}
