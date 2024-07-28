/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package food_project2;

import javax.swing.JPanel;
import java.sql.*;
import java.util.List;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
/**
 *
 * @author khushi pandey
 */
public class Cash extends javax.swing.JPanel {
JpanelLoader Jload = new JpanelLoader();
    private JPanel child2;
    private Payment py;
    private int userId; // Add a variable to store the user ID
    Connection con = null;
 ResultSet rs = null;
 PreparedStatement ps = null;
 

   
    public Cash(JPanel child2, Payment py, int userId) {
        initComponents();
        this.child2 = child2;
    this.py = py;
    this.userId = userId;
    
        con = food_project2.conn.mycon();
        this.userId = userId;
        id.setText("Customer ID: " + userId);
        fetchUserDetails(userId);

        // Populate the state JComboBox with Indian states
        String[] indianStates = { "Select State",
            "Andhra Pradesh", "Arunachal Pradesh", "Assam", "Bihar", "Chhattisgarh",
            "Goa", "Gujarat", "Haryana", "Himachal Pradesh", "Jammu and Kashmir",
            "Jharkhand", "Karnataka", "Kerala", "Madhya Pradesh", "Maharashtra",
            "Manipur", "Meghalaya", "Mizoram", "Nagaland", "Odisha", "Punjab",
            "Rajasthan", "Sikkim", "Tamil Nadu", "Telangana", "Tripura", "Uttar Pradesh",
            "Uttarakhand", "West Bengal", "Andaman and Nicobar Islands", "Chandigarh",
            "Dadra and Nagar Haveli", "Daman and Diu", "Delhi", "Lakshadweep", "Puducherry"
        };

        // Set the model for the state JComboBox
        state.setModel(new DefaultComboBoxModel<>(indianStates));
    
    }

     private void fetchUserDetails(int userId) {
        try {
            String query = "SELECT Name, Email FROM Customer_details WHERE ID = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, userId);
            rs = ps.executeQuery();
            if (rs.next()) {
                // Retrieve name and email from the result set
                String userName = rs.getString("Name");
                String userEmail = rs.getString("Email");
                // Set the retrieved values to the JTextFields
                name.setText(userName);
                email.setText(userEmail);
            } else {
                // Handle the case where no user with the provided ID is found
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle any SQL exceptions
        } finally {
            // Close the PreparedStatement and ResultSet
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
      public void setUserId(int userId) {
        this.userId = userId; // Set the user ID received from the main form
        id.setText("User ID: " + userId);
    }
   public void goToChild2() {
        // Reload the main components of child2
        // You can implement this method according to your JPanel structure
        // For example:
        jPanelLoader(child2, cash); // Replace mainChild2Panel with your actual child2 main panel
    }
  public void jPanelLoader(JPanel parent, JPanel child) {
    parent.removeAll();
    parent.add(child);
    parent.revalidate();
    parent.repaint();
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cash = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pincode = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        address = new javax.swing.JTextField();
        city = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        state = new javax.swing.JComboBox<>();
        proceed = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        back = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cash.setBackground(new java.awt.Color(255, 255, 255));
        cash.setForeground(new java.awt.Color(255, 255, 255));
        cash.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Rockwell Nova", 1, 24)); // NOI18N
        jLabel1.setText("Cash On Devilery");
        cash.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 60, -1, -1));

        pincode.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        cash.add(pincode, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 540, 140, 35));

        jLabel2.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel2.setText("Enter State");
        cash.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 500, 160, -1));

        jLabel3.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel3.setText("Your Name");
        cash.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 140, 120, -1));

        jLabel4.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel4.setText("Your Email");
        cash.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 230, 120, -1));

        jLabel5.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel5.setText("Your Address");
        cash.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 320, 120, -1));

        jLabel6.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel6.setText("Enter City");
        cash.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 410, 150, -1));

        name.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });
        cash.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 180, 420, 35));

        email.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });
        cash.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 270, 420, 35));

        address.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        cash.add(address, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 360, 420, 35));

        city.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        cash.add(city, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 450, 420, 35));

        jLabel7.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel7.setText("Enter Pin Code");
        cash.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 500, 140, -1));

        state.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        state.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cash.add(state, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 540, 170, 35));

        proceed.setBackground(new java.awt.Color(0, 0, 204));
        proceed.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        proceed.setForeground(new java.awt.Color(255, 255, 255));
        proceed.setText("Proceed to Pay");
        proceed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proceedActionPerformed(evt);
            }
        });
        cash.add(proceed, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 610, -1, 36));

        jPanel1.setBackground(new java.awt.Color(255, 102, 102));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        cash.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, 500, 620));

        jLabel8.setIcon(new javax.swing.ImageIcon("E:\\Food\\cheff6.png")); // NOI18N
        cash.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, -10, -1, -1));

        id.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        id.setText("Customer ID:-");
        cash.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 220, -1));

        back.setBackground(new java.awt.Color(51, 51, 51));
        back.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        back.setForeground(new java.awt.Color(255, 255, 255));
        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        cash.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 30, 90, 40));
        back.getAccessibleContext().setAccessibleDescription("");

        add(cash, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1450, 780));
    }// </editor-fold>//GEN-END:initComponents

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailActionPerformed

    private void proceedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proceedActionPerformed
       // Get the values from the text fields
    String nameValue = name.getText();
    String emailValue = email.getText();
    String addressValue = address.getText();
    String cityValue = city.getText();
    String pincodeValue = pincode.getText();
    String stateValue = state.getSelectedItem().toString(); // Assuming state is a combo box

    // Check if all fields are filled
    if (nameValue.isEmpty() || emailValue.isEmpty() || addressValue.isEmpty() || cityValue.isEmpty() || pincodeValue.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please fill all fields.");
        return; // Exit the method if any field is empty
    }

    try {
        // Insert data into the CashDetails table
        String insertQuery = "INSERT INTO CashDetails (Name, Email, Address, City, Pincode, State) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(insertQuery);
        ps.setString(1, nameValue);
        ps.setString(2, emailValue);
        ps.setString(3, addressValue);
        ps.setString(4, cityValue);
        ps.setString(5, pincodeValue);
        ps.setString(6, stateValue);

        int rowsAffected = ps.executeUpdate();
        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(this, "Data inserted successfully into CashDetails");
            Show up= new  Show(child2,this,null);
              Jload.jPanelLoader(child2,up); 
                    
        } else {
            JOptionPane.showMessageDialog(this, "Failed to insert data into CashDetails");
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
    }
    }//GEN-LAST:event_proceedActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to go back?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            // Navigate back to Emp_Panel using the reference
            py.goToChild2();
        }
    }//GEN-LAST:event_backActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField address;
    private javax.swing.JButton back;
    private javax.swing.JPanel cash;
    private javax.swing.JTextField city;
    private javax.swing.JTextField email;
    private javax.swing.JLabel id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField name;
    private javax.swing.JTextField pincode;
    private javax.swing.JButton proceed;
    private javax.swing.JComboBox<String> state;
    // End of variables declaration//GEN-END:variables
}
