package lists;

import nodes.Node;

public class SinglyLinked<T> {
	
	private Node<T> head;
	private Node<T> tail;
	
	// For iterating
	private Node<T> currPoint;
	public int length = 0;
	
	// Constructors
	public SinglyLinked() {
		head = null;
		tail = null;
		currPoint = null;
	}
	
	public SinglyLinked(T data) {
		this();
		this.append(data);
	}
	
	
	// Inserts at start of list.
	public void insert(T data) {
		Node<T> temp = new Node<T>(data);
		length++;
		temp.setNext(head);
		head = temp;
		if (length == 1) { tail = head; currPoint = head; }
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
			tail = tail.next;
		}
	}
	
	// Returns the next node in the list. Starts at the first node and loops back to the first. Advances the currPoint.
	public Node<T> getNext() {
		try {
			return currPoint;
		} finally {
			currPoint = (currPoint.next != null) ? currPoint.next : head;
		}
	}
	
	// Calls getNext() and returns the data from the node. Advances the currPoint
	public T getNextData() {
		return this.getNext().data;
	}
	
	// Prints the list to console from start to end.
	public void printList() {
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

}
