import javafx.util.Pair;

import java.util.LinkedList;
import java.util.List;

/**
 * The type Hierarchical clustering.
 */
public class HierarchicalClustering {
    /**
     * The interface Linkage strategy.
     */
    public interface LinkageStrategy {
        /**
         * Calculating the distance between two clusters.
         *
         * @param c1 the first cluster
         * @param c2 the second cluster
         * @return the distance between the clusters.
         */
        Double distance(Cluster c1, Cluster c2);
    }

    private List<Cluster> clusters;
    private int requiredClusters;
    private LinkageStrategy strategy;


    /**
     * Instantiates a new Hierarchical clustering.
     *
     * @param points           the elements for clustering
     * @param requiredClusters the required number of clusters
     * @param strategy         the linkage strategy
     */
    public HierarchicalClustering(List<Point> points, int requiredClusters, LinkageStrategy strategy) {
        this.clusters = createInitialClusters(points);
        this.requiredClusters = requiredClusters;
        this.strategy = strategy;
    }

    /**
     * Gets clusters.
     *
     * @return the clusters
     */
    public List<Cluster> getClusters() {
        return this.clusters;
    }

    /**
     * Add cluster.
     *
     * @param c the c
     */
    public void addCluster(Cluster c) {
        this.clusters.add(c);
    }

    /**
     * Remove cluster.
     *
     * @param c the c
     */
    public void removeCluster(Cluster c) {
        this.clusters.remove(c);
    }

    /**
     * Run algorithm.
     */
    public void runAlgorithm() {
        while (this.clusters.size() > this.requiredClusters) {
            Pair<Cluster, Cluster> closestPair = this.closestPair();
            Cluster c1 = closestPair.getKey();
            Cluster c2 = closestPair.getValue();
            this.removeCluster(c1);
            this.removeCluster(c2);
            this.addCluster(Cluster.marge(c1, c2));
        }
    }

    private Pair<Cluster, Cluster> closestPair() {
        Cluster C1 = null;
        Cluster C2 = null;
        Double minDistance = Double.MAX_VALUE;
        for (Cluster c1 : this.clusters) {
            for (Cluster c2 : this.clusters) {
                if (c2 == c1) continue;
                Double distance = this.strategy.distance(c1, c2);
                if (distance < minDistance) {
                    C1 = c1;
                    C2 = c2;
                    minDistance = distance;
                }
            }
        }
        return new Pair<>(C1, C2);
    }

    /**
     * Create the initial clusters - each point is a cluster.
     *
     * @param points is the list of the given points.
     * @return the list of the cluster.
     */
    private List<Cluster> createInitialClusters(List<Point> points) {
        List<Cluster> clusters = new LinkedList<>();
        for (Point p : points) {
            Cluster c = new Cluster();
            c.addMember(p);
            clusters.add(c);
        }
        return clusters;
    }
}

