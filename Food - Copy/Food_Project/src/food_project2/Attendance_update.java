/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package food_project2;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.*;
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
public class Attendance_update extends javax.swing.JPanel {
 Connection con = null;
   ResultSet rs = null;
   PreparedStatement pst = null;
  
    JpanelLoader Jload = new JpanelLoader();
    private JPanel child2;
    private Attend_Panel att;

    public Attendance_update(JPanel child2,Attend_Panel att) {
         initComponents();
        Connection con = food_project2.conn.mycon();
         this.child2 = child2;
          this.att= att;
        fetchEmployeeData();
        customizeTable();
        // Add action listener to table cells
         populateEmpIDs(); 
    }

     private void fetchEmployeeData() {
    try {
         con = food_project2.conn.mycon();
        String query = "SELECT Emp_ID,Name,Shift,Attendance,Date FROM emp_attendance";
         pst = con.prepareStatement(query);
         rs = pst.executeQuery();
        if (admtab != null) {
            admtab.setModel(buildTableModel(rs)); // Display result set in table
        } else {
            System.err.println("Error: JTable emp is null.");
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e);
    }
}
    private void populateEmpIDs() {
    try {
         con = food_project2.conn.mycon();
        String query = "SELECT Emp_ID FROM employee_details";
         pst = con.prepareStatement(query);
         rs = pst.executeQuery();

        emp_id.removeAllItems();
        emp_id.addItem("Select ID");

        while (rs.next()) {
            emp_id.addItem(rs.getString("Emp_ID"));
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e);
    }
} public static DefaultTableModel buildTableModel(ResultSet rs) throws SQLException {
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

  
   public void goBackToChild2() {
        // Reload the main components of child2
        // You can implement this method according to your JPanel structure
        // For example:
        jPanelLoader(child2, emp_attend); // Replace mainChild2Panel with your actual child2 main panel
    }
  public void jPanelLoader(JPanel parent, JPanel child) {
    parent.removeAll();
    parent.add(child);
    parent.revalidate();
    parent.repaint();
    
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        emp_attend = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        admtab = new javax.swing.JTable();
        search1 = new javax.swing.JLabel();
        search = new javax.swing.JLabel();
        search_btn = new javax.swing.JButton();
        emp_id = new javax.swing.JComboBox<>();
        back = new javax.swing.JButton();
        date = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        emp_attend.setBackground(new java.awt.Color(255, 255, 255));
        emp_attend.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        admtab.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
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

        emp_attend.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, -1, -1));

        search1.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        search1.setText("Enter Employee ID:-");
        emp_attend.add(search1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, -1, -1));

        search.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        search.setText("Enter Date:-");
        emp_attend.add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, -1, -1));

        search_btn.setBackground(new java.awt.Color(0, 51, 153));
        search_btn.setFont(new java.awt.Font("Serif", 1, 15)); // NOI18N
        search_btn.setForeground(new java.awt.Color(255, 255, 255));
        search_btn.setText("Search");
        search_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_btnActionPerformed(evt);
            }
        });
        emp_attend.add(search_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 120, 90, 35));

        emp_id.setFont(new java.awt.Font("SimHei", 1, 18)); // NOI18N
        emp_id.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        emp_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emp_idActionPerformed(evt);
            }
        });
        emp_attend.add(emp_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 20, 240, 30));

        back.setBackground(new java.awt.Color(51, 51, 51));
        back.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        back.setForeground(new java.awt.Color(255, 255, 255));
        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        emp_attend.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 50, 90, 40));

        date.setFont(new java.awt.Font("UD Digi Kyokasho N-R", 1, 14)); // NOI18N
        date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateActionPerformed(evt);
            }
        });
        emp_attend.add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 70, 240, 30));

        jLabel3.setFont(new java.awt.Font("Bookman Old Style", 3, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 0));
        jLabel3.setText("UPDATE Attendance Details");
        emp_attend.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 280, -1));

        add(emp_attend, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1380, 1240));
    }// </editor-fold>//GEN-END:initComponents

    private void search_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_btnActionPerformed

     
        String empID = emp_id.getSelectedItem().toString();
//            String empID = id.getText();
            String enteredDate = date.getText();
// Validate the entered date format
            if (!enteredDate.matches("\\d{2}-\\d{2}-\\d{4}")) {
                    JOptionPane.showMessageDialog(null, "Please enter date in the format: dd-mm-yyyy");
                    return;
                }
    try {
            con = food_project2.conn.mycon();
            // Update the SQL query to handle the date format change
            String query = "SELECT * FROM  emp_attendance WHERE Emp_ID = ? AND DATE_FORMAT(date, '%d-%m-%Y') = ?";
            pst = con.prepareStatement(query);
            pst.setString(1, empID);
            pst.setString(2, enteredDate);  //
             rs = pst.executeQuery();

            // Check if a matching record is found
            if (rs.next()) {
                // If a matching record is found, create an instance of Attend_Update_Form
                Attend_Update_Form form = new Attend_Update_Form(child2,this,empID);
                Jload.jPanelLoader(child2, form);
                
            } else {
                JOptionPane.showMessageDialog(this, "No matching record found for the provided Employee ID and Date.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error while searching: " + e.getMessage());
        }
    }//GEN-LAST:event_search_btnActionPerformed

   
    private void emp_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emp_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emp_idActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to go back?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            // Navigate back to Emp_Panel using the reference
            att.goBackToChild2();
        }
    }//GEN-LAST:event_backActionPerformed

    private void dateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable admtab;
    private javax.swing.JButton back;
    private javax.swing.JTextField date;
    private javax.swing.JPanel emp_attend;
    private javax.swing.JComboBox<String> emp_id;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel search;
    private javax.swing.JLabel search1;
    private javax.swing.JButton search_btn;
    // End of variables declaration//GEN-END:variables
}
