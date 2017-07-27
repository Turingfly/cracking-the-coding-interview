package chapter08RecursionAndDynamicProgramming;

/**
 * 
 * Problem: Implement the "paint fill" function that one might see on many image
 * editing programs. That is, given a screen(represented by a two-dimensional
 * array of colors), a point, and a new color, fill in the surrounding area
 * until the color changes from the original color.
 *
 */
enum Color {
	Black, White, Red, Yellow, Green
}

public class PaintFill {
	public boolean paintFill(Color[][] screen, int row, int col, Color nColor) {
		if (screen[row][col] == nColor) {
			return false;
		}
		return helper(screen, row, col, screen[row][col], nColor);
	}

	private boolean helper(Color[][] screen, int row, int col, Color oColor, Color nColor) {
		if (row < 0 || row >= screen.length || col < 0 || col >= screen[0].length) {
			return false;
		}
		if (screen[row][col] == oColor) {
			screen[row][col] = nColor;
			helper(screen, row - 1, col, oColor, nColor); // up
			helper(screen, row + 1, col, oColor, nColor); // down
			helper(screen, row, col - 1, oColor, nColor); // left
			helper(screen, row, col + 1, oColor, nColor); // right
		}
		return true;
	}
}
