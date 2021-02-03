package com.example.demo.memo_this.assorted;


// A simple program to demonstrate
// Tic-Tac-Toe Game.

import java.util.Arrays;
import java.util.Scanner;

class TicTac {
	private static final int len = 3;
	private static String[][] board;
	private static String turn;

	private static InputProcessor inputProcessor;

	public static void main(String[] args) {
		GameStarter starter = new GameStarter();
		starter.start();
	}

	private static class GameStarter {

		GameStarter() {
			init();
		}

		private void init() {
			//init
			inputProcessor = new InputProcessor();
			board = new String[3][3];
			turn = "X";

			for (int i = 0; i < len; i++) {
				String[] rowArr = new String[len];
				for (int j = 0; j < len; j++) {
					int value = j;
					if (i > 0) {
						value = i * len + j;
					}
					rowArr[j] = String.valueOf(value);
				}
				board[i] = rowArr;
			}

			System.out.println("Welcome to 3x3 Tic Tac Toe.");
			Printer.printBoard();
			System.out.println("X will play first. Enter a slot number to place X in:");
		}


		void start() {
			String winner = null;
			while (winner == null) {
				winner = inputProcessor.takeInput();
			}

			// If no one win or lose from both player x and O.
			// then here is the logic to print "draw".
			if (winner.equalsIgnoreCase("draw")) {
				System.out.println(
						"It's a draw! Thanks for playing.");
			}

			// For winner -to display Congratulations! message.
			else {
				System.out.println(
						"Congratulations! " + winner
								+ "'s have won! Thanks for playing.");
			}
		}
	}


	private static class WinnerChecker {
		static String winner = null;

		private static String check() {
			for (int a = 0; a < 8; a++) {
				String line = null;

//				switch (a) {
//					case 0:
//						line = board[0] + board[1] + board[2];
//						break;
//					case 1:
//						line = board[3] + board[4] + board[5];
//						break;
//					case 2:
//						line = board[6] + board[7] + board[8];
//						break;
//					case 3:
//						line = board[0] + board[3] + board[6];
//						break;
//					case 4:
//						line = board[1] + board[4] + board[7];
//						break;
//					case 5:
//						line = board[2] + board[5] + board[8];
//						break;
//					case 6:
//						line = board[0] + board[4] + board[8];
//						break;
//					case 7:
//						line = board[2] + board[4] + board[6];
//						break;
//				}
				//For X winner
				if (line.equals("XXX")) {
					return "X";
				}

				// For O winner
				else if (line.equals("OOO")) {
					return "O";
				}
			}

			for (int a = 0; a < 9; a++) {
				if (Arrays.asList(board).contains(
						String.valueOf(a + 1))) {
					break;
				} else if (a == 8) {
					return "draw";
				}
			}

			// To enter the X Or O at the exact place on board.
			System.out.println(turn + "'s turn; enter a slot number to place " + turn + " in:");
			return winner;
		}

	}


	private static class InputProcessor {
		private final Scanner inputScanner;

		InputProcessor() {
			inputScanner = new Scanner(System.in);
		}

		// TODO
		private String takeInput() {
//			int numInput = inputScanner.nextInt();
//			validateInput(numInput);
//			// This game has two player x and O.
//			// Here is the logic to decide the turn.
//			if (board[numInput - 1].equals(
//					String.valueOf(numInput))) {
//				board[numInput - 1] = turn;
//
//				if (turn.equals("X")) {
//					turn = "O";
//				} else {
//					turn = "X";
//				}
//
//				Printer.printBoard();
//				return WinnerChecker.check();
//			} else {
//				System.out.println(
//						"Slot already taken; re-enter slot number:");
//				return "";
//			}
			return null;
		}

		private void validateInput(int numInput) {
			boolean inputValid = false;
			int badInputCounter = 0;
			while (!inputValid && badInputCounter < 4) {
				// must be 0 - 9
				if (numInput > -1 && numInput < 10) {
					inputValid = true;
					badInputCounter = 0;
				} else {

					if (badInputCounter == 3) {
						System.out.println("If you don't know how to make an invalid input, there is no point. Bye~");
						return;
					}
					badInputCounter++;
					System.out.println("Invalid input; re-enter slot number between 0 - 9");
				}
			}
		}

	}


	private static class Printer {
		private static void printBoard() {
			for (String[] row : board) {
				for (String val : row) {
					System.out.print("\t[" + val + "]");
				}
				System.out.println();
			}
			System.out.println();
		}
	}
}
