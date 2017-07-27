package chapter08RecursionAndDynamicProgramming;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Problem: Write an algorithm to print all ways of arranging eight queens on a
 * 8*8 chess board so that none of them share the same row, column, or diagonal.
 * In this case, "diagonal" means all diagonals, not just the two that bisect
 * the board.
 *
 */
public class EightQueues {
	public List<Integer[]> set(int size) {
		Integer[] columns = new Integer[size];
		List<Integer[]> res = new ArrayList<>();
		placeQueens(0, columns, res, size);
		return res;
	}

	public void placeQueens(int row, Integer[] columns, List<Integer[]> res, int size) {
		if (row == size) {
			res.add(columns.clone());
		} else {
			for (int col = 0; col < size; col++) {
				if (checkValid(columns, row, col)) {
					columns[row] = col;
					placeQueens(row + 1, columns, res, size);
				}
			}
		}
	}

	/**
	 * Check if (row1, column1) is a valid spot for a queen by checking if there
	 * is a queen in the same column or diagonal. We don't need to check it for
	 * queens in the same row because the calling placeQueen only attempts to
	 * place one queen at a time. We know this row is empty.
	 */
	private boolean checkValid(Integer[] columns, int row1, int column1) {
		for (int row2 = 0; row2 < row1; row2++) {
			int column2 = columns[row2];
			if (column1 == column2) {
				return false;
			}
			// check diagonal
			int columnDistance = Math.abs(column2 - column1);
			int rowDistance = row1 - row2;
			if (columnDistance == rowDistance) {
				return false;
			}
		}
		return true;
	}
}
