import java.util.LinkedList;
import java.util.List;

/**
 * The type Cluster.
 */
public class Cluster {
    private int number;
    private List<Point> members;

    /**
     * Instantiates a new Cluster.
     *
     * @param members the members
     */
    public Cluster(List<Point> members) {
        this.members = members;
    }

    /**
     * Instantiates a new Cluster.
     */
    public Cluster() {
        this.members = new LinkedList<>();
    }

    /**
     * Marge cluster.
     *
     * @param c1 the c 1
     * @param c2 the c 2
     * @return the cluster
     */
    public static Cluster marge(Cluster c1 , Cluster c2){
        List<Point> members1 = c1.getMembers();
        List<Point> members2 = c2.getMembers();
        members1.addAll(members2);
        return new Cluster(members1);
    }

    /**
     * Gets number.
     *
     * @return the number
     */
    public int getNumber() {
        return number;
    }

    /**
     * Sets number.
     *
     * @param number the number
     */
    public void setNumber(int number) {
        this.number = number;
        for (Point p : this.members) {
            p.setCluster(number);
        }
    }

    /**
     * Add member.
     *
     * @param p the p
     */
    public void addMember(Point p) {
        this.members.add(p);
    }

    /**
     * Remove member.
     *
     * @param p the p
     */
    public void removeMember(Point p) {
        this.members.remove(p);
    }

    /**
     * Is exist boolean.
     *
     * @param p the p
     * @return the boolean
     */
    public boolean isExist(Point p) {
        return this.members.contains(p);
    }


    /**
     * Gets members.
     *
     * @return the members
     */
    public List<Point> getMembers() {
        return this.members;
    }

}
