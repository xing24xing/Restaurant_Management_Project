/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package food_project2;

import com.toedter.calendar.JDateChooser;
import food_project2.Home;
import java.sql.*;
import com.toedter.calendar.JDateChooser; // Import the JCalendar componen
import java.util.Random;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Emp_Up_Form extends javax.swing.JPanel {
Connection con = null;
private String empID;
PreparedStatement pst = null;
   ResultSet rs = null;
    private Emp_Update update;
    private final JDateChooser emp_dob_calendar;
    private final JDateChooser emp_doj_calendar;

    public Emp_Up_Form(JPanel child2, Emp_Update update, String empID) {
//      con = food_project.conn.mycon();
       this.empID = empID;
        con = food_project2.conn.mycon();
        initComponents();
        this.update = update;
        String[] educationOptions = {"Select", "B.Sc", "MBA", "B.E", "M.E", "B.Acc", "M.Fin", "B.Mktg", "M.Psy", "B.Nur",
            "M.Ed", "B.Comm", "M.PH", "B.CJ", "M.SW", "B.GD", "M.IT", "B.Bio", "M.Env", "B.Eng", 
            "M.PS", "B.Hist", "M.Soc", "B.Math", "M.IR", "High School", "Intermediate", 
            "B.A", "B.Com", "B.Tech", "M.Tech", "BBA", "MCA", "BCA", "MS", "Ph.D", 
            "LLB", "BDS", "MBBS", "CA", "ICWA", "CS", "M.Sc", "M.A", "BFA", "B.Pharm",
            "M.Pharm", "B.Ed", "Diploma"};
      DefaultComboBoxModel<String> eduModel = new DefaultComboBoxModel<>(educationOptions);
      emp_edu.setModel(eduModel);
//      emp_edu = new javax.swing.JComboBox<>(eduModel);
      emp_edu.setFont(new java.awt.Font("Segoe UI", 1, 14));
      // Set font for combo box
//      add(emp_edu, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 460, 160, -1));
     emp_dob_calendar = new JDateChooser(); // Initialize the JDateChooser
     add(emp_dob_calendar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 415, 190, -1)); // Add JDateChooser
        // Add a JDateChooser component for emp_doj after emp_salary in the initComponents method
   emp_doj_calendar = new JDateChooser();
    add(emp_doj_calendar, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 390, 190, -1)); // Adjust the coordinates as needed

