package driver;

import nodes.*;
import grids.SquareGrid;
import lists.DoublyLinked;

public class SquareGridPathing {
	private static SquareGrid grid = new SquareGrid(15, 15);
	private static DoublyLinked<SquareNode> path = new DoublyLinked();
	private static SquareNode endPoint;

	public static void main(String[] args) {
		// Define start point. Adds as the first node in path list.
		path.append(grid.getNode(0,0));
		
		// Define end point.
		endPoint = grid.getNode(13, 14);
		
		// Define obstacles (non traversable tiles.)
		
		// Start finding path.
		findPath();
		
	}
	
	private static void findPath() {
		
	}
	
	private static int manDist(SquareNode from) {
		int x1, y1, x2, y2;
		x1 = path.getTail().getData().x;
		y1 = path.getTail().getData().y;
		x2 = endPoint.x;
		y2 = endPoint.y;
		
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}
	
	private static SquareNode minManDist(SquareNode node) {
		SquareNode smallest = node;
		for (int i = 0; i < 4; i++) {
			if (node.up != null) {
				if (node.up.traversible && manDist(node.getUp()) < manDist(smallest)) {
					smallest = node.getUp();
				}
			} else if (node.down != null) {
				if (node.down.traversible && manDist(node.getDown()) < manDist(smallest)) {
					smallest = node.getDown();
				}
			} else if (node.left != null) {
				if (node.left.traversible && manDist(node.getLeft()) < manDist(smallest)) {
					smallest = node.getLeft();
				}
			} else if (node.right != null) {
				if (node.right.traversible && manDist(node.getRight()) < manDist(smallest)) {
					smallest = node.getRight();
				}
			}
		}
		return smallest;
	}

}
