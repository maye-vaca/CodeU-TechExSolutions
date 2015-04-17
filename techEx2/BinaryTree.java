import java.util.LinkedList;
import java.util.Queue;
public class BinaryTree<T extends Comparable<T>> {
    private Node<T> root;

    public BinaryTree(T data) {
	this.root = new Node<T>(data);
    }

    public BinaryTree() {
	this.root = null;
    }

    public void add(T data) {
	//if there is no root, make one
	if (this.root == null) {
	    this.root = new Node<T>(data);
	} else {
	    //traverse to the tree from top-down, left to right until finding
	    //a spot for a new node.
	    Node<T> curr = this.root;
	    boolean added = false;
	    while (!added) {
		//check the left child then the right and place the new node
		//in the first empty spot. 
		if (curr.getLeft() == null) {
		    curr.setLeft(new Node<T>(data));
		    added = true;
		} else if (curr.getRight() == null) {
		    curr.setRight(new Node<T>(data));
		    added = true;	
		} else {
		    //if neither spots are empty move down to the left child
		    //and check for empty spots there
		    curr = curr.getLeft();
		}
	    }
	}
    }

    public Node<T> getRoot() {
	return this.root;
    }

    public String flatten() {
	String data = "";
	Queue<Node<T>> q = new LinkedList<Node<T>>();
	if (this.root == null) {
	    return data;
	} 
	//perform a level-order traversal of the tree to order the outputs
	q.add(root);
	//do the following while there are still nodes left in the tree
	while(!q.isEmpty()) {
	    //remove the first item in the queue and print it's data
	    Node<T> curr = q.remove();
	    data += curr.getData() + " ";
	    //add the left child to the queue if it's there
	    if (curr.getLeft()!= null) {
		q.add(curr.getLeft());
	    }
	    //add the right child to the queue if it's there
	    if (curr.getRight() != null) {
		q.add(curr.getRight());
	    }
	}
	//return the full data string
	return data;
    }
    public static void main(String[] args) {
	//Tests Cases//
	//Testing with integers
	BinaryTree<Integer> tree = new BinaryTree<Integer>();
	for (int i = 10; i > 0; i--) {
	    tree.add(i);
	}
	//Expected output 10,9,....2,1
	System.out.println(tree.flatten());

	BinaryTree<String> tree2 = new BinaryTree<String>();
	tree2.add("Why");
	tree2.add("Hello");
	tree2.add("There");
	tree2.add("Sunshine");
	//Expected output "Why Hello There Sunshine"
	System.out.println(tree2.flatten());
    }
}
