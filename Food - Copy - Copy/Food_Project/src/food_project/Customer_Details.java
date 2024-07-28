
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package food_project;

import food_project2.Home;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.JOptionPane;

import java.sql.*;
import java.util.Random;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
public class Customer_Details extends javax.swing.JFrame {

     private static final String URL = "jdbc:mysql://localhost:3306/project";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    public Customer_Details() {
        initComponents();
        // Generate a six-digit customer ID
     String customerId = generateRandomSixDigitNumber();

        this.setExtendedState(Home.MAXIMIZED_BOTH);
        // JDBC URL, username, and password of MySQL server
   
    // JDBC variables for opening, closing and managing connection

        this.setExtendedState(Home.MAXIMIZED_BOTH);
        try {
            DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.err.println("Error connecting to the database: " + e.getMessage());
        }
        weak.setVisible(false);
    medium.setVisible(false);
    strong.setVisible(false);

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
     private String generateRandomSixDigitNumber() {
    Random random = new Random();
    int num = random.nextInt(900000) + 100000; // Generates a random number between 100000 and 999999
    return String.valueOf(num);
}
 private void updatePasswordStrength() {
    String password = String.valueOf(pass1.getPassword());

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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cancel = new javax.swing.JButton();
        submit = new javax.swing.JButton();
        pass2 = new javax.swing.JPasswordField();
        pass1 = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        weak = new javax.swing.JLabel();
        medium = new javax.swing.JLabel();
        strong = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        phone = new javax.swing.JTextField();
        back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 255));
        jLabel1.setText("Enter Full Name");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 280, 210, -1));

        jLabel3.setFont(new java.awt.Font("Bookman Old Style", 3, 30)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 0));
        jLabel3.setText("Enter Your Details To Register");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 190, 510, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 255));
        jLabel4.setText("Enter Email  ID");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 350, 190, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 255));
        jLabel5.setText("Set New Password");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 530, 230, -1));

        name.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });
        getContentPane().add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 280, 210, 30));

        email.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });
        getContentPane().add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 340, 210, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 255));
        jLabel6.setText("Confirm Password");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 600, 240, -1));

        cancel.setBackground(new java.awt.Color(255, 51, 51));
        cancel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        cancel.setForeground(new java.awt.Color(255, 255, 255));
        cancel.setText("cancel");
        getContentPane().add(cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 710, -1, -1));

        submit.setBackground(new java.awt.Color(51, 204, 0));
        submit.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        submit.setForeground(new java.awt.Color(255, 255, 255));
        submit.setText("submit");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });
        getContentPane().add(submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 710, -1, -1));

        pass2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        pass2.setOpaque(true);
        getContentPane().add(pass2, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 600, 210, 30));

        pass1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        pass1.setOpaque(true);
        getContentPane().add(pass1, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 540, 210, 30));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Vivaldi", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(32, 163, 103));
        jLabel7.setText("K - Food");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 190, -1));

        weak.setBackground(new java.awt.Color(255, 0, 0));
        weak.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        weak.setForeground(new java.awt.Color(204, 0, 0));
        weak.setText("weak password");
        getContentPane().add(weak, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 550, -1, 20));

        medium.setBackground(new java.awt.Color(255, 0, 0));
        medium.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        medium.setForeground(new java.awt.Color(204, 204, 0));
        medium.setText("medium password");
        getContentPane().add(medium, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 550, -1, 20));

        strong.setBackground(new java.awt.Color(255, 0, 0));
        strong.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        strong.setForeground(new java.awt.Color(0, 204, 0));
        strong.setText("strong password");
        getContentPane().add(strong, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 550, -1, 20));

        jLabel8.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 102, 255));
        jLabel8.setText("Enter Username");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 470, 210, -1));

        username.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        getContentPane().add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 470, 210, 30));

        jLabel9.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 102, 255));
        jLabel9.setText("Enter Phone no.");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 410, 210, -1));

        phone.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        getContentPane().add(phone, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 400, 210, 30));

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

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailActionPerformed

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
     String Name = name.getText();
    String Email = email.getText();
    String Username = username.getText();
    String Phone =  phone.getText();
    String password = String.valueOf(pass1.getPassword());
    String con_password = String.valueOf(pass2.getPassword());

    if (!Email.toLowerCase().endsWith("@gmail.com")) {
        JOptionPane.showMessageDialog(this, "Please enter a Gmail address.");
        return; // Don't proceed further
    }

    if (!password.equals(con_password)) {
        JOptionPane.showMessageDialog(this, "Passwords don't match. Please try again.");
        return; // Don't proceed further
    }

    // Generate a six-digit customer ID
    String customerId = generateRandomSixDigitNumber();

    // Hash the password before storing it in the database
    String hashedPassword = hashPassword(password);

    // Insert user details into database
    try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
         PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO customer_details (id, Name, Email, Username, Phone, Password) VALUES (?, ?, ?, ?, ?, ?)")) {

        preparedStatement.setString(1, customerId);
        preparedStatement.setString(2, Name);
        preparedStatement.setString(3, Email);
        preparedStatement.setString(4, Username);
        preparedStatement.setString(5, Phone);
        preparedStatement.setString(6, hashedPassword);

        int rowsInserted = preparedStatement.executeUpdate();
        if (rowsInserted > 0) {
            JOptionPane.showMessageDialog(rootPane, "Admin Registered Successfully !!");
        } else {
            JOptionPane.showMessageDialog(rootPane, "Admin Registration Failed!!");
        }
    } catch (SQLException e) {
        System.err.println("Error inserting user details: " + e.getMessage());
    }
    }//GEN-LAST:event_submitActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        this.dispose(); // Terminate the current JFrame
        Customer_Dash det= new Customer_Dash(); // Create an instance of the Employee_Panel class
        det.setVisible(true); // Make the Employee_Panel visible
    }//GEN-LAST:event_backActionPerformed

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
            java.util.logging.Logger.getLogger(Customer_Details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Customer_Details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Customer_Details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Customer_Details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Customer_Details().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JButton cancel;
    private javax.swing.JTextField email;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel medium;
    private javax.swing.JTextField name;
    private javax.swing.JPasswordField pass1;
    private javax.swing.JPasswordField pass2;
    private javax.swing.JTextField phone;
    private javax.swing.JLabel strong;
    private javax.swing.JButton submit;
    private javax.swing.JTextField username;
    private javax.swing.JLabel weak;
    // End of variables declaration//GEN-END:variables
}
