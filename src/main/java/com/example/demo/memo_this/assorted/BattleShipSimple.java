package com.example.demo.memo_this.assorted;

import java.util.Objects;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class BattleShipSimple {

	public static int numRows = 6;
	public static int numCols = 6;
	public static int computerShips;
	public static String[][] grid = new String[numRows][numCols];

	public static void createOceanMap() {
		//First section of Ocean Map
		out.print("  ");
		for (int i = 0; i < numCols; i++)
			out.print(i);
		out.println();

		//Middle section of Ocean Map
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				grid[i][j] = " ";
				if (j == 0)
					out.print(i + "|" + grid[i][j]);
				else if (j == grid[i].length - 1)
					out.print(grid[i][j] + "|" + i);
				else
					out.print(grid[i][j]);
			}
			out.println();
		}

		//Last section of Ocean Map
		out.print("  ");
		for (int i = 0; i < numCols; i++)
			out.print(i);
		out.println();
	}

	public static void deployComputerShips() {
		out.println("\nComputer is deploying ships");
		//Deploying five ships for computer
		BattleShipSimple.computerShips = 5;
		for (int i = 1; i <= BattleShipSimple.computerShips; 	i++) {
			int x = (int) (Math.random() * 10);
			int y = (int) (Math.random() * 10);

			if ((x >= 0 && x < numRows)
					&& (y >= 0 && y < numCols)
					&& (Objects.equals(grid[x][y], " "))) {
				grid[x][y] = "x";
				out.println(i + ". ship DEPLOYED");

			}
		}
//		printOceanMap();
	}

	public static void Battle() {
		playerTurn();
		printOceanMap();

		out.println();
		out.println("Computer ships left: " + BattleShipSimple.computerShips);
		out.println();
	}

	public static void playerTurn() {
		out.println("\nYOUR TURN");
		int x = -1, y = -1;
		do {
			Scanner input = new Scanner(in);
			out.print("Enter X coordinate: ");
			x = input.nextInt();
			out.print("Enter Y coordinate: ");
			y = input.nextInt();

			if ((x >= 0 && x < numRows) && (y >= 0 && y < numCols)) //valid guess
			{
				if (Objects.equals(grid[x][y], "x")) //if computer ship is already there; computer loses ship
				{
					out.println("Boom! You sunk the ship!");
					grid[x][y] = "!"; //Hit mark
					--BattleShipSimple.computerShips;
				} else if (Objects.equals(grid[x][y], " ")) {
					out.println("Sorry, you missed");
					grid[x][y] = "-";
				}
			} else if ((x < 0 || x >= numRows) || (y < 0 || y >= numCols))  //invalid guess
				out.println("You can't place ships outside the " + numRows + " by " + numCols + " grid");
		} while ((x < 0 || x >= numRows) || (y < 0 || y >= numCols));  //keep re-prompting till valid guess
	}

	public static void gameOver() {
		out.println("Game Finished Computer ships: " + BattleShipSimple.computerShips);
		out.println();
	}

	public static void printOceanMap() {
		out.println();
		//First section of Ocean Map
		out.print("  ");
		for (int i = 0; i < numCols; i++)
			out.print(i);
		out.println();

		//Middle section of Ocean Map
		for (int x = 0; x < grid.length; x++) {
			out.print(x + "|");

			for (int y = 0; y < grid[x].length; y++) {
				out.print(grid[x][y]);
			}

			out.println("|" + x);
		}

		//Last section of Ocean Map
		out.print("  ");
		for (int i = 0; i < numCols; i++)
			out.print(i);
		out.println();
	}

	public static void main(String[] args) {
		out.println("**** Welcome to Battle Ships game ****");
		out.println("Right now, sea is empty\n");

		createOceanMap();
		deployComputerShips();

		do {
			Battle();
		} while (BattleShipSimple.computerShips != 0);

		//Step 5 - Game over
		gameOver();
	}

}