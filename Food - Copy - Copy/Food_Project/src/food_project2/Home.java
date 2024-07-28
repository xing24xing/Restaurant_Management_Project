/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package food_project2;

import java.awt.BorderLayout;
import java.awt.Image;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
     import java.awt.Component;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;
public class Home extends javax.swing.JFrame {
 JpanelLoader Jload = new JpanelLoader();
  private final JPanel startingPanel; // Store the starting panel here
  private final Session session;
  Connection con = null;
  PreparedStatement ps = null;
  
    public Home() {
    setLayout(new BorderLayout());
    initComponents();
    this.setExtendedState(Home.MAXIMIZED_BOTH);
    session = Session.getInstance();
    updateButtonAvailability();
    startingPanel = Home_Pane;
    Register.setEnabled(false);
         Login.setEnabled(false);
    con = food_project2.conn.mycon();
    cust.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                custMouseClicked(evt);
            }
        });
        adm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                
                admMouseClicked(evt);
            }
        });

   // Hide all components of Home_Pane initially
       
        // Check if child2 is properly initialized
        if (child2 == null) {
            System.err.println("child2 panel is not initialized properly!");
        }
     loadAndSetImage("E:\\Food\\adm.png", img1);
       loadAndSetImage("E:\\Food\\customer_logo.png", img2);
    }

     public void setStartingPanel() {
        jPanelLoader(child2, startingPanel);
    }

     // Method to update button availability based on session state
    private void updateButtonAvailability() {
       boolean loggedIn = false;
    if (session != null) {
        loggedIn = session.isLoggedIn();
    } else {
        System.err.println("Session is null!");
    }
    admin.setEnabled(loggedIn);
    employee.setEnabled(loggedIn);
    rest_details.setEnabled(loggedIn);
    Customer.setEnabled(loggedIn);
    Delivery1.setEnabled(loggedIn);
    product.setEnabled(loggedIn);
    logout.setEnabled(loggedIn); // Enable logout button when logged in
    Register.setEnabled(!loggedIn);
    }

    public void loginSuccess(String username) {
        session.setLoggedIn(true); // Set session as active
    session.setUsername(username); // Set username
    updateButtonAvailability(); // Update button availability
    loginSuccess(); // Call the method to handle login success
    }
   private void custMouseClicked(java.awt.event.MouseEvent evt) {
    // Check if the user is currently using any feature other than the customer feature
    if (admin.isEnabled() || employee.isEnabled() || rest_details.isEnabled() || Delivery1.isEnabled() || Register.isEnabled() || Login.isEnabled() || product.isEnabled()) {
        // If yes, automatically log out
        logoutActionPerformed(new java.awt.event.ActionEvent(this, java.awt.event.ActionEvent.ACTION_PERFORMED, ""));
    }

    // Enable Customer button and disable all other buttons
    Customer.setEnabled(true);
    admin.setEnabled(false);
    employee.setEnabled(false);
    rest_details.setEnabled(false);
    Delivery1.setEnabled(false);
    logout.setEnabled(false);
    Register.setEnabled(false);
    Login.setEnabled(false);
    product.setEnabled(false);

    // Show the Home_Pane
    jPanelLoader(child2, Home_Pane);
}

