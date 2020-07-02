package ua.edu.ukma.ykrukovska.warplane.model;

public class Bomb {

    private int height;
    private int location;

    public Bomb(int location, int height) {
        this.height = height;
        this.location = location;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public int getLocation() {
        return location;
    }
}
