package nodes;

public class SquareNode {
	public int value;
	public int[] coord;
	
	public SquareNode up;
	public SquareNode down;
	public SquareNode left;
	public SquareNode right;
	
	public SquareNode(int value, int i, int j) {
		coord = new int[2];
		coord[0] = i;
		coord[1] = j;
		this.value = value;
		up = null;
		down = null;
		left = null;
		right = null;
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
	
	

}
