package Data;

import javax.swing.JOptionPane;

/**
 *
 * @author Alejandro
 */
public class Helper {

    public static int vertexCount = 0;
    public static boolean primaryOcuppied = false;
    public static int edgeCount = 0;

    public static String introduceCity() {
        return Helper.checkCityName(JOptionPane.showInputDialog(null, "Nombre de la ciudad", "Ciudad", JOptionPane.QUESTION_MESSAGE));
    }

    private static String checkCityName(String city) {
        while (city.isEmpty()) {
            city = JOptionPane.showInputDialog(null, "Nombre de la ciudad", "Ciudad", JOptionPane.QUESTION_MESSAGE);
        }
        return city;
    }

    public static int introduceDistance() {
        return Helper.checkDistance(JOptionPane.showInputDialog(null, "Valor entre los vertice", "Distancia", JOptionPane.QUESTION_MESSAGE));
    }

    private static int checkDistance(String distance) {
        while (distance.isEmpty()) {
            distance = JOptionPane.showInputDialog(null, "Valor entre los vertices", "Distancia", JOptionPane.QUESTION_MESSAGE);
        }
        return Integer.parseInt(distance);
    }

    public static void errorMessage() {
        JOptionPane.showMessageDialog(null, "Ya hay un vertice aquí", "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    public static void existingVertex(){
        JOptionPane.showMessageDialog(null, "Está ciudad ya existe", "Vertice existente", JOptionPane.ERROR_MESSAGE);
    }

    public static void setPrimaryVertex() {
        primaryOcuppied = false;
    }

    public static void plusOneVertex() {
        Helper.vertexCount++;
    }

    public static void plusOneEdge() {
        Helper.edgeCount++;
    }

}
