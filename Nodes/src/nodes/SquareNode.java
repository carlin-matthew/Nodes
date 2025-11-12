package nodes;

public class SquareNode {
	public int value; // For any value, such as a cost to traverse.
	public int x; // x coordinate/column
	public int y; // y coordinate/row
	public boolean traversible; // Can be used for path-finding algorithm to store whether a square can be traversed.
	public boolean checked; // Can be used for path-finding algorithm to store whether a square has been checked.
	
	
	public SquareNode up;
	public SquareNode down;
	public SquareNode left;
	public SquareNode right;
	
	public SquareNode(int value, int i, int j) {
		y = i;
		x = j;
		this.value = value;
		up = null;
		down = null;
		left = null;
		right = null;
		traversible = true; // Default is true.
		checked = false; // Default is false.
	}
	
	public void setUp(SquareNode node) {
		up = node;
	}
	
	public void setDown(SquareNode node) {
		down = node;
	}
	
	public void setLeft(SquareNode node) {
		left = node;
	}
	
	public void setRight(SquareNode node) {
		right = node;
	}
	
	public SquareNode getUp() {
		return up;
	}
	
	public SquareNode getDown() {
		return down;
	}
	
	public SquareNode getLeft() {
		return left;
	}
	
	public SquareNode getRight() {
		return right;
	}
	

}
