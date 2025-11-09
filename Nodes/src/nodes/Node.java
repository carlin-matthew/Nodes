package nodes;

public class Node {
	public int data;
	public Node prev;
	public Node next;
	
	public Node (Node next, int data) {
		this.next = next;
		this.data = data;
		this.prev = null;
	}
	
	public void printForward() {
		try {
			Node curr = this;
			do {
				System.out.printf("%d ", curr.data);
				curr = curr.next;
			} while (curr != this && curr != null);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}
	
	public void printBackward() {
		try {
			Node curr = this;
			do {
				System.out.printf("%d ", curr.data);
				curr = curr.prev;
			} while (curr != this && prev != null);
			if (curr == this.prev) {
				System.out.println("\nSingly linked list. Previous node does not exist.");
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String toString() {
		return "" + data;
	}
	

}
