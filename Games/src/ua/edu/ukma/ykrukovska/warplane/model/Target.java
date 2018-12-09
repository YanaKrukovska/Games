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

    /**
     * @return location of the target (x)
     */
    public int getLocation() {
        return location;
    }

    /**
     * @return height of the target
     */
    public int getTargetHeight() {
        return targetHeight;
    }

    /**
     * @return width of the target
     */
    public int getTargetWidth() {
        return targetWidth;
    }

    // sets state of the target - destroyed
    public void destroy() {
        this.destroyed = true;
    }
}
