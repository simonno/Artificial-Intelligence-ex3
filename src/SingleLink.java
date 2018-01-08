/**
 * The type Single link.
 */
public class SingleLink implements HierarchicalClustering.LinkageStrategy {

    /**
     * Calculating the distance between two clusters according to single link strategy.
     * <p>
     * single link: distance between two clusters is the shortest distance
     * between a pair of elements from the two clusters.
     * </p>
     *
     * @param c1 the first cluster
     * @param c2 the second cluster
     * @return the distance between two clusters according to single link strategy.
     */
    @Override
    public Double distance(Cluster c1, Cluster c2) {
        Double minDistance = Double.MAX_VALUE;
        for (Point p1 : c1.getMembers()) {
            for (Point p2 : c2.getMembers()) {
                Double distance = p1.distanceTo(p2);
                if (distance < minDistance) {
                    minDistance = distance;
                }
            }
        }
        return minDistance;
    }
}
