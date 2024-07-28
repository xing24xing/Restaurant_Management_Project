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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
/**
 *
 * @author khushi pandey
 */
public class Attend_view extends javax.swing.JPanel {

       javax.swing.JFrame parentFrame;
    Stack<String> tasksStack;    
   Connection con = null;
   ResultSet rs = null;
   PreparedStatement ps = null;
   private Attend_Panel  att;
   private  JPanel child2;
    public Attend_view(JPanel child2,Attend_Panel att) {
         initComponents(); // Initialize components
    con = food_project2.conn.mycon();
     this.att = att;
     this.child2 = child2;
    customizeTable();
    this.parentFrame = parentFrame;
    tasksStack = new Stack<>(); // Initialize the stack

    fetchEmployeeData();
    }
  private void fetchEmployeeData() {
    try {
        Connection con = food_project2.conn.mycon();
        String query = "SELECT * FROM emp_attendance";
        PreparedStatement pst = con.prepareStatement(query);
        ResultSet rs = pst.executeQuery();
        if (emp_attend != null) {
            emp_attend.setModel(buildTableModel(rs)); // Display result set in table
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
                query = "SELECT * FROM emp_attendance";
                pst = con.prepareStatement(query);
            } else {
                // If search query is not empty, search for matches in column data only
                query = "SELECT * FROM emp_attendance WHERE Emp_ID LIKE ? OR Name LIKE ? OR Shift LIKE ? OR Attendance LIKE ? OR Date LIKE ?";
                pst = con.prepareStatement(query);

                // Set parameters for each column data search
                for (int i = 1; i <= 5; i++) {
                    pst.setString(i, "%" + searchQuery + "%");
                }
            }

            ResultSet rs = pst.executeQuery();
            emp_attend.setModel(buildTableModel(rs)); // Display result set in table
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }


public void goBackToChild2() {
        // Reload the main components of child2
        // You can implement this method according to your JPanel structure
        // For example:
        jPanelLoader(child2, view); // Replace mainChild2Panel with your actual child2 main panel
    }
  public void jPanelLoader(JPanel parent, JPanel child) {
    parent.removeAll();
    parent.add(child);
    parent.revalidate();
    parent.repaint();
}
  
   public static DefaultTableModel buildTableModel(ResultSet rs) throws SQLException {
        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();
        String[] columnNames = new String[columnCount];
        for (int column = 1; column <= columnCount; column++) {
            columnNames[column - 1] = metaData.getColumnName(column);
        }

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

    private static Object[][] addRow(Object[][] original, Object[] newRow, int rowCount) {
        Object[][] result = new Object[rowCount + 1][];
        System.arraycopy(original, 0, result, 0, rowCount);
        result[rowCount] = newRow;
        return result;
    }

    private void customizeTable() {
        emp_attend.setDefaultRenderer(Object.class, new CustomTableCellRenderer());

        JTableHeader header = emp_attend.getTableHeader();
        header.setFont(new Font("Segoe UI", Font.BOLD, 15));
        header.setBackground(new Color(204, 0, 204));
        header.setForeground(Color.BLUE);
        header.setDefaultRenderer(new HeaderRenderer(header.getDefaultRenderer()));

        emp_attend.setRowHeight(40);

        int[] columnWidths = {250, 300, 150, 300};
        for (int i = 0; i < Math.min(columnWidths.length, emp_attend.getColumnCount()); i++) {
            emp_attend.getColumnModel().getColumn(i).setPreferredWidth(columnWidths[i]);
        }

        jScrollPane1.setPreferredSize(new Dimension(1260, 570));
        emp_attend.setDefaultEditor(Object.class, null);
    }

    class HeaderRenderer implements javax.swing.table.TableCellRenderer {
        private final javax.swing.table.TableCellRenderer delegate;

        public HeaderRenderer(javax.swing.table.TableCellRenderer delegate) {
            this.delegate = delegate;
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component comp = delegate.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (comp instanceof JLabel) {
                ((JLabel) comp).setHorizontalAlignment(JLabel.CENTER);
            }
            return comp;
        }
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

        view = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        emp_attend = new javax.swing.JTable();
        search_btn = new javax.swing.JButton();
        search = new javax.swing.JLabel();
        query = new javax.swing.JTextField();
        print = new javax.swing.JButton();
        view_all = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        Back = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        view.setBackground(new java.awt.Color(255, 255, 255));
        view.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        emp_attend.setFont(new java.awt.Font("SimSun-ExtB", 1, 14)); // NOI18N
        emp_attend.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(emp_attend);

        view.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, 430));

        search_btn.setBackground(new java.awt.Color(0, 0, 204));
        search_btn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        search_btn.setForeground(new java.awt.Color(255, 255, 255));
        search_btn.setText("Search");
        search_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_btnActionPerformed(evt);
            }
        });
        view.add(search_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        search.setFont(new java.awt.Font("Serif", 3, 24)); // NOI18N
        search.setForeground(new java.awt.Color(153, 0, 0));
        search.setText("Search By Employee Queries Here :-");
        view.add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 50, -1, -1));

        query.setFont(new java.awt.Font("UD Digi Kyokasho N-R", 1, 18)); // NOI18N
        query.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                queryActionPerformed(evt);
            }
        });
        view.add(query, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 50, 310, 30));

        print.setBackground(new java.awt.Color(0, 0, 204));
        print.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        print.setForeground(new java.awt.Color(255, 255, 255));
        print.setText("Print");
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });
        view.add(print, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, -1, -1));

        view_all.setBackground(new java.awt.Color(0, 153, 153));
        view_all.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        view_all.setForeground(new java.awt.Color(255, 255, 255));
        view_all.setText("View All");
        view_all.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view_allActionPerformed(evt);
            }
        });
        view.add(view_all, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 120, -1, -1));

        cancel.setBackground(new java.awt.Color(255, 0, 0));
        cancel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        cancel.setForeground(new java.awt.Color(255, 255, 255));
        cancel.setText("Cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        view.add(cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 120, -1, -1));

        Back.setBackground(new java.awt.Color(51, 51, 51));
        Back.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        Back.setForeground(new java.awt.Color(255, 255, 255));
        Back.setText("Back");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });
        view.add(Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 50, 100, 40));

        add(view, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1400, 810));
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

    private void queryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_queryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_queryActionPerformed

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
        printTable();
    }//GEN-LAST:event_printActionPerformed

    private void view_allActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view_allActionPerformed
        fetchEmployeeData(null);
    }//GEN-LAST:event_view_allActionPerformed
    private void printTable() {
    try {
        // Print the table
        boolean complete = emp_attend.print(JTable.PrintMode.FIT_WIDTH, null, null);
        if (complete) {
            JOptionPane.showMessageDialog(null, "Printing Complete", "Printing Result", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Printing Cancelled", "Printing Result", JOptionPane.WARNING_MESSAGE);
        }
    } catch (PrinterException ex) {
        JOptionPane.showMessageDialog(null, "Printing Failed: " + ex.getMessage(), "Printing Error", JOptionPane.ERROR_MESSAGE);
    
    }}
    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
//        if (!tasksStack.isEmpty()) {
   
//            String lastTask = tasksStack.pop(); // Pop the last task
//            // Perform action associated with the last task
//            switch (lastTask) {
//                case "search":
//                // Revert the UI or cancel search operation
//                query.setText(""); // Clear search text field
//                fetchEmployeeData(null); // Fetch all employee data
//                break;
//                // Add more cases for other tasks if needed
//            }
//        } else {
//            JOptionPane.showMessageDialog(null, "No task to cancel!");
//        }
 

    }//GEN-LAST:event_cancelActionPerformed

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to go back?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            // Navigate back to Emp_Panel using the reference
            att.goBackToChild2();
        }
    }//GEN-LAST:event_BackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JButton cancel;
    private javax.swing.JTable emp_attend;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton print;
    private javax.swing.JTextField query;
    private javax.swing.JLabel search;
    private javax.swing.JButton search_btn;
    private javax.swing.JPanel view;
    private javax.swing.JButton view_all;
    // End of variables declaration//GEN-END:variables
}
