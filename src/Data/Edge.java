package Data;

/**
 *
 * @author Alejandro
 */
public class Edge {

    private Vertex origin, destiny; //Vertice origen y destino
    private int distance; //Distancia entre un par de vertices

    /**
     * Constructor de la clase Edge
     *
     * @param origin, vertice origen
     * @param destiny, vertice destino
     * @param distance, distancia un par de vertices
     */
    public Edge(Vertex origin, Vertex destiny, int distance) {
        this.origin = origin;
        this.destiny = destiny;
        this.distance = distance;
    }

    /**
     * Obtiene distancia
     *
     * @return distancia
     */
    public int getDistance() {
        return distance;
    }

    /**
     * Coloca una distancia para una arista
     *
     * @param distance
     */
    public void setDistance(int distance) {
        this.distance = distance;
    }

    /**
     * Obtiene vertice origen
     *
     * @return vertice origen
     */
    public Vertex getOriginVertex() {
        return origin;
    }

    /**
     * Coloca el vertice origen para una arista
     *
     * @param origin, vertice origen
     */
    public void setVertexOrigin(Vertex origin) {
        this.origin = origin;
    }

    /**
     * Obtiene vertice destino
     *
     * @return vertice destino
     */
    public Vertex getDestinyVertex() {
        return destiny;
    }

    /**
     * Coloca vertice destino
     *
     * @param destiny, vertice destino
     */
    public void setVertexDestiny(Vertex destiny) {
        this.destiny = destiny;
    }

}
