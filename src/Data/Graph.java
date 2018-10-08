package Data;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Alejandro
 */
public class Graph {

    public final static int INF = 99999;
    public ArrayList<Vertex> vertex = new ArrayList<>();
    public ArrayList<Edge> edges = new ArrayList<>();

    public void addVertex(Vertex v) {
        vertex.add(v);
    }

    public void addEdge(Edge e) {
        edges.add(e);
    }

    public int checkVertexList(Vertex v) {
        for (Vertex e : vertex) {
            if (v.getCity().equalsIgnoreCase(e.getCity())) {
                return -1;
            }
        }
        return 1;
    }

    public void deleteVertex(String ans) {
        for (int i = 0; i < vertex.size(); i++) {
            if (ans.equalsIgnoreCase(vertex.get(i).getCity())) {
                JOptionPane.showMessageDialog(null, "Borrado exitoso", "Exito", JOptionPane.INFORMATION_MESSAGE);
                vertex.remove(i);
            }
        }
    }

    public void deleteEdges(String ans) {
        for (int i = 0; i < edges.size(); i++) {
            if (edges.get(i).getOriginVertex().getCity().equalsIgnoreCase(ans) || edges.get(i).getDestinyVertex().getCity().equalsIgnoreCase(ans)) {
                edges.remove(i);
            }
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
            matrix[vertex.indexOf(edge.getOriginVertex())][vertex.indexOf(edge.getDestinyVertex())] = edge.getDistance();
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