private void admMouseClicked(java.awt.event.MouseEvent evt) {
    // Enable Customer button and disable all other buttons
    Customer.setEnabled(false);
    admin.setEnabled(false);
    employee.setEnabled(false);
    rest_details.setEnabled(false);
    Delivery1.setEnabled(false);
    logout.setEnabled(false);
    Register.setEnabled(true);
    Login.setEnabled(true);
    product.setEnabled(false);

    // Check if Home_Pane is already added to child2
    boolean homePaneAdded = false;
    for (Component comp : child2.getComponents()) {
        if (comp == Home_Pane) {
            homePaneAdded = true;
            break;
        }
    }

    // If Home_Pane is not added, add it to child2
    if (!homePaneAdded) {
        jPanelLoader(child2, Home_Pane);
    }
}



    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        product = new javax.swing.JToggleButton();
        employee = new javax.swing.JToggleButton();
        rest_details = new javax.swing.JToggleButton();
        Customer = new javax.swing.JToggleButton();
        Delivery1 = new javax.swing.JToggleButton();
        admin = new javax.swing.JToggleButton();
        child2 = new javax.swing.JPanel();
        Home_Pane = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        Admin_log = new javax.swing.JLabel();
        Tab_nav = new javax.swing.JTabbedPane();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Register = new javax.swing.JToggleButton();
        logo = new javax.swing.JLabel();
        Login = new javax.swing.JToggleButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        logout = new javax.swing.JToggleButton();
        img2 = new javax.swing.JLabel();
        img1 = new javax.swing.JLabel();
        adm = new javax.swing.JLabel();
        cust = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        product.setBackground(new java.awt.Color(255, 0, 0));
        product.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        product.setForeground(new java.awt.Color(255, 255, 255));
        product.setText("Product Details");
        product.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productActionPerformed(evt);
            }
        });
        jPanel1.add(product, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, 190, 50));

        employee.setBackground(new java.awt.Color(255, 0, 0));
        employee.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        employee.setForeground(new java.awt.Color(255, 255, 255));
        employee.setText("Employee");
        employee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeActionPerformed(evt);
            }
        });
        jPanel1.add(employee, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 190, 50));

        rest_details.setBackground(new java.awt.Color(255, 0, 0));
        rest_details.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        rest_details.setForeground(new java.awt.Color(255, 255, 255));
        rest_details.setText("Restaurant Details");
        rest_details.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rest_detailsActionPerformed(evt);
            }
        });
        jPanel1.add(rest_details, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 190, 50));

        Customer.setBackground(new java.awt.Color(255, 0, 0));
        Customer.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        Customer.setForeground(new java.awt.Color(255, 255, 255));
        Customer.setText("Customers");
        Customer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CustomerActionPerformed(evt);
            }
        });
        jPanel1.add(Customer, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 190, 50));

        Delivery1.setBackground(new java.awt.Color(255, 0, 0));
        Delivery1.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        Delivery1.setForeground(new java.awt.Color(255, 255, 255));
        Delivery1.setText("Delivery");
        jPanel1.add(Delivery1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 190, 50));

        admin.setBackground(new java.awt.Color(255, 0, 0));
        admin.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        admin.setForeground(new java.awt.Color(255, 255, 255));
        admin.setText("Admin");
        admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminActionPerformed(evt);
            }
        });
        jPanel1.add(admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 190, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 210, 710));

        child2.setBackground(new java.awt.Color(255, 255, 255));
        child2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        child2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Home_Pane.setBackground(new java.awt.Color(255, 255, 255));
        Home_Pane.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        Home_Pane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Rockwell", 1, 22)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 153));
        jLabel9.setText("Admin Registration");
        Home_Pane.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 280, 220, -1));

        Admin_log.setFont(new java.awt.Font("Rockwell", 1, 22)); // NOI18N
        Admin_log.setForeground(new java.awt.Color(0, 0, 153));
        Admin_log.setText("Admin Login");
        Home_Pane.add(Admin_log, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 370, -1, -1));

        Tab_nav.setBackground(new java.awt.Color(255, 0, 255));
        Tab_nav.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Tab_nav.setForeground(new java.awt.Color(51, 51, 51));
        Tab_nav.setFont(new java.awt.Font("Neue Haas Grotesk Text Pro", 1, 20)); // NOI18N

        jLabel4.setText("jLabel4");
        Tab_nav.addTab("Home", jLabel4);

        jLabel5.setText("jLabel5");
        Tab_nav.addTab("Enquiry", jLabel5);

        jLabel6.setText("jLabel6");
        Tab_nav.addTab("About us", jLabel6);

        Home_Pane.add(Tab_nav, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1340, 35));

        Register.setBackground(new java.awt.Color(204, 0, 0));
        Register.setFont(new java.awt.Font("UD Digi Kyokasho NP-B", 1, 18)); // NOI18N
        Register.setForeground(new java.awt.Color(255, 255, 255));
        Register.setText("Click to Register");
        Register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisterActionPerformed(evt);
            }
        });
        Home_Pane.add(Register, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 280, 210, 45));

        logo.setIcon(new javax.swing.ImageIcon("E:\\Food\\adm.png")); // NOI18N
        Home_Pane.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 30, -1, 210));

        Login.setBackground(new java.awt.Color(204, 0, 0));
        Login.setFont(new java.awt.Font("UD Digi Kyokasho NP-B", 1, 18)); // NOI18N
        Login.setForeground(new java.awt.Color(255, 255, 255));
        Login.setText("Click to Login");
        Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginActionPerformed(evt);
            }
        });
        Home_Pane.add(Login, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 370, 210, 45));
        Login.getAccessibleContext().setAccessibleDescription("");

        child2.add(Home_Pane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1340, 710));

        getContentPane().add(child2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, 1340, 710));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Vivaldi", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(32, 163, 103));
        jLabel7.setText("K - Food");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 190, -1));

        logout.setBackground(new java.awt.Color(0, 0, 204));
        logout.setFont(new java.awt.Font("Segoe UI Variable", 1, 16)); // NOI18N
        logout.setForeground(new java.awt.Color(255, 255, 255));
        logout.setText("Logout");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });
        jPanel3.add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(1420, 20, 100, 35));

        img2.setIcon(new javax.swing.ImageIcon("E:\\Food\\customer_logo.png")); // NOI18N
        jPanel3.add(img2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, 90, 65));

        img1.setIcon(new javax.swing.ImageIcon("E:\\Food\\adm.png")); // NOI18N
        jPanel3.add(img1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 0, 90, 65));

        adm.setFont(new java.awt.Font("Sitka Text", 0, 12)); // NOI18N
        adm.setText("Admin");
        jPanel3.add(adm, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, -1, -1));

        cust.setFont(new java.awt.Font("Sitka Text", 0, 12)); // NOI18N
        cust.setText("Customer");
        jPanel3.add(cust, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 60, -1, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1550, 90));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rest_detailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rest_detailsActionPerformed
    Rest_Details rest = new Rest_Details(child2);
    Jload.jPanelLoader(child2, rest);
         
    }//GEN-LAST:event_rest_detailsActionPerformed
 
    private void adminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminActionPerformed
    Admin_Dashboard adm = new Admin_Dashboard(child2,this);
    Jload.jPanelLoader(child2, adm);
    }//GEN-LAST:event_adminActionPerformed
 public void setButtonAvailability(boolean loggedIn) {
        // Enable or disable buttons based on login status
        admin.setEnabled(loggedIn);
        employee.setEnabled(loggedIn);
        rest_details.setEnabled(loggedIn);
         Customer.setEnabled(false);
        Delivery1.setEnabled(loggedIn);
        logout.setEnabled(loggedIn);
        Register.setEnabled(!loggedIn);
         product.setEnabled(loggedIn);
    }
