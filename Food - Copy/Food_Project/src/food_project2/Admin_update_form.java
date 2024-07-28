/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package food_project2;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.sql.*;
/**
 *
 * @author khushi pandey
 */
public class Admin_update_form extends javax.swing.JPanel {

  Connection con = null;
  PreparedStatement pst = null;
  ResultSet rs = null;
  private String ID;
  private Emp_Update update;
  private Admin_Update updt;
   private JPanel child2;
    public Admin_update_form(JPanel child2,Admin_Update updt, String ID ) {
        this.ID = ID;
        this.child2 = child2;
        this.updt = updt;
        initComponents();
        fetchAndSetEmployeeDetails(ID);
    }

   private void fetchAndSetEmployeeDetails(String ID) {
        try {
            // Fetch employee details from the database based on the Emp_ID
            con = food_project2.conn.mycon();
            String query = "SELECT ID, firstName, lastName, email_ID, username FROM admin WHERE ID = ?";
            pst = con.prepareStatement(query);
            pst.setString(1, ID);
            rs = pst.executeQuery();

            // Check if the result set is not empty
            if (rs.next()) {
                // Set the text of the fields with fetched employee details
                adm_id.setText(rs.getString("ID"));
                Name.setText(rs.getString("firstName"));
                Lastname.setText(rs.getString("lastName"));
                Email.setText(rs.getString("email_ID"));
                username.setText(rs.getString("username"));
            } else {
                JOptionPane.showMessageDialog(null, "No employee found with Emp_ID: " + ID);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

//   public void goBackToChild2() {
//        // Reload the main components of child2
//        // You can implement this method according to your JPanel structure
//        // For example:
//        jPanelLoader(child2, admin); // Replace mainChild2Panel with your actual child2 main panel
//    }
//  public void jPanelLoader(JPanel parent, JPanel child) {
//    parent.removeAll();
//    parent.add(child);
//    parent.revalidate();
//    parent.repaint();
//}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        form = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        Email = new javax.swing.JTextField();
        adm_id = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Name = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        Lastname = new javax.swing.JTextField();
        Update = new javax.swing.JButton();
        username = new javax.swing.JTextField();
        Back = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        id1 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        form.setBackground(new java.awt.Color(255, 255, 255));
        form.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        jLabel3.setText("Enter Email - ID");
        form.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 300, -1, -1));

        Email.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        Email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmailActionPerformed(evt);
            }
        });
        form.add(Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 300, 230, 30));

        adm_id.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        adm_id.setText("id");
        form.add(adm_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 120, 160, 30));

        jLabel1.setFont(new java.awt.Font("Rockwell Nova", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 153));
        jLabel1.setText("Admin Update Details Form");
        form.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 40, 420, -1));

        jLabel8.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        jLabel8.setText("Enter Last Name  ");
        form.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 240, -1, -1));

        Name.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        form.add(Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 180, 230, 30));

        jLabel5.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        jLabel5.setText("Enter  Username  ");
        form.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 360, -1, -1));

        Lastname.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        form.add(Lastname, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 240, 230, 30));

        Update.setBackground(new java.awt.Color(51, 153, 0));
        Update.setFont(new java.awt.Font("Segoe UI Black", 1, 20)); // NOI18N
        Update.setForeground(new java.awt.Color(255, 255, 255));
        Update.setText("Update");
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });
        form.add(Update, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 430, -1, -1));

        username.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });
        form.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 360, 230, 30));

        Back.setBackground(new java.awt.Color(102, 102, 102));
        Back.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        Back.setForeground(new java.awt.Color(255, 255, 255));
        Back.setText("Back");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });
        form.add(Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 20, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon("E:\\Food\\cheff6.png")); // NOI18N
        form.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, -10, -1, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon("E:\\Food\\file2.png")); // NOI18N
        form.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 90, -1, -1));

        jLabel4.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        jLabel4.setText("Enter First Name  ");
        form.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 180, -1, -1));

        id1.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        id1.setText("Enter First Name  ");
        form.add(id1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 120, -1, -1));

        add(form, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1450, 700));
    }// </editor-fold>//GEN-END:initComponents

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
       int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to go back?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            // Navigate back to Emp_Panel using the reference
            updt.goBackToChild2();
        }
    }//GEN-LAST:event_BackActionPerformed

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameActionPerformed
public void goToChild2() {
        // Reload the main components of child2
        // You can implement this method according to your JPanel structure
        // For example:
        jPanelLoader(child2, form); // Replace mainChild2Panel with your actual child2 main panel
    }
  public void jPanelLoader(JPanel parent, JPanel child) {
    parent.removeAll();
    parent.add(child);
    child.setVisible(true); // Ensure the newly loaded panel is set to visible
    parent.revalidate();
    parent.repaint();
}
    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
       try {
        // Get data from text fields
        String fName = Name.getText().trim();
        String lName = Lastname.getText().trim();
        String email = Email.getText().trim();
        String user = username.getText().trim();
        String id = adm_id.getText().trim(); // Get ID from the text field

        // Update query
        String query = "UPDATE admin SET firstName=?, lastName=?, email_ID=?, username=? WHERE ID=?";

        // Prepare statement
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1, fName);
        pst.setString(2, lName);
        pst.setString(3, email);
        pst.setString(4, user);
        pst.setString(5, id); // Set ID in the WHERE clause

        // Execute the update
        int rowsAffected = pst.executeUpdate();

        // Check if update successful
        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(this, "Admin record updated successfully.");
          Name.setText("");
               Lastname.setText("");
               Email.setText("");
               username.setText("");
               username.setText("");
               adm_id.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Failed to update Admin record.");
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
    }     
    }//GEN-LAST:event_UpdateActionPerformed

    private void EmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmailActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JTextField Email;
    private javax.swing.JTextField Lastname;
    private javax.swing.JTextField Name;
    private javax.swing.JButton Update;
    private javax.swing.JLabel adm_id;
    private javax.swing.JPanel form;
    private javax.swing.JLabel id1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
