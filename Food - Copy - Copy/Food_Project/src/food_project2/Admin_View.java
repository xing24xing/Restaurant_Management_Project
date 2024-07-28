/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package food_project2;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.print.PrinterException;
import java.sql.*;
import java.util.Stack;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
public class Admin_View extends javax.swing.JPanel {

    Connection con = null;
   ResultSet rs = null;
   PreparedStatement ps = null;
   private Admin_Dashboard dash;
   private JPanel child2;
    public Admin_View(JPanel child2, Admin_Dashboard dash) {
         initComponents(); // Initialize components
    con = food_project2.conn.mycon();
    this.child2 = child2;
    this.dash = dash;
    customizeTable();
    fetchEmployeeData();
    }
 private void fetchEmployeeData() {
    try {
        Connection con = food_project2.conn.mycon();
        String query = "SELECT ID,firstName,lastName,email_ID ,username,status FROM admin";
        PreparedStatement pst = con.prepareStatement(query);
        ResultSet rs = pst.executeQuery();
        if (admtab != null) {
            admtab.setModel(buildTableModel(rs)); // Display result set in table
        } else {
            System.err.println("Error: JTable emp is null.");
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e);
    }
}
   private void fetchEmployeeData(String searchQuery) {
     try {
         
        Connection con = food_project2.conn.mycon();
        String query;
        PreparedStatement pst;

        if (searchQuery == null || searchQuery.isEmpty()) {
            // If search query is empty or null, fetch all employee data
            query = "SELECT ID,firstName,lastName,email_ID,username,status FROM admin";
            pst = con.prepareStatement(query);
        } else {
            // If search query is not empty, search for matches in all columns
            query = "SELECT ID,firstName,lastName,email_ID,username,status FROM admin WHERE CONCAT(ID, firstName, lastName, email_ID, username, status) LIKE ?";
            pst = con.prepareStatement(query);

            // Set parameter for the search query
            pst.setString(1, "%" + searchQuery + "%");
        }

        ResultSet rs = pst.executeQuery();
        admtab.setModel(buildTableModel(rs)); // Display result set in table
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
    admtab.setDefaultRenderer(Object.class, new CustomTableCellRenderer());
    admtab.setRowHeight(40); // Increase row height
    admtab.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15)); // Increase header font size
    admtab.getTableHeader().setBackground(new Color(204, 0, 204)); // Set header background color
    admtab.getTableHeader().setForeground(Color.BLACK); // Set header text color
    admtab.getTableHeader().setPreferredSize(new Dimension(100, 50)); // Set header height

    // Center-align table headers
    ((DefaultTableCellRenderer) admtab.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);

    // Set the size of the JScrollPane containing the table
    jScrollPane1.setPreferredSize(new Dimension(1200, 450));

    // Get the column count from the table model
    int columnCount = admtab.getModel().getColumnCount();

    // Adjust preferred widths for specific columns
    if (columnCount > 0) {
        admtab.getColumnModel().getColumn(0).setPreferredWidth(250); // Adjusted for the 1st column
    }
    if (columnCount > 1) {
        admtab.getColumnModel().getColumn(1).setPreferredWidth(300); // Adjusted for the 2nd column
    }
    if (columnCount > 2) {
        admtab.getColumnModel().getColumn(2).setPreferredWidth(150); // Adjusted for the 3rd column
    }
    if (columnCount > 3) {
        admtab.getColumnModel().getColumn(3).setPreferredWidth(300); // Adjusted for the 4th column
    }

    // Make the table non-editable
    admtab.setDefaultEditor(Object.class, null);
}


 class CustomTableCellRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // Set padding for cell data
        setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setHorizontalAlignment(CENTER);
