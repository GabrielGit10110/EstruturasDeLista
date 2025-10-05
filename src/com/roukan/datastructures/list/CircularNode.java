package com.Roukan.datastructures.list;

public class CircularNode<T> {
	private CircularNode<T> next;
	private CircularNode<T> previous;
	private T value;

	// empty constructor
	public CircularNode() {
		this.next = null;
		this.previous = null;
		this.value = null;
	}

	// default constructor
	public CircularNode(T value) {
		this.next = null;
		this.previous = null;
		this.value = value;
	}

	// getters & setters
	public CircularNode<T> getNext() {
		return this.next;
	}

	public void setNext(CircularNode<T> next) {
		this.next = next;
	}

	public CircularNode<T> getPrevious() {
		return this.previous;
	}

	public void setPrevious(CircularNode<T> previous) {
		this.previous = previous;
	}

	public T getValue() {
		return this.value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	// to string method, to print the value of the node
	@Override
	public String toString() {
		if (this.value == null) {
			return "null";
		}

		return this.value.toString();
	}
}
