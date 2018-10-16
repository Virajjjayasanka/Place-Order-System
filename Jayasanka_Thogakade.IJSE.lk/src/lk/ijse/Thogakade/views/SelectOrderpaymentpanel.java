/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.Thogakade.views;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import lk.ijse.Thogakade.controller.ControllerFactory;
import lk.ijse.Thogakade.controller.custom.OrderDetailController;
import lk.ijse.Thogakade.dto.CustomerDTO;
import lk.ijse.Thogakade.dto.OrderDetailDTO;
import lk.ijse.Thogakade.dto.SupplerOrderDTO;

/**
 *
 * @author Viraj jayasanka
 */
public class SelectOrderpaymentpanel extends javax.swing.JFrame {
     private OrderDetailController ctrlOrderD;
     private DefaultTableModel dtmOrder;
    /**
     * Creates new form SelectOrderpaymentpanel
     */
    public SelectOrderpaymentpanel() {
        initComponents();
        setLocationRelativeTo(null);
        ctrlOrderD = (OrderDetailController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.ORDERDETAIL);
        dtmOrder = (DefaultTableModel) tblOrdes.getModel();
        loadData();
    }
     private void loadData() {

        dtmOrder.setRowCount(0);

        try {
            ArrayList<OrderDetailDTO> allOrders = ctrlOrderD.getAll();

            if (allOrders == null) {
                return;
            }

            for (OrderDetailDTO orderD : allOrders) {
                Object[] rowData = {
                    orderD.getOrderId(),
                    orderD.getItemCode(),
                    orderD.getItemDescription(),
                    orderD.getUnitPrice(),
                    orderD.getQty(),
                   
                };
                dtmOrder.addRow(rowData);
            }
        } catch (Exception ex) {
            Logger.getLogger(customerPaymentPanel.class.getName()).log(Level.SEVERE, null, ex);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblOrdes = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtOrderId = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblOrdes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "oderid", "itemCode", " Description", "unitPrice", "itemQTYHand"
            }
        ));
        tblOrdes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblOrdesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblOrdes);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 460, 430));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Search Order Id");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 100, -1));

        txtOrderId.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtOrderId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOrderIdActionPerformed(evt);
            }
        });
        jPanel1.add(txtOrderId, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 260, 30));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/Thogakade/icons/CLOSE.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 520));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tblOrdesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblOrdesMouseClicked
        String orderId = tblOrdes.getValueAt(tblOrdes.getSelectedRow(), 0).toString();
        CustomerOrderPaymentPanel.lblOrderId.setText(orderId);
        this.dispose();
       
    }//GEN-LAST:event_tblOrdesMouseClicked

    private void txtOrderIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOrderIdActionPerformed
         String id = txtOrderId.getText();
       try{
           OrderDetailDTO orderD = ctrlOrderD.search(id);
           if(orderD == null){
               JOptionPane.showMessageDialog(this, "Order Not found");
           }else{
           
               Object [] rowData ={orderD.getOrderId(),orderD.getItemCode(),orderD.getItemDescription(),orderD.getUnitPrice(),orderD.getQty()};
               DefaultTableModel dtm = (DefaultTableModel) tblOrdes.getModel();
               dtm.setRowCount(0);
               dtm.addRow(rowData);
           }
       }catch (Exception ex) {
            Logger.getLogger(SelectCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtOrderIdActionPerformed

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
            java.util.logging.Logger.getLogger(SelectOrderpaymentpanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SelectOrderpaymentpanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SelectOrderpaymentpanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SelectOrderpaymentpanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SelectOrderpaymentpanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblOrdes;
    private javax.swing.JTextField txtOrderId;
    // End of variables declaration//GEN-END:variables
}
