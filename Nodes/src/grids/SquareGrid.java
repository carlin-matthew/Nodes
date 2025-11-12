package grids;

import nodes.SquareNode;

public class SquareGrid {
	private SquareNode[][] arr;
	private int rows, cols;
	
	public SquareGrid(int rows, int cols) {
		arr = new SquareNode[rows][cols];
		this.rows = rows;
		this.cols = cols;
		int i, j;
		int num = 0;
		
		for (i = 0; i < rows; i++) {
			for (j = 0; j < cols; j++, num++) {
				arr[i][j] = new SquareNode(num, i, j);
			}
		}

		for (i = 0; i < rows; i++) {
			for (j = 0; j < cols; j++) {
				if (i < rows - 1) arr[i][j].setDown(arr[i+1][j]);
				if (i > 0) arr[i][j].setUp(arr[i-1][j]);
				if (j > 0) arr[i][j].setLeft(arr[i][j-1]);
				if (j < cols - 1) arr[i][j].setRight(arr[i][j+1]);
			}
		}

	}
	
	public SquareNode getNode(int rowY, int colX) {
		return arr[rowY][colX];
	}

	public void printGrid() {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.printf("%3d ", arr[i][j].value);
			}
			System.out.println();
		}
	}
	
	public SquareNode[][] getArr() {
		return arr;
	}

}
