package ua.edu.ukma.ykrukovska.Breakout;

public class Constants {


    public static final int APPLICATION_WIDTH = 400;
    public static final int APPLICATION_HEIGHT = 600;
    public static final int WIDTH = APPLICATION_WIDTH;
    public static final int PADDLE_WIDTH = 60;
    public static final int PADDLE_HEIGHT = 10;
    public static final int PADDLE_Y_OFFSET = 30;
    public static final int NBRICKS_PER_ROW = 10;
    public static final int NBRICK_ROWS = 10;
    public static final int BRICK_SEP = 4;

    public static final int BRICK_WIDTH =
            (WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;

    public static final int BRICK_HEIGHT = 8;
    public static final int BALL_RADIUS = 10;
    public static final int BRICK_Y_OFFSET = 70;

    public static final int NTURNS = 3;

}