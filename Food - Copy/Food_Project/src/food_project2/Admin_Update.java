/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package food_project2;

import static food_project2.Admin_View.buildTableModel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author khushi pandey
 */
public class Admin_Update extends javax.swing.JPanel {
 
     Connection con = null;
   ResultSet rs = null;
   PreparedStatement pst = null;
  
    JpanelLoader Jload = new JpanelLoader();
    private final JPanel child2;
    
    private Admin_Dashboard dash; // Add reference to Home frame
    public Admin_Update(JPanel child2, Admin_Dashboard dash) {
        initComponents();
        this.child2 = child2;
        this.dash = dash;
        fetchEmployeeData();
        customizeTable();
    }

   private void fetchEmployeeData() {
    try {
            Connection con = food_project2.conn.mycon();
            String query = "SELECT ID, firstName, lastName, email_ID, username, status FROM admin";
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
   public void goBackToChild2() {
        // Reload the main components of child2
        // You can implement this method according to your JPanel structure
        // For example:
        jPanelLoader(child2, upd); // Replace mainChild2Panel with your actual child2 main panel
    }
  public void jPanelLoader(JPanel parent, JPanel child) {
    parent.removeAll();
    parent.add(child);
    parent.revalidate();
    parent.repaint();
}
   private void fetchEmployeeData(String ID) {
    try {
        con = food_project2.conn.mycon();
        String query = "SELECT ID, firstName, lastName, email_ID, username, status FROM admin WHERE ID = ?";
        pst = con.prepareStatement(query);
        pst.setString(1, ID);
        rs = pst.executeQuery();

        // Check if the result set is not empty
        if (rs.next()) {
            String status = rs.getString("status");
            if ("Deactivate".equalsIgnoreCase(status)) {
                JOptionPane.showMessageDialog(this, "Employee is deactivated and cannot be updated.");
            } else if ("Active".equalsIgnoreCase(status)) {
                // Open the Admin_update_form panel with the empID
                Admin_update_form up = new Admin_update_form(child2, this, ID);
                Jload.jPanelLoader(child2, up);
            } else {
                JOptionPane.showMessageDialog(this, "Employee status is not recognized.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No employee found with ID: " + ID);
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
    admtab.setDefaultRenderer(Object.class, new CustomTableCellRenderer());
    admtab.setRowHeight(40); // Increase row height
    admtab.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15)); // Increase header font size
    admtab.getTableHeader().setBackground(new Color(204, 0, 204)); // Set header background color
    admtab.getTableHeader().setForeground(Color.BLACK); // Set header text color
    admtab.getTableHeader().setPreferredSize(new Dimension(100, 50)); // Set header height

    // Center-align table headers
    ((DefaultTableCellRenderer) admtab.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);

    // Set the size of the JScrollPane containing the table
    jScrollPane2.setPreferredSize(new Dimension(1200, 450));

    // Get the column count from the table model
    int columnCount = admtab.getModel().getColumnCount();

    // Adjust preferred widths for specific columns
    if (columnCount > 0) {
        admtab.getColumnModel().getColumn(0).setPreferredWidth(100); // Adjusted for the 1st column
    }
    if (columnCount > 1) {
        admtab.getColumnModel().getColumn(1).setPreferredWidth(200); // Adjusted for the 2nd column
    }
    if (columnCount > 2) {
        admtab.getColumnModel().getColumn(2).setPreferredWidth(200); // Adjusted for the 3rd column
    }
    if (columnCount > 3) {
        admtab.getColumnModel().getColumn(3).setPreferredWidth(200); // Adjusted for the 4th column
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

        upd = new javax.swing.JPanel();
        update_btn = new javax.swing.JButton();
        search = new javax.swing.JLabel();
        query = new javax.swing.JTextField();
        back = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        admtab = new javax.swing.JTable();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        upd.setBackground(new java.awt.Color(255, 255, 255));
        upd.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        update_btn.setBackground(new java.awt.Color(0, 153, 0));
        update_btn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        update_btn.setForeground(new java.awt.Color(255, 255, 255));
        update_btn.setText("Update");
        update_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_btnActionPerformed(evt);
            }
        });
        upd.add(update_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 110, 40));

        search.setFont(new java.awt.Font("Serif", 3, 24)); // NOI18N
        search.setForeground(new java.awt.Color(102, 0, 102));
        search.setText("Search Admin Queries Here :-");
        upd.add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, -1, -1));

        query.setFont(new java.awt.Font("UD Digi Kyokasho N-R", 1, 18)); // NOI18N
        query.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                queryActionPerformed(evt);
            }
        });
        upd.add(query, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 50, 310, -1));

        back.setBackground(new java.awt.Color(51, 51, 51));
        back.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        back.setForeground(new java.awt.Color(255, 255, 255));
        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        upd.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 50, 90, 40));

        admtab.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        admtab.setFont(new java.awt.Font("SimHei", 1, 14)); // NOI18N
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
        jScrollPane2.setViewportView(admtab);

        upd.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 1180, -1));

        add(upd, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1500, 820));
    }// </editor-fold>//GEN-END:initComponents

    private void update_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_btnActionPerformed
        // Get the ID entered in the JTextField
    String ID = query.getText().trim();

    // Check if the ID is not empty
    if (!ID.isEmpty()) {
        // Fetch details related to the entered ID
        fetchEmployeeData(ID);
    } else {
        // Show a message if no ID is entered
        JOptionPane.showMessageDialog(this, "Please enter an ID.");
    }
    }//GEN-LAST:event_update_btnActionPerformed

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
    private javax.swing.JTable admtab;
    private javax.swing.JButton back;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField query;
    private javax.swing.JLabel search;
    private javax.swing.JPanel upd;
    private javax.swing.JButton update_btn;
    // End of variables declaration//GEN-END:variables
}
