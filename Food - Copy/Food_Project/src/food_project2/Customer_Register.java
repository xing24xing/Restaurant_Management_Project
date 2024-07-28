/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package food_project2;

import food_project2.Home;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.JOptionPane;

import java.sql.*;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
public class Customer_Register extends javax.swing.JPanel {
 
      private JPanel child2;
     JpanelLoader Jload = new JpanelLoader();
     private static final String URL = "jdbc:mysql://localhost:3306/project";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private Customer_Dashboard dash;
    public Customer_Register(JPanel child2, Customer_Dashboard dash) {
        initComponents();
        this.dash = dash;
         this.child2 = child2;
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
  pass1.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
    weak.setVisible(false);
    medium.setVisible(false);
    strong.setVisible(false);

            }
        });
    sign_in.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseClicked(java.awt.event.MouseEvent evt) {
        sign_inMouseClicked(evt);
    }
});
    exist.setVisible(false);
        verify.setVisible(false);
  // Add a DocumentListener to the username text field
        username.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                checkUsername();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                checkUsername();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                checkUsername();
            }
        });
         username.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                exist.setVisible(false);
                verify.setVisible(false);
            }
        });
    }
    private void sign_inMouseClicked(java.awt.event.MouseEvent evt) {
    // Create an instance of the login_admin class
    Customer_login log = new Customer_login(child2,dash);

    // Load the login panel into the child2 panel of the Home frame
    Jload.jPanelLoader(child2, log);
}
    private void checkUsername() {
        String enteredUsername = username.getText();
        if (enteredUsername.isEmpty()) {
            // If the username field is empty, hide both labels
            exist.setVisible(false);
            verify.setVisible(false);
        } else {
            boolean exists = doesUsernameExist(enteredUsername);
            if (exists) {
                exist.setVisible(true); // Show "exist" label
                verify.setVisible(false); // Hide "verify" label
            } else {
                exist.setVisible(false); // Hide "exist" label
                verify.setVisible(true); // Show "verify" label
            }
        }
    }

    // Method to check if a username exists in the database
    private boolean doesUsernameExist(String username) {
        boolean exists = false;
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM customer_details WHERE username = ?")) {
            stmt.setString(1, username);
            try (ResultSet rs = stmt.executeQuery()) {
                exists = rs.next(); // If rs.next() returns true, the username exists in the database
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle database exception
        }
        return exists;
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

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        phone = new javax.swing.JTextField();
        username = new javax.swing.JTextField();
        pass1 = new javax.swing.JPasswordField();
        pass2 = new javax.swing.JPasswordField();
        submit = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        weak = new javax.swing.JLabel();
        medium = new javax.swing.JLabel();
        strong = new javax.swing.JLabel();
        back = new javax.swing.JButton();
        login_lab1 = new javax.swing.JLabel();
        sign_in = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        verify = new javax.swing.JLabel();
        exist = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Bookman Old Style", 3, 30)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 0));
        jLabel3.setText("Enter Your Details To Register");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 90, 510, -1));

        jLabel1.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        jLabel1.setText("Enter Full Name");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 190, 190, -1));

        jLabel4.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        jLabel4.setText("Enter Email  ID");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 250, 180, 30));

        jLabel9.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        jLabel9.setText("Enter Phone no.");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 310, 190, -1));

        jLabel8.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        jLabel8.setText("Enter Username");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 370, 200, -1));

        jLabel5.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        jLabel5.setText("Set New Password");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 430, 210, -1));

        jLabel6.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        jLabel6.setText("Confirm Password");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 490, 210, -1));

        name.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });
        jPanel1.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 180, 210, 30));

        email.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });
        jPanel1.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 240, 210, 30));

        phone.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jPanel1.add(phone, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 300, 210, 30));

        username.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jPanel1.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 360, 210, 30));

        pass1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        pass1.setOpaque(true);
        jPanel1.add(pass1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 420, 210, 30));

        pass2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        pass2.setOpaque(true);
        jPanel1.add(pass2, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 480, 210, 30));

        submit.setBackground(new java.awt.Color(0, 153, 51));
        submit.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        submit.setForeground(new java.awt.Color(255, 255, 255));
        submit.setText("Create");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });
        jPanel1.add(submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 570, -1, -1));

        cancel.setBackground(new java.awt.Color(255, 51, 51));
        cancel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        cancel.setForeground(new java.awt.Color(255, 255, 255));
        cancel.setText("cancel");
        jPanel1.add(cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 570, -1, -1));

        weak.setBackground(new java.awt.Color(255, 0, 0));
        weak.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        weak.setForeground(new java.awt.Color(204, 0, 0));
        weak.setText("weak password");
        jPanel1.add(weak, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 420, -1, 20));

        medium.setBackground(new java.awt.Color(255, 0, 0));
        medium.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        medium.setForeground(new java.awt.Color(204, 204, 0));
        medium.setText("medium password");
        jPanel1.add(medium, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 420, -1, 20));

        strong.setBackground(new java.awt.Color(255, 0, 0));
        strong.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        strong.setForeground(new java.awt.Color(0, 204, 0));
        strong.setText("strong password");
        jPanel1.add(strong, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 420, -1, 20));

        back.setBackground(new java.awt.Color(51, 51, 51));
        back.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        back.setForeground(new java.awt.Color(255, 255, 255));
        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        jPanel1.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 60, 90, 40));

        login_lab1.setFont(new java.awt.Font("Shruti", 1, 14)); // NOI18N
        login_lab1.setText("IF You Have Account");
        jPanel1.add(login_lab1, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 570, 150, -1));

        sign_in.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        sign_in.setForeground(new java.awt.Color(255, 0, 0));
        sign_in.setText(",Sing in Here");
        jPanel1.add(sign_in, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 570, 100, 20));

        jLabel2.setIcon(new javax.swing.ImageIcon("E:\\Food\\cheff6.png")); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, -20, -1, -1));

        verify.setFont(new java.awt.Font("SimSun", 1, 12)); // NOI18N
        verify.setForeground(new java.awt.Color(0, 204, 0));
        verify.setText("Pass Verification");
        jPanel1.add(verify, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 370, 120, -1));

        exist.setFont(new java.awt.Font("SimSun", 1, 12)); // NOI18N
        exist.setForeground(new java.awt.Color(204, 0, 0));
        exist.setText("Already exist");
        jPanel1.add(exist, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 370, -1, -1));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1310, 770));
    }// </editor-fold>//GEN-END:initComponents

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailActionPerformed

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
                JOptionPane.showMessageDialog(this, "Admin Registered Successfully !!");
            } else {
                JOptionPane.showMessageDialog(this, "Admin Registration Failed!!");
            }
        } catch (SQLException e) {
            System.err.println("Error inserting user details: " + e.getMessage());
        }
    }//GEN-LAST:event_submitActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to go back?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            // Navigate back to Emp_Panel using the reference
            dash.goToChild2();
        }
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
      private String generateRandomSixDigitNumber() {
    Random random = new Random();
    int num = random.nextInt(900000) + 100000; // Generates a random number between 100000 and 999999
    return String.valueOf(num);
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JButton cancel;
    private javax.swing.JTextField email;
    private javax.swing.JLabel exist;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel login_lab1;
    private javax.swing.JLabel medium;
    private javax.swing.JTextField name;
    private javax.swing.JPasswordField pass1;
    private javax.swing.JPasswordField pass2;
    private javax.swing.JTextField phone;
    private javax.swing.JLabel sign_in;
    private javax.swing.JLabel strong;
    private javax.swing.JButton submit;
    private javax.swing.JTextField username;
    private javax.swing.JLabel verify;
    private javax.swing.JLabel weak;
    // End of variables declaration//GEN-END:variables
}
