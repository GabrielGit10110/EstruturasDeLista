package com.Roukan.datastructures.list;

public class DoublyLinkedList<T> {
	private DoublyNode<T> head;
	private DoublyNode<T> last;
	private int size;

	public DoublyLinkedList() {
		this.head = null;
		this.last = null;
		this.size = 0;
	}

	// append() = Adiciona o value no final;
	// get() = Retorna um no dado um index;
	// index() = Retorna um indice de um value;
	// insert() = Insere um value em uma determinada posicao;
	// remove() = Remove um value dado o index;
	// size() = Retorna o total de values;
	// isEmpty() = Retorna true ou false se a lista estiver vazia;

	public void append(T value) {
		DoublyNode<T> buffer = new DoublyNode<>(value);

		// se a lista esta vazia
		// a cabeca aponta para o novo elemento
		// o fim aponta para o novo elemento
		if (isEmpty()) {
			this.head = buffer;
			this.last = buffer;

		} else {
			// proximo elemento do ultimo(antigo)
			// vira o ultimo(novo)
			this.last.setNextNode(buffer);

			// ultimo elemento aponta para nada em sua frente
			buffer.setNextNode(null);
			// ultimo elemento aponta para o antigo ultimo
			// elemento em suas costas
			buffer.setPreviousNode(this.last);

			// atualiza o ultimo elemento e aumenta o tamanho
			this.last = buffer;

		}

		this.size++;
	}

	public DoublyNode<T> get(int index) throws IllegalArgumentException {
		int i = 0;

		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index invalido, maior do que o tamanho ou menor do que 0");

		}

		// divide a lista em dois
		// caso o index seja menor ou igual a metade total
		if (index <= size / 2) {
			DoublyNode<T> buffer = this.head;
			for (i = 0; i < index; i++) {
				buffer = buffer.getNextNode();

			}

			return buffer;

			// caso nao
		} else {
			DoublyNode<T> buffer = this.last;
			// vai do fim até o index
			for (i = (size - 1); i > index; i--) {
				buffer = buffer.getPreviousNode();

			}
			return buffer;

		}

	}

	public int index(T value) throws IllegalArgumentException {
		if (isEmpty()) {
			throw new IllegalArgumentException("Nao existe item na lista.");

		}

		if (value == null) {
			throw new IllegalArgumentException("Valor nao pode ser nulo");
		}

		int index = 0;
		if (this.head.getValue().equals(value)) {
			return index;

		}

		DoublyNode<T> buffer = this.head;
		do {
			if (buffer.getValue() == value) {
				return index;
			}
			buffer = buffer.getNextNode();
			index++;

		} while (buffer != null);

		throw new IllegalArgumentException("Item nao encontrado.");
	}

	public void insert(int index, T value) throws IllegalArgumentException {
		// tratamento do indice
		if (index < 0 || index > size) {
			throw new IllegalArgumentException("Indice invalido: " + index);

		}

		// caso especial
		if (index == 0) {
			prepend(value);
			return;

		}

		// caso especial
		if (index == size) {
			append(value);
			return;

		}

		// cria um novo nó
		DoublyNode<T> newNode = new DoublyNode<>(value);
		// pega o nó onde fica o indice atual
		DoublyNode<T> afterNode = get(index);
		// pega o que nó que vem antes do indice atual
		DoublyNode<T> previousNode = afterNode.getPreviousNode();

		// o novo nó agora aponta para o nó no indice atual
		newNode.setNextNode(afterNode);
		// o novo nó agora aponta para o nó um indice para trás
		newNode.setPreviousNode(previousNode);

		// o nó do indice atual agora vira o próximo nó na lista
		afterNode.setPreviousNode(newNode);
		// e o anterior fica atrás do novo nó
		previousNode.setNextNode(newNode);

		// aumenta o tamanho da lista
		this.size++;

	}

	public void prepend(T value) throws IllegalArgumentException {
		DoublyNode<T> newNode = new DoublyNode<>(value);
		// tratamento lista vazia
		if (isEmpty()) {
			this.head = newNode;

		} else {
			// cria um nó que é igual a head (o começo)
			DoublyNode<T> headNode = this.head;
			// novo nó aponta para o antigo primeiro item
			newNode.setNextNode(headNode);
			// novo nó agora aponta em suas costas para nada
			newNode.setPreviousNode(null);
			// o antigo primeiro nó agora aponta em suas costas para
			// o novo nó
			headNode.setPreviousNode(newNode);

			// atualiza a head
			this.head = newNode;

		}

		// aumenta o tamanho
		this.size++;
	}

	public void remove(int index) throws IllegalArgumentException {
		if (isEmpty()) {
			throw new IllegalArgumentException("Nao há itens para remover...");

		}

		if (index < 0 || index >= size) {
			throw new IllegalArgumentException("Index invalido: " + index);

		}

		if (index == 0) {
			DoublyNode<T> nodeToBeRemoved = this.head;
			DoublyNode<T> nextNode = nodeToBeRemoved.getNextNode();

			this.head = nextNode;

			if (nextNode != null) {
				nextNode.setPreviousNode(null);

			} else {
				this.last = null;

			}

			nodeToBeRemoved.setNextNode(null);
			nodeToBeRemoved.setPreviousNode(null);
			nodeToBeRemoved.setValue(null);

			this.size--;
			return;

		}

		if (index == size - 1) {
			DoublyNode<T> nodeToBeRemoved = this.last;
			DoublyNode<T> previousNode = nodeToBeRemoved.getPreviousNode();

			previousNode.setNextNode(null);

			nodeToBeRemoved.setNextNode(null);
			nodeToBeRemoved.setPreviousNode(null);
			nodeToBeRemoved.setValue(null);

			this.last = previousNode;
			this.size--;
			return;

		}

		DoublyNode<T> nodeToBeRemoved = get(index);
		DoublyNode<T> previousNode = nodeToBeRemoved.getPreviousNode();
		DoublyNode<T> nextNode = nodeToBeRemoved.getNextNode();

		nodeToBeRemoved.setNextNode(null);
		nodeToBeRemoved.setPreviousNode(null);
		nodeToBeRemoved.setValue(null);

		previousNode.setNextNode(nextNode);
		nextNode.setPreviousNode(previousNode);

		this.size--;

	}

	public int size() {
		return this.size;

	}

	public boolean isEmpty() {
		if (this.head == null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		if (isEmpty()) {
			return "[]";
		}

		StringBuilder builder = new StringBuilder("[");
		DoublyNode<T> buffer = this.head;
		int counter = 0;

		do {
			builder.append(buffer.getValue());
			if (counter < size - 1) {
				builder.append(", ");
			}
			counter++;
			buffer = buffer.getNextNode();

		} while (buffer != null && counter < size);
		builder.append("]");
		return builder.toString();
	}

}
