package ua.edu.ukma.ykrukovska.TicTacToe;

public class TicTacToeModel {

    private int c11 = 0;
    private int c12 = 0;
    private int c13 = 0;
    private int c21 = 0;
    private int c22 = 0;
    private int c23 = 0;
    private int c31 = 0;
    private int c32 = 0;
    private int c33 = 0;

    private final static int CIRCLE = 1;
    private final static int CROSS = 4;

    private boolean isCircleTurn = true;

    // Set player 1 turn
    public boolean isCircleTurn() {
        return isCircleTurn;
    }

    // Set player 1 turn
    public void setCircleTurn(boolean circleTurn) {
        isCircleTurn = circleTurn;
    }

    // Method which switches players' turns
    public void changePlayer() {
        isCircleTurn = !isCircleTurn;
    }

    // Method which does the turn
    public void doTurn(int row, int column) {

        updateBoard(row, column);

    }

    // Checks if the winning combination was reached
    public int checkIfGameOver() {
        int isGameOver = 0;
        if (c11 + c12 + c13 == 3 || c11 + c12 + c13 == 12) {
            isGameOver = 1;
        } else if (c21 + c22 + c23 == 3 || c21 + c22 + c23 == 12) {
            isGameOver = 2;
        } else if (c31 + c32 + c33 == 3 || c31 + c32 + c33 == 12) {
            isGameOver = 3;
        } else if (c11 + c21 + c31 == 3 || c11 + c21 + c31 == 12) {
            isGameOver = 4;
        } else if (c12 + c22 + c32 == 3 || c12 + c22 + c32 == 12) {
            isGameOver = 5;
        } else if (c13 + c23 + c33 == 3 || c13 + c23 + c33 == 12) {
            isGameOver = 6;
        } else if (c11 + c22 + c33 == 3 || c11 + c22 + c33 == 12) {
            isGameOver = 7;
        } else if (c13 + c22 + c31 == 3 || c13 + c22 + c31 == 12) {
            isGameOver = 8;
        }
        return isGameOver;
    }

    // Updates the board after each turn
    private void updateBoard(int row, int column) {
        int currentSign = isCircleTurn ? CIRCLE : CROSS;
        if (row == 1 && column == 1) {
            c11 = currentSign;
        } else if (row == 1 && column == 2) {
            c12 = currentSign;
        } else if (row == 1 && column == 3) {
            c13 = currentSign;
        } else if (row == 2 && column == 1) {
            c21 = currentSign;
        } else if (row == 2 && column == 2) {
            c22 = currentSign;
        } else if (row == 2 && column == 3) {
            c23 = currentSign;
        } else if (row == 3 && column == 1) {
            c31 = currentSign;
        } else if (row == 3 && column == 2) {
            c32 = currentSign;
        } else if (row == 3 && column == 3) {
            c33 = currentSign;
        }
    }

    // Checks if the cell is empty
    public boolean isCellEmpty(int row, int column) {

        int currentValue = 0;
        if (row == 1 && column == 1) {
            currentValue = c11;
        } else if (row == 1 && column == 2) {
            currentValue = c12;
        } else if (row == 1 && column == 3) {
            currentValue = c13;
        } else if (row == 2 && column == 1) {
            currentValue = c21;
        } else if (row == 2 && column == 2) {
            currentValue = c22;
        } else if (row == 2 && column == 3) {
            currentValue = c23;
        } else if (row == 3 && column == 1) {
            currentValue = c31;
        } else if (row == 3 && column == 2) {
            currentValue = c32;
        } else if (row == 3 && column == 3) {
            currentValue = c33;
        }
        return currentValue == 0;

    }
}
