/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package food_project2;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.*;
import javax.swing.JPanel;
/**
 *
 * @author khushi pandey
 */
public class Admin_Remove extends javax.swing.JPanel {

   Connection con = null;
   ResultSet rs = null;
   PreparedStatement pst = null;
   private JPanel child2;
   private Admin_Dashboard dash; // Reference to Emp_Panel
    public Admin_Remove(JPanel child2,Admin_Dashboard dash) {
          con = food_project2.conn.mycon(); // Establish database connection
      
      initComponents();
      this.dash = dash;
//    pane.add(adm_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 170, -1, -1));
    populateEmpIDs(); 
    }
  private boolean isAdminActive(String adminID) {
    try {
        String query = "SELECT status FROM admin WHERE ID = ?";
        pst = con.prepareStatement(query);
        pst.setString(1, adminID);
        rs = pst.executeQuery();

        if (rs.next()) {
            String status = rs.getString("status");
            return "active".equalsIgnoreCase(status);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e);
    }
    return false;
}

    private void populateEmpIDs() {
     try {
            String query = "SELECT ID FROM admin";
            pst = con.prepareStatement(query);
            rs = pst.executeQuery();

            // Clear existing items
            adm_id.removeAllItems();

            // Add "Select ID" as the first item
            adm_id.addItem("Select ID");

            // Add new items from ResultSet
            while (rs.next()) {
                adm_id.addItem(rs.getString("ID"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pane = new javax.swing.JPanel();
        head = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        Email = new javax.swing.JLabel();
        phone = new javax.swing.JLabel();
        adm_id = new javax.swing.JComboBox<>();
        adm_name = new javax.swing.JLabel();
        adm_email = new javax.swing.JLabel();
        adm_user = new javax.swing.JLabel();
        back = new javax.swing.JButton();
        search = new javax.swing.JButton();
        Delete = new javax.swing.JButton();
        Activate = new javax.swing.JButton();
        Deactivate = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pane.setBackground(new java.awt.Color(255, 255, 255));
        pane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        head.setFont(new java.awt.Font("Lucida Bright", 3, 24)); // NOI18N
        head.setForeground(new java.awt.Color(255, 0, 0));
        head.setText("'Admin' Account Deletion ,Deactivation and Activation");
        pane.add(head, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, 670, -1));

        id.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        id.setForeground(new java.awt.Color(0, 0, 102));
        id.setText("Admin ID");
        pane.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 170, 124, -1));

        name.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        name.setForeground(new java.awt.Color(0, 0, 102));
        name.setText("Admin Name");
        pane.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 250, 170, -1));

