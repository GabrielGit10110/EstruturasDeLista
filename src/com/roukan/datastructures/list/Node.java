package com.Roukan.datastructures.list;

public class Node<T> {
	private T value; // the value inside any node
	private Node<T> nextNode;  // the memory register of the next node

	// constructor for the final node (pointing to null)
	public Node(T value) {
		this.value = value;
		this.nextNode = null;
	}

	// constructor for all the other nodes
	public Node(T value, Node<T> nextNode) {
		this.value = value;
		this.nextNode = nextNode; // instantiate a new 
					  // adress and point to it
	}

	// getters and setters
	// get the value inside the node
	public T getValue() {
		return value;
	}

	// set a new value to the node
	public void setValue(T value) {
		this.value = value;
	}

	// get the value of the next node
	// if the node is the last one, the return is null... 
	public Node<T> getNextNode() {
		return nextNode;
	}

	// set the value of the next node
	// (points to where the next node is in memory)
	public void setNextNode(Node<T> nextNode) {
		this.nextNode = nextNode;
	}

	// converts the value inside the node to string
	// debug reasons
	@Override
	public String toString() {
		StringBuilder msg = new StringBuilder();
		if (value == null) {
			return "Node{null}";
		} else {
			msg.append("Node{").append(value);
			msg.append("}");
			return msg.toString();
		}
	}
}
