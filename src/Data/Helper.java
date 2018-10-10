package Data;

import javax.swing.JOptionPane;

/**
 *
 * @author Alejandro
 */
public class Helper {

    public static int vertexCount = 0; //Contador de vertices
    public static boolean primaryOcuppied = false; //Vertice origen ocupado
    public static int edgeCount = 0; //Contador de aristas

    /**
     * Método ayudante para checkear que se introduzca el nombre de una ciudad
     *
     * @return String, nombre de la ciudad
     */
    public static String introduceCity() {
        return Helper.checkCityName(JOptionPane.showInputDialog(null, "Nombre de la ciudad", "Ciudad", JOptionPane.QUESTION_MESSAGE));
    }

    /**
     * Método para evitar que se envie un JOptionPane vacio generando un
     * NullPointer Exception
     *
     * @param city, obtenido del JOptionPane
     * @return city, una vez sea diferente de vacio
     */
    private static String checkCityName(String city) {
        while (city.isEmpty()) {
            city = JOptionPane.showInputDialog(null, "Nombre de la ciudad", "Ciudad", JOptionPane.QUESTION_MESSAGE);
        }
        return city;
    }

    /**
     * Método ayudante para checkear que se introduzca la distancia entre un par
     * de vertices
     *
     * @return entero, valor de la distancia entre un par de vertices
     */
    public static int introduceDistance() {
        return Helper.checkDistance(JOptionPane.showInputDialog(null, "Valor entre los vertice", "Distancia", JOptionPane.QUESTION_MESSAGE));
    }

    /**
     * Método para checkear que el JOptionPane sea distinto de vacio
     *
     * @param distance, obtenida del JOptionPane
     * @return distance, valor entre un par de vertice
     */
    private static int checkDistance(String distance) {
        while (distance.isEmpty()) {
            distance = JOptionPane.showInputDialog(null, "Valor entre los vertices", "Distancia", JOptionPane.QUESTION_MESSAGE);
        }
        return Integer.parseInt(distance);
    }

    /**
     * Mensaje de error que salta a la pantalla si colisiona, es decir, si en el
     * lugar donde se da click ya hay un vertice
     */
    public static void errorMessage() {
        JOptionPane.showMessageDialog(null, "Ya hay un vertice aquí", "Error", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Mensaje de error que salta a la pantalla si se trata de crear un vertice
     * con el nombre de una ciudad ya existente
     */
    public static void existingVertex() {
        JOptionPane.showMessageDialog(null, "Está ciudad ya existe", "Vertice existente", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Mensaje de error que salta a la pantalla si se trata de escoger un mismo
     * vertice para generar una arista hacia sí mismo
     */
    public static void errorSameVertex() {
        JOptionPane.showMessageDialog(null, "No puedes escoger el mismo vertice", "Opción no valida", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Mensaje de ayuda que explica como funciona el programa si se da click en
     * el boton de ayuda del frame
     */
    public static void helpMessage() {
        JOptionPane.showMessageDialog(null, "Para agregar vertices presiona click izquierdo"
                + " en el mapa. \nPara agregar aristas de un vertice a otro presiona click derecho"
                + ", primero presiona en el vertice origen y luego en el vertice destino."
                + "\nPara calcular la ruta mínima utiliza el comboBox y selecciona la ciudad origen y la destino,"
                + " luego presiona el boton de floyd warshall y luego en la moneda.", "Ayuda", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Mensaje de error que salta a la pantalla si se manda un JOptionPane vacio
     */
    public static void emptyJOptionPane() {
        JOptionPane.showMessageDialog(null, "Debes llenar el espacio requerido", "Error", JOptionPane.WARNING_MESSAGE);
    }

    /**
     * Método ayudante que se invoca una vez que ya se formo una arista, se
     * vuelve falso dando paso a la escogencia de un nuevo vertice origen
     */
    public static void setPrimaryVertex() {
        primaryOcuppied = false;
    }

    /**
     * Método ayudante para ir contando cuantos vertices se han agregado
     */
    public static void plusOneVertex() {
        Helper.vertexCount++;
    }

    /**
     * Método ayudante para ir contando cuantas aristas hay
     */
    public static void plusOneEdge() {
        Helper.edgeCount++;
    }

    /**
     * Método ayudante para reducir la cantidad de vertices en caso se elimine
     * uno
     */
    public static void minusOneVertex() {
        Helper.vertexCount--;
    }

    /**
     * Método ayudante para reducir la cantidad de vertices en caso de que se
     * elimine una o varias aristas
     */
    public static void minusOneEdge() {
        Helper.edgeCount--;
    }

}
