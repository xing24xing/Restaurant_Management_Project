/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package food_project2;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author khushi pandey
 */
public class Attend_Panel extends javax.swing.JPanel {

    JpanelLoader Jload = new JpanelLoader();
    private JPanel child2;
    
    private  Emp_Panel emp; // Add reference to Home frame

    public Attend_Panel(JPanel child2, Emp_Panel emp) {
        initComponents();
        this.child2 = child2;
        this.emp = emp;
        loadAndSetImage("E:\\Food\\emp.jpg", emp_img);
    }

   public void goBackToChild2() {
        // Reload the main components of child2
        // You can implement this method according to your JPanel structure
        // For example:
        jPanelLoader(child2, att); // Replace mainChild2Panel with your actual child2 main panel
    }
  public void jPanelLoader(JPanel parent, JPanel child) {
    parent.removeAll();
    parent.add(child);
    parent.revalidate();
    parent.repaint();
}
    private void loadAndSetImage(String imagePath, JLabel label) {
    int width = 1340; // Fixed width for all images
    int height = 890; // Fixed height for all images
    ImageIcon icon = new ImageIcon(imagePath);
    Image scaledImage = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
    label.setIcon(new ImageIcon(scaledImage));
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        att = new javax.swing.JPanel();
        take = new javax.swing.JButton();
        view = new javax.swing.JButton();
        update = new javax.swing.JButton();
        del = new javax.swing.JButton();
        Back = new javax.swing.JButton();
        emp_img = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        att.setBackground(new java.awt.Color(255, 255, 255));
        att.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        take.setBackground(new java.awt.Color(0, 102, 102));
        take.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        take.setForeground(new java.awt.Color(255, 255, 255));
        take.setText("Take Attendance");
        take.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                takeActionPerformed(evt);
            }
        });
        att.add(take, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 190, 50));

        view.setBackground(new java.awt.Color(0, 102, 102));
        view.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        view.setForeground(new java.awt.Color(255, 255, 255));
        view.setText("View Attendance");
        view.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewActionPerformed(evt);
            }
        });
        att.add(view, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, 190, 50));

        update.setBackground(new java.awt.Color(0, 102, 102));
        update.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        update.setForeground(new java.awt.Color(255, 255, 255));
        update.setText("Update Attendance");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        att.add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 190, 50));

        del.setBackground(new java.awt.Color(0, 102, 102));
        del.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        del.setForeground(new java.awt.Color(255, 255, 255));
        del.setText("Delete Attendance");
        del.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delActionPerformed(evt);
            }
        });
        att.add(del, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, 190, 50));

        Back.setBackground(new java.awt.Color(51, 51, 51));
        Back.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        Back.setForeground(new java.awt.Color(255, 255, 255));
        Back.setText("Back");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });
        att.add(Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 40, 100, 40));

        emp_img.setIcon(new javax.swing.ImageIcon("E:\\Food\\emp.jpg")); // NOI18N
        att.add(emp_img, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1340, 770));

        add(att, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1340, 910));
    }// </editor-fold>//GEN-END:initComponents

    private void takeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_takeActionPerformed
        Emp_Attendance attend = new Emp_Attendance(child2,this);
        Jload.jPanelLoader(child2,attend); 
    }//GEN-LAST:event_takeActionPerformed

    private void delActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delActionPerformed
       Attend_Delete del = new Attend_Delete(child2,this);
        Jload.jPanelLoader(child2,del);
    }//GEN-LAST:event_delActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
       Attendance_update up = new Attendance_update(child2,this);
        Jload.jPanelLoader(child2,up); 
    }//GEN-LAST:event_updateActionPerformed

    private void viewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewActionPerformed
       Attend_view view = new Attend_view(child2,this);
        Jload.jPanelLoader(child2,view); 
    }//GEN-LAST:event_viewActionPerformed

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
       int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to go back?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            // Navigate back to Emp_Panel using the reference
            emp.goToChild2();
        }
    }//GEN-LAST:event_BackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JPanel att;
    private javax.swing.JButton del;
    private javax.swing.JLabel emp_img;
    private javax.swing.JButton take;
    private javax.swing.JButton update;
    private javax.swing.JButton view;
    // End of variables declaration//GEN-END:variables
}
