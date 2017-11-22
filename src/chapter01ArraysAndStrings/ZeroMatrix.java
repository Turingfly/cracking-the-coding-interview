package chapter01ArraysAndStrings;

/**
 * 
 * Problem: Write an algorithm such that if an element in an MxN matrix is 0,
 * its entire row and column are set to 0.
 *
 * Solution: We can reduce the space to O(1) by using the first row as a
 * replacement for the row array and the first column as a replacement for the
 * column array. This works as follows: 1. Check if the first row and first
 * column have any zeros, and set variables rowHasZero and columnHasZero. (We'll
 * nullify the first row and first column later, if necessary.) 2. Iterate
 * through the rest of the matrix, seeing matrix[i][0) and matrix[0) [j] to zero
 * whenever there's a zero in matrix[i][j]. 3. Iterate through rest of matrix,
 * nullifying row i if there's a zero in matrix[i][0]. 4. Iterate through rest
 * of matrix, nullifying column j if there's a zero in matrix[ 0][ j]. 5.
 * Nullify the first row and first column, if necessary (based on values from
 * Step 1).
 *
 */
public class ZeroMatrix {
	public void setZeros(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return;
		}
		boolean firstRow = false;
		boolean firstCol = false;
		// check if first col has a zero
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][0] == 0) {
				firstCol = true;
				break;
			}
		}
		// check if first row has a zero
		for (int i = 0; i < matrix[0].length; i++) {
			if (matrix[0][i] == 0) {
				firstRow = true;
				break;
			}
		}
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		// Nullify rows
		for (int i = 1; i < matrix.length; i++) {
			if (matrix[i][0] == 0) {
				nullifyRow(matrix, i);
			}
		}
		// Nullify cols
		for (int i = 1; i < matrix[0].length; i++) {
			if (matrix[0][i] == 0) {
				nullifyRow(matrix, i);
			}
		}
		if (firstRow) {
			nullifyRow(matrix, 0);
		}
		if (firstCol) {
			nullifyCol(matrix, 0);
		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	private void nullifyRow(int[][] matrix, int row) {
		for (int i = 0; i < matrix[0].length; i++) {
			matrix[row][i] = 0;
		}
	}

	private void nullifyCol(int[][] matrix, int col) {
		for (int i = 0; i < matrix.length; i++) {
			matrix[i][col] = 0;
		}
	}

	public static void main(String[] args) {
		ZeroMatrix matrix = new ZeroMatrix();
		int[][] matrix1 = { { 1, 2, 3 }, { 4, 0, 6 }, { 7, 8, 9 } };
		matrix.setZeros(matrix1);
	}
}
