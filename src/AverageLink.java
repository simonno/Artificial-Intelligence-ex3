/**
 * The type Average link.
 */
public class AverageLink implements HierarchicalClustering.LinkageStrategy {
    /**
     * Calculating the distance between two clusters according to average link strategy.
     * <p>
     * average link: distance between two clusters is the average distance between
     * each pair of elements from the two clusters.
     * </p>
     *
     * @param c1 the first cluster
     * @param c2 the second cluster
     * @return the distance between two clusters according to average link strategy.
     */
    @Override
    public Double distance(Cluster c1, Cluster c2) {
        Double averageDistance = 0.0;
        int counter = 0;
        for (Point p1 : c1.getMembers()) {
            for (Point p2 : c2.getMembers()) {
                counter++;
                averageDistance += p1.distanceTo(p2);
            }
        }
        return averageDistance / counter;
    }
}
