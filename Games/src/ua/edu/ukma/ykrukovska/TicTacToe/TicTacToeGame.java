package ua.edu.ukma.ykrukovska.TicTacToe;

import acm.graphics.GLabel;
import acm.graphics.GLine;
import acm.graphics.GOval;
import acm.program.GraphicsProgram;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TicTacToeGame extends GraphicsProgram implements MouseListener {

    private TicTacToeModel model = new TicTacToeModel();

    private final static int WORLD_WIDTH = 600;
    private final static int WORLD_HEIGHT = 600;
    private final static int CELL_SIZE = 200;
    private GLabel label;

    public void run() {

        drawBoard();
        label = new GLabel("");
        label.setFont("Chiller-36");
        add(label, 180, 300);
        addMouseListeners(this);
    }

    public void mouseClicked(MouseEvent e) {
        int column = e.getX() / CELL_SIZE + 1;
        int row = e.getY() / CELL_SIZE + 1;

        if (model.isCellEmpty(row, column) && model.checkIfGameOver() == 0) {
            if (model.isCircleTurn()) {

                drawZero(row, column);
            } else {
                drawCross(row, column);
            }
            model.doTurn(row, column);
            if (model.checkIfGameOver() > 0) {
                label.setLabel("Winner - player " + (model.isCircleTurn() ? "1" : "2"));
                gameOverLine();
            } else {
                model.changePlayer();

            }
        }
    }

    private void gameOverLine() {
        if (model.checkIfGameOver() == 1) {
            GLine line1 = new GLine(50, 100, 550, 100);
            add(line1);
        }
        if (model.checkIfGameOver() == 2) {
            GLine line1 = new GLine(50, 300, 550, 300);
            add(line1);
        }
        if (model.checkIfGameOver() == 3) {
            GLine line1 = new GLine(50, 500, 550, 500);
            add(line1);
        }
        if (model.checkIfGameOver() == 4) {
            GLine line1 = new GLine(100, 50, 100, 550);
            add(line1);
        }
        if (model.checkIfGameOver() == 5) {
            GLine line1 = new GLine(300, 50, 300, 550);
            add(line1);
        }
        if (model.checkIfGameOver() == 6) {
            GLine line1 = new GLine(500, 50, 500, 550);
            add(line1);
        }

        if (model.checkIfGameOver() == 7) {
            GLine line1 = new GLine(50, 100, 550, 550);
            add(line1);
        }
        if (model.checkIfGameOver() == 8) {
            GLine line1 = new GLine(550, 50, 50, 550);
            add(line1);
        }
    }

    private void drawZero(int row, int column) {
        GOval zero = new GOval(100, 100);
        add(zero, CELL_SIZE * (column - 1) + CELL_SIZE / 4., CELL_SIZE * (row - 1) + CELL_SIZE / 4.);

    }

    private void drawCross(int row, int column) {
        GLine xSide1 = new GLine((column - 1) * CELL_SIZE, (row - 1) * CELL_SIZE, column * CELL_SIZE, CELL_SIZE * row);

        GLine xSide2 = new GLine((column - 1) * CELL_SIZE, CELL_SIZE * row, column * CELL_SIZE, (row - 1) * CELL_SIZE);
        add(xSide1);
        add(xSide2);
    }

    private void drawBoard() {
        this.setSize(WORLD_WIDTH, WORLD_HEIGHT);
        GLine line1Vertical = new GLine(WORLD_WIDTH / 3., 0, WORLD_WIDTH / 3., WORLD_HEIGHT);
        add(line1Vertical);
        GLine line2Vertical = new GLine(WORLD_WIDTH / 1.5, 0, WORLD_WIDTH / 1.5, WORLD_HEIGHT);
        add(line2Vertical);
        GLine line1Horizontal = new GLine(0, WORLD_HEIGHT / 3., WORLD_WIDTH, WORLD_HEIGHT / 3.);
        add(line1Horizontal);
        GLine line2Horizontal = new GLine(0, WORLD_HEIGHT / 1.5, WORLD_WIDTH, WORLD_HEIGHT / 1.5);
        add(line2Horizontal);
    }

}


