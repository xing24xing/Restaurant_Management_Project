/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package food_project;

import food_project2.conn;
import food_project2.Home;
import static food_project.Emp_view.buildTableModel;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JOptionPane;

import java.sql.*;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
public class Emp_Update extends javax.swing.JFrame {
  Connection con = null;
   ResultSet rs = null;
   PreparedStatement pst = null;
  
    public Emp_Update() {
         initComponents();
         this.setExtendedState(Home.MAXIMIZED_BOTH);
        //cemployeeId = new Choice(); // Initialize cemployeeId
//        getContentPane().add(cemployeeId); // Add cemployeeId to the content pane
        fetchEmployeeData();
        customizeTable();
    }
  private void fetchEmployeeData() {
        try {
            con = conn.mycon();
            String query = "SELECT * FROM employee_details";
            pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            if (emp != null) {
                emp.setModel(buildTableModel(rs)); // Display result set in table
            } else {
                System.err.println("Error: JTable emp is null.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void fetchEmployeeData(String empID) {
    try {
        // Fetch employee details from the database based on the Emp_ID
        con = conn.mycon();
        String query = "SELECT * FROM employee_details WHERE Emp_ID = ?";
       pst = con.prepareStatement(query);
        pst.setString(1, empID);
        rs = pst.executeQuery();

        // Check if the result set is not empty
        if (rs.next()) {
            // Open the emp_update_form panel with the empID
            emp_update_form updateFormPanel = new emp_update_form(empID);
            updateFormPanel.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "No employee found with Emp_ID: " + empID);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e);
    }
}

    public static DefaultTableModel buildTableModel(ResultSet rs) throws SQLException {
        ResultSetMetaData metaData = rs.getMetaData();

        // Names of columns
        int columnCount = metaData.getColumnCount();
        String[] columnNames = new String[columnCount];
        for (int column = 1; column <= columnCount; column++) {
            columnNames[column - 1] = metaData.getColumnName(column);
        }

        // Data of the table
        Object[][] data = new Object[0][columnCount];
        int rowCount = 0;
        while (rs.next()) {
            Object[] newRow = new Object[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                newRow[i - 1] = rs.getObject(i);
            }
            data = addRow(data, newRow, rowCount++);
        }

        return new DefaultTableModel(data, columnNames);
    }

    // Helper method to add a row to Object[][]
    private static Object[][] addRow(Object[][] original, Object[] newRow, int rowCount) {
        Object[][] result = new Object[rowCount + 1][];
        System.arraycopy(original, 0, result, 0, rowCount);
        result[rowCount] = newRow;
        return result;
    }

    private void customizeTable() {
        emp.setDefaultRenderer(Object.class, new CustomTableCellRenderer());
        emp.setRowHeight(40); // Increase row height
        emp.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 19)); // Increase header font size
        emp.getTableHeader().setBackground(new Color(204, 0, 204)); // Set header background color
        emp.getTableHeader().setForeground(Color.red); // Set header text color

        // Set the size of the JScrollPane containing the table
        jScrollPane1.setPreferredSize(new Dimension(1500, 600));

        // Get the column count from the table model
        int columnCount = emp.getModel().getColumnCount();

        // Adjust preferred widths for specific columns
        if (columnCount > 0) {
            emp.getColumnModel().getColumn(0).setPreferredWidth(250); // Adjusted for the 1st column
        }
        if (columnCount > 1) {
            emp.getColumnModel().getColumn(1).setPreferredWidth(300); // Adjusted for the 2nd column
        }
        if (columnCount > 2) {
            emp.getColumnModel().getColumn(2).setPreferredWidth(150); // Adjusted for the 3rd column
        }
        if (columnCount > 3) {
            emp.getColumnModel().getColumn(3).setPreferredWidth(300); // Adjusted for the 4th column
        }

        // Make the table non-editable
        emp.setDefaultEditor(Object.class, null);
    }

    class CustomTableCellRenderer extends DefaultTableCellRenderer {

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
                int row, int column) {
            Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row,
                    column);

            // Set padding for cell data
            setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));

            // Center alignment for all cell content
            ((JLabel) cellComponent).setHorizontalAlignment(JLabel.CENTER);

            // Increase column width
            table.getColumnModel().getColumn(column).setPreferredWidth(200);
            return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        emp = new javax.swing.JTable();
        update_btn = new javax.swing.JButton();
        query = new javax.swing.JTextField();
        search = new javax.swing.JLabel();
        back = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        emp.setBackground(new java.awt.Color(204, 255, 204));
        emp.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        emp.setForeground(new java.awt.Color(153, 0, 153));
        emp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(emp);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 1340, -1));

        update_btn.setBackground(new java.awt.Color(51, 204, 0));
        update_btn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        update_btn.setForeground(new java.awt.Color(255, 255, 255));
        update_btn.setText("Update");
        update_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_btnActionPerformed(evt);
            }
        });
        getContentPane().add(update_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

        query.setFont(new java.awt.Font("UD Digi Kyokasho N-R", 1, 18)); // NOI18N
        query.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                queryActionPerformed(evt);
            }
        });
        getContentPane().add(query, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 30, 310, -1));

        search.setFont(new java.awt.Font("Segoe UI Black", 3, 24)); // NOI18N
        search.setForeground(new java.awt.Color(102, 0, 102));
        search.setText("Search Employee Queries Here :-");
        getContentPane().add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, -1, -1));

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

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void update_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_btnActionPerformed
     // Get the Emp_ID entered in the JTextField
    String empID = query.getText().trim();

    // Check if the empID is not empty
    if (!empID.isEmpty()) {
        // Open the emp_update_form panel with the entered employee ID
        fetchEmployeeData(empID);
    } else {
        // Show a message if no Emp_ID is entered
        JOptionPane.showMessageDialog(this, "Please enter an Employee ID.");
    }
    }//GEN-LAST:event_update_btnActionPerformed
    
    private void queryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_queryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_queryActionPerformed

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
            java.util.logging.Logger.getLogger(Emp_Update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Emp_Update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Emp_Update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Emp_Update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Emp_Update().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JTable emp;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField query;
    private javax.swing.JLabel search;
    private javax.swing.JButton update_btn;
    // End of variables declaration//GEN-END:variables
}
