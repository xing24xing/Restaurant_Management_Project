/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package food_project2;

import com.toedter.calendar.JDateChooser;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
/**
 *
 * @author khushi pandey
 */
public class Bank extends javax.swing.JPanel {
JpanelLoader Jload = new JpanelLoader();
    private JPanel child2;
    private Payment py;
     private JDateChooser exp;
//      private JTextField cvvField; // JTextField for CVV input
    private int userId; // Add a variable to store the user ID
    Connection con = null;
 ResultSet rs = null;
 PreparedStatement ps = null;
 
    public Bank(JPanel child2, Payment py, int userId) {
          initComponents();
        this.child2 = child2;
        this.py = py;
        this.userId = userId;

        con = food_project2.conn.mycon();
        this.userId = userId;
        id.setText("Customer ID: " + userId);
        fetchUserDetails(userId);
  
        // Instantiate JDateChooser
        exp = new JDateChooser();
        jPanel1.add(exp, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 320, 150, 40));
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
                String userName = rs.getString("Name");
                String userEmail = rs.getString("Email");
                name.setText(userName);
                email.setText(userEmail);
            } else {
                JOptionPane.showMessageDialog(this, "No user found with the provided ID.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void setUserId(int userId) {
        this.userId = userId;
        id.setText("Customer ID: " + userId);
    }

    public void goToChild2() {
        jPanelLoader(child2, cash);
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
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        address = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        city = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        state = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        pincode = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        proceed = new javax.swing.JButton();
        cvv = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        debitno = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        back = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cash.setBackground(new java.awt.Color(255, 255, 255));
        cash.setForeground(new java.awt.Color(255, 255, 255));
        cash.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 102, 102));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Rockwell Nova", 1, 24)); // NOI18N
        jLabel1.setText("Enter Card Details");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 30, -1, -1));

        name.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });
        jPanel1.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, 420, 35));

        jLabel3.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel3.setText("Your Name");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 120, -1));

        jLabel4.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel4.setText("Your Email");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 120, -1));

        email.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });
        jPanel1.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, 420, 35));

        jLabel5.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel5.setText("Your Address");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, 120, -1));

        address.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jPanel1.add(address, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 320, 420, 35));

        jLabel6.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel6.setText("Enter City");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 370, 150, -1));

        city.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jPanel1.add(city, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 420, 420, 35));

        jLabel2.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel2.setText("Enter State");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 90, 160, -1));

        state.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        state.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(state, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 130, 170, 35));

        jLabel7.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel7.setText("Enter Pin Code");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 90, 140, -1));

        pincode.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jPanel1.add(pincode, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 130, 160, 35));

        jLabel9.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel9.setText("Enter Debit Card No.");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 190, 200, -1));

        proceed.setBackground(new java.awt.Color(0, 0, 204));
        proceed.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        proceed.setForeground(new java.awt.Color(255, 255, 255));
        proceed.setText("Proceed to Pay");
        proceed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proceedActionPerformed(evt);
            }
        });
        jPanel1.add(proceed, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 540, -1, 36));

        cvv.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        cvv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cvvActionPerformed(evt);
            }
        });
        jPanel1.add(cvv, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 420, 420, 35));

        jLabel10.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel10.setText("CVV");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 380, 120, -1));

        jLabel11.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel11.setText("Card Exp. Date");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 280, 150, -1));

        debitno.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        debitno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                debitnoActionPerformed(evt);
            }
        });
        jPanel1.add(debitno, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 230, 420, 35));

        cash.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 1090, 620));

        jLabel8.setIcon(new javax.swing.ImageIcon("E:\\Food\\cheff6.png")); // NOI18N
        cash.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, -20, -1, -1));

        id.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        id.setText("Customer ID:-");
        cash.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 220, -1));

        back.setBackground(new java.awt.Color(204, 204, 204));
        back.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        cash.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 20, -1, -1));

        add(cash, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1450, 840));
    }// </editor-fold>//GEN-END:initComponents

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_emailActionPerformed

    private void proceedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proceedActionPerformed
        String userName = name.getText();
        String userEmail = email.getText();
        String userAddress = address.getText();
        String userCity = city.getText();
        String userState = state.getSelectedItem().toString();
        String userPincode = pincode.getText();
         String cardCvv = cvv.getText(); // Get CVV input from JTextField

        // Validate CVV (e.g., ensure it is three or four digits)
        if (cardCvv.isEmpty() || !cardCvv.matches("\\d{3,4}")) {
            JOptionPane.showMessageDialog(this, "Please enter a valid CVV.");
            return;
        }

        // Get selected date from JDateChooser
        java.util.Date selectedDate = exp.getDate();
        java.sql.Date expiryDate = new java.sql.Date(selectedDate.getTime());

        if (userName.isEmpty() || userEmail.isEmpty() || userAddress.isEmpty() || userCity.isEmpty() ||
            userState.equals("Select State") || userPincode.isEmpty() || 
            expiryDate == null || cardCvv.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.");
            return;
        }

        try {
            String query = "INSERT INTO CardDetails (CustomerID, Name, Email, Address, City, State, Pincode, Exp_date, Cvv) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            ps = con.prepareStatement(query);
            ps.setInt(1, userId);
            ps.setString(2, userName);
            ps.setString(3, userEmail);
            ps.setString(4, userAddress);
            ps.setString(5, userCity);
            ps.setString(6, userState);
            ps.setString(7, userPincode);
            ps.setDate(8, expiryDate); // Set Date
            ps.setString(9, cardCvv);

            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Payment details saved successfully!");
             Show up= new  Show(child2,null,this);
             Jload.jPanelLoader(child2,up); 
            goToChild2();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        } finally {
            try {
                if (ps != null) ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }//GEN-LAST:event_proceedActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to go back?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            // Navigate back to Emp_Panel using the reference
            py.goToChild2();
        }
    }//GEN-LAST:event_backActionPerformed

    private void cvvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cvvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cvvActionPerformed

    private void debitnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_debitnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_debitnoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField address;
    private javax.swing.JButton back;
    private javax.swing.JPanel cash;
    private javax.swing.JTextField city;
    private javax.swing.JTextField cvv;
    private javax.swing.JTextField debitno;
    private javax.swing.JTextField email;
    private javax.swing.JLabel id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField name;
    private javax.swing.JTextField pincode;
    private javax.swing.JButton proceed;
    private javax.swing.JComboBox<String> state;
    // End of variables declaration//GEN-END:variables
}
