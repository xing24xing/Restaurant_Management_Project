/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package food_project2;

import javax.swing.JPanel;
import java.sql.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
/**
 *
 * @author khushi pandey
 */
public class Attend_Delete extends javax.swing.JPanel {

     Connection con = null;
   ResultSet rs = null;
   PreparedStatement pst = null;
  
    JpanelLoader Jload = new JpanelLoader();
    private JPanel child2;
    private Attend_Panel att;
    public Attend_Delete(JPanel child2,Attend_Panel att) {
         initComponents();
        this.child2 = child2;
        populateUniqueDates(); // Call the method to populate unique dates
        this.att =  att;
       populateEmpIDs();

   
    }

    private void populateEmpIDs() {
    try {
         con = food_project2.conn.mycon();
        String query = "SELECT Emp_ID FROM employee_details";
         pst = con.prepareStatement(query);
         rs = pst.executeQuery();

        empid.removeAllItems();
        empid.addItem("Select ID");

        while (rs.next()) {
            empid.addItem(rs.getString("Emp_ID"));
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e);
    }
}
    private void populateUniqueDates() {
    try {
        con = food_project2.conn.mycon();
        String query = "SELECT DISTINCT Date FROM emp_attendance"; // Modify this query according to your database schema
        pst = con.prepareStatement(query);
        rs = pst.executeQuery();

        date.removeAllItems();
        date.addItem("Select Date");

        while (rs.next()) {
            date.addItem(rs.getString("Date"));
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
        emp_shift = new javax.swing.JLabel();
        phone = new javax.swing.JLabel();
        empid = new javax.swing.JComboBox<>();
        emp_name = new javax.swing.JLabel();
        shift = new javax.swing.JLabel();
        Attendance = new javax.swing.JLabel();
        back = new javax.swing.JButton();
        search = new javax.swing.JButton();
        Delete = new javax.swing.JButton();
        cancel1 = new javax.swing.JButton();
        attend = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        date = new javax.swing.JComboBox<>();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pane.setBackground(new java.awt.Color(255, 255, 255));
        pane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        head.setFont(new java.awt.Font("Lucida Bright", 3, 32)); // NOI18N
        head.setForeground(new java.awt.Color(255, 51, 51));
        head.setText("Remove Employee Details");
        pane.add(head, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 60, 430, -1));

        id.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        id.setForeground(new java.awt.Color(0, 0, 102));
        id.setText("Emp ID");
        pane.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 170, 124, -1));

