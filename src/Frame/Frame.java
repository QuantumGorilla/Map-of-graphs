package Frame;

import Data.Graphics;
import Data.Edge;
import Data.Graph;
import Data.Helper;
import Data.Node;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Alejandro
 */
public class Frame extends javax.swing.JFrame {

    public static ArrayList<Node> nodes = new ArrayList<>();
    public static ArrayList<Edge> edges = new ArrayList<>();
    private int[][] distance;
    private Node origin;
    private Node destiny;
    private Node helperNode;
    private Graphics music = new Graphics();

    public Frame(){
        initComponents();
        setScreenLocation();
        music.playMusic();
    }

    private void setScreenLocation() {
        this.setLocationRelativeTo(null);
    }
    
    public void paint(java.awt.Graphics g, Node n) {
        map2.revalidate();

        g.setColor(Color.decode("#304fb5"));
        g.fillOval(n.getPosX(), n.getPosY(), 55, 55);
        g.setColor(Color.decode("#80da03"));
        g.drawOval(n.getPosX(), n.getPosY(), 55, 55);

        g.setColor(Color.BLACK);
        g.drawString(n.getCity(), n.getPosX() + 5, n.getPosY() + 30);
    }

    public void paintDistance(java.awt.Graphics g, Node a, Node b, int distance) {
        map2.revalidate();

        g.setColor(Color.decode("#e5bf23"));
        g.drawLine(a.getPosX() + 10, a.getPosY() + 10, b.getPosX() + 10, b.getPosY() + 10);

        g.setColor(Color.decode("#ff7e00"));
        g.drawString(String.valueOf(distance), ((a.getPosX() + b.getPosX()) / 2) + 10, ((a.getPosY() + b.getPosY()) / 2) + 10);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        map = new javax.swing.JPanel();
        helpLabel = new javax.swing.JLabel();
        map2 = new javax.swing.JLabel();
        price = new javax.swing.JButton();
        originLabel = new javax.swing.JLabel();
        destinyLabel = new javax.swing.JLabel();
        originBox = new javax.swing.JComboBox<>();
        destinyBox = new javax.swing.JComboBox<>();
        priceField = new javax.swing.JTextField();
        floydButton = new javax.swing.JButton();
        priceLabel = new javax.swing.JLabel();
        backGroundPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        map.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        map.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        helpLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Help-icon.png"))); // NOI18N
        helpLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                helpLabelMouseClicked(evt);
            }
        });
        map.add(helpLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        map2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Mario world.png"))); // NOI18N
        map2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                map2MouseClicked(evt);
            }
        });
        map.add(map2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 390));

        getContentPane().add(map, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 388));

        price.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/price tag icon.png"))); // NOI18N
        price.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.white, java.awt.Color.lightGray, java.awt.Color.white));
        price.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceActionPerformed(evt);
            }
        });
        getContentPane().add(price, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 417, 60, 50));

        originLabel.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        originLabel.setText("Ciudad origen");
        getContentPane().add(originLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 394, -1, 32));

        destinyLabel.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        destinyLabel.setText("Ciudad destino");
        getContentPane().add(destinyLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(227, 399, -1, 27));

        originBox.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        originBox.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(originBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 140, 30));

        destinyBox.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        destinyBox.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(destinyBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 430, 150, 30));

        priceField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                priceFieldKeyTyped(evt);
            }
        });
        getContentPane().add(priceField, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 430, 179, 30));

        floydButton.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        floydButton.setText("Floyd Warshall");
        floydButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                floydButtonActionPerformed(evt);
            }
        });
        getContentPane().add(floydButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 470, 170, 30));

        priceLabel.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        priceLabel.setText("Costo:");
        getContentPane().add(priceLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 430, -1, 30));

        backGroundPanel.setBackground(new java.awt.Color(255, 255, 255));
        backGroundPanel.setForeground(new java.awt.Color(255, 255, 255));
        backGroundPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(backGroundPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, 750, 120));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void map2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_map2MouseClicked

        if (evt.getButton() == MouseEvent.BUTTON1) {
            if (nodes.isEmpty()) {
                helperNode = Graphics.answer(JOptionPane.showInputDialog(null, "Quieres añadir un lugar en esta posiciòn? Si / No", "Añadir", JOptionPane.INFORMATION_MESSAGE), evt.getX(), evt.getY());
                if (helperNode != null) {
                    nodes.add(helperNode);
                    addNodesInComboBox();
                    paint(map2.getGraphics(), nodes.get(Helper.nodeCount));
                    Helper.plusOneNode();
                }
            } else {
                if (Graphics.checkNodesPosition(nodes, evt.getX(), evt.getY())) {
                    Helper.errorMessage();
                } else {
                    helperNode = Graphics.answer(JOptionPane.showInputDialog(null, "Quieres añadir un lugar en esta posiciòn? Si / No", "Añadir", JOptionPane.INFORMATION_MESSAGE), evt.getX(), evt.getY());
                    if (helperNode != null) {
                        nodes.add(helperNode);
                        addNodesInComboBox();
                        paint(map2.getGraphics(), nodes.get(Helper.nodeCount));
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
                    paintDistance(map2.getGraphics(), edges.get(Helper.relationCount).getNodeOrigin(), edges.get(Helper.relationCount).getNodeDestiny(),
                            edges.get(Helper.relationCount).getDistance());
                    Helper.plusOneRelation();
                    origin = destiny = null;
                }
            }
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

        if (searchOriginNode() != null && searchDestinyNode() != null && distance != null) {
            int price = distance[nodes.indexOf(searchOriginNode())][nodes.indexOf(searchDestinyNode())];
            if (price == Graph.INF) {
                JOptionPane.showMessageDialog(null, "Parece que no puedes ir de " + searchOriginNode().getCity() + " a " + searchDestinyNode().getCity());
            } else {
                priceField.setText(String.valueOf(price));
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecciona dos ciudades en el combo box y presiona el boton de Floyd Warshall");
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

        distance = Graph.getDistanceMatrix();
        Graph.floyd(distance);

    }//GEN-LAST:event_floydButtonActionPerformed

    private void helpLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_helpLabelMouseClicked

        JOptionPane.showMessageDialog(null, "Para agregar vertices presiona click izquierdo"
                + " en el mapa. Para agregar aristas de un vertice a otro presiona click derecho"
                + ", primero presiona en el vertice origen y luego en el vertice destino."
                + "\nPara calcular la ruta mínima utiliza el comboBox y selecciona la ciudad origen y la destino,"
                + " luego presiona el boton de floyd warshall y luego la etiqueta del precio.", "Ayuda", JOptionPane.INFORMATION_MESSAGE);
        
    }//GEN-LAST:event_helpLabelMouseClicked

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info
                    : javax.swing.UIManager
                            .getInstalledLookAndFeels()) {
                if ("Windows".equals(info
                        .getName())) {
                    javax.swing.UIManager
                            .setLookAndFeel(info
                                    .getClassName());

                    break;

                }
            }
        } catch (ClassNotFoundException
                | InstantiationException
                | IllegalAccessException
                | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger
                    .getLogger(Frame.class
                            .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue
                .invokeLater(() -> {
                    new Frame().setVisible(true);

                });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel backGroundPanel;
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
