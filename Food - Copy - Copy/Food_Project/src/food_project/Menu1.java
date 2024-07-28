/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package food_project;

import food_project.Receipt;
import food_project2.conn;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.sql.*;
//import java.awt.Image;
//import javax.swing.ImageIcon;
//import javax.swing.JLabel;

public class Menu1 extends javax.swing.JFrame {
private Map<JSpinner, Container> spinnerContainerMap;
  Connection con = null;
   ResultSet rs = null;
//   private int id;

   PreparedStatement pst = null;
    public Menu1() {
        con = conn.mycon(); 
       
        addActionListenerToCheckBoxes(child_panel1);
         addActionListenerToCheckBoxes(child_panel2);
        addActionListenerToCheckBoxes(child_panel3);
        addActionListenerToCheckBoxes(child_panel4);
        
        initComponents();
          JScrollPane scrollPane = new JScrollPane(getContentPane());
        setContentPane(scrollPane);
        
        child_panel1 = new javax.swing.JPanel();
        // Your existing code for child_panel1 goes here...

        child_panel3 = new javax.swing.JPanel();
        // Your existing code for child_panel2 goes here...

        child_panel4 = new javax.swing.JPanel();
        // Your existing code for child_panel3 goes here...

        total = new javax.swing.JButton(); // Changed name from totalBtn to total
        total.setText("Total");
         
         loadAndSetImage("E:\\Food\\f1.jpg", img1);
        loadAndSetImage("E:\\Food\\f2.jpg", img2);
        loadAndSetImage("E:\\Food\\f6.jpg", img3);
        loadAndSetImage("E:\\Food\\f3.jpg", img4);
//        loadAndSetImage("E:\\Food\\f5.jpg", img5);
//        loadAndSetImage("E:\\Food\\f6.jpg", img6);
//        loadAndSetImage("E:\\Food\\f7.jpg", img7);
//        loadAndSetImage("E:\\Food\\f8.jpg", img8);
//        loadAndSetImage("E:\\Food\\f11.jpg", img9);
//        loadAndSetImage("E:\\Food\\f10.jpg", img10);
//        loadAndSetImage("E:\\Food\\f11.jpg", img11);
//        loadAndSetImage("E:\\Food\\f12.jpg", img12);
        // component.setBounds(x, y, width, height);
          DefaultTableModel model = new DefaultTableModel(new Object[][]{}, new String[]{"Item", "Qty", "Price", "Net Value"}) {
        @Override
        public boolean isCellEditable(int row, int column) {
            // Make cells non-editable for columns other than "Net Value"
            return column != 3;
        }
    };
          
    Record.setModel(model); // Set the custom model to the table

    // Set the header font size to 15px
    Record.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));

    // Center align all the cells in the table
    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
    centerRenderer.setHorizontalAlignment(JLabel.CENTER);
    Record.setDefaultRenderer(Object.class, centerRenderer);

         spinnerContainerMap = new HashMap<>();
        spinnerContainerMap.put(qty1, child_panel1);
        spinnerContainerMap.put(qty2, child_panel2);
        spinnerContainerMap.put(qty3, child_panel3);
        spinnerContainerMap.put(qty4, child_panel4);

        for (Map.Entry<JSpinner, Container> entry : spinnerContainerMap.entrySet()) {
            JSpinner spinner = entry.getKey();
            Container container = entry.getValue();
            spinner.addChangeListener(e -> updateQuantity(spinner, container));
        }

    }
       private void updateQuantity(JSpinner spinner, Container container) {
        DefaultTableModel model = (DefaultTableModel) Record.getModel();
        String productName = null;
        int quantity = (int) spinner.getValue();

        // Find the product name within the container
        for (Component comp : container.getComponents()) {
            if (comp instanceof JLabel) {
                JLabel label = (JLabel) comp;
                if (label.getText().equals("Name")) {
                    productName = label.getText();
                    break;
                }
            }
        }

        if (productName != null) {
            // Update the quantity in the table
            for (int i = 0; i < model.getRowCount(); i++) {
                if (model.getValueAt(i, 0).equals(productName)) {
                    model.setValueAt(quantity, i, 1); // Update quantity
                    int price = Integer.parseInt(model.getValueAt(i, 2).toString().substring(1)); // Extract price and remove '$' sign
                    int netValue = price * quantity;
                    model.setValueAt("$" + netValue, i, 3); // Update net value
                    break;
                }
            }
        }
    }
        private void loadAndSetImage(String imagePath, JLabel label) {
        ImageIcon icon = new ImageIcon(imagePath);
        Image scaledImage = icon.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        label.setIcon(scaledIcon);
    }

       
    private void addActionListenerToCheckBoxes(Container container) {
        if (container != null) {
            for (Component comp : container.getComponents()) {
                if (comp instanceof JCheckBox) {
                    ((JCheckBox) comp).addActionListener((java.awt.event.ActionEvent evt) -> {
                        JSpinner qtySpinner = (JSpinner) container.getComponent(7);
                        JLabel productNameLabel = (JLabel) container.getComponent(1);
                        JLabel priceLabel = (JLabel) container.getComponent(3);
//                        addToTable(container, qtySpinner, productNameLabel, priceLabel, (JCheckBox) comp);
                    });
                } else if (comp instanceof Container) {
                    addActionListenerToCheckBoxes((Container) comp);
                }
            }
        }
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        child_panel1 = new javax.swing.JPanel();
        q1 = new javax.swing.JLabel();
        price1 = new javax.swing.JLabel();
        buy1 = new javax.swing.JLabel();
        jSpinner3 = new javax.swing.JSpinner();
        n1 = new javax.swing.JLabel();
        p1 = new javax.swing.JLabel();
        name1 = new javax.swing.JLabel();
        qty1 = new javax.swing.JSpinner();
        check1 = new javax.swing.JCheckBox();
        img1 = new javax.swing.JLabel();
        total = new javax.swing.JButton();
        Receipt = new javax.swing.JButton();
        Reset = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        child_panel2 = new javax.swing.JPanel();
        q2 = new javax.swing.JLabel();
        price2 = new javax.swing.JLabel();
        buy2 = new javax.swing.JLabel();
        jSpinner6 = new javax.swing.JSpinner();
        n2 = new javax.swing.JLabel();
        p2 = new javax.swing.JLabel();
        name2 = new javax.swing.JLabel();
        qty2 = new javax.swing.JSpinner();
        check2 = new javax.swing.JCheckBox();
        img2 = new javax.swing.JLabel();
        child_panel3 = new javax.swing.JPanel();
        q3 = new javax.swing.JLabel();
        price3 = new javax.swing.JLabel();
        buy3 = new javax.swing.JLabel();
        jSpinner4 = new javax.swing.JSpinner();
        n3 = new javax.swing.JLabel();
        p3 = new javax.swing.JLabel();
        name3 = new javax.swing.JLabel();
        qty3 = new javax.swing.JSpinner();
        check3 = new javax.swing.JCheckBox();
        img3 = new javax.swing.JLabel();
        child_panel4 = new javax.swing.JPanel();
        q4 = new javax.swing.JLabel();
        price4 = new javax.swing.JLabel();
        buy4 = new javax.swing.JLabel();
        jSpinner5 = new javax.swing.JSpinner();
        n4 = new javax.swing.JLabel();
        p4 = new javax.swing.JLabel();
        name4 = new javax.swing.JLabel();
        qty4 = new javax.swing.JSpinner();
        check4 = new javax.swing.JCheckBox();
        img4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Record = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        child_panel1.setBackground(new java.awt.Color(255, 153, 255));
        child_panel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        child_panel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        q1.setBackground(new java.awt.Color(153, 0, 153));
        q1.setFont(new java.awt.Font("SimHei", 1, 12)); // NOI18N
        q1.setText("Quantity");
        child_panel1.add(q1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 70, 30));

        price1.setBackground(new java.awt.Color(153, 0, 153));
        price1.setFont(new java.awt.Font("SimSun", 1, 12)); // NOI18N
        price1.setText("$50");
        child_panel1.add(price1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 30, 30));

        buy1.setBackground(new java.awt.Color(153, 0, 153));
        buy1.setFont(new java.awt.Font("SimHei", 1, 12)); // NOI18N
        buy1.setText("Purchase");
        child_panel1.add(buy1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 60, 30));
        child_panel1.add(jSpinner3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 360, -1, 320));

        n1.setBackground(new java.awt.Color(153, 0, 153));
        n1.setFont(new java.awt.Font("SimHei", 1, 12)); // NOI18N
        n1.setText("Name");
        child_panel1.add(n1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 40, 30));

        p1.setBackground(new java.awt.Color(153, 0, 153));
        p1.setFont(new java.awt.Font("SimHei", 1, 12)); // NOI18N
        p1.setText("Price");
        child_panel1.add(p1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 40, 30));

        name1.setBackground(new java.awt.Color(153, 0, 153));
        name1.setFont(new java.awt.Font("SimSun", 1, 12)); // NOI18N
        name1.setText("salad");
        child_panel1.add(name1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 40, 30));
        child_panel1.add(qty1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 40, -1));

        check1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check1ActionPerformed(evt);
            }
        });
        child_panel1.add(check1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, -1, -1));

        img1.setBackground(new java.awt.Color(153, 0, 153));
        img1.setText("jLabel1");
        child_panel1.add(img1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 170, 150));

        getContentPane().add(child_panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 190, 290));

        total.setBackground(new java.awt.Color(255, 0, 0));
        total.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        total.setForeground(new java.awt.Color(255, 255, 255));
        total.setText("Total");
        total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalActionPerformed(evt);
            }
        });
        getContentPane().add(total, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 700, -1, -1));

        Receipt.setBackground(new java.awt.Color(0, 204, 51));
        Receipt.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Receipt.setForeground(new java.awt.Color(255, 255, 255));
        Receipt.setText("Receipt");
        Receipt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReceiptActionPerformed(evt);
            }
        });
        getContentPane().add(Receipt, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 700, -1, -1));

        Reset.setBackground(new java.awt.Color(204, 0, 204));
        Reset.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Reset.setForeground(new java.awt.Color(255, 255, 255));
        Reset.setText("Reset");
        getContentPane().add(Reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 700, -1, -1));

        exit.setBackground(new java.awt.Color(0, 0, 204));
        exit.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        exit.setForeground(new java.awt.Color(255, 255, 255));
        exit.setText("Exit");
        getContentPane().add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 700, -1, -1));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Vivaldi", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(32, 163, 103));
        jLabel7.setText("K - Food");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 190, -1));

        child_panel2.setBackground(new java.awt.Color(255, 153, 153));
        child_panel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        child_panel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        q2.setBackground(new java.awt.Color(153, 0, 153));
        q2.setFont(new java.awt.Font("SimHei", 1, 12)); // NOI18N
        q2.setText("Quantity");
        child_panel2.add(q2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 70, 30));

        price2.setBackground(new java.awt.Color(153, 0, 153));
        price2.setFont(new java.awt.Font("SimSun", 1, 12)); // NOI18N
        price2.setText("$100");
        child_panel2.add(price2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 30, 30));

        buy2.setBackground(new java.awt.Color(153, 0, 153));
        buy2.setFont(new java.awt.Font("SimHei", 1, 12)); // NOI18N
        buy2.setText("Purchase");
        child_panel2.add(buy2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 60, 30));
        child_panel2.add(jSpinner6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 360, -1, 320));

        n2.setBackground(new java.awt.Color(153, 0, 153));
        n2.setFont(new java.awt.Font("SimHei", 1, 12)); // NOI18N
        n2.setText("Name");
        child_panel2.add(n2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 40, 30));

        p2.setBackground(new java.awt.Color(153, 0, 153));
        p2.setFont(new java.awt.Font("SimHei", 1, 12)); // NOI18N
        p2.setText("Price");
        child_panel2.add(p2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 40, 30));

        name2.setBackground(new java.awt.Color(153, 0, 153));
        name2.setFont(new java.awt.Font("SimSun", 1, 12)); // NOI18N
        name2.setText("Bread");
        child_panel2.add(name2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 40, 30));
        child_panel2.add(qty2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 40, -1));

        check2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check2ActionPerformed(evt);
            }
        });
        child_panel2.add(check2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, -1, -1));

        img2.setBackground(new java.awt.Color(153, 0, 153));
        img2.setText("jLabel1");
        child_panel2.add(img2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 170, 150));

        getContentPane().add(child_panel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 190, 290));

        child_panel3.setBackground(new java.awt.Color(153, 153, 255));
        child_panel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        child_panel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        q3.setBackground(new java.awt.Color(153, 0, 153));
        q3.setFont(new java.awt.Font("SimHei", 1, 12)); // NOI18N
        q3.setText("Quantity");
        child_panel3.add(q3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 70, 30));

        price3.setBackground(new java.awt.Color(153, 0, 153));
        price3.setFont(new java.awt.Font("SimSun", 1, 12)); // NOI18N
        price3.setText("$150");
        child_panel3.add(price3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 30, 30));

        buy3.setBackground(new java.awt.Color(153, 0, 153));
        buy3.setFont(new java.awt.Font("SimHei", 1, 12)); // NOI18N
        buy3.setText("Purchase");
        child_panel3.add(buy3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 60, 30));
        child_panel3.add(jSpinner4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 360, -1, 320));

        n3.setBackground(new java.awt.Color(153, 0, 153));
        n3.setFont(new java.awt.Font("SimHei", 1, 12)); // NOI18N
        n3.setText("Name");
        child_panel3.add(n3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 40, 30));

        p3.setBackground(new java.awt.Color(153, 0, 153));
        p3.setFont(new java.awt.Font("SimHei", 1, 12)); // NOI18N
        p3.setText("Price");
        child_panel3.add(p3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 40, 30));

        name3.setBackground(new java.awt.Color(153, 0, 153));
        name3.setFont(new java.awt.Font("SimSun", 1, 12)); // NOI18N
        name3.setText("Toats");
        child_panel3.add(name3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 40, 30));
        child_panel3.add(qty3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 40, -1));

        check3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check3ActionPerformed(evt);
            }
        });
        child_panel3.add(check3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, -1, -1));

        img3.setBackground(new java.awt.Color(153, 0, 153));
        img3.setText("jLabel1");
        child_panel3.add(img3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 170, 150));

        getContentPane().add(child_panel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 80, 190, 290));

        child_panel4.setBackground(new java.awt.Color(153, 204, 255));
        child_panel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        child_panel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        q4.setBackground(new java.awt.Color(153, 0, 153));
        q4.setFont(new java.awt.Font("SimHei", 1, 12)); // NOI18N
        q4.setText("Quantity");
        child_panel4.add(q4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 70, 30));

        price4.setBackground(new java.awt.Color(153, 0, 153));
        price4.setFont(new java.awt.Font("SimSun", 1, 12)); // NOI18N
        price4.setText("$70");
        child_panel4.add(price4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 30, 30));

        buy4.setBackground(new java.awt.Color(153, 0, 153));
        buy4.setFont(new java.awt.Font("SimHei", 1, 12)); // NOI18N
        buy4.setText("Purchase");
        child_panel4.add(buy4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 60, 30));
        child_panel4.add(jSpinner5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 360, -1, 320));

        n4.setBackground(new java.awt.Color(153, 0, 153));
        n4.setFont(new java.awt.Font("SimHei", 1, 12)); // NOI18N
        n4.setText("Name");
        child_panel4.add(n4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 40, 30));

        p4.setBackground(new java.awt.Color(153, 0, 153));
        p4.setFont(new java.awt.Font("SimHei", 1, 12)); // NOI18N
        p4.setText("Price");
        child_panel4.add(p4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 40, 30));

        name4.setBackground(new java.awt.Color(153, 0, 153));
        name4.setFont(new java.awt.Font("SimSun", 1, 12)); // NOI18N
        name4.setText("Spicy");
        child_panel4.add(name4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 40, 30));
        child_panel4.add(qty4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 40, -1));

        check4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check4ActionPerformed(evt);
            }
        });
        child_panel4.add(check4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, -1, -1));

        img4.setBackground(new java.awt.Color(153, 0, 153));
        img4.setText("jLabel1");
        child_panel4.add(img4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 170, 150));

        getContentPane().add(child_panel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 80, 190, 290));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Record.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Record.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(Record);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 380));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 80, 270, 780));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalActionPerformed

    }//GEN-LAST:event_totalActionPerformed



    
    private void check1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check1ActionPerformed
