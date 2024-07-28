/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package food_project2;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author khushi pandey
 */
public class Emp_Panel extends javax.swing.JPanel {
  JpanelLoader Jload = new JpanelLoader();
    private JPanel child2;
    
    private Home homeFrame; // Add reference to Home frame

    public Emp_Panel(JPanel child2, Home homeFrame) {
        initComponents();
        this.child2 = child2;
        this.homeFrame = homeFrame; 
        
    }

  public void goToChild2() {
        // Reload the main components of child2
        // You can implement this method according to your JPanel structure
        // For example:
        jPanelLoader(child2, Home_Pane); // Replace mainChild2Panel with your actual child2 main panel
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

        Home_Pane = new javax.swing.JPanel();
        add = new javax.swing.JButton();
        jLabel = new javax.swing.JLabel();
        update = new javax.swing.JButton();
        attendance = new javax.swing.JButton();
        remove = new javax.swing.JButton();
        view = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Home_Pane.setBackground(new java.awt.Color(255, 255, 255));
        Home_Pane.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        Home_Pane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        add.setBackground(new java.awt.Color(0, 102, 102));
        add.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        add.setForeground(new java.awt.Color(255, 255, 255));
        add.setText("ADD");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        Home_Pane.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 230, 150, 50));

        jLabel.setBackground(new java.awt.Color(204, 204, 204));
        jLabel.setFont(new java.awt.Font("Rockwell Nova", 3, 32)); // NOI18N
        jLabel.setForeground(new java.awt.Color(255, 51, 51));
        jLabel.setText("Employee Management");
        Home_Pane.add(jLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 140, -1, -1));

        update.setBackground(new java.awt.Color(0, 102, 102));
        update.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        update.setForeground(new java.awt.Color(255, 255, 255));
        update.setText("UPDATE");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        Home_Pane.add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 280, 150, 50));

        attendance.setBackground(new java.awt.Color(0, 102, 102));
        attendance.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        attendance.setForeground(new java.awt.Color(255, 255, 255));
        attendance.setText("ATTENDANCE");
        attendance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attendanceActionPerformed(evt);
            }
        });
        Home_Pane.add(attendance, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 330, 150, 50));

        remove.setBackground(new java.awt.Color(0, 102, 102));
        remove.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        remove.setForeground(new java.awt.Color(255, 255, 255));
        remove.setText("REMOVE");
        remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeActionPerformed(evt);
            }
        });
        Home_Pane.add(remove, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 280, 150, 50));

        view.setBackground(new java.awt.Color(0, 102, 102));
        view.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        view.setForeground(new java.awt.Color(255, 255, 255));
        view.setText("VIEW");
        view.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewActionPerformed(evt);
            }
        });
        Home_Pane.add(view, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 230, 150, 50));

        jLabel4.setIcon(new javax.swing.ImageIcon("E:\\Food\\cheff8.png")); // NOI18N
        Home_Pane.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-110, -10, 440, 480));

        add(Home_Pane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1390, 730));
    }// </editor-fold>//GEN-END:initComponents

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        Add_Emp add= new  Add_Emp(child2,this);
         Jload.jPanelLoader(child2, add); 
    }//GEN-LAST:event_addActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
         Emp_Update up= new Emp_Update(child2,this);
         Jload.jPanelLoader(child2, up); 
    }//GEN-LAST:event_updateActionPerformed

    private void attendanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attendanceActionPerformed
        Attend_Panel attend= new  Attend_Panel(child2,this);
         Jload.jPanelLoader(child2,attend); 
    }//GEN-LAST:event_attendanceActionPerformed

    private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed
      Remove_em remove= new  Remove_em(child2,this);
         Jload.jPanelLoader(child2,remove); 
    }//GEN-LAST:event_removeActionPerformed

    private void viewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewActionPerformed
        View_Emp view= new View_Emp(child2,this);
         Jload.jPanelLoader(child2,view); 
    }//GEN-LAST:event_viewActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Home_Pane;
    private javax.swing.JButton add;
    private javax.swing.JButton attendance;
    private javax.swing.JLabel jLabel;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton remove;
    private javax.swing.JButton update;
    private javax.swing.JButton view;
    // End of variables declaration//GEN-END:variables
}
