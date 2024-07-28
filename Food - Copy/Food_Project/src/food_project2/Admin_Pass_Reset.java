/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package food_project2;

import food_project2.Home;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
//import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
//import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
public class Admin_Pass_Reset extends javax.swing.JPanel {
Connection con = null;
   ResultSet rs = null;
   PreparedStatement ps = null;
private login_admin login;
    public Admin_Pass_Reset(JPanel child2, login_admin login) {
           initComponents();
        this.login = login;
        con = food_project2.conn.mycon();
         weak.setVisible(false);
    medium.setVisible(false);
    strong.setVisible(false);
    Reset.setEnabled(false);
    // Add DocumentListener to the password field
    pass1.getDocument().addDocumentListener(new DocumentListener() {
        @Override
        public void insertUpdate(DocumentEvent e) {
            updatePasswordStrength();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            updatePasswordStrength();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            updatePasswordStrength();
        }
    });

    }

   private void updatePasswordStrength() {
        String password = String.valueOf(pass1.getPassword());
        if (password.isEmpty()) {
            // Hide all password strength labels if password is empty
            weak.setVisible(false);
            medium.setVisible(false);
            strong.setVisible(false);
        } else {
            // Check password strength and show the corresponding label
            int strength = getPasswordStrength(password);
            switch (strength) {
                case 0:
                    weak.setVisible(true);
                    medium.setVisible(false);
                    strong.setVisible(false);
                    break;
                case 1:
                    weak.setVisible(false);
                    medium.setVisible(true);
                    strong.setVisible(false);
                    break;
                case 2:
                    weak.setVisible(false);
                    medium.setVisible(false);
                    strong.setVisible(true);
                    break;
                default:
                    weak.setVisible(false);
                    medium.setVisible(false);
                    strong.setVisible(false);
                    break;
            }
        }
    }
private int getPasswordStrength(String password) {
    int score = 0;

    // Check length of password
    if (password.length() < 8) {
        return score;
    } else if (password.length() >= 8 && password.length() <= 10) {
        score += 10;
    } else {
        score += 25;
    }

    // Check for lowercase and uppercase letters
    if (password.matches(".*[a-z].*")) {
        score += 10;
    }
    if (password.matches(".*[A-Z].*")) {
        score += 10;
    }

    // Check for digits
    if (password.matches(".*\\d.*")) {
        score += 10;
    }

    // Check for special characters
    if (password.matches(".*[`~!@#$%^&*()\\-_=+\\\\|\\[{\\]};:'\",<.>/?].*")) {
        score += 10;
    }

    return score;
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        verify = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        medium = new javax.swing.JLabel();
        weak = new javax.swing.JLabel();
        pass1 = new javax.swing.JPasswordField();
        pass2 = new javax.swing.JPasswordField();
        Reset = new javax.swing.JButton();
        Back = new javax.swing.JButton();
        strong = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Rockwell Nova Extra Bold", 3, 26)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 102));
        jLabel7.setText("Admin Password Reset");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 90, 410, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 153));
        jLabel2.setText("Enter Username");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 180, 200, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 153));
        jLabel3.setText("Enter Email - ID");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 250, 200, 30));

        username.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });
        jPanel1.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 180, 230, 36));

        email.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });
        jPanel1.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 250, 230, 36));

        verify.setBackground(new java.awt.Color(0, 153, 0));
        verify.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        verify.setForeground(new java.awt.Color(255, 255, 255));
        verify.setText("Verify");
        verify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verifyActionPerformed(evt);
            }
        });
        jPanel1.add(verify, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 310, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 1, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 153));
        jLabel4.setText("Set New Password");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 350, 200, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 153));
        jLabel1.setText("Confirm New Password");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 430, 260, 30));

        medium.setBackground(new java.awt.Color(255, 0, 0));
        medium.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        medium.setForeground(new java.awt.Color(204, 204, 0));
        medium.setText("medium password");
        jPanel1.add(medium, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 360, -1, 20));

        weak.setBackground(new java.awt.Color(255, 0, 0));
        weak.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        weak.setForeground(new java.awt.Color(204, 0, 0));
        weak.setText("weak password");
        jPanel1.add(weak, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 360, -1, 20));

        pass1.setFont(new java.awt.Font("Sanskrit Text", 1, 18)); // NOI18N
        jPanel1.add(pass1, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 350, 230, -1));

        pass2.setFont(new java.awt.Font("Sanskrit Text", 1, 18)); // NOI18N
        jPanel1.add(pass2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 430, 230, -1));

        Reset.setBackground(new java.awt.Color(255, 0, 51));
        Reset.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        Reset.setForeground(new java.awt.Color(255, 255, 255));
        Reset.setText("Reset Password");
        Reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetActionPerformed(evt);
            }
        });
        jPanel1.add(Reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 520, -1, -1));

        Back.setBackground(new java.awt.Color(0, 0, 0));
        Back.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        Back.setForeground(new java.awt.Color(255, 255, 255));
        Back.setText("Back");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });
        jPanel1.add(Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 60, 90, 40));

        strong.setBackground(new java.awt.Color(255, 0, 0));
        strong.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        strong.setForeground(new java.awt.Color(0, 204, 0));
        strong.setText("strong password");
        jPanel1.add(strong, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 360, -1, 20));

        jLabel5.setIcon(new javax.swing.ImageIcon("E:\\Food\\cheff6.png")); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1450, 690));
    }// </editor-fold>//GEN-END:initComponents
