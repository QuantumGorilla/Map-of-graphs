package Data;

/**
 *
 * @author Alejandro
 */
public class Node {

    private String city, hood, country;
    private int x, y;

    public Node(int x, int y, String city, String hood, String country) {
        this.x = x;
        this.y = y;
        this.city = city;
        this.hood = hood;
        this.country = country;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getHood() {
        return hood;
    }

    public void setHood(String hood) {
        this.hood = hood;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}
