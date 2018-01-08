/**
 * The type Point.
 */
public class Point {
    private Double x;
    private Double y;
    private Integer cluster;

    /**
     * Instantiates a new Point.
     *
     * @param x the x coordinate
     * @param y the y coordinate
     */
    public Point(Double x, Double y) {
        this.x = x;
        this.y = y;
        this.cluster = null;

    }

    /**
     * Gets x.
     *
     * @return the x coordinate
     */
    public Double getX() {
        return x;
    }

    /**
     * Sets x.
     *
     * @param x the x coordinate
     */
    public void setX(Double x) {
        this.x = x;
    }

    /**
     * Gets y.
     *
     * @return the y coordinate
     */
    public Double getY() {
        return y;
    }

    /**
     * Sets y.
     *
     * @param y the y coordinate
     */
    public void setY(Double y) {
        this.y = y;
    }

    /**
     * Gets cluster.
     *
     * @return the number of cluster of this point
     */
    public Integer getCluster() {
        return this.cluster;
    }

    /**
     * Sets cluster.
     *
     * @param cluster the number of cluster of this point
     */
    public void setCluster(Integer cluster) {
        this.cluster = cluster;
    }

    /**
     * Distance between the points.
     *
     * @param p the point p.
     * @return the distance from this point to point p.
     */
    public Double distanceTo(Point p) {
        return Math.sqrt(Math.pow(this.x - p.x, 2) + Math.pow(this.y - p.y, 2));
    }
}
