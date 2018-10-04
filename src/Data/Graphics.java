package Data;

import static Data.Helper.primaryOcuppied;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
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

    public boolean checkVertexPosition(ArrayList<Vertex> vertex, int x, int y) {
        for (Vertex n : vertex) {
            if (n.getPosX() + 30 >= x && n.getPosX() - 30 <= x && n.getPosY() + 30 >= y && n.getPosY() - 30 <= y) {
                return true;
            }
        }
        return false;
    }

    public Vertex getVertexInPosition(ArrayList<Vertex> vertex, int x, int y) {
        primaryOcuppied = true;
        for (Vertex n : vertex) {
            if (n.getPosX() + 30 >= x && n.getPosX() - 30 <= x && n.getPosY() + 30 >= y && n.getPosY() - 30 <= y) {
                return n;
            }
        }
        return null;
    }

    public Vertex answer(String ans, int x, int y) {
        if (ans.equalsIgnoreCase("Si") && !ans.isEmpty()) {
            String city = Helper.introduceCity();
            return new Vertex(x, y, city);
        }
        return null;
    }

    public Vertex originVertex(ArrayList<Vertex> vertex, int x, int y) {
        if (checkVertexPosition(vertex, x, y) && !Helper.primaryOcuppied) {
            Vertex a = getVertexInPosition(vertex, x, y);
            JOptionPane.showMessageDialog(null, "Seleccionaste el vertice: " + a.getCity(), "Seleccion Exitosa", JOptionPane.INFORMATION_MESSAGE);
            return a;
        }
        return null;
    }

    public Vertex destinyVertex(ArrayList<Vertex> nodes, int x, int y) {
        if (checkVertexPosition(nodes, x, y)) {
            Vertex b = getVertexInPosition(nodes, x, y);
            JOptionPane.showMessageDialog(null, "Seleccionaste el vertice: " + b.getCity(), "Seleccion Exitosa", JOptionPane.INFORMATION_MESSAGE);
            Helper.setPrimaryVertex();
            return b;
        }
        return null;
    }

    public void paint(Graphics2D g, Vertex n) {
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setStroke(new BasicStroke(3));
        g.setColor(Color.decode("#304fb5"));
        g.fillOval(n.getPosX() - 20, n.getPosY() - 20, 45, 35);
        g.setColor(Color.decode("#80da03"));
        g.drawOval(n.getPosX() - 20, n.getPosY() - 20, 45, 35);

        g.setColor(Color.BLACK);
        g.setFont(new Font("Gadugi", Font.BOLD, 10));
        g.drawString(n.getCity(), n.getPosX() - 20, n.getPosY());
    }

    public void paintDistance(Graphics2D g, Vertex origin, Vertex destiny, int distance) {
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setStroke(new BasicStroke(3));
        g.setColor(Color.decode("#e5bf23"));
        g.drawLine(origin.getPosX() + 25, origin.getPosY(), destiny.getPosX() + 25, destiny.getPosY());

        g.setColor(Color.decode("#000"));
        g.setFont(new Font("Gadugi", Font.BOLD, 10));
        g.drawString(String.valueOf(distance), ((origin.getPosX() + destiny.getPosX()) / 2) - 40, ((origin.getPosY() + destiny.getPosY()) / 2));
        g.drawString(String.valueOf(distance), ((origin.getPosX() + destiny.getPosX()) / 2), ((origin.getPosY() + destiny.getPosY()) / 2) + 40);
    }

    public void paintAgainVertex(Graphics2D g, ArrayList<Vertex> vertex) {
        for (Vertex v : vertex) {
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g.setStroke(new BasicStroke(2));
            g.setColor(Color.decode("#304fb5"));
            g.fillOval(v.getPosX() - 20, v.getPosY() - 20, 45, 35);
            g.setColor(Color.decode("#80da03"));
            g.drawOval(v.getPosX() - 20, v.getPosY() - 20, 45, 35);

            g.setColor(Color.BLACK);
            g.setFont(new Font("Georgia", Font.BOLD, 10));
            g.drawString(v.getCity(), v.getPosX() - 20, v.getPosY());
        }
    }

    public void paintAgainEdges(Graphics2D g, ArrayList<Edge> edges) {
        for (Edge e : edges) {
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g.setStroke(new BasicStroke(3));
            g.setColor(Color.decode("#e5bf23"));
            g.drawLine(e.getNodeOrigin().getPosX() + 25, e.getNodeOrigin().getPosY(), e.getNodeDestiny().getPosX() + 25, e.getNodeDestiny().getPosY());

            g.setColor(Color.decode("#000"));
            g.setFont(new Font("Georgia", Font.BOLD, 10));
            g.drawString(String.valueOf(e.getDistance()), ((e.getNodeOrigin().getPosX() + e.getNodeDestiny().getPosX()) / 2), ((e.getNodeOrigin().getPosY() + e.getNodeDestiny().getPosY()) / 2));
        }
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
