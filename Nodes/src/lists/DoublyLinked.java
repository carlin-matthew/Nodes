package lists;

import nodes.Node;

public class DoublyLinked<T> {
	
	private Node<T> head;
	private Node<T> tail;
	
	// For iterating
	private Node<T> currPoint;
	public int length = 0;
	
	// Constructors
	public DoublyLinked() {
		head = null;
		tail = null;
		currPoint = null;
	}
	
	public DoublyLinked(T data) {
		this();
		this.append(data);
	}
	
	
	// Inserts at start of list.
	public void insert(T data) {
		Node<T> temp = new Node<T>(data);
		length++;
		if (length == 1) {
			head = temp;
			tail = temp;
			currPoint = temp;
		} else {
			temp.setNext(head);
			head.setPrev(temp);
			head = temp;
		}
	}
	
	// Appends to end of list.
	public void append(T data) {
		Node<T> temp = new Node<T>(data);
		length++;
		if (length == 1) {
			head = temp;
			tail = temp;
			currPoint = temp;
		} else {
			tail.setNext(temp);
			tail = temp;
		}
	}
	
	// Moves the currPoint to the previous node in list. Returns the node.
	public Node<T> prevNode() {
		currPoint = (currPoint != null) ? currPoint.prev : null;
		return currPoint;
	}
	
	// Calls prevNode() and returns the data from the node. Moves the currPoint to previous node.
	public T prevData() {
		return this.prevNode().data;
	}
	
	// Advances the currPoint to next node in list. Returns the node.
	public Node<T> nextNode() {
			currPoint = (currPoint != null) ? currPoint.next : null;
			return currPoint;
	}
	
	// Calls next() and returns the data from the node. Advances the currPoint.
	public T nextData() {
		return this.nextNode().data;
	}
	
	// Returns the current node.
	public Node<T> current() {
		return currPoint;
	}
	
	// Returns the data for the current node.
	public T currentData() {
		return currPoint.data;
	}
	
	// Prints the list to console from start to end.
	public void printListF() {
		if (head != null) {
			Node<T> temp = head;
			while (temp != null) {
				temp.print();
				temp = temp.next;
			}
			System.out.println();
		} else {
			System.out.println("List is empty.");
		}
	}
	
	// Prints the list to console from end to start.
	public void printListB() {
		if (tail != null) {
			Node<T> temp = tail;
			while (temp != null) {
				temp.print();
				temp = temp.prev;
			}
			System.out.println();
		} else {
			System.out.println("List is empty.");
		}
	}

}
