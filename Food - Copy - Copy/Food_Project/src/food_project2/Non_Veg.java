/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package food_project2;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
/**
 *
 * @author khushi pandey
 */
public class Non_Veg extends javax.swing.JPanel {

   private String username;
   private int totalClicks = 0;
 Connection con = null;
 ResultSet rs = null;
 PreparedStatement ps = null;
   
   private final List<Map<String, Object>> cartItems = new ArrayList<>();

    private final JPanel[] childPanels = new JPanel[30];
//     private final JScrollPane scrollPane;
    // Assuming a maximum of 10 child panels, adjust as needed
    private final JPanel child2;
    
     private int userID;
    private String userName;

     JpanelLoader Jload = new JpanelLoader();
     private Customer_Dashboard dash;
    public Non_Veg(JPanel child2, Customer_Dashboard dash, int userID, String username) {
           initComponents();
        con = food_project2.conn.mycon(); 
       
        this.child2 = child2;
        this.dash = dash;
        this.userID = userID; // Store the user ID
        this.userName = userName;  
        
        // Display logged-in user information
         id.setText("Your Id, " + userID );
         cust_name.setText("Welcome, " + username + "!");
       loadAndSetImage("E:\\Food\\fn1.jpg", img1);
       loadAndSetImage("E:\\Food\\food21.jpeg", img2);
       loadAndSetImage("E:\\Food\\fn3.jpg", img3);
       loadAndSetImage("E:\\Food\\fn4.jpg", img4);
        loadAndSetImage("E:\\Food\\fn5.jpg", img5);
        loadAndSetImage("E:\\Food\\fn6.jpg", img6);
        loadAndSetImage("E:\\Food\\food19.jpeg", img7);
        loadAndSetImage("E:\\Food\\fn7.jpg", img8);
        loadAndSetImage("E:\\Food\\food39.jpeg", img9);
        loadAndSetImage("E:\\Food\\fn10.jpg", img10);
        loadAndSetImage("E:\\Food\\fn11.jpg", img11);
        loadAndSetImage("E:\\Food\\food1.jpeg", img12);
        loadAndSetImage("E:\\Food\\food6.jpeg", img13);
        loadAndSetImage("E:\\Food\\food14.jpeg", img14);
        loadAndSetImage("E:\\Food\\food22.jpeg", img15);
        loadAndSetImage("E:\\Food\\food27.jpeg", img17);
        loadAndSetImage("E:\\Food\\food29.jpeg", img18);
        loadAndSetImage("E:\\Food\\food30.jpeg", img19);
        loadAndSetImage("E:\\Food\\food32.jpeg", img20);
        loadAndSetImage("E:\\Food\\food38.jpeg", img16);
        count_Of_Product.setText("0");
        // Make the count_of_products JTextField non-editable
        count_Of_Product.setEditable(false);
       
        JScrollPane scrollPane = new JScrollPane(cust);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // Set the preferred size of the cust panel
        cust.setPreferredSize(new Dimension(1330, 1540)); // Adjust dimensions as needed

        // Add scrollPane to the main panel
        add(scrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1330, 880)); // Adjust size as needed
    }

     private void loadAndSetImage(String imagePath, JLabel label) {
    int width = 160; // Fixed width for all images
    int height = 130; // Fixed height for all images
    ImageIcon icon = new ImageIcon(imagePath);
    Image scaledImage = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
    label.setIcon(new ImageIcon(scaledImage));
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
 private void handleAddToCartClick() {
        totalClicks++;
        count_Of_Product.setText(String.valueOf(totalClicks));
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
        child_panel5 = new javax.swing.JPanel();
        img5 = new javax.swing.JLabel();
        add5 = new javax.swing.JButton();
        name5 = new javax.swing.JLabel();
        price5 = new javax.swing.JLabel();
        qty5 = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        cust_name = new javax.swing.JLabel();
        back = new javax.swing.JButton();
        child_panel6 = new javax.swing.JPanel();
        img6 = new javax.swing.JLabel();
        add6 = new javax.swing.JButton();
        name6 = new javax.swing.JLabel();
        price6 = new javax.swing.JLabel();
        qty6 = new javax.swing.JSpinner();
        record = new javax.swing.JButton();
        child_panel7 = new javax.swing.JPanel();
        img7 = new javax.swing.JLabel();
        add7 = new javax.swing.JButton();
        name7 = new javax.swing.JLabel();
        price7 = new javax.swing.JLabel();
        qty7 = new javax.swing.JSpinner();
        child_panel8 = new javax.swing.JPanel();
        img8 = new javax.swing.JLabel();
        add8 = new javax.swing.JButton();
        name8 = new javax.swing.JLabel();
        price8 = new javax.swing.JLabel();
        qty8 = new javax.swing.JSpinner();
        child_panel9 = new javax.swing.JPanel();
        img9 = new javax.swing.JLabel();
        add9 = new javax.swing.JButton();
        name9 = new javax.swing.JLabel();
        price9 = new javax.swing.JLabel();
        qty9 = new javax.swing.JSpinner();
        child_panel11 = new javax.swing.JPanel();
        img11 = new javax.swing.JLabel();
        add11 = new javax.swing.JButton();
        name11 = new javax.swing.JLabel();
        price11 = new javax.swing.JLabel();
        qty11 = new javax.swing.JSpinner();
        child_panel10 = new javax.swing.JPanel();
        img10 = new javax.swing.JLabel();
        add10 = new javax.swing.JButton();
        name10 = new javax.swing.JLabel();
        price10 = new javax.swing.JLabel();
        qty10 = new javax.swing.JSpinner();
        child_panel12 = new javax.swing.JPanel();
        img12 = new javax.swing.JLabel();
        add12 = new javax.swing.JButton();
        name12 = new javax.swing.JLabel();
        price12 = new javax.swing.JLabel();
        qty12 = new javax.swing.JSpinner();
        child_panel13 = new javax.swing.JPanel();
        img13 = new javax.swing.JLabel();
        add13 = new javax.swing.JButton();
        name13 = new javax.swing.JLabel();
        price13 = new javax.swing.JLabel();
        qty13 = new javax.swing.JSpinner();
        child_panel14 = new javax.swing.JPanel();
        img14 = new javax.swing.JLabel();
        add14 = new javax.swing.JButton();
        name14 = new javax.swing.JLabel();
        price14 = new javax.swing.JLabel();
        qty14 = new javax.swing.JSpinner();
        child_panel15 = new javax.swing.JPanel();
        img15 = new javax.swing.JLabel();
        add15 = new javax.swing.JButton();
        name15 = new javax.swing.JLabel();
        price15 = new javax.swing.JLabel();
        qty15 = new javax.swing.JSpinner();
        child_panel16 = new javax.swing.JPanel();
        img16 = new javax.swing.JLabel();
        add16 = new javax.swing.JButton();
        name16 = new javax.swing.JLabel();
        price16 = new javax.swing.JLabel();
        qty16 = new javax.swing.JSpinner();
        child_panel17 = new javax.swing.JPanel();
        img17 = new javax.swing.JLabel();
        add17 = new javax.swing.JButton();
        name17 = new javax.swing.JLabel();
        price17 = new javax.swing.JLabel();
        qty17 = new javax.swing.JSpinner();
        child_panel18 = new javax.swing.JPanel();
        img18 = new javax.swing.JLabel();
        add18 = new javax.swing.JButton();
        name18 = new javax.swing.JLabel();
        price18 = new javax.swing.JLabel();
        qty18 = new javax.swing.JSpinner();
        child_panel19 = new javax.swing.JPanel();
        img19 = new javax.swing.JLabel();
        add19 = new javax.swing.JButton();
        name19 = new javax.swing.JLabel();
        price19 = new javax.swing.JLabel();
        qty19 = new javax.swing.JSpinner();
        child_panel20 = new javax.swing.JPanel();
        img20 = new javax.swing.JLabel();
        add20 = new javax.swing.JButton();
        name20 = new javax.swing.JLabel();
        price20 = new javax.swing.JLabel();
        qty20 = new javax.swing.JSpinner();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        name1.setText("Chicken Fried Veges");
        child_panel1.add(name1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 170, 30));

        price1.setBackground(new java.awt.Color(153, 0, 153));
        price1.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        price1.setText("$95/-");
        child_panel1.add(price1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 50, 30));
        child_panel1.add(qty1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 40, -1));

        cust.add(child_panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 180, 260));

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
        name2.setText("Fried Sprinkles");
        child_panel2.add(name2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 130, 30));

        price2.setBackground(new java.awt.Color(153, 0, 153));
        price2.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        price2.setText("$50/-");
        child_panel2.add(price2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 50, 30));
        child_panel2.add(qty2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 40, -1));

        cust.add(child_panel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, -1, 260));

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
        name3.setText("Chicken Noodles");
        child_panel3.add(name3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 140, 30));

        price3.setBackground(new java.awt.Color(153, 0, 153));
        price3.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        price3.setText("$40/-");
        child_panel3.add(price3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 50, 30));
        child_panel3.add(qty3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 40, -1));

        cust.add(child_panel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 150, -1, 260));

        Cart_btn.setBackground(new java.awt.Color(255, 255, 0));
        Cart_btn.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        Cart_btn.setText("Cart");
        Cart_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cart_btnActionPerformed(evt);
            }
        });
        cust.add(Cart_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 60, -1, -1));

        count_Of_Product.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        cust.add(count_Of_Product, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 60, 40, 30));

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
        name4.setText("Baked Meat ");
        child_panel4.add(name4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 130, 30));

        price4.setBackground(new java.awt.Color(153, 0, 153));
        price4.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        price4.setText("$10/-");
        child_panel4.add(price4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 50, 30));
        child_panel4.add(qty4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 40, -1));

        cust.add(child_panel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 150, -1, 260));

        child_panel5.setBackground(new java.awt.Color(153, 153, 255));
        child_panel5.setForeground(new java.awt.Color(204, 204, 255));
        child_panel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        img5.setBackground(new java.awt.Color(153, 0, 153));
        img5.setText("jLabel1");
        child_panel5.add(img5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 160, 130));

        add5.setBackground(new java.awt.Color(0, 204, 0));
        add5.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        add5.setText("Add to Cart");
        add5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add5ActionPerformed(evt);
            }
        });
        child_panel5.add(add5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, -1));

        name5.setBackground(new java.awt.Color(153, 0, 153));
        name5.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        name5.setText("Beaf Soup veges");
        child_panel5.add(name5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 160, 30));

        price5.setBackground(new java.awt.Color(153, 0, 153));
        price5.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        price5.setText("$70/-");
        child_panel5.add(price5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 50, 30));
        child_panel5.add(qty5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 40, -1));

        cust.add(child_panel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 150, -1, 260));

        jLabel2.setIcon(new javax.swing.ImageIcon("E:\\Food\\cheff6.png")); // NOI18N
        cust.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, -10, -1, -1));

        id.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        id.setText("ID:-");
        cust.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 20, 170, 16));

        cust_name.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        cust.add(cust_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, 170, 16));

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

        child_panel6.setBackground(new java.awt.Color(204, 153, 255));
        child_panel6.setForeground(new java.awt.Color(204, 204, 255));
        child_panel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        img6.setBackground(new java.awt.Color(153, 0, 153));
        img6.setText("jLabel1");
        child_panel6.add(img6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 160, 130));

        add6.setBackground(new java.awt.Color(0, 204, 0));
        add6.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        add6.setText("Add to Cart");
        add6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add6ActionPerformed(evt);
            }
        });
        child_panel6.add(add6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, -1));

        name6.setBackground(new java.awt.Color(153, 0, 153));
        name6.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        name6.setText("Egg Fried Rice");
        child_panel6.add(name6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 120, 30));

        price6.setBackground(new java.awt.Color(153, 0, 153));
        price6.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        price6.setText("$25/-");
        child_panel6.add(price6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 50, 30));
        child_panel6.add(qty6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 40, -1));

        cust.add(child_panel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 460, -1, 260));

        record.setBackground(new java.awt.Color(0, 0, 204));
        record.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        record.setForeground(new java.awt.Color(255, 255, 255));
        record.setText("Receipt");
        record.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recordActionPerformed(evt);
            }
        });
        cust.add(record, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 20, 100, 40));

        child_panel7.setBackground(new java.awt.Color(255, 153, 255));
        child_panel7.setForeground(new java.awt.Color(204, 204, 255));
        child_panel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        img7.setBackground(new java.awt.Color(153, 0, 153));
        img7.setText("jLabel1");
        child_panel7.add(img7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 160, 130));

        add7.setBackground(new java.awt.Color(0, 204, 0));
        add7.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        add7.setText("Add to Cart");
        add7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add7ActionPerformed(evt);
            }
        });
        child_panel7.add(add7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, -1));

        name7.setBackground(new java.awt.Color(153, 0, 153));
        name7.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        name7.setText("Milk Tea");
        child_panel7.add(name7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 80, 30));

        price7.setBackground(new java.awt.Color(153, 0, 153));
        price7.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        price7.setText("$65/-");
        child_panel7.add(price7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 50, 30));
        child_panel7.add(qty7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 40, -1));

        cust.add(child_panel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 460, 180, 260));

        child_panel8.setBackground(new java.awt.Color(153, 255, 255));
        child_panel8.setForeground(new java.awt.Color(204, 204, 255));
        child_panel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        img8.setBackground(new java.awt.Color(153, 0, 153));
        img8.setText("jLabel1");
        child_panel8.add(img8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 160, 130));

        add8.setBackground(new java.awt.Color(0, 204, 0));
        add8.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        add8.setText("Add to Cart");
        add8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add8ActionPerformed(evt);
            }
        });
        child_panel8.add(add8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, -1));

        name8.setBackground(new java.awt.Color(153, 0, 153));
        name8.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        name8.setText("Chicken Soya rice");
        child_panel8.add(name8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 150, 30));

        price8.setBackground(new java.awt.Color(153, 0, 153));
        price8.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        price8.setText("$60/-");
        child_panel8.add(price8, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 50, 30));
        child_panel8.add(qty8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 40, -1));

        cust.add(child_panel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 460, -1, 260));

        child_panel9.setBackground(new java.awt.Color(255, 255, 102));
        child_panel9.setForeground(new java.awt.Color(204, 204, 255));
        child_panel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        img9.setBackground(new java.awt.Color(153, 0, 153));
        img9.setText("jLabel1");
        child_panel9.add(img9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 160, 130));

        add9.setBackground(new java.awt.Color(0, 204, 0));
        add9.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        add9.setText("Add to Cart");
        add9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add9ActionPerformed(evt);
            }
        });
        child_panel9.add(add9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, -1));

        name9.setBackground(new java.awt.Color(153, 0, 153));
        name9.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        name9.setText("Boiled Egg Noodles");
        child_panel9.add(name9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 160, 30));

        price9.setBackground(new java.awt.Color(153, 0, 153));
        price9.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        price9.setText("$50/-");
        child_panel9.add(price9, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 50, 30));
        child_panel9.add(qty9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 40, -1));

        cust.add(child_panel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 460, -1, 260));

        child_panel11.setBackground(new java.awt.Color(102, 153, 255));
        child_panel11.setForeground(new java.awt.Color(204, 204, 255));
        child_panel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        img11.setBackground(new java.awt.Color(153, 0, 153));
        img11.setText("jLabel1");
        child_panel11.add(img11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 160, 130));

        add11.setBackground(new java.awt.Color(0, 204, 0));
        add11.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        add11.setText("Add to Cart");
        add11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add11ActionPerformed(evt);
            }
        });
        child_panel11.add(add11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, -1));

        name11.setBackground(new java.awt.Color(153, 0, 153));
        name11.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        name11.setText("Fish Curry Fries");
        child_panel11.add(name11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 150, 30));

        price11.setBackground(new java.awt.Color(153, 0, 153));
        price11.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        price11.setText("$50/-");
        child_panel11.add(price11, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 50, 30));
        child_panel11.add(qty11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 40, -1));

        cust.add(child_panel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 760, -1, 260));

        child_panel10.setBackground(new java.awt.Color(102, 255, 153));
        child_panel10.setForeground(new java.awt.Color(204, 204, 255));
        child_panel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        img10.setBackground(new java.awt.Color(153, 0, 153));
        img10.setText("jLabel1");
        child_panel10.add(img10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 160, 130));

        add10.setBackground(new java.awt.Color(0, 204, 0));
        add10.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        add10.setText("Add to Cart");
        add10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add10ActionPerformed(evt);
            }
        });
        child_panel10.add(add10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, -1));

        name10.setBackground(new java.awt.Color(153, 0, 153));
        name10.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        name10.setText("Meat Naan Veges");
        child_panel10.add(name10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 140, 30));

        price10.setBackground(new java.awt.Color(153, 0, 153));
        price10.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        price10.setText("$40/-");
        child_panel10.add(price10, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 50, 30));
        child_panel10.add(qty10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 40, -1));

        cust.add(child_panel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 460, -1, 260));

        child_panel12.setBackground(new java.awt.Color(153, 153, 255));
        child_panel12.setForeground(new java.awt.Color(204, 204, 255));
        child_panel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        img12.setBackground(new java.awt.Color(153, 0, 153));
        img12.setText("jLabel1");
        child_panel12.add(img12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 160, 130));

        add12.setBackground(new java.awt.Color(0, 204, 0));
        add12.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        add12.setText("Add to Cart");
        add12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add12ActionPerformed(evt);
            }
        });
        child_panel12.add(add12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, -1));

        name12.setBackground(new java.awt.Color(153, 0, 153));
        name12.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        name12.setText("Chicken Curry");
        child_panel12.add(name12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 130, 30));

        price12.setBackground(new java.awt.Color(153, 0, 153));
        price12.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        price12.setText("$75/-");
        child_panel12.add(price12, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 50, 30));
        child_panel12.add(qty12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 40, -1));

        cust.add(child_panel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 760, -1, 260));

        child_panel13.setBackground(new java.awt.Color(255, 153, 102));
        child_panel13.setForeground(new java.awt.Color(204, 204, 255));
        child_panel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        img13.setBackground(new java.awt.Color(153, 0, 153));
        img13.setText("jLabel1");
        child_panel13.add(img13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 160, 130));

        add13.setBackground(new java.awt.Color(0, 204, 0));
        add13.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        add13.setText("Add to Cart");
        add13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add13ActionPerformed(evt);
            }
        });
        child_panel13.add(add13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, -1));

        name13.setBackground(new java.awt.Color(153, 0, 153));
        name13.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        name13.setText("Soya fish Veges");
        child_panel13.add(name13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 140, 30));

        price13.setBackground(new java.awt.Color(153, 0, 153));
        price13.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        price13.setText("$55/-");
        child_panel13.add(price13, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 50, 30));
        child_panel13.add(qty13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 40, -1));

        cust.add(child_panel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 760, -1, 260));

        child_panel14.setBackground(new java.awt.Color(255, 102, 204));
        child_panel14.setForeground(new java.awt.Color(204, 204, 255));
        child_panel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        img14.setBackground(new java.awt.Color(153, 0, 153));
        img14.setText("jLabel1");
        child_panel14.add(img14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 160, 130));

        add14.setBackground(new java.awt.Color(0, 204, 0));
        add14.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        add14.setText("Add to Cart");
        add14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add14ActionPerformed(evt);
            }
        });
        child_panel14.add(add14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, -1));

        name14.setBackground(new java.awt.Color(153, 0, 153));
        name14.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        name14.setText("Chicken Barbeque");
        child_panel14.add(name14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 160, 30));

        price14.setBackground(new java.awt.Color(153, 0, 153));
        price14.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        price14.setText("$85/-");
        child_panel14.add(price14, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 50, 30));
        child_panel14.add(qty14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 40, -1));

        cust.add(child_panel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 760, -1, 260));

        child_panel15.setBackground(new java.awt.Color(153, 51, 255));
        child_panel15.setForeground(new java.awt.Color(204, 204, 255));
        child_panel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        img15.setBackground(new java.awt.Color(153, 0, 153));
        img15.setText("jLabel1");
        child_panel15.add(img15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 160, 130));

        add15.setBackground(new java.awt.Color(0, 204, 0));
        add15.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        add15.setText("Add to Cart");
        add15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add15ActionPerformed(evt);
            }
        });
        child_panel15.add(add15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, -1));

        name15.setBackground(new java.awt.Color(153, 0, 153));
        name15.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        name15.setText("Chicken Burger");
        child_panel15.add(name15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 130, 30));

        price15.setBackground(new java.awt.Color(153, 0, 153));
        price15.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        price15.setText("$40/-");
        child_panel15.add(price15, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 50, 30));
        child_panel15.add(qty15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 40, -1));

        cust.add(child_panel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 760, -1, 260));

        child_panel16.setBackground(new java.awt.Color(0, 255, 153));
        child_panel16.setForeground(new java.awt.Color(204, 204, 255));
        child_panel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        img16.setBackground(new java.awt.Color(153, 0, 153));
        img16.setText("jLabel1");
        child_panel16.add(img16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 160, 130));

        add16.setBackground(new java.awt.Color(0, 204, 0));
        add16.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        add16.setText("Add to Cart");
        add16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add16ActionPerformed(evt);
            }
        });
        child_panel16.add(add16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, -1));

        name16.setBackground(new java.awt.Color(153, 0, 153));
        name16.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        name16.setText("Fish Curry Rice");
        child_panel16.add(name16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 150, 30));

        price16.setBackground(new java.awt.Color(153, 0, 153));
        price16.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        price16.setText("$60/-");
        child_panel16.add(price16, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 50, 30));
        child_panel16.add(qty16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 40, -1));

        cust.add(child_panel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1060, -1, 260));

        child_panel17.setBackground(new java.awt.Color(255, 153, 204));
        child_panel17.setForeground(new java.awt.Color(204, 204, 255));
        child_panel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        img17.setBackground(new java.awt.Color(153, 0, 153));
        img17.setText("jLabel1");
        child_panel17.add(img17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 160, 130));

        add17.setBackground(new java.awt.Color(0, 204, 0));
        add17.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        add17.setText("Add to Cart");
        add17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add17ActionPerformed(evt);
            }
        });
        child_panel17.add(add17, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, -1));

        name17.setBackground(new java.awt.Color(153, 0, 153));
        name17.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        name17.setText("Fish Veges");
        child_panel17.add(name17, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 150, 30));

        price17.setBackground(new java.awt.Color(153, 0, 153));
        price17.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        price17.setText("$40/-");
        child_panel17.add(price17, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 50, 30));
        child_panel17.add(qty17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 40, -1));

        cust.add(child_panel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 1060, -1, 260));

        child_panel18.setBackground(new java.awt.Color(102, 102, 255));
        child_panel18.setForeground(new java.awt.Color(204, 204, 255));
        child_panel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        img18.setBackground(new java.awt.Color(153, 0, 153));
        img18.setText("jLabel1");
        child_panel18.add(img18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 160, 130));

        add18.setBackground(new java.awt.Color(0, 204, 0));
        add18.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        add18.setText("Add to Cart");
        add18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add18ActionPerformed(evt);
            }
        });
        child_panel18.add(add18, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, -1));

        name18.setBackground(new java.awt.Color(153, 0, 153));
        name18.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        name18.setText("Chicken Cheese ");
        child_panel18.add(name18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 130, 30));

        price18.setBackground(new java.awt.Color(153, 0, 153));
        price18.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        price18.setText("$75/-");
        child_panel18.add(price18, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 50, 30));
        child_panel18.add(qty18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 40, -1));

        cust.add(child_panel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 1060, -1, 260));

        child_panel19.setBackground(new java.awt.Color(255, 204, 153));
        child_panel19.setForeground(new java.awt.Color(204, 204, 255));
        child_panel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        img19.setBackground(new java.awt.Color(153, 0, 153));
        img19.setText("jLabel1");
        child_panel19.add(img19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 160, 130));

        add19.setBackground(new java.awt.Color(0, 204, 0));
        add19.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        add19.setText("Add to Cart");
        add19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add19ActionPerformed(evt);
            }
        });
        child_panel19.add(add19, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, -1));

        name19.setBackground(new java.awt.Color(153, 0, 153));
        name19.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        name19.setText("Egg With Veges");
        child_panel19.add(name19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 130, 30));

        price19.setBackground(new java.awt.Color(153, 0, 153));
        price19.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        price19.setText("$90/-");
        child_panel19.add(price19, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 50, 30));
        child_panel19.add(qty19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 40, -1));

        cust.add(child_panel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 1060, -1, 260));

        child_panel20.setBackground(new java.awt.Color(153, 102, 255));
        child_panel20.setForeground(new java.awt.Color(204, 204, 255));
        child_panel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        img20.setBackground(new java.awt.Color(153, 0, 153));
        img20.setText("jLabel1");
        child_panel20.add(img20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 160, 130));

        add20.setBackground(new java.awt.Color(0, 204, 0));
        add20.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        add20.setText("Add to Cart");
        add20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add20ActionPerformed(evt);
            }
        });
        child_panel20.add(add20, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, -1));

        name20.setBackground(new java.awt.Color(153, 0, 153));
        name20.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        name20.setText("Chicken legs");
        child_panel20.add(name20, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 130, 30));

        price20.setBackground(new java.awt.Color(153, 0, 153));
        price20.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        price20.setText("$70/-");
        child_panel20.add(price20, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 50, 30));
        child_panel20.add(qty20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 40, -1));

        cust.add(child_panel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 1060, -1, 260));

        add(cust, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1340, 1540));
    }// </editor-fold>//GEN-END:initComponents

    private void add1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add1ActionPerformed
        addToCart(child_panel1);
    }//GEN-LAST:event_add1ActionPerformed

    private void add2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add2ActionPerformed
        addToCart(child_panel2);
    }//GEN-LAST:event_add2ActionPerformed

    private void add3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add3ActionPerformed
        addToCart(child_panel3);
    }//GEN-LAST:event_add3ActionPerformed

    private void Cart_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cart_btnActionPerformed
        if (cartItems.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please add at least one product to cart.");
            return; // Exit the method if the cart is empty
        }

        try {
            // Calculate total net value
            double totalNetValue = calculateTotalNetValue();

            // Get the user ID from the id label
            // Extract the numerical part of the ID text
            String idText = id.getText();
            String numericalId = idText.replaceAll("[^0-9]", ""); // Remove non-numeric characters
            int userId = Integer.parseInt(numericalId);

            // Insert order details into the orders table
            String orderSql = "INSERT INTO orders (customer_id, total_net_value) VALUES (?, ?)";
            PreparedStatement orderPs = con.prepareStatement(orderSql, Statement.RETURN_GENERATED_KEYS);
            orderPs.setInt(1, userId);
            orderPs.setDouble(2, totalNetValue);
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

            // Reset UI components
            resetAllJSpinners(this);
            resetAllCountOfProductTextFields(this);
            cartItems.clear();
            totalClicks = 0;

            // Display success message
            JOptionPane.showMessageDialog(this, "Order placed successfully.");
            //          addToCart(this);
            // Proceed to the Payment form
            // Proceed to the Payment form
            // Assuming cartItems is defined and populated in the Cart_btnActionPerformed method
            Payment paymentForm = new Payment(child2, this, null); // Pass the cartItems data
            paymentForm.setUserId(userId); // Set the user ID
            Jload.jPanelLoader(child2, paymentForm);
            //
            //        Jload.jPanelLoader(child2, paymentForm);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: Failed to place order.");
        }
    }//GEN-LAST:event_Cart_btnActionPerformed

    private void add4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add4ActionPerformed
        addToCart(child_panel4);
    }//GEN-LAST:event_add4ActionPerformed

    private void add5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add5ActionPerformed
        addToCart(child_panel5);
    }//GEN-LAST:event_add5ActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to go back?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            // Navigate back to Emp_Panel using the reference
            dash.goToChild2();
        }
    }//GEN-LAST:event_backActionPerformed

    private void add6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add6ActionPerformed
        addToCart(child_panel6);
    }//GEN-LAST:event_add6ActionPerformed

    private void recordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recordActionPerformed
        if (cartItems.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please add at least one product to the cart.");
            return;
        }
        // Create and display the Receipt panel with the cart items and other necessary parameters
        Receipt receipt = new Receipt(child2,this , null, userID, cartItems);
        Jload.jPanelLoader(child2, receipt);

    }//GEN-LAST:event_recordActionPerformed

    private void add7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add7ActionPerformed
        addToCart(child_panel7);
    }//GEN-LAST:event_add7ActionPerformed

    private void add8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add8ActionPerformed
        addToCart(child_panel8);
    }//GEN-LAST:event_add8ActionPerformed

    private void add9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add9ActionPerformed
        addToCart(child_panel9);
    }//GEN-LAST:event_add9ActionPerformed

    private void add10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add10ActionPerformed
        addToCart(child_panel10);
    }//GEN-LAST:event_add10ActionPerformed

    private void add11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add11ActionPerformed
        addToCart(child_panel11);
    }//GEN-LAST:event_add11ActionPerformed

    private void add12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add12ActionPerformed
        addToCart(child_panel12);
    }//GEN-LAST:event_add12ActionPerformed

    private void add13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add13ActionPerformed
        addToCart(child_panel13);
    }//GEN-LAST:event_add13ActionPerformed

    private void add14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add14ActionPerformed
        addToCart(child_panel14);
    }//GEN-LAST:event_add14ActionPerformed

    private void add15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add15ActionPerformed
        addToCart(child_panel15);
    }//GEN-LAST:event_add15ActionPerformed

    private void add16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add16ActionPerformed
        addToCart(child_panel16);
    }//GEN-LAST:event_add16ActionPerformed

    private void add17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add17ActionPerformed
        addToCart(child_panel17);
    }//GEN-LAST:event_add17ActionPerformed

    private void add18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add18ActionPerformed
        addToCart(child_panel18);
    }//GEN-LAST:event_add18ActionPerformed

    private void add19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add19ActionPerformed
        addToCart(child_panel19);
    }//GEN-LAST:event_add19ActionPerformed

    private void add20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add20ActionPerformed
        addToCart(child_panel20);
    }//GEN-LAST:event_add20ActionPerformed
    private void resetAllJSpinners(Container container) {
    for (Component comp : container.getComponents()) {
        if (comp instanceof JSpinner) {
            JSpinner spinner = (JSpinner) comp;
            spinner.setValue(0);
        } else if (comp instanceof Container) {
            resetAllJSpinners((Container) comp); // Recursively search in nested containers
        }
    }
}


