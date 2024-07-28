/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package food_project2;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
 
public final class Customer_Notification extends javax.swing.JPanel {
Connection con = null;
   ResultSet rs = null;
   PreparedStatement pst = null;
  
     private int cust_id;
    private JPanel child2;
    private Customer_Dashboard dash;
    public Customer_Notification(JPanel child2,Customer_Dashboard dash,int id) {
         initComponents();
        this.child2 = child2;
        this.dash = dash;
        this.cust_id = id;
        orders.setEditable(false);
          // Set the customer ID label text
        setIDLabelText(String.valueOf(id));
        populateUniqueDates();
        populateNameLabel();
//         loadAndSetImage("E:\\Food\\customer_logo.png", cart);
         loadAndSetImage("E:\\Food\\customer_logo.png", cart);
         date.addActionListener((ActionEvent e) -> {
             // Call a method to populate order IDs based on the selected date
             populateOrderIds();
        });
    }
    private void populateOrderIds() {
        try {
            con = food_project2.conn.mycon();
            String selectedDate = (String) date.getSelectedItem();
            String query = "SELECT id FROM orders WHERE Date = ? AND customer_id = ?";
            pst = con.prepareStatement(query);
            pst.setString(1, selectedDate);
            pst.setInt(2, cust_id);
            rs = pst.executeQuery();

            // Clear existing items in the combo box
            orderId.removeAllItems();

            // Add a default item
            orderId.addItem("Select Order ID");

            // Add retrieved order IDs to the combo box
            while (rs.next()) {
                int orderIdValue = rs.getInt("id");
                orderId.addItem(String.valueOf(orderIdValue));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
    }
private void loadAndSetImage(String imagePath, JLabel label) {
    int width = 60; // Fixed width for all images
    int height = 40; // Fixed height for all images
    ImageIcon icon = new ImageIcon(imagePath);
    Image scaledImage = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
    label.setIcon(new ImageIcon(scaledImage));
}
     public void setIDLabelText(String text) {
        id.setText(text);
    }
     private void populateUniqueDates() {
    try {
        con = food_project2.conn.mycon();
        String query = "SELECT DISTINCT Date FROM orders"; // Modify this query to fetch distinct dates
        pst = con.prepareStatement(query);
        rs = pst.executeQuery();

        date.removeAllItems();
        date.addItem("Select Date");

        while (rs.next()) {
            date.addItem(rs.getString("Date"));
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e);
    } 
}

 private void populateNameLabel() {
        

        try {
            
            String sql = "SELECT Name FROM customer_details WHERE ID = ?";
            pst = con.prepareStatement(sql);
            pst.setInt(1, cust_id);

            // Execute query
            rs = pst.executeQuery();

            // Set the name label text
            if (rs.next()) {
                String customerName = rs.getString("Name");
                name.setText(customerName);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            // Close connections and statements
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (con != null) con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
 public void goToChild2() {
        // Reload the main components of child2
        // You can implement this method according to your JPanel structure
        // For example:
        jPanelLoader(child2, cust); // Replace mainChild2Panel with your actual child2 main panel
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

        cust = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        orders = new javax.swing.JTextArea();
        id = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        date = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        yes = new javax.swing.JToggleButton();
        no = new javax.swing.JToggleButton();
        fiter = new javax.swing.JButton();
        back = new javax.swing.JButton();
        cart = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        orderId = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cust.setBackground(new java.awt.Color(255, 255, 255));
        cust.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        orders.setColumns(20);
        orders.setFont(new java.awt.Font("UD Digi Kyokasho N-R", 0, 12)); // NOI18N
        orders.setRows(5);
        jScrollPane1.setViewportView(orders);

        cust.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 270, 410, 320));

        id.setFont(new java.awt.Font("SimSun", 1, 18)); // NOI18N
        cust.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 70, 170, 30));

        jLabel3.setFont(new java.awt.Font("SimSun", 1, 18)); // NOI18N
        jLabel3.setText("Your ID");
        cust.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 80, -1, -1));

