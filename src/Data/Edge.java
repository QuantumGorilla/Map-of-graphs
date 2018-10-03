package Data;


/**
 *
 * @author Alejandro
 */
public class Edge {

    
    private Vertex origin, destiny;
    private int distance;

    public Edge(Vertex origin, Vertex destiny, int distance) {
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

    public Vertex getNodeOrigin() {
        return origin;
    }

    public void setNodeOrigin(Vertex origin) {
        this.origin = origin;
    }

    public Vertex getNodeDestiny() {
        return destiny;
    }

    public void setNodeDestiny(Vertex destiny) {
        this.destiny = destiny;
    }

}