// Adjust the submitActionPerformed method to retrieve the selected date from the JDateChooser for emp_doj
//      String DOJ = ((JTextField) emp_doj_calendar.getDateEditor().getUiComponent()).getText();
        emp_id.setEditable(false);

    fetchAndSetEmployeeDetails(empID);
    }

    private void fetchAndSetEmployeeDetails(String empID) {
    try {
        // Fetch employee details from the database based on the Emp_ID
         con = food_project2.conn.mycon();
        String query = "SELECT * FROM employee_details WHERE Emp_ID = ?";
        pst = con.prepareStatement(query);
        pst.setString(1, empID);
        rs = pst.executeQuery();

        // Check if the result set is not empty
       // Check if the result set is not empty
        if (rs.next()) {
    // Set the text of the fields with fetched employee details
    emp_id.setText(empID);
    emp_name.setText(rs.getString("Name"));
    fname.setText(rs.getString("Father_Name"));
    emp_phone.setText(rs.getString("Phone_no"));
    emp_email.setText(rs.getString("Email_ID"));
    emp_add.setText(rs.getString("Address"));
    emp_gender.setText(rs.getString("Gender"));
    emp_salary.setText(rs.getString("Salary"));
    emp_post.setText(rs.getString("Post"));
    emp_edu.setSelectedItem(rs.getString("Higher_edu"));
    ((JTextField) emp_dob_calendar.getDateEditor().getUiComponent()).setText(rs.getString("DOB"));
    ((JTextField) emp_doj_calendar.getDateEditor().getUiComponent()).setText(rs.getString("DOJ"));
} else {
    JOptionPane.showMessageDialog(null, "No employee found with Emp_ID: " + empID);
}
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e);
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        update_head = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        phone = new javax.swing.JLabel();
        emp_phone = new javax.swing.JTextField();
        email = new javax.swing.JLabel();
        emp_email = new javax.swing.JTextField();
        gender = new javax.swing.JLabel();
        address = new javax.swing.JLabel();
        emp_add = new javax.swing.JTextField();
        dob = new javax.swing.JLabel();
        emp_gender = new javax.swing.JTextField();
        emp_name = new javax.swing.JTextField();
        update_btn = new javax.swing.JButton();
        cancel_btn = new javax.swing.JButton();
        id = new javax.swing.JLabel();
        emp_id = new javax.swing.JTextField();
        father = new javax.swing.JLabel();
        fname = new javax.swing.JTextField();
        salary = new javax.swing.JLabel();
        emp_salary = new javax.swing.JTextField();
        doj = new javax.swing.JLabel();
        edu = new javax.swing.JLabel();
        emp_edu = new javax.swing.JComboBox<>();
        emp_post = new javax.swing.JTextField();
        post = new javax.swing.JLabel();
        back = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        update_head.setBackground(new java.awt.Color(204, 204, 204));
        update_head.setFont(new java.awt.Font("Sitka Text", 3, 30)); // NOI18N
        update_head.setForeground(new java.awt.Color(0, 102, 102));
        update_head.setText("Update Employee Data");
        add(update_head, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 60, -1, -1));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Vivaldi", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(32, 163, 103));
        jLabel7.setText("K - Food");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 190, -1));

        name.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        name.setForeground(new java.awt.Color(0, 0, 255));
        name.setText("Employee Name");
        add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 149, -1));

        phone.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        phone.setForeground(new java.awt.Color(0, 0, 255));
        phone.setText("Phone no.");
        add(phone, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, 149, -1));

        emp_phone.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        add(emp_phone, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 240, 240, 35));

        email.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        email.setForeground(new java.awt.Color(0, 0, 255));
        email.setText("Email ID");
        add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 310, 149, -1));

        emp_email.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        add(emp_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 310, 240, 35));

        gender.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        gender.setForeground(new java.awt.Color(0, 0, 255));
        gender.setText("Gender");
        add(gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 500, 149, -1));

        address.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        address.setForeground(new java.awt.Color(0, 0, 255));
        address.setText("Address");
        add(address, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 370, 149, -1));

        emp_add.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        add(emp_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 380, 240, 35));

        dob.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        dob.setForeground(new java.awt.Color(0, 0, 255));
        dob.setText("Date Of Birth");
        add(dob, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 430, 149, -1));

        emp_gender.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        add(emp_gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 500, 240, 35));

        emp_name.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        add(emp_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 170, 240, 35));

        update_btn.setBackground(new java.awt.Color(51, 204, 0));
        update_btn.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        update_btn.setForeground(new java.awt.Color(255, 255, 255));
        update_btn.setText("Update");
        update_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_btnActionPerformed(evt);
            }
        });
        add(update_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 600, -1, -1));

        cancel_btn.setBackground(new java.awt.Color(255, 0, 51));
        cancel_btn.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        cancel_btn.setForeground(new java.awt.Color(255, 255, 255));
        cancel_btn.setText("cancel");
        cancel_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel_btn_btnActionPerformed(evt);
            }
        });
        add(cancel_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 600, -1, -1));

        id.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        id.setForeground(new java.awt.Color(0, 0, 255));
        id.setText("Employee ID");
        add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 170, 149, -1));

        emp_id.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        add(emp_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 160, 240, 35));

        father.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        father.setForeground(new java.awt.Color(0, 0, 255));
        father.setText("Father's Name");
        add(father, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 240, 149, -1));

        fname.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        fname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fnameActionPerformed(evt);
            }
        });
        add(fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 240, 240, 35));

        salary.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        salary.setForeground(new java.awt.Color(0, 0, 255));
        salary.setText("Salary");
        add(salary, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 310, 149, -1));

        emp_salary.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        add(emp_salary, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 310, 240, 35));

        doj.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        doj.setForeground(new java.awt.Color(0, 0, 255));
        doj.setText("Date Of Joining");
        add(doj, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 380, 149, -1));

        edu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        edu.setForeground(new java.awt.Color(0, 0, 255));
        edu.setText("Higher Qualification");
        add(edu, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 450, 180, -1));

        emp_edu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        emp_edu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(emp_edu, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 450, 240, 35));

        emp_post.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        add(emp_post, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 510, 240, 35));

        post.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        post.setForeground(new java.awt.Color(0, 0, 255));
        post.setText("Post/ Desingnation");
        add(post, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 510, 170, -1));

        back.setBackground(new java.awt.Color(204, 204, 204));
        back.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 60, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void update_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_btnActionPerformed
        try {
            // Get data from text fields
            String empName = emp_name.getText().trim();
            String fatherName = fname.getText().trim();
            String phoneNo = emp_phone.getText().trim();
            String address = emp_add.getText().trim();
            String salary = emp_salary.getText().trim();
            String email = emp_email.getText().trim();
            String post = emp_post.getText().trim();
            String gender = emp_gender.getText().trim();
            String edu = (String) emp_edu.getSelectedItem();
            String dob = ((JTextField) emp_dob_calendar.getDateEditor().getUiComponent()).getText();
            String doj = ((JTextField) emp_doj_calendar.getDateEditor().getUiComponent()).getText();

            // Update query
            String query = "UPDATE employee_details SET Name=?, Father_Name=?, Phone_no=?, Address=?, Salary=?, Email_ID=?, Post=?, Gender=?, Higher_edu=?, DOB=?, DOJ=? WHERE Emp_ID=?";

            // Prepare statement
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, empName);
            pst.setString(2, fatherName);
            pst.setString(3, phoneNo);
            pst.setString(4, address);
            pst.setString(5, salary);
            pst.setString(6, email);
            pst.setString(7, post);
            pst.setString(8, gender);
            pst.setString(9, edu);
            pst.setString(10, dob);
            pst.setString(11, doj);
            pst.setString(12, emp_id.getText());

            // Execute the update
            int rowsAffected = pst.executeUpdate();

            // Check if update successful
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Employee record updated successfully.");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to update employee record.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_update_btnActionPerformed

    private void cancel_btn_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel_btn_btnActionPerformed
        // Clear all the text fields and reset the combo box to default
        emp_name.setText("");
        fname.setText("");
        emp_phone.setText("");
        emp_add.setText("");
        emp_salary.setText("");
        emp_email.setText("");
        emp_post.setText("");
        emp_gender.setText("");
        emp_edu.setSelectedIndex(0); // Set to default value
        emp_dob_calendar.setDate(null); // Clear the date chooser for DOB
        emp_doj_calendar.setDate(null); // Clear the date chooser for DOJ
    }//GEN-LAST:event_cancel_btn_btnActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
       int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to go back?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            // Navigate back to Emp_Panel using the reference
            update.goToChild2();
        }
     

    }//GEN-LAST:event_backActionPerformed

    private void fnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fnameActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel address;
    private javax.swing.JButton back;
    private javax.swing.JButton cancel_btn;
    private javax.swing.JLabel dob;
    private javax.swing.JLabel doj;
    private javax.swing.JLabel edu;
    private javax.swing.JLabel email;
    private javax.swing.JTextField emp_add;
    private javax.swing.JComboBox<String> emp_edu;
    private javax.swing.JTextField emp_email;
    private javax.swing.JTextField emp_gender;
    private javax.swing.JTextField emp_id;
    private javax.swing.JTextField emp_name;
    private javax.swing.JTextField emp_phone;
    private javax.swing.JTextField emp_post;
    private javax.swing.JTextField emp_salary;
    private javax.swing.JLabel father;
    private javax.swing.JTextField fname;
    private javax.swing.JLabel gender;
    private javax.swing.JLabel id;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel name;
    private javax.swing.JLabel phone;
    private javax.swing.JLabel post;
    private javax.swing.JLabel salary;
    private javax.swing.JButton update_btn;
    private javax.swing.JLabel update_head;
    // End of variables declaration//GEN-END:variables
}
