package arrayList;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Class ListArray<T> will create an array-based list and is one of the 3 generic list classes that
 * implement MyList. This class is responsible for creating the array-based list that class
 * ArrayPlaylist will utilize.
 * 
 * @author Will Graham, Ryan Godfrey
 * @version 10/2/2016
 *
 */
public class ListArray {

  private int size; // The current size
  private Comparable[] array; // The array

  /**
   * Constructor for class ListArray. When creating an instance of this class it will set the size
   * to 0, initialize the class object. It will also initialize a new array with a starting size of
   * 10.
   * 
   * @param c
   */
  @SuppressWarnings("unchecked")
  public ListArray() {
    this.size = 0;
    array = (Comparable[]) Array.newInstance(Comparable.class, 10);
  }

  /**
   * The add method inserts an element into a specified position in the list. It throws an exception
   * if the position value is less than 1 or greater than list size.
   * 
   * @param index
   * @param object.
   * @return boolean
   */
  public boolean add(int index, Comparable o) {
    checkBound(index);
    ensureArraySpace();
    this.array[size] = o;
    size++;
    swap(index, size - 1);
    return true;
  }

  /**
   * The overloaded add() method is different by taking in only a list object as a parameter. It
   * appends an element to the end of the list.
   * 
   * @param object
   * @return boolean
   */

  public boolean add(Comparable o) {
    // Check to see if there is space in the array. If not create a copy and double the size.
    ensureArraySpace();
    this.array[size] = o;
    size++;
    return true;
  }

  /**
   * The clear() method will remove all of the elements from the list.
   * 
   * @return boolean
   */
  @SuppressWarnings("unchecked")

  public boolean clear() {
    // Create a new instance of an array and set it to the current array. This will clear the
    // current.
    this.array = (Comparable[]) Array.newInstance(Comparable.class, 10);
    this.size = 0; // Reset size to 0
    return true;
  }

  /**
   * The contains() method will return true if the list contains the specified element.
   * 
   * @param object
   * @return boolean
   */

  public boolean contains(Comparable o) {
    if (array[0] == null) { // return false if the list is empty.
      return false;
    }

    for (int i = 0; i < size - 1; i++) {
      if (array[i] == o) { // Return true if the element matches an element in the list.
        return true;
      }
    }
    return false;
  }

  /**
   * The get() method takes in an index and returns the element located in the specified position of
   * this list. This method also throws an exception if the position value is less than 1 or greater
   * than the list size.
   * 
   * @param index The index in question
   * @return T Retrieve the element at the index
   */

  public Comparable get(int index) {
    checkBound(index);
    return (Comparable) array[index]; // If there is no exception return the element at the
                                      // specified index.

  }

  /**
   * The indexOf() method will return an index in the list of the first occurrence of the specified
   * element, or -1 if this list does not contain the element.
   * 
   * @param object
   * @return The index or -1 if it does not exist
   */

  public int indexOf(Comparable o) {
    for (int i = 0; i < size; i++) {
      if (array[i] == o) { // If the element is in the list then return the index.
        return i;
      }
    }
    return -1; // return -1 if no such element
  }

  /**
   * The isEmpty() method will return true if the list contains no elements.
   * 
   * @return boolean True if list is empty
   */

  public boolean isEmpty() {
    return (size == 0); // If size is equal to 0 then return true.
  }

  /**
   * The remove() method will remove the element at the specified position in this list. It also
   * throws and exception if the position value is less than 1 or greater than the list size.
   * 
   * @param index
   * @return the deleted data
   */

  public Comparable remove(int index) {
    checkBound(index);
    Comparable returnObject = array[index]; // Get the element at the index and set it to a
                                            // variable.
    for (int i = index; i < size - 1; i++) { // Starting at the index position
      array[i] = array[i + 1]; // Shift all elements after the index left.
    }
    array[size - 1] = null; // Clear the last element.
    size--;
    return returnObject; // return the deleted data.
  }

  /**
   * The overloaded remove() method is different in that it takes in an object as a parameter
   * instead of an index. It removes the first occurrence of the specified element from the list.
   * 
   * @param object
   * @return The deleted data
   */
  @SuppressWarnings("unchecked")

  public Comparable remove(Object o) {
    int index = indexOf((Comparable) o); // Get the element and its index.
    remove(index); // Remove that index
    return (Comparable) o; // Return the deleted data.
  }

  /**
   * The set method() will replace the element in specified position in the list with the provided
   * element. It also throws an exception if the position value is less than 1 or greater than the
   * list size.
   * 
   * @param index
   * @param Object element
   * @return boolean
   */
  @SuppressWarnings("unchecked")

  public boolean set(int index, Object element) {
    checkBound(index);
    array[index] = (Comparable) element; // Set the element at the specified index.
    return true;
  }

  /**
   * The size() method will return the number of elements in the list
   * 
   * @return the size of the list
   */

  public int size() {
    return size;
  }

