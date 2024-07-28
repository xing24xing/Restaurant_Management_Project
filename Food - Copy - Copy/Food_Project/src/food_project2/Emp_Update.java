/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package food_project2;



import food_project.emp_update_form;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JOptionPane;
import java.sql.*;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
public class Emp_Update extends javax.swing.JPanel {
JpanelLoader Jload = new JpanelLoader();
    Connection con = null;
   ResultSet rs = null;
   private JPanel child2;
    
   // Add reference to Home frame

    private Emp_Panel empPanel;
   PreparedStatement pst = null;
    public Emp_Update(JPanel child2, Emp_Panel empPanel) {
        initComponents();
        fetchEmployeeData();
        customizeTable();
       this.child2 = child2;
        this.empPanel = empPanel;
        
    }
   public void goToChild2() {
        // Reload the main components of child2
        // You can implement this method according to your JPanel structure
        // For example:
        jPanelLoader(child2, Emp_Pane); // Replace mainChild2Panel with your actual child2 main panel
    }
  public void jPanelLoader(JPanel parent, JPanel child) {
    parent.removeAll();
    parent.add(child);
    parent.revalidate();
    parent.repaint();
}
   private void fetchEmployeeData() {
        try {
            con = food_project2.conn.mycon();
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
        con = food_project2.conn.mycon();
        String query = "SELECT * FROM employee_details WHERE Emp_ID = ?";
        pst = con.prepareStatement(query);
        pst.setString(1, empID);
        rs = pst.executeQuery();

        // Check if the result set is not empty
        if (rs.next()) {
            // Open the Emp_Up_Form panel with the empID
            Emp_Up_Form up= new  Emp_Up_Form(child2,this,empID);
              Jload.jPanelLoader(child2,up); 
        } else {
            JOptionPane.showMessageDialog(null, "No employee found with Emp_ID: " + empID);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e);
    }}

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
        jScrollPane2.setPreferredSize(new Dimension(1400,530));

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
            table.getColumnModel().getColumn(column).setPreferredWidth(100);
            return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Emp_Pane = new javax.swing.JPanel();
        update_btn = new javax.swing.JButton();
        search = new javax.swing.JLabel();
        query = new javax.swing.JTextField();
        back = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        emp = new javax.swing.JTable();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Emp_Pane.setBackground(new java.awt.Color(255, 255, 255));
        Emp_Pane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        update_btn.setBackground(new java.awt.Color(0, 153, 0));
        update_btn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        update_btn.setForeground(new java.awt.Color(255, 255, 255));
        update_btn.setText("Update");
        update_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_btnActionPerformed(evt);
            }
        });
        Emp_Pane.add(update_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, -1, -1));

        search.setFont(new java.awt.Font("Serif", 3, 24)); // NOI18N
        search.setForeground(new java.awt.Color(102, 0, 102));
        search.setText("Search Employee Queries Here :-");
        Emp_Pane.add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, -1, -1));

        query.setFont(new java.awt.Font("UD Digi Kyokasho N-R", 1, 18)); // NOI18N
        query.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                queryActionPerformed(evt);
            }
        });
        Emp_Pane.add(query, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 50, 310, -1));

        back.setBackground(new java.awt.Color(204, 204, 204));
        back.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        Emp_Pane.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 50, -1, -1));

        emp.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        emp.setFont(new java.awt.Font("SimHei", 1, 14)); // NOI18N
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
        jScrollPane2.setViewportView(emp);

        Emp_Pane.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 1180, -1));

        add(Emp_Pane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1490, 820));
    }// </editor-fold>//GEN-END:initComponents

    private void queryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_queryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_queryActionPerformed

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

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to go back?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            // Navigate back to Emp_Panel using the reference
            empPanel.goToChild2();
        }
     
    }//GEN-LAST:event_backActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Emp_Pane;
    private javax.swing.JButton back;
    private javax.swing.JTable emp;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField query;
    private javax.swing.JLabel search;
    private javax.swing.JButton update_btn;
    // End of variables declaration//GEN-END:variables
}
