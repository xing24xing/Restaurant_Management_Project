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
public class Profit_Company extends javax.swing.JPanel {
 Connection con = null;
   ResultSet rs = null;
   PreparedStatement pst = null;
   private Home homeFrame; 
    JpanelLoader Jload = new JpanelLoader();
    private final JPanel child2;
    public Profit_Company(JPanel child2,Home  homeFrame) {
        initComponents();
       this.child2 = child2;
        this.homeFrame = homeFrame; 
        profit_tab.setEnabled(false);
        con = food_project2.conn.mycon();       
        fetchDataFromOrderDetails();
        customizeTable();
    }
 private void fetchDataFromOrderDetails() {
        try {
            String query = "SELECT * FROM order_items";
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            DefaultTableModel model = new DefaultTableModel();
            profit_tab.setModel(model);

            ResultSetMetaData meta = rs.getMetaData();
            int colCount = meta.getColumnCount();
            String[] cols = new String[colCount];
            for (int i = 1; i <= colCount; i++) {
                cols[i - 1] = meta.getColumnName(i);
            }
            model.setColumnIdentifiers(cols);

            while (rs.next()) {
                Object[] rowData = new Object[colCount];
                for (int i = 1; i <= colCount; i++) {
                    rowData[i - 1] = rs.getObject(i);
                }
                model.addRow(rowData);
            }

            // Debug statement to confirm data fetch
            System.out.println("Data fetched successfully. Rows count: " + model.getRowCount());

        } catch (SQLException e) {
            // Improved error handling
            JOptionPane.showMessageDialog(null, "Error fetching data: " + e.getMessage());
            e.printStackTrace();
        }
    }
private void customizeTable() {
    profit_tab.setDefaultRenderer(Object.class, new CustomTableCellRenderer());
    profit_tab.setRowHeight(40); // Increase row height
    profit_tab.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15)); // Increase header font size
    profit_tab.getTableHeader().setBackground(new Color(204, 0, 204)); // Set header background color
    profit_tab.getTableHeader().setForeground(Color.BLACK); // Set header text color
    profit_tab.getTableHeader().setPreferredSize(new Dimension(100, 50)); // Set header height

    // Center-align table headers
    ((DefaultTableCellRenderer) profit_tab.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
}
class CustomTableCellRenderer extends DefaultTableCellRenderer {
    @Override
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
private void calculateTotalNetValue() {
        DefaultTableModel model = (DefaultTableModel) profit_tab.getModel();
    int netValueColumnIndex = -1;
    double totalNetValue = 0.0;
    
    // Find the index of the net_value column
    for (int i = 0; i < model.getColumnCount(); i++) {
        if ("net_value".equalsIgnoreCase(model.getColumnName(i))) {
            netValueColumnIndex = i;
            break;
        }
    }
    
    if (netValueColumnIndex == -1) {
        JOptionPane.showMessageDialog(null, "net_value column not found.");
        return;
    }
    
    // Calculate the total net value
    for (int i = 0; i < model.getRowCount(); i++) {
        Object value = model.getValueAt(i, netValueColumnIndex);
        if (value != null) {
            totalNetValue += Double.parseDouble(value.toString());
        }
    }
    
    // Set the total net value in the net_profit label
    net_profit.setText("Total Net Value: " + totalNetValue);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        profit_tab = new javax.swing.JTable();
        cal = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        date = new javax.swing.JTextField();
        net_profit = new javax.swing.JLabel();
        search = new javax.swing.JButton();
        View_All = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        profit_tab.setBackground(new java.awt.Color(204, 204, 204));
        profit_tab.setFont(new java.awt.Font("UD Digi Kyokasho N-R", 0, 16)); // NOI18N
        profit_tab.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(profit_tab);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 1100, 500));

        cal.setBackground(new java.awt.Color(255, 0, 0));
        cal.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        cal.setForeground(new java.awt.Color(255, 255, 255));
        cal.setText("Calculate Total Profit");
        cal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calActionPerformed(evt);
            }
        });
        jPanel1.add(cal, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, -1, 40));

        jLabel1.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel1.setText(" Enter Date To Know Profit (Eg dd-mm-yy) : ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, -1, -1));

        date.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jPanel1.add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 10, 220, 40));

        net_profit.setFont(new java.awt.Font("Sitka Text", 0, 18)); // NOI18N
        jPanel1.add(net_profit, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, 250, 30));

        search.setBackground(new java.awt.Color(0, 0, 204));
        search.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        search.setForeground(new java.awt.Color(255, 255, 255));
        search.setText("Search");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        jPanel1.add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 10, 140, 40));

        View_All.setBackground(new java.awt.Color(0, 204, 51));
        View_All.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        View_All.setForeground(new java.awt.Color(255, 255, 255));
        View_All.setText("View All");
        View_All.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                View_AllActionPerformed(evt);
            }
        });
        jPanel1.add(View_All, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 10, 140, 40));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1390, 890));
    }// </editor-fold>//GEN-END:initComponents

    private void calActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calActionPerformed
       calculateTotalNetValue();
    }//GEN-LAST:event_calActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
     // Retrieve the date entered by the user
    String enteredDate = date.getText();
    
    // Check if the entered date follows the required format (dd-mm-yy)
    if (!enteredDate.matches("\\d{2}-\\d{2}-\\d{4}")) {
        JOptionPane.showMessageDialog(null, "Please enter date in the format: dd-mm-yyyy");
        return;
    }
    
    // Query the database to fetch rows matching the entered date
    try {
        // Update the SQL query to handle the date format change
        String query = "SELECT * FROM order_items WHERE DATE_FORMAT(date, '%d-%m-%Y') = ?";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1, enteredDate);
        ResultSet rs = pst.executeQuery();
        
        DefaultTableModel model = (DefaultTableModel) profit_tab.getModel();
        model.setRowCount(0); // Clear the existing table
        
        // Populate the table with the filtered rows
        while (rs.next()) {
            Object[] rowData = new Object[model.getColumnCount()];
            for (int i = 0; i < model.getColumnCount(); i++) {
                rowData[i] = rs.getObject(i + 1);
            }
            model.addRow(rowData);
        }
          
        // Calculate and display the total net value
       
        
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error fetching data: " + e.getMessage());
        e.printStackTrace();
    }
    }//GEN-LAST:event_searchActionPerformed

    private void View_AllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_View_AllActionPerformed
        try {
        // Query to fetch all rows from the order_items table
        String query = "SELECT * FROM order_items";
         pst = con.prepareStatement(query);
         rs = pst.executeQuery();

        DefaultTableModel model = (DefaultTableModel) profit_tab.getModel();
        model.setRowCount(0); // Clear existing rows

        // Populate the table with all rows from the database
        while (rs.next()) {
            Object[] rowData = new Object[model.getColumnCount()];
            for (int i = 0; i < model.getColumnCount(); i++) {
                rowData[i] = rs.getObject(i + 1);
            }
            model.addRow(rowData);
        }

        // Calculate and display the total net value
      

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error fetching data: " + e.getMessage());
        e.printStackTrace();
    }
    }//GEN-LAST:event_View_AllActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton View_All;
    private javax.swing.JButton cal;
    private javax.swing.JTextField date;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel net_profit;
    private javax.swing.JTable profit_tab;
    private javax.swing.JButton search;
    // End of variables declaration//GEN-END:variables
}
