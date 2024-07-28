/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package food_project2;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class Show extends javax.swing.JPanel {
 Connection con = null;
   ResultSet rs = null;
   PreparedStatement pst = null;
       private Timer typingTimer;
    private int currentIndex = 0;
    private Timer delayTimer;

    private String message = "Thanks, For Coming here !! Visit Again";

  
//    JpanelLoader Jload = new JpanelLoader();
    private JPanel child2;
    private Cash  ca;
    
    private Bank ba;
    public Show( JPanel child2,Cash  ca,Bank ba) {
        initComponents();
           initComponents();
         this.ca = ca;
         this.ba = ba;
        typingTimer = new Timer(100, e -> {
            if (currentIndex <= message.length()) {
                t2.setText(message.substring(0, currentIndex));
                currentIndex++;
            } else {
                // Stop the timer once the typing effect is complete
                typingTimer.stop();
            }
        });
        typingTimer.start();

        // Initialize the delay timer
        delayTimer = new Timer(8000, e -> {
            int confirm = JOptionPane.showConfirmDialog(this, "Transaction successfully done.\nThanks for coming here!! Visit again.", "Transaction Done", JOptionPane.DEFAULT_OPTION);
            if (confirm == JOptionPane.OK_OPTION) {
                // Navigate back to the correct form
                if (ca != null) {
                    ca.goToChild2();
                } else if (ba != null) {
                    ba.goToChild2();
                }
            }
        });
        delayTimer.setRepeats(false); // Set to run only once
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        warm = new javax.swing.JPanel();
        t1 = new javax.swing.JLabel();
        img1 = new javax.swing.JLabel();
        t2 = new javax.swing.JLabel();
        img2 = new javax.swing.JLabel();
        back = new javax.swing.JButton();

        setBackground(new java.awt.Color(153, 255, 153));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        warm.setBackground(new java.awt.Color(255, 255, 255));
        warm.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        t1.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 1, 36)); // NOI18N
        t1.setForeground(new java.awt.Color(0, 0, 204));
        t1.setText("Transaction successfully done");
        warm.add(t1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 50, -1, -1));

        img1.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 1, 36)); // NOI18N
        img1.setForeground(new java.awt.Color(0, 204, 102));
        img1.setIcon(new javax.swing.ImageIcon("E:\\Food\\tans1.png")); // NOI18N
        warm.add(img1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 40, 490, -1));

        t2.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 1, 36)); // NOI18N
        t2.setForeground(new java.awt.Color(255, 0, 51));
        t2.setText("Thanks, For Coming here !! Visit Again");
        warm.add(t2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 460, -1, -1));

        img2.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 1, 36)); // NOI18N
        img2.setForeground(new java.awt.Color(0, 204, 102));
        img2.setIcon(new javax.swing.ImageIcon("E:\\Food\\done1.png")); // NOI18N
        warm.add(img2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-130, -70, 490, -1));

        back.setBackground(new java.awt.Color(51, 51, 51));
        back.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        back.setForeground(new java.awt.Color(255, 255, 255));
        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        warm.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 30, 90, 40));

        add(warm, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1320, 800));
    }// </editor-fold>//GEN-END:initComponents

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
       int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to go back?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            // Navigate back to the correct form
            if (ca != null) {
                ca.goToChild2();
            } else if (ba != null) {
                ba.goToChild2();
            }
        }
    }//GEN-LAST:event_backActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JLabel img1;
    private javax.swing.JLabel img2;
    private javax.swing.JLabel t1;
    private javax.swing.JLabel t2;
    private javax.swing.JPanel warm;
    // End of variables declaration//GEN-END:variables
}
