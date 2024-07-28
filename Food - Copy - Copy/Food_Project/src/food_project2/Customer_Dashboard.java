/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package food_project2;

import food_project.vMenu;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.sql.*;
import javax.swing.JLabel;
/**
 *
 * @author khushi pandey
 */
public class Customer_Dashboard extends javax.swing.JPanel {
private Timer timer;
private int id;
    private int imageIndex = 0;
    private ImageIcon[] images;
     private Timer marqueeTimer;
      private boolean isLoggedIn = false;
    
     Connection con = null;
   ResultSet rs = null;
   PreparedStatement ps = null;
  
    JpanelLoader Jload = new JpanelLoader();
    private JPanel child2;
    private Home homeFrame; // Add reference to Home frame

private final int marqueeSpeed = 5; // Adjust the speed as needed
private final int marqueeDirection = 1; // 1 for right, -1 for left
private int marqueeX = 0;

    public Customer_Dashboard(JPanel child2, Home  homeFrame) {
         initComponents();
         initializeSlideshow();
         this.child2 = child2;
        this.homeFrame = homeFrame; 
        startMarquee();
        con = food_project2.conn.mycon();   
         loadAndSetImage("E:\\Food\\not.png", notification);
             notification.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
        // Check if the user is logged in
        if (!isLoggedIn) {
            // Show a message prompting the user to login
            JOptionPane.showMessageDialog(Customer_Dashboard.this, "Please login to access notifications.");
            // Return without further action
            return;
        }

        // Open the Customer_Notification panel and pass the ID
        Customer_Notification notificationPanel = new Customer_Notification(child2, Customer_Dashboard.this, id);
        Jload.jPanelLoader(child2, notificationPanel);
    }
});


         
    }
    public void setLoggedIn(boolean isLoggedIn) {
    this.isLoggedIn = isLoggedIn;
}

    public void goToChild2() {
        // Reload the main components of child2
        // You can implement this method according to your JPanel structure
        // For example:
        jPanelLoader(child2, cust_pane); // Replace mainChild2Panel with your actual child2 main panel
    }
  public void jPanelLoader(JPanel parent, JPanel child) {
    parent.removeAll();
    parent.add(child);
    parent.revalidate();
    parent.repaint();
}
  private void startMarquee() {
    marqueeTimer = new Timer(20, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int width = jPanel3.getWidth(); // Adjust the panel width as needed
            if (marqueeDirection == 1) {
                marqueeX += marqueeSpeed;
                if (marqueeX >= width) {
                    marqueeX = -head.getWidth();
                }
            } else {
                marqueeX -= marqueeSpeed;
                if (marqueeX <= -head.getWidth()) {
                    marqueeX = width;
                }
            }
            head.setLocation(marqueeX, head.getY());
        }
    });
    marqueeTimer.start();
    
    choise.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose Categories Here!!", "Veg", "Non-Veg" }));
    

    }
