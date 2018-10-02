package Frame;

import Data.Graphics;
import Data.Edge;
import Data.Graph;
import Data.Helper;
import Data.Node;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Alejandro
 */
public class Frame extends javax.swing.JFrame {

    private ArrayList<Node> nodes = new ArrayList<>();
    private ArrayList<Edge> edges = new ArrayList<>();
    private int[][] distance;
    private Node origin;
    private Node destiny;
    private Node helperNode;
    private final Graphics music = new Graphics();

    public Frame() {
        initComponents();
        setScreenLocation();
        setTitle();
        setResize(false);
        setFavicon();
        music.playMusic();
    }
    
    private void setResize(boolean resize){
        this.setResizable(resize);
    }
    
    private void setFavicon(){
        this.setIconImage(new ImageIcon(getClass().getResource("/Images/Mario Mushroom.png")).getImage());
    }
    
    private void setTitle(){
        this.setTitle("Mapa de grafos");
    }

    private void setScreenLocation() {
        this.setLocationRelativeTo(null);
    }

    private void paint(Graphics2D g, Node n) {
        map2.revalidate();
        Graphics.paint(g, n);
    }

    private void paintDistance(Graphics2D g, Node origin, Node destiny, int distance) {
        map2.revalidate();
        Graphics.paintDistance(g, origin, destiny, distance);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        map = new javax.swing.JPanel();
        map2 = new javax.swing.JLabel();
        backGroundPanel = new javax.swing.JPanel();
        originLabel = new javax.swing.JLabel();
        originBox = new javax.swing.JComboBox<>();
        destinyBox = new javax.swing.JComboBox<>();
        destinyLabel = new javax.swing.JLabel();
        priceLabel = new javax.swing.JLabel();
        floydButton = new javax.swing.JButton();
        priceField = new javax.swing.JTextField();
        price = new javax.swing.JButton();
        helpLabel = new javax.swing.JLabel();
        backgroundLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        map.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        map.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        map2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Mario world.png"))); // NOI18N
        map2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                map2MouseClicked(evt);
            }
        });
        map.add(map2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, -1));

        getContentPane().add(map, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 118, 750, 400));

        backGroundPanel.setBackground(new java.awt.Color(255, 255, 255));
        backGroundPanel.setForeground(new java.awt.Color(255, 255, 255));
        backGroundPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        originLabel.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        originLabel.setText("Ciudad origen");
        backGroundPanel.add(originLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, 20));

        originBox.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        originBox.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backGroundPanel.add(originBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 140, 30));

        destinyBox.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        destinyBox.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backGroundPanel.add(destinyBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, 150, 30));

        destinyLabel.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        destinyLabel.setText("Ciudad destino");
        backGroundPanel.add(destinyLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, -1, 20));

        priceLabel.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        priceLabel.setText("Mìnimo Costo:");
        backGroundPanel.add(priceLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 20, -1, 30));

        floydButton.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        floydButton.setText("Floyd Warshall");
        floydButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        floydButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                floydButtonActionPerformed(evt);
            }
        });
        backGroundPanel.add(floydButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 70, 170, 30));

        priceField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                priceFieldKeyTyped(evt);
            }
        });
        backGroundPanel.add(priceField, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 20, 179, 30));

        price.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Mario coin.png"))); // NOI18N
        price.setBorder(null);
        price.setContentAreaFilled(false);
        price.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceActionPerformed(evt);
            }
        });
        backGroundPanel.add(price, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 50, 70, -1));

        helpLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Help-icon.png"))); // NOI18N
        helpLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                helpLabelMouseClicked(evt);
            }
        });
        backGroundPanel.add(helpLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        backgroundLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Mario clouds.png"))); // NOI18N
        backGroundPanel.add(backgroundLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, -1));

        getContentPane().add(backGroundPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 120));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void map2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_map2MouseClicked

        try {
            if (evt.getButton() == MouseEvent.BUTTON1) {
                if (nodes.isEmpty()) {
                    helperNode = Graphics.answer(JOptionPane.showInputDialog(null, "Quieres añadir un lugar en esta posiciòn? Sí / No", "Añadir", JOptionPane.INFORMATION_MESSAGE), evt.getX(), evt.getY());
                    if (helperNode != null) {
                        nodes.add(helperNode);
                        addNodesInComboBox();
                        paint((Graphics2D) map2.getGraphics(), nodes.get(Helper.nodeCount));
                        Helper.plusOneNode();
                    }
                } else {
                    if (Graphics.checkNodesPosition(nodes, evt.getX(), evt.getY())) {
                        Helper.errorMessage();
                    } else {
                        helperNode = Graphics.answer(JOptionPane.showInputDialog(null, "Quieres añadir un lugar en esta posiciòn? Sí / No", "Añadir", JOptionPane.INFORMATION_MESSAGE), evt.getX(), evt.getY());
                        if (helperNode != null) {
                            nodes.add(helperNode);
                            addNodesInComboBox();
                            paint((Graphics2D) map2.getGraphics(), nodes.get(Helper.nodeCount));
                            Helper.plusOneNode();
                        }
                    }
                }
            } else {
                if (evt.getButton() == MouseEvent.BUTTON3) {
                    if (!Helper.primaryOcuppied) {
                        origin = Graphics.originNode(nodes, evt.getX(), evt.getY());
                    } else {
                        destiny = Graphics.destinyNode(nodes, evt.getX(), evt.getY());
                        Helper.setPrimaryNode();
                    }
                    if (origin != null && destiny != null) {
                        edges.add(new Edge(origin, destiny, Helper.introduceDistance()));
                        paintDistance((Graphics2D) map2.getGraphics(), edges.get(Helper.relationCount).getNodeOrigin(), edges.get(Helper.relationCount).getNodeDestiny(),
                                edges.get(Helper.relationCount).getDistance());
                        Helper.plusOneRelation();
                        origin = destiny = null;
                    }
                }
            }
        } catch (Exception e) {

        }
    }//GEN-LAST:event_map2MouseClicked

    private void addNodesInComboBox() {
        destinyBox.insertItemAt(nodes.get(Helper.nodeCount).getCity() + "/" + nodes.get(Helper.nodeCount).getCountry(), Helper.nodeCount);
        originBox.insertItemAt(nodes.get(Helper.nodeCount).getCity() + "/" + nodes.get(Helper.nodeCount).getCountry(), Helper.nodeCount);
    }

    private void priceFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_priceFieldKeyTyped

        evt.consume();

    }//GEN-LAST:event_priceFieldKeyTyped

    private void priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceActionPerformed

        try {
            if (searchOriginNode() != null && searchDestinyNode() != null && distance != null) {
                int price = distance[nodes.indexOf(searchOriginNode())][nodes.indexOf(searchDestinyNode())];
                if (price == Graph.INF) {
                    JOptionPane.showMessageDialog(null, "No puedes ir de " + searchOriginNode().getCity() + " a " + searchDestinyNode().getCity());
                } else {
                    priceField.setText(String.valueOf(price));
                }
            } else {
                JOptionPane.showMessageDialog(null, "Selecciona dos ciudades en el combo box y presiona el boton de Floyd Warshall");
            }
        } catch (Exception e) {

        }

    }//GEN-LAST:event_priceActionPerformed

    private Node searchOriginNode() {
        for (Node n : nodes) {
            if (originBox.getSelectedItem().toString().equalsIgnoreCase(n.getCity() + "/" + n.getCountry())) {
                return n;
            }
        }
        return null;
    }

    private Node searchDestinyNode() {
        for (Node n : nodes) {
            if (destinyBox.getSelectedItem().toString().equalsIgnoreCase(n.getCity() + "/" + n.getCountry())) {
                return n;
            }
        }
        return null;
    }

    private void floydButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_floydButtonActionPerformed

        distance = Graph.getDistanceMatrix(nodes, edges);
        Graph.floyd(distance);

    }//GEN-LAST:event_floydButtonActionPerformed

    private void helpLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_helpLabelMouseClicked

        JOptionPane.showMessageDialog(null, "Para agregar vertices presiona click izquierdo"
                + " en el mapa. Para agregar aristas de un vertice a otro presiona click derecho"
                + ", primero presiona en el vertice origen y luego en el vertice destino."
                + "\nPara calcular la ruta mínima utiliza el comboBox y selecciona la ciudad origen y la destino,"
                + " luego presiona el boton de floyd warshall y luego en la moneda.", "Ayuda", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_helpLabelMouseClicked

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Frame().setVisible(true);
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel backGroundPanel;
    private javax.swing.JLabel backgroundLabel;
    private javax.swing.JComboBox<String> destinyBox;
    private javax.swing.JLabel destinyLabel;
    private javax.swing.JButton floydButton;
    private javax.swing.JLabel helpLabel;
    private javax.swing.JPanel map;
    private javax.swing.JLabel map2;
    private javax.swing.JComboBox<String> originBox;
    private javax.swing.JLabel originLabel;
    private javax.swing.JButton price;
    private javax.swing.JTextField priceField;
    private javax.swing.JLabel priceLabel;
    // End of variables declaration//GEN-END:variables
}
