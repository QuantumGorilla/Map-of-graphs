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

    /**
     * Método de colisiones, utiliza un radio de 30 pixeles para evitar que se
     * agregue un vertice encima de otro
     *
     * @param vertex, lista para checkear con todos los vertices y sus
     * posiciones
     * @param x, posición en x donde se dio click
     * @param y, posición en y donde se dio click
     * @return true si choca con algún vertice o false si no hay ningún vertice
     * en el radio de 30 pixeles
     */
    public boolean checkVertexPosition(ArrayList<Vertex> vertex, int x, int y) {
        for (Vertex n : vertex) {
            if (n.getPosX() + 30 >= x && n.getPosX() - 30 <= x && n.getPosY() + 30 >= y && n.getPosY() - 30 <= y) {
                return true;
            }
        }
        return false;
    }

    /**
     * Método para seleccionar un vertice en pantalla, utilizando 30 pixeles de
     * radio
     *
     * @param vertex, la lista para checkear sus respectivas posiciones y si el
     * click que se da es cercano
     * @param x, posición en x donde se dio click
     * @param y, posición en y donde se dio click
     * @return retorna el vertice encontrado en la posición donde se dio click o
     * null si no encuentra nada
     */
    public Vertex getVertexInPosition(ArrayList<Vertex> vertex, int x, int y) {
        primaryOcuppied = true;
        for (Vertex n : vertex) {
            if (n.getPosX() + 30 >= x && n.getPosX() - 30 <= x && n.getPosY() + 30 >= y && n.getPosY() - 30 <= y) {
                return n;
            }
        }
        return null;
    }

    /**
     * Método para crear un vertice
     *
     * @param ans, respuesta del usuario
     * @param x, posición en x donde se dio click
     * @param y, posición en y donde se dio click
     * @return un vertice creado con las posiciones en (x,y) y el nombre de la
     * ciudad
     */
    public Vertex answer(String ans, int x, int y) {
        if (ans.equalsIgnoreCase("Si") && !ans.isEmpty()) {
            String city = Helper.introduceCity();
            return new Vertex(x, y, city);
        }
        return null;
    }

    /**
     * Método para buscar el vertice de origen donde se haya dado click para
     * crear la arista
     *
     * @param vertex, la lista de vertices donde se recorrera para buscar
     * @param x, posición en x donde se dio click
     * @param y, posición en y donde se dio click
     * @return un vertice si la posición donde se dio click existe uno sino
     * retorna null
     */
    public Vertex originVertex(ArrayList<Vertex> vertex, int x, int y) {
        if (checkVertexPosition(vertex, x, y) && !Helper.primaryOcuppied) {
            Vertex a = getVertexInPosition(vertex, x, y);
            JOptionPane.showMessageDialog(null, "Seleccionaste el vertice: " + a.getCity(), "Seleccion Exitosa", JOptionPane.INFORMATION_MESSAGE);
            return a;
        }
        return null;
    }

    /**
     * Método para buscar el vertice destino donde se haya dado click para crear
     * la arista
     *
     * @param vertex, la lista de vertices donde se recorrera para buscar
     * @param x, posición en x donde se dio click
     * @param y, posición en x donde se dio click
     * @return un vertice si la posición donde se dio click existe uno sino
     * retorna null
     */
    public Vertex destinyVertex(ArrayList<Vertex> vertex, int x, int y) {
        if (checkVertexPosition(vertex, x, y)) {
            Vertex b = getVertexInPosition(vertex, x, y);
            JOptionPane.showMessageDialog(null, "Seleccionaste el vertice: " + b.getCity(), "Seleccion Exitosa", JOptionPane.INFORMATION_MESSAGE);
            Helper.setPrimaryVertex();
            return b;
        }
        return null;
    }

    /**
     * Pinta el vertice en la posición (x,y) del mapa donde se dio click
     *
     * @param g, graphics 2D del mapa
     * @param n, vertice a pintar
     */
    public void paintVertex(Graphics2D g, Vertex n) {
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setStroke(new BasicStroke(3));
        g.setColor(Color.decode("#B80C09"));
        g.fillOval(n.getPosX() - 20, n.getPosY() - 20, 45, 35);
        g.setColor(Color.decode("#FEC601"));
        g.drawOval(n.getPosX() - 20, n.getPosY() - 20, 45, 35);

        g.setColor(Color.BLACK);
        g.setFont(new Font("Gadugi", Font.BOLD, 10));
        g.drawString(n.getCity(), n.getPosX() - 5, n.getPosY());
    }

    /**
     * Método para pintar la arista desde un vertice origen a un vertice destino
     *
     * @param g, graphics 2D del mapa
     * @param origin, vertice origen
     * @param destiny, vertice destino
     * @param distance, el valor de la distancia entre el par de vertices
     */
    public void paintDistance(Graphics2D g, Vertex origin, Vertex destiny, int distance) {
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setStroke(new BasicStroke(3));
        g.setColor(Color.decode("#F5BB00"));
        g.drawLine(origin.getPosX() + 25, origin.getPosY(), destiny.getPosX() + 25, destiny.getPosY());

        g.setColor(Color.decode("#000"));
        g.setFont(new Font("Gadugi", Font.BOLD, 10));
        g.drawString(String.valueOf(distance), ((origin.getPosX() + destiny.getPosX()) / 2), ((origin.getPosY() + destiny.getPosY()) / 2) + 10);
    }

    /**
     * Pinta la mínima ruta obtenida del algoritmo de Floyd Warshall
     *
     * @param g, graphics 2D del mapa
     * @param minRoute, lista de aristas para pintar la mínima ruta
     */
    public void paintMinPath(Graphics2D g, ArrayList<Edge> minRoute) {
        if (!minRoute.isEmpty()) {
            minRoute.forEach((r) -> {
                paintMinimun(g, r.getOriginVertex(), r.getDestinyVertex(), r.getDistance());
            });
        }
    }

    /**
     * Pinta la mínima ruta por cada arista enviada del método paintMinPath();
     *
     * @see PaintMinPath(Graphics2D g, ArrayList<Edge> minRoute);
     * @param g, graphics 2D del mapa
     * @param origin, vertice origen
     * @param destiny, vertice destino
     * @param distance, distancia entre un par de vertice
     */
    private void paintMinimun(Graphics2D g, Vertex origin, Vertex destiny, int distance) {
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setStroke(new BasicStroke(3));
        g.setColor(Color.decode("#D00000"));
        g.drawLine(origin.getPosX() + 25, origin.getPosY(), destiny.getPosX() + 25, destiny.getPosY());

        g.setColor(Color.decode("#D00000"));
        g.setFont(new Font("Gadugi", Font.BOLD, 10));
        g.drawString(String.valueOf(distance), ((origin.getPosX() + destiny.getPosX()) / 2), ((origin.getPosY() + destiny.getPosY()) / 2));
    }

    /**
     * Reproduce música de manera continua de Mario Bros
     */
    public void playMusic() {
        try {
            Clip sound = AudioSystem.getClip();
            sound.open(AudioSystem.getAudioInputStream(getClass().getResourceAsStream("/Music/Mario_Overworld_Theme.wav")));
            sound.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException ex) {

        }
    }
}