private String hashPassword(String password) throws NoSuchAlgorithmException {
    MessageDigest md = MessageDigest.getInstance("SHA-256");
    md.update(password.getBytes());
    byte[] digest = md.digest();
    BigInteger bigInt = new BigInteger(1, digest);
    return bigInt.toString(16);
}
    private void verifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verifyActionPerformed

       String usernameInput = username.getText();
    String emailInput = email.getText();

    if (!emailInput.toLowerCase().endsWith("@gmail.com")) {
        JOptionPane.showMessageDialog(this, "Please enter a Gmail address.");
        return;
    }

    try {
        String sql = "SELECT * FROM admin WHERE Username = ? AND Email = ?";
        ps = con.prepareCall(sql);
        ps.setString(1, usernameInput);
        ps.setString(2, emailInput);
        rs = ps.executeQuery();
        if (rs.next()) {
            JOptionPane.showMessageDialog(this, "User verified successfully!");
            Reset.setEnabled(true); // Enable the "Reset Password" button
        } else {
            JOptionPane.showMessageDialog(this, "Invalid username or email. Please try again.");
            Reset.setEnabled(false); // Disable the "Reset Password" button
        }
    } catch (Exception e) {
        System.err.println("Error verifying user: " + e.getMessage());
    }
    }//GEN-LAST:event_verifyActionPerformed

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameActionPerformed

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailActionPerformed

    private void ResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetActionPerformed
        String usernameInput = username.getText();
        String emailInput = email.getText();
        String newPassword = String.valueOf(pass1.getPassword());
        String confirmPassword = String.valueOf(pass2.getPassword());

        if (!newPassword.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(this, "Passwords do not match. Please try again.");
            return; // Return without proceeding further
        }

        try {
            //        con = conn.mycon(); // Get the connection
            String sql = "SELECT * FROM admin WHERE username = ? AND email_ID = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, usernameInput);
            ps.setString(2, emailInput);
            rs = ps.executeQuery();
            if (rs.next()) {
                String hashedPassword;
                try {
                    hashedPassword = hashPassword(newPassword); // Hash the new password
                } catch (NoSuchAlgorithmException e) {
                    JOptionPane.showMessageDialog(this, "Error hashing password: " + e.getMessage());
                    return;
                }
                sql = "UPDATE admin SET password = ? WHERE username = ?";
                ps = con.prepareStatement(sql);
                ps.setString(1, hashedPassword);
                ps.setString(2, usernameInput);
                int rowsUpdated = ps.executeUpdate();
                if (rowsUpdated > 0) {
                    JOptionPane.showMessageDialog(this, "Password reset successfully!");
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to reset password. Please try again later.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or email. Please try again.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error updating password: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error closing resources: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_ResetActionPerformed

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to go back?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            // Call the method in the Home frame to navigate back
            login.goBackToChild2();
        }
    }//GEN-LAST:event_BackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JButton Reset;
    private javax.swing.JTextField email;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel medium;
    private javax.swing.JPasswordField pass1;
    private javax.swing.JPasswordField pass2;
    private javax.swing.JLabel strong;
    private javax.swing.JTextField username;
    private javax.swing.JButton verify;
    private javax.swing.JLabel weak;
    // End of variables declaration//GEN-END:variables
}
