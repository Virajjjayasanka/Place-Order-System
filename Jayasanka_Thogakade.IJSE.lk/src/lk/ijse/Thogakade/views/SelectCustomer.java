/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.Thogakade.views;

import com.sun.java.swing.plaf.windows.WindowsBorders;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import lk.ijse.Thogakade.controller.ControllerFactory;
import lk.ijse.Thogakade.controller.custom.CustomerController;
import lk.ijse.Thogakade.dto.CustomerDTO;

/**
 *
 * @author Viraj jayasanka
 */
public class SelectCustomer extends javax.swing.JFrame {
     private CustomerController ctrlCustomer;
     private DefaultTableModel dtmCustomer;
     private CustomerController ctrlController;
    
    /**
     * Creates new form SelectCustomer
     */
    public SelectCustomer() {
        initComponents();
         setLocationRelativeTo(null);
         dtmCustomer = (DefaultTableModel) tblCustomers.getModel();
         ctrlCustomer = (CustomerController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.CUSTOMER);
         ctrlController = (CustomerController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.CUSTOMER);
        loadData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCustomers = new javax.swing.JTable();
        txtCustomerName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/Thogakade/icons/CLOSE.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, -1, -1));

        tblCustomers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Customer ID", "Customer Name", "Customer Address"
            }
        ));
        tblCustomers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCustomersMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCustomers);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        txtCustomerName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtCustomerName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCustomerNameActionPerformed(evt);
            }
        });
        jPanel1.add(txtCustomerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 200, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Enter Customer Name :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtCustomerNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCustomerNameActionPerformed
         String name= txtCustomerName.getText();
       try{
           CustomerDTO customer = ctrlController.search(name);
           if(customer == null){
               JOptionPane.showMessageDialog(this, "Customer Not found");
           }else{
           
               Object [] rowData ={customer.getId(),customer.getName(),customer.getAddress()};
               DefaultTableModel dtm = (DefaultTableModel) tblCustomers.getModel();
               dtm.setRowCount(0);
               dtm.addRow(rowData);
           }
       }catch (Exception ex) {
            Logger.getLogger(SelectCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtCustomerNameActionPerformed

    private void tblCustomersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCustomersMouseClicked
//        String customerId = tblCustomers.getValueAt(tblCustomers.getSelectedRow(), 0).toString();
//         ManageMain.getOrderFrom().setCustomerId(customerId);
//         dispose();
      String custpmerId = tblCustomers.getValueAt(tblCustomers.getSelectedRow(), 0).toString();
      String customerName = tblCustomers.getValueAt(tblCustomers.getSelectedRow(), 1).toString();
     
        placeOderFrom.customerNameText.setText(customerName);
        placeOderFrom.txtCustomerId.setText(custpmerId);
   //     InvoicePanel.txtCustomerId.setText(custpmerId);
      //  placeOderFrom.txtCustomerId.setText(custpmerId);
        
       
      
      dispose();
    }//GEN-LAST:event_tblCustomersMouseClicked

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
                    customer.getAddress()
                };
                dtmCustomer.addRow(rowData);
            }
        } catch (Exception ex) {
            Logger.getLogger(AddCustomerFrom.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
    
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
            java.util.logging.Logger.getLogger(SelectCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SelectCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SelectCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SelectCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SelectCustomer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCustomers;
    private javax.swing.JTextField txtCustomerName;
    // End of variables declaration//GEN-END:variables
}
