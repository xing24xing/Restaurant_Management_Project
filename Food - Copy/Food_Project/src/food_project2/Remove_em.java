/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package food_project2;
import food_project2.Home;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
public class Remove_em extends javax.swing.JPanel {
Connection con = null;
   ResultSet rs = null;
   PreparedStatement pst = null;
   private Emp_Panel empPanel; // Reference to Emp_Panel
    public Remove_em(JPanel child2, Emp_Panel empPanel) {
          con = food_project2.conn.mycon(); // Establish database connection
      
      initComponents();
      this.empPanel = empPanel;
//    emp_id = new javax.swing.JComboBox<>(); // Initialize emp_id JComboBox
//    pane.add(emp_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 170, -1, -1));
    populateEmpIDs(); 
    }
private void populateEmpIDs() {
     try {
            String query = "SELECT Emp_ID FROM employee_details";
            pst = con.prepareStatement(query);
            rs = pst.executeQuery();

            // Clear existing items
            emp_id.removeAllItems();

            // Add "Select ID" as the first item
            emp_id.addItem("Select ID");

            // Add new items from ResultSet
            while (rs.next()) {
                emp_id.addItem(rs.getString("Emp_ID"));
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
        emp_id = new javax.swing.JComboBox<>();
        emp_name = new javax.swing.JLabel();
        emp_email = new javax.swing.JLabel();
        emp_phone = new javax.swing.JLabel();
        back = new javax.swing.JButton();
        search = new javax.swing.JButton();
        Delete = new javax.swing.JButton();
        cancel1 = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pane.setBackground(new java.awt.Color(255, 255, 255));
        pane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        head.setFont(new java.awt.Font("Lucida Bright", 3, 32)); // NOI18N
        head.setForeground(new java.awt.Color(255, 51, 51));
        head.setText("Remove Employee Details");
        pane.add(head, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 70, 430, -1));

        id.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        id.setForeground(new java.awt.Color(0, 0, 102));
        id.setText("Emp ID");
        pane.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 170, 124, -1));

        name.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        name.setForeground(new java.awt.Color(0, 0, 102));
        name.setText("Emp Name");
        pane.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 250, 170, -1));

        Email.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        Email.setForeground(new java.awt.Color(0, 0, 102));
        Email.setText("Emp Email ID");
        pane.add(Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 330, 200, -1));

        phone.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        phone.setForeground(new java.awt.Color(0, 0, 102));
        phone.setText("Emp Phone no.");
        pane.add(phone, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 410, 210, -1));

        emp_id.setFont(new java.awt.Font("Segoe UI Variable", 1, 15)); // NOI18N
        emp_id.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        emp_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emp_idActionPerformed(evt);
            }
        });
        pane.add(emp_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(713, 160, 100, 35));

        emp_name.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        pane.add(emp_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 250, 160, 30));

        emp_email.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        pane.add(emp_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 330, 170, 30));

        emp_phone.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        pane.add(emp_phone, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 410, 150, 30));

        back.setBackground(new java.awt.Color(51, 51, 51));
        back.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        back.setForeground(new java.awt.Color(255, 255, 255));
        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        pane.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 30, 90, 40));

        search.setBackground(new java.awt.Color(0, 51, 204));
        search.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        search.setForeground(new java.awt.Color(255, 255, 255));
        search.setText("search");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        pane.add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 160, 90, 35));

        Delete.setBackground(new java.awt.Color(255, 0, 51));
        Delete.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Delete.setForeground(new java.awt.Color(255, 255, 255));
        Delete.setText("Delete");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });
        pane.add(Delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 500, -1, -1));

        cancel1.setBackground(new java.awt.Color(51, 204, 0));
        cancel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        cancel1.setForeground(new java.awt.Color(255, 255, 255));
        cancel1.setText("Cancel");
        cancel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel1ActionPerformed(evt);
            }
        });
        pane.add(cancel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 500, -1, -1));

        add(pane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1440, 720));
    }// </editor-fold>//GEN-END:initComponents

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        try {
            String selectedID = emp_id.getSelectedItem().toString();
            if (!selectedID.equals("Select ID")) {
                String query = "DELETE FROM employee_details WHERE Emp_ID = ?";
                pst = con.prepareStatement(query);
                pst.setString(1, selectedID);
                int deletedRows = pst.executeUpdate();

                if (deletedRows > 0) {
                    JOptionPane.showMessageDialog(null, "Employee deleted successfully.");
                    // Remove the deleted ID from the JComboBox
                    emp_id.removeItem(selectedID);
                    // Clear the fields after deletion if needed
                    emp_phone.setText("");
                    emp_phone.setText("");
                    emp_email.setText("");
                    emp_id.setSelectedIndex(0); // Reset the selected index
                } else {
                    JOptionPane.showMessageDialog(null, "No employee found with Emp_ID: " + selectedID);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please select an Employee ID to delete.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_DeleteActionPerformed

    private void cancel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel1ActionPerformed
        //        this.dispose();
    }//GEN-LAST:event_cancel1ActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        try {
            String query = "SELECT * FROM employee_details WHERE Emp_ID = ?";
            pst = con.prepareStatement(query);
            pst.setString(1, emp_id.getSelectedItem().toString());
            rs = pst.executeQuery();

            if (rs.next()) {
                emp_name.setText(rs.getString("Name"));
                emp_phone.setText(rs.getString("Phone_no"));
                emp_email.setText(rs.getString("Email_ID"));
            } else {
                JOptionPane.showMessageDialog(null, "No employee found with Emp_ID: " + emp_id.getSelectedItem().toString());
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_searchActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to go back?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            // Navigate back to Emp_Panel using the reference
            empPanel.goToChild2();
        }
    }//GEN-LAST:event_backActionPerformed

    private void emp_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emp_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emp_idActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Delete;
    private javax.swing.JLabel Email;
    private javax.swing.JButton back;
    private javax.swing.JButton cancel1;
    private javax.swing.JLabel emp_email;
    private javax.swing.JComboBox<String> emp_id;
    private javax.swing.JLabel emp_name;
    private javax.swing.JLabel emp_phone;
    private javax.swing.JLabel head;
    private javax.swing.JLabel id;
    private javax.swing.JLabel name;
    private javax.swing.JPanel pane;
    private javax.swing.JLabel phone;
    private javax.swing.JButton search;
    // End of variables declaration//GEN-END:variables
}
