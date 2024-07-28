/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package food_project2;


import java.sql.*;
import java.awt.CardLayout;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Stack;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
public class login_admin extends javax.swing.JPanel {
    JpanelLoader Jload = new JpanelLoader();
     private boolean isLoggedIn = false; // Track l
     private JPanel child2;
    private final Home homeFrame; // Add reference to Home frame

   Connection con = null;
   ResultSet rs = null;
   PreparedStatement ps = null;
  
    public login_admin(JPanel child2, Home homeFrame) {
        initComponents();
         isLoggedIn = false;
         this.child2 = child2;
        this.homeFrame = homeFrame; 
        con = food_project2.conn.mycon();
             sign_in.addMouseListener(new java.awt.event.MouseAdapter() {
    @Override
    public void mouseClicked(java.awt.event.MouseEvent evt) {
        sign_inMouseClicked(evt);
    }
});
    }
       
 private void sign_inMouseClicked(java.awt.event.MouseEvent evt) {
     // Create an instance of the login_admin class
    Register_admin reg= new Register_admin(child2, homeFrame);

    // Load the login panel into the child2 panel of the Home frame
    Jload.jPanelLoader(child2, reg);
}
    
   public void goBackToChild2() {
        // Reload the main components of child2
        // You can implement this method according to your JPanel structure
        // For example:
        jPanelLoader(child2, login); // Replace mainChild2Panel with your actual child2 main panel
    }
  public void jPanelLoader(JPanel parent, JPanel child) {
    parent.removeAll();
    parent.add(child);
    parent.revalidate();
    parent.repaint();
}
    
private void loginSuccess(String username) {
        if (username == null || username.isEmpty()) {
        System.err.println("Invalid username provided: " + username);
        return;
    }

    Session session = Session.getInstance();
    session.setLoggedIn(true);
    session.setUsername(username);
    homeFrame.loginSuccess(); // Notify the Home frame about the successful login
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
    public interface BackButtonCallback {
    void onBackButtonClicked();
}
private boolean isAdminActive(String username) {
    try {
        String sql = "SELECT status FROM admin WHERE username = ?";
        ps = con.prepareStatement(sql);
        ps.setString(1, username);
        rs = ps.executeQuery();
        if (rs.next()) {
            String status = rs.getString("status");
            return status.equals("active");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        // Close resources
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    // Default to not active
    return false;
}
private int getLoginStatus(String username, String hashedPassword) throws SQLException {
    if (!isAdminActive(username)) {
        return -1; // Admin account is deactivated
    }
    
    String sql = "SELECT * FROM admin WHERE username = ?";
    ps = con.prepareStatement(sql);
    ps.setString(1, username);
    rs = ps.executeQuery();
    if (rs.next()) {
        String dbPassword = rs.getString("password");
        if (hashedPassword.equals(dbPassword)) {
            return 1; // Login successful
        } else {
            return 0; // Incorrect password
        }
    } else {
        return -2; // Incorrect username
    }
}

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        login = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Username = new javax.swing.JLabel();
        Password = new javax.swing.JLabel();
        userNameField = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        Back = new javax.swing.JButton();
        Login = new javax.swing.JButton();
        Forget = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        login_lab1 = new javax.swing.JLabel();
        sign_in = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        login.setBackground(new java.awt.Color(255, 255, 255));
        login.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Rockwell Nova Extra Bold", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setText("Admin Login Form");
        login.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 110, 320, -1));

        Username.setFont(new java.awt.Font("Myanmar Text", 1, 26)); // NOI18N
        Username.setText("Enter Username");
        login.add(Username, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 210, -1, -1));

        Password.setFont(new java.awt.Font("Myanmar Text", 1, 26)); // NOI18N
        Password.setText("Enter Password");
        login.add(Password, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 300, 200, -1));

        userNameField.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        userNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userNameFieldActionPerformed(evt);
            }
        });
        login.add(userNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 210, 280, 40));

        passwordField.setFont(new java.awt.Font("Segoe UI", 1, 20
        ));
        login.add(passwordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 300, 280, 40));

        Back.setBackground(new java.awt.Color(102, 102, 102));
        Back.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        Back.setForeground(new java.awt.Color(255, 255, 255));
        Back.setText("Back");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });
        login.add(Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 40, -1, -1));

        Login.setBackground(new java.awt.Color(0, 0, 153));
        Login.setFont(new java.awt.Font("Segoe UI Black", 1, 22)); // NOI18N
        Login.setForeground(new java.awt.Color(255, 255, 255));
        Login.setText("Login");
        Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginActionPerformed(evt);
            }
        });
        login.add(Login, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 400, -1, -1));

        Forget.setBackground(new java.awt.Color(204, 0, 0));
        Forget.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        Forget.setForeground(new java.awt.Color(255, 255, 255));
        Forget.setText("Forgot Password");
        Forget.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ForgetActionPerformed(evt);
            }
        });
        login.add(Forget, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 470, 240, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon("E:\\Food\\file2.png")); // NOI18N
        login.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 200, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon("E:\\Food\\cheff6.png")); // NOI18N
        login.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, -40, -1, -1));

        login_lab1.setFont(new java.awt.Font("Shruti", 1, 14)); // NOI18N
        login_lab1.setText("IF You Don't Have A/c");
        login.add(login_lab1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 400, 150, -1));

        sign_in.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        sign_in.setForeground(new java.awt.Color(255, 0, 0));
        sign_in.setText(",Click to Register");
        login.add(sign_in, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 390, 150, 40));

        add(login, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1630, 690));
    }// </editor-fold>//GEN-END:initComponents

    private void LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginActionPerformed
  String username = userNameField.getText();
    String password = new String(passwordField.getPassword());
    String hashedPassword = hashPassword(password);

    try {
        int loginStatus = getLoginStatus(username, hashedPassword);
        
        switch (loginStatus) {
            case 1:
                JOptionPane.showMessageDialog(this, "Login Successful! Welcome, " + username + "!");
                userNameField.setText("");
                passwordField.setText("");
                loginSuccess(username); // Pass username to loginSuccess method
                break;
            case 0:
                JOptionPane.showMessageDialog(this, "Login Failed! Incorrect username or password.");
                break;
            case -1:
                JOptionPane.showMessageDialog(this, "Login Failed! Admin account is deactivated.");
                break;
            case -2:
                JOptionPane.showMessageDialog(this, "An error occurred while logging in. Please try again later.");
                break;
            default:
                break;
        }
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "An error occurred while logging in. Please try again later.");
    } finally {
        // Close resources
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    

    }//GEN-LAST:event_LoginActionPerformed

    private void ForgetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ForgetActionPerformed
         Admin_Pass_Reset reset= new  Admin_Pass_Reset(child2,this);
         Jload.jPanelLoader(child2, reset); 
    }//GEN-LAST:event_ForgetActionPerformed

    private void userNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userNameFieldActionPerformed

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
     int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to go back?", "Confirmation", JOptionPane.YES_NO_OPTION);
    if (confirm == JOptionPane.YES_OPTION) {
        // Call the method in the Home frame to navigate back
        homeFrame.goBackToChild2();
    }
    }//GEN-LAST:event_BackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JButton Forget;
    private javax.swing.JButton Login;
    private javax.swing.JLabel Password;
    private javax.swing.JLabel Username;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel login;
    private javax.swing.JLabel login_lab1;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel sign_in;
    private javax.swing.JTextField userNameField;
    // End of variables declaration//GEN-END:variables
}
