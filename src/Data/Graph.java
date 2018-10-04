package Data;

import java.util.ArrayList;

/**
 *
 * @author Alejandro
 */
public class Graph {

    public final static int INF = 99999;
    private ArrayList<Vertex> vertex = new ArrayList<>();
    private ArrayList<Edge> edges = new ArrayList<>();

    public void addVertex(Vertex v) {
        vertex.add(v);
    }

    public ArrayList<Vertex> getVertexList() {
        return vertex;
    }

    public void addEdge(Edge e) {
        edges.add(e);
    }

    public ArrayList<Edge> getEdgesList() {
        return edges;
    }

    public int checkVertexList(Vertex v) {
        for (Vertex e : vertex) {
            if (v.getCity().equalsIgnoreCase(e.getCity())) {
                return -1;
            }
        }
        return 1;
    }

    public int deleteVertex(String ans) {
        int i = 0;
        for (Vertex v : vertex) {
            if (v.getCity().equalsIgnoreCase(ans)) {
                vertex.remove(i);
                return i;
            }
            i++;
        }
        return -1;
    }

    public void deleteEdge(String ans) {
        int i = 0;
        for (Edge e : edges) {
            if (e.getNodeOrigin().getCity().equalsIgnoreCase(ans) || e.getNodeDestiny().getCity().equalsIgnoreCase(ans)) {
                edges.remove(i);
            }
            i++;
        }
    }

    public int[][] getDistanceMatrix(ArrayList<Vertex> vertex, ArrayList<Edge> edges) {
        int matrix[][] = new int[vertex.size()][vertex.size()];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (i == j) {
                    matrix[i][j] = 0;
                } else {
                    matrix[i][j] = INF;
                }
            }
        }
        edges.forEach((edge) -> {
            matrix[vertex.indexOf(edge.getNodeOrigin())][vertex.indexOf(edge.getNodeDestiny())] = edge.getDistance();
        });
        return matrix;
    }

    public void floyd(int[][] adj) {
        for (int k = 0; k < adj.length; k++) {
            for (int i = 0; i < adj.length; i++) {
                for (int j = 0; j < adj.length; j++) {
                    if (adj[i][k] + adj[k][j] < adj[i][j]) {
                        adj[i][j] = adj[i][k] + adj[k][j];
                    }
                }
            }
        }
    }

}
