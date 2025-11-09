package driver;

import lists.*;


public class Driver {

	public static void main(String[] args) {
		

		System.out.print(""); // To open console.
		SinglyLinked<Integer> slList = new SinglyLinked<>();
		for (int i = 0; i < 1000000; i++) {
			slList.append(i);
		}
		
		slList.printList();
		System.out.println("\n" + slList.length);
		
		
		
		/*Node head = new Node(null, 0);
		Node temp = head;
		
		for (int i = 0; i < 10; i++) {
			head = new Node(head, i + 1);
			head.next.prev = head;
		}
		head.prev = temp;
		temp.next = head;
		
		
		*/

	}
	

}
