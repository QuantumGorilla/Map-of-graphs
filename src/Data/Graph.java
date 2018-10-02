package Data;

/**
 *
 * @author Alejandro
 */
public class Graph {

    public final static int INF = 99999;

    public static int[][] getDistanceMatrix() {
        int matrix[][] = new int[Frame.Frame.nodes.size()][Frame.Frame.nodes.size()];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (i == j) {
                    matrix[i][j] = 0;
                } else {
                    matrix[i][j] = INF;
                }
            }
        }
        Frame.Frame.edges.forEach((edge) -> {
            matrix[Frame.Frame.nodes.indexOf(edge.getNodeOrigin())][Frame.Frame.nodes.indexOf(edge.getNodeDestiny())] = edge.getDistance();
        });
        return matrix;
    }

    public static void floyd(int[][] adj) {
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
