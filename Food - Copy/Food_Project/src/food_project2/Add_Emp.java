/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package food_project2;

import java.sql.*;
import com.toedter.calendar.JDateChooser; // Import the JCalendar componen
import java.util.Random;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class Add_Emp extends javax.swing.JPanel {

    Connection con = null;
    PreparedStatement ps = null;

    private final JDateChooser emp_dob_calendar;
    private final JDateChooser emp_doj_calendar;
    private Emp_Panel empPanel;
    public Add_Emp(JPanel child2, Emp_Panel empPanel) {
        initComponents();
        this.empPanel = empPanel;
        String[] educationOptions = {"Select", "B.Sc", "MBA", "B.E", "M.E", "B.Acc", "M.Fin", "B.Mktg", "M.Psy", "B.Nur",
            "M.Ed", "B.Comm", "M.PH", "B.CJ", "M.SW", "B.GD", "M.IT", "B.Bio", "M.Env", "B.Eng",
            "M.PS", "B.Hist", "M.Soc", "B.Math", "M.IR", "High School", "Intermediate",
            "B.A", "B.Com", "B.Tech", "M.Tech", "BBA", "MCA", "BCA", "MS", "Ph.D",
            "LLB", "BDS", "MBBS", "CA", "ICWA", "CS", "M.Sc", "M.A", "BFA", "B.Pharm",
            "M.Pharm", "B.Ed", "Diploma"};
        DefaultComboBoxModel<String> eduModel = new DefaultComboBoxModel<>(educationOptions);
        emp_edu.setModel(eduModel);
        emp_edu.setFont(new java.awt.Font("Segoe UI", 1, 14));

        emp_dob_calendar = new JDateChooser();
add(emp_dob_calendar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 460, 190, -1));

emp_doj_calendar = new JDateChooser();
add(emp_doj_calendar, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 370, 190, -1));
 emp_id.setEditable(false);
  con = food_project2.conn.mycon();  

    }

     private String generateRandomSixDigitNumber() {
    Random random = new Random();
    int num = random.nextInt(900000) + 100000; // Generates a random number between 100000 and 999999
    return String.valueOf(num);
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        new_pane = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        phone = new javax.swing.JLabel();
        email = new javax.swing.JLabel();
        address = new javax.swing.JLabel();
        dob = new javax.swing.JLabel();
        gender = new javax.swing.JLabel();
        emp_name = new javax.swing.JTextField();
        emp_phone = new javax.swing.JTextField();
        emp_email = new javax.swing.JTextField();
        emp_add = new javax.swing.JTextField();
        emp_gender = new javax.swing.JTextField();
        submit = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        id = new javax.swing.JLabel();
        father = new javax.swing.JLabel();
        salary = new javax.swing.JLabel();
        doj = new javax.swing.JLabel();
        edu = new javax.swing.JLabel();
        post = new javax.swing.JLabel();
        emp_edu = new javax.swing.JComboBox<>();
        emp_id = new javax.swing.JTextField();
        back = new javax.swing.JButton();
        emp_father = new javax.swing.JTextField();
        emp_salary = new javax.swing.JTextField();
        emp_post = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        new_pane.setBackground(new java.awt.Color(255, 255, 255));
        new_pane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setBackground(new java.awt.Color(204, 204, 204));
        jLabel11.setFont(new java.awt.Font("Segoe UI Black", 1, 30)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 51, 51));
        jLabel11.setText("New Employee Details");
        new_pane.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 50, -1, -1));

        name.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        name.setForeground(new java.awt.Color(0, 0, 255));
        name.setText("Employee Name");
        new_pane.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 149, -1));

        phone.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        phone.setForeground(new java.awt.Color(0, 0, 255));
        phone.setText("Phone no.");
        new_pane.add(phone, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 149, -1));

        email.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        email.setForeground(new java.awt.Color(0, 0, 255));
        email.setText("Email ID");
        new_pane.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 320, 149, -1));

        address.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        address.setForeground(new java.awt.Color(0, 0, 255));
        address.setText("Address");
        new_pane.add(address, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 390, 149, -1));

        dob.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        dob.setForeground(new java.awt.Color(0, 0, 255));
        dob.setText("Date Of Birth");
        new_pane.add(dob, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 470, 149, -1));

        gender.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        gender.setForeground(new java.awt.Color(0, 0, 255));
        gender.setText("Gender");
        new_pane.add(gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 540, 149, -1));

        emp_name.setFont(new java.awt.Font("SimSun-ExtB", 1, 14)); // NOI18N
        new_pane.add(emp_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 170, 190, -1));

        emp_phone.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        new_pane.add(emp_phone, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 240, 190, -1));

        emp_email.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        new_pane.add(emp_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 310, 190, -1));

        emp_add.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        new_pane.add(emp_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 390, 190, -1));

        emp_gender.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        new_pane.add(emp_gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 530, 190, -1));

        submit.setBackground(new java.awt.Color(0, 204, 0));
        submit.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        submit.setForeground(new java.awt.Color(255, 255, 255));
        submit.setText("submit");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });
        new_pane.add(submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 610, -1, -1));

        cancel.setBackground(new java.awt.Color(255, 0, 51));
        cancel.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        cancel.setForeground(new java.awt.Color(255, 255, 255));
        cancel.setText("cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        new_pane.add(cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 610, -1, -1));

        id.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        id.setForeground(new java.awt.Color(0, 0, 255));
        id.setText("Employee ID");
        new_pane.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 160, 149, -1));

        father.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        father.setForeground(new java.awt.Color(0, 0, 255));
        father.setText("Father's Name");
        new_pane.add(father, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 230, 149, -1));

        salary.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        salary.setForeground(new java.awt.Color(0, 0, 255));
        salary.setText("Salary");
        new_pane.add(salary, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 300, 149, -1));

        doj.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        doj.setForeground(new java.awt.Color(0, 0, 255));
        doj.setText("Date Of Joining");
        new_pane.add(doj, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 380, 149, -1));

        edu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        edu.setForeground(new java.awt.Color(0, 0, 255));
        edu.setText("Higher Qualification");
        new_pane.add(edu, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 450, 180, -1));

        post.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        post.setForeground(new java.awt.Color(0, 0, 255));
        post.setText("Post/ Desingnation");
        new_pane.add(post, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 520, 170, -1));

        emp_edu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        emp_edu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        new_pane.add(emp_edu, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 450, 190, 30));

        emp_id.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        new_pane.add(emp_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 160, 190, -1));

        back.setBackground(new java.awt.Color(204, 204, 204));
        back.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        new_pane.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 60, -1, -1));

        emp_father.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        new_pane.add(emp_father, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 230, 190, -1));

        emp_salary.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        new_pane.add(emp_salary, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 300, 190, -1));

        emp_post.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        new_pane.add(emp_post, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 530, 190, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon("E:\\Food\\cheff6.png")); // NOI18N
        new_pane.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-50, -50, -1, -1));

        add(new_pane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1450, 740));
    }// </editor-fold>//GEN-END:initComponents

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        try {
            // Generate a random six-digit number for Employee_ID
            String Emloyee_Id = generateRandomSixDigitNumber();
            String Employee_name = emp_name.getText(); // Corrected variable name
            String Father_Name = emp_father.getText(); // Corrected variable name
            String DOB = ((JTextField) emp_dob_calendar.getDateEditor().getUiComponent()).getText(); // Corrected variable name
            String Phone_no = emp_phone.getText();
            String Emp_Address = emp_add.getText();
            String Emp_Salary = emp_salary.getText();
            String Email_ID = emp_email.getText();
            String Higher_Qua = emp_edu.getSelectedItem().toString();
            String Post = emp_post.getText();
            String Gender = emp_gender.getText(); // Assuming emp_gender is the component for gender input
            String DOJ = ((JTextField) emp_doj_calendar.getDateEditor().getUiComponent()).getText(); // Corrected variable name

            // Check if email contains "@gmail.com"
             java.util.Date currentDate = new java.util.Date();

        // Check if selected DOB is after the current date
        if (emp_dob_calendar.getDate().after(currentDate)) {
            JOptionPane.showMessageDialog(null, "Please select a date of birth on or before the current date.");
            return; // Stop further execution
        }

        // Check if selected DOJ is after the current date
        if (emp_doj_calendar.getDate().after(currentDate)) {
            JOptionPane.showMessageDialog(null, "Please select a date of joining on or before the current date.");
            return; // Stop further execution
        }
            if (!Email_ID.contains("@gmail.com")) {
                JOptionPane.showMessageDialog(null, "Please enter a valid Gmail address");
                return; // Stop further execution
            }
          if (Phone_no.length() != 10){
                JOptionPane.showMessageDialog(null, "Please enter a 10-digit phone number");
                return; // Stop further execution
            }

            String query = "INSERT INTO employee_details (Emp_ID, Name, Father_Name, DOB, Phone_no, Address, Salary, Email_ID, Higher_edu, Post, Gender, DOJ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, Emloyee_Id);
            pst.setString(2, Employee_name);
            pst.setString(3, Father_Name);
            pst.setString(4,  DOB);
            pst.setString(5, Phone_no);
            pst.setString(6, Emp_Address);
            pst.setString(7, Emp_Salary);
            pst.setString(8, Email_ID);
            pst.setString(9, Higher_Qua);
            pst.setString(10, Post);
            pst.setString(11, Gender);
            pst.setString(12, DOJ);
            // Assuming Department and Experience are obtained from input fields as well

            pst.executeUpdate();

            emp_name.setText("");
        emp_father.setText("");
        emp_phone.setText("");
        emp_add.setText("");
        emp_salary.setText("");
        emp_email.setText("");
        emp_post.setText("");
        emp_gender.setText("");
        emp_edu.setSelectedIndex(0); // Set to default value
        emp_dob_calendar.setDate(null); // Clear the date chooser for DOB
        emp_doj_calendar.setDate(null); // Clear the date chooser for DOJ

        JOptionPane.showMessageDialog(null, "Data Inserted Successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_submitActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        // Clear all the text fields and reset the combo box to default
        emp_name.setText("");
        emp_father.setText("");
        emp_phone.setText("");
        emp_add.setText("");
        emp_salary.setText("");
        emp_email.setText("");
        emp_post.setText("");
        emp_gender.setText("");
        emp_edu.setSelectedIndex(0); // Set to default value
        emp_dob_calendar.setDate(null); // Clear the date chooser for DOB
        emp_doj_calendar.setDate(null); // Clear the date chooser for DOJ
    }//GEN-LAST:event_cancelActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to go back?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            // Navigate back to Emp_Panel using the reference
            empPanel.goToChild2();
        }

    }//GEN-LAST:event_backActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel address;
    private javax.swing.JButton back;
    private javax.swing.JButton cancel;
    private javax.swing.JLabel dob;
    private javax.swing.JLabel doj;
    private javax.swing.JLabel edu;
    private javax.swing.JLabel email;
    private javax.swing.JTextField emp_add;
    private javax.swing.JComboBox<String> emp_edu;
    private javax.swing.JTextField emp_email;
    private javax.swing.JTextField emp_father;
    private javax.swing.JTextField emp_gender;
    private javax.swing.JTextField emp_id;
    private javax.swing.JTextField emp_name;
    private javax.swing.JTextField emp_phone;
    private javax.swing.JTextField emp_post;
    private javax.swing.JTextField emp_salary;
    private javax.swing.JLabel father;
    private javax.swing.JLabel gender;
    private javax.swing.JLabel id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel name;
    private javax.swing.JPanel new_pane;
    private javax.swing.JLabel phone;
    private javax.swing.JLabel post;
    private javax.swing.JLabel salary;
    private javax.swing.JButton submit;
    // End of variables declaration//GEN-END:variables
}
