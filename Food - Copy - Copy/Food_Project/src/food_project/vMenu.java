/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package food_project;

import food_project2.conn;
import food_project2.Home;
import java.awt.Component;
import java.awt.Container;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class vMenu extends javax.swing.JFrame {
private int totalClicks = 0;
 Connection con = null;
 ResultSet rs = null;
 PreparedStatement ps = null;
   
   private List<Map<String, Object>> cartItems = new ArrayList<>();

    private final JPanel[] childPanels = new JPanel[30]; // Assuming a maximum of 10 child panels, adjust as needed
     private final JScrollPane scrollPane;
    private JPanel contentPane;

    public vMenu() {
        initComponents();
       con = conn.mycon(); 
       this.setExtendedState(Home.MAXIMIZED_BOTH);
        loadAndSetImage("E:\\Food\\f1.jpg", img1);
        loadAndSetImage("E:\\Food\\f2.jpg", img2);
        loadAndSetImage("E:\\Food\\f3.jpg", img3);
        loadAndSetImage("E:\\Food\\food1.jpeg", img4);
        // Initialize the count_of_products JTextField with 0
        count_Of_Product.setText("0");
        // Make the count_of_products JTextField non-editable
        count_Of_Product.setEditable(false);
        scrollPane = new JScrollPane(cust);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // Set the scroll pane as the content pane of the frame
        setContentPane(scrollPane);
    }
      
    private void handleAddToCartClick() {
        totalClicks++;
        count_Of_Product.setText(String.valueOf(totalClicks));
    }
    
  private void resetValues(Container container) {
    for (Component comp : container.getComponents()) {
        if (comp instanceof JSpinner) {
            ((JSpinner) comp).setValue(0);
        } else if (comp instanceof JTextField) {
            ((JTextField) comp).setText("0");
        } else if (comp instanceof Container) {
            resetValues((Container) comp);
        }
    }
}



 private void addToCart(JPanel childPanel) {
    Map<String, Object> itemDetails = new HashMap<>();

    // Extract details from the child panel
    JLabel nameLabel = null;
    JLabel priceLabel = null;
    JSpinner qtySpinner = null;

    for (Component comp : childPanel.getComponents()) {
        if (comp instanceof JLabel) {
            JLabel label = (JLabel) comp;
            String labelText = label.getText().trim();
            if (labelText.startsWith("$")) {
                priceLabel = label;
            } else {
                nameLabel = label; // Assuming the first label encountered is the name label
            }
        } else if (comp instanceof JSpinner) {
            qtySpinner = (JSpinner) comp;
        }
    }

    // Ensure all required components are found
    if (nameLabel == null || priceLabel == null || qtySpinner == null) {
        JOptionPane.showMessageDialog(this, "Error: Product details not found.");
        return;
    }

    // Get the quantity from the JSpinner
    int quantity = (int) qtySpinner.getValue();

    // Check if the quantity is greater than 0
    if (quantity <= 0) {
        JOptionPane.showMessageDialog(this, "Please enter a valid quantity.");
        return;
    }

    // Add details to the itemDetails map
    itemDetails.put("name", nameLabel.getText());
    itemDetails.put("price", Double.parseDouble(priceLabel.getText().replaceAll("[^\\d.]", "")));
    itemDetails.put("quantity", quantity);
    itemDetails.put("net_value", (double) itemDetails.get("price") * quantity);

    // Add itemDetails to the cartItems list
    cartItems.add(itemDetails);

    // Increment the total number of clicks
    handleAddToCartClick();

    JOptionPane.showMessageDialog(this, "Product added to cart successfully.");
}

    private void loadAndSetImage(String imagePath, JLabel label) {
        ImageIcon icon = new ImageIcon(imagePath);
        Image scaledImage = icon.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        label.setIcon(scaledIcon);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cust = new javax.swing.JPanel();
        child_panel1 = new javax.swing.JPanel();
        img1 = new javax.swing.JLabel();
        add1 = new javax.swing.JButton();
        name1 = new javax.swing.JLabel();
        price1 = new javax.swing.JLabel();
        qty1 = new javax.swing.JSpinner();
        child_panel2 = new javax.swing.JPanel();
        img2 = new javax.swing.JLabel();
        add2 = new javax.swing.JButton();
        name2 = new javax.swing.JLabel();
        price2 = new javax.swing.JLabel();
        qty2 = new javax.swing.JSpinner();
        child_panel3 = new javax.swing.JPanel();
        img3 = new javax.swing.JLabel();
        add3 = new javax.swing.JButton();
        name3 = new javax.swing.JLabel();
        price3 = new javax.swing.JLabel();
        qty3 = new javax.swing.JSpinner();
        Cart_btn = new javax.swing.JButton();
        count_Of_Product = new javax.swing.JTextField();
        child_panel4 = new javax.swing.JPanel();
        img4 = new javax.swing.JLabel();
        add4 = new javax.swing.JButton();
        name4 = new javax.swing.JLabel();
        price4 = new javax.swing.JLabel();
        qty4 = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cust.setBackground(new java.awt.Color(255, 255, 255));
        cust.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        child_panel1.setBackground(new java.awt.Color(255, 153, 255));
        child_panel1.setForeground(new java.awt.Color(204, 204, 255));
        child_panel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        img1.setBackground(new java.awt.Color(153, 0, 153));
        img1.setText("jLabel1");
        child_panel1.add(img1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 160, 130));

        add1.setBackground(new java.awt.Color(0, 204, 0));
        add1.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        add1.setText("Add to Cart");
        add1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add1ActionPerformed(evt);
            }
        });
        child_panel1.add(add1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, -1));

        name1.setBackground(new java.awt.Color(153, 0, 153));
        name1.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        name1.setText("Bread");
        child_panel1.add(name1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 60, 30));

        price1.setBackground(new java.awt.Color(153, 0, 153));
        price1.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        price1.setText("$15/-");
        child_panel1.add(price1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 50, 30));
        child_panel1.add(qty1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 40, -1));

        cust.add(child_panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 180, 260));

        child_panel2.setBackground(new java.awt.Color(255, 153, 153));
        child_panel2.setForeground(new java.awt.Color(204, 204, 255));
        child_panel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        img2.setBackground(new java.awt.Color(153, 0, 153));
        img2.setText("jLabel1");
        child_panel2.add(img2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 160, 130));

        add2.setBackground(new java.awt.Color(0, 204, 0));
        add2.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        add2.setText("Add to Cart");
        add2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add2ActionPerformed(evt);
            }
        });
        child_panel2.add(add2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, -1));

        name2.setBackground(new java.awt.Color(153, 0, 153));
        name2.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        name2.setText("Dhokla");
        child_panel2.add(name2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 60, 30));

        price2.setBackground(new java.awt.Color(153, 0, 153));
        price2.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        price2.setText("$20/-");
        child_panel2.add(price2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 50, 30));
        child_panel2.add(qty2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 40, -1));

        cust.add(child_panel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, -1, 260));

        child_panel3.setBackground(new java.awt.Color(153, 153, 255));
        child_panel3.setForeground(new java.awt.Color(204, 204, 255));
        child_panel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        img3.setBackground(new java.awt.Color(153, 0, 153));
        img3.setText("jLabel1");
        child_panel3.add(img3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 160, 130));

        add3.setBackground(new java.awt.Color(0, 204, 0));
        add3.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        add3.setText("Add to Cart");
        add3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add3ActionPerformed(evt);
            }
        });
        child_panel3.add(add3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, -1));

        name3.setBackground(new java.awt.Color(153, 0, 153));
        name3.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        name3.setText("Pasta");
        child_panel3.add(name3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 60, 30));

        price3.setBackground(new java.awt.Color(153, 0, 153));
        price3.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        price3.setText("$20/-");
        child_panel3.add(price3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 50, 30));
        child_panel3.add(qty3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 40, -1));

        cust.add(child_panel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 70, -1, 260));

        Cart_btn.setBackground(new java.awt.Color(255, 255, 0));
        Cart_btn.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        Cart_btn.setText("Cart");
        Cart_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cart_btnActionPerformed(evt);
            }
        });
        cust.add(Cart_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 10, -1, -1));

        count_Of_Product.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        cust.add(count_Of_Product, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 20, 40, -1));

        child_panel4.setBackground(new java.awt.Color(153, 255, 153));
        child_panel4.setForeground(new java.awt.Color(204, 204, 255));
        child_panel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        img4.setBackground(new java.awt.Color(153, 0, 153));
        img4.setText("jLabel1");
        child_panel4.add(img4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 160, 130));

        add4.setBackground(new java.awt.Color(0, 204, 0));
        add4.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        add4.setText("Add to Cart");
        add4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add4ActionPerformed(evt);
            }
        });
        child_panel4.add(add4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, -1));

        name4.setBackground(new java.awt.Color(153, 0, 153));
        name4.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        name4.setText("Dhokla");
        child_panel4.add(name4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 60, 30));

        price4.setBackground(new java.awt.Color(153, 0, 153));
        price4.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        price4.setText("$20/-");
        child_panel4.add(price4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 50, 30));
        child_panel4.add(qty4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 40, -1));

        cust.add(child_panel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 70, -1, 260));

        getContentPane().add(cust, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1240, 710));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void add1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add1ActionPerformed
     addToCart(child_panel1);
    }//GEN-LAST:event_add1ActionPerformed

    private void add2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add2ActionPerformed
