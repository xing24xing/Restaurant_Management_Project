/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package food_project;

import food_project2.conn;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class Product_details extends javax.swing.JFrame {

    Connection con = null;
   ResultSet rs = null;
   PreparedStatement ps = null;
  
    public Product_details() {
        initComponents();
         con = conn.mycon(); 
         fetchDataFromDatabase(search.getText());
    }
 private void fetchDataFromDatabase(String customerID) {
        try {
            String query = "SELECT customer_details.ID, customer_details.Name, customer_details.Email, " +
                           "customer_details.Username, customer_details.Phone, orders.total_net_value " +
                           "FROM customer_details " +
                           "INNER JOIN orders ON customer_details.ID = orders.customer_id " +
                           "WHERE customer_details.ID = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, customerID);
            rs = ps.executeQuery();
            
            DefaultTableModel model = (DefaultTableModel) rec.getModel();
            model.setRowCount(0); // Clear existing rows
            
            while (rs.next()) {
                String[] row = {
                    rs.getString("ID"),
                    rs.getString("Name"),
                    rs.getString("Email"),
                    rs.getString("Username"),
                    rs.getString("Phone"),
                    rs.getString("total_net_value")
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        rec = new javax.swing.JTable();
        search_btn = new javax.swing.JButton();
        search = new javax.swing.JTextField();
        lab = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rec.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7"
            }
        ));
        jScrollPane1.setViewportView(rec);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 770, -1));

        search_btn.setBackground(new java.awt.Color(0, 0, 204));
        search_btn.setFont(new java.awt.Font("Serif", 1, 16)); // NOI18N
        search_btn.setForeground(new java.awt.Color(255, 255, 255));
        search_btn.setText("Search");
        jPanel1.add(search_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, -1, -1));

        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        jPanel1.add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 30, 200, 30));

        lab.setFont(new java.awt.Font("Serif", 3, 22)); // NOI18N
        lab.setText("Enter Customer ID : -");
        jPanel1.add(lab, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1190, 670));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Product_details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Product_details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Product_details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Product_details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Product_details().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lab;
    private javax.swing.JTable rec;
    private javax.swing.JTextField search;
    private javax.swing.JButton search_btn;
    // End of variables declaration//GEN-END:variables
}
