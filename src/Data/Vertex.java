package Data;

/**
 *
 * @author Alejandro
 */
public class Vertex {

    private String city;
    private int posX, posY;

    public Vertex(int x, int y, String city) {
        this.posX = x;
        this.posY = y;
        this.city = city;
    }

    public int getPosX() {
        return posX;
    }

    public void setX(int x) {
        this.posX = x;
    }

    public int getPosY() {
        return posY;
    }

    public void setY(int y) {
        this.posY = y;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}
