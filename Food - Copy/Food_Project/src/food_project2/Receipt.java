/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package food_project2;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterJob;
import javax.swing.JPanel;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import java.util.Date;

public class Receipt extends javax.swing.JPanel {
     Connection con = null;
 ResultSet rs = null;
     PreparedStatement ps = null;
   private JPanel child2;
   private int userId;
    JpanelLoader Jload = new JpanelLoader();
    private Menu_veg veg;
    private static final double TAX_RATE = 0.10;
//    private javax.swing.JTextArea receiptTextArea; // Added declaration
    private Non_Veg non;
    public Receipt(JPanel child2,Non_Veg non,Menu_veg veg,int userId,List<Map<String, Object>> cartItems) {
        initComponents();
        this.userId = userId;
        this.child2 = child2;
        this.veg = veg;
        this.non = non;
        receiptTextArea.setEnabled(false);
        Receive.setEnabled(false);
        id.setText("Customer ID: " + userId);
        System.out.println("Cart Items: " + cartItems);

        // Generate the receipt text
        StringBuilder receipt = new StringBuilder();
        receipt.append("['Delicious Food Items From All Over The World']\n\n");
        receipt.append("['Add : Mumbai ,401203'] ['Phone no : 1234567890']\n\n");
        receipt.append("Authentic Continental Food  At Its Finest\n\n");
        receipt.append(String.format("%-16s %-10s %-10s %-10s\n", "Item", "Quantity", "Price", "Net Value"));
       receipt.append("\n=================================================\n\n");

        double subtotal = 0.0;

        for (Map<String, Object> item : cartItems) {
            String name = (String) item.get("name");
            double price = (double) item.get("price");
            int quantity = (int) item.get("quantity");
            double netValue = (double) item.get("net_value");

            receipt.append(String.format("%-20s %-10d %-10.2f %-10.2f\n", name, quantity, price, netValue));
            subtotal += netValue;
              receipt.append("------------------------------------------------\n");
        }

        double taxAmount = subtotal * TAX_RATE;
        double grandTotal = subtotal + taxAmount;

        receipt.append("\n=================================================\n");
        receipt.append(String.format("%-35s %-10.2f\n\n", "Subtotal", subtotal));
        receipt.append(String.format("%-35s %-10.2f\n\n", "Tax (10%)", taxAmount));
        receipt.append(String.format("%-35s %-10.2f\n\n", "Grand Total", grandTotal));

        receiptTextArea.setText(receipt.toString());

        // Display current date
        String currentDate = getCurrentDate();
        dat.setText("Date: " + currentDate);
    }

     private String getCurrentDate() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return formatter.format(date);
    }
     public void goToChild2() {
        // Reload the main components of child2
        // You can implement this method according to your JPanel structure
        // For example:
        jPanelLoader(child2, tab); // Replace mainChild2Panel with your actual child2 main panel
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

        tab = new javax.swing.JPanel();
        Receive = new javax.swing.JPanel();
        dat = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        receiptTextArea = new javax.swing.JTextArea();
        id = new javax.swing.JLabel();
        print = new javax.swing.JButton();
        back = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tab.setBackground(new java.awt.Color(255, 255, 255));
        tab.setForeground(new java.awt.Color(102, 102, 102));
        tab.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Receive.setBackground(new java.awt.Color(255, 255, 255));
        Receive.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        Receive.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dat.setFont(new java.awt.Font("SimSun", 1, 12)); // NOI18N
        Receive.add(dat, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 150, 20));

        jLabel2.setFont(new java.awt.Font("Vivaldi", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 153));
        jLabel2.setText("K - Food");
        Receive.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, -1));

        jLabel4.setFont(new java.awt.Font("Serif", 3, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 153, 0));
        jLabel4.setText("Receipt");
        Receive.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, 100, -1));

        receiptTextArea.setColumns(20);
        receiptTextArea.setFont(new java.awt.Font("UD Digi Kyokasho N-R", 0, 13)); // NOI18N
        receiptTextArea.setRows(5);
        jScrollPane2.setViewportView(receiptTextArea);

        Receive.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 370, 550));

        tab.add(Receive, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 30, 390, 590));

        id.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        id.setText("ID:-");
        tab.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, 210, 30));

        print.setBackground(new java.awt.Color(0, 0, 153));
        print.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        print.setForeground(new java.awt.Color(255, 255, 255));
        print.setText("Print");
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });
        tab.add(print, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 100, 90, 40));

        back.setBackground(new java.awt.Color(51, 51, 51));
        back.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        back.setForeground(new java.awt.Color(255, 255, 255));
        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        tab.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 20, 90, 40));

        jLabel3.setIcon(new javax.swing.ImageIcon("E:\\Food\\cheff6.png")); // NOI18N
        tab.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, -20, -1, -1));

        add(tab, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1460, 720));
    }// </editor-fold>//GEN-END:initComponents
    public void printPanel(JPanel Receive) {
    PrinterJob printerJob = PrinterJob.getPrinterJob();
    printerJob.setJobName("Print Panel");

    printerJob.setPrintable(new Printable() {
        public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) {
            if (pageIndex > 0) {
                return Printable.NO_SUCH_PAGE;
            }

            Graphics2D g2 = (Graphics2D) graphics;
            g2.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

            // Scale the panel content to fit the printable area
            double scaleFactor = pageFormat.getImageableWidth() / Receive.getWidth();
            g2.scale(scaleFactor, scaleFactor);

            // Print the panel content
            Receive.paint(g2);

            // Print the text area content
            g2.translate(0, 100); // Adjust Y position according to your layout
            receiptTextArea.print(g2);

            return Printable.PAGE_EXISTS;
        }
    });

    boolean ok = printerJob.printDialog();
    if (ok) {
        try {
            printerJob.print();
        } catch (Exception ex) {
            /* handle exception */
        }
    }
    }

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
       printPanel(Receive);
   
    }//GEN-LAST:event_printActionPerformed
public JPanel getPanelByName(String panelName) {
    if (panelName.equals("receive")) {
        return this; // Return the current panel instance
    } else {
        // Handle other panel names if needed
        return null; // Or return another panel instance or null if not found
    }
}

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to go back?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            // Navigate back to the correct form
            if (veg != null) {
                veg.goToChild2();
            } else if (non != null) {
                non.goToChild2();
            }
        }
    
    }//GEN-LAST:event_backActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Receive;
    private javax.swing.JButton back;
    private javax.swing.JLabel dat;
    private javax.swing.JLabel id;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton print;
    private javax.swing.JTextArea receiptTextArea;
    private javax.swing.JPanel tab;
    // End of variables declaration//GEN-END:variables
}
