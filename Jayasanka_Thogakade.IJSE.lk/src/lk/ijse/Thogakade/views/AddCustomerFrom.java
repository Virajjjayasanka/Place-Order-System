/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.Thogakade.views;

import com.sun.glass.events.KeyEvent;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import static java.lang.Integer.parseInt;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.synth.Region;
import javax.swing.table.DefaultTableModel;
import lk.ijse.Thogakade.common.IDGenerator;
import lk.ijse.Thogakade.controller.ControllerFactory;
import lk.ijse.Thogakade.controller.custom.CustomerController;
import lk.ijse.Thogakade.dto.CustomerDTO;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 *
 * @author Viraj jayasanka
 */
public class AddCustomerFrom extends javax.swing.JPanel {
     private CustomerController ctrlCustomer;
     private DefaultTableModel dtmCustomer;
    /**
     * Creates new form AddCustomerFrom
     */
    public AddCustomerFrom() {
        initComponents();
        ctrlCustomer = (CustomerController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.CUSTOMER);
        dtmCustomer = (DefaultTableModel) AddCustomerTabel.getModel();
        setEnable(false);
        loadData();
        handleEvents();
        setDate();
        CustomerID();
    }
     private void setDate(){
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        txtDate.setText(sdf.format(d));
    }

    private void handleEvents() {

        AddCustomerTabel.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                if (AddCustomerTabel.getSelectedRowCount() <= 0) {
                    return;
                }

                String customerId = dtmCustomer.getValueAt(AddCustomerTabel.getSelectedRow(), 0).toString();
                try {
                    CustomerDTO customer = ctrlCustomer.search(customerId);

                    if (customer != null) {
                        txtCustomerId.setText(customer.getId());
                        txtCustomerName.setText(customer.getName());
                        txtCustomerAddress.setText(customer.getAddress());
                        txtCustomerTelePoneNo.setText(customer.getTelePoneNO());
                        txtDate.setText(customer.getDate());
                    }
                    setEnable(true, btnAddCustomer,txtCustomerId);
                    

                } catch (Exception ex) {
                    Logger.getLogger(AddCustomerFrom.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

    }
    
    //tabel load
      private void loadData() {

        dtmCustomer.setRowCount(0);

        try {
            ArrayList<CustomerDTO> allCustomers = ctrlCustomer.getAll();

            if (allCustomers == null) {
                return;
            }

            for (CustomerDTO customer : allCustomers) {
                Object[] rowData = {
                    customer.getId(),
                    customer.getName(),
                    customer.getAddress(),
                    customer.getTelePoneNO(),
                    customer.getDate(),
                };
                dtmCustomer.addRow(rowData);
            }
        } catch (Exception ex) {
            Logger.getLogger(AddCustomerFrom.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
    //remove field
     private void clearFields() {
     //   txtCustomerId.setText("");
        txtCustomerName.setText("");
        txtCustomerAddress.setText("");
       // txtDate.setText("");
        txtCustomerTelePoneNo.setText("");
        
    }
      private void setEnable(boolean enable, JComponent... cmp) {
        txtCustomerId.setEnabled(enable);
        txtCustomerName.setEnabled(enable);
        txtCustomerAddress.setEnabled(enable);
        txtCustomerTelePoneNo.setEnabled(enable);
        txtDate.setEnabled(enable);
        btnAddCustomer.setEnabled(enable);
        deletejButton.setEnabled(enable);
        removeAlljButton.setEnabled(enable);
        nextjButton.setEnabled(enable);
        for (JComponent jcmp : cmp) {
            jcmp.setEnabled(!enable);
        }
    }
      private void doValidate() {
        String customerId = txtCustomerId.getText();
        String customerName = txtCustomerName.getText();
        String customerAddress = txtCustomerAddress.getText();
        String customerTelePoneNo =  txtCustomerTelePoneNo.getText();
        String Date = txtDate.getText();
                
       btnAddCustomer.setEnabled(false);

        if (!customerId.isEmpty()) {
            if (customerName.matches("[A-Za-z ]+")) {
                if (!customerAddress.isEmpty()) {
                      if (!customerTelePoneNo.isEmpty()) {  
                          if (!Date.isEmpty()) {
                    btnAddCustomer.setEnabled(true);
                       
                      }
               }
            }
        }
      }
   }

    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        AddCustomerTabel = new javax.swing.JTable();
        txtCustomerAddress = new javax.swing.JTextField();
        txtCustomerName = new javax.swing.JTextField();
        txtCustomerTelePoneNo = new javax.swing.JTextField();
        nextjButton = new javax.swing.JButton();
        btnAddCustomer = new javax.swing.JButton();
        removeAlljButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        deletejButton = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        btnNewCustomer = new javax.swing.JButton();
        txtCustomerId = new javax.swing.JTextField();
        txtDate = new javax.swing.JTextField();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("CUSTOMER ID");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("CUSTOMER ADDRESS");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("CUSTOMER NAME");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("DATE");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 170, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("CUSTOMER TELE PONE NO.");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 110, -1, -1));

        jLabel8.setFont(new java.awt.Font("Sinhala-Lasitha-1", 3, 36)); // NOI18N
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/Thogakade/icons/Add.png"))); // NOI18N
        jLabel8.setText("ADD CUSTOMER FORM");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 620, -1));

        AddCustomerTabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        AddCustomerTabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CustomerID", "CustomerName", "CustomerAddress", "Customer Tele  Pone No.", "Date"
            }
        ));
        AddCustomerTabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddCustomerTabelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(AddCustomerTabel);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 1030, 280));

        txtCustomerAddress.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtCustomerAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCustomerAddressActionPerformed(evt);
            }
        });
        txtCustomerAddress.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCustomerAddressKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCustomerAddressKeyReleased(evt);
            }
        });
        add(txtCustomerAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 233, 280, 30));

        txtCustomerName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtCustomerName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCustomerNameActionPerformed(evt);
            }
        });
        txtCustomerName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCustomerNameKeyReleased(evt);
            }
        });
        add(txtCustomerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 170, 280, 30));

        txtCustomerTelePoneNo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtCustomerTelePoneNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCustomerTelePoneNoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCustomerTelePoneNoKeyReleased(evt);
            }
        });
        add(txtCustomerTelePoneNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 100, 260, 30));

        nextjButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nextjButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/Thogakade/icons/next button ican.png"))); // NOI18N
        nextjButton.setText("NEXT");
        add(nextjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 600, 160, 40));

        btnAddCustomer.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAddCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/Thogakade/icons/Add button ican 4.png"))); // NOI18N
        btnAddCustomer.setText("ADD CUSTOMER");
        btnAddCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCustomerActionPerformed(evt);
            }
        });
        add(btnAddCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 230, 490, 40));

        removeAlljButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        removeAlljButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/Thogakade/icons/update Customer.png"))); // NOI18N
        removeAlljButton.setText("REMOVE ALL");
        removeAlljButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        removeAlljButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeAlljButtonActionPerformed(evt);
            }
        });
        add(removeAlljButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 600, 220, 40));

        jSeparator1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 1060, 10));

        deletejButton.setBackground(new java.awt.Color(255, 51, 51));
        deletejButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        deletejButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/Thogakade/icons/delete customer ican1.png"))); // NOI18N
        deletejButton.setText("DELETE");
        deletejButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        deletejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletejButtonActionPerformed(evt);
            }
        });
        add(deletejButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 600, 170, 40));
        add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 1060, 10));

        btnNewCustomer.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnNewCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/Thogakade/icons/New Btn Ican.png"))); // NOI18N
        btnNewCustomer.setText("NEW CUSTOMER");
        btnNewCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewCustomerActionPerformed(evt);
            }
        });
        add(btnNewCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 20, 310, 40));

        txtCustomerId.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtCustomerId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCustomerIdActionPerformed(evt);
            }
        });
        txtCustomerId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCustomerIdKeyReleased(evt);
            }
        });
        add(txtCustomerId, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, 280, 30));
        add(txtDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 170, 260, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void removeAlljButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeAlljButtonActionPerformed
       //  int showConfirmDialog = JOptionPane.showConfirmDialog(this, "Clear Are you sure?");
       // if(showConfirmDialog == 0) {
       // }
         clearFields();
    }//GEN-LAST:event_removeAlljButtonActionPerformed

    private void btnNewCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewCustomerActionPerformed
        clearFields();

        if (dtmCustomer.getRowCount() > 0) {
            AddCustomerTabel.getSelectionModel().clearSelection();
        }
        setEnable(true,deletejButton,nextjButton);
        txtCustomerId.requestFocusInWindow();
    }//GEN-LAST:event_btnNewCustomerActionPerformed

    private void deletejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletejButtonActionPerformed
         String customerId = dtmCustomer.getValueAt(AddCustomerTabel.getSelectedRow(), 0).toString();
        try {
            boolean deleted = ctrlCustomer.delete(customerId);
            if (deleted) {
               // CustomerID();
                clearFields();
                setEnable(false);
                loadData();
                AddCustomerTabel.clearSelection();
                btnNewCustomer.requestFocusInWindow();
                JOptionPane.showMessageDialog(this, "Deleted success");
            } else {
                JOptionPane.showMessageDialog(this,
                        "Customer deletion has been failed, Please try again.",
                        "Delete Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    "Customer deletion has been failed, Please try again.",
                    "Delete Error",
                    JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(AddCustomerFrom.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_deletejButtonActionPerformed

    private void btnAddCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCustomerActionPerformed
        CustomerDTO customerDTO = new CustomerDTO(
                txtCustomerId.getText(),
                txtCustomerName.getText(),
                txtCustomerAddress.getText(),
                txtCustomerTelePoneNo.getText(),
                txtDate.getText());
                
        try {
            
            boolean result = false;
            if (txtCustomerId.isEnabled()){
                result = ctrlCustomer.add(customerDTO);                
            }else{
                result = ctrlCustomer.update(customerDTO);
            }
            if (result) {
                CustomerID();
                loadData();
                clearFields();
                setEnable(false);
                btnNewCustomer.requestFocusInWindow();
                JOptionPane.showMessageDialog(this, "Added success");
            } else {
                JOptionPane.showMessageDialog(this,
                        "Customer has been failed to add",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                txtCustomerId.requestFocusInWindow();
                txtCustomerId.selectAll();
            }
        } catch (SQLException ex) {
            String errorMsg;


            switch (ex.getErrorCode()) {
                case 1062:
                    errorMsg = "Duplicate entry has been found. Please enter valid Customer Id to proceed.";
                    break;
                default:
                    errorMsg = "Customer has been failed to add";
                    break;
            }

            JOptionPane.showMessageDialog(this,
                    errorMsg,
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            txtCustomerId.requestFocusInWindow();
            txtCustomerId.selectAll();
        } catch (Exception ex) {
            Logger.getLogger(AddCustomerFrom.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAddCustomerActionPerformed

    private void txtCustomerNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCustomerNameActionPerformed
       
    }//GEN-LAST:event_txtCustomerNameActionPerformed

    private void txtCustomerAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCustomerAddressActionPerformed
      
    }//GEN-LAST:event_txtCustomerAddressActionPerformed

    private void txtCustomerAddressKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCustomerAddressKeyReleased
       doValidate();
    }//GEN-LAST:event_txtCustomerAddressKeyReleased

    private void txtCustomerAddressKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCustomerAddressKeyPressed
          if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnAddCustomer.doClick();
        }
    }//GEN-LAST:event_txtCustomerAddressKeyPressed

    private void txtCustomerIdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCustomerIdKeyReleased
       doValidate();
    }//GEN-LAST:event_txtCustomerIdKeyReleased

    private void txtCustomerNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCustomerNameKeyReleased
        doValidate();
    }//GEN-LAST:event_txtCustomerNameKeyReleased

    private void AddCustomerTabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddCustomerTabelMouseClicked
         int r = AddCustomerTabel.getSelectedRow();
           String CustomerID = AddCustomerTabel.getValueAt(r, 0).toString();
            String CustomerName = AddCustomerTabel.getValueAt(r, 1).toString();
             String CustomerAddress= AddCustomerTabel.getValueAt(r, 2).toString();
              String CustomerTelePoneNo = AddCustomerTabel.getValueAt(r, 3).toString();
               String Date = AddCustomerTabel.getValueAt(r, 4).toString();
               
               txtCustomerId.setText(CustomerID);
               txtCustomerName.setText(CustomerName);
               txtCustomerAddress.setText(CustomerAddress);
               txtCustomerTelePoneNo.setText(CustomerTelePoneNo);
               txtDate.setText(Date);
    }//GEN-LAST:event_AddCustomerTabelMouseClicked

    private void txtCustomerIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCustomerIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCustomerIdActionPerformed

    private void txtCustomerTelePoneNoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCustomerTelePoneNoKeyPressed
      
    }//GEN-LAST:event_txtCustomerTelePoneNoKeyPressed

    private void txtCustomerTelePoneNoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCustomerTelePoneNoKeyReleased
       doValidate();
    }//GEN-LAST:event_txtCustomerTelePoneNoKeyReleased
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
            java.util.logging.Logger.getLogger(AddCustomerFrom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddCustomerFrom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddCustomerFrom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddCustomerFrom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddCustomerFrom().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable AddCustomerTabel;
    private javax.swing.JButton btnAddCustomer;
    private javax.swing.JButton btnNewCustomer;
    private javax.swing.JButton deletejButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton nextjButton;
    private javax.swing.JButton removeAlljButton;
    private javax.swing.JTextField txtCustomerAddress;
    private javax.swing.JTextField txtCustomerId;
    private javax.swing.JTextField txtCustomerName;
    private javax.swing.JTextField txtCustomerTelePoneNo;
    private javax.swing.JTextField txtDate;
    // End of variables declaration//GEN-END:variables
private void CustomerID() {
        try {
            String customerId;
            customerId = IDGenerator.getNewID("Customer", "customerID", "C");
           txtCustomerId.setText(customerId);
        } catch (SQLException ex) {
            Logger.getLogger(AddCustomerFrom.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddCustomerFrom.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    }
}

