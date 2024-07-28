/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package food_project;

/**
 *
 * @author khushi pandey
 */
import food_project2.Home;
import javax.swing.*;
import java.awt.*;
import java.io.InputStream;
//import java.awt.event.ActionEvent;
import java.util.Stack;


public class First_Page extends javax.swing.JFrame {
//   JpanelLoader jl = new JpanelLoader();
    private final JPanel cardPanel;
    private final CardLayout cardLayout;
    private final Stack<String> panelStack;
    public First_Page() {
       initComponents();
       Font fontAwesomeFont = new Font("FontAwesome", Font.PLAIN, 20);
        Register_btn.setFont(fontAwesomeFont);
        Login.setFont(fontAwesomeFont);
        
        // Set text for buttons using Unicode characters
        Register_btn.setText("\uf234 Register"); // Unicode for "Register" icon
        Login.setText("\uf007 Login"); // Unicode for "Login" icon
    
       this.setExtendedState(Home.MAXIMIZED_BOTH);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("K - Food");
        panelStack = new Stack<>();
       cardPanel = new JPanel();
    cardLayout = new CardLayout(); // Initialize cardLayout
    cardPanel.setLayout(cardLayout);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Tab_nav = new javax.swing.JTabbedPane();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        child2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        Register_btn = new javax.swing.JButton();
        Admin_log = new javax.swing.JLabel();
        Login = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Tab_nav.setBackground(new java.awt.Color(255, 0, 255));
        Tab_nav.setForeground(new java.awt.Color(51, 51, 51));
        Tab_nav.setFont(new java.awt.Font("Neue Haas Grotesk Text Pro", 1, 20)); // NOI18N

        jLabel4.setText("jLabel4");
        Tab_nav.addTab("Home", jLabel4);

        jLabel5.setText("jLabel5");
        Tab_nav.addTab("Enquiry", jLabel5);

        jLabel6.setText("jLabel6");
        Tab_nav.addTab("About us", jLabel6);

        getContentPane().add(Tab_nav, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 1500, 35));
        Tab_nav.getAccessibleContext().setAccessibleDescription("");

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Vivaldi", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(32, 163, 103));
        jLabel7.setText("K - Food");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 190, -1));

        child2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Rockwell", 1, 22)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 153));
        jLabel9.setText("Admin Registration");
        child2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 250, 220, -1));

        Register_btn.setBackground(new java.awt.Color(204, 0, 0));
        Register_btn.setFont(new java.awt.Font("UD Digi Kyokasho NK-B", 1, 18)); // NOI18N
        Register_btn.setForeground(new java.awt.Color(255, 255, 255));
        Register_btn.setText("Click to Register");
        Register_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Register_btnActionPerformed(evt);
            }
        });
        child2.add(Register_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 250, 210, 35));

        Admin_log.setFont(new java.awt.Font("Rockwell", 1, 22)); // NOI18N
        Admin_log.setForeground(new java.awt.Color(0, 0, 153));
        Admin_log.setText("Admin Login");
        child2.add(Admin_log, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 330, -1, -1));

        Login.setBackground(new java.awt.Color(204, 0, 0));
        Login.setFont(new java.awt.Font("UD Digi Kyokasho NK-B", 1, 18)); // NOI18N
        Login.setForeground(new java.awt.Color(255, 255, 255));
        Login.setText("Click to Login");
        Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginActionPerformed(evt);
            }
        });
        child2.add(Login, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 330, 210, 35));

        getContentPane().add(child2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1350, 640));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Register_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Register_btnActionPerformed
      
     panelStack.push(cardLayout.toString());
     Admin_Register log = new Admin_Register();
     log.setVisible(true);
    
      dispose();  
      

    }//GEN-LAST:event_Register_btnActionPerformed

    private void LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginActionPerformed
        panelStack.push(cardLayout.toString());
        Login_Form log = new Login_Form();
        log.setVisible(true);
         
         dispose();
        
       
    }//GEN-LAST:event_LoginActionPerformed
// private void BackActionPerformed(ActionEvent evt) {
//        
//    }
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(() -> {
            new First_Page().setVisible(true);
        });
    }
   
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Admin_log;
    private javax.swing.JButton Login;
    private javax.swing.JButton Register_btn;
    private javax.swing.JTabbedPane Tab_nav;
    private javax.swing.JPanel child2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
