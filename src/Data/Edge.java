package Data;


/**
 *
 * @author Alejandro
 */
public class Edge {

    
    private Node origin, destiny;
    private int distance;

    public Edge(Node origin, Node destiny, int distance) {
        this.origin = origin;
        this.destiny = destiny;
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Node getNodeOrigin() {
        return origin;
    }

    public void setNodeOrigin(Node origin) {
        this.origin = origin;
    }

    public Node getNodeDestiny() {
        return destiny;
    }

    public void setNodeDestiny(Node destiny) {
        this.destiny = destiny;
    }

}
