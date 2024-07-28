
package food_project;
import food_project2.Home;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.Timer;

public class Customer_Dash extends javax.swing.JFrame {
private int id;
//    private JLabel panel_img;

    private int imageIndex = 0;
    private ImageIcon[] images;
     private Timer marqueeTimer;
private int marqueeSpeed = 5; // Adjust the speed as needed
private int marqueeDirection = 1; // 1 for right, -1 for left
private int marqueeX = 0;
 private boolean isLoggedIn = false;
    public Customer_Dash() {
        initComponents();
        initializeSlideshow();
        this.setExtendedState(Home.MAXIMIZED_BOTH);
        
//           setBackgroundImage();
 startMarquee();
 JScrollPane scrollPane = new JScrollPane(getContentPane());
 scrollPane.setColumnHeaderView(Nav);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        setContentPane(scrollPane);
        
// 
    }
    
   

  private void startMarquee() {
    marqueeTimer = new Timer(20, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int width = jPanel2.getWidth(); // Adjust the panel width as needed
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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        Nav = new javax.swing.JPanel();
        login_btn = new javax.swing.JButton();
        Register_btn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        choise = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        main = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        manchef = new javax.swing.JLabel();
        girlschef = new javax.swing.JLabel();
        chef_img = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        head = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        slide_imgs = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Nav.setBackground(new java.awt.Color(204, 204, 0));
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
        Nav.add(login_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 10, 80, 25));

        Register_btn.setBackground(new java.awt.Color(0, 204, 0));
        Register_btn.setFont(new java.awt.Font("SimSun", 1, 15)); // NOI18N
        Register_btn.setForeground(new java.awt.Color(255, 255, 255));
        Register_btn.setText("Register");
        Register_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Register_btnActionPerformed(evt);
            }
        });
        Nav.add(Register_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 10, 100, 25));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel1.setText("OR");
        Nav.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1360, 10, -1, -1));

        choise.setBackground(new java.awt.Color(204, 204, 255));
        choise.setFont(new java.awt.Font("UD Digi Kyokasho NK-B", 1, 14)); // NOI18N
        choise.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        choise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                choiseActionPerformed(evt);
            }
        });
        Nav.add(choise, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 200, 20));
        Nav.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, -40, -1, -1));

        jPanel6.add(Nav, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1580, 50));

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1570, 50));

        main.setBackground(new java.awt.Color(102, 102, 102));
        main.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        main.setForeground(new java.awt.Color(102, 102, 102));
        main.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextArea2.setBackground(new java.awt.Color(102, 102, 102));
        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Serif", 3, 18)); // NOI18N
        jTextArea2.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea2.setLineWrap(true);
        jTextArea2.setRows(5);
        jTextArea2.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. \"\n        + \"Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, \"\n        + \"quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. \"\n        + \"Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. \"\n        + \"Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
        jTextArea2.setBorder(null);
        jScrollPane2.setViewportView(jTextArea2);

        main.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 960, 750, 230));

        manchef.setForeground(new java.awt.Color(255, 255, 255));
        manchef.setIcon(new javax.swing.ImageIcon("E:\\Food\\file.png")); // NOI18N
        main.add(manchef, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 1030, 340, 380));

        girlschef.setForeground(new java.awt.Color(255, 255, 255));
        girlschef.setIcon(new javax.swing.ImageIcon("E:\\Food\\file2.png")); // NOI18N
        main.add(girlschef, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 950, -1, -1));

        chef_img.setForeground(new java.awt.Color(255, 255, 255));
        chef_img.setIcon(new javax.swing.ImageIcon("E:\\Food\\food8.jpeg")); // NOI18N
        main.add(chef_img, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 1460, 1530, 340));

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setForeground(new java.awt.Color(0, 204, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        head.setBackground(new java.awt.Color(204, 0, 204));
        head.setFont(new java.awt.Font("Palatino Linotype", 3, 23)); // NOI18N
        head.setForeground(new java.awt.Color(255, 255, 255));
        head.setText("Get And Order All Delicious Food Here");
        jPanel2.add(head, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, -40, -1, -1));

        main.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1570, 50));
        main.add(slide_imgs, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 1530, 650));

        getContentPane().add(main, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 1600, 2010));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void choiseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_choiseActionPerformed
       // Check if the user is logged in
        if (!isLoggedIn) {
            // Show a message prompting the user to register and login
            JOptionPane.showMessageDialog(this, "Please register and login to access this feature.");
            // Return without further action
            return;
        }
        
        String selectedOption = (String) choise.getSelectedItem();
        if (selectedOption.equals("Veg")) {
            // Open Menu1 JFrame for Veg
            vMenu m1 = new vMenu();
            m1.setVisible(true);
        } else if (selectedOption.equals("Non-Veg")) {
            // Open Menu2 JFrame for Non-Veg
            // Menu2 menu2 = new Menu2();
            // menu2.setVisible(true);
        }
    }//GEN-LAST:event_choiseActionPerformed

    private void Register_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Register_btnActionPerformed
       Customer_Details cdetails = new Customer_Details();
       cdetails.setVisible(true);
    }//GEN-LAST:event_Register_btnActionPerformed

    private void login_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_login_btnActionPerformed
        Customer_Login log = new Customer_Login();
        log.setVisible(true);
    }//GEN-LAST:event_login_btnActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Customer_Dash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Customer_Dash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Customer_Dash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Customer_Dash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Customer_Dash().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Nav;
    private javax.swing.JButton Register_btn;
    private javax.swing.JLabel chef_img;
    private javax.swing.JComboBox<String> choise;
    private javax.swing.JLabel girlschef;
    private javax.swing.JLabel head;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JButton login_btn;
    private javax.swing.JPanel main;
    private javax.swing.JLabel manchef;
    private javax.swing.JLabel slide_imgs;
    // End of variables declaration//GEN-END:variables
}
