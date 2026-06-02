package idh.java;

public class MyLinkedList<T> {

    /**
     * Helper class for the list elements
     * 
     * It's an "inner class", i.e., can only be used within MyLinkedList.
     */
    private class ListElement {
        T payload;
        ListElement next = null;

        ListElement(T value) {
            this.payload = value;
        }
    }

    /**
     * We only need to store the very first element of our list, because it will
     * know whether there is a next element.
     */
    ListElement first;

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements
     */
    public int size() {
        if (isEmpty()) {
            return 0;
        }

        int s = 1;
        ListElement current = first;

        while (current.next != null) {
            current = current.next;
            s += 1;
        }

        return s;
    }

    /**
     * Returns true if this list contains the specified object.
     * Comparison is performed using Object.equals.
     *
     * @param o the object to search for
     * @return true if the object is present, false otherwise
     */
    public boolean contains(Object o) {
        ListElement current = first;

        while (current != null) {
            if (current.payload.equals(o)) {
                return true;
            }

            current = current.next;
        }

        return false;
    }

    /**
     * Removes the first occurrence of the specified object from the list.
     * Comparison is performed using Object.equals.
     *  
     * @param o the object to remove
     * @return true if an element was removed, false if not found
     */
    public boolean remove(Object o) {
        if (isEmpty()) {
            return false;
        }

        if (first.payload.equals(o)) {
            first = first.next;
            return true;
        }

        ListElement current = first;
        ListElement previous = null;

        while (current != null) {
            if (current.payload.equals(o)) {
                previous.next = current.next;
                return true;
            }

            previous = current;
            current = current.next;
        }

        return false;
    }

    /**
     * Replaces the element at the specified index with the given value and
     * returns the previously stored value.
     *
     * @param index zero based position of the element to replace
     * @param element the new value to store at index
     * @return the value previously stored at index, or null if the index is out of bounds
     */
    public T set(int index, T element) {
        ListElement e = getElement(index);

        if (e != null) {
            T oldValue = e.payload;
            e.payload = element;
            return oldValue;
        }

        return null;
    }

    /**
     * Appends the specified value to the end of this list.
     *
     * @param value the value to add
     */
    public void add(T value) {
        ListElement newElement = new ListElement(value);

        if (first == null) {
            first = newElement;
        } else {
            last().next = newElement;
        }
    }

    /**
     * Removes and returns the element at the specified index.
     * Returns null if the index is out of bounds.
     * 
     * @param index zero based position of the element to remove
     * @return the removed element's value, or null if out of bounds
     */
    public T remove(int index) {
        if (isEmpty()) {
            return null;
        }

        if (index == 0) {
            T removedValue = first.payload;
            first = first.next;
            return removedValue;
        }

        ListElement current = first;
        ListElement previous = null;

        while (current != null) {
            if (index == 0) {
                T removedValue = current.payload;
                previous.next = current.next;
                return removedValue;
            }

            previous = current;
            current = current.next;
            index--;
        }

        return null;
    }

    /**
     * Returns true if this list contains no elements.
     *
     * @return true if the list is empty
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Removes all elements from this list. The list will be empty after this call.
     */
    public void clear() {
        first = null;
    }

    /**
     * Returns the value at the specified index, or null if out of bounds.
     *
     * @param index zero based position of the element to retrieve
     * @return the value at index, or null
     */
    public T get(int index) {
        ListElement el = getElement(index);

        if (el == null) {
            return null;
        } else {
            return el.payload;
        }
    }

    /**
     * Internal method that iterates over the list, returning the last element.
     * 
     * @return the last element of the list
     */
    private ListElement last() {
        if (first == null) {
            return null;
        }

        ListElement current = first;

        while (current.next != null) {
            current = current.next;
        }

        return current;
    }

    /**
     * Internal method to get the list element at the specified index position.
     * This method starts the recursive search.
     * 
     * @param index the index to search for
     * @return the list element at the index, or null
     */
    private ListElement getElement(int index) {
        return getElementRecursive(first, index);
    }

    /**
     * Recursive helper method for getElement.
     * 
     * Basisfälle:
     * current == null bedeutet: Ende der Liste erreicht.
     * index < 0 bedeutet: ungültiger Index.
     * index == 0 bedeutet: gesuchtes Element gefunden.
     * 
     * Rekursionsschritt:
     * Gehe zum nächsten Element und verringere den Index um 1.
     * 
     * @param current the current list element
     * @param index the remaining index
     * @return the matching list element, or null
     */
    private ListElement getElementRecursive(ListElement current, int index) {
        if (current == null) {
            return null;
        }

        if (index < 0) {
            return null;
        }

        if (index == 0) {
            return current;
        }

        return getElementRecursive(current.next, index - 1);
    }
}