        Email.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        Email.setForeground(new java.awt.Color(0, 0, 102));
        Email.setText("Admin Email ID");
        pane.add(Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 330, 200, -1));

        phone.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        phone.setForeground(new java.awt.Color(0, 0, 102));
        phone.setText("Admin Username");
        pane.add(phone, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 410, 200, -1));

        adm_id.setFont(new java.awt.Font("Segoe UI Variable", 1, 15)); // NOI18N
        adm_id.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        adm_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adm_idActionPerformed(evt);
            }
        });
        pane.add(adm_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 150, 140, 40));

        adm_name.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        pane.add(adm_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 250, 160, 30));

        adm_email.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        pane.add(adm_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 330, 170, 30));

        adm_user.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        pane.add(adm_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 410, 160, 30));

        back.setBackground(new java.awt.Color(51, 51, 51));
        back.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        back.setForeground(new java.awt.Color(255, 255, 255));
        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        pane.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 30, 90, 40));

        search.setBackground(new java.awt.Color(0, 51, 204));
        search.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        search.setForeground(new java.awt.Color(255, 255, 255));
        search.setText("search");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        pane.add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 150, 100, 35));

        Delete.setBackground(new java.awt.Color(255, 0, 51));
        Delete.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Delete.setForeground(new java.awt.Color(255, 255, 255));
        Delete.setText("Delete");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });
        pane.add(Delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 490, 120, 40));

        Activate.setBackground(new java.awt.Color(51, 204, 0));
        Activate.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Activate.setForeground(new java.awt.Color(255, 255, 255));
        Activate.setText("Activate");
        Activate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActivateActionPerformed(evt);
            }
        });
        pane.add(Activate, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 490, 130, 40));

        Deactivate.setBackground(new java.awt.Color(0, 0, 204));
        Deactivate.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Deactivate.setForeground(new java.awt.Color(255, 255, 255));
        Deactivate.setText("Deactivate");
        Deactivate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeactivateActionPerformed(evt);
            }
        });
        pane.add(Deactivate, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 490, 140, 40));

        add(pane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1440, 720));
    }// </editor-fold>//GEN-END:initComponents

    private void adm_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adm_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_adm_idActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to go back?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            // Navigate back to Emp_Panel using the reference
            dash.goToChild2();
        }
    }//GEN-LAST:event_backActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
          try {
        String selectedID = adm_id.getSelectedItem().toString();
        if (!selectedID.equals("Select ID")) {
            if (!isAdminActive(selectedID)) {
                JOptionPane.showMessageDialog(null, "This admin account is deactivated and cannot perform any actions.");
                return;
            }
            String query = "SELECT ID, firstName, lastName, email_ID, username FROM admin WHERE ID = ?";
            pst = con.prepareStatement(query);
            pst.setString(1, selectedID);
            rs = pst.executeQuery();

            if (rs.next()) {
                adm_name.setText(rs.getString("firstName"));
                adm_user.setText(rs.getString("username"));
                adm_email.setText(rs.getString("email_ID"));
            } else {
                JOptionPane.showMessageDialog(null, "No admin found with ID: " + selectedID);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select an Admin ID to search.");
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e);
    }
    }//GEN-LAST:event_searchActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        try {
            String selectedID = adm_id.getSelectedItem().toString();
            if (!selectedID.equals("Select ID")) {
                String query = "DELETE FROM admin WHERE ID = ?";
                pst = con.prepareStatement(query);
                pst.setString(1, selectedID);
                int deletedRows = pst.executeUpdate();

                if (deletedRows > 0) {
                    JOptionPane.showMessageDialog(null, "admin deleted successfully.");
                    // Remove the deleted ID from the JComboBox
                    adm_id.removeItem(selectedID);
                    // Clear the fields after deletion if needed
                    adm_name.setText("");
                    adm_user.setText("");
                    adm_email.setText("");
                    adm_id.setSelectedIndex(0); // Reset the selected index
                } else {
                    JOptionPane.showMessageDialog(null, "No Admin found with ID: " + selectedID);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please select an Admin ID to delete.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_DeleteActionPerformed

    private void ActivateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActivateActionPerformed
        try {
        String selectedID = adm_id.getSelectedItem().toString();
        if (!selectedID.equals("Select ID")) {
            String query = "UPDATE admin SET status = 'active' WHERE ID = ?";
            pst = con.prepareStatement(query);
            pst.setString(1, selectedID);
            int updatedRows = pst.executeUpdate();

            if (updatedRows > 0) {
                JOptionPane.showMessageDialog(null, "Admin account activated successfully.");
            } else {
                JOptionPane.showMessageDialog(null, "No Admin found with ID: " + selectedID);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select an Admin ID to activate.");
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e);
    }
    }//GEN-LAST:event_ActivateActionPerformed

    private void DeactivateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeactivateActionPerformed
         try {
        String selectedID = adm_id.getSelectedItem().toString();
        if (!selectedID.equals("Select ID")) {
            String query = "UPDATE admin SET status = 'inactive' WHERE ID = ?";
            pst = con.prepareStatement(query);
            pst.setString(1, selectedID);
            int updatedRows = pst.executeUpdate();

            if (updatedRows > 0) {
                JOptionPane.showMessageDialog(null, "Admin account deactivated successfully.");
            } else {
                JOptionPane.showMessageDialog(null, "No Admin found with ID: " + selectedID);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select an Admin ID to deactivate.");
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e);
    }
    }//GEN-LAST:event_DeactivateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Activate;
    private javax.swing.JButton Deactivate;
    private javax.swing.JButton Delete;
    private javax.swing.JLabel Email;
    private javax.swing.JLabel adm_email;
    private javax.swing.JComboBox<String> adm_id;
    private javax.swing.JLabel adm_name;
    private javax.swing.JLabel adm_user;
    private javax.swing.JButton back;
    private javax.swing.JLabel head;
    private javax.swing.JLabel id;
    private javax.swing.JLabel name;
    private javax.swing.JPanel pane;
    private javax.swing.JLabel phone;
    private javax.swing.JButton search;
    // End of variables declaration//GEN-END:variables
}