  /**
   * The subList() method will return a new list that contains the portion of the original list
   * between the specified fromIndex, inclusive, and toIndex, exclusive. It also throws an exception
   * if the either the index values is less than 1 or greater than the list size.
   * 
   * @param fromindex
   * @param toindex
   * @return the new list
   */
  @SuppressWarnings({"unchecked", "rawtypes"})

  public ListArray subList(int fromIndex, int toIndex) {
    checkBound(fromIndex);
    checkBound(toIndex);

    ListArray newList = new ListArray(); // Create a new array to copy to.
    newList.setArray(Arrays.copyOfRange(array, fromIndex, toIndex)); // Grab the elements within the
                                                                     // range.
    newList.size = toIndex - fromIndex; // Update the list size.
    return newList; // Return the new sub list
  }

  /**
   * The toArray() method will return an array containing all of the elements in the list in proper
   * sequence.
   * 
   * @return the array
   */
  @SuppressWarnings("unchecked")

  public Comparable[] toArray() {
    Comparable[] newArray = (Comparable[]) Array.newInstance(Comparable.class, size); // Create a
                                                                                      // new array
                                                                                      // to copy to.
    for (int i = 0; i < size; i++) {
      newArray[i] = array[i]; // Shift the elements from the array to the new one.
    }
    return newArray; // Return the new array.
  }

  /**
   * The swap() method will swap elements of the List located in the positions 1 and 2. It also
   * throws an exception if either position values is less than 1 or greater than the list size.
   * 
   * @param position1
   * @param position2
   * @return boolean
   */

  public boolean swap(int position1, int position2) {
    checkBound(position1);
    checkBound(position2);
    Comparable temp = array[position1]; // Load position1 data into a temporary
    array[position1] = array[position2]; // Load position2 data into postition1
    array[position2] = temp; // Load the temp into position2

    return true;
  }

  /**
   * The shift() method will shift all elements in the List by a specified number of location. If
   * the value of positions is positive then the elements are shifted from left to right. If the
   * value of positions is negative then the elements are shifted from right to left.
   * 
   * @param positions
   * @return boolean
   */
  @SuppressWarnings("unchecked")

  public boolean shift(int positions) {
    positions *= -1; // Fixes the opposite result
    Comparable[] newArray = (Comparable[]) new Object[size];
    if (positions > 0) { // If positions is positive
      int j = 0;
      for (int i = positions; i < size; i++) { // Start iterating at positions
        newArray[j] = array[i]; // Move what is in i to j
        j++;
      }
      for (int i = 0; i < positions; i++) { // Start iterating again for what is remaining
        newArray[j] = array[i]; // Move what is left from i to j
        j++;
      }
    } else if (positions < 0) { // If positions is negative
      int j = 0;
      for (int i = size + positions; i < size; i++) { // Start iterating at the proper position
        newArray[j] = array[i]; // Move what is in i to j
        j++;
      }
      for (int i = 0; i < size + positions; i++) { // Start iterating again for what is remaining
        newArray[j] = array[i]; // Move what is remaining from i to j
        j++;
      }
    } else {
      return false;
    }
    this.array = newArray;
    return true;
  }


  /**
   * The setArray() method will take in an array object and set it to the current array.
   * 
   * @param array
   */
  public void setArray(Comparable[] array) {
    this.array = array;
    int newSize = 0;
    for (Comparable c : array) {
      newSize++;
    }
    this.size = newSize;
  }

  /**
   * The ensureArraySpace() method will check to see if the current space in the array is sufficient
   * for the upcoming actions. If it is not then it creates more space by copying to a new array and
   * doubling the size. v
   */
  private void ensureArraySpace() {
    if ((size + 1) > array.length) // If the size of the list is 1 bigger than the array itself
      this.array = Arrays.copyOf(array, (array.length * 2)); // Create a copy and double the size of
                                                             // the old array.
  }

  /**
   * The checkBound will take in an index and check to see if the index is valid. If it is not valid
   * then it will throw an outOfBoundsException
   * 
   * @param index
   */

  private void checkBound(int index) {
    if (index < 0 || index > size - 1) {
      throw new IndexOutOfBoundsException("Index is invalid");
    }
  }

  public void bubbleSort() {
    if (size == 0) {
      return;
    }
    boolean swap = true;
    while (swap) {
      swap = false;
      for (int i = 0; i < size - 1; i++) {
        if (array[i].compareTo(array[i + 1]) > 0) {
          Comparable temp = array[i];
          array[i] = array[i + 1];
          array[i + 1] = temp;
          swap = true;
        }
      }
    }
  }

  // Not needed.
  public void selectionSort() {
    if (size == 0) {
      return;
    }
    for (int i = 0; i < size; i++) {
      int min = i;
      for (int j = i; j < size; j++) {
        if (array[min].compareTo(array[j]) > 0) {
          min = j;
        }
      }
      swap(i, min);
    }
  }

  public void insertionSort() {
    if (size == 0) {
      return;
    }
    for (int i = 1; i < size; i++) {
      int j = i;
      Comparable c = array[i];
      while ((j > 0) && array[j - 1].compareTo(c) > 0) {
        array[j] = array[j - 1];
        j--;
      }
      array[j] = c;
    }
  }

