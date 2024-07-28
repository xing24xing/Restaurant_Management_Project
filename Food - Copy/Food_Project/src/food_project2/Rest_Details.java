/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package food_project2;

import food_project2.Home;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.Color;
import java.awt.Component;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.table.TableColumn;

public class Rest_Details extends javax.swing.JPanel {

    private final Object[][] rowData = {};
           private Home homeFrame;
        private final String[] columnNames = {"Sr. no.", "Restaurant Name", "Branch", "Phone no."};
    public Rest_Details(JPanel child2) {
        initComponents();
        populateTable();
        customizeTableAppearance();
        setTableCellsNonEditable();
        customizeColumnWidthAndColor();
        setRowHeight();
        
        
    }

      private void populateTable() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        for (Object[] row : rowData) {
            model.addRow(row);
        }
    }

    private void customizeTableAppearance() {
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setForeground(Color.BLACK);
        cellRenderer.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 18));

        for (int i = 0; i < jTable1.getColumnCount(); i++) {
            jTable1.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
        }
    }

    private void setTableCellsNonEditable() {
        jTable1.setDefaultEditor(Object.class, null);
    }
     private void customizeColumnWidthAndColor() {
        // Customize width and color for the 2nd column
        TableColumn first = jTable1.getColumnModel().getColumn(0);
        first .setPreferredWidth(100); // Set preferred width
        first .setMinWidth(100); // Set minimum width
        first .setMaxWidth(200); // Set maximum width
         first .setHeaderRenderer(new CustomHeaderRenderer());
//        first.Set
        first .setHeaderRenderer(new CustomHeaderRenderer());
        TableColumn secondColumn = jTable1.getColumnModel().getColumn(2);
        secondColumn.setPreferredWidth(200); // Set preferred width
        secondColumn.setMinWidth(300); // Set minimum width
        secondColumn.setMaxWidth(500); // Set maximum width
        
        TableColumn Sec = jTable1.getColumnModel().getColumn(1);
         Sec .setHeaderRenderer(new CustomHeaderRenderer());
        secondColumn.setHeaderRenderer(new CustomHeaderRenderer()); // Set custom header renderer
        TableColumn Third = jTable1.getColumnModel().getColumn(3);
        Third.setPreferredWidth(200); // Set preferred width
        Third.setMinWidth(300); // Set minimum width
        Third.setMaxWidth(400); // Set maximum width
        Third.setHeaderRenderer(new CustomHeaderRenderer());
    }
  private void setRowHeight() {
       jTable1.setRowHeight(0, 40); // Set row height for Sr. no. column
               jTable1.setRowHeight( 30); // Set row height for Sr. no. column
       
    }
    private class CustomHeaderRenderer extends DefaultTableCellRenderer {
        public CustomHeaderRenderer() {
            setHorizontalAlignment(CENTER);
            setBackground(Color.GRAY); // Set custom background color
            setForeground(Color.WHITE); // Set custom text color
            setFont(new Font("Verdana", Font.BOLD, 20)); // Set custom font
            setHorizontalAlignment(CENTER);
             DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
    cellRenderer.setForeground(Color.DARK_GRAY);
    cellRenderer.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 20));
    cellRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER); //
             for (int i = 0; i < jTable1.getColumnCount(); i++) {
        jTable1.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
    }
        }
    }
  

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setBackground(new java.awt.Color(204, 204, 255));
        jTable1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                { new Integer(1), "  ABC ", " Mumbai", "  12345"},
                { new Integer(2), "  Lotus", " Bandra", " 23456"},
                { new Integer(3), " Lion", "  Shainghai", "  12347"},
                { new Integer(4), " Luise", "  Norway", "78885"},
                { new Integer(5), "  XYZ", "  Tokyo", " 45678"},
                { new Integer(6), "  City", "  Oslo", "  55666"},
                { new Integer(7), "  Tiny", "  Jaipur", " 58689"},
                { new Integer(8), "  Temp", "  Beijing", " 45677"},
                { new Integer(9), "  Ten", " Tokyo", "  25345"},
                { new Integer(10), "  Litz", "  Thane", "  34566"},
                { new Integer(11), "   Len", "  Delhi", "45788"},
                { new Integer(12), "  Five Star", "  Busan", "  22345"},
                { new Integer(13), "  Top", "  Singapore", "  12345"},
                { new Integer(14), "   SunFlower", "  Bangkok", "  12346"},
                { new Integer(15), "  Venice", "  Rome", "  34456"},
                { new Integer(16), "   Lizard", "  Thimphu", "  23344"},
                { new Integer(17), "   Zard", "   Chennai", " 67890"},
                { new Integer(18), "    Tiger", "   Lakhnow", "  67889"},
                { new Integer(19), "   Rosse", "   Patna", "  88989"},
                { new Integer(20), "    Topper", "    NewYork", "  44433"},
                { new Integer(21), "   Lamda", "   Hongkong", "  23334"},
                { new Integer(22), "  chille", "   Kathmandu", "   77888"},
                { new Integer(23), "   Lion", "    London", "   77894"},
                { new Integer(24), "  Ben Food", "  Berlin", "   78895"},
                { new Integer(25), "  FDH", "  Peris", "    67898"}
            },
            new String [] {
                "Sr. no.", "Restaurant Name", "Branch", "Phone no."
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setSelectionBackground(new java.awt.Color(102, 255, 0));
        jTable1.setSelectionForeground(new java.awt.Color(51, 51, 255));
        jTable1.setShowGrid(true);
        jScrollPane2.setViewportView(jTable1);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 1210, 521));

        jLabel3.setIcon(new javax.swing.ImageIcon("E:\\Food\\cheff6.png")); // NOI18N
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-50, -40, -1, -1));

        jLabel4.setFont(new java.awt.Font("Bookman Old Style", 3, 30)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 204));
        jLabel4.setText("Restaurant Details");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 30, 340, -1));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
