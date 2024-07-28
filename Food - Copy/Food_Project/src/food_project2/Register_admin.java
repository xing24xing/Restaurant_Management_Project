/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package food_project2;

import food_project2.Home;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
//import java.awt.event.KeyEvent;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Register_admin extends javax.swing.JPanel {
private static final String URL = "jdbc:mysql://localhost:3306/project";
    private static final String USER = "root";
    private static final String PASSWORD = "";
     private Home homeFrame;
      private JPanel child2;
     JpanelLoader Jload = new JpanelLoader();
     
    public Register_admin(JPanel child2,Home homeFrame) {
        initComponents();
         this.homeFrame = homeFrame;
         this.child2 = child2;
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
    // sign -in link 
    sign_in.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
    sign_in.setForeground(new java.awt.Color(255, 0, 0));
    sign_in.setText(",Sing in Here");
    sign_in.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseClicked(java.awt.event.MouseEvent evt) {
        sign_inMouseClicked(evt);
    }
    
});

       weak.setVisible(false);
       medium.setVisible(false);
       strong.setVisible(false);


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
  Pass1.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                weak.setVisible(false);
    medium.setVisible(false);
    strong.setVisible(false);

            }
        });
 // Hide both labels initially
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
    // Method to check if the entered username exists in the database
   // Method to check if the entered username exists in the database
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
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM admin WHERE username = ?")) {
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

    public void registrationSuccess() {
        // Notify the Home frame about the successful registration
        homeFrame.setButtonAvailability(false);
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
private void sign_inMouseClicked(java.awt.event.MouseEvent evt) {                                        
    // Create an instance of the login_admin class
    login_admin loginPanel = new login_admin(child2, homeFrame);

    // Load the login panel into the child2 panel of the Home frame
    Jload.jPanelLoader(child2, loginPanel);
}                                       

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        Pass1 = new javax.swing.JPasswordField();
        Email = new javax.swing.JTextField();
        Pass2 = new javax.swing.JPasswordField();
        topass2 = new javax.swing.JToggleButton();
        jLabel2 = new javax.swing.JLabel();
        login_lab1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        sign_in = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        topass1 = new javax.swing.JToggleButton();
        Name = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        Lastname = new javax.swing.JTextField();
        submit = new javax.swing.JButton();
        username = new javax.swing.JTextField();
        weak = new javax.swing.JLabel();
        Back = new javax.swing.JButton();
        medium = new javax.swing.JLabel();
        strong = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        verify = new javax.swing.JLabel();
        exist = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Nirmala UI", 1, 21)); // NOI18N
        jLabel3.setText("Enter Email - ID");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 260, -1, -1));

        Pass1.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        Pass1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Pass1ActionPerformed(evt);
            }
        });
        jPanel1.add(Pass1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 390, 260, 33));

        Email.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        Email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmailActionPerformed(evt);
            }
        });
        jPanel1.add(Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 260, 260, 33));

        Pass2.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        Pass2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Pass2ActionPerformed(evt);
            }
        });
        jPanel1.add(Pass2, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 450, 260, 33));

        topass2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                topass2ActionPerformed(evt);
            }
        });
        jPanel1.add(topass2, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 460, 20, 20));

        jLabel2.setFont(new java.awt.Font("Nirmala UI", 1, 21)); // NOI18N
        jLabel2.setText("Enter First Name  ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 140, -1, -1));

        login_lab1.setFont(new java.awt.Font("Shruti", 1, 14)); // NOI18N
        login_lab1.setText("IF You are Registered ");
        jPanel1.add(login_lab1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 530, 150, -1));

        jLabel4.setFont(new java.awt.Font("Nirmala UI", 1, 21)); // NOI18N
        jLabel4.setText("Set  New Password");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 380, -1, -1));

        jLabel6.setFont(new java.awt.Font("Nirmala UI", 1, 21)); // NOI18N
        jLabel6.setText("Confirm Set Password");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 450, -1, -1));

        sign_in.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        sign_in.setForeground(new java.awt.Color(255, 0, 0));
        sign_in.setText(",Sing in Here");
        jPanel1.add(sign_in, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 530, 100, 20));

        jLabel1.setFont(new java.awt.Font("Rockwell Nova", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 153));
        jLabel1.setText("Admin Registration Form");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 60, 420, -1));

        jLabel8.setFont(new java.awt.Font("Nirmala UI", 1, 21)); // NOI18N
        jLabel8.setText("Enter Last Name  ");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 200, -1, -1));

        topass1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                topass1ActionPerformed(evt);
            }
        });
        jPanel1.add(topass1, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 400, 20, 20));

        Name.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        jPanel1.add(Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 140, 260, 33));

        jLabel5.setFont(new java.awt.Font("Nirmala UI", 1, 21)); // NOI18N
        jLabel5.setText("Enter  Username  ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 320, -1, -1));

        Lastname.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        jPanel1.add(Lastname, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 200, 260, 33));

        submit.setBackground(new java.awt.Color(0, 0, 153));
        submit.setFont(new java.awt.Font("Segoe UI Black", 1, 20)); // NOI18N
        submit.setForeground(new java.awt.Color(255, 255, 255));
        submit.setText("Register");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });
        jPanel1.add(submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 520, -1, -1));

        username.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });
        jPanel1.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 320, 260, 33));

        weak.setBackground(new java.awt.Color(255, 0, 0));
        weak.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        weak.setForeground(new java.awt.Color(204, 0, 0));
        weak.setText("weak password");
        jPanel1.add(weak, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 390, -1, 20));

        Back.setBackground(new java.awt.Color(102, 102, 102));
        Back.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        Back.setForeground(new java.awt.Color(255, 255, 255));
        Back.setText("Back");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });
        jPanel1.add(Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 20, -1, -1));

        medium.setBackground(new java.awt.Color(255, 0, 0));
        medium.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        medium.setForeground(new java.awt.Color(204, 204, 0));
        medium.setText("medium password");
        jPanel1.add(medium, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 390, -1, 20));

        strong.setBackground(new java.awt.Color(255, 0, 0));
        strong.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        strong.setForeground(new java.awt.Color(0, 204, 0));
        strong.setText("strong password");
        jPanel1.add(strong, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 390, -1, 20));

        jLabel7.setIcon(new javax.swing.ImageIcon("E:\\Food\\cheff6.png")); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, -10, -1, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon("E:\\Food\\file2.png")); // NOI18N
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 90, -1, -1));

        verify.setFont(new java.awt.Font("SimSun", 1, 12)); // NOI18N
        verify.setForeground(new java.awt.Color(0, 204, 0));
        verify.setText("Pass Verification");
        jPanel1.add(verify, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 330, 120, -1));

        exist.setFont(new java.awt.Font("SimSun", 1, 12)); // NOI18N
        exist.setForeground(new java.awt.Color(204, 0, 0));
        exist.setText("Already exist");
        jPanel1.add(exist, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 330, -1, -1));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1450, 700));
    }// </editor-fold>//GEN-END:initComponents

    private void EmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmailActionPerformed

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
     
    }//GEN-LAST:event_usernameActionPerformed

    private void Pass1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Pass1ActionPerformed

    }//GEN-LAST:event_Pass1ActionPerformed

    private void Pass2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Pass2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Pass2ActionPerformed

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

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
  int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to go back?", "Confirmation", JOptionPane.YES_NO_OPTION);
    if (confirm == JOptionPane.YES_OPTION) {
        // Call the method in the Home frame to navigate back
        homeFrame.goBackToChild2();
    }
    }//GEN-LAST:event_BackActionPerformed

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        String firstName = Name.getText();
    String lastName = Lastname.getText();
    String email = Email.getText();
    String userName = username.getText();
    String password = String.valueOf(Pass1.getPassword());
    String con_password = String.valueOf(Pass2.getPassword());

    // Check if any of the fields are empty
    if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || userName.isEmpty() || password.isEmpty() || con_password.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please fill in all the fields.");
        return; // Don't proceed further
    }

    if (!email.toLowerCase().endsWith("@gmail.com")) {
        JOptionPane.showMessageDialog(this, "Please enter a Gmail address.");
        return; // Don't proceed further
    }

    if (!password.equals(con_password)) {
        JOptionPane.showMessageDialog(this, "Passwords don't match. Please try again.");
        return; // Don't proceed further
    }

    // Check if the username already exists
    if (doesUsernameExist(userName)) {
        JOptionPane.showMessageDialog(this, "Username already exists. Please choose a different one.");
        return; // Don't proceed further
    }

    // Generate a three-digit random number for the admin ID
    Random random = new Random();
    int adminID = random.nextInt(900) + 100; // Generates a random number between 100 and 999 (inclusive)

    // Hash the password before storing it in the database
    String hashedPassword = hashPassword(password);

    // Insert user details into database
    try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO admin (ID, firstname, lastname, email_ID, username, password) VALUES (?, ?, ?, ?, ?, ?)")) {

        preparedStatement.setInt(1, adminID); // Set the generated admin ID
        preparedStatement.setString(2, firstName);
        preparedStatement.setString(3, lastName);
        preparedStatement.setString(4, email);
        preparedStatement.setString(5, userName);
        preparedStatement.setString(6, hashedPassword);

        int rowsInserted = preparedStatement.executeUpdate();
        if (rowsInserted > 0) {
            JOptionPane.showMessageDialog(this, "Admin Registered Successfully !!");
               Name.setText("");
               Lastname.setText("");
               Email.setText("");
               username.setText("");
               Pass1.setText("");
               Pass2.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Admin Registration Failed!!");        
        }
    } catch (SQLException e) {
        System.err.println("Error inserting user details: " + e.getMessage());
    }
    }//GEN-LAST:event_submitActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JTextField Email;
    private javax.swing.JTextField Lastname;
    private javax.swing.JTextField Name;
    private javax.swing.JPasswordField Pass1;
    private javax.swing.JPasswordField Pass2;
    private javax.swing.JLabel exist;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel login_lab1;
    private javax.swing.JLabel medium;
    private javax.swing.JLabel sign_in;
    private javax.swing.JLabel strong;
    private javax.swing.JButton submit;
    private javax.swing.JToggleButton topass1;
    private javax.swing.JToggleButton topass2;
    private javax.swing.JTextField username;
    private javax.swing.JLabel verify;
    private javax.swing.JLabel weak;
    // End of variables declaration//GEN-END:variables

   
}