//         addToTable(child_panel1, qty1, name1, price1, check1);

    }//GEN-LAST:event_check1ActionPerformed

    private void check2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check2ActionPerformed
//        addToTable(child_panel2, qty2, name2, price2, check2);
    }//GEN-LAST:event_check2ActionPerformed

    private void check3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check3ActionPerformed
//         addToTable(child_panel3, qty3, name3, price3, check3);
    }//GEN-LAST:event_check3ActionPerformed

    private void check4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check4ActionPerformed
//         addToTable(child_panel4, qty4, name4, price4, check4);
    }//GEN-LAST:event_check4ActionPerformed

    private void ReceiptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReceiptActionPerformed
//        DefaultTableModel dataModel = (DefaultTableModel) Record.getModel();
//        Receipt receiptFrame = new Receipt(dataModel);
//        receiptFrame.setVisible(true);
    }//GEN-LAST:event_ReceiptActionPerformed

   

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
            java.util.logging.Logger.getLogger(Menu1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               new Menu1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Receipt;
    private javax.swing.JTable Record;
    private javax.swing.JButton Reset;
    private javax.swing.JLabel buy1;
    private javax.swing.JLabel buy2;
    private javax.swing.JLabel buy3;
    private javax.swing.JLabel buy4;
    private javax.swing.JCheckBox check1;
    private javax.swing.JCheckBox check2;
    private javax.swing.JCheckBox check3;
    private javax.swing.JCheckBox check4;
    private javax.swing.JPanel child_panel1;
    private javax.swing.JPanel child_panel2;
    private javax.swing.JPanel child_panel3;
    private javax.swing.JPanel child_panel4;
    private javax.swing.JButton exit;
    private javax.swing.JLabel img1;
    private javax.swing.JLabel img2;
    private javax.swing.JLabel img3;
    private javax.swing.JLabel img4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner3;
    private javax.swing.JSpinner jSpinner4;
    private javax.swing.JSpinner jSpinner5;
    private javax.swing.JSpinner jSpinner6;
    private javax.swing.JLabel n1;
    private javax.swing.JLabel n2;
    private javax.swing.JLabel n3;
    private javax.swing.JLabel n4;
    private javax.swing.JLabel name1;
    private javax.swing.JLabel name2;
    private javax.swing.JLabel name3;
    private javax.swing.JLabel name4;
    private javax.swing.JLabel p1;
    private javax.swing.JLabel p2;
    private javax.swing.JLabel p3;
    private javax.swing.JLabel p4;
    private javax.swing.JLabel price1;
    private javax.swing.JLabel price2;
    private javax.swing.JLabel price3;
    private javax.swing.JLabel price4;
    private javax.swing.JLabel q1;
    private javax.swing.JLabel q2;
    private javax.swing.JLabel q3;
    private javax.swing.JLabel q4;
    private javax.swing.JSpinner qty1;
    private javax.swing.JSpinner qty2;
    private javax.swing.JSpinner qty3;
    private javax.swing.JSpinner qty4;
    private javax.swing.JButton total;
    // End of variables declaration//GEN-END:variables
}


