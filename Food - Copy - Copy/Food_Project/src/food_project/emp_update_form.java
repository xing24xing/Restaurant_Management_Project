/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package food_project;

import food_project2.conn;
import food_project2.Home;
import com.toedter.calendar.JDateChooser;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.sql.*;
import java.util.jar.Attributes.Name;
import javax.swing.JOptionPane;
public final class emp_update_form extends javax.swing.JFrame {

     Connection con = null;
   ResultSet rs = null;
   PreparedStatement pst = null;
    // Declare a variable to hold the employee ID
    private String empID;
   private final JDateChooser emp_dob_calendar; 
   private final JDateChooser emp_doj_calendar;
    public emp_update_form(String empID) {
     con = conn.mycon();
     this.empID = empID;
     initComponents();
     this.setExtendedState(Home.MAXIMIZED_BOTH);
       
        String[] educationOptions = {"Select", "B.Sc", "MBA", "B.E", "M.E", "B.Acc", "M.Fin", "B.Mktg", "M.Psy", "B.Nur",
            "M.Ed", "B.Comm", "M.PH", "B.CJ", "M.SW", "B.GD", "M.IT", "B.Bio", "M.Env", "B.Eng", 
            "M.PS", "B.Hist", "M.Soc", "B.Math", "M.IR", "High School", "Intermediate", 
            "B.A", "B.Com", "B.Tech", "M.Tech", "BBA", "MCA", "BCA", "MS", "Ph.D", 
            "LLB", "BDS", "MBBS", "CA", "ICWA", "CS", "M.Sc", "M.A", "BFA", "B.Pharm",
            "M.Pharm", "B.Ed", "Diploma"};
      DefaultComboBoxModel<String> eduModel = new DefaultComboBoxModel<>(educationOptions);
      emp_edu.setModel(eduModel);
      emp_edu = new javax.swing.JComboBox<>(eduModel);
      emp_edu.setFont(new java.awt.Font("Segoe UI", 1, 14));
      // Set font for combo box
      getContentPane().add(emp_edu, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 460, 160, -1));
     emp_dob_calendar = new JDateChooser(); // Initialize the JDateChooser
      getContentPane().add(emp_dob_calendar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 460, 190, -1)); // Add JDateChooser
        // Add a JDateChooser component for emp_doj after emp_salary in the initComponents method
   emp_doj_calendar = new JDateChooser();
    getContentPane().add(emp_doj_calendar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 390, 190, -1)); // Adjust the coordinates as needed

