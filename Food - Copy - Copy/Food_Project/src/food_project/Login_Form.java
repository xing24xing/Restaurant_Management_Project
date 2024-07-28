/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package food_project;

/**
 *
 * @author khushi pandey
 */
import food_project2.conn;
import food_project2.Home;
import java.sql.*;
import java.awt.CardLayout;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Stack;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Login_Form extends javax.swing.JFrame {
     
   Connection con = null;
   ResultSet rs = null;
   PreparedStatement ps = null;
   
//    private final Stack<String> panelStack;

    public Login_Form() {
        initComponents();
        con = conn.mycon();   
        this.setExtendedState(Home.MAXIMIZED_BOTH);
}
    
         
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        Username = new javax.swing.JLabel();
        Forget = new javax.swing.JButton();
        userName = new javax.swing.JTextField();
        Password = new javax.swing.JLabel();
        pass = new javax.swing.JPasswordField();
        Login = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        Back = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Rockwell Nova Extra Bold", 1, 26)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setText("Admin Login Form");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 140, 360, -1));

        Username.setFont(new java.awt.Font("Myanmar Text", 1, 26)); // NOI18N
        Username.setText("Enter Username");
        getContentPane().add(Username, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 260, -1, -1));

        Forget.setBackground(new java.awt.Color(204, 0, 0));
        Forget.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        Forget.setForeground(new java.awt.Color(255, 255, 255));
        Forget.setText("Forgot Password");
        Forget.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ForgetActionPerformed(evt);
            }
        });
        getContentPane().add(Forget, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 610, 240, -1));

        userName.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        userName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userNameActionPerformed(evt);
            }
        });
        getContentPane().add(userName, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 270, 280, 40));
        userName.getAccessibleContext().setAccessibleName("");

        Password.setFont(new java.awt.Font("Myanmar Text", 1, 26)); // NOI18N
        Password.setText("Enter Password");
        getContentPane().add(Password, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 380, 200, -1));

        pass.setFont(new java.awt.Font("Segoe UI", 1, 24));
        getContentPane().add(pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 380, 280, 40));

        Login.setBackground(new java.awt.Color(0, 0, 153));
        Login.setFont(new java.awt.Font("Segoe UI Black", 1, 22)); // NOI18N
        Login.setForeground(new java.awt.Color(255, 255, 255));
        Login.setText("Login");
        Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginActionPerformed(evt);
            }
        });
        getContentPane().add(Login, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 500, -1, -1));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Verdana Pro Black", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(32, 163, 103));
        jLabel5.setText("K - Food");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 190, -1));

        Back.setBackground(new java.awt.Color(204, 204, 204));
        Back.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        Back.setText("Back");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });
        getContentPane().add(Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(1450, 10, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\khushi pandey\\OneDrive\\ドキュメント\\image\\favimg.jpg")); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void userNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userNameActionPerformed

    private void ForgetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ForgetActionPerformed
       Admin_Pass_Reset passResetFrame = new Admin_Pass_Reset();
        passResetFrame.setVisible(true);
    }//GEN-LAST:event_ForgetActionPerformed
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
    private void LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginActionPerformed
    String username = userName.getText();
    String password = pass.getText();

    // Hash the password entered by the user
    String hashedPassword = hashPassword(password);

    // Validate username input and compare hashed passwords
    try {
        String sql = "SELECT * FROM admin WHERE username = ?";
        ps = con.prepareStatement(sql);
        ps.setString(1, username);
        rs = ps.executeQuery();
        if (rs.next()) {
            String dbPassword = rs.getString("password");
            if (hashedPassword.equals(dbPassword)) {
                // Passwords match, login successful
                String dbUsername = rs.getString("username");
                JOptionPane.showMessageDialog(rootPane, "Login Successful! Welcome, " + dbUsername + "!");
                // Open your Admin_Panel here
                 Admin_Panel adminPanel = new Admin_Panel();
                 adminPanel.setVisible(true);
            } else {
                // Passwords don't match, login failed
                JOptionPane.showMessageDialog(rootPane, "Login Failed! Incorrect password.");
            }
        } else {
            // No user found with the entered username
            JOptionPane.showMessageDialog(rootPane, "Login Failed! Incorrect username.");
        }
    } catch (Exception e) {
        System.out.println(e);
    }
    }//GEN-LAST:event_LoginActionPerformed

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
   JOptionPane.showMessageDialog(rootPane,"You're Loding on Home Page");
        First_Page fp = new First_Page();
        fp.setVisible(true);
    }//GEN-LAST:event_BackActionPerformed

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
            java.util.logging.Logger.getLogger(Login_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
try {
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                javax.swing.UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }
    } catch (ClassNotFoundException ex) {
        java.util.logging.Logger.getLogger(Login_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
        java.util.logging.Logger.getLogger(Login_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
        java.util.logging.Logger.getLogger(Login_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
        java.util.logging.Logger.getLogger(Login_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
      java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new Login_Form().setVisible(true);
        }
    });
    
   
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JButton Forget;
    private javax.swing.JButton Login;
    private javax.swing.JLabel Password;
    private javax.swing.JLabel Username;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPasswordField pass;
    private javax.swing.JTextField userName;
    // End of variables declaration//GEN-END:variables

//    private String hashPassword(String password) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
}
