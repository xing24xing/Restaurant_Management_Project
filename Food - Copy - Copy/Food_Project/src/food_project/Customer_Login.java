/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package food_project;

import food_project2.conn;
import food_project2.Home;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import javax.swing.JOptionPane;
public class Customer_Login extends javax.swing.JFrame {
Connection con = null;
   ResultSet rs = null;
   PreparedStatement ps = null;
   private String loggedInUserName;
    private int loggedInUserID;
    public Customer_Login() {
        initComponents();
        con = conn.mycon();  
        this.setExtendedState(Home.MAXIMIZED_BOTH);
    }

       private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getLoggedInUserName() {
        return loggedInUserName;
    }

    public int getLoggedInUserID() {
        return loggedInUserID;
    }

    // Method to set loggedInUserName and loggedInUserID after successful login
    private void setLoggedInUser(String userName, int userID) {
        this.loggedInUserName = userName;
        this.loggedInUserID = userID;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        pass = new javax.swing.JTextField();
        userName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        login = new javax.swing.JButton();
        forget_password = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 255));
        jLabel2.setText("Enter Username");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 240, 210, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 255));
        jLabel5.setText("Enter Password");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 340, 210, -1));

        pass.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        getContentPane().add(pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 340, 210, 30));

        userName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        getContentPane().add(userName, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 250, 210, 30));

        jLabel3.setFont(new java.awt.Font("Bookman Old Style", 3, 30)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 0));
        jLabel3.setText("Enter The Details To Login");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 140, 470, -1));

        login.setBackground(new java.awt.Color(0, 0, 204));
        login.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        login.setForeground(new java.awt.Color(255, 255, 255));
        login.setText("Login");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        getContentPane().add(login, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 440, 150, -1));

        forget_password.setBackground(new java.awt.Color(204, 0, 0));
        forget_password.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        forget_password.setForeground(new java.awt.Color(255, 255, 255));
        forget_password.setText("Forget Password");
        forget_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forget_passwordActionPerformed(evt);
            }
        });
        getContentPane().add(forget_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 520, 200, -1));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Vivaldi", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(32, 163, 103));
        jLabel7.setText("K - Food");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 190, -1));

        back.setBackground(new java.awt.Color(204, 204, 204));
        back.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        getContentPane().add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 20, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
    String username = userName.getText();
        String password = pass.getText();

        // Hash the password entered by the user
        String hashedPassword = hashPassword(password);

        // Validate username input and compare hashed passwords
        try {
            String sql = "SELECT * FROM customer_details WHERE username = ? AND password = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, hashedPassword);
            rs = ps.executeQuery();
            if (rs.next()) {
                // Login successful
                loggedInUserName = rs.getString("Name");
                loggedInUserID = rs.getInt("ID");
                JOptionPane.showMessageDialog(rootPane, "Login Successful! Welcome, " + loggedInUserName + "!");
                // Open your Admin_Panel here
                // Menu1 menu = new Menu1();
                // menu.setVisible(true);
            } else {
                // Login failed
                JOptionPane.showMessageDialog(rootPane, "Login Failed! Incorrect username or password.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(rootPane, "Login Failed! An error occurred.");
        }
    }//GEN-LAST:event_loginActionPerformed

    private void forget_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forget_passwordActionPerformed
        Customer_Pass_Reset reset = new Customer_Pass_Reset();
        reset.setVisible(true);
    }//GEN-LAST:event_forget_passwordActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        this.dispose(); // Terminate the current JFrame
        Customer_Dash det= new Customer_Dash(); // Create an instance of the Employee_Panel class
        det.setVisible(true); // Make the Employee_Panel visible
    }//GEN-LAST:event_backActionPerformed

    
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
            java.util.logging.Logger.getLogger(Customer_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Customer_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Customer_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Customer_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Customer_Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JButton forget_password;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JButton login;
    private javax.swing.JTextField pass;
    private javax.swing.JTextField userName;
    // End of variables declaration//GEN-END:variables
}
