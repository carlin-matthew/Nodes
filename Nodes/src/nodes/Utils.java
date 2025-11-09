package nodes;

public class Utils {
	
	public static Node reverseSingle(Node head) {
		Node prev = null;
		Node curr = head;
		Node next;
		
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		
		return prev;
	}
	
	public static Node reverseDoubleCircle(Node curr) {
		if (curr == null) {
			return null;
		}
		Node start = curr;
		do {
			Node temp = curr.prev;		
			curr.prev = curr.next;
			curr.next = temp;
			curr = curr.prev;
		} while (curr != start);
		
		return curr.next;
	}
	

}
