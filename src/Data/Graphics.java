package Data;

import static Data.Helper.primaryOcuppied;
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
            JOptionPane.showMessageDialog(null, "Seleccionaste el nodo: " + a.getCity(), "Seleccion Exitosa", JOptionPane.INFORMATION_MESSAGE);
            return a;
        }
        return null;
    }

    public static Node destinyNode(ArrayList<Node> nodes, int x, int y) {
        Node b;
        if (checkNodesPosition(nodes, x, y)) {
            b = getNodeInPosition(nodes, x, y);
            JOptionPane.showMessageDialog(null, "Seleccionaste el nodo: " + b.getCity(), "Seleccion Exitosa", JOptionPane.INFORMATION_MESSAGE);
            Helper.setPrimaryNode();
            return b;
        }
        return null;
    }
    
    
        public void playMusic(){
        try {
            Clip sound = AudioSystem.getClip();
            sound.open(AudioSystem.getAudioInputStream(getClass().getResourceAsStream("/Music/Mario_Overworld_Theme.wav")));
            sound.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException ex) {
            
        }
    }
}