        jLabel4.setFont(new java.awt.Font("SimSun", 1, 18)); // NOI18N
        jLabel4.setText("Order Id");
        cust.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 200, -1, -1));

        name.setFont(new java.awt.Font("SimSun", 1, 18)); // NOI18N
        cust.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 110, 150, 30));

        jLabel5.setFont(new java.awt.Font("SimSun", 1, 18)); // NOI18N
        jLabel5.setText("Your Name");
        cust.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 120, -1, -1));

        date.setFont(new java.awt.Font("SimHei", 1, 14)); // NOI18N
        date.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cust.add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 150, 110, 30));

        jLabel1.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jLabel1.setText("Do Your Food Delivered");
        cust.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 590, -1, -1));

        yes.setBackground(new java.awt.Color(0, 204, 0));
        yes.setFont(new java.awt.Font("Segoe UI Variable", 1, 12)); // NOI18N
        yes.setForeground(new java.awt.Color(255, 255, 255));
        yes.setText("Yes");
        yes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yesActionPerformed(evt);
            }
        });
        cust.add(yes, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 620, -1, -1));

        no.setBackground(new java.awt.Color(255, 0, 0));
        no.setFont(new java.awt.Font("Segoe UI Variable", 1, 12)); // NOI18N
        no.setForeground(new java.awt.Color(255, 255, 255));
        no.setText("no");
        no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noActionPerformed(evt);
            }
        });
        cust.add(no, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 620, -1, -1));

        fiter.setBackground(new java.awt.Color(0, 0, 204));
        fiter.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        fiter.setForeground(new java.awt.Color(255, 255, 255));
        fiter.setText("Filter");
        fiter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fiterActionPerformed(evt);
            }
        });
        cust.add(fiter, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 230, -1, -1));

        back.setBackground(new java.awt.Color(51, 51, 51));
        back.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        back.setForeground(new java.awt.Color(255, 255, 255));
        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        cust.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 20, 90, 40));

        cart.setIcon(new javax.swing.ImageIcon("E:\\Food\\cheff6.png")); // NOI18N
        cust.add(cart, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 10, 60, 40));

        jLabel6.setIcon(new javax.swing.ImageIcon("E:\\Food\\cheff6.png")); // NOI18N
        cust.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(-50, -20, -1, -1));

        orderId.setFont(new java.awt.Font("SimHei", 1, 14)); // NOI18N
        orderId.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cust.add(orderId, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 190, 110, 30));

        jLabel7.setFont(new java.awt.Font("SimSun", 1, 18)); // NOI18N
        jLabel7.setText("Choose Date");
        cust.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 160, -1, -1));

        add(cust, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1310, 920));
    }// </editor-fold>//GEN-END:initComponents

    private void yesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yesActionPerformed
          updateDeliveryStatus("Delivered");
    }//GEN-LAST:event_yesActionPerformed

    private void fiterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fiterActionPerformed
        fetchDetailsAndUpdateTextArea();
    }//GEN-LAST:event_fiterActionPerformed
 private void fetchDetailsAndUpdateTextArea() {
    try {
        con = food_project2.conn.mycon(); // Establish connection

        // Retrieve selected order ID, customer ID, and date
        int selectedOrderId = Integer.parseInt((String) orderId.getSelectedItem());
        String selectedDate = (String) date.getSelectedItem();

        // Query to fetch order details including order items
        String query = "SELECT * FROM orders JOIN order_items ON orders.id = order_items.order_id WHERE orders.id = ? AND orders.Date = ? AND orders.customer_id = ?";
        pst = con.prepareStatement(query);
        pst.setInt(1, selectedOrderId);
        pst.setString(2, selectedDate);
        pst.setInt(3, cust_id);
        rs = pst.executeQuery();

        // Clear existing text in the TextArea
        orders.setText("");

        // Check if any records are found
        if (rs.next()) {
            // Display order details
            double subTotal = 0.0;
            orders.append("Restaurant Bill\n");
            orders.append("-----------------------------------------\n");
            orders.append(String.format("%-20s %-10s %-10s %-10s\n", "Item", "Quantity", "Price", "Net Value"));

            do {
                String itemName = rs.getString("name");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                double netValue = rs.getDouble("net_value");

                // Calculate total for each item
                subTotal += netValue;

                // Append order item details
                orders.append(String.format("%-20s %-10.2f %-10d %-10.2f\n", itemName, price, quantity, netValue));
            } while (rs.next());

            // Append sub-total, tax, and grand total to the TextArea
            double tax = subTotal * 0.10;
            double grandTotal = subTotal + tax;
            orders.append("-----------------------------------------\n");
            orders.append(String.format("%-35s %.2f\n", "Sub-total:", subTotal));
            orders.append(String.format("%-35s %.2f\n", "Tax (10%):", tax));
            orders.append(String.format("%-35s %.2f\n", "Grand Total:", grandTotal));
        } else {
            orders.setText("No records found for the selected order ID, date, and customer ID.");
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    } finally {
        // Close connections and statements
        try {
            if (rs != null) rs.close();
            if (pst != null) pst.close();
            if (con != null) con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
private void updateDeliveryStatus(String status) {
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    try {
        con = food_project2.conn.mycon(); // Establish connection

        // Retrieve selected order ID, customer ID, and date
        int selectedOrderId = Integer.parseInt((String) orderId.getSelectedItem());
        String selectedDate = (String) date.getSelectedItem();

        // Check if the delivery status is already "Delivered"
        String checkDeliveryStatusSql = "SELECT delivery FROM orders WHERE id = ? AND Date = ? AND customer_id = ?";
        pst = con.prepareStatement(checkDeliveryStatusSql);
        pst.setInt(1, selectedOrderId);
        pst.setString(2, selectedDate);
        pst.setInt(3, cust_id);
        rs = pst.executeQuery();

        if (rs.next()) {
            String currentStatus = rs.getString("delivery");
            if (currentStatus != null && currentStatus.equals("Delivered")) {
                JOptionPane.showMessageDialog(this, "This delivery is already done. You can't update it now.");
                return; // Exit the method if delivery is already done
            }
        }

        // Update delivery status in the orders table if it's not already "Delivered"
        String updateDeliveryStatusSql = "UPDATE orders SET delivery = ? WHERE id = ? AND Date = ? AND customer_id = ? AND delivery IS NULL";
        pst = con.prepareStatement(updateDeliveryStatusSql);
        pst.setString(1, status);
        pst.setInt(2, selectedOrderId);
        pst.setString(3, selectedDate);
        pst.setInt(4, cust_id);
        int rowsAffected = pst.executeUpdate();

        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(this, "Delivery status updated successfully: " + status);
        } else {
            JOptionPane.showMessageDialog(this, "No records found for the selected order ID, date, and customer ID, or the delivery status is already set.");
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error updating delivery status: " + ex.getMessage());
    } finally {
        // Close ResultSet, PreparedStatement, and Connection in the finally block
        try {
            if (rs != null) rs.close();
            if (pst != null) pst.close();
            if (con != null) con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}


    private void noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noActionPerformed
         updateDeliveryStatus("Pending");
    }//GEN-LAST:event_noActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to go back?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            // Navigate back to Emp_Panel using the reference
            dash.goToChild2();
        }
    }//GEN-LAST:event_backActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JLabel cart;
    private javax.swing.JPanel cust;
    private javax.swing.JComboBox<String> date;
    private javax.swing.JButton fiter;
    private javax.swing.JLabel id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel name;
    private javax.swing.JToggleButton no;
    private javax.swing.JComboBox<String> orderId;
    private javax.swing.JTextArea orders;
    private javax.swing.JToggleButton yes;
    // End of variables declaration//GEN-END:variables
}
