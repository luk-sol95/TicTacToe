package com.soltys;

public class TicTacToeLogic {

    private int currentPlayer;
    private char[][] board;
    private static final char X = 'X';
    private static final char O = 'O';
    private int turnCounter = 0;

    public TicTacToeLogic(int startingPlayer) {
        if (startingPlayer > 2 || startingPlayer < 1) {
            this.currentPlayer = 1;
        } else {
            this.currentPlayer = startingPlayer;
        }
        board = new char[3][3];
        reset();

    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public void reset() {
        for (int i = 0; i < 3; i++) {
            for (int u = 0; u < 3; u++) {
                board[i][u] = '-';
            }
        }
        turnCounter = 0;
    }

    public boolean move(int row, int column) {
        char sign = ' ';
        switch (currentPlayer) {
            case 1:
                sign = 'X';
                break;
            case 2:
                sign = 'O';
        }


        if (board[row][column] == '-') {
            board[row][column] = sign;
            swapPlayers();
            turnCounter += 1;
            return true;

        } else
            return false;
    }

    private void swapPlayers() {
        if (currentPlayer == 1) {
            currentPlayer = 2;
        } else currentPlayer = 1;
    }

    public boolean isFinished() {
        if (turnCounter >= 9) {
            return true;
        }
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == board[i][1] && board[i][1] == board[i][2]) && (board[i][2] == 'X' || board[i][2] == 'O') ) {
                return true;
            } else if ((board[0][i] == board[1][i] && board[1][i] == board[2][i]) && (board[0][i] == 'X' || board[0][i] == 'O')) {
                return true;
            }
        }
        if ((board[0][0] == board [1][1] && board[1][1] == board [2][2]) && (board[1][1] == 'X' || board[1][1] == 'O')) {
            return true;
        } else
            return (board[2][0] == board[1][1] && board[1][1] == board[0][2]) && (board[0][2] == 'X' || board[0][2] == 'O');

    }

    public void printBoard () {
        for (int i = 0; i <3; i++) {
            for (int u = 0; u < 3; u++) {
                System.out.print(board[i][u]);
            }
            System.out.println();
        }
    }

}






