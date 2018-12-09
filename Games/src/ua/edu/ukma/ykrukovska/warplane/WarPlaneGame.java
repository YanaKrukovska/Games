package ua.edu.ukma.ykrukovska.warplane;

import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import ua.edu.ukma.ykrukovska.warplane.model.GameWorld;
import ua.edu.ukma.ykrukovska.warplane.model.Plane;
import ua.edu.ukma.ykrukovska.warplane.model.Target;

import java.awt.*;
import java.awt.event.KeyEvent;

import static ua.edu.ukma.ykrukovska.warplane.GameConstants.*;

/*Task: create a game where planes shoots targets on the ground.
 * Made by: Yana Krukovska
 * WarPlaneGame.java*/

public class WarPlaneGame extends GraphicsProgram {

    private GPlane plane;
    private GOval bomb;
    private GameWorld gameWorldModel;
    private GRect target1;
    private GRect target2;
    private GRect target3;
    private GRect target4;
    private GRect target5;


    public void run() {
        addKeyListeners(this);

        initModel();
        this.setSize(WORLD_WIDTH, WORLD_HEIGHT);
        GImage image = new GImage("C:\\IdeaProjects\\Games\\Games\\WarPlane.png ");
        image.setSize(WORLD_WIDTH, WORLD_HEIGHT);
        add(image, 0, 0);

        drawWorld();


        while (plane.getX() < WORLD_WIDTH) {
            plane.setLocation(plane.getX() + 1, plane.getY());
            gameWorldModel.move();
            pause(PLANE_DELAY);
            if (plane.getX() == WORLD_WIDTH) {
                plane.setLocation(-plane.getWidth(), getY());
            }
            gameWorldModel.getPlane().setAttitude((int) plane.getY());
            gameWorldModel.getPlane().setPosition((int) plane.getX());

            moveBombs();
            destroyTargets();

            if (isGameOver()) {
                GLabel label = new GLabel("You won. You used " + gameWorldModel.getBombCounter() + " bombs");
                label.setFont("Arial-20");
                label.setColor(Color.blue);
                add(label, WORLD_WIDTH / 2. - label.getWidth() / 2., WORLD_HEIGHT / 2.);
                break;
            }
        }


    }

    // Draws the plane.
    private void drawPlane() {
        plane = new GPlane(WORLD_WIDTH, WORLD_HEIGHT);
        add(plane);
    }

    // Checks if the game is over
    private boolean isGameOver() {
        return gameWorldModel.getT1() == null && gameWorldModel.getT2() == null && gameWorldModel.getT3() == null && gameWorldModel.getT4() == null && gameWorldModel.getT5() == null;
    }

    // Method which provides bombs' falling moves
    private void moveBombs() {
        if (gameWorldModel.getBomb() != null && bomb == null) {
            this.bomb = drawBomb();
            add(bomb);
        } else if (bomb != null && gameWorldModel.getBomb() != null) {
            bomb.setLocation(bomb.getX(), gameWorldModel.getBomb().getHeight());
        } else if (bomb != null && gameWorldModel.getBomb() == null) {
            bomb.setVisible(false);
            bomb = null;
        }
    }

    // Method which destroys target in case bomb touched them.
    private void destroyTargets() {
        if (gameWorldModel.getT1() != null && gameWorldModel.getT1().isDestroyed()) {
            target1.setVisible(false);
            gameWorldModel.addTarget1(null);
        }
        if (gameWorldModel.getT2() != null && gameWorldModel.getT2().isDestroyed()) {
            target2.setVisible(false);
            gameWorldModel.addTarget2(null);
        }
        if (gameWorldModel.getT3() != null && gameWorldModel.getT3().isDestroyed()) {
            target3.setVisible(false);
            gameWorldModel.addTarget3(null);
        }
        if (gameWorldModel.getT4() != null && gameWorldModel.getT4().isDestroyed()) {
            target4.setVisible(false);
            gameWorldModel.addTarget4(null);
        }
        if (gameWorldModel.getT5() != null && gameWorldModel.getT5().isDestroyed()) {
            target5.setVisible(false);
            gameWorldModel.addTarget5(null);
        }
    }

    // Method which draws the world
    private void drawWorld() {
        drawTargets();
        drawPlane();
    }

    // Method which draws the targets
    private void drawTargets() {
        target1 = new GRect(gameWorldModel.getT1().getTargetWidth(), gameWorldModel.getT1().getTargetHeight());
        target1.setFilled(true);
        target1.setFillColor(Color.gray);
        add(target1, gameWorldModel.getT1().getLocation(), WORLD_HEIGHT - gameWorldModel.getT1().getTargetHeight());

        target2 = new GRect(gameWorldModel.getT2().getTargetWidth(), gameWorldModel.getT2().getTargetHeight());
        target2.setFilled(true);
        target2.setFillColor(Color.lightGray);
        add(target2, gameWorldModel.getT2().getLocation(), WORLD_HEIGHT - gameWorldModel.getT2().getTargetHeight());

        target3 = new GRect(gameWorldModel.getT3().getTargetWidth(), gameWorldModel.getT3().getTargetHeight());
        target3.setFilled(true);
        target3.setFillColor(Color.darkGray);
        add(target3, gameWorldModel.getT3().getLocation(), WORLD_HEIGHT - gameWorldModel.getT3().getTargetHeight());

        target4 = new GRect(gameWorldModel.getT4().getTargetWidth(), gameWorldModel.getT4().getTargetHeight());
        target4.setFilled(true);
        target4.setFillColor(Color.black);
        add(target4, gameWorldModel.getT4().getLocation(), WORLD_HEIGHT - gameWorldModel.getT4().getTargetHeight());

        target5 = new GRect(gameWorldModel.getT5().getTargetWidth(), gameWorldModel.getT5().getTargetHeight());
        target5.setFilled(true);
        target5.setFillColor(Color.white);
        add(target5, gameWorldModel.getT5().getLocation(), WORLD_HEIGHT - gameWorldModel.getT5().getTargetHeight());
    }

    // Sets the location, height and width for targets and plane
    private void initModel() {
        gameWorldModel = new GameWorld();
        Plane planeModel = new Plane((int) (WORLD_HEIGHT * 0.8), 0);
        gameWorldModel.addPlane(planeModel);

        gameWorldModel.addTarget1(new Target(100, 100, 40));
        gameWorldModel.addTarget2(new Target(300, 50, 50));
        gameWorldModel.addTarget3(new Target(475, 80, 80));
        gameWorldModel.addTarget4(new Target(580, 20, 60));
        gameWorldModel.addTarget5(new Target(650, 33, 60));

    }

    // Key listener
    public void keyPressed(KeyEvent e) {
        gameWorldModel.addBomb();


    }

    // Draws the bomb
    private GOval drawBomb() {
        int bombX = (int) plane.getX() + 100;
        int bombY = (int) plane.getY() + 100;
        GOval bomb = new GOval(bombX, bombY, BOMB_SIZE, BOMB_SIZE);
        bomb.setFilled(true);
        bomb.setFillColor(Color.black);
        return bomb;
    }


}
