package nodes;

public class Node<T> {
	public T data;
	public Node<T> prev;
	public Node<T> next;
	
	public Node (T data) {
		this.data = data;
		this.prev = null;
	}
	
	public void setPrev(Node<T> node) {
		this.prev = node;
	}
	
	public void setNext(Node<T> node) {
		this.next = node;
	}
	
	public void print() {
		System.out.printf("%s ", data);
	}
	
	public T getData() {
		return data;
	}
	
	/*
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
	*/
	

}
