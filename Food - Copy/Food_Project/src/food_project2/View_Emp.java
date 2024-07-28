/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package food_project2;

import food_project2.Home;
import food_project2.Emp_Up_Form;
import java.awt.print.PrinterException;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import java.awt.Color;
import java.util.Stack;
import javax.swing.JPanel;

//import static javax.swing.SwingConstants.CENTER;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
public class View_Emp extends javax.swing.JPanel {

    javax.swing.JFrame parentFrame;
    Stack<String> tasksStack;    
   Connection con = null;
   ResultSet rs = null;
   PreparedStatement ps = null;
   private Emp_Panel empPanel;
    public View_Emp(JPanel child2, Emp_Panel empPanel) {
         initComponents(); // Initialize components
    con = food_project2.conn.mycon();
     this.empPanel = empPanel;
    customizeTable();
    this.parentFrame = parentFrame;
    tasksStack = new Stack<>(); // Initialize the stack

    fetchEmployeeData();
        
    }

    private void fetchEmployeeData() {
    try {
        Connection con = food_project2.conn.mycon();
        String query = "SELECT * FROM employee_details";
        PreparedStatement pst = con.prepareStatement(query);
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
   private void fetchEmployeeData(String searchQuery) {
    try {
        con = food_project2.conn.mycon();
        String query;
        PreparedStatement pst;

        if (searchQuery == null || searchQuery.isEmpty()) {
            // If search query is empty or null, fetch all employee data
            query = "SELECT * FROM employee_details";
            pst = con.prepareStatement(query);
        } else {
            // If search query is not empty, search for matches in column data only
            query = "SELECT * FROM employee_details WHERE Emp_ID LIKE ? OR Name LIKE ? OR Father_Name LIKE ? OR DOB LIKE ? OR Phone_no LIKE ? OR Address LIKE ? OR Salary LIKE ? OR Email_ID LIKE ? OR Higher_edu LIKE ? OR Post LIKE ? OR Gender LIKE ? OR DOJ LIKE ?";
            pst = con.prepareStatement(query);

            // Set parameters for each column data search
            for (int i = 1; i <= 12; i++) {
                pst.setString(i, "%" + searchQuery + "%");
            }
        }

        ResultSet rs = pst.executeQuery();
        emp.setModel(buildTableModel(rs)); // Display result set in table
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
    emp.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15)); // Increase header font size
    emp.getTableHeader().setBackground(new Color(204, 0, 204)); // Set header background color
    emp.getTableHeader().setForeground(Color.BLUE); // Set header text color

    // Set the size of the JScrollPane containing the table
    jScrollPane1.setPreferredSize(new Dimension(1260, 550));

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

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            // Set padding for cell data
            setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));

            // Center alignment for all cell content
            ((JLabel) cellComponent).setHorizontalAlignment(JLabel.CENTER);