private void initializeSlideshow() {
        slide_imgs.setSize(1530, 650);
        images = new ImageIcon[10]; // Change the size according to the number of images
        images[0] = resizeImageIcon(new ImageIcon("E:\\Food\\food23.jpeg"));
        images[1] = resizeImageIcon(new ImageIcon("E:\\Food\\food26.jpeg"));
        images[2] = resizeImageIcon(new ImageIcon("E:\\Food\\food27.jpeg"));
        images[3] = resizeImageIcon(new ImageIcon("E:\\Food\\food25.jpeg"));
        images[4] = resizeImageIcon(new ImageIcon("E:\\Food\\f6.jpg"));
        images[5] = resizeImageIcon(new ImageIcon("E:\\Food\\f3.jpg"));
        images[6] = resizeImageIcon(new ImageIcon("E:\\Food\\food31.jpeg"));
        images[7] = resizeImageIcon(new ImageIcon("E:\\Food\\food28.jpeg"));
        images[8] = resizeImageIcon(new ImageIcon("E:\\Food\\f11.jpg"));
        images[9] = resizeImageIcon(new ImageIcon("E:\\Food\\f7.jpg"));

        Timer timer = new Timer(1000, new ActionListener() {
            int imageIndex = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                slide_imgs.setIcon(images[imageIndex]);
                imageIndex = (imageIndex + 1) % images.length;
            }
        });
        timer.start();
    }

    private ImageIcon resizeImageIcon(ImageIcon icon) {
        Image img = icon.getImage();
        int labelWidth = slide_imgs.getWidth();
        int labelHeight = slide_imgs.getHeight();

        // Create a new image with the label's dimensions
        BufferedImage resizedImg = new BufferedImage(labelWidth, labelHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = resizedImg.createGraphics();

        // Draw the original image onto the resized image
        g2d.drawImage(img, 0, 0, labelWidth, labelHeight, null);
        g2d.dispose();

        return new ImageIcon(resizedImg);
    }
    private void loadAndSetImage(String imagePath, JLabel label) {
    int width = 30; // Fixed width for all images
    int height = 20; // Fixed height for all images
    ImageIcon icon = new ImageIcon(imagePath);
    Image scaledImage = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
    label.setIcon(new ImageIcon(scaledImage));
}
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cust_pane = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        head = new javax.swing.JLabel();
        slide_imgs = new javax.swing.JLabel();
        Nav = new javax.swing.JPanel();
        login_btn = new javax.swing.JButton();
        choise = new javax.swing.JComboBox<>();
        notification = new javax.swing.JLabel();

        setBackground(new java.awt.Color(102, 102, 102));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cust_pane.setBackground(new java.awt.Color(102, 102, 102));
        cust_pane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel3.setForeground(new java.awt.Color(102, 102, 102));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(102, 102, 102));
        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, true));
        jPanel4.setForeground(new java.awt.Color(102, 102, 102));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        head.setBackground(new java.awt.Color(0, 0, 0));
        head.setFont(new java.awt.Font("Palatino Linotype", 3, 23)); // NOI18N
        head.setForeground(new java.awt.Color(255, 255, 255));
        head.setText("Get And Order All Delicious Food Here");
        jPanel4.add(head, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, -1, -1));

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 50));
        jPanel3.add(slide_imgs, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 1270, 600));

        cust_pane.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 1340, 680));

        Nav.setBackground(new java.awt.Color(255, 153, 153));
        Nav.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        Nav.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        login_btn.setBackground(new java.awt.Color(51, 51, 255));
        login_btn.setFont(new java.awt.Font("SimSun-ExtB", 1, 15)); // NOI18N
        login_btn.setForeground(new java.awt.Color(255, 255, 255));
        login_btn.setText("Login");
        login_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login_btnActionPerformed(evt);
            }
        });
        Nav.add(login_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 10, 80, 30));

        choise.setBackground(new java.awt.Color(204, 204, 255));
        choise.setFont(new java.awt.Font("UD Digi Kyokasho NK-R", 1, 13)); // NOI18N
        choise.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        choise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                choiseActionPerformed(evt);
            }
        });
        Nav.add(choise, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 200, 32));

        notification.setIcon(new javax.swing.ImageIcon("E:\\Food\\not.png")); // NOI18N
        notification.setText("jLabel1");
        Nav.add(notification, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 10, 30, 20));

        cust_pane.add(Nav, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1380, 40));

        add(cust_pane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1340, 720));
    }// </editor-fold>//GEN-END:initComponents

    private void login_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_login_btnActionPerformed
// Assuming the user is successfully logged in
    isLoggedIn = true;
    // Retrieve the username from the session
    String username = SessionManager.getCurrentUser();
    // Set the username in the session
    SessionManager.setCurrentUser(username);
    // Open Customer_login form or whatever your login process is
    Customer_login log = new Customer_login(child2, this);
    Jload.jPanelLoader(child2, log);

    // Fetch customer ID from the database based on the username
    try {
        String sql = "SELECT ID FROM Customer_Details WHERE username = ?";
        ps = con.prepareStatement(sql);
        ps.setString(1, username);
        rs = ps.executeQuery();
        if (rs.next()) {
            id = rs.getInt("ID");
        }
    } catch (SQLException e) {
        System.out.println("Error fetching customer ID: " + e.getMessage());
    }
   
    }//GEN-LAST:event_login_btnActionPerformed
     
    private void choiseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_choiseActionPerformed
      // Check if the user is logged in
    if (!isLoggedIn) {
        // Show a message prompting the user to login
        JOptionPane.showMessageDialog(this, "Please login to access this feature.");
        // Return without further action
        return;
    }
    
    String selectedOption = (String) choise.getSelectedItem();
    if (selectedOption.equals("Veg")) {
        // Retrieve the username from the session
        String username = SessionManager.getCurrentUser();
        
        try {
            String sql = "SELECT ID, Name FROM Customer_Details WHERE username = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            if (rs.next()) {
                int userID = rs.getInt("ID");
                String userName = rs.getString("Name");
                // Open Menu_veg JFrame for Veg and pass the userID and userName
                
                Menu_veg menu = new Menu_veg(child2, this, userID, userName);
                Jload.jPanelLoader(child2, menu); 
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    } else if (selectedOption.equals("Non-Veg")) {
        String username = SessionManager.getCurrentUser();
        try {
            String sql = "SELECT ID, Name FROM Customer_Details WHERE username = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            if (rs.next()) {
                int userID = rs.getInt("ID");
                String userName = rs.getString("Name");
                 //Open Menu_veg JFrame for Veg and pass the userID and userName
                Non_Veg menu = new Non_Veg(child2, this, userID, userName);
             Jload.jPanelLoader(child2, menu); 
    } else {
             JOptionPane.showMessageDialog(this, "Select Any Category of Food");    
            }
        } catch (Exception e) {
            System.out.println(e);
        }
         
        // Handle other options
        JOptionPane.showMessageDialog(this, "Selected option: " + selectedOption);
        // Add your logic here for handling other options
    }
    }//GEN-LAST:event_choiseActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Nav;
    private javax.swing.JComboBox<String> choise;
    private javax.swing.JPanel cust_pane;
    private javax.swing.JLabel head;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JButton login_btn;
    private javax.swing.JLabel notification;
    private javax.swing.JLabel slide_imgs;
    // End of variables declaration//GEN-END:variables
}
