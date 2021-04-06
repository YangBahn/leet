package com.example.demo.memo_this.assorted;

import java.util.Arrays;

public class TicTacToe {

    public static void main(String[] args) {
        TicTacToe toe = new TicTacToe(3);

//        toe.move(1, 1, 1);
        toe.move(1, 2, 1);
        System.out.println(Arrays.toString(toe.rows));

        toe.move(1, 1, 1);
        System.out.println(Arrays.toString(toe.rows));
        ;
        toe.print();

//        System.out.println(winner);

    }


    private int rows[], cols[], diag, diagRev, len;

    public TicTacToe(int n) {
        this.rows = new int[n];
        this.cols = new int[n];
        this.len = n;
    }

    public int move(int row, int col, int player) {

        int add = player == 1 ? 1 : -1;
        rows[row] = rows[row] + add;
        cols[col] = cols[col] + add;

        if (row == col)
            diag += add;
        if (col == cols.length - row - 1)
            diagRev += add;

        if (rows[row] == len || cols[col] == len || diag == len || diagRev == len)
            return 1;

        if (rows[row] == -len || cols[col] == -len || diag == -len || diagRev == -len)
            return 2;

        return 0;
    }


    public void print() {


        for (int i = 0; i < len; i++) {

        }
    }

}
