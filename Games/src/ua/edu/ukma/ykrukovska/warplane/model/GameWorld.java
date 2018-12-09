package ua.edu.ukma.ykrukovska.warplane.model;

import static ua.edu.ukma.ykrukovska.warplane.GameConstants.BOMB_SIZE;
import static ua.edu.ukma.ykrukovska.warplane.GameConstants.WORLD_HEIGHT;

public class GameWorld {

    private Target t1;
    private Target t2;
    private Target t3;
    private Target t4;
    private Target t5;
    private int bombCounter = 0;
    private Plane plane;
    private Bomb bomb;

    /**
     * @return counter of amount of bombs.
     */
    public int getBombCounter() {
        return bombCounter;
    }

    /**
     * @param planeModel all the parametrs of the plane
     */
    public void addPlane(Plane planeModel) {
        this.plane = planeModel;
    }

    /**
     * @return model of the plane
     */
    public Plane getPlane() {
        return plane;
    }

    /**
     * @param t1 target #1
     */
    public void addTarget1(Target t1) {
        this.t1 = t1;
    }

    /**
     * @param t2 target #2
     */
    public void addTarget2(Target t2) {
        this.t2 = t2;
    }

    /**
     * @param t3 target #3
     */
    public void addTarget3(Target t3) {
        this.t3 = t3;
    }

    /**
     * @param t4 target #4
     */
    public void addTarget4(Target t4) {
        this.t4 = t4;
    }

    /**
     * @param t5 target #5
     */
    public void addTarget5(Target t5) {
        this.t5 = t5;
    }

    /**
     * @return target #1
     */
    public Target getT1() {
        return t1;
    }

    /**
     * @return target #2
     */
    public Target getT2() {
        return t2;
    }

    /**
     * @return target #3
     */
    public Target getT3() {
        return t3;
    }

    /**
     * @return target #4
     */
    public Target getT4() {
        return t4;
    }

    /**
     * @return target #5
     */
    public Target getT5() {
        return t5;
    }

    /**
     * @return
     */
    public Bomb getBomb() {
        return bomb;
    }

    // Method which creates a bomb
    public void addBomb() {
        if (bomb == null) {
            bomb = new Bomb(plane.getPosition() + 100, plane.getAttitude() + 100);
            bombCounter++;
        }
    }

    // Method which provides bomb's falling and it destroying the target.
    public void move() {
        calculateNewBombPosition();
        checkIfTargetsDestroyed();
    }

    // Checks if the target must be destroyed or not.
    private void checkIfTargetsDestroyed() {
        if (t1 != null && bomb != null && matchX(t1) && matchY(t1)) {
            t1.destroy();
            bomb = null;
        }
        if (t2 != null && bomb != null && matchX(t2) && matchY(t2)) {
            t2.destroy();
            bomb = null;

        }
        if (t3 != null && bomb != null && matchX(t3) && matchY(t3)) {
            t3.destroy();
            bomb = null;

        }
        if (t4 != null && bomb != null && matchX(t4) && matchY(t4)) {
            t4.destroy();
            bomb = null;

        }
        if (t5 != null && bomb != null && matchX(t5) && matchY(t5)) {
            t5.destroy();
            bomb = null;

        }

    }

    // Checks if y coordinate of bombs matches y coordinate of target.
    private boolean matchY(Target target) {
        return WORLD_HEIGHT - target.getTargetHeight() <= bomb.getHeight() + BOMB_SIZE;

    }

    // Checks if x coordinate of bombs matches x coordinate of target.
    private boolean matchX(Target target) {
        return bomb.getLocation() + BOMB_SIZE >= target.getLocation() &&
                bomb.getLocation() <= target.getLocation() + target.getTargetWidth();
    }

    // Calculates new position for bomb when it's falling.
    private void calculateNewBombPosition() {
        if (bomb != null && bomb.getHeight() + BOMB_SIZE < WORLD_HEIGHT) {
            bomb.setHeight(bomb.getHeight() + 1);
        } else {
            bomb = null;
        }
    }


}
