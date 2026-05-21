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
	 */
	public int size() {
		// Basisfall: Wenn der Knoten leer ist (null), zählt er als 0, sonst als 1.
		// Das ist wichtig, da ein "new Tree()" laut Test die Größe 0 haben soll.
		int count = (value == null) ? 0 : 1;
		
		// Rekursionsschritt: Wir addieren die Größen aller Kinder-Teilbäume dazu
		for (int i = 0; i < children.size(); i++) {
			count += children.get(i).size();
		}
		
		return count;
	}

	/**
	 * Checks whether the tree contains a value that is equal to the given object.
	 */
	public boolean contains(T object) {
		// 1. Basisfall: Ist der gesuchte Wert genau in DIESEM Knoten?
		if (object == null ? value == null : object.equals(value)) {
			return true;
		}
		
		// 2. Rekursionsschritt: Suchtrupps in alle Kinder-Teilbäume schicken
		for (int i = 0; i < children.size(); i++) {
			// Sobald ein Kind (oder dessen Kinder) "true" zurückgibt, brechen wir erfolgreich ab
			if (children.get(i).contains(object)) {
				return true;
			}
		}
		
		// 3. Wenn weder hier noch in den Kindern etwas gefunden wurde:
		return false;
	}

	/**
	 * Adds a child to this node. The object representing the sub tree is
	 * automatically created, and added to the children's list.
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
	 * Produces a string representation of the tree.
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