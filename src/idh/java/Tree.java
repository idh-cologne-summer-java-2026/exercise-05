package idh.java;

public class Tree<T> {
	
	
	private Node node;
	private int size = 0;
	
	//class depicting a Node in the tree -> each node has a value as well as two potential neighbors (in the case of a binary tree?)
	private class Node {
		Integer value; //changing to Object-Type to be able to use the contains method without casting
		Node left;
		Node right;
		
		Node(Integer cont){ //same here
			value = cont;
			left = right = null; //same as left = null and right = null
		}
	}
	
	/**
	 * The value stored at this tree node
	 */
	T value;

	/**
	 * The list of children
	 */
	MyLinkedList<Tree<T>> children = new MyLinkedList<Tree<T>>();

	/**
	 * Returns the number of nodes in this tree.
	 * Basically, search strategies?
	 * Either traverse branch-wise or level-wise (up-down first or left-right first)
	 * And count steps?. Would I have to count Node objects or is the Node class unnecessary?
	 * 
	 * @return the number of nodes in this tree
	 */
	public int size() {
		// TODO: Implement me!
		
		return size;
	}

	
	
	/**
	 * Checks whether the tree contains a value that is equal to the given object.
	 * I.e., the comparison between the objects is done with {@link Object#equals}.
	 * The method returns false when all nodes have been visited and none of them is
	 * equal to the object. It returns true when a matching object has been found.
	 * 
	 * @param object The object that we want to check for
	 * @return true or false
	 */
	public boolean contains(T object, Node target) {	
		this.traverse(object, target);
//		if(node.equals(null)) {
//			return false;
//		}
//		if(node.equals(object)) {
//			return true;
//		}else {
//			return false;
//		}
//		return 
	}

	/**
	 * Adds a child to this node. The object representing the sub tree is
	 * automatically created, and added to the children's list.
	 * 
	 * @param object The value we want to store.
	 */
	public void addChild(T object) {
		Tree<T> subtree = new Tree<T>();
		subtree.setValue(object);
		getChildren().add(subtree);
		size++;
	}

	private String toString(int indentation) {
		StringBuffer buf = new StringBuffer();

		buf.append(" ".repeat(indentation));
		buf.append(this.getValue());
		buf.append('\n');

		for (int i = 0; i < getChildren().size(); i++) {
			buf.append(getChildren().get(i).toString(indentation + 2));
		}

		return buf.toString();
	}

	/**
	 * Produces a string representation of the tree. Subtrees are indented with spaces. 
	 * A tree with the value "A" and the two children "B" and "C" is shown like this:
	 * <pre>
	 * A
	 *   B
	 *   C
	 * </pre>
	 * 
	 * 
	 */
	public String toString() {
		return toString(0);
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public MyLinkedList<Tree<T>> getChildren() {
		return children;
	}

	public void setChildren(MyLinkedList<Tree<T>> children) {
		this.children = children;
	}
	
	/**
	 * Helper method to traverse the Tree
	 * Changed the initial node value to Integer to gain access to the equals() method
	 */
	public boolean traverse(Node node, T target) {
		if(node.equals(null)) //Tree is empty
			return false;
		if(node.value.equals(target)) {
			return true; //an else statement could be added, but would just be redundant it seems
		} 
		return traverse(node.left, target) || traverse(node.right, target);
		
	}
	 
}
