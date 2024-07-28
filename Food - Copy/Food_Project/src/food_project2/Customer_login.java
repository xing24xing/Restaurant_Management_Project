/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package food_project2;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
public class Customer_login extends javax.swing.JPanel {
Connection con = null;
   ResultSet rs = null;
   private JPanel child2;
   
           private String loggedInUserName;
    private int loggedInUserID;

     JpanelLoader Jload = new JpanelLoader();
   PreparedStatement ps = null;
   private Customer_Dashboard dash;
    public Customer_login(JPanel child2, Customer_Dashboard dash) {
        initComponents();
        this.dash = dash;
        this.child2 = child2;
         con = food_project2.conn.mycon(); 
          sign_in.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseClicked(java.awt.event.MouseEvent evt) {
        sign_inMouseClicked(evt);
    }
});
      

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
     public void goBackToChild2() {
        // Reload the main components of child2
        // You can implement this method according to your JPanel structure
        // For example:
        jPanelLoader(child2, login_pane); // Replace mainChild2Panel with your actual child2 main panel
    }
  public void jPanelLoader(JPanel parent, JPanel child) {
    parent.removeAll();
    parent.add(child);
    parent.revalidate();
    parent.repaint();
}
     private void sign_inMouseClicked(java.awt.event.MouseEvent evt) {
     // Create an instance of the login_admin class
    Customer_Register reg= new Customer_Register(child2,dash);

    // Load the login panel into the child2 panel of the Home frame
    Jload.jPanelLoader(child2, reg);
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
        }   } @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        login_pane = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        userName = new javax.swing.JTextField();
        login = new javax.swing.JButton();
        forget_password = new javax.swing.JButton();
        back = new javax.swing.JButton();
        login_lab1 = new javax.swing.JLabel();
        sign_in = new javax.swing.JLabel();
        img = new javax.swing.JLabel();
        pass = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        login_pane.setBackground(new java.awt.Color(255, 255, 255));
        login_pane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Bookman Old Style", 3, 30)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 0));
        jLabel3.setText("Enter The Details To Login");
        login_pane.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 150, 470, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI Variable", 1, 24)); // NOI18N
        jLabel2.setText("Enter Username");
        login_pane.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 230, 210, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI Variable", 1, 24)); // NOI18N
        jLabel5.setText("Enter Password");
        login_pane.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 320, 210, -1));

        userName.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        login_pane.add(userName, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 240, 210, 35));

        login.setBackground(new java.awt.Color(0, 0, 204));
        login.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        login.setForeground(new java.awt.Color(255, 255, 255));
        login.setText("Login");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        login_pane.add(login, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 450, 130, 45));

        forget_password.setBackground(new java.awt.Color(204, 0, 0));
        forget_password.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        forget_password.setForeground(new java.awt.Color(255, 255, 255));
        forget_password.setText("Forget Password");
        forget_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forget_passwordActionPerformed(evt);
            }
        });
        login_pane.add(forget_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 520, 200, 40));

        back.setBackground(new java.awt.Color(51, 51, 51));
        back.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        back.setForeground(new java.awt.Color(255, 255, 255));
        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        login_pane.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 70, 90, 40));

        login_lab1.setFont(new java.awt.Font("Shruti", 1, 14)); // NOI18N
        login_lab1.setText("IF You Don't Have A/c");
        login_pane.add(login_lab1, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 460, 150, -1));

        sign_in.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        sign_in.setForeground(new java.awt.Color(255, 0, 0));
        sign_in.setText(",Click to Create");
        login_pane.add(sign_in, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 450, 130, 40));
        login_pane.add(img, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 20, 200, 100));

        pass.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        login_pane.add(pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 310, 210, 35));

        jLabel1.setIcon(new javax.swing.ImageIcon("E:\\Food - Copy\\cheff6.png")); // NOI18N
        login_pane.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, -10, -1, -1));

        add(login_pane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1400, 700));
    }// </editor-fold>//GEN-END:initComponents

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
     String username = userName.getText();
    String password = pass.getText();

    // Hash the password entered by the user
    String hashedPassword = hashPassword(password);

    // Validate username input and compare hashed passwords
    try {
        String sql = "SELECT * FROM Customer_Details WHERE username = ?";
        ps = con.prepareStatement(sql);
        ps.setString(1, username);
        rs = ps.executeQuery();
        if (rs.next()) {
            String dbPassword = rs.getString("password");
            if (hashedPassword.equals(dbPassword)) {
                // Passwords match, login successful
                String dbUsername = rs.getString("username");
                int userID = rs.getInt("ID");
                
                // Set the logged-in user details in the session
                SessionManager.setCurrentUser(dbUsername);
                SessionManager.setCurrentUserID(userID);

                JOptionPane.showMessageDialog(this, "Login Successful! Welcome, " + dbUsername + "!");
                // Open your Admin_Panel here
                dash.goToChild2();
                 
            } else {
                // Passwords don't match, login failed
                JOptionPane.showMessageDialog(this, "Login Failed! Incorrect password.");
            }
        } else {
            // No user found with the entered username
            JOptionPane.showMessageDialog(this, "Login Failed! Incorrect username.");
        }
    } catch (Exception e) {
        System.out.println(e);
    }
    }//GEN-LAST:event_loginActionPerformed

    private void forget_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forget_passwordActionPerformed
       Customer_Pass_Reset del = new Customer_Pass_Reset(child2,this);
        Jload.jPanelLoader(child2,del);
    }//GEN-LAST:event_forget_passwordActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to go back?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            // Navigate back to Emp_Panel using the reference
            dash.goToChild2();
        }
    }//GEN-LAST:event_backActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JButton forget_password;
    private javax.swing.JLabel img;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton login;
    private javax.swing.JLabel login_lab1;
    private javax.swing.JPanel login_pane;
    private javax.swing.JPasswordField pass;
    private javax.swing.JLabel sign_in;
    private javax.swing.JTextField userName;
    // End of variables declaration//GEN-END:variables
}
