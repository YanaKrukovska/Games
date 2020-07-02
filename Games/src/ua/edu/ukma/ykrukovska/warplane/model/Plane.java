package ua.edu.ukma.ykrukovska.warplane.model;

public class Plane {

    private int attitude;
    private int position;

    public Plane(int attitude, int position) {
        this.attitude = attitude;
        this.position = position;
    }

    public int getAttitude() {
        return attitude;
    }

    public void setAttitude(int attitude) {
        this.attitude = attitude;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

}