            // Increase column width
            table.getColumnModel().getColumn(column).setPreferredWidth(180);
            return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        }
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        search = new javax.swing.JLabel();
        query = new javax.swing.JTextField();
        back = new javax.swing.JButton();
        search_btn = new javax.swing.JButton();
        print = new javax.swing.JButton();
        view_all = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        emp = new javax.swing.JTable();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        search.setFont(new java.awt.Font("Segoe UI Black", 3, 24)); // NOI18N
        search.setForeground(new java.awt.Color(153, 0, 0));
        search.setText("Search By Employee Queries Here :-");
        jPanel1.add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, -1, -1));

        query.setFont(new java.awt.Font("UD Digi Kyokasho N-R", 1, 18)); // NOI18N
        query.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                queryActionPerformed(evt);
            }
        });
        jPanel1.add(query, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 60, 310, -1));

        back.setBackground(new java.awt.Color(204, 204, 204));
        back.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        jPanel1.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 60, -1, -1));

        search_btn.setBackground(new java.awt.Color(0, 0, 204));
        search_btn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        search_btn.setForeground(new java.awt.Color(255, 255, 255));
        search_btn.setText("Search");
        search_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_btnActionPerformed(evt);
            }
        });
        jPanel1.add(search_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        print.setBackground(new java.awt.Color(0, 0, 204));
        print.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        print.setForeground(new java.awt.Color(255, 255, 255));
        print.setText("Print");
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });
        jPanel1.add(print, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, -1, -1));

        view_all.setBackground(new java.awt.Color(0, 153, 153));
        view_all.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        view_all.setForeground(new java.awt.Color(255, 255, 255));
        view_all.setText("View All");
        view_all.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view_allActionPerformed(evt);
            }
        });
        jPanel1.add(view_all, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 120, -1, -1));

        cancel.setBackground(new java.awt.Color(255, 0, 0));
        cancel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        cancel.setForeground(new java.awt.Color(255, 255, 255));
        cancel.setText("Cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        jPanel1.add(cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 120, -1, -1));

        emp.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, 430));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1340, 810));
    }// </editor-fold>//GEN-END:initComponents

    private void search_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_btnActionPerformed
        String searchQuery = query.getText().trim();
        if (searchQuery.isEmpty()) {
            // If search query is empty, fetch all employee data
            fetchEmployeeData(null);
        } else {
            // If search query is not empty, perform the search
            fetchEmployeeData(searchQuery);
        }
    }//GEN-LAST:event_search_btnActionPerformed

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
        printTable();
    }//GEN-LAST:event_printActionPerformed
    private void printTable() {
    try {
        // Print the table
        boolean complete = emp.print(JTable.PrintMode.FIT_WIDTH, null, null);
        if (complete) {
            JOptionPane.showMessageDialog(null, "Printing Complete", "Printing Result", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Printing Cancelled", "Printing Result", JOptionPane.WARNING_MESSAGE);
        }
    } catch (PrinterException ex) {
        JOptionPane.showMessageDialog(null, "Printing Failed: " + ex.getMessage(), "Printing Error", JOptionPane.ERROR_MESSAGE);
    
    }}
    private void view_allActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view_allActionPerformed
        fetchEmployeeData(null);
    }//GEN-LAST:event_view_allActionPerformed
  private void fetchEmployeeDetails(String empID) {
    try {
        // Fetch employee details from the database based on the Emp_ID
        con = food_project2.conn.mycon();
        String query = "SELECT * FROM employee_details WHERE Emp_ID = ?";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1, empID);
        ResultSet rs = pst.executeQuery();

        // Check if the result set is not empty
        if (rs.next()) {
            // Open the emp_update_form panel with the details filled
//           Emp_Up_Form updateFormPanel = new Emp_Up_Form(empID); // Pass Emp_ID
//            updateFormPanel.setVisible(true);
            
        } else {
            JOptionPane.showMessageDialog(null, "No employee found with Emp_ID: " + empID);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e);
    }
}
    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        if (!tasksStack.isEmpty()) {
            String lastTask = tasksStack.pop(); // Pop the last task
            // Perform action associated with the last task
            switch (lastTask) {
                case "search":
                // Revert the UI or cancel search operation
                query.setText(""); // Clear search text field
                fetchEmployeeData(null); // Fetch all employee data
                break;
                // Add more cases for other tasks if needed
            }
        } else {
            JOptionPane.showMessageDialog(null, "No task to cancel!");
        }
    }//GEN-LAST:event_cancelActionPerformed

    private void queryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_queryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_queryActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to go back?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            // Navigate back to Emp_Panel using the reference
            empPanel.goToChild2();
        }

    }//GEN-LAST:event_backActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JButton cancel;
    private javax.swing.JTable emp;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton print;
    private javax.swing.JTextField query;
    private javax.swing.JLabel search;
    private javax.swing.JButton search_btn;
    private javax.swing.JButton view_all;
    // End of variables declaration//GEN-END:variables
}