// Adjust the submitActionPerformed method to retrieve the selected date from the JDateChooser for emp_doj
      String DOJ = ((JTextField) emp_doj_calendar.getDateEditor().getUiComponent()).getText();
        emp_id.setEditable(false);

    fetchAndSetEmployeeDetails(empID);

    }

   
    private void fetchAndSetEmployeeDetails(String empID) {
    try {
        // Fetch employee details from the database based on the Emp_ID
        con = conn.mycon();
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

        name = new javax.swing.JLabel();
        phone = new javax.swing.JLabel();
        email = new javax.swing.JLabel();
        address = new javax.swing.JLabel();
        dob = new javax.swing.JLabel();
        gender = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        father = new javax.swing.JLabel();
        salary = new javax.swing.JLabel();
        doj = new javax.swing.JLabel();
        edu = new javax.swing.JLabel();
        post = new javax.swing.JLabel();
        emp_name = new javax.swing.JTextField();
        emp_phone = new javax.swing.JTextField();
        emp_email = new javax.swing.JTextField();
        emp_gender = new javax.swing.JTextField();
        emp_id = new javax.swing.JTextField();
        fname = new javax.swing.JTextField();
        emp_salary = new javax.swing.JTextField();
        emp_edu = new javax.swing.JComboBox<>();
        emp_post = new javax.swing.JTextField();
        emp_add = new javax.swing.JTextField();
        update_btn = new javax.swing.JButton();
        cancel_btn = new javax.swing.JButton();
        update_head = new javax.swing.JLabel();
        back = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        name.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        name.setForeground(new java.awt.Color(0, 0, 255));
        name.setText("Employee Name");
        getContentPane().add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 170, 149, -1));

        phone.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        phone.setForeground(new java.awt.Color(0, 0, 255));
        phone.setText("Phone no.");
        getContentPane().add(phone, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 250, 149, -1));

        email.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        email.setForeground(new java.awt.Color(0, 0, 255));
        email.setText("Email ID");
        getContentPane().add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 320, 149, -1));

        address.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        address.setForeground(new java.awt.Color(0, 0, 255));
        address.setText("Address");
        getContentPane().add(address, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 400, 149, -1));

        dob.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        dob.setForeground(new java.awt.Color(0, 0, 255));
        dob.setText("Date Of Birth");
        getContentPane().add(dob, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 470, 149, -1));

        gender.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        gender.setForeground(new java.awt.Color(0, 0, 255));
        gender.setText("Gender");
        getContentPane().add(gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 540, 149, -1));

        id.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        id.setForeground(new java.awt.Color(0, 0, 255));
        id.setText("Employee ID");
        getContentPane().add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 170, 149, -1));

        father.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        father.setForeground(new java.awt.Color(0, 0, 255));
        father.setText("Father's Name");
        getContentPane().add(father, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 240, 149, -1));

        salary.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        salary.setForeground(new java.awt.Color(0, 0, 255));
        salary.setText("Salary");
        getContentPane().add(salary, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 320, 149, -1));

        doj.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        doj.setForeground(new java.awt.Color(0, 0, 255));
        doj.setText("Date Of Joining");
        getContentPane().add(doj, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 390, 149, -1));

        edu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        edu.setForeground(new java.awt.Color(0, 0, 255));
        edu.setText("Higher Qualification");
        getContentPane().add(edu, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 460, 180, -1));

        post.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        post.setForeground(new java.awt.Color(0, 0, 255));
        post.setText("Post/ Desingnation");
        getContentPane().add(post, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 540, 170, -1));

        emp_name.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        getContentPane().add(emp_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 180, 190, -1));

        emp_phone.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        getContentPane().add(emp_phone, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 250, 190, -1));

        emp_email.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        getContentPane().add(emp_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 320, 190, -1));

        emp_gender.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        getContentPane().add(emp_gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 530, 190, -1));

        emp_id.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        getContentPane().add(emp_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 170, 190, -1));

        fname.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        getContentPane().add(fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 240, 190, -1));

        emp_salary.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        getContentPane().add(emp_salary, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 310, 190, -1));

        emp_edu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        emp_edu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(emp_edu, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 460, 160, -1));

        emp_post.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        getContentPane().add(emp_post, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 540, 190, -1));

        emp_add.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        getContentPane().add(emp_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 390, 190, -1));

        update_btn.setBackground(new java.awt.Color(51, 204, 0));
        update_btn.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        update_btn.setForeground(new java.awt.Color(255, 255, 255));
        update_btn.setText("Update");
        update_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_btnActionPerformed(evt);
            }
        });
        getContentPane().add(update_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 640, -1, -1));

        cancel_btn.setBackground(new java.awt.Color(255, 0, 51));
        cancel_btn.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        cancel_btn.setForeground(new java.awt.Color(255, 255, 255));
        cancel_btn.setText("cancel");
        cancel_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel_btn_btnActionPerformed(evt);
            }
        });
        getContentPane().add(cancel_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 640, -1, -1));

        update_head.setBackground(new java.awt.Color(204, 204, 204));
        update_head.setFont(new java.awt.Font("Sitka Text", 3, 30)); // NOI18N
        update_head.setForeground(new java.awt.Color(0, 102, 102));
        update_head.setText("Update Employee Data");
        getContentPane().add(update_head, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 50, -1, -1));

        back.setBackground(new java.awt.Color(204, 204, 204));
        back.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        getContentPane().add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(1440, 20, -1, -1));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Vivaldi", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(32, 163, 103));
        jLabel7.setText("K - Food");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 190, -1));
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, -1, -1));

        pack();
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
        this.dispose(); // Terminate the current JFrame
        Emp_Update update = new Emp_Update(); // Create an instance of the Employee_Panel class
        update.setVisible(true); // Make the Employee_Panel visible
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
            java.util.logging.Logger.getLogger(emp_update_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(emp_update_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(emp_update_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(emp_update_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
             String empID = "Emp_ID"; // Replace "123" with an actual employee ID from your database
            try {
                new emp_update_form(empID).setVisible(true);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }
            }
        });
    }

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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel name;
    private javax.swing.JLabel phone;
    private javax.swing.JLabel post;
    private javax.swing.JLabel salary;
    private javax.swing.JButton update_btn;
    private javax.swing.JLabel update_head;
    // End of variables declaration//GEN-END:variables
}
