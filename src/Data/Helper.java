package Data;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Alejandro
 */
public class Helper {

    public static int nodeCount = 0;
    public static boolean primaryOcuppied = false;
    public static int relationCount = 0;

    public static boolean checkNodesPosition(ArrayList<Node> nodes, int x, int y) {
        for (Node n : nodes) {
            if (n.getX() + 30 >= x && n.getX() - 30 <= x && n.getY() + 30 >= y && n.getY() - 30 <= y) {
                return true;
            }
        }
        return false;
    }

    public static Node getNodeInPosition(ArrayList<Node> nodes, int x, int y) {
        primaryOcuppied = true;
        for (Node n : nodes) {
            if (n.getX() + 30 >= x && n.getX() - 30 <= x && n.getY() + 30 >= y && n.getY() - 30 <= y) {
                return n;
            }
        }
        return null;
    }

    public static String introduceCity() {
        return Helper.checkCityName(JOptionPane.showInputDialog(null, "Nombre de la ciudad", "Ciudad", JOptionPane.INFORMATION_MESSAGE));
    }

    private static String checkCityName(String city) {
        while (city.isEmpty()) {
            city = JOptionPane.showInputDialog(null, "Nombre de la ciudad", "Ciudad", JOptionPane.INFORMATION_MESSAGE);
        }
        return city;
    }

    public static String introduceHood() {
        return checkHoodName(JOptionPane.showInputDialog(null, "Nombre del barrio", "Barrio", JOptionPane.INFORMATION_MESSAGE));
    }

    private static String checkHoodName(String hood) {
        while (hood.isEmpty()) {
            hood = JOptionPane.showInputDialog(null, "Nombre del barrio", "Barrio", JOptionPane.INFORMATION_MESSAGE);
        }
        return hood;
    }

    public static String introduceCountry() {
        return Helper.checkCountryName(JOptionPane.showInputDialog(null, "Nombre del país", "Pais", JOptionPane.INFORMATION_MESSAGE));
    }

    private static String checkCountryName(String country) {
        while (country.isEmpty()) {
            country = JOptionPane.showInputDialog(null, "Nombre del país", "Pais", JOptionPane.INFORMATION_MESSAGE);
        }
        return country;
    }

    public static String introduceDistance() {
        return Helper.checkDistance(JOptionPane.showInputDialog(null, "Valor entre los nodos", "Distancia", JOptionPane.INFORMATION_MESSAGE));
    }

    private static String checkDistance(String distance) {
        while (distance.isEmpty()) {
            distance = JOptionPane.showInputDialog(null, "Valor entre los nodos", "Distancia", JOptionPane.INFORMATION_MESSAGE);
        }
        return distance;
    }

    public static void errorMessage() {
        JOptionPane.showMessageDialog(null, "Ya hay un nodo aquí", "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void setPrimaryNode(){
        primaryOcuppied = false;
    }
    
    public static void plusOneNode() {
        Helper.nodeCount++;
    }

    public static void plusOneRelation() {
        Helper.relationCount++;
    }

}
