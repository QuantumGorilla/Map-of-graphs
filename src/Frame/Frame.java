package Frame;

import Data.Graphics;
import Data.Edge;
import Data.Graph;
import Data.Helper;
import Data.Vertex;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Alejandro
 */
public class Frame extends javax.swing.JFrame {

    private final Graph graph;
    private int[][] distance;
    private Vertex origin;
    private Vertex destiny;
    private Vertex helperVertex;
    private final Graphics graphics;

    public Frame() {
        initComponents();
        graph = new Graph();
        graphics = new Graphics();
        setScreenLocation();
        setTitle();
        setResize(false);
        setFavicon();
        graphics.playMusic();
    }

    private void setResize(boolean resize) {
        this.setResizable(resize);
    }

    private void setFavicon() {
        this.setIconImage(new ImageIcon(getClass().getResource("/Images/Mario Mushroom.png")).getImage());
    }

    private void setTitle() {
        this.setTitle("Mario World Navigator");
    }

    private void setScreenLocation() {
        this.setLocationRelativeTo(null);
    }

    private void paint(Graphics2D g, Vertex n) {
        map2.revalidate();
        graphics.paint(g, n);
    }

    private void paintDistance(Graphics2D g, Vertex origin, Vertex destiny, int distance) {
        map2.revalidate();
        graphics.paintDistance(g, origin, destiny, distance);
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
        price = new javax.swing.JButton();
        helpLabel = new javax.swing.JLabel();
        deleteButton = new javax.swing.JButton();
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
        map.add(map2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 390));

