package ua.edu.ukma.ykrukovska.warplane.model;

public class Target {

    private int location;
    private int targetHeight;
    private int targetWidth;
    private boolean destroyed = false;

    public boolean isDestroyed() {
        return destroyed;
    }

    public Target(int location, int targetHeight, int targetWidth) {
        this.location = location;
        this.targetHeight = targetHeight;
        this.targetWidth = targetWidth;
    }

    public int getLocation() {
        return location;
    }

    public int getTargetHeight() {
        return targetHeight;
    }

    public int getTargetWidth() {
        return targetWidth;
    }

    public void destroy() {
        this.destroyed = true;
    }
}
