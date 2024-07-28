/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package food_project2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author khushi pandey
 */
public class Payment extends javax.swing.JPanel {

   private final JPanel child2;
    private Menu_veg veg;
    private JpanelLoader Jload = new JpanelLoader();
    private int userId; // Add a variable to store the user ID
    private Non_Veg non ;
    private List<Map<String, Object>> cartItems; // Add car
    public  Payment(JPanel child2, Non_Veg non, Menu_veg veg) {
        initComponents();
        this.child2 = child2;
    this.veg = veg;
    this.non = non;
    this.cartItems = cartItems; // Store the cart items data

        // Remove default items from the combo box
        pay.removeAllItems();
        
        // Add new payment options
         pay.addItem("Select");
        pay.addItem("Cash");
        pay.addItem("Card");

        // Add ActionListener to the JComboBox pay
        pay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the selected item from the JComboBox
                String selectedPayment = pay.getSelectedItem().toString();

                // Check which payment option was selected
                if (selectedPayment.equalsIgnoreCase("Cash")) { // Make the comparison case insensitive
                    // Open Cash form and pass the user ID
                   Cash cashForm = new Cash(child2, Payment.this, userId); // Pass the user ID and cartItems
                Jload.jPanelLoader(child2, cashForm);
                } else if (selectedPayment.equalsIgnoreCase("Card")) { // Make the comparison case insensitive
                     //Open Card form
                     Bank card = new  Bank (child2, Payment.this,userId); // Assuming Card form constructor accepts JPanel and Payment objects
                     Jload.jPanelLoader(child2, card);
                } else if (selectedPayment.equals("Another Payment")) {
                    // Open Another Payment form
                    // AnotherPaymentForm anotherPaymentForm = new AnotherPaymentForm(); // Replace AnotherPaymentForm with the actual name of your Another Payment form
                    // anotherPaymentForm.setVisible(true);
                }
            }
        });
    }
   
     public void setUserId(int userId) {
        this.userId = userId; // Set the user ID received from the main form
        id.setText("User ID: " + userId);
    }

    public void goToChild2() {
        // Reload the main components of child2
        // You can implement this method according to your JPanel structure
        // For example:
        jPanelLoader(child2, Port); // Replace mainChild2Panel with your actual child2 main panel
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

        Port = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pay = new javax.swing.JComboBox<>();
        img = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        back = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Port.setBackground(new java.awt.Color(255, 255, 255));
        Port.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Sitka Text", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 153));
        jLabel1.setText("Choose Payement Method ");
        Port.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, -1, -1));

        pay.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        pay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Port.add(pay, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 80, 220, -1));

        img.setIcon(new javax.swing.ImageIcon("E:\\Food\\payment.png")); // NOI18N
        Port.add(img, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 190, 520, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon("E:\\Food\\cheff6.png")); // NOI18N
        Port.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, -20, -1, -1));

        id.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        id.setText("Customer ID:-");
        Port.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 220, -1));

        back.setBackground(new java.awt.Color(51, 51, 51));
        back.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        back.setForeground(new java.awt.Color(255, 255, 255));
        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        Port.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 30, 90, 40));

        add(Port, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1400, 780));
    }// </editor-fold>//GEN-END:initComponents

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
    private javax.swing.JPanel Port;
    private javax.swing.JButton back;
    private javax.swing.JLabel id;
    private javax.swing.JLabel img;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JComboBox<String> pay;
    // End of variables declaration//GEN-END:variables
}
