package Data;

import static Data.Helper.primaryOcuppied;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.io.IOException;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author Alejandro
 */
public class Graphics {

    public static boolean checkNodesPosition(ArrayList<Node> nodes, int x, int y) {
        for (Node n : nodes) {
            if (n.getPosX() + 30 >= x && n.getPosX() - 30 <= x && n.getPosY() + 30 >= y && n.getPosY() - 30 <= y) {
                return true;
            }
        }
        return false;
    }

    public static Node getNodeInPosition(ArrayList<Node> nodes, int x, int y) {
        primaryOcuppied = true;
        for (Node n : nodes) {
            if (n.getPosX() + 30 >= x && n.getPosX() - 30 <= x && n.getPosY() + 30 >= y && n.getPosY() - 30 <= y) {
                return n;
            }
        }
        return null;
    }

    public static Node answer(String ans, int x, int y) {
        if (ans.equalsIgnoreCase("Si") && !ans.isEmpty()) {
            String city = Helper.introduceCity();
            String country = Helper.introduceCountry();
            return new Node(x, y, city, country);
        }
        return null;
    }

    public static Node originNode(ArrayList<Node> nodes, int x, int y) {
        Node a;
        if (checkNodesPosition(nodes, x, y) && !Helper.primaryOcuppied) {
            a = getNodeInPosition(nodes, x, y);
            JOptionPane.showMessageDialog(null, "Seleccionaste el vertice: " + a.getCity(), "Seleccion Exitosa", JOptionPane.INFORMATION_MESSAGE);
            return a;
        }
        return null;
    }

    public static Node destinyNode(ArrayList<Node> nodes, int x, int y) {
        Node b;
        if (checkNodesPosition(nodes, x, y)) {
            b = getNodeInPosition(nodes, x, y);
            JOptionPane.showMessageDialog(null, "Seleccionaste el vertice: " + b.getCity(), "Seleccion Exitosa", JOptionPane.INFORMATION_MESSAGE);
            Helper.setPrimaryNode();
            return b;
        }
        return null;
    }

    public static void paint(Graphics2D g, Node n) {
        g.setStroke(new BasicStroke(3));
        g.setColor(Color.decode("#304fb5"));
        g.fillOval(n.getPosX() - 20, n.getPosY() - 20, 45, 35);
        g.setColor(Color.decode("#80da03"));
        g.drawOval(n.getPosX() - 20, n.getPosY() - 20, 45, 35);

        g.setColor(Color.BLACK);
        g.setFont(new Font("Gadugi", Font.BOLD, 10));
        g.drawString(n.getCity(), n.getPosX() - 20, n.getPosY());
    }

    public static void paintDistance(Graphics2D g, Node origin, Node destiny, int distance) {
        g.setStroke(new BasicStroke(3));
        g.setColor(Color.decode("#e5bf23"));
        g.drawLine(origin.getPosX() + 25, origin.getPosY(), destiny.getPosX() + 25, destiny.getPosY());
        g.drawPolygon(drawTriangleX(), drawTriangleY(), 3);

        g.setColor(Color.decode("#ff7e00"));
        g.setFont(new Font("Gadugi", Font.BOLD, 10));
        g.drawString(String.valueOf(distance), ((origin.getPosX() + destiny.getPosX()) / 2), ((origin.getPosY() + destiny.getPosY()) / 2));
    }
    
    private static int[] drawTriangleX(){
        return new int[]{20, 20, 30};
    }
    
    private static int[] drawTriangleY(){
        return new int[]{20, 20, 30};
    }
    
    public void playMusic() {
        try {
            Clip sound = AudioSystem.getClip();
            sound.open(AudioSystem.getAudioInputStream(getClass().getResourceAsStream("/Music/Mario_Overworld_Theme.wav")));
            sound.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException ex) {

        }
    }
}
