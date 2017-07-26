package chapter08RecursionAndDynamicProgramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * Problem: Imagine a robot sitting on the upper left corner of grid with r rows
 * and c columns. The robot can only move in two directions, right and down, but
 * certain cells are "off limits" such that the robot cannot step on them.
 * Design an algorithm to find a path for the robot from the top left to the
 * bottom right.
 *
 */
public class RobotInAGrid {

	/**
	 * Method 1: Duplicate work
	 * 
	 * Time Complexity: O(2(r + c)). each path has r + c steps and there are two
	 * choices we can make at each step.
	 */

	public List<Point> getPath1(boolean[][] maze) {
		if (maze == null || maze.length == 0) {
			return null;
		}
		List<Point> res = new ArrayList<>();
		if (getPath1(maze, maze.length - 1, maze[0].length - 1, res)) {
			return res;
		}
		return null;
	}

	private boolean getPath1(boolean[][] maze, int row, int col, List<Point> path) {
		// out of bounds or not available
		if (!maze[row][col] || col < 0 || row < 0) {
			return false;
		}
		boolean isAtOrigin = (row == 0) && (col == 0);
		if (getPath1(maze, row, col - 1, path) || getPath1(maze, row - 1, col, path) || isAtOrigin) {
			Point p = new Point(row, col);
			path.add(p);
			return true;
		}
		return false;
	}

	/**
	 * Method 2:
	 * 
	 * Time Complexity: O(rc), we hit each cell just once.
	 */
	public List<Point> getPath2(boolean[][] maze) {
		if (maze == null || maze.length == 0) {
			return null;
		}
		List<Point> res = new ArrayList<>();
		Set<Point> failedPoints = new HashSet<>();
		if (getPath2(maze, maze.length - 1, maze[0].length - 1, res, failedPoints)) {
			return res;
		}
		return null;
	}

	private boolean getPath2(boolean[][] maze, int row, int col, List<Point> path, Set<Point> failedPoints) {
		// out of bounds or not available
		if (!maze[row][col] || col < 0 || row < 0) {
			return false;
		}
		Point p = new Point(row, col);
		if (failedPoints.contains(p)) {
			return false;
		}
		boolean isAtOrigin = (row == 0) && (col == 0);
		if (getPath2(maze, row, col - 1, path, failedPoints) || getPath2(maze, row - 1, col, path, failedPoints)
				|| isAtOrigin) {
			path.add(p);
			return true;
		}
		return false;
	}

}

class Point {
	int row;
	int col;

	public Point(int row, int col) {
		this.row = row;
		this.col = col;
	}

	@Override
	public String toString() {
		return "(" + row + "," + col + ")";
	}

	@Override
	public int hashCode() {
		return this.toString().hashCode();
	}

	@Override
	public boolean equals(Object o) {
		if ((o instanceof Point) && ((Point) o).row == this.row && ((Point) o).col == this.col) {
			return true;
		} else {
			return false;
		}
	}
}