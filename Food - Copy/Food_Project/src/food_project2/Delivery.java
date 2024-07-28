/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package food_project2;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
public class Delivery extends javax.swing.JPanel {
Connection con = null;
   ResultSet rs = null;
   PreparedStatement pst = null;
   private Home homeFrame; 
    JpanelLoader Jload = new JpanelLoader();
    private final JPanel child2;
    public Delivery(JPanel child2,Home  homeFrame) {
            initComponents();
       this.child2 = child2;
        this.homeFrame = homeFrame; 
        admtab.setEnabled(false);
        con = food_project2.conn.mycon();       
        fetchDataFromOrderDetails();
        customizeTable();
         loadAndSetImage("E:\\Food\\cart.png", cart);
    }
private void loadAndSetImage(String imagePath, JLabel label) {
    int width = 160; // Fixed width for all images
    int height = 130; // Fixed height for all images
    ImageIcon icon = new ImageIcon(imagePath);
    Image scaledImage = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
    label.setIcon(new ImageIcon(scaledImage));
}
    private void fetchDataFromOrderDetails() {
        try {
            String query = "SELECT * FROM orders";
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            DefaultTableModel model = new DefaultTableModel();
            admtab.setModel(model);

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
   admtab.setDefaultRenderer(Object.class, new CustomTableCellRenderer());
    admtab.setRowHeight(40); // Increase row height
    admtab.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15)); // Increase header font size
    admtab.getTableHeader().setBackground(new Color(204, 0, 204)); // Set header background color
    admtab.getTableHeader().setForeground(Color.BLACK); // Set header text color
    admtab.getTableHeader().setPreferredSize(new Dimension(100, 50)); // Set header height

    // Center-align table headers
    ((DefaultTableCellRenderer) admtab.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        admtab = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        cart = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 1110, 450));

        jLabel1.setFont(new java.awt.Font("Sitka Text", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setText("Product Delivery Details");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 50, -1, -1));

        cart.setIcon(new javax.swing.ImageIcon("E:\\Food - Copy\\cart.png")); // NOI18N
        jPanel1.add(cart, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 0, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon("E:\\Food\\cheff6.png")); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, -10, -1, -1));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1340, 980));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable admtab;
    private javax.swing.JLabel cart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
