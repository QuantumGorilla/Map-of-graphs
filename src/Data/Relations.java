package Data;

/**
 *
 * @author Alejandro
 */
public class Relations {

    private Node a, b;
    private int distance;

    public Relations(Node a, Node b, int distance) {
        this.a = a;
        this.b = b;
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
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
