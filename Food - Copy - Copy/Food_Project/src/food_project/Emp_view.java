/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package food_project;



import food_project2.conn;
import food_project2.Home;
import java.awt.print.PrinterException;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterJob;
import java.util.Stack;

//import static javax.swing.SwingConstants.CENTER;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
public class Emp_view extends javax.swing.JFrame {

    javax.swing.JFrame parentFrame;
    Stack<String> tasksStack;    
   Connection con = null;
   ResultSet rs = null;
   PreparedStatement ps = null;
 
    public Emp_view() {
      initComponents(); // Initialize components
    con = conn.mycon();
    this.setExtendedState(Home.MAXIMIZED_BOTH);
//    customizeTable();
    this.parentFrame = parentFrame;
    tasksStack = new Stack<>(); // Initialize the stack

    fetchEmployeeData(); // Fe    
    
//        search_btn.addActionListener(e -> searchButtonClicked());
emp.setEnabled(false);
    }

    private void fetchEmployeeData() {
    try {
        Connection con = conn.mycon();
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
//   private void fetchEmployeeData(String searchQuery) {
//    try {
//        con = conn.mycon();
//        String query;
//        PreparedStatement pst;
//
//        if (searchQuery == null || searchQuery.isEmpty()) {
//            // If search query is empty or null, fetch all employee data
//            query = "SELECT * FROM employee_details";
//            pst = con.prepareStatement(query);
//        } else {
//            // If search query is not empty, search for matches in column data only
//            query = "SELECT * FROM employee_details WHERE Emp_ID LIKE ? OR Name LIKE ? OR Father_Name LIKE ? OR DOB LIKE ? OR Phone_no LIKE ? OR Address LIKE ? OR Salary LIKE ? OR Email_ID LIKE ? OR Higher_edu LIKE ? OR Post LIKE ? OR Gender LIKE ? OR DOJ LIKE ?";
//            pst = con.prepareStatement(query);
//
//            // Set parameters for each column data search
//            for (int i = 1; i <= 12; i++) {
//                pst.setString(i, "%" + searchQuery + "%");
//            }
//        }
//
//        ResultSet rs = pst.executeQuery();
//        emp.setModel(buildTableModel(rs)); // Display result set in table
//    } catch (SQLException e) {
//        JOptionPane.showMessageDialog(null, e);
//    }
//}
//
//
  
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

//   private void customizeTable() {
//    emp.setDefaultRenderer(Object.class, new CustomTableCellRenderer());
//    emp.setRowHeight(40); // Increase row height
//    emp.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 19)); // Increase header font size
//    emp.getTableHeader().setBackground(new Color(204, 0, 204)); // Set header background color
//    emp.getTableHeader().setForeground(Color.red); // Set header text color
//
//    // Set the size of the JScrollPane containing the table
//    jScrollPane1.setPreferredSize(new Dimension(1500, 600));
//
//    // Get the column count from the table model
//    int columnCount = emp.getModel().getColumnCount();
//    
//    // Adjust preferred widths for specific columns
//    if (columnCount > 0) {
//        emp.getColumnModel().getColumn(0).setPreferredWidth(250); // Adjusted for the 1st column
//    }
//    if (columnCount > 1) {
//        emp.getColumnModel().getColumn(1).setPreferredWidth(300); // Adjusted for the 2nd column
//    }
//    if (columnCount > 2) {
//        emp.getColumnModel().getColumn(2).setPreferredWidth(150); // Adjusted for the 3rd column
//    }
//    if (columnCount > 3) {
//        emp.getColumnModel().getColumn(3).setPreferredWidth(300); // Adjusted for the 4th column
//    }
//
//    // Make the table non-editable
//    emp.setDefaultEditor(Object.class, null);
//}
//
//   class CustomTableCellRenderer extends DefaultTableCellRenderer {
//
//        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
//            Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
//
//            // Set padding for cell data
//            setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
//
//            // Center alignment for all cell content
//            ((JLabel) cellComponent).setHorizontalAlignment(JLabel.CENTER);
//
//            // Increase column width
//            table.getColumnModel().getColumn(column).setPreferredWidth(200);
//            return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
//        }
//    }
//    
//
   
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        search = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        emp = new javax.swing.JTable();
        cancel = new javax.swing.JButton();
        view_all = new javax.swing.JButton();
        query = new javax.swing.JTextField();
        back = new javax.swing.JButton();
        print = new javax.swing.JButton();
        search_btn = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        search.setFont(new java.awt.Font("Segoe UI Black", 3, 24)); // NOI18N
        search.setForeground(new java.awt.Color(153, 0, 0));
        search.setText("Search By Employee Queries Here :-");
        getContentPane().add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, -1, -1));