private void loadAndSetImage(String imagePath, JLabel label) {
    int width = 70; // Fixed width for all images
    int height = 40; // Fixed height for all images
    ImageIcon icon = new ImageIcon(imagePath);
    Image scaledImage = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
    label.setIcon(new ImageIcon(scaledImage));
}
    public void loginSuccess() {
      session.setLoggedIn(true);
        updateButtonAvailability();
        setButtonAvailability(true);

        try {
            // Insert login activity into database
            String query = "INSERT INTO admin_logs (first_name, last_name, login_time) " +
                           "SELECT firstName, lastName, CURRENT_TIMESTAMP FROM admin WHERE username = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, session.getUsername());
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Login activity inserted successfully.");
            } else {
                System.err.println("No rows were inserted for username: " + session.getUsername());
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            // Close resources
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    private void employeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeActionPerformed
        Emp_Panel emp = new Emp_Panel(child2,this);
        Jload.jPanelLoader(child2, emp);
    }//GEN-LAST:event_employeeActionPerformed
   
    private void CustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CustomerActionPerformed
       Customer_Dashboard customer = new  Customer_Dashboard(child2,this);
         Jload.jPanelLoader(child2, customer);
    }//GEN-LAST:event_CustomerActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
    // Check if there is an active session
    if (!session.isLoggedIn()) {
        System.err.println("No active session found for username: " + session.getUsername());
        return;
    }

    String username = session.getUsername();
    System.out.println("Username from session: " + username); // Debugging info

    int choice = JOptionPane.showConfirmDialog(this, "Are you sure you want to log out?", "Logout Confirmation", JOptionPane.YES_NO_OPTION);
    if (choice == JOptionPane.YES_OPTION) {
        try {
            // Prepare a query to update the logout time for the current login session
            String updateQuery = "UPDATE admin_logs SET logout_time = CURRENT_TIMESTAMP WHERE first_name = (SELECT first_name FROM admin WHERE username = ?) AND last_name = (SELECT last_name FROM admin WHERE username = ?) AND login_time = (SELECT MAX(login_time) FROM admin_logs WHERE first_name = (SELECT first_name FROM admin WHERE username = ?) AND last_name = (SELECT last_name FROM admin WHERE username = ?) AND login_time IS NOT NULL AND logout_time IS NULL)";
            ps = con.prepareStatement(updateQuery);

            // Set the username as parameters for the query
            ps.setString(1, username);
            ps.setString(2, username);
            ps.setString(3, username);
            ps.setString(4, username);

            // Execute the update query
            int rowsAffected = ps.executeUpdate();

            // Debugging info
            System.out.println("Rows affected: " + rowsAffected);

            if (rowsAffected > 0) {
                System.out.println("Logout activity updated successfully.");
            } else {
                System.err.println("No matching record found for username: " + username);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            // Close resources
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // Reset session state
        session.setLoggedIn(false); // Set session as inactive
        session.setUsername(null); // Clear username
        updateButtonAvailability(); // Update button availability
        setStartingPanel(); // Set starting panel
        
    }
    }//GEN-LAST:event_logoutActionPerformed

    private void productActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productActionPerformed
        Profit_Company com = new Profit_Company(child2,this);
    Jload.jPanelLoader(child2, com);
    }//GEN-LAST:event_productActionPerformed

    private void LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginActionPerformed
        login_admin log = new login_admin(child2, this);

        // Add the login_admin form to the child2 panel
        Jload.jPanelLoader(child2, log);

        // Disable other buttons until successful login
        admin.setEnabled(false);
        employee.setEnabled(false);
        rest_details.setEnabled(false);
        Customer.setEnabled(false);
        Delivery1.setEnabled(false);
    }//GEN-LAST:event_LoginActionPerformed

    private void RegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegisterActionPerformed
        Register_admin reg = new  Register_admin(child2,this);
        Jload.jPanelLoader(child2, reg);

    }//GEN-LAST:event_RegisterActionPerformed
    
    public void goBackToChild2() {
        // Reload the main components of child2
        // You can implement this method according to your JPanel structure
        // For example:
        jPanelLoader(child2, Home_Pane); // Replace mainChild2Panel with your actual child2 main panel
    }
  public void jPanelLoader(JPanel parent, JPanel child) {
    // Remove all components from the parent panel
    parent.removeAll();

    // Set layout manager of parent panel to AbsoluteLayout
    parent.setLayout(new AbsoluteLayout());

    // Add the child panel to the parent panel with specific constraints
    parent.add(child, new AbsoluteConstraints(0, 0, parent.getWidth(), parent.getHeight()));

    // Revalidate and repaint the parent panel
    parent.revalidate();
    parent.repaint();
}

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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Admin_log;
    private javax.swing.JToggleButton Customer;
    private javax.swing.JToggleButton Delivery1;
    private javax.swing.JPanel Home_Pane;
    private javax.swing.JToggleButton Login;
    private javax.swing.JToggleButton Register;
    private javax.swing.JTabbedPane Tab_nav;
    private javax.swing.JLabel adm;
    private javax.swing.JToggleButton admin;
    private javax.swing.JPanel child2;
    private javax.swing.JLabel cust;
    private javax.swing.JToggleButton employee;
    private javax.swing.JLabel img1;
    private javax.swing.JLabel img2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel logo;
    private javax.swing.JToggleButton logout;
    private javax.swing.JToggleButton product;
    private javax.swing.JToggleButton rest_details;
    // End of variables declaration//GEN-END:variables
}
