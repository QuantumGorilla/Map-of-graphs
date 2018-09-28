package Data;

/**
 *
 * @author Alejandro
 */
public class Relation {

    private Node a, b;
    private String distance;

    public Relation(Node a, Node b, String distance) {
        this.a = a;
        this.b = b;
        this.distance = distance;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public Node getNodeA() {
        return a;
    }

    public void setNodeA(Node a) {
        this.a = a;
    }

    public Node getNodeB() {
        return b;
    }

    public void setNodeB(Node b) {
        this.b = b;
    }

}
