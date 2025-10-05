package com.Roukan.datastructures.list;

public class CircularLinkedList<T> {
	private CircularNode<T> last;
	private int size;

	public CircularLinkedList () {
		this.last = null;
		this.size = 0;
	}

	/*
	 * append(T value) = adiciona no fim da lista circular
	 * remove(int index) = remove um no em determinado indice
	 * toString() = transforma a lista em string
	 */

	public void append(T value) {
		CircularNode<T> newNode = new CircularNode<T>(value);

		if (this.last == null) {
			newNode.setNext(newNode);
			newNode.setPrevious(newNode);
			this.last = newNode;
		}

		else {
			CircularNode<T> lastNode = this.last;
			CircularNode<T> firstNode = this.last.getNext();

			newNode.setNext(firstNode);
			newNode.setPrevious(lastNode);
			
			lastNode.setNext(newNode);
			firstNode.setPrevious(newNode);
			this.last = newNode;
		}
		this.size++;

	}

	public void remove(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= this.size) {
			throw new IndexOutOfBoundsException("Indice invalido: "+index);
		}
		CircularNode<T> toBeRemoved = get(index); 
		CircularNode<T> previous = toBeRemoved.getPrevious();
		CircularNode<T> next = toBeRemoved.getNext();

		if (toBeRemoved == this.last) {
			this.last = previous;
		}

		previous.setNext(next);
		next.setPrevious(previous);

		toBeRemoved.setNext(null);
		toBeRemoved.setPrevious(null);
		toBeRemoved.setValue(null);

		this.size--;
	}

	public CircularNode<T> get(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= this.size) {
			throw new IndexOutOfBoundsException("Indice invalido: "+index);

		}
		CircularNode<T> expected = this.last.getNext();

		for (int i = 0; i < index; i++) {
			expected = expected.getNext();
		}

		return expected;

	}

	@Override
	public String toString() {
		if (this.last == null) {
			return "[]";
		}

		StringBuilder list = new StringBuilder("[");
		CircularNode<T> pointer = this.last.getNext();
		int counter = 0;

		do {
			list.append(pointer.getValue());

			if (counter < size - 1) {
				list.append(", ");
			}

			counter++;
			pointer = pointer.getNext();
		} while (pointer != this.last.getNext() && counter < size);

		list.append("]");

		return list.toString();
	}

}
