/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package food_project;

import food_project2.conn;
import food_project2.Home;
import java.sql.*;
import javax.swing.JOptionPane;
public class Remove_emp extends javax.swing.JFrame {

     Connection con = null;
   ResultSet rs = null;
   
   PreparedStatement pst = null;
    public Remove_emp() {
       con = conn.mycon(); // Establish database connection
      this.setExtendedState(Home.MAXIMIZED_BOTH);
      initComponents();
   
//    emp_id = new javax.swing.JComboBox<>(); // Initialize emp_id JComboBox
    getContentPane().add(emp_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 190, -1, -1));
    populateEmpIDs(); // Populate JComboBox with employee IDs
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

        name = new javax.swing.JLabel();
        head = new javax.swing.JLabel();
        Email = new javax.swing.JLabel();
        emp_name = new javax.swing.JLabel();
        phone = new javax.swing.JLabel();
        emp_phone = new javax.swing.JLabel();
        emp_email = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        search = new javax.swing.JButton();
        Delete = new javax.swing.JButton();
        cancel1 = new javax.swing.JButton();
        emp_id = new javax.swing.JComboBox<>();
        back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        name.setFont(new java.awt.Font("Segoe UI", 1, 21)); // NOI18N
        name.setForeground(new java.awt.Color(204, 0, 204));
        name.setText("Emp Name");
        getContentPane().add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 280, 170, -1));

        head.setFont(new java.awt.Font("Sitka Text", 3, 32)); // NOI18N
        head.setForeground(new java.awt.Color(204, 0, 0));
        head.setText("Remove Employee Details");
        getContentPane().add(head, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 90, 400, -1));

        Email.setFont(new java.awt.Font("Segoe UI", 1, 21)); // NOI18N
        Email.setForeground(new java.awt.Color(204, 0, 204));
        Email.setText("Emp Email ID");
        getContentPane().add(Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 370, 200, -1));

        emp_name.setBackground(new java.awt.Color(255, 255, 255));
        emp_name.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        getContentPane().add(emp_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 280, 210, -1));

        phone.setFont(new java.awt.Font("Segoe UI", 1, 21)); // NOI18N
        phone.setForeground(new java.awt.Color(204, 0, 204));
        phone.setText("Emp Phone no.");
        getContentPane().add(phone, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 470, 210, -1));

        emp_phone.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        getContentPane().add(emp_phone, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 470, 230, -1));

        emp_email.setBackground(new java.awt.Color(255, 255, 255));
        emp_email.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        getContentPane().add(emp_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 370, 260, -1));

        id.setFont(new java.awt.Font("Segoe UI", 1, 21)); // NOI18N
        id.setForeground(new java.awt.Color(204, 0, 204));
        id.setText("Emp ID");
        getContentPane().add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 180, 124, -1));

        search.setBackground(new java.awt.Color(0, 51, 204));
        search.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        search.setForeground(new java.awt.Color(255, 255, 255));
        search.setText("search");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        getContentPane().add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 190, -1, -1));

        Delete.setBackground(new java.awt.Color(255, 0, 51));
        Delete.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Delete.setForeground(new java.awt.Color(255, 255, 255));
        Delete.setText("Delete");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });
        getContentPane().add(Delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 580, -1, -1));

        cancel1.setBackground(new java.awt.Color(51, 204, 0));
        cancel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        cancel1.setForeground(new java.awt.Color(255, 255, 255));
        cancel1.setText("Cancel");
        cancel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel1ActionPerformed(evt);
            }
        });
        getContentPane().add(cancel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 580, -1, -1));

        emp_id.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        emp_id.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(emp_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 190, -1, -1));

        back.setBackground(new java.awt.Color(204, 204, 204));
        back.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        getContentPane().add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(1440, 20, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
                    emp_name.setText("");
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
        this.dispose();
    }//GEN-LAST:event_cancel1ActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        this.dispose(); // Terminate the current JFrame
        Employee_Panel emp = new Employee_Panel(); // Create an instance of the Employee_Panel class
        emp.setVisible(true); // Make the Employee_Panel visible
    }//GEN-LAST:event_backActionPerformed

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
            java.util.logging.Logger.getLogger(Remove_emp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Remove_emp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Remove_emp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Remove_emp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Remove_emp().setVisible(true);
            }
        });
    }

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
    private javax.swing.JLabel phone;
    private javax.swing.JButton search;
    // End of variables declaration//GEN-END:variables
}
