package com.example.demo.assorted;


/*
Until arriving, do:
	check next path, return if arrived
	move next path
fail if can't do either above

Check Next isPath:
	both row & col in map and are OPEN

Check Arrived:
	both row & col are the last square and are OPEN

* */
public class RatMaze {

	static final int OPEN = 1;
	static final int CLOSED = 0;
	static final int MOVED = 11;

	static int[][] maze = {
			{1, 0, 0, 0},
			{1, 1, 0, 1},
			{0, 1, 0, 0},
			{1, 1, 1, 1}
	};

	static int mazeLen = maze.length;

	static boolean check(int[][] maze, int row, int column, int[][] record) {

		if (hasArrived(row, column)) {
			// at destination
			record[row][column] = MOVED;
			return true;
		} else if (isPath(maze, row, column)) {
			// continue
			return gotToNext(maze, row, column, record);
		} else {
			// blocked & can't move
			return false;
		}
	}

	static boolean gotToNext(int[][] maze, int row, int column, int[][] record) {
		// try forward or down
		if (check(maze, row + 1, column, record) || check(maze, row, column + 1, record)) {
			record[row][column] = MOVED; // move
			return true;
		} else {
			// blocked, backtrack
			record[row][column] = CLOSED;
			return false;
		}
	}

	static boolean hasArrived(int row, int y) {
		boolean atTheEndSquare = row == mazeLen - 1 && y == mazeLen - 1;
		return atTheEndSquare &&  maze[row][y] == OPEN;
	}

	static boolean isPath(int[][] maze, int x, int y) {
		// if (x, y outside maze) return false
		boolean xIsWithinBound = x >= 0 && x < mazeLen;
		boolean yIsWithinBound = y >= 0 && y < mazeLen;
		return xIsWithinBound && yIsWithinBound && maze[x][y] == OPEN;
	}

	static void printSolution(int[][] sol) {
		for (int i = 0; i < mazeLen; i++) {
			for (int j = 0; j < mazeLen; j++)
				System.out.print(
						" " + sol[i][j] + " ");
			System.out.println();
		}
	}


	public static void main(String[] args) {
		int[][] sol = new int[mazeLen][mazeLen];
		boolean isPassable = check(maze, 0, 0, sol);
		if (!isPassable) {
			System.out.print("Solution doesn't exist");
			return;
		}
		printSolution(sol);
	}
}