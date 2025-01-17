/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package food_project2;
import food_project2.Home;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.DefaultCellEditor;
import javax.swing.JRadioButton;
import java.awt.Component;
import java.awt.Font;
import java.awt.print.PrinterException;
import javax.swing.AbstractCellEditor;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

public class Emp_Attendance extends javax.swing.JPanel {
private DefaultTableModel model;
    private JComboBox<String> attendanceComboBox; // Combo box for attendance options
    private JComboBox<String> shiftComboBox; // Combo box for shift options
     private Connection connection;
     private Attend_Panel attend;
    public Emp_Attendance(JPanel child2, Attend_Panel attend) {
        initComponents();
          this.attend = attend;
          initializeTable();
        connection = food_project2.conn.mycon(); // Establish database connection
        loadDataFromDatabase();
    }

      private void loadDataFromDatabase() {
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT Emp_ID, Name FROM employee_details");
            while (rs.next()) {
                model.addRow(new Object[]{rs.getInt("Emp_ID"), rs.getString("Name"), null, null}); // Add Emp_ID and Name to the table
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void saveDataToDatabase() {
    try {
        String query = "INSERT INTO emp_Attendance (Emp_ID, Name, Shift, Attendance, Date) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement pstmt = connection.prepareStatement(query);
        for (int i = 0; i < model.getRowCount(); i++) {
            pstmt.setInt(1, (int) model.getValueAt(i, 0)); // Emp_ID
            pstmt.setString(2, (String) model.getValueAt(i, 1)); // Name
            pstmt.setString(3, (String) model.getValueAt(i, 2)); // Shift

            // Attendance
            Object attendanceObject = model.getValueAt(i, 3);
            if (attendanceObject != null) {
                pstmt.setString(4, (String) attendanceObject);
            } else {
                pstmt.setNull(4, java.sql.Types.VARCHAR);
            }

            // Set the Date column value
            java.util.Date currentDate = new java.util.Date();
            java.sql.Timestamp timestamp = new java.sql.Timestamp(currentDate.getTime());
            pstmt.setTimestamp(5, timestamp);

            pstmt.executeUpdate();
        }
        // Show success message
        JOptionPane.showMessageDialog(this, "Attendance data saved successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
    } catch (SQLException e) {
        e.printStackTrace();
        // Show error message
        JOptionPane.showMessageDialog(this, "Attendance data could not be saved.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

    private void initializeTable() {
        model = new DefaultTableModel() {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return String.class; // All columns contain String data
            }
        };
        model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("Shift");
        model.addColumn("Attendance");

        jTable1.setModel(model);

        TableColumnModel columnModel = jTable1.getColumnModel();

        attendanceComboBox = new JComboBox<>();
        attendanceComboBox.addItem("Present");
        attendanceComboBox.addItem("Absent");

        shiftComboBox = new JComboBox<>();
        shiftComboBox.addItem("Morning");
        shiftComboBox.addItem("Afternoon");
        shiftComboBox.addItem("Evening");
        shiftComboBox.addItem("Night");

        columnModel.getColumn(2).setCellEditor(new DefaultCellEditor(shiftComboBox));
        columnModel.getColumn(3).setCellEditor(new DefaultCellEditor(attendanceComboBox));

        // Set column header properties
        JTableHeader header = jTable1.getTableHeader();
        header.setFont(new Font("Verdana Pro Black", Font.BOLD, 19)); // Set font size to 19px
        header.setForeground(new Color(32, 103, 78)); // Set green color
        ((DefaultTableCellRenderer) header.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER); // Center align headers

        // Center align data in columns
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        jTable1.setDefaultRenderer(String.class, centerRenderer);

        jTable1.setRowHeight(30);
    }
public class RadioCellRenderer extends JRadioButton implements TableCellRenderer {
    public RadioCellRenderer() {
        setHorizontalAlignment(JRadioButton.CENTER);
        setOpaque(true); // Make sure the renderer is opaque
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (isSelected) {
            setBackground(table.getSelectionBackground());
        } else {
            setBackground(table.getBackground());
        }
        if (hasFocus) {
            setBorder(UIManager.getBorder("Table.focusCellHighlightBorder"));
        } else {
            setBorder(null);
        }
        if (value != null && value.equals("Present")) {
            setSelected(true);
        } else {
            setSelected(false);
        }
        return this;
    }
}

public class RadioCellEditor extends AbstractCellEditor implements TableCellEditor {
    JRadioButton presentButton;
    JRadioButton absentButton;

    public RadioCellEditor() {
        presentButton = new JRadioButton("Present");
        absentButton = new JRadioButton("Absent");
        ButtonGroup group = new ButtonGroup();
        group.add(presentButton);
        group.add(absentButton);
    }

    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        if (value != null && value.equals("Present")) {
            presentButton.setSelected(true);
        } else {
            absentButton.setSelected(true);
        }
        return (column == 3) ? presentButton : absentButton;
    }

    public Object getCellEditorValue() {
        return presentButton.isSelected() ? "Present" : "Absent";
    }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        save = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        back1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        save.setBackground(new java.awt.Color(0, 153, 0));
        save.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        save.setForeground(new java.awt.Color(255, 255, 255));
        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        jPanel1.add(save, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, -1, -1));

        cancel.setBackground(new java.awt.Color(255, 0, 0));
        cancel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        cancel.setForeground(new java.awt.Color(255, 255, 255));
        cancel.setText("Cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        jPanel1.add(cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, -1, -1));

        jTable1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTable1.setForeground(new java.awt.Color(204, 0, 204));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 1150, -1));

        back1.setBackground(new java.awt.Color(204, 204, 204));
        back1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        back1.setText("Back");
        back1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back1ActionPerformed(evt);
            }
        });
        jPanel1.add(back1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 60, -1, -1));

        jLabel3.setFont(new java.awt.Font("Bookman Old Style", 3, 30)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 0));
        jLabel3.setText("Take Attendance Of Emp");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 470, -1));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1450, 840));
    }// </editor-fold>//GEN-END:initComponents

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        saveDataToDatabase();
    }//GEN-LAST:event_saveActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
//        this.dispose();
    }//GEN-LAST:event_cancelActionPerformed

    private void back1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back1ActionPerformed
 int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to go back?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            // Navigate back to Emp_Panel using the reference
            attend.goBackToChild2();
        }
      
    }//GEN-LAST:event_back1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back1;
    private javax.swing.JButton cancel;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton save;
    // End of variables declaration//GEN-END:variables
}
