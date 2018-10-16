/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.Thogakade.views;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import lk.ijse.Thogakade.common.IDGenerator;
import lk.ijse.Thogakade.controller.ControllerFactory;
import lk.ijse.Thogakade.controller.custom.CustomerController;
import lk.ijse.Thogakade.controller.custom.SupplerOderController;
import lk.ijse.Thogakade.dto.CustomerDTO;
import lk.ijse.Thogakade.dto.SupplerOrderDTO;
import static lk.ijse.Thogakade.views.placeOderFrom.txtQty;

/**
 *
 * @author Viraj jayasanka
 */
public class SupplerOderDeatilPanel extends javax.swing.JPanel {
     private SupplerOderController supplerOderController;
     private DefaultTableModel dtmSuppler;
    /**
     * Creates new form SupplerOderDeatilPanel
     */
    public SupplerOderDeatilPanel() {
        initComponents();
        setDate();
        SupplerID();
        supplerOderController = (SupplerOderController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.SUPPLER_ODER);
        dtmSuppler = (DefaultTableModel) SupplerOrderTabel.getModel();
        setEnable(false);
        loadData();
        handleEvents();
       
    }
     private void setDate(){
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        txtDate.setText(sdf.format(d));
    }
      private void handleEvents() {

        SupplerOrderTabel.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                if (SupplerOrderTabel.getSelectedRowCount() <= 0) {
                    return;
                }

                String supplerId = dtmSuppler.getValueAt(SupplerOrderTabel.getSelectedRow(), 0).toString();
                try {
                    SupplerOrderDTO suppler = supplerOderController.search(supplerId);

                    if (suppler != null) {
                        txtSupplerId.setText(suppler.getId());
                        txtOrderrName.setText(suppler.getName());
                        txtDate.setText(suppler.getDate());
                        txtSupplerQty.setText(""+suppler.getSpplerOrderQTY());
   
                    }
                    setEnable(true, btnAddSuppler,txtSupplerId);
                    

                } catch (Exception ex) {
                    Logger.getLogger(AddCustomerFrom.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

    }
      
      
      
       private void loadData() {

        dtmSuppler.setRowCount(0);

        try {
            ArrayList<SupplerOrderDTO> allSuppler = supplerOderController.getAll();

            if (allSuppler == null) {
                return;
            }

            for (SupplerOrderDTO suppler : allSuppler) {
                Object[] rowData = {
                    suppler.getId(),
                    suppler.getName(),
                    suppler.getSpplerOrderQTY(),
                    suppler.getDate(),
                };
                dtmSuppler.addRow(rowData);
            }
        } catch (Exception ex) {
            Logger.getLogger(AddCustomerFrom.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
       
       private void clearFields() {
        txtOrderrName.setText("");
        txtSupplerQty.setText("");   
    }
       
        private void setEnable(boolean enable, JComponent... cmp) {
        txtSupplerId.setEnabled(enable);
        txtOrderrName.setEnabled(enable);
        txtDate.setEnabled(enable);
        txtSupplerQty.setEnabled(enable); 
        for (JComponent jcmp : cmp) {
            jcmp.setEnabled(!enable);
        }
    }
         private void doValidate() {
        String supplerId = txtSupplerId.getText();
        String supplerName = txtOrderrName.getText();
        String date = txtDate.getText();
         String qty = txtSupplerQty.getText();
       
                
       btnAddSuppler.setEnabled(false);

        if (!supplerId.isEmpty()) {
            if (supplerName.matches("[A-Za-z ]+")) {
                if (!date.isEmpty()) {
                      if(!qty.isEmpty()){  
                         
                    btnAddSuppler.setEnabled(true);
                       
                     
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

        jPanel1 = new javax.swing.JPanel();
        txtDate = new javax.swing.JTextField();
        txtOrderrName = new javax.swing.JTextField();
        txtSupplerId = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnAddSuppler = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        SupplerOrderTabel = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        txtSupplerQty = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnNew = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDateActionPerformed(evt);
            }
        });
        jPanel1.add(txtDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 120, 290, 30));

        txtOrderrName.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jPanel1.add(txtOrderrName, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, 300, 30));

        txtSupplerId.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jPanel1.add(txtSupplerId, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, 300, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Suppler Order Date");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 130, -1, -1));

        btnAddSuppler.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAddSuppler.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/Thogakade/icons/Add button ican 4.png"))); // NOI18N
        btnAddSuppler.setText("Add  Suppler ORDER");
        btnAddSuppler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddSupplerActionPerformed(evt);
            }
        });
        jPanel1.add(btnAddSuppler, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 190, 430, 40));

        SupplerOrderTabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Suppler Order Id", "Suppler Order Name", "Suppler order qty", "Suppler Order Date"
            }
        ));
        jScrollPane1.setViewportView(SupplerOrderTabel);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 1070, 280));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Suppler Order Id");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, 20));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/Thogakade/icons/update Customer.png"))); // NOI18N
        jButton2.setText("Update");
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 250, 190, 40));

        jButton3.setBackground(new java.awt.Color(255, 51, 51));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/Thogakade/icons/delete customer ican1.png"))); // NOI18N
        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 250, 190, 40));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 1000, 20));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Suppler Order Name");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, -1));

        txtSupplerQty.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jPanel1.add(txtSupplerQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 240, 300, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Suppler order qty");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, -1, -1));

        jLabel6.setFont(new java.awt.Font("Sinhala-Lasitha-1", 3, 36)); // NOI18N
        jLabel6.setText("SUPPLER ORDER DEATIL");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        btnNew.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/Thogakade/icons/New Btn Ican.png"))); // NOI18N
        btnNew.setText("new");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });
        jPanel1.add(btnNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 30, 300, 40));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1150, 690));
    }// </editor-fold>//GEN-END:initComponents

    private void txtDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDateActionPerformed

    private void btnAddSupplerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddSupplerActionPerformed
          SupplerOrderDTO supplerOrderDTO = new SupplerOrderDTO(
                txtSupplerId.getText(),
                txtOrderrName.getText(),
                txtDate.getText(),
                Integer.parseInt((String) txtSupplerQty.getText()));
                 
                
                
        try {
            
            boolean result = false;
            if (txtSupplerId.isEnabled()){
                result = supplerOderController.add(supplerOrderDTO);                
            }else{
                result = supplerOderController.update(supplerOrderDTO);
            }
            if (result) {
                SupplerID();
                loadData();
                clearFields();
                setEnable(false);
                btnAddSuppler.requestFocusInWindow();
                JOptionPane.showMessageDialog(this, "Added success");
            } else {
                JOptionPane.showMessageDialog(this,
                        "Customer has been failed to add",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                txtSupplerId.requestFocusInWindow();
                txtSupplerId.selectAll();
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
            txtSupplerId.requestFocusInWindow();
            txtSupplerId.selectAll();
        } catch (Exception ex) {
            Logger.getLogger(AddCustomerFrom.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAddSupplerActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
         clearFields();

        if (dtmSuppler.getRowCount() > 0) {
            SupplerOrderTabel.getSelectionModel().clearSelection();
        }
        setEnable(true);
        txtSupplerId.requestFocusInWindow();
                  
    }//GEN-LAST:event_btnNewActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
         String supplerId = dtmSuppler.getValueAt(SupplerOrderTabel.getSelectedRow(), 0).toString();
        try {
            boolean deleted = supplerOderController.delete(supplerId);
            if (deleted) {
               
                clearFields();
                setEnable(false);
                loadData();
                SupplerOrderTabel.clearSelection();
                btnNew.requestFocusInWindow();
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
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable SupplerOrderTabel;
    private javax.swing.JButton btnAddSuppler;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtOrderrName;
    private javax.swing.JTextField txtSupplerId;
    private javax.swing.JTextField txtSupplerQty;
    // End of variables declaration//GEN-END:variables
private void SupplerID() {
        try {
            String customerId;
            customerId = IDGenerator.getNewID("Customer", "customerID", "C");
           txtSupplerId.setText(customerId);
        } catch (SQLException ex) {
            Logger.getLogger(AddCustomerFrom.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddCustomerFrom.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    }
}









