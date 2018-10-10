package Data;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Alejandro
 */
public class Graph {

    public final static int INF = 99999; //Infinito
    public ArrayList<Vertex> vertex = new ArrayList<>(); //Lista de vertices
    public ArrayList<Edge> edges = new ArrayList<>(); //Lista de aristas

    /**
     * Añade vertices
     *
     * @param v, vertice a añadir
     */
    public void addVertex(Vertex v) {
        vertex.add(v);
    }

    /**
     * Añade aristas
     *
     * @param e, arista a añadir
     */
    public void addEdge(Edge e) {
        edges.add(e);
    }

    /**
     * Busca el vertice dentro de la lista para comprobar que no exista
     *
     * @param v, vertice a buscar
     * @return -1 si lo encuentra y 1 si no lo encuentra
     */
    public int checkVertexList(Vertex v) {
        for (Vertex e : vertex) {
            if (v.getCity().equalsIgnoreCase(e.getCity())) {
                return -1;
            }
        }
        return 1;
    }

    /**
     * Borrar vertice
     *
     * @param ans, nombre del vertice a borrar
     */
    public void deleteVertex(String ans) {
        for (int i = 0; i < vertex.size(); i++) {
            if (ans.equalsIgnoreCase(vertex.get(i).getCity())) {
                JOptionPane.showMessageDialog(null, "Borrado exitoso", "Exito", JOptionPane.INFORMATION_MESSAGE);
                vertex.remove(i);
            }
        }
    }

    /**
     * Borrar aristas
     *
     * @param ans, nombre del vertice origen o destino que conecta la arista
     */
    public void deleteEdges(String ans) {
        ArrayList<Edge> helper = new ArrayList<>();
        for (int i = 0; i < edges.size(); i++) {
            if (edges.get(i).getOriginVertex().getCity().equalsIgnoreCase(ans) || edges.get(i).getDestinyVertex().getCity().equalsIgnoreCase(ans)) {
                helper.add(edges.get(i));
            }
        }

        helper.forEach((e) -> {
            Helper.minusOneEdge();
            edges.remove(e);
        });
    }

    /**
     * Genera una matriz de distancias, primero las llena de 0 e infinitos y
     * luego por cada vertice origen y destino la llena de las distancias
     *
     * @param vertex, lista de vertices
     * @param edges, lista de aristas
     * @return matriz de distancias
     */
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

    /**
     * Genera una matriz de caminos default
     *
     * @param vertex, lista de vertices
     * @return matriz default de caminos
     */
    public int[][] getPathMatrix(ArrayList<Vertex> vertex) {
        int matrix[][] = new int[vertex.size()][vertex.size()];
        for (int i = 0; i < vertex.size(); i++) {
            for (int j = 0; j < vertex.size(); j++) {
                matrix[i][j] = j;
            }
        }
        return matrix;
    }

    /**
     * Algoritmo de Floyd Warshall para encontrar el camino mínimo de un vertice
     * X a un vertice Y
     *
     * @param adj, matriz de adyacencia o matriz de distancias
     * @param minRoute, matriz de caminos
     */
    public void floyd(int[][] adj, int[][] minRoute) {
        for (int k = 0; k < adj.length; k++) {
            for (int i = 0; i < adj.length; i++) {
                for (int j = 0; j < adj.length; j++) {
                    if (adj[i][k] + adj[k][j] < adj[i][j]) {
                        adj[i][j] = adj[i][k] + adj[k][j];
                        minRoute[i][j] = minRoute[i][k];
                    }
                }
            }
        }
    }

    /**
     * Busca la mínima ruta de un vertice X a un vertice Y
     *
     * @param origin, vertice origen
     * @param destiny, vertice destino
     * @param route, matriz de caminos
     * @return minRoute, lista con los vertices que tienen la mínima ruta de X a
     * Y
     */
    public ArrayList<Edge> getMinRoute(Vertex origin, Vertex destiny, int[][] route) {
        ArrayList<Edge> minRoute = new ArrayList<>();
        int begin = vertex.indexOf(origin);
        int end = vertex.indexOf(destiny);
        while (begin != end) {
            begin = route[begin][end];
            Vertex path = vertex.get(end);
            minRoute.add(getNextVertex(origin, destiny));
            origin = path;
        }
        return minRoute;
    }

    /**
     * Obtiene la arista siguiente del camino mínimo
     *
     * @param origin, vertice origen
     * @param destiny, vertice destino
     * @return una arista si encuentra la relación del vertice origen y el
     * destino si no encuentra relación alguna retorna null
     */
    public Edge getNextVertex(Vertex origin, Vertex destiny) {
        for (Edge e : edges) {
            if (e.getOriginVertex() == origin && e.getDestinyVertex() == destiny) {
                return e;
            }
        }
        return null;
    }
}
