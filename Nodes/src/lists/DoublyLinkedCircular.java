package lists;

import nodes.Node;

public class DoublyLinkedCircular<T> {
	private Node<T> head;
	private Node<T> tail;
	
	// For iterating
	private Node<T> currPoint;
	public int length = 0;
	
	// Constructors
	public DoublyLinkedCircular() {
		head = null;
		tail = null;
		currPoint = null;
	}
	
	public DoublyLinkedCircular(T data) {
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
			head.setPrev(head);
			head.setNext(head);			
		} else {
			temp.setNext(head);
			temp.setPrev(tail);
			tail.setNext(temp);
			head.setPrev(temp);
			head = temp;
		}
	}
	
	// TODO: Appends to end of list.
	public void append(T data) {
		Node<T> temp = new Node<T>(data);
		length++;
		if (length == 1) {
			head = temp;
			tail = temp;
			currPoint = temp;
			head.setPrev(head);
			head.setNext(head);
		} else {
			temp.setNext(head);
			temp.setPrev(tail);
			tail.setNext(temp);
			head.setPrev(temp);
			tail = temp;
		}
	}
	
	// TODO: Returns the next node in the list. Starts at the first node and loops back to the first. Advances the currPoint.
	public Node<T> getNext() {
		try {
			return currPoint;
		} finally {
			currPoint = (currPoint.next != null) ? currPoint.next : head;
		}
	}
	
	// TODO: Calls getNext() and returns the data from the node. Advances the currPoint
	public T getNextData() {
		return this.getNext().data;
	}
	
	// TODO: Prints the list to console from start to end.
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
