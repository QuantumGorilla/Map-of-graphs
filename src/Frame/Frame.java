package Frame;

import Data.Relations;
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

    ArrayList<Node> nodes = new ArrayList<>();
    Relations g;

    public Frame() {
        initComponents();
        setScreenLocation();
    }

    private void setScreenLocation() {
        this.setLocationRelativeTo(null);
    }

    public void paint(java.awt.Graphics graphics, Node n) {
        map2.revalidate();

        graphics.setColor(Color.white);
        graphics.fillOval(n.getX() - 5, n.getY() - 5, 55, 55);
        graphics.drawOval(n.getX() - 5, n.getY() - 5, 55, 55);

        graphics.setColor(Color.black);
        graphics.drawString(n.getCity(), n.getX(), n.getY() + 25);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        map = new javax.swing.JPanel();
        map2 = new javax.swing.JLabel();
        price = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        origin = new javax.swing.JComboBox<>();
        destiny = new javax.swing.JComboBox<>();
        priceField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        map.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        map.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        map2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/horizon-zero-dawn-mapa.jpg"))); // NOI18N
        map2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                map2MouseClicked(evt);
            }
        });
        map.add(map2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-230, 0, 1040, 390));

        getContentPane().add(map, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 388));

        price.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/price tag icon.png"))); // NOI18N
        price.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.white, java.awt.Color.lightGray, java.awt.Color.white));
        price.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(price, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 417, 60, 50));

        jLabel1.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jLabel1.setText("Ciudad origen");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 394, -1, 32));

        jLabel2.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jLabel2.setText("Ciudad destino");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(227, 399, -1, 27));

        origin.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        origin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(origin, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 432, 102, 30));

        destiny.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        destiny.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(destiny, new org.netbeans.lib.awtextra.AbsoluteConstraints(227, 432, 109, 30));

        priceField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                priceFieldKeyTyped(evt);
            }
        });
        getContentPane().add(priceField, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 430, 179, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void map2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_map2MouseClicked

        if (evt.getButton() == MouseEvent.BUTTON1) {

            String answer = JOptionPane.showInputDialog(null, "Quieres añadir un lugar en esta posiciòn? Si / No", "Añadir", JOptionPane.INFORMATION_MESSAGE);

            if (!answer.isEmpty() && answer.equalsIgnoreCase("Si")) {

                String city = Helper.checkCityName(JOptionPane.showInputDialog(null, "Nombre de la ciudad", "Ciudad", JOptionPane.INFORMATION_MESSAGE));
                String hood = Helper.checkHoodName(JOptionPane.showInputDialog(null, "Nombre del barrio", "Barrio", JOptionPane.INFORMATION_MESSAGE));
                String country = Helper.checkCountryName(JOptionPane.showInputDialog(null, "Nombre del país", "Pais", JOptionPane.INFORMATION_MESSAGE));

                if (nodes.isEmpty()) {
                    addNodes(evt.getX(), evt.getY(), city, hood, country);
                    paint(map2.getGraphics(), nodes.get(Helper.nodeCount));
                    Helper.plusOneNode();
                } else {
                    if (Helper.checkNodesPosition(nodes, evt.getX(), evt.getY())) {
                        Helper.errorMessage();
                    } else {
                        addNodes(evt.getX(), evt.getY(), city, hood, country);
                        paint(map2.getGraphics(), nodes.get(Helper.nodeCount));
                        Helper.plusOneNode();
                    }
                }
            }
        }

    }//GEN-LAST:event_map2MouseClicked

    private void addNodes(int x, int y, String city, String hood, String country) {
        nodes.add(new Node(x, y, city, hood, country));
        addNodesInComboBox();
    }

    private void addNodesInComboBox() {
        destiny.insertItemAt(nodes.get(Helper.nodeCount).getCity() + "/" + nodes.get(Helper.nodeCount).getCountry(), Helper.nodeCount);
        origin.insertItemAt(nodes.get(Helper.nodeCount).getCity() + "/" + nodes.get(Helper.nodeCount).getCountry(), Helper.nodeCount);
    }

    private void priceFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_priceFieldKeyTyped

        evt.consume();

    }//GEN-LAST:event_priceFieldKeyTyped

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
    private javax.swing.JComboBox<String> destiny;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel map;
    private javax.swing.JLabel map2;
    private javax.swing.JComboBox<String> origin;
    private javax.swing.JButton price;
    private javax.swing.JTextField priceField;
    // End of variables declaration//GEN-END:variables
}
