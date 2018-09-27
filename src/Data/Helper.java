package Data;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Alejandro
 */
public class Helper {

    public static int nodeCount = 0;

    public static boolean checkNodesPosition(ArrayList<Node> nodes, int x, int y) {
        for (Node n : nodes) {
            if (n.getX() + 30 >= x && n.getX() - 30 <= x && n.getY() + 30 >= y && n.getY() - 30 <= y) {
                return true;
            }
        }
        return false;
    }

    public static String checkCityName(String city) {
        while (city.isEmpty()) {
            city = JOptionPane.showInputDialog(null, "Nombre de la ciudad", "Ciudad", JOptionPane.INFORMATION_MESSAGE);
        }
        return city;
    }

    public static String checkHoodName(String hood) {
        while (hood.isEmpty()) {
            hood = JOptionPane.showInputDialog(null, "Nombre del barrio", "Barrio", JOptionPane.INFORMATION_MESSAGE);
        }
        return hood;
    }

    public static String checkCountryName(String country) {
        while (country.isEmpty()) {
            country = JOptionPane.showInputDialog(null, "Nombre del país", "Pais", JOptionPane.INFORMATION_MESSAGE);
        }
        return country;
    }

}
