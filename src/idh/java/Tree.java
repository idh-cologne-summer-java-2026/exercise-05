package idh.java;

import java.util.ArrayList;
import java.util.List;

public class Tree<T> {

	private T value;
	private List<Tree<T>> children;

	public Tree() {
		this.children = new ArrayList<>();
	}

	public void setValue(T value) {
		this.value = value;
	}

	public T getValue() {
		return value;
	}

	public void addChild(T childValue) {
		Tree<T> childTree = new Tree<>();
		childTree.setValue(childValue);
		this.children.add(childTree);
	}

	public List<Tree<T>> getChildren() {
		return children;
	}

	// --- Aufgabe 2: Implementierungen ---

	public int size() {
		// Fix: Ein Knoten zählt nur als 1, wenn er auch einen echten Wert hat!
		int totalSize = (this.value != null) ? 1 : 0;

		// Addiere rekursiv die Groesse aller Kinder
		for (Tree<T> child : children) {
			totalSize += child.size();
		}

		return totalSize;
	}

	public boolean contains(Object o) {
		// Basisfall: Befindet sich das Objekt in diesem Knoten?
		if (this.value != null && this.value.equals(o)) {
			return true;
		}

		// Rekursionsschritt: Suche in allen Kindern weiter
		for (Tree<T> child : children) {
			if (child.contains(o)) {
				return true; 
			}
		}

		return false;
	}
}