        name.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        name.setForeground(new java.awt.Color(0, 0, 102));
        name.setText("Emp Name");
        pane.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 370, 170, -1));

        emp_shift.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        emp_shift.setForeground(new java.awt.Color(0, 0, 102));
        emp_shift.setText("Emp Shift");
        pane.add(emp_shift, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 440, 200, -1));

        phone.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        phone.setForeground(new java.awt.Color(0, 0, 102));
        phone.setText("Enter Date");
        pane.add(phone, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 250, 130, -1));

        empid.setFont(new java.awt.Font("Segoe UI Variable", 1, 15)); // NOI18N
        empid.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        empid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empidActionPerformed(evt);
            }
        });
        pane.add(empid, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 160, 120, 35));

        emp_name.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        pane.add(emp_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 370, 160, 30));

        shift.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        pane.add(shift, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 440, 170, 30));

        Attendance.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        pane.add(Attendance, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 520, 150, 30));

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

        search.setBackground(new java.awt.Color(0, 0, 204));
        search.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        search.setForeground(new java.awt.Color(255, 255, 255));
        search.setText("search");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        pane.add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 310, 90, 35));

        Delete.setBackground(new java.awt.Color(255, 0, 51));
        Delete.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Delete.setForeground(new java.awt.Color(255, 255, 255));
        Delete.setText("Delete");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });
        pane.add(Delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 600, -1, -1));

        cancel1.setBackground(new java.awt.Color(51, 204, 0));
        cancel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        cancel1.setForeground(new java.awt.Color(255, 255, 255));
        cancel1.setText("Cancel");
        cancel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel1ActionPerformed(evt);
            }
        });
        pane.add(cancel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 600, -1, -1));

        attend.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        attend.setForeground(new java.awt.Color(0, 0, 102));
        attend.setText("Emp Attendance");
        pane.add(attend, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 520, 210, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon("E:\\Food\\cheff6.png")); // NOI18N
        pane.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, -10, -1, -1));

        date.setFont(new java.awt.Font("Segoe UI Variable", 1, 15)); // NOI18N
        date.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateActionPerformed(evt);
            }
        });
        pane.add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 230, 120, 35));

        add(pane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1460, 920));
    }// </editor-fold>//GEN-END:initComponents

    private void empidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_empidActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to go back?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            // Navigate back to Emp_Panel using the reference
            att.goBackToChild2();
        }
    }//GEN-LAST:event_backActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
      try {
        // Get the selected Emp_ID
        String selectedEmpID = empid.getSelectedItem().toString();
        if (!selectedEmpID.equals("Select ID")) {
            // Get the selected date
            String selectedDate = date.getSelectedItem().toString();
            if (!selectedDate.equals("Select Date")) {
                // Fetch details from the database
                String query = "SELECT Name, Shift, Attendance FROM emp_attendance WHERE Emp_ID = ? AND Date = ?";
                pst = con.prepareStatement(query);
                pst.setString(1, selectedEmpID);
                pst.setString(2, selectedDate);
                rs = pst.executeQuery();

                if (rs.next()) {
                    // Display fetched details
                    emp_name.setText(rs.getString("Name"));
                    shift.setText(rs.getString("Shift"));
                    Attendance.setText(rs.getString("Attendance"));
                } else {
                    JOptionPane.showMessageDialog(null, "No records found for the provided Emp_ID and Date.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please select a Date.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select an Employee ID.");
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e);
    }
    }//GEN-LAST:event_searchActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
       try {
        // Get the selected Emp_ID
        String selectedEmpID = empid.getSelectedItem().toString();
        if (!selectedEmpID.equals("Select ID")) {
            // Get the selected date
            String selectedDate = date.getSelectedItem().toString();
            if (!selectedDate.equals("Select Date")) {
                // Delete record from the database
                String query = "DELETE FROM emp_attendance WHERE Emp_ID = ? AND Date = ?";
                pst = con.prepareStatement(query);
                pst.setString(1, selectedEmpID);
                pst.setString(2, selectedDate);
                int deletedRows = pst.executeUpdate();

                if (deletedRows > 0) {
                    JOptionPane.showMessageDialog(null, "Record deleted successfully.");
                    // Clear the fields after deletion if needed
                    emp_name.setText("");
                    shift.setText("");
                    Attendance.setText("");
                    
                    // Remove the deleted date from the combo box
                    date.removeItem(selectedDate);
                    
                    // Fetch distinct dates again after deletion
                    populateUniqueDates();
                } else {
                    JOptionPane.showMessageDialog(null, "No records found for the provided Emp_ID and Date.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please select a Date.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select an Employee ID.");
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e);
    }
    }//GEN-LAST:event_DeleteActionPerformed

    private void cancel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel1ActionPerformed
        //        this.dispose();
    }//GEN-LAST:event_cancel1ActionPerformed

    private void dateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Attendance;
    private javax.swing.JButton Delete;
    private javax.swing.JLabel attend;
    private javax.swing.JButton back;
    private javax.swing.JButton cancel1;
    private javax.swing.JComboBox<String> date;
    private javax.swing.JLabel emp_name;
    private javax.swing.JLabel emp_shift;
    private javax.swing.JComboBox<String> empid;
    private javax.swing.JLabel head;
    private javax.swing.JLabel id;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel name;
    private javax.swing.JPanel pane;
    private javax.swing.JLabel phone;
    private javax.swing.JButton search;
    private javax.swing.JLabel shift;
    // End of variables declaration//GEN-END:variables
}
