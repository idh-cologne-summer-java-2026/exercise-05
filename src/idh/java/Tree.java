package idh.java;

public class Tree<T> {
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
	 * 
	 * @return the number of nodes in this tree
	 */
	public int size() {
		// TODO: Implement me!
		int totalSize = 1;
		MyLinkedList<Tree<T>> currentChild = this.children;
		
		while(currentChild != null) {
			totalSize += currentChild.size();
			currentChild = currentChild.next;
		} return totalSize;
		

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
	public boolean contains(T object) {
		if(this.value == null) {
			if (object == null) {
				return true;
			} else if (this.value.equals(object)) {
				return true;
			}
		}
		
		MyLinkedList<Tree<T>> currentElement = this.children.first;
		while(this.children != null) {
			MyLinkedList<Tree<T>> TreeChild = currentElement.value;
			if(TreeChild.contains(object)) {
				return true;
				currentElement = currentElement.next;
			}
		} return false;
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
}
