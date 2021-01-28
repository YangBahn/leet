package com.example.demo.memo_this.assorted;

import java.util.Objects;
import java.util.Scanner;

import static java.lang.System.*;

 class BattleShip {

	public static int numRows = 10;
	public static int numCols = 10;
	public static int playerShips;
	public static int computerShips;
	public static String[][] grid = new String[numRows][numCols];
	public static int[][] missedGuesses = new int[numRows][numCols];


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

	public static void deployPlayerShips() {
		Scanner input = new Scanner(in);

		out.println("\nDeploy your ships:");
		//Deploying five ships for player
		BattleShip.playerShips = 5;
		for (int i = 1; i <= BattleShip.playerShips; ) {
			out.print("Enter X coordinate for your " + i + " ship: ");
			int x = input.nextInt();
			out.print("Enter Y coordinate for your " + i + " ship: ");
			int y = input.nextInt();

			if ((x >= 0 && x < numRows) && (y >= 0 && y < numCols) && (grid[x][y] == " ")) {
				grid[x][y] = "@";
				i++;
			} else if ((x >= 0 && x < numRows) && (y >= 0 && y < numCols) && grid[x][y] == "@")
				out.println("You can't place two or more ships on the same location");
			else if ((x < 0 || x >= numRows) || (y < 0 || y >= numCols))
				out.println("You can't place ships outside the " + numRows + " by " + numCols + " grid");
		}
		printOceanMap();
	}

	public static void deployComputerShips() {
		out.println("\nComputer is deploying ships");
		//Deploying five ships for computer
		BattleShip.computerShips = 5;
		for (int i = 1; i <= BattleShip.computerShips; ) {
			int x = (int) (Math.random() * 10);
			int y = (int) (Math.random() * 10);

			if ((x >= 0 && x < numRows) && (y >= 0 && y < numCols) && (grid[x][y] == " ")) {
				grid[x][y] = "x";
				out.println(i + ". ship DEPLOYED");
				i++;
			}
		}
		printOceanMap();
	}

	public static void Battle() {
		playerTurn();
//		computerTurn();

		printOceanMap();

		out.println();
		out.println("Your ships: " + BattleShip.playerShips + " | Computer ships: " + BattleShip.computerShips);
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
				if (grid[x][y] == "x") //if computer ship is already there; computer loses ship
				{
					out.println("Boom! You sunk the ship!");
					grid[x][y] = "!"; //Hit mark
					--BattleShip.computerShips;
				} else if (grid[x][y] == "@") {
					out.println("Oh no, you sunk your own ship :(");
					grid[x][y] = "x";
					--BattleShip.playerShips;
					++BattleShip.computerShips;
				} else if (grid[x][y] == " ") {
					out.println("Sorry, you missed");
					grid[x][y] = "-";
				}
			} else if ((x < 0 || x >= numRows) || (y < 0 || y >= numCols))  //invalid guess
				out.println("You can't place ships outside the " + numRows + " by " + numCols + " grid");
		} while ((x < 0 || x >= numRows) || (y < 0 || y >= numCols));  //keep re-prompting till valid guess
	}

//	public static void computerTurn() {
//		out.println("\nCOMPUTER'S TURN");
//		//Guess co-ordinates
//		int x = -1, y = -1;
//		do {
//			x = (int) (Math.random() * 10);
//			y = (int) (Math.random() * 10);
//
//			if ((x >= 0 && x < numRows) && (y >= 0 && y < numCols)) //valid guess
//			{
//				if (Objects.equals(grid[x][y], "@")) //if player ship is already there; player loses ship
//				{
//					out.println("The Computer sunk one of your ships!");
//					grid[x][y] = "x";
//					--BattleShip.playerShips;
//					++BattleShip.computerShips;
//				} else if (Objects.equals(grid[x][y], "x")) {
//					out.println("The Computer sunk one of its own ships");
//					grid[x][y] = "!";
//				} else if (grid[x][y] == " ") {
//					out.println("Computer missed");
//					//Saving missed guesses for computer
//					if (missedGuesses[x][y] != 1)
//						missedGuesses[x][y] = 1;
//				}
//			}
//		} while ((x < 0 || x >= numRows) || (y < 0 || y >= numCols));  //keep re-prompting till valid guess
//	}

	public static void gameOver() {
//		out.println("Your ships: " + BattleShip.playerShips + " | Computer ships: " + BattleShip.computerShips);
		out.println("Game Finished Computer ships: " + BattleShip.computerShips);
//		if (BattleShip.playerShips > 0 && BattleShip.computerShips <= 0)
//			out.println("Hooray! You won the battle :)");
//		else
//			out.println("Sorry, you lost the battle");
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

		//Step 1 – Create the ocean map
		createOceanMap();

//		//Step 2 – Deploy player’s ships
//		deployPlayerShips();

		//Step 3 - Deploy computer's ships
		deployComputerShips();

		//Step 4 Battle
		do {
			Battle();
		} while (BattleShip.playerShips != 0 && BattleShip.computerShips != 0);

		//Step 5 - Game over
		gameOver();
	}

}