        getContentPane().add(map, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 118, 750, 400));

        backGroundPanel.setBackground(new java.awt.Color(255, 255, 255));
        backGroundPanel.setForeground(new java.awt.Color(255, 255, 255));
        backGroundPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        originLabel.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        originLabel.setText("Ciudad origen");
        backGroundPanel.add(originLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, 20));

        originBox.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        originBox.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backGroundPanel.add(originBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 140, 30));

        destinyBox.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        destinyBox.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backGroundPanel.add(destinyBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, 150, 30));

        destinyLabel.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        destinyLabel.setText("Ciudad destino");
        backGroundPanel.add(destinyLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 30, -1, 20));

        priceLabel.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        priceLabel.setText("Mínimo Costo");
        backGroundPanel.add(priceLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 70, -1, 30));

        price.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Coin Mario.png"))); // NOI18N
        price.setBorder(null);
        price.setContentAreaFilled(false);
        price.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceActionPerformed(evt);
            }
        });
        backGroundPanel.add(price, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 50, 50, -1));

        helpLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Help-icon.png"))); // NOI18N
        helpLabel.setText("Help");
        helpLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                helpLabelMouseClicked(evt);
            }
        });
        backGroundPanel.add(helpLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        deleteButton.setText("Eliminar");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        backGroundPanel.add(deleteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 60, -1, -1));

        backgroundLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Clouds.png"))); // NOI18N
        backGroundPanel.add(backgroundLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 120));

        getContentPane().add(backGroundPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 120));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void map2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_map2MouseClicked

        try {
            if (evt.getButton() == MouseEvent.BUTTON1) {
                if (graph.getVertexList().isEmpty()) {
                    helperVertex = graphics.answer(JOptionPane.showInputDialog(null, "Quieres añadir un lugar en esta posiciòn? Sí / No", "Añadir", JOptionPane.INFORMATION_MESSAGE), evt.getX(), evt.getY());
                    if (helperVertex != null) {
                        graph.addVertex(helperVertex);
                        addVertexInComboBox();
                        paint((Graphics2D) map2.getGraphics(), graph.getVertexList().get(Helper.vertexCount));
                        Helper.plusOneVertex();
                    }
                } else {
                    if (graphics.checkVertexPosition(graph.getVertexList(), evt.getX(), evt.getY())) {
                        Helper.errorMessage();
                    } else {
                        helperVertex = graphics.answer(JOptionPane.showInputDialog(null, "Quieres añadir un lugar en esta posiciòn? Sí / No", "Añadir", JOptionPane.INFORMATION_MESSAGE), evt.getX(), evt.getY());
                        if (helperVertex != null && graph.checkVertexList(helperVertex) != -1) {
                            graph.getVertexList().add(helperVertex);
                            addVertexInComboBox();
                            paint((Graphics2D) map2.getGraphics(), graph.getVertexList().get(Helper.vertexCount));
                            Helper.plusOneVertex();
                        } else {
                            Helper.existingVertex();
                        }
                    }
                }
            } else {
                if (evt.getButton() == MouseEvent.BUTTON3) {
                    if (!Helper.primaryOcuppied) {
                        origin = graphics.originVertex(graph.getVertexList(), evt.getX(), evt.getY());
                    } else {
                        destiny = graphics.destinyVertex(graph.getVertexList(), evt.getX(), evt.getY());
                        Helper.setPrimaryVertex();
                    }
                    if (origin != null && destiny != null) {
                        graph.getEdgesList().add(new Edge(origin, destiny, Helper.introduceDistance()));
                        paintDistance((Graphics2D) map2.getGraphics(), graph.getEdgesList().get(Helper.edgeCount).getNodeOrigin(), graph.getEdgesList().get(Helper.edgeCount).getNodeDestiny(),
                                graph.getEdgesList().get(Helper.edgeCount).getDistance());
                        Helper.plusOneEdge();
                        origin = destiny = null;
                    }
                }
            }
        } catch (Exception e) {

        }
    }//GEN-LAST:event_map2MouseClicked

    private void addVertexInComboBox() {
        originBox.insertItemAt(graph.getVertexList().get(Helper.vertexCount).getCity(), Helper.vertexCount);
        destinyBox.insertItemAt(graph.getVertexList().get(Helper.vertexCount).getCity(), Helper.vertexCount);
    }

    private void priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceActionPerformed

        try {
            distance = graph.getDistanceMatrix(graph.getVertexList(), graph.getEdgesList());
            graph.floyd(distance);
            if (searchOriginVertex() != null && searchDestinyVertex() != null && distance != null) {
                int priceDistance = distance[graph.getVertexList().indexOf(searchOriginVertex())][graph.getVertexList().indexOf(searchDestinyVertex())];
                if (priceDistance == Graph.INF) {
                    JOptionPane.showMessageDialog(null, "No puedes ir de " + searchOriginVertex().getCity() + " a " + searchDestinyVertex().getCity());
                } else {
                    JOptionPane.showMessageDialog(null, "La ruta mínima para ir de: " + originBox.getSelectedItem().toString()
                            + " a " + destinyBox.getSelectedItem().toString() + " cuesta " + priceDistance, "Ruta mínima", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Selecciona dos ciudades en el combo box y presiona el boton de Floyd Warshall");
            }
        } catch (Exception e) {

        }

    }//GEN-LAST:event_priceActionPerformed

    private Vertex searchOriginVertex() {
        for (Vertex v : graph.getVertexList()) {
            if (originBox.getSelectedItem().toString().equalsIgnoreCase(v.getCity())) {
                return v;
            }
        }
        return null;
    }

    private Vertex searchDestinyVertex() {
        for (Vertex v : graph.getVertexList()) {
            if (destinyBox.getSelectedItem().toString().equalsIgnoreCase(v.getCity())) {
                return v;
            }
        }
        return null;
    }

    private void helpLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_helpLabelMouseClicked

        JOptionPane.showMessageDialog(null, "Para agregar vertices presiona click izquierdo"
                + " en el mapa. \nPara agregar aristas de un vertice a otro presiona click derecho"
                + ", primero presiona en el vertice origen y luego en el vertice destino."
                + "\nPara calcular la ruta mínima utiliza el comboBox y selecciona la ciudad origen y la destino,"
                + " luego presiona el boton de floyd warshall y luego en la moneda.", "Ayuda", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_helpLabelMouseClicked

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed

        try {
            int j, init = graph.getVertexList().size();
            String ans = JOptionPane.showInputDialog(null, "¿Cual vertice desea eliminar?", "Eliminar", JOptionPane.QUESTION_MESSAGE);
            if (!ans.isEmpty() && ans != null) {
                j = graph.deleteVertex(ans);
                graph.deleteEdge(ans);
                deleteFromOriginBox(j);
                deleteFromDestinyBox(j);
                if (init > graph.getVertexList().size()) {
                    map2.paint(map2.getGraphics());
                    paintAgainGraph();
                }
            }
        } catch (Exception e) {

        }


    }//GEN-LAST:event_deleteButtonActionPerformed

    private void paintAgainGraph() {
        map2.revalidate();
        graphics.paintAgainVertex((Graphics2D) map2.getGraphics(), graph.getVertexList());
        graphics.paintAgainEdges((Graphics2D) map2.getGraphics(), graph.getEdgesList());
    }

    private void deleteFromOriginBox(int i) {
        if (i != -1) originBox.removeItemAt(i);
    }

    private void deleteFromDestinyBox(int j) {
        if (j != -1) destinyBox.removeItemAt(j);
    }

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
    private javax.swing.JButton deleteButton;
    private javax.swing.JComboBox<String> destinyBox;
    private javax.swing.JLabel destinyLabel;
    private javax.swing.JLabel helpLabel;
    private javax.swing.JPanel map;
    private javax.swing.JLabel map2;
    private javax.swing.JComboBox<String> originBox;
    private javax.swing.JLabel originLabel;
    private javax.swing.JButton price;
    private javax.swing.JLabel priceLabel;
    // End of variables declaration//GEN-END:variables
}
