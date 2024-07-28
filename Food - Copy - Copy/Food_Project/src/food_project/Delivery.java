/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package food_project;

import food_project2.conn;
import food_project2.Home;
import java.sql.*;
import javax.swing.JOptionPane;
public class Delivery extends javax.swing.JFrame {
    private String empID;
   Connection con = null;
   ResultSet rs = null;
   PreparedStatement ps = null;
   
    public Delivery(int customerId ) {
        initComponents();
         this.empID = empID;
         con = conn.mycon();  
        this.setExtendedState(Home.MAXIMIZED_BOTH);
       // Assuming you have the customer ID stored in a variable called customerId
   fetchCustomerDetails(customerId);
   fetchOrderDetails(customerId);

    }

   private void insertOrderData(String name, String phone, int paymentMode, String country, String state, String pin, String address, String products, int totalPrice) {
        try {
            String query = "INSERT INTO orders (Name, Phone, Payment_mode, Country, State, Pin_code, Address, Products, Total_Price, Time) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, name);
            pst.setString(2, phone);
            pst.setInt(3, paymentMode);
            pst.setString(4, country);
            pst.setString(5, state);
            pst.setString(6, pin);
            pst.setString(7, address);
            pst.setString(8, products);
            pst.setInt(9, totalPrice);
            pst.setTimestamp(10, new Timestamp(System.currentTimeMillis()));
            pst.executeUpdate();
            System.out.println("Data inserted successfully.");
        } catch (SQLException e) {
            System.out.println("Error inserting data.");
            e.printStackTrace();
        }
    }

   private void fetchCustomerDetails(int customerId) {
    try {
        String query = "SELECT ID, Name, Phone FROM customer_details WHERE ID = ?";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setInt(1, customerId);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            id.setText(rs.getString("ID"));
            name.setText(rs.getString("Name"));
            phone.setText(rs.getString("Phone"));
        }
    } catch (SQLException e) {
        System.out.println("Error fetching customer details.");
        e.printStackTrace();
    }
}

private void fetchOrderDetails(int customerId) {
    try {
        String query = "SELECT product_name, quantity, price, Net_value FROM orderdetails WHERE Customer_id = ?";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setInt(1, customerId);
        ResultSet rs = pst.executeQuery();
        int totalAmount = 0;
        StringBuilder productsBuilder = new StringBuilder();
        while (rs.next()) {
            String productName = rs.getString("product_name");
            int quantity = rs.getInt("quantity");
            int netValue = rs.getInt("Net_value");
            totalAmount += netValue;
            productsBuilder.append(productName).append(" (").append(quantity).append("), ");
        }
        String products = productsBuilder.toString();
        if (!products.isEmpty()) {
            products = products.substring(0, products.length() - 2); // Remove the trailing comma and space
        }
        product.setText(products);
        amt.setText(String.valueOf(totalAmount));
    } catch (SQLException e) {
        System.out.println("Error fetching order details.");
        e.printStackTrace();
    }
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        payment = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        phone = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        product = new javax.swing.JLabel();
        amt = new javax.swing.JLabel();
        country = new javax.swing.JTextField();
        state = new javax.swing.JTextField();
        Address = new javax.swing.JTextField();
        pin = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel1.setText("Enter Your Pin Code");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 150, 140, -1));

        payment.setText("jTextField1");
        jPanel1.add(payment, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 200, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel2.setText("Your Full Name");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 100, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel3.setText("Your Phone no.");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 110, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel4.setText("Customer ID");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 100, -1));

        id.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        id.setText("jLabel1");
        jPanel1.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, 70, -1));

        name.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        name.setText("jLabel1");
        jPanel1.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, 70, -1));

        phone.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        phone.setText("jLabel1");
        jPanel1.add(phone, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, 70, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel8.setText("Enter Your Country");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, 130, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel9.setText("Enter Your State");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, 120, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel10.setText("Enter Your Address ");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 90, 130, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel11.setText("Your Total Amount");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 300, 130, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel12.setText("Enter Payment Mode");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 200, 150, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel13.setText("Your Products");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 250, 100, -1));

        product.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        product.setText("jLabel1");
        jPanel1.add(product, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 250, 70, -1));

        amt.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        amt.setText("jLabel1");
        jPanel1.add(amt, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 300, 70, -1));

        country.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                countryActionPerformed(evt);
            }
        });
        jPanel1.add(country, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 260, -1, -1));

        state.setText("jTextField1");
        jPanel1.add(state, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 300, -1, -1));

        Address.setText("jTextField1");
        jPanel1.add(Address, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 90, 300, -1));

        pin.setText("jTextField1");
        jPanel1.add(pin, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 150, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1190, 630));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void countryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_countryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_countryActionPerformed

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
            java.util.logging.Logger.getLogger(Delivery.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Delivery.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Delivery.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Delivery.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
             String empID = "Emp_ID"; // Replace "123" with an actual employee ID from your database
            try {
                new emp_update_form(empID).setVisible(true);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Address;
    private javax.swing.JLabel amt;
    private javax.swing.JTextField country;
    private javax.swing.JLabel id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel name;
    private javax.swing.JTextField payment;
    private javax.swing.JLabel phone;
    private javax.swing.JTextField pin;
    private javax.swing.JLabel product;
    private javax.swing.JTextField state;
    // End of variables declaration//GEN-END:variables
}
