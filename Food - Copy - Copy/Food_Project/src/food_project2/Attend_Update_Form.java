/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package food_project2;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.sql.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
/**
 *
 * @author khushi pandey
 */
public class Attend_Update_Form extends javax.swing.JPanel {
Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    private JPanel child2;
    private String empID;
    private Attendance_update att_upd;
   

    public Attend_Update_Form(JPanel child2, Attendance_update att_upd, String empID) {
        initComponents();
        this.child2 = child2;
        this.empID = empID;
        this. att_upd =  att_upd;
         id.setText(empID);
//        shift = new JComboBox<>();
        shift.setModel(new DefaultComboBoxModel<>(new String[] { "Morning", "Afternoon", "Evening", "Night" }));
//        Attendance = new JComboBox<>();
        Attendance.setModel(new DefaultComboBoxModel<>(new String[] { "Present", "Absent" }));
//         id.setText(empID);

    // Fetch and set other employee details
    fetchAndSetEmployeeDetails(empID);
    }
    
   public void goBackToChild2() {
        // Reload the main components of child2
        // You can implement this method according to your JPanel structure
        // For example:
        jPanelLoader(child2, form_pane); // Replace mainChild2Panel with your actual child2 main panel
    }
  public void jPanelLoader(JPanel parent, JPanel child) {
    parent.removeAll();
    parent.add(child);
    parent.revalidate();
    parent.repaint();
}

   private void fetchAndSetEmployeeDetails(String ID) {
    try {
        con = food_project2.conn.mycon();
        String query = "SELECT Name, Shift, Attendance FROM emp_attendance WHERE Emp_ID = ?";
        pst = con.prepareStatement(query);
        pst.setString(1, ID);
        rs = pst.executeQuery();

        if (rs.next()) {
            name.setText(rs.getString("Name"));
            shift.setSelectedItem(rs.getString("Shift"));
            Attendance.setSelectedItem(rs.getString("Attendance"));
        } else {
            JOptionPane.showMessageDialog(null, "No employee found with Emp_ID: " + ID);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e);
    }
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        form_pane = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        Attendance = new javax.swing.JComboBox<>();
        shift = new javax.swing.JComboBox<>();
        update = new javax.swing.JButton();
        back = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        form_pane.setBackground(new java.awt.Color(255, 255, 255));
        form_pane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel1.setText("Emp Name");
        form_pane.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 220, 100, -1));

        jLabel2.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel2.setText("Emp ID");
        form_pane.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 150, 100, -1));

        name.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        name.setForeground(new java.awt.Color(0, 0, 204));
        name.setText("Emp ID");
        form_pane.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 210, 100, -1));

        jLabel4.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel4.setText("Emp Shift");
        form_pane.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 290, 100, -1));

        jLabel5.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel5.setText("Emp Attendance");
        form_pane.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 360, 140, -1));

        id.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        id.setForeground(new java.awt.Color(0, 0, 204));
        id.setText("Emp ID");
        form_pane.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 140, 100, -1));

        Attendance.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        Attendance.setForeground(new java.awt.Color(0, 0, 204));
        Attendance.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        form_pane.add(Attendance, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 350, 180, -1));

        shift.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        shift.setForeground(new java.awt.Color(0, 0, 204));
        shift.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        shift.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shiftActionPerformed(evt);
            }
        });
        form_pane.add(shift, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 280, 180, -1));

        update.setBackground(new java.awt.Color(0, 153, 102));
        update.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        update.setForeground(new java.awt.Color(255, 255, 255));
        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        form_pane.add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 440, 120, 40));

        back.setBackground(new java.awt.Color(51, 51, 51));
        back.setFont(new java.awt.Font("SimHei", 1, 19)); // NOI18N
        back.setForeground(new java.awt.Color(255, 255, 255));
        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        form_pane.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 40, 90, 40));

        jLabel6.setIcon(new javax.swing.ImageIcon("E:\\Food\\cheff6.png")); // NOI18N
        form_pane.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, -10, -1, -1));

        jLabel3.setFont(new java.awt.Font("Rockwell Nova", 1, 28)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 153));
        jLabel3.setText("Emp Attendance Update Details Form");
        form_pane.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 60, 560, -1));

        add(form_pane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1380, 890));
    }// </editor-fold>//GEN-END:initComponents

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to go back?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            // Navigate back to Emp_Panel using the reference
            att_upd.goBackToChild2();
        }
    }//GEN-LAST:event_backActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        try {
            String ID = id.getText().trim();
            String Name = name.getText().trim();
            String shif = (String) shift.getSelectedItem();
            String att = (String) Attendance.getSelectedItem();
            String query = "UPDATE emp_attendance SET Shift=?, Attendance=? WHERE Emp_ID=?";
            pst = con.prepareStatement(query);
            pst.setString(1, shif);
            pst.setString(2, att);
            pst.setString(3, ID);
            int rowsAffected = pst.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Employee record updated successfully.");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to update employee record.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_updateActionPerformed

    private void shiftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shiftActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_shiftActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Attendance;
    private javax.swing.JButton back;
    private javax.swing.JPanel form_pane;
    private javax.swing.JLabel id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel name;
    private javax.swing.JComboBox<String> shift;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
