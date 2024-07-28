/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package food_project;

import food_project2.conn;
import food_project2.Home;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author khushi pandey
 */
public class Emp_Search extends javax.swing.JFrame {

     // Declare JComboBox 
    private String selectedColumn; // Declare selectedColumn variable to store the selected column name
    public Emp_Search() {
        initComponents();
         fetchAttendanceData();
         customizeTable();
         this.setExtendedState(Home.MAXIMIZED_BOTH);
          selectedColumn = ""; // Initialize selectedColumn
          
    }
    

   private void fetchAttendanceData() {
        try {
            Connection con = conn.mycon();
            String query = "SELECT * FROM emp_attendance";
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            Emp_data.setModel(buildTableModel(rs));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

   private void fetchEmployeeData(String searchQuery) {
    try {
        Connection con = conn.mycon();
        
        // Build the SQL query dynamically based on the selected column
        String query = "SELECT * FROM emp_attendance";
        if (!selectedColumn.isEmpty()) {
            query += " WHERE " + selectedColumn + " LIKE ?";
        }
        
        PreparedStatement pst = con.prepareStatement(query);
        if (!selectedColumn.isEmpty()) {
            pst.setString(1, "%" + searchQuery + "%");
        }
        
        ResultSet rs = pst.executeQuery();
        DefaultTableModel model = buildTableModel(rs);
        Emp_data.setModel(model);

        // Check if the result set is empty
        if (!rs.isBeforeFirst()) {
            JOptionPane.showMessageDialog(this, "No results found.", "No Results", JOptionPane.INFORMATION_MESSAGE);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e);
    }
}

// Add this method to set the selected column
public void setSelectedColumn(String selectedColumn) {
    this.selectedColumn = selectedColumn;
}

    public static DefaultTableModel buildTableModel(ResultSet rs) throws SQLException {
        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();
        String[] columnNames = new String[columnCount];
        for (int column = 1; column <= columnCount; column++) {
            columnNames[column - 1] = metaData.getColumnName(column);
        }
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        while (rs.next()) {
            Object[] row = new Object[columnCount];
            for (int i = 0; i < columnCount; i++) {
                row[i] = rs.getObject(i + 1);
            }
            model.addRow(row);
        }
        return model;
    }

    class CustomTableCellRenderer extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
            ((JLabel) cellComponent).setHorizontalAlignment(JLabel.CENTER);
            return cellComponent;
        }
    }

    private void customizeTable() {
    Emp_data.setDefaultRenderer(Object.class, new CustomTableCellRenderer());
    Emp_data.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 19));
    Emp_data.getTableHeader().setForeground(new Color(0, 128, 0));
    ((DefaultTableCellRenderer) Emp_data.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
    Emp_data.setEnabled(false); // Disable table editing
    jScrollPane1.setPreferredSize(new Dimension(1500, 600));
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Emp_data = new javax.swing.JTable();
        search = new javax.swing.JLabel();
        query = new javax.swing.JTextField();
        back1 = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        View_LL = new javax.swing.JButton();
        print = new javax.swing.JButton();
        search_btn = new javax.swing.JButton();
        search_btn1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Emp_data.setFont(new java.awt.Font("Segoe UI Emoji", 1, 16)); // NOI18N
        Emp_data.setForeground(new java.awt.Color(204, 0, 204));
        Emp_data.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(Emp_data);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 1280, -1));

        search.setFont(new java.awt.Font("Segoe UI Black", 3, 24)); // NOI18N
        search.setForeground(new java.awt.Color(102, 0, 102));
        search.setText("Search  Employee Related Queries Here :-");
        getContentPane().add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, -1, -1));

        query.setFont(new java.awt.Font("UD Digi Kyokasho N-R", 1, 18)); // NOI18N
        getContentPane().add(query, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 50, 290, -1));

        back1.setBackground(new java.awt.Color(204, 204, 204));
        back1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        back1.setText("Back");
        back1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back1ActionPerformed(evt);
            }
        });
        getContentPane().add(back1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 20, -1, -1));

        cancel.setBackground(new java.awt.Color(204, 0, 0));
        cancel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        cancel.setForeground(new java.awt.Color(255, 255, 255));
        cancel.setText("Cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        getContentPane().add(cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 130, -1, -1));

        View_LL.setBackground(new java.awt.Color(0, 153, 153));
        View_LL.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        View_LL.setForeground(new java.awt.Color(255, 255, 255));
        View_LL.setText("View ALL");
        View_LL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                View_LLActionPerformed(evt);
            }
        });
        getContentPane().add(View_LL, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 130, -1, -1));

        print.setBackground(new java.awt.Color(0, 0, 255));
        print.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        print.setForeground(new java.awt.Color(255, 255, 255));
        print.setText("Print");
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });
        getContentPane().add(print, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, -1, -1));

        search_btn.setBackground(new java.awt.Color(0, 0, 255));
        search_btn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        search_btn.setForeground(new java.awt.Color(255, 255, 255));
        search_btn.setText("Search");
        search_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_btnActionPerformed(evt);
            }
        });
        getContentPane().add(search_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, -1, -1));

        search_btn1.setBackground(new java.awt.Color(204, 204, 204));
        search_btn1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        search_btn1.setForeground(new java.awt.Color(255, 0, 255));
        search_btn1.setText("Search");
        search_btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_btn1ActionPerformed(evt);
            }
        });
        getContentPane().add(search_btn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, -1, -1));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Vivaldi", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(32, 163, 103));
        jLabel7.setText("K - Food");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 190, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void back1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back1ActionPerformed
        this.dispose(); // Terminate the current JFrame
        Attendance_Panel view = new Attendance_Panel(); // Create an instance of the Employee_Panel class
        view.setVisible(true); // Make the Employee_Panel visible
    }//GEN-LAST:event_back1ActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelActionPerformed

    private void View_LLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_View_LLActionPerformed
       fetchEmployeeData(null);
    
    }//GEN-LAST:event_View_LLActionPerformed

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
          PrinterJob job = PrinterJob.getPrinterJob(); // Initialize PrinterJob object
    job.setJobName("Print Data");
    job.setPrintable(new Printable(){
        public int print(Graphics pg, PageFormat pf, int pageNum){
            if(pageNum > 0){
                return Printable.NO_SUCH_PAGE;
            }
            Graphics2D g2 = (Graphics2D)pg;
            g2.translate(pf.getImageableX(), pf.getImageableY());
            Emp_data.print(g2);
            return Printable.PAGE_EXISTS;
        }
    });
    boolean ok = job.printDialog();
    if(ok){
        try{
            job.print();
        }catch(PrinterException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    }//GEN-LAST:event_printActionPerformed
   
    private void search_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_btnActionPerformed
        String searchQuery = query.getText();
        fetchEmployeeData(searchQuery);
    }//GEN-LAST:event_search_btnActionPerformed

    private void search_btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_btn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search_btn1ActionPerformed

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
            java.util.logging.Logger.getLogger(Emp_Search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Emp_Search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Emp_Search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Emp_Search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Emp_Search().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Emp_data;
    private javax.swing.JButton View_LL;
    private javax.swing.JButton back1;
    private javax.swing.JButton cancel;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton print;
    private javax.swing.JTextField query;
    private javax.swing.JLabel search;
    private javax.swing.JButton search_btn;
    private javax.swing.JButton search_btn1;
    // End of variables declaration//GEN-END:variables
}
