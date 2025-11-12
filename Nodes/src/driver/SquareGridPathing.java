package driver;

import nodes.*;
import grids.SquareGrid;
import lists.DoublyLinked;

public class SquareGridPathing {
	private final static int ROWS = 15;
	private final static int COLS = 15;
	private static SquareGrid grid = new SquareGrid(ROWS, COLS);
	private static DoublyLinked<SquareNode> path = new DoublyLinked();
	private static SquareNode endPoint;
	private static SquareNode[][] gridArr = grid.getArr();

	public static void main(String[] args) {
		// Define start point. Adds as the first node in path list.
		path.append(grid.getNode(0,0));
		
		// Define end point.
		endPoint = grid.getNode(13, 14);
		
		// Define obstacles (non traversable tiles.)
		
		// Output starting grid. O for traversable, + for not traversable, X for path chosen.
		for (int r = 0; r < ROWS; r++) {
			for (int c = 0; c < COLS; c++) {
				if(gridArr[r][c] == path.getHead().getData()) {
					System.out.print("S");
				} else if (gridArr[r][c] == endPoint) {
					System.out.print("E");
				} else {
					System.out.print("O");
				}
			}
			System.out.println();
		}
		
		// Start finding path.
		findPath();
		
		// Output grid with path.
		path.nextNode(); // Makes current node not point to head.
		for (int r = 0; r < ROWS; r++) {
			for (int c = 0; c < COLS; c++) {
				if(gridArr[r][c] == path.getHead().getData()) {
					System.out.print("S");
				} else if (gridArr[r][c] == endPoint) {
					System.out.print("E");
				} else if (gridArr[r][c] == path.current().getData()) {
					System.out.print("X");
					path.nextNode(); // Advances the current node of the path list.
				}
				else {
					System.out.print("O");
				}
			}
			System.out.println();
		}
		
	}
	
	private static void findPath() {
		SquareNode next;
		do {
			next = findNext(); // Finds the next move.
			if (next == path.getTail().getData()) { // If the next move was to stay on the square, there must have been no traversable and unchecked square.
				path.getTail().getData().checked = true; // Squares are set to checked only when they are determined to have no next move.
				path.delTail(); // Removes the square from the list.
			}
		} while (path.getTail().getData() != endPoint);
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
				if (node.up.traversible && manDist(node.getUp()) < manDist(smallest) && !(node.checked)) {
					smallest = node.getUp();
				}
			} else if (node.down != null) {
				if (node.down.traversible && manDist(node.getDown()) < manDist(smallest) && !(node.checked)) {
					smallest = node.getDown();
				}
			} else if (node.left != null) {
				if (node.left.traversible && manDist(node.getLeft()) < manDist(smallest) && !(node.checked)) {
					smallest = node.getLeft();
				}
			} else if (node.right != null) {
				if (node.right.traversible && manDist(node.getRight()) < manDist(smallest) && !(node.checked)) {
					smallest = node.getRight();
				}
			}
		}
		return smallest;
	}
	
	// For convenience and to make sure I don't mistype it.
	public static SquareNode findNext() {
		return minManDist(path.getTail().getData());
	}

}
