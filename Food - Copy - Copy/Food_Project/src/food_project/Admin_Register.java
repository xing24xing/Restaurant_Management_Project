/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package food_project;

import food_project2.Home;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.ImageIcon;

import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
//import java.awt.event.KeyEvent;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Admin_Register extends javax.swing.JFrame {
   
    // JDBC URL, username, and password of MySQL server
    private static final String URL = "jdbc:mysql://localhost:3306/project";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    // JDBC variables for opening, closing and managing connection


        public Admin_Register() {
        initComponents();
        weak.setVisible(false);
        medium.setVisible(false);
        strong.setVisible(false);


        topass1.addActionListener((ActionEvent e) -> {
            if (topass1.isSelected()) {
                Pass1.setEchoChar((char) 0); // Show password
                topass1.setText("\uf06e"); // Open eye icon
            } else {
                Pass1.setEchoChar('*'); // Hide password
                topass1.setText("\uf070"); // Closed eye icon
            }
        });

    topass2.addActionListener((ActionEvent e) -> {
        if (topass2.isSelected()) {
            Pass2.setEchoChar((char) 0); // Show password
            topass2.setText("\uf06e"); // Open eye icon
        } else {
            Pass2.setEchoChar('*'); // Hide password
            topass2.setText("\uf070"); // Closed eye icon
        }
        });

       this.setExtendedState(Home.MAXIMIZED_BOTH);
        try {
            DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.err.println("Error connecting to the database: " + e.getMessage());
        }
      
        // Add toggle buttons to the panel
       
Pass1.getDocument().addDocumentListener(new DocumentListener() {
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
    String password = String.valueOf(Pass1.getPassword());

    // Check password strength
    int score = getPasswordStrength(password);

    // Hide all strength labels by default
    weak.setVisible(false);
    medium.setVisible(false);
    strong.setVisible(false);

    // Update labels based on password strength score
    if (score < 30) {
        weak.setVisible(true);
    } else if (score < 60) {
        medium.setVisible(true);
    } else {
        strong.setVisible(true);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Name = new javax.swing.JTextField();
        username = new javax.swing.JTextField();
        Email = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        submit = new javax.swing.JButton();
        Pass2 = new javax.swing.JPasswordField();
        Pass1 = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        Lastname = new javax.swing.JTextField();
        weak = new javax.swing.JLabel();
        medium = new javax.swing.JLabel();
        strong = new javax.swing.JLabel();
        Back = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        topass1 = new javax.swing.JToggleButton();
        topass2 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 26)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setText("Admin Registration Form");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 110, 420, -1));

        jLabel2.setFont(new java.awt.Font("Nirmala UI", 1, 24)); // NOI18N
        jLabel2.setText("Enter First Name  ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 200, -1, -1));

        Name.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        getContentPane().add(Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 210, 230, 30));
        Name.getAccessibleContext().setAccessibleName("");

        username.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });
        getContentPane().add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 400, 230, 30));
        username.getAccessibleContext().setAccessibleName("");

        Email.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        Email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmailActionPerformed(evt);
            }
        });
        getContentPane().add(Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 340, 230, 30));

        jLabel3.setFont(new java.awt.Font("Nirmala UI", 1, 24)); // NOI18N
        jLabel3.setText("Enter Email - ID");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 340, -1, -1));

        jLabel4.setFont(new java.awt.Font("Nirmala UI", 1, 24)); // NOI18N
        jLabel4.setText("Set  New Password");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 470, -1, -1));

        jLabel5.setFont(new java.awt.Font("Nirmala UI", 1, 24)); // NOI18N
        jLabel5.setText("Enter  Username  ");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 410, -1, -1));

        jLabel6.setFont(new java.awt.Font("Nirmala UI", 1, 24)); // NOI18N
        jLabel6.setText("Confirm Set Password");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 530, -1, -1));

        submit.setBackground(new java.awt.Color(0, 0, 153));
        submit.setFont(new java.awt.Font("Segoe UI Black", 1, 20)); // NOI18N
        submit.setForeground(new java.awt.Color(255, 255, 255));
        submit.setText("submit");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });
        getContentPane().add(submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 610, -1, -1));

        Pass2.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        Pass2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Pass2ActionPerformed(evt);
            }
        });
        getContentPane().add(Pass2, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 530, 230, 30));

        Pass1.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        Pass1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Pass1ActionPerformed(evt);
            }
        });
        getContentPane().add(Pass1, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 470, 230, -1));

        jLabel8.setFont(new java.awt.Font("Nirmala UI", 1, 24)); // NOI18N
        jLabel8.setText("Enter Last Name  ");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 270, -1, -1));

        Lastname.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        getContentPane().add(Lastname, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 270, 230, 30));

        weak.setBackground(new java.awt.Color(255, 0, 0));
        weak.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        weak.setForeground(new java.awt.Color(204, 0, 0));
        weak.setText("weak password");
        getContentPane().add(weak, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 470, -1, 20));

        medium.setBackground(new java.awt.Color(255, 0, 0));
        medium.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        medium.setForeground(new java.awt.Color(204, 204, 0));
        medium.setText("medium password");
        getContentPane().add(medium, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 470, -1, 20));

        strong.setBackground(new java.awt.Color(255, 0, 0));
        strong.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        strong.setForeground(new java.awt.Color(0, 204, 0));
        strong.setText("strong password");
        getContentPane().add(strong, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 470, -1, 20));

        Back.setBackground(new java.awt.Color(0, 204, 51));
        Back.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        Back.setForeground(new java.awt.Color(255, 255, 255));
        Back.setText("Back");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });
        getContentPane().add(Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 20, -1, -1));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Vivaldi", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(32, 163, 103));
        jLabel7.setText("K - Food");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 190, -1));

        topass1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                topass1ActionPerformed(evt);
            }
        });
        getContentPane().add(topass1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 530, 30, 30));

        topass2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                topass2ActionPerformed(evt);
            }
        });
        getContentPane().add(topass2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 470, 30, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameActionPerformed

    private void EmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmailActionPerformed

    private void Pass2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Pass2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Pass2ActionPerformed

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
    String firstName = Name.getText();
    String lastName = Lastname.getText();
    String email = Email.getText();
    String userName = username.getText();
    String password = String.valueOf(Pass1.getPassword());
    String con_password = String.valueOf(Pass2.getPassword());

    if (!email.toLowerCase().endsWith("@gmail.com")) {
        JOptionPane.showMessageDialog(this, "Please enter a Gmail address.");
        return; // Don't proceed further
    }

    if (!password.equals(con_password)) {
        JOptionPane.showMessageDialog(this, "Passwords don't match. Please try again.");
        return; // Don't proceed further
    }
    
    // Hash the password before storing it in the database
    String hashedPassword = hashPassword(password);

    // Insert user details into database
    try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
         PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO admin (firstname, lastname, email_ID, username, password) VALUES (?, ?, ?, ?, ?)")) {

        preparedStatement.setString(1, firstName);
        preparedStatement.setString(2, lastName);
        preparedStatement.setString(3, email);
        preparedStatement.setString(4, userName);
        preparedStatement.setString(5, hashedPassword);

        int rowsInserted = preparedStatement.executeUpdate();
        if (rowsInserted > 0) {
             JOptionPane.showMessageDialog(rootPane, "Admin Registered Successfully !!");
        } else {
            JOptionPane.showMessageDialog(rootPane, "Admin Registration Failed!!");        }
    } catch (SQLException e) {
        System.err.println("Error inserting user details: " + e.getMessage());
    }
    
    }//GEN-LAST:event_submitActionPerformed
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

    private void Pass1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Pass1ActionPerformed
        updatePasswordStrength();
    
    }//GEN-LAST:event_Pass1ActionPerformed

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        JOptionPane.showMessageDialog(rootPane,"You're Loding on Home Page");
        First_Page fp = new First_Page();
        fp.setVisible(true);
    }//GEN-LAST:event_BackActionPerformed

    private void topass2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_topass2ActionPerformed
          
    topass2.setFont(new Font("FontAwesome", Font.PLAIN, 12));
    
    // Set FontAwesome icons for toggle buttons
   
    topass2.setText("\uf06e"); // Open eye icon
    topass2.setSelected(true); // Initially selected (eye is open)
    
    }//GEN-LAST:event_topass2ActionPerformed

    private void topass1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_topass1ActionPerformed
         topass1.setFont(new Font("FontAwesome", Font.PLAIN, 12));
           topass1.setText("\uf06e"); // Open eye icon
    topass1.setSelected(true); // Initially selected (eye is open)
    }//GEN-LAST:event_topass1ActionPerformed

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
            java.util.logging.Logger.getLogger(Admin_Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin_Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin_Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin_Register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JTextField Email;
    private javax.swing.JTextField Lastname;
    private javax.swing.JTextField Name;
    private javax.swing.JPasswordField Pass1;
    private javax.swing.JPasswordField Pass2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel medium;
    private javax.swing.JLabel strong;
    private javax.swing.JButton submit;
    private javax.swing.JToggleButton topass1;
    private javax.swing.JToggleButton topass2;
    private javax.swing.JTextField username;
    private javax.swing.JLabel weak;
    // End of variables declaration//GEN-END:variables
}