//        setFont(new Font("Verdana", Font.BOLD, 14)); // Set custom font
        setHorizontalAlignment(CENTER);

        // Center alignment for all cell content
        ((JLabel) cellComponent).setHorizontalAlignment(JLabel.CENTER);

        // Set foreground color based on status
        if (column == 5) { // Assuming the status column is the 6th column (index 5)
            String status = (String) value;
            if ("active".equalsIgnoreCase(status)) {
                cellComponent.setForeground(Color.GREEN);
            } else if ("inactive".equalsIgnoreCase(status)) {
                cellComponent.setForeground(Color.RED);
            } else {
                cellComponent.setForeground(Color.BLACK);
            }
        } else {
            cellComponent.setForeground(Color.BLACK); // Default text color
        }

        return cellComponent;
    }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        view = new javax.swing.JPanel();
        search = new javax.swing.JLabel();
        query = new javax.swing.JTextField();
        search_btn = new javax.swing.JButton();
        print = new javax.swing.JButton();
        view_all = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        admtab = new javax.swing.JTable();
        back = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        view.setBackground(new java.awt.Color(255, 255, 255));
        view.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        search.setFont(new java.awt.Font("Segoe UI Semibold", 3, 24)); // NOI18N
        search.setForeground(new java.awt.Color(153, 0, 0));
        search.setText("Search By Employee Queries Here :-");
        view.add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, -1, -1));

        query.setFont(new java.awt.Font("UD Digi Kyokasho N-R", 1, 18)); // NOI18N
        query.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                queryActionPerformed(evt);
            }
        });
        view.add(query, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 50, 310, -1));

        search_btn.setBackground(new java.awt.Color(0, 0, 204));
        search_btn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        search_btn.setForeground(new java.awt.Color(255, 255, 255));
        search_btn.setText("Search");
        search_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_btnActionPerformed(evt);
            }
        });
        view.add(search_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, -1));

        print.setBackground(new java.awt.Color(0, 0, 204));
        print.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        print.setForeground(new java.awt.Color(255, 255, 255));
        print.setText("Print");
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });
        view.add(print, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, -1, -1));

        view_all.setBackground(new java.awt.Color(0, 153, 153));
        view_all.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        view_all.setForeground(new java.awt.Color(255, 255, 255));
        view_all.setText("View All");
        view_all.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view_allActionPerformed(evt);
            }
        });
        view.add(view_all, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 140, -1, -1));

        cancel.setBackground(new java.awt.Color(255, 0, 0));
        cancel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        cancel.setForeground(new java.awt.Color(255, 255, 255));
        cancel.setText("Cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        view.add(cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 140, -1, -1));

        admtab.setFont(new java.awt.Font("SimHei", 1, 14)); // NOI18N
        admtab.setForeground(new java.awt.Color(153, 0, 153));
        admtab.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(admtab);

        view.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, 410));

        back.setBackground(new java.awt.Color(51, 51, 51));
        back.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        back.setForeground(new java.awt.Color(255, 255, 255));
        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        view.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 50, 90, 40));

        add(view, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1610, 800));
    }// </editor-fold>//GEN-END:initComponents

    private void queryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_queryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_queryActionPerformed

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

    private void view_allActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view_allActionPerformed
        fetchEmployeeData(null);
    }//GEN-LAST:event_view_allActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        
    }//GEN-LAST:event_cancelActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to go back?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            // Navigate back to Emp_Panel using the reference
            dash.goToChild2();
        }
    }//GEN-LAST:event_backActionPerformed
private void printTable() {
    try {
        // Print the table
        boolean complete = admtab.print(JTable.PrintMode.FIT_WIDTH, null, null);
        if (complete) {
            JOptionPane.showMessageDialog(null, "Printing Complete", "Printing Result", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Printing Cancelled", "Printing Result", JOptionPane.WARNING_MESSAGE);
        }
    } catch (PrinterException ex) {
        JOptionPane.showMessageDialog(null, "Printing Failed: " + ex.getMessage(), "Printing Error", JOptionPane.ERROR_MESSAGE);
    
    }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable admtab;
    private javax.swing.JButton back;
    private javax.swing.JButton cancel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton print;
    private javax.swing.JTextField query;
    private javax.swing.JLabel search;
    private javax.swing.JButton search_btn;
    private javax.swing.JPanel view;
    private javax.swing.JButton view_all;
    // End of variables declaration//GEN-END:variables
}