        emp.setBackground(new java.awt.Color(204, 255, 204));
        emp.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 1130, 500));

        cancel.setBackground(new java.awt.Color(255, 0, 0));
        cancel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        cancel.setForeground(new java.awt.Color(255, 255, 255));
        cancel.setText("Cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        getContentPane().add(cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 140, -1, -1));

        view_all.setBackground(new java.awt.Color(0, 153, 153));
        view_all.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        view_all.setForeground(new java.awt.Color(255, 255, 255));
        view_all.setText("View All");
        view_all.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view_allActionPerformed(evt);
            }
        });
        getContentPane().add(view_all, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 140, -1, -1));

        query.setFont(new java.awt.Font("UD Digi Kyokasho N-R", 1, 18)); // NOI18N
        query.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                queryActionPerformed(evt);
            }
        });
        getContentPane().add(query, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 60, 310, -1));

        back.setBackground(new java.awt.Color(204, 204, 204));
        back.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        getContentPane().add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 10, -1, -1));

        print.setBackground(new java.awt.Color(0, 0, 204));
        print.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        print.setForeground(new java.awt.Color(255, 255, 255));
        print.setText("Print");
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });
        getContentPane().add(print, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, -1, -1));

        search_btn.setBackground(new java.awt.Color(0, 0, 204));
        search_btn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        search_btn.setForeground(new java.awt.Color(255, 255, 255));
        search_btn.setText("Search");
        search_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_btnActionPerformed(evt);
            }
        });
        getContentPane().add(search_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, -1));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Vivaldi", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(32, 163, 103));
        jLabel7.setText("K - Food");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 190, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void view_allActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view_allActionPerformed
//       fetchEmployeeData(null);
    }//GEN-LAST:event_view_allActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
//      if (!tasksStack.isEmpty()) {
//            String lastTask = tasksStack.pop(); // Pop the last task
//            // Perform action associated with the last task
//            switch (lastTask) {
//                case "search":
//                    // Revert the UI or cancel search operation
//                    query.setText(""); // Clear search text field
//                    fetchEmployeeData(null); // Fetch all employee data
//                    break;
//                // Add more cases for other tasks if needed
//            }
//        } else {
//            JOptionPane.showMessageDialog(null, "No task to cancel!");
//        }
    }//GEN-LAST:event_cancelActionPerformed
//private void fetchEmployeeDetails(String empID) {
//    try {
//        // Fetch employee details from the database based on the Emp_ID
//        con = conn.mycon();
//        String query = "SELECT * FROM employee_details WHERE Emp_ID = ?";
//        PreparedStatement pst = con.prepareStatement(query);
//        pst.setString(1, empID);
//        ResultSet rs = pst.executeQuery();
//
//        // Check if the result set is not empty
//        if (rs.next()) {
//            // Open the emp_update_form panel with the details filled
//            emp_update_form updateFormPanel = new emp_update_form(empID); // Pass Emp_ID
//            updateFormPanel.setVisible(true);
//            this.dispose(); // Close the current panel
//        } else {
//            JOptionPane.showMessageDialog(null, "No employee found with Emp_ID: " + empID);
//        }
//    } catch (SQLException e) {
//        JOptionPane.showMessageDialog(null, e);
//    }
//}

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
          this.dispose(); // Terminate the current JFrame
    Employee_Panel employeePanel = new Employee_Panel(); // Create an instance of the Employee_Panel class
    employeePanel.setVisible(true); // Make the Employee_Panel visible
    }//GEN-LAST:event_backActionPerformed

    private void queryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_queryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_queryActionPerformed

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
       printTable();
    }//GEN-LAST:event_printActionPerformed

    private void search_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_btnActionPerformed
//     String searchQuery = query.getText().trim();
//    if (searchQuery.isEmpty()) {
//        // If search query is empty, fetch all employee data
//        fetchEmployeeData(null);
//    } else {
//        // If search query is not empty, perform the search
//        fetchEmployeeData(searchQuery);
//    }
    }//GEN-LAST:event_search_btnActionPerformed

    private void printTable() {
//    try {
//        // Print the table
//        boolean complete = emp.print(JTable.PrintMode.FIT_WIDTH, null, null);
//        if (complete) {
//            JOptionPane.showMessageDialog(null, "Printing Complete", "Printing Result", JOptionPane.INFORMATION_MESSAGE);
//        } else {
//            JOptionPane.showMessageDialog(null, "Printing Cancelled", "Printing Result", JOptionPane.WARNING_MESSAGE);
//        }
//    } catch (PrinterException ex) {
//        JOptionPane.showMessageDialog(null, "Printing Failed: " + ex.getMessage(), "Printing Error", JOptionPane.ERROR_MESSAGE);
//    
//    }

    PrinterJob printerJob = PrinterJob.getPrinterJob();
    printerJob.setJobName("Print Panel");

    printerJob.setPrintable(new Printable() {
        public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) {
            if (pageIndex > 0) {
                return Printable.NO_SUCH_PAGE;
            }

            Graphics2D g2 = (Graphics2D) graphics;
            g2.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

            // Scale the panel content to fit the printable area
            double scaleFactor = pageFormat.getImageableWidth() / getWidth();
            g2.scale(scaleFactor, scaleFactor);

            // Print the panel content
            paint(g2);
            return Printable.PAGE_EXISTS;
        }
    });

    boolean ok = printerJob.printDialog();
    if (ok) {
        try {
            printerJob.print();
        } catch (Exception ex) {
            /* handle exception */
        }
    
}

    } 
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
       try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Emp_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Emp_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Emp_view().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JButton cancel;
    private javax.swing.JTable emp;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton print;
    private javax.swing.JTextField query;
    private javax.swing.JLabel search;
    private javax.swing.JButton search_btn;
    private javax.swing.JButton view_all;
    // End of variables declaration//GEN-END:variables
}
