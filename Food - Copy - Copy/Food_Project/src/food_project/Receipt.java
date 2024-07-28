/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package food_project;

import food_project2.Home;
import food_project2.Session;
import food_project2.conn;
import javax.swing.table.DefaultTableModel;

import java.sql.*;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;

public class Receipt extends javax.swing.JFrame {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public Receipt(DefaultTableModel dataModel) {
        initComponents();
       
           loadReceiptDetails();
            String[] columnNames = {"Name", "Price", "Quantity", "Net Value"};

    // Initialize the table model with four columns
    DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
    Receive.setModel(tableModel);

    jScrollPane1.setViewportView(Receive);
    
        
    }
private void loadReceiptDetails() {
        // Retrieve cart items from session
        List<Map<String, Object>> cartItems = (List<Map<String, Object>>) ProductSession.get("cartItems");

        // Display cart items in the table
        if (cartItems != null) {
            DefaultTableModel tableModel = (DefaultTableModel) Receive.getModel();
            for (Map<String, Object> item : cartItems) {
                String name = (String) item.get("name");
                double price = (double) item.get("price");
                int quantity = (int) item.get("quantity");
                double netValue = (double) item.get("net_value");
                // Add the data to the table model
                tableModel.addRow(new Object[]{name, price, quantity, netValue});
            }
        } else {
            JOptionPane.showMessageDialog(this, "Cart is empty!");
        }
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        record = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Receive = new javax.swing.JTable();
        Address = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Name = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Phone = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Vivaldi", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(32, 163, 103));
        jLabel7.setText("K - Food");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 190, -1));

        record.setBackground(new java.awt.Color(255, 255, 255));
        record.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Receive.setFont(new java.awt.Font("SimHei", 1, 14)); // NOI18N
        Receive.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(Receive);

        record.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 350, 210));

        Address.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        Address.setForeground(new java.awt.Color(51, 51, 255));
        Address.setText("Customer  ");
        record.add(Address, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 280, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        jLabel8.setText("Customer Name : ");
        record.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));

        Name.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        Name.setForeground(new java.awt.Color(51, 51, 255));
        Name.setText("Customer  ");
        record.add(Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 60, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        jLabel10.setText("Phone no.");
        record.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, -1, -1));

        Phone.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        Phone.setForeground(new java.awt.Color(51, 51, 255));
        Phone.setText("Customer ");
        record.add(Phone, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 140, 100, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        jLabel12.setText("Address : ");
        record.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, -1));

        jLabel3.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 51));
        jLabel3.setText("['Add : Mumbai ,401203'] ['Phone no : 1234567890']");
        record.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 380, 30));

        jLabel2.setFont(new java.awt.Font("Vivaldi", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 153));
        jLabel2.setText("K - Food");
        record.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 90, -1));

        jLabel4.setFont(new java.awt.Font("Serif", 3, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 153, 0));
        jLabel4.setText("Receipt");
        record.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, 100, -1));

        jLabel5.setFont(new java.awt.Font("Sitka Text", 3, 10)); // NOI18N
        jLabel5.setText("['Delicious Food Items From All Over The World']");
        record.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 260, 30));

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        jLabel6.setText("Authentic Continental Food  At Its Finest");
        record.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 330, 30));

        getContentPane().add(record, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 40, 410, 440));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // Creating an instance of DefaultTableModel
                DefaultTableModel dataModel = new DefaultTableModel();
                // Populate the dataModel with your data
                // For example:
                // dataModel.addRow(new Object[]{"Column 1 Data", "Column 2 Data", "Column 3 Data", "Column 4 Data"});
                // Creating an instance of Receipt and passing data model
                new Receipt(dataModel).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Address;
    private javax.swing.JLabel Name;
    private javax.swing.JLabel Phone;
    private javax.swing.JTable Receive;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel record;
    // End of variables declaration//GEN-END:variables
}
