// src/main/java/com/example/demo/TicTacToeGame.java
package com.example.demo;

public class TicTacToeGame {
    private char[][] board = new char[3][3];
    private char currentPlayer = 'X';
    private String winner = null;

    public TicTacToeGame() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                board[i][j] = ' ';
    }

    public char[][] getBoard() { return board; }
    public char getCurrentPlayer() { return currentPlayer; }
    public String getWinner() { return winner; }

    public boolean makeMove(int row, int col) {
        if (winner != null || board[row][col] != ' ') return false;
        board[row][col] = currentPlayer;
        if (checkWinner()) {
            winner = String.valueOf(currentPlayer);
        } else if (isDraw()) {
            winner = "Draw";
        } else {
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
        return true;
    }

    private boolean checkWinner() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) return true;
            if (board[0][i] != ' ' && board[0][i] == board[1][i] && board[1][i] == board[2][i]) return true;
        }
        if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) return true;
        if (board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) return true;
        return false;
    }

    private boolean isDraw() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[i][j] == ' ') return false;
        return true;
    }

    public void reset() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                board[i][j] = ' ';
        currentPlayer = 'X';
        winner = null;
    }
}