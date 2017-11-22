package chapter01ArraysAndStrings;

/**
 * Problem: Rotate Matrix: Given an image represented by an NxN matrix, where
 * each pixel in the image is 4 bytes, write a method to rotate the image by 90
 * degrees. Can you do this in place?
 *
 */
public class RotateMatrix {
	public boolean rotate(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix.length != matrix[0].length)
			return false;
		int len = matrix.length;
		for (int layer = 0; layer < len / 2; layer++) {
			int first = layer;
			int last = len - 1 - layer;
			for (int i = first; i < last; i++) {
				int offset = i - first;
				int top = matrix[first][i];
				// left -> top
				matrix[first][i] = matrix[last - offset][first];
				// bottom -> left
				matrix[last - offset][first] = matrix[last][last - offset];
				// right -> bottom
				matrix[last][last - offset] = matrix[i][last];
				// top -> right
				matrix[i][last] = top;
			}
		}
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		return true;
	}

	public static void main(String[] args) {
		RotateMatrix rm = new RotateMatrix();
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		rm.rotate(matrix);
	}
}
