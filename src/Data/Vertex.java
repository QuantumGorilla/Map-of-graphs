package Data;

/**
 *
 * @author Alejandro
 */
public class Vertex {

    private String city; //Nombre del vertice
    private int posX, posY; //Posición en X y en Y

    /**
     * Constructor de vertice
     *
     * @param x, posición en x donde se dio click
     * @param y, posición en y donde se dio click
     * @param city, nombre del vertice
     */
    public Vertex(int x, int y, String city) {
        this.posX = x;
        this.posY = y;
        this.city = city;
    }

    /**
     * Obtiene la posición en x
     *
     * @return posición en x
     */
    public int getPosX() {
        return posX;
    }

    /**
     * Coloca la posición en X
     *
     * @param x, posición donde haya dado click
     */
    public void setX(int x) {
        this.posX = x;
    }

    /**
     * Obtiene la posición en y
     *
     * @return posicióne en y
     */
    public int getPosY() {
        return posY;
    }

    /**
     * Coloca la posición en y
     *
     * @param y, posición donde haya dado click
     */
    public void setY(int y) {
        this.posY = y;
    }

    /**
     * Obtiene el nombre del ciudad
     *
     * @return nombre de la ciudad
     */
    public String getCity() {
        return city;
    }

    /**
     * Coloca el nombre de la ciudad
     *
     * @param city, nombre que se quiera colocar
     */
    public void setCity(String city) {
        this.city = city;
    }

}
