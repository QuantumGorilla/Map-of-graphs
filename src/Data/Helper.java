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

    public static void existingVertex() {
        JOptionPane.showMessageDialog(null, "Está ciudad ya existe", "Vertice existente", JOptionPane.ERROR_MESSAGE);
    }

    public static void errorSameVertex() {
        JOptionPane.showMessageDialog(null, "No puedes escoger el mismo vertice", "Opción no valida", JOptionPane.ERROR_MESSAGE);
    }

    public static void helpMessage() {
        JOptionPane.showMessageDialog(null, "Para agregar vertices presiona click izquierdo"
                + " en el mapa. \nPara agregar aristas de un vertice a otro presiona click derecho"
                + ", primero presiona en el vertice origen y luego en el vertice destino."
                + "\nPara calcular la ruta mínima utiliza el comboBox y selecciona la ciudad origen y la destino,"
                + " luego presiona el boton de floyd warshall y luego en la moneda.", "Ayuda", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void emptyJOptionPane() {
        JOptionPane.showMessageDialog(null, "Debes llenar el espacio requerido", "Error", JOptionPane.WARNING_MESSAGE);
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

    public static void minusOneVertex() {
        Helper.vertexCount--;
    }

    public static void minusOneEdge() {
        Helper.edgeCount--;
    }

}
