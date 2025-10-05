package com.Roukan.datastructures.list;

import java.util.NoSuchElementException;

import com.Roukan.datastructures.list.Node;

public class LinkedList<T> {
	private Node<T> head; // head that points to the first element
	private int size; // the size of the LinkedList

	public LinkedList() {
		this.head = null; // initialize without pointing to any node
		this.size = 0; // no elements
		
	}

	/* Operations:
	 *
	 * append() = adds an element to the end of the list #
	 * prepend() = adds an element to the beginning of the list #
	 * insert() = inserts an element at the specified index #
	 *
	 * removeFirst() = removes and returns the first element #
	 * removeLast() = removes and returns the last element  #
	 * remove() = removes and returns the element at the given index #
	 *
	 * get() = returns the element at the specified index #
	 * getFirst() = returns the first element #
	 * getLast() = returns the last element #
	 * indexOf() = returns the first index of the specified element  #
	 * lastIndexOf() = returns the last index of the specified element #
	 * contains() = returns true if the list contains the element #
	 *
	 * size() = returns the number of elements in the list #
	 * isEmpty() = returns true if the list is empty #
	 * clear() = removes all elements from the list 
	 * toString() = returns a string representation of the list #
	 */


	public boolean isEmpty() {
		if (head == null) { // if the head of the list points to nothing
			return true; // It's empty
		} else {
			return false;
		}
	}

	public void append(T value) {
		Node<T> newNode = new Node<>(value); // creates a new node with the given value

		if (isEmpty()) {
			head = newNode; // If it's the first item
		} else {
			Node<T> lastNode = getLast(); // creates a counter to cycle through the list
			lastNode.setNextNode(newNode); // the last node points to the new node

		}

		size++; // updates the size of the LinkedList
	}

	public void prepend(T value) {
		Node<T> newNode = new Node<>(value); // creates a new node with the given value
		Node<T> firstNode = head; // the first node 

		if (isEmpty()) {
			head = newNode;
		} else {
			head = newNode; // the head now points to the new node
			newNode.setNextNode(firstNode); // the new node points to the first node
		}

		size++;
	}

	public void insert(T value, int index) throws IndexOutOfBoundsException {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index is smaller or bigger than the list...");
		}

		if (index == 0) {
			prepend(value);
			return;
		}

		if (index == size) {
			append(value);
			return;
		}

		Node<T> previousNode = head;

		for (int i = 0; i < index - 1; i++) { // go to the previous index (where the previous node is)
			previousNode = previousNode.getNextNode();

		}

		Node<T> indexNode = previousNode.getNextNode(); 

		Node<T> newNode = new Node<>(value); // creates a new node without pointing to anywhere
		newNode.setNextNode(indexNode); // the new node points to the index
		previousNode.setNextNode(newNode); // the previous node now points to the new node

		size++;
	}

	public void removeFirst() throws IllegalArgumentException {
		if (isEmpty()) {
			throw new IllegalArgumentException("Cannot remove elements from an empty list");

		} else {
			Node<T> nodeToBeRemoved = head; // initial node
			Node<T> nextReference = head.getNextNode();
			head = nextReference;

			nodeToBeRemoved.setNextNode(null);
			nodeToBeRemoved.setValue(null);
			
		}
		size--;
	}

	public void removeLast() throws IllegalArgumentException {
		if (isEmpty()) {
			throw new IllegalArgumentException("Cannot remove elements from an empty list");

		} else if (size == 1) {
			head = null;

		} else {
			Node<T> penultimateNode = head;

			while (penultimateNode.getNextNode().getNextNode() != null) {
				penultimateNode = penultimateNode.getNextNode();

			}

			Node<T> lastNode = penultimateNode.getNextNode();

			penultimateNode.setNextNode(null);
			lastNode.setNextNode(null);
			lastNode.setValue(null);

		}
		size--;
	}

	public void remove(int index) throws IllegalArgumentException, IndexOutOfBoundsException {
		Node<T> previousNode = head;
		if (isEmpty()) {
			throw new IllegalArgumentException ("Cannot remove elements from an empty list");

		} 

		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index: " + index + " is out of bounds" + " for size: " + size);

		} 

		if (index == 0) {
			removeFirst();
			return;

		}

		if (index == size - 1) {
			removeLast();
			return;
		}

		for (int i = 0; i < index - 1; i++) {
			previousNode = previousNode.getNextNode();
						
		}
		Node<T> nodeToBeRemoved = previousNode.getNextNode();
		Node<T> nextNode = nodeToBeRemoved.getNextNode();
		previousNode.setNextNode(nextNode);
		nodeToBeRemoved.setNextNode(null);
		nodeToBeRemoved.setValue(null);

		size--;
	}

	public Node<T> get(int index) throws IllegalArgumentException, IndexOutOfBoundsException {
		if (isEmpty()) {
			throw new IllegalArgumentException("Cannot find elements inside an empty list...");

		}

		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index: " + index + " is out of bounds" + " for length: " + size);

		}

		Node<T> getNode = head;
		for (int i = 0; i < index; i++) {
			getNode = getNode.getNextNode();

		}
		return getNode;

	}

	public Node<T> getFirst() throws IllegalArgumentException {
		if (isEmpty()) {
			throw new IllegalArgumentException ("Cannot find elements inside an empty list...");

		}

		return head;
		
	}

	public Node<T> getLast() {
		if (isEmpty()) { // if the list is empty returns null
			return null;

		} else {
			Node<T> currentNode = head; // creates node that starts from the beginning of the list
			while (currentNode.getNextNode() != null) { // go to the last node (before null)
				currentNode = currentNode.getNextNode();

			}
			return currentNode;

		}

	}

	public int indexOf(T value) {
		int index = 0;
		Node<T> currentNode = head;
		while (currentNode != null) {
			if (currentNode.getValue().equals(value)) {
				return index;

			}

			currentNode = currentNode.getNextNode();
			index++;
		}
		return -1;
	}

	public int lastIndexOf(T value) {
		int index = 0;
		int lastPosition = -1;
		Node<T> currentNode = head;
		while (currentNode != null) {
			if (currentNode.getValue().equals(value)) {
				lastPosition = index;
			}

			currentNode = currentNode.getNextNode();
			index++;
		}
		return lastPosition;
	}

	public boolean contains(T value) {
		Node<T> current = head;

		while (current != null) {
			if (current.getValue().equals(value)) {
				return true;
			}
			current = current.getNextNode();
		}

		return false;
	}

	public void clear() {
		head = null;
		size = 0;
	}

	@Override
	public String toString() {
		Node<T> current = head;
		StringBuilder list = new StringBuilder("[");

		if (isEmpty()) {
			return "[]";
		}

		while (current != null) {
			list.append(current.getValue());
			if (current.getNextNode() != null) {
				list.append(", ");
			}
			current = current.getNextNode();

		}

		list.append("]");
		return list.toString();
	}

	public int size() {
		return size;
	}


}