private void resetAllCountOfProductTextFields(Container container) {
    for (Component comp : container.getComponents()) {
        if (comp instanceof JTextField) {
            JTextField textField = (JTextField) comp;
            if ("count_Of_Product".equals(textField.getName())) {
//                textField.setText("0");
              count_Of_Product.setText("0");
            }
        } else if (comp instanceof Container) {
            resetAllCountOfProductTextFields((Container) comp); // Recursively search in nested containers
        }
    }
}
private void addToCartRecord(int orderId, String name, double price, int quantity, double netValue) {
    try {
        // Insert details into the order_items table
        String sql = "INSERT INTO order_items (order_id, name, price, quantity, net_value) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, orderId);
        ps.setString(2, name); // Set the name directly without any modifications
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
    double taxRate = 0.10; // 10 percent tax rate
    for (Map<String, Object> item : cartItems) {
        double netValue = (double) item.get("net_value");
        totalNetValue += netValue;
    }
    // Apply tax
    totalNetValue *= (1 + taxRate); // Increase total net value by tax rate
    return totalNetValue;
}



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cart_btn;
    private javax.swing.JButton add1;
    private javax.swing.JButton add10;
    private javax.swing.JButton add11;
    private javax.swing.JButton add12;
    private javax.swing.JButton add13;
    private javax.swing.JButton add14;
    private javax.swing.JButton add15;
    private javax.swing.JButton add16;
    private javax.swing.JButton add17;
    private javax.swing.JButton add18;
    private javax.swing.JButton add19;
    private javax.swing.JButton add2;
    private javax.swing.JButton add20;
    private javax.swing.JButton add3;
    private javax.swing.JButton add4;
    private javax.swing.JButton add5;
    private javax.swing.JButton add6;
    private javax.swing.JButton add7;
    private javax.swing.JButton add8;
    private javax.swing.JButton add9;
    private javax.swing.JButton back;
    private javax.swing.JPanel child_panel1;
    private javax.swing.JPanel child_panel10;
    private javax.swing.JPanel child_panel11;
    private javax.swing.JPanel child_panel12;
    private javax.swing.JPanel child_panel13;
    private javax.swing.JPanel child_panel14;
    private javax.swing.JPanel child_panel15;
    private javax.swing.JPanel child_panel16;
    private javax.swing.JPanel child_panel17;
    private javax.swing.JPanel child_panel18;
    private javax.swing.JPanel child_panel19;
    private javax.swing.JPanel child_panel2;
    private javax.swing.JPanel child_panel20;
    private javax.swing.JPanel child_panel3;
    private javax.swing.JPanel child_panel4;
    private javax.swing.JPanel child_panel5;
    private javax.swing.JPanel child_panel6;
    private javax.swing.JPanel child_panel7;
    private javax.swing.JPanel child_panel8;
    private javax.swing.JPanel child_panel9;
    private javax.swing.JTextField count_Of_Product;
    private javax.swing.JPanel cust;
    private javax.swing.JLabel cust_name;
    private javax.swing.JLabel id;
    private javax.swing.JLabel img1;
    private javax.swing.JLabel img10;
    private javax.swing.JLabel img11;
    private javax.swing.JLabel img12;
    private javax.swing.JLabel img13;
    private javax.swing.JLabel img14;
    private javax.swing.JLabel img15;
    private javax.swing.JLabel img16;
    private javax.swing.JLabel img17;
    private javax.swing.JLabel img18;
    private javax.swing.JLabel img19;
    private javax.swing.JLabel img2;
    private javax.swing.JLabel img20;
    private javax.swing.JLabel img3;
    private javax.swing.JLabel img4;
    private javax.swing.JLabel img5;
    private javax.swing.JLabel img6;
    private javax.swing.JLabel img7;
    private javax.swing.JLabel img8;
    private javax.swing.JLabel img9;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel name1;
    private javax.swing.JLabel name10;
    private javax.swing.JLabel name11;
    private javax.swing.JLabel name12;
    private javax.swing.JLabel name13;
    private javax.swing.JLabel name14;
    private javax.swing.JLabel name15;
    private javax.swing.JLabel name16;
    private javax.swing.JLabel name17;
    private javax.swing.JLabel name18;
    private javax.swing.JLabel name19;
    private javax.swing.JLabel name2;
    private javax.swing.JLabel name20;
    private javax.swing.JLabel name3;
    private javax.swing.JLabel name4;
    private javax.swing.JLabel name5;
    private javax.swing.JLabel name6;
    private javax.swing.JLabel name7;
    private javax.swing.JLabel name8;
    private javax.swing.JLabel name9;
    private javax.swing.JLabel price1;
    private javax.swing.JLabel price10;
    private javax.swing.JLabel price11;
    private javax.swing.JLabel price12;
    private javax.swing.JLabel price13;
    private javax.swing.JLabel price14;
    private javax.swing.JLabel price15;
    private javax.swing.JLabel price16;
    private javax.swing.JLabel price17;
    private javax.swing.JLabel price18;
    private javax.swing.JLabel price19;
    private javax.swing.JLabel price2;
    private javax.swing.JLabel price20;
    private javax.swing.JLabel price3;
    private javax.swing.JLabel price4;
    private javax.swing.JLabel price5;
    private javax.swing.JLabel price6;
    private javax.swing.JLabel price7;
    private javax.swing.JLabel price8;
    private javax.swing.JLabel price9;
    private javax.swing.JSpinner qty1;
    private javax.swing.JSpinner qty10;
    private javax.swing.JSpinner qty11;
    private javax.swing.JSpinner qty12;
    private javax.swing.JSpinner qty13;
    private javax.swing.JSpinner qty14;
    private javax.swing.JSpinner qty15;
    private javax.swing.JSpinner qty16;
    private javax.swing.JSpinner qty17;
    private javax.swing.JSpinner qty18;
    private javax.swing.JSpinner qty19;
    private javax.swing.JSpinner qty2;
    private javax.swing.JSpinner qty20;
    private javax.swing.JSpinner qty3;
    private javax.swing.JSpinner qty4;
    private javax.swing.JSpinner qty5;
    private javax.swing.JSpinner qty6;
    private javax.swing.JSpinner qty7;
    private javax.swing.JSpinner qty8;
    private javax.swing.JSpinner qty9;
    private javax.swing.JButton record;
    // End of variables declaration//GEN-END:variables
}
