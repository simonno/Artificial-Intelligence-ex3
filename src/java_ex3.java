//C:\Users\simon\IdeaProjects\artificial intelligence\ex1\input files\

import java.io.*;
import java.util.LinkedList;
import java.util.List;

import static java.lang.System.exit;

/**
 * The type Search algorithms.
 */
public class java_ex3 {

    private static String fileName;
    private static HierarchicalClustering.LinkageStrategy strategy;
    private static int numberOfCluster;


    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        fileName = "input.txt";
        List<Point> points = parseFile();
        HierarchicalClustering clustering = new HierarchicalClustering(points, numberOfCluster, strategy);
        clustering.runAlgorithm();
        List<Cluster> clusters = clustering.getClusters();
        writeToOutputFile(parseSolution(clusters, points));
    }

    /**
     * Parse the solution.
     * <p>
     * running over the point check the their clusters and numerator the clusters
     * in ascending order according to the point order.
     * The cluster which holds the first point will be cluster 1.
     * The cluster which holds the next point (which not belongs to cluster 1)  will be cluster 2, and so on.
     * <p>
     *
     * @param clusters the list of the cluster
     * @param points   the list of the point
     * @return the string of the solution - which cluster each point belongs.
     */
    private static String parseSolution(List<Cluster> clusters, List<Point> points) {
        // numerator the clusters
        int clusterNumber = 1;
        for (Point p : points) {
            if (p.getCluster() == null) {
                for (Cluster c : clusters) {
                    if (c.isExist(p)) {
                        c.setNumber(clusterNumber);
                        clusters.remove(c);
                        clusterNumber++;
                        break;
                    }
                }
            }

        }

        // built the solution string.
        StringBuilder solution = new StringBuilder();
        for (Point p : points) {
            solution.append(p.getCluster().toString()).append("\n");
        }
        return solution.toString();
    }



    /**
     * Write the solution to the file
     *
     * @param solution is the solution of the search.
     */
    private static void writeToOutputFile(String solution) {
        try {
            File statText = new File("output.txt");
            FileOutputStream is = new FileOutputStream(statText);
            OutputStreamWriter osw = new OutputStreamWriter(is);
            Writer w = new BufferedWriter(osw);
            w.write(solution);
            w.close();
        } catch (IOException e) {
            System.err.println("Problem writing to the file output.txt");
        }
    }

    /**
     * Parse the input file.
     *
     * @return list of the points.
     */
    private static List<Point> parseFile() {
        List<Point> points = null;
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            // read the linkage strategy
            String strategyString = br.readLine();
            if (strategyString.matches("single link")) {
                strategy = new SingleLink();
            } else {
                strategy = new AverageLink();
            }

            // read the number of required clusters
            numberOfCluster = Integer.parseInt(br.readLine());

            //read the points coordinates.
            points = new LinkedList<>();
            String line;
            while ((line = br.readLine()) != null) {
                String[] coordinates = line.split(",");
                Double x = Double.parseDouble(coordinates[0]);
                Double y = Double.parseDouble(coordinates[1]);
                points.add(new Point(x, y));
            }

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
            exit(1);
        }
        return points;
    }
}