addToCart(child_panel2);
    }//GEN-LAST:event_add2ActionPerformed
  private void addToCartRecord(int orderId, String name, double price, int quantity, double netValue) {
    try {
        // Insert details into the order_items table
        String sql = "INSERT INTO order_items (order_id, name, price, quantity, net_value) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, orderId);
        ps.setString(2, name);
        ps.setDouble(3, price);
        ps.setInt(4, quantity);
        ps.setDouble(5, netValue);
        ps.executeUpdate();
        ps.close();
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error: Failed to insert data into the database.");
    }
}
  private double calculateTotalNetValue() {
    double totalNetValue = 0.0;
    for (Map<String, Object> item : cartItems) {
        double netValue = (double) item.get("net_value");
        totalNetValue += netValue;
    }
    return totalNetValue;
}


    private void Cart_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cart_btnActionPerformed
      try {
        // Calculate total net value
        double totalNetValue = calculateTotalNetValue();

        // Insert order details into the orders table
        String orderSql = "INSERT INTO orders (total_net_value) VALUES (?)";
        PreparedStatement orderPs = con.prepareStatement(orderSql, Statement.RETURN_GENERATED_KEYS);
        orderPs.setDouble(1, totalNetValue);
        orderPs.executeUpdate();

        // Get the generated order ID
        ResultSet generatedKeys = orderPs.getGeneratedKeys();
        int orderId = -1;
        if (generatedKeys.next()) {
            orderId = generatedKeys.getInt(1);
        }

        // Insert each item into the order_items table
        for (Map<String, Object> item : cartItems) {
            String name = (String) item.get("name");
            double price = (double) item.get("price");
            int quantity = (int) item.get("quantity");
            double netValue = (double) item.get("net_value");
            addToCartRecord(orderId, name, price, quantity, netValue);
        }
       resetValues(getContentPane()); // Call with the content pane of the frame
        JOptionPane.showMessageDialog(this, "Order placed successfully.");
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error: Failed to place order.");
    }
    

    }//GEN-LAST:event_Cart_btnActionPerformed

    private void add3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add3ActionPerformed
       addToCart(child_panel3);
    }//GEN-LAST:event_add3ActionPerformed

    private void add4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add4ActionPerformed
         addToCart(child_panel4);
    }//GEN-LAST:event_add4ActionPerformed
 


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
            java.util.logging.Logger.getLogger(vMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cart_btn;
    private javax.swing.JButton add1;
    private javax.swing.JButton add2;
    private javax.swing.JButton add3;
    private javax.swing.JButton add4;
    private javax.swing.JPanel child_panel1;
    private javax.swing.JPanel child_panel2;
    private javax.swing.JPanel child_panel3;
    private javax.swing.JPanel child_panel4;
    private javax.swing.JTextField count_Of_Product;
    private javax.swing.JPanel cust;
    private javax.swing.JLabel img1;
    private javax.swing.JLabel img2;
    private javax.swing.JLabel img3;
    private javax.swing.JLabel img4;
    private javax.swing.JLabel name1;
    private javax.swing.JLabel name2;
    private javax.swing.JLabel name3;
    private javax.swing.JLabel name4;
    private javax.swing.JLabel price1;
    private javax.swing.JLabel price2;
    private javax.swing.JLabel price3;
    private javax.swing.JLabel price4;
    private javax.swing.JSpinner qty1;
    private javax.swing.JSpinner qty2;
    private javax.swing.JSpinner qty3;
    private javax.swing.JSpinner qty4;
    // End of variables declaration//GEN-END:variables
}
