package heap;

/**
 * Supplied Node for the Heap implementation
 * 
 * @author Ryan Godfrey, William Graham
 */
public class Node {
  private Node left_child;
  private Node right_child;
  private Node parent;
  private Comparable data;

  /**
   * Constructor
   */
  public Node() {
    left_child = null;
    right_child = null;
    data = null;
    parent = null;
  }

  /**
   * Constructor 
   * @param data The data for the first node to hold
   */
  public Node(Comparable data) {
    this.data = data;
    left_child = null;
    right_child = null;
    parent = null;
  }

  /**
   * Constructor
   * @param data The data for the first node to hold
   * @param left_child 
   * @param right_child
   * @param parent
   */
  public Node(Comparable data, Node left_child, Node right_child, Node parent) {
    this.data = data;
    this.left_child = left_child;
    this.right_child = right_child;
    this.parent = parent;
  }

  /**
   * The getter for the left child
   * @return the left child
   */
  public Node getLeftChild() {
    return left_child;
  }

  /**
   * The getter for the right child
   * @return the right child
   */
  public Node getRightChild() {
    return right_child;
  }

  /**
   * Getter for the data contained in the node
   * @return
   */
  public Comparable getData() {
    return data;
  }

  /**
   * Getter for the parent
   * @return
   */
  public Node getParent() {
    return parent;
  }

  /**
   * Setter for the left child
   * @param left_child
   */
  public void setLeftChild(Node left_child) {
    this.left_child = left_child;
  }

  /**
   * Setter for the right child
   * @param right_child
   */
  public void setRightChild(Node right_child) {
    this.right_child = right_child;
  }
  
  /**
   * Setter for the node's data
   * @param data
   */
  public void setData(Comparable data) {
    this.data = data;
  }

  /**
   * Setter for the parent
   * @param parent
   */
  public void setParent(Node parent) {
    this.parent = parent;
  }
}
