package ua.edu.ukma.ykrukovska.warplane.model;

public class Plane {


    private int attitude;
    private int position;

    public Plane(int attitude, int position) {
        this.attitude = attitude;
        this.position = position;
    }

    /**
     * @return attitude of the plane
     */
    public int getAttitude() {
        return attitude;
    }

    /**
     * @param attitude set the attitude of the plane
     */
    public void setAttitude(int attitude) {
        this.attitude = attitude;
    }

    /**
     * @return gets the x coordinate of the plane
     */
    public int getPosition() {
        return position;
    }

    /**
     * @param position set the x coordinate of the plane
     */
    public void setPosition(int position) {
        this.position = position;
    }

}
