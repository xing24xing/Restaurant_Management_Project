/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package food_project2;


import javax.swing.table.DefaultTableModel;
 // Importing DefaultTableCellRenderer
import java.awt.Color;
import java.awt.print.PrinterException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;

import javax.swing.table.DefaultTableCellRenderer;
public class Check_login_logout extends javax.swing.JPanel {

     Connection con = null;
   ResultSet rs = null;
   PreparedStatement ps = null;
   JpanelLoader Jload = new JpanelLoader();
    private final JPanel child2;
    private Admin_Dashboard dash;
    public Check_login_logout(JPanel child2, Admin_Dashboard dash) {
        initComponents();
        this.child2 = child2;
        this.dash = dash;
        con = food_project2.conn.mycon();
         fetchEmployeeData();
        setTableAppearance();
        check_in_out.setEnabled(false);
    
    }

   private void fetchEmployeeData() {
    try {
        Connection con = conn.mycon();
        String query = "SELECT * FROM admin_logs";
        PreparedStatement pst = con.prepareStatement(query);
        ResultSet rs = pst.executeQuery();
        if (check_in_out != null) {
            check_in_out.setModel(buildTableModel(rs)); // Display result set in table
        } else {
            System.err.println("Error: JTable emp is null.");
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
public void goBackToChild2() {
        // Reload the main components of child2
        // You can implement this method according to your JPanel structure
        // For example:
        jPanelLoader(child2, time); // Replace mainChild2Panel with your actual child2 main panel
    }
  public void jPanelLoader(JPanel parent, JPanel child) {
    parent.removeAll();
    parent.add(child);
    parent.revalidate();
    parent.repaint();
}
    private void setTableAppearance() {
    // Setting table header color
    check_in_out.getTableHeader().setBackground(new Color(0, 102, 204));
    // Setting header text color
    check_in_out.getTableHeader().setForeground(Color.BLUE);
    // Setting header font
    check_in_out.getTableHeader().setFont(new java.awt.Font("Rockwell Nova", java.awt.Font.BOLD, 13));
    // Center-align header text
    ((DefaultTableCellRenderer)check_in_out.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

    // Setting data alignment for each column
    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
    centerRenderer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

    // Apply alignment to each column
    for (int i = 0; i < check_in_out.getColumnCount(); i++) {
        check_in_out.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
    }
}

private void fetchEmployeeData(String searchQuery) {
    try {
        con = conn.mycon();
        String query;
        PreparedStatement pst;

        if (searchQuery == null || searchQuery.isEmpty()) {
            // If search query is empty or null, fetch all employee data
            query = "SELECT * FROM admin_logs";
            pst = con.prepareStatement(query);
        } else {
            // If search query is not empty, search for matches in column data
            query = "SELECT * FROM admin_logs WHERE id LIKE ? OR login_time LIKE ?";
            pst = con.prepareStatement(query);

            // Set parameters for each column data search
            for (int i = 1; i <= 2; i++) {
                pst.setString(i, "%" + searchQuery + "%");
            }
        }

        ResultSet rs = pst.executeQuery();
        check_in_out.setModel(buildTableModel(rs)); // Display result set in table
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e);
    }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        time = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        check_in_out = new javax.swing.JTable();
        search_btn = new javax.swing.JButton();
        print = new javax.swing.JButton();
        view_all = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        search = new javax.swing.JLabel();
        query = new javax.swing.JTextField();
        back = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        time.setBackground(new java.awt.Color(255, 255, 255));
        time.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        check_in_out.setBackground(new java.awt.Color(204, 204, 204));
        check_in_out.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        check_in_out.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(check_in_out);

        time.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 1070, 480));

        search_btn.setBackground(new java.awt.Color(0, 0, 204));
        search_btn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        search_btn.setForeground(new java.awt.Color(255, 255, 255));
        search_btn.setText("Search");
        search_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_btnActionPerformed(evt);
            }
        });
        time.add(search_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, -1, -1));

        print.setBackground(new java.awt.Color(0, 0, 204));
        print.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        print.setForeground(new java.awt.Color(255, 255, 255));
        print.setText("Print");
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });
        time.add(print, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, -1, -1));

        view_all.setBackground(new java.awt.Color(0, 153, 153));
        view_all.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        view_all.setForeground(new java.awt.Color(255, 255, 255));
        view_all.setText("View All");
        view_all.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view_allActionPerformed(evt);
            }
        });
        time.add(view_all, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, -1, -1));

        cancel.setBackground(new java.awt.Color(255, 0, 0));
        cancel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        cancel.setForeground(new java.awt.Color(255, 255, 255));
        cancel.setText("Cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        time.add(cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 110, -1, -1));

        search.setFont(new java.awt.Font("Serif", 3, 24)); // NOI18N
        search.setForeground(new java.awt.Color(255, 0, 102));
        search.setText("Search By Employee Queries Here :-");
        time.add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, -1, -1));

        query.setFont(new java.awt.Font("UD Digi Kyokasho N-R", 1, 18)); // NOI18N
        query.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                queryActionPerformed(evt);
            }
        });
        time.add(query, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 50, 310, -1));

        back.setBackground(new java.awt.Color(51, 51, 51));
        back.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        back.setForeground(new java.awt.Color(255, 255, 255));
        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        time.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 50, 90, 40));

        add(time, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 720));
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
         try {
             printTable();
         } catch (PrinterException ex) {
             Logger.getLogger(Check_login_logout.class.getName()).log(Level.SEVERE, null, ex);
         }
    }//GEN-LAST:event_printActionPerformed
    private void printTable() throws PrinterException {
        // Print the table
        boolean complete = check_in_out.print(JTable.PrintMode.FIT_WIDTH, null, null);
        if (complete) {
            JOptionPane.showMessageDialog(null, "Printing Complete", "Printing Result", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Printing Cancelled", "Printing Result", JOptionPane.WARNING_MESSAGE);
        }
    }
    private void view_allActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view_allActionPerformed
        fetchEmployeeData(null);
    }//GEN-LAST:event_view_allActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        
    }//GEN-LAST:event_cancelActionPerformed

    private void queryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_queryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_queryActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to go back?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            // Navigate back to Emp_Panel using the reference
            dash.goToChild2();
        }
    }//GEN-LAST:event_backActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JButton cancel;
    private javax.swing.JTable check_in_out;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton print;
    private javax.swing.JTextField query;
    private javax.swing.JLabel search;
    private javax.swing.JButton search_btn;
    private javax.swing.JPanel time;
    private javax.swing.JButton view_all;
    // End of variables declaration//GEN-END:variables
}
