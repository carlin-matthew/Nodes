package driver;

import nodes.*;

public class Driver {

	public static void main(String[] args) {
		Node head = new Node(null, 0);
		Node temp = head;
		
		for (int i = 0; i < 10; i++) {
			head = new Node(head, i + 1);
			head.next.prev = head;
		}
		head.prev = temp;
		temp.next = head;
		
		// Printing circular doubly linked list
		System.out.println("\nPrinting forward");
		head.printForward();
		System.out.println();
		
		System.out.println("Printing backward");
		head.printBackward();
		System.out.println();
		
		System.out.println("\nReversing list\n");
		//head = Utils.reverseSingle(head);
		head = Utils.reverseDoubleCircle(head);
		
		System.out.println("Printing forward");
		head.printForward();
		System.out.println();
		
		System.out.println("Printing backward");
		head.printBackward();
		System.out.println();
		
		
		System.out.println("\nMaking new singly linked list with same cirular doubly linked list compatible nodes\n");
		Node head2 = new Node(null, 0);
		for (int i = 0; i < 10; i++) {
			head2 = new Node(head2, i + 1);
		}
		
		// Printing singly linked list
		System.out.println("\nPrinting forward");
		head2.printForward();
		System.out.println();
		
		System.out.println("Printing backward");
		head2.printBackward();
		System.out.println();
		
		System.out.println("\nReversing list\n");
		head2 = Utils.reverseSingle(head2);
		
		System.out.println("Printing forward");
		head2.printForward();
		System.out.println();
		
		System.out.println("Printing backward");
		head2.printBackward();
		System.out.println();

	}
	

}
