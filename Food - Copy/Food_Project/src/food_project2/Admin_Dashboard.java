/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package food_project2;

import javax.swing.JPanel;

/**
 *
 * @author khushi pandey
 */
public class Admin_Dashboard extends javax.swing.JPanel {
JpanelLoader Jload = new JpanelLoader();
    private JPanel child2;
    
    private Home homeFrame; // Add reference to Home frame

    public Admin_Dashboard(JPanel child2,Home homeFrame) {
        initComponents();
        this.child2 = child2;
        this.homeFrame = homeFrame; 
        
    }

   public void goToChild2() {
        // Reload the main components of child2
        // You can implement this method according to your JPanel structure
        // For example:
        jPanelLoader(child2, adm); // Replace mainChild2Panel with your actual child2 main panel
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

        adm = new javax.swing.JPanel();
        view = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        remove = new javax.swing.JButton();
        update = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        history = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        adm.setBackground(new java.awt.Color(255, 255, 255));
        adm.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        view.setBackground(new java.awt.Color(51, 51, 255));
        view.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        view.setForeground(new java.awt.Color(255, 255, 255));
        view.setText("View All Admins");
        view.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewActionPerformed(evt);
            }
        });
        adm.add(view, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 190, -1, 50));

        jLabel1.setFont(new java.awt.Font("Perpetua", 3, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 204, 51));
        jLabel1.setText("Admin Dashborad");
        adm.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 50, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon("E:\\Food\\chef5.jpg")); // NOI18N
        adm.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, -50, 630, -1));

        remove.setBackground(new java.awt.Color(255, 0, 0));
        remove.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        remove.setForeground(new java.awt.Color(255, 255, 255));
        remove.setText("Remove Admin Info");
        remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeActionPerformed(evt);
            }
        });
        adm.add(remove, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 290, -1, 50));

        update.setBackground(new java.awt.Color(0, 102, 0));
        update.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        update.setForeground(new java.awt.Color(255, 255, 255));
        update.setText("Update Admin Info");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        adm.add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 240, -1, 50));

        jLabel4.setIcon(new javax.swing.ImageIcon("E:\\Food\\file2.png")); // NOI18N
        adm.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 0, -1, -1));

        history.setBackground(new java.awt.Color(153, 0, 153));
        history.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        history.setForeground(new java.awt.Color(255, 255, 255));
        history.setText("History");
        history.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                historyActionPerformed(evt);
            }
        });
        adm.add(history, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 330, 170, 50));

        add(adm, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1360, 920));
    }// </editor-fold>//GEN-END:initComponents

    private void viewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewActionPerformed
        Admin_View view = new Admin_View(child2,this);
         Jload.jPanelLoader(child2, view); 
    }//GEN-LAST:event_viewActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        Admin_Update up = new Admin_Update(child2,this);
        Jload.jPanelLoader(child2, up); 
    }//GEN-LAST:event_updateActionPerformed

    private void historyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historyActionPerformed
       Check_login_logout chk = new Check_login_logout(child2,this);
         Jload.jPanelLoader(child2, chk); 
    }//GEN-LAST:event_historyActionPerformed

    private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed
        Admin_Remove rev = new  Admin_Remove(child2,this);
        Jload.jPanelLoader(child2,rev);
    }//GEN-LAST:event_removeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel adm;
    private javax.swing.JButton history;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton remove;
    private javax.swing.JButton update;
    private javax.swing.JButton view;
    // End of variables declaration//GEN-END:variables
}