  public void quickSortRecursive() {
    if (size == 0) {
      return;
    }
    quickSortRecurs(0, size - 1);
  }


  private void quickSortRecurs(int lower, int higher) {
    if (higher <= lower || lower >= higher)
      return;

    Comparable pivot = array[lower];
    int i = lower + 1;

    for (int j = lower + 1; j <= higher; j++) {
      if (pivot.compareTo(array[j]) > 0) {
        swap(j, i);
        i++;
      }
    }
    array[lower] = array[i - 1];
    array[i - 1] = pivot;

    quickSortRecurs(lower, i - 2);
    quickSortRecurs(i, higher);

  }

  public void quickSortIterative() {
    if (size == 0) {
      return;
    }
    Stack<Integer> stack = new Stack<>();
    stack.push(0);
    stack.push(size);
    while (!stack.isEmpty()) {
      int end = stack.pop();
      int start = stack.pop();
      if (end - start < 2)
        continue;
      int p = start + ((end - start) / 2);
      p = partition(p, start, end);

      stack.push(p + 1);
      stack.push(end);

      stack.push(start);
      stack.push(p);
    }
  }

  private int partition(int pivot, int start, int end) {
    int l = start;
    int h = end - 2;
    Comparable pivObj = array[pivot];
    swap(pivot, end - 1);

    while (l < h) {
      if (array[l].compareTo(pivObj) < 0)
        l++;
      else if (array[h].compareTo(pivObj) >= 0)
        h--;
      else
        swap(l, h);
    }

    int index = h;
    if (array[h].compareTo(pivObj) < 0)
      index++;

    swap(end - 1, index);
    return index;
  }

  public void mergeSort() {
    if (size == 0) {
      return;
    }
    Comparable[] tempArray = new Comparable[size];
    mergeSortRecurs(0, size - 1, tempArray);
  }

  private void mergeSortRecurs(int lower, int higher, Comparable[] tempArray) {
    if (lower < higher) { // Only runs recursively when indices != or out of order
      int middle = lower + (higher - lower) / 2;
      mergeSortRecurs(lower, middle, tempArray);
      mergeSortRecurs(middle + 1, higher, tempArray);
      mergeParts(lower, middle, higher, tempArray);
    }
  }

  private void mergeParts(int lower, int middle, int higher, Comparable[] tempArray) {
    for (int i = lower; i <= higher; i++) {
      tempArray[i] = array[i];
    }
    int i = lower;
    int j = middle + 1;
    int k = lower;

    while (i <= middle && j <= higher) {
      if (tempArray[i].compareTo(tempArray[j]) <= 0) {
        array[k] = tempArray[i];
        i++;
      } else {
        array[k] = tempArray[j];
        j++;
      }
      k++;
    }
    while (i <= middle) {
      array[k] = tempArray[i];
      k++;
      i++;
    }
  }

  public void radixSort() {
    if (size == 0) {
      return;
    }
    boolean cont = true;
    long divisor = 1L;
    Queue[] buckets = new LinkedList[10];
    for (int i = 0; i < 10; i++) {
      buckets[i] = new LinkedList();
    }

    while (cont) {
      cont = false;
      for (int i = 0; i < size; i++) {
        long hashIndex = ((int) array[i] / divisor) % 10;
        if (hashIndex > 0) {
          cont = true;
        }
        buckets[(int) hashIndex].add(new Integer((Integer) array[i]));
      }
      divisor *= 10;
      int i = 0;
      for (int j = 0; j < 10; j++) {
        while (!buckets[j].isEmpty()) {
          Integer ival = (Integer) buckets[j].poll();
          array[i++] = ival.intValue();
        }
      }
    }

  }

  public void bucketSort(int bucketSize) {
    if (size == 0) { // TODO: Implement this in all other sorts
      return;
    }

    Integer max = (Integer) array[0];
    Integer min = (Integer) array[0];
    for (int i = 1; i < size; i++) {
      if ((Integer) array[i] < min) {
        min = (Integer) array[i];
      } else if ((Integer) array[i] > max) {
        max = (Integer) array[i];
      }
    }

    int bucketNum = (max - min) / bucketSize + 1;
    List<List<Integer>> buckets = new ArrayList<List<Integer>>(bucketNum);
    for (int i = 0; i < bucketNum; i++) {
      buckets.add(new ArrayList<Integer>());
    }

    for (int i = 0; i < size; i++) {
      buckets.get(((Integer) array[i] - min) / bucketSize).add((Integer) array[i]);
    }

    int index = 0;
    for (int i = 0; i < buckets.size(); i++) {
      // Integer[] bucketArray = new Integer[buckets.get(i).size()];
      ListArray bucketArray = new ListArray();
      // bucketArray = buckets.get(i).toArray(bucketArray);
      bucketArray.setArray(buckets.get(i).toArray(new Comparable[0]));
      // SORT BUCKETARRAY
      bucketArray.quickSortIterative();
      for (int j = 0; j < bucketArray.size; j++) {
        array[index++] = bucketArray.get(j);
      }
    }

  }

}
