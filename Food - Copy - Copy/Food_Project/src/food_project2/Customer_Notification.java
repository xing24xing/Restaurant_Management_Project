/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package food_project2;
import java.sql.*;
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
          // Set the customer ID label text
        setIDLabelText(String.valueOf(id));
        populateUniqueDates();
        populateNameLabel();
    }

     public void setIDLabelText(String text) {
        id.setText(text);
    }
      private void populateUniqueDates() {
    try {
        con = food_project2.conn.mycon();
        String query = "SELECT Date FROM orders"; // Modify this query according to your database schema
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

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cust.setBackground(new java.awt.Color(255, 255, 255));
        cust.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        orders.setColumns(20);
        orders.setFont(new java.awt.Font("UD Digi Kyokasho N-R", 0, 12)); // NOI18N
        orders.setRows(5);
        jScrollPane1.setViewportView(orders);

        cust.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 230, 330, 320));

        id.setFont(new java.awt.Font("SimSun", 1, 18)); // NOI18N
        id.setText("Your Name");
        cust.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 50, -1, -1));

        jLabel3.setFont(new java.awt.Font("SimSun", 1, 18)); // NOI18N
        jLabel3.setText("Your ID");
        cust.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 50, -1, -1));

        jLabel4.setFont(new java.awt.Font("SimSun", 1, 18)); // NOI18N
        jLabel4.setText("Choose Date");
        cust.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 150, -1, -1));

        name.setFont(new java.awt.Font("SimSun", 1, 18)); // NOI18N
        name.setText("Your Name");
        cust.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 100, -1, -1));

        jLabel5.setFont(new java.awt.Font("SimSun", 1, 18)); // NOI18N
        jLabel5.setText("Your Name");
        cust.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 100, -1, -1));

        date.setFont(new java.awt.Font("SimHei", 1, 14)); // NOI18N
        date.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cust.add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 150, 110, 30));

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
        cust.add(fiter, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 190, -1, -1));

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

        // Step 1: Retrieve order_id from the orders table
        String getOrderIDSql = "SELECT id FROM orders WHERE Date = ? AND customer_id = ?";
        pst = con.prepareStatement(getOrderIDSql);
        pst.setString(1, (String) date.getSelectedItem()); // Assuming date is a JComboBox
        pst.setInt(2, cust_id); // Assuming cust_id is the customer ID label value
        rs = pst.executeQuery();

        // Check if order_id is found
        if (rs.next()) {
            int orderId = rs.getInt("id");

            // Step 2: Retrieve details from order_items table based on order_id
            String getOrderItemsSql = "SELECT name, price, quantity, net_value FROM order_items WHERE order_id = ?";
            pst = con.prepareStatement(getOrderItemsSql);
            pst.setInt(1, orderId);
            rs = pst.executeQuery();

            // Clear existing text in the TextArea
            orders.setText("");

            // Append header of the receipt
            orders.append("Restaurant Bill\n");
            orders.append("-----------------------------------------\n");
            orders.append(String.format("%-16s %-10s %-10s %-10s\n", "Item", "Quantity", "Price", "Net Value"));
            // Append details to the TextArea in receipt format
            double subTotal = 0.0;
            while (rs.next()) {
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                double totalItem = rs.getDouble("net_value");

                // Calculate total for each item
                subTotal += totalItem;

                // Format the detail as a receipt item
                String receiptItem = String.format("%-20s %-10.2f %-5d %-10.2f\n", name, price, quantity, totalItem);

                // Append receipt item to the TextArea
                orders.append(receiptItem);
            }

            // Calculate tax and grand total
            double tax = subTotal * 0.10;
            double grandTotal = subTotal + tax;

            // Append sub-total, tax, and grand total to the TextArea
            orders.append("-----------------------------------------\n");
            orders.append(String.format("%-35s %.2f\n", "Sub-total:", subTotal));
            orders.append(String.format("%-35s %.2f\n", "Tax (10%):", tax));
            orders.append(String.format("%-35s %.2f\n", "Grand Total:", grandTotal));
        } else {
            // Handle case when no order_id is found
            orders.setText("No orders found for the selected date and customer ID.");
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
    try {
        con = food_project2.conn.mycon(); // Establish connection

        // Step 1: Retrieve order_id from the orders table
        String getOrderIDSql = "SELECT id FROM orders WHERE Date = ? AND customer_id = ?";
        pst = con.prepareStatement(getOrderIDSql);
        pst.setString(1, (String) date.getSelectedItem()); // Assuming date is a JComboBox
        pst.setInt(2, cust_id); // Assuming cust_id is the customer ID label value
        rs = pst.executeQuery();

        // Check if order_id is found
        if (rs.next()) {
            int orderId = rs.getInt("id");

            // Step 2: Update delivery status in the orders table
            String updateDeliveryStatusSql = "UPDATE orders SET delivery = ? WHERE id = ?";
            pst = con.prepareStatement(updateDeliveryStatusSql);
            pst.setString(1, status);
            pst.setInt(2, orderId);
            pst.executeUpdate();

            // Display success message
            JOptionPane.showMessageDialog(this, "Delivery status updated successfully: " + status);
        } else {
            // Handle case when no order_id is found
            JOptionPane.showMessageDialog(this, "No orders found for the selected date and customer ID.");
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error updating delivery status: " + ex.getMessage());
    } finally {
        // Close connections and statements
        try {
            if (rs != null) rs.close();
            if (pst != null) pst.close();
            if (con != null) con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }}

    private void noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noActionPerformed
         updateDeliveryStatus("Pending");
    }//GEN-LAST:event_noActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel cust;
    private javax.swing.JComboBox<String> date;
    private javax.swing.JButton fiter;
    private javax.swing.JLabel id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel name;
    private javax.swing.JToggleButton no;
    private javax.swing.JTextArea orders;
    private javax.swing.JToggleButton yes;
    // End of variables declaration//GEN-END:variables
}
