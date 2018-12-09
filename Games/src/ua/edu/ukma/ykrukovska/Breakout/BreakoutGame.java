package ua.edu.ukma.ykrukovska.Breakout;

import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import acm.util.RandomGenerator;

import static ua.edu.ukma.ykrukovska.Breakout.Constants.*;

public class BreakoutGame extends GraphicsProgram {


    private double vx, vy;
    private GRect paddle;
    private GOval ball;
    private int ballCounter = 0;
    private int brickCounter;
    private RandomGenerator rgen = RandomGenerator.getInstance();

    public void run() {
        setUpWorld();
        gameplay();
    }

    private void gameplay() {
        while (ballCounter < NTURNS + 1) {
            setBall();
            ballMove();
            if (ballCounter == NTURNS && brickCounter != 0) {
                writeGameOver();
                break;
            }
            if (brickCounter <= 0) {
                writeYouWon();
                break;
            }
        }
    }


    private void writeYouWon() {
        GLabel youWon = new GLabel("You won", APPLICATION_WIDTH / 2., APPLICATION_HEIGHT / 2.);
        youWon.move(-youWon.getWidth() / 2, -youWon.getHeight());
        youWon.setColor(Color.green);
        add(youWon);
    }

    private void writeGameOver() {
        GLabel gameOver = new GLabel("Game Over", APPLICATION_WIDTH / 2., APPLICATION_HEIGHT / 2.);
        gameOver.move(-gameOver.getWidth() / 2, -gameOver.getHeight());
        gameOver.setColor(Color.RED);
        add(gameOver);
    }

    private void setUpWorld() {
        this.setSize(APPLICATION_WIDTH, APPLICATION_HEIGHT);
        setBricks();
        createPaddle();
        addMouseListeners(this);

    }

    private void createPaddle() {
        paddle = new GRect(WIDTH / 2., APPLICATION_HEIGHT - PADDLE_Y_OFFSET, PADDLE_WIDTH, PADDLE_HEIGHT);
        paddle.setFilled(true);
        paddle.setFillColor(Color.black);
        add(paddle);
    }


    private void setBall() {
        ballCounter++;
        double x = APPLICATION_WIDTH / 2. - BALL_RADIUS;
        double y = APPLICATION_HEIGHT / 2. - BALL_RADIUS;
        ball = new GOval(x, y, BALL_RADIUS, BALL_RADIUS);
        ball.setFilled(true);
        add(ball);


    }

    private GObject getCollidingObject() {
        if ((getElementAt(ball.getX(), ball.getY())) != null) {
            return getElementAt(ball.getX(), ball.getY());
        } else if (getElementAt((ball.getX() + BALL_RADIUS * 2), ball.getY()) != null) {
            return getElementAt(ball.getX() + BALL_RADIUS * 2, ball.getY());
        } else if (getElementAt(ball.getX(), (ball.getY() + BALL_RADIUS * 2)) != null) {
            return getElementAt(ball.getX(), ball.getY() + BALL_RADIUS * 2);
        } else if (getElementAt((ball.getX() + BALL_RADIUS * 2), (ball.getY() + BALL_RADIUS * 2)) != null) {
            return getElementAt(ball.getX() + BALL_RADIUS * 2, ball.getY() + BALL_RADIUS * 2);
        } else {
            return null;
        }
    }


    private void ballMove() {
        setBallSpeed();

        while (true) {

            ball.move(vx, vy);
            pause(8);


            if ((ball.getX() < 0) && vx < 0 || ball.getX() >= (APPLICATION_WIDTH - BALL_RADIUS) && vx > 0) {
                vx = -vx;
            }
            if (ball.getY() <= 0 && vy < 0) {
                vy = -vy;
            }
            if (ball.getY() + 2 * BALL_RADIUS > APPLICATION_HEIGHT) {
                ball.setVisible(false);
                break;
            }
            GObject collider = getCollidingObject();

            if (collider == paddle) {
                vy = -vy;
            } else if (collider != null) {
                remove(collider);
                if (--brickCounter <= 0) {
                    break;
                }
                vy = -vy;
            }


        }


    }


    private void setBallSpeed() {
        vy = 3.0;
        vx = rgen.nextDouble(1.0, 3.0);
        if (rgen.nextBoolean(0.5)) {
            vy = -vy;
        }

    }

    public void mouseDragged(MouseEvent e) {


        if (e.getX() > 0 && e.getX() + PADDLE_WIDTH < APPLICATION_WIDTH) {
            paddle.setLocation(e.getX(), APPLICATION_HEIGHT - PADDLE_Y_OFFSET);
        }


    }


    private void setBricks() {
        brickCounter = NBRICKS_PER_ROW * NBRICK_ROWS;
        for (int row = 1; row <= NBRICK_ROWS; row++) {
            for (int column = 1; column <= NBRICKS_PER_ROW; column++) {
                createBrick(row, column);
            }
        }
    }

    private void createBrick(int row, int column) {

        GRect brick = new GRect((BRICK_WIDTH + BRICK_SEP) * column - BRICK_WIDTH - BRICK_SEP / 2, (BRICK_HEIGHT + BRICK_SEP) * row + BRICK_Y_OFFSET, BRICK_WIDTH, BRICK_HEIGHT);
        setBrickColour(row, brick);
        add(brick);
    }

    private void setBrickColour(int i, GRect brick) {
        if (i == 1 || i == 2) {
            brick.setFilled(true);
            brick.setColor(Color.RED);
            brick.setFillColor(Color.RED);
        } else if (i == 3 || i == 4) {
            brick.setFilled(true);
            brick.setColor(Color.ORANGE);
            brick.setFillColor(Color.ORANGE);
        } else if (i == 5 || i == 6) {
            brick.setFilled(true);
            brick.setColor(Color.YELLOW);
            brick.setFillColor(Color.YELLOW);
        } else if (i == 7 || i == 8) {
            brick.setFilled(true);
            brick.setColor(Color.GREEN);
            brick.setFillColor(Color.GREEN);
        } else if (i == 9 || i == 10) {
            brick.setFilled(true);
            brick.setColor(Color.CYAN);
            brick.setFillColor(Color.CYAN);
        }
    }

}
