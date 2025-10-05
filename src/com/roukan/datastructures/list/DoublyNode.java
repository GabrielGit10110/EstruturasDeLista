package com.Roukan.datastructures.list;

public class DoublyNode<T> {
	private T value;
	private DoublyNode<T> nextNode;
	private DoublyNode<T> previousNode;

	public DoublyNode(T value) {
		this.nextNode = null;
		this.previousNode = null;
		this.value = value;

	}

	public DoublyNode(T value, DoublyNode<T> nextNode, DoublyNode<T> previousNode) {
		this.value = value;
		this.nextNode = nextNode;
		this.previousNode = previousNode;

	}

	public DoublyNode() {
		this.value = null;
		this.nextNode = null;
		this.previousNode = null;

	}

	public T getValue() {
		return value;

	}

	public void setValue(T value) {
		this.value = value;

	}

	public void setNextNode(DoublyNode<T> nextNode) {
		this.nextNode = nextNode;

	}

	public DoublyNode<T> getNextNode() {
		return nextNode;

	}

	public DoublyNode<T> getPreviousNode() {
		return previousNode;

	}

	public void setPreviousNode(DoublyNode<T> previousNode) {
		this.previousNode = previousNode;

	}

	@Override
	public String toString() {
		return value.toString();

	}

}
