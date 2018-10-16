/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.Thogakade.views;

import com.sun.glass.events.KeyEvent;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import lk.ijse.Thogakade.common.IDGenerator;
import lk.ijse.Thogakade.controller.ControllerFactory;
import lk.ijse.Thogakade.controller.custom.ItemController;
import lk.ijse.Thogakade.dto.ItemDTO;
import net.sf.jasperreports.components.items.Item;

/**
 *
 * @author Viraj jayasanka
 */
public class addItemPanel extends javax.swing.JPanel {
        private ItemController itemController;
         private DefaultTableModel dtmItem;
    /**
     * Creates new form addItemPanel
     */
    public addItemPanel() {
        initComponents();
        setDate();
        itemController = (ItemController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.ITEM);
        dtmItem = (DefaultTableModel) itemDescription.getModel();
        setEnable(false);
        loadData();
        handleEvents();
        
        ItemCode();
    }
    private void setDate(){
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        txtDate.setText(sdf.format(d));
    }
    
     public void clearFields() {
        txtDescription.setText("");
        txtItemName.setText("");
       // txtItemCode.setText("");
       // txtDate.setText("");
        txtQty.setText("");
      //  txtUnitPrice.setText("");
    }
     private void setEnable(boolean enable, JComponent... cmp) {
        txtItemName.setEnabled(enable);
        txtDescription.setEnabled(enable);
        txtItemCode.setEnabled(enable);
        txtUnitPrice.setEnabled(enable);
        txtQty.setEnabled(enable);
        bttonAddItem.setEnabled(enable);
        buttonDelete.setEnabled(enable);
        txtDate.setEnabled(enable);
        for (JComponent jcmp : cmp) {
            jcmp.setEnabled(!enable);
        }
    }
     
     private void handleEvents() {

        itemDescription.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                if (itemDescription.getSelectedRowCount() <= 0) {
                    return;
                }

                String itemCode = dtmItem.getValueAt(itemDescription.getSelectedRow(), 0).toString();
                try {
                    ItemDTO item = itemController.search(itemCode);

                    if (item != null) {
                        txtItemCode.setText(item.getCode());
                        txtItemName.setText(item.getName());
                        txtUnitPrice.setText(item.getUnitPrice().toString());
                        txtQty.setText(item.getQtyOnHand().toString());
                        txtDescription.setText(item.getDescription());
                        txtDate.setText(item.getDate());
                    }

                    setEnable(true, bttonAddItem, txtItemCode);

                } catch (Exception ex) {
                    Logger.getLogger(addItemPanel.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
     }
     
     
      private void loadData(){
        dtmItem.setRowCount(0);
        try{
            ArrayList<ItemDTO> allItem =itemController.getAll();
            if(allItem == null){
             return ;
            }
            for(ItemDTO item :allItem){
                Object[]rowData ={item.getCode(),item.getName(),item.getDescription(),item.getUnitPrice(),item.getQtyOnHand(),item.getDate()};
                dtmItem.addRow(rowData);
            }
        } catch (Exception ex) {
            Logger.getLogger(addItemPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
      
     private void doValidate() {
        String itemCode = txtItemCode.getText();
        String itemName = txtItemName.getText();       
        String itemDescription = txtDescription.getText();
        String itemUnitPrice = txtUnitPrice.getText();
        String itemQTYHand =txtQty.getText();
        String itemDate = txtDate.getText();
        

        bttonAddItem.setEnabled(false);

        if (!itemCode.isEmpty()) {
            if(!itemName.isEmpty()){
                if(!itemDate.isEmpty()){
                   if (itemDescription.matches("[A-Za-z ]+")) {
                        if (itemUnitPrice.matches("\\b[0-9]*\\.[0-9]{2}\\b")/*!unitPrice.isEmpty()*/) {
                            
                             if(itemQTYHand.matches("[0-9]+")){
                                   bttonAddItem.setEnabled(true);
                            }
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
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtDescription = new javax.swing.JTextField();
        SearchItem = new javax.swing.JTextField();
        txtItemCode = new javax.swing.JTextField();
        txtDate = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        itemDescription = new javax.swing.JTable();
        txtItemName = new javax.swing.JTextField();
        txtQty = new javax.swing.JTextField();
        txtUnitPrice = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        bttonAddItem = new javax.swing.JButton();
        buttonDelete = new javax.swing.JButton();
        UpdateBtn = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        btnNewItem = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Sinhala-Lasitha-1", 3, 36)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/Thogakade/icons/projects-icon4 add item image.png"))); // NOI18N
        jLabel1.setText("ADD ITEM FORM");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 480, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("ITEM DESCRIPTION");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, 20));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("SEATCH ITEM");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("UNIT PRICE");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 140, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("ITEM CODE");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("DATE");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 190, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("ITEM QTY HAND");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 90, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("ITEM NAME");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));

        txtDescription.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtDescription.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDescriptionKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDescriptionKeyReleased(evt);
            }
        });
        add(txtDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, 270, 30));

        SearchItem.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        SearchItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchItemActionPerformed(evt);
            }
        });
        add(SearchItem, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, 270, 30));

        txtItemCode.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtItemCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtItemCodeActionPerformed(evt);
            }
        });
        txtItemCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtItemCodeKeyReleased(evt);
            }
        });
        add(txtItemCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 270, 30));

        txtDate.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        add(txtDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 190, 280, 30));

        itemDescription.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "itemCode", "itemName", "itemDescription", "itemQTYHand", "itemUnitPrice", "itemDate"
            }
        ));
        jScrollPane1.setViewportView(itemDescription);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 1040, 280));

        txtItemName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtItemName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtItemNameActionPerformed(evt);
            }
        });
        add(txtItemName, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 270, 30));

        txtQty.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtQty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQtyActionPerformed(evt);
            }
        });
        txtQty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtQtyKeyReleased(evt);
            }
        });
        add(txtQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 80, 270, 30));

        txtUnitPrice.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtUnitPrice.setText("00.00");
        txtUnitPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUnitPriceActionPerformed(evt);
            }
        });
        txtUnitPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtUnitPriceKeyReleased(evt);
            }
        });
        add(txtUnitPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 130, 280, 30));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/Thogakade/icons/search customer 1.png"))); // NOI18N
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 240, -1, 40));

        bttonAddItem.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bttonAddItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/Thogakade/icons/Add buton item image.png"))); // NOI18N
        bttonAddItem.setText("ADD ITEM");
        bttonAddItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttonAddItemActionPerformed(evt);
            }
        });
        add(bttonAddItem, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 240, 280, 40));

        buttonDelete.setBackground(new java.awt.Color(255, 51, 51));
        buttonDelete.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        buttonDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/Thogakade/icons/delete customer ican1.png"))); // NOI18N
        buttonDelete.setText("DELETE");
        buttonDelete.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        buttonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteActionPerformed(evt);
            }
        });
        add(buttonDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 610, 210, 40));

        UpdateBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        UpdateBtn.setText("UPDATE");
        add(UpdateBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 610, 200, 40));

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton5.setText("REMOVE ALL");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 610, 200, 40));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 1060, 20));

        btnNewItem.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnNewItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/Thogakade/icons/AddItem Ican.png"))); // NOI18N
        btnNewItem.setText("NEW ITEM");
        btnNewItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewItemActionPerformed(evt);
            }
        });
        add(btnNewItem, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 10, 280, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void txtItemCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtItemCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtItemCodeActionPerformed

    private void SearchItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchItemActionPerformed
        String itemCode = SearchItem.getText();

        try {
            ItemDTO clientDTO = itemController.searchItem(itemCode);
            if (clientDTO == null) {
                JOptionPane.showMessageDialog(this, "No Member Found");
            } else {
                txtItemCode.setText(clientDTO.getCode());
                txtItemName.setText(clientDTO.getName());
                txtDescription.setText(clientDTO.getDescription());
                txtQty.setText(""+clientDTO.getQtyOnHand());
                txtUnitPrice.setText(""+clientDTO.getUnitPrice());
                txtDate.setText("" + clientDTO.getDate());
               
            }
        } catch (Exception ex) {
            Logger.getLogger(addItemPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_SearchItemActionPerformed

    private void txtItemNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtItemNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtItemNameActionPerformed

    private void txtQtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQtyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQtyActionPerformed

    private void txtUnitPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUnitPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUnitPriceActionPerformed

    private void buttonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteActionPerformed
       String customerId = dtmItem.getValueAt(itemDescription.getSelectedRow(), 0).toString();
        try {
            boolean deleted = itemController.delete(customerId);
            if (deleted) {
                clearFields();
                setEnable(false);
                loadData();
                itemDescription.clearSelection();
                btnNewItem.requestFocusInWindow();
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
                                          
    }//GEN-LAST:event_buttonDeleteActionPerformed

    private void bttonAddItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttonAddItemActionPerformed
        String itemCode = txtItemCode.getText();
        String itemName = txtItemName.getText();
        String iDescription = txtDescription.getText();
        int    itemQTYHand  = Integer.parseInt(txtQty.getText());
        BigDecimal itemUnitPrice = BigDecimal.valueOf(Double.parseDouble(txtUnitPrice.getText()));
        String itemDate = txtDate.getText();
        
        System.out.println(iDescription);
        
        ItemDTO item = new ItemDTO (itemCode,itemName,iDescription, itemQTYHand, itemUnitPrice,itemDate);

        try {
            
             boolean isAdded = false;
             if(txtItemCode.isEnabled()){
                isAdded = itemController.add(item);
            }else{
                isAdded = itemController.update(item);
            }
            
            if (isAdded) {
                setEnable(false);
                ItemCode();
                loadData();
                JOptionPane.showMessageDialog(this, "Added success");
                clearFields();
                btnNewItem.requestFocusInWindow(); 
            }else{
               
                JOptionPane.showMessageDialog(this,
                        "item has been failed to add",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                txtItemCode.requestFocusInWindow();
                txtItemCode.selectAll();
            }
        } catch (SQLException ex) {
            
           // JOptionPane.showMessageDialog(this,ex);
           String errorMsg;
            switch (ex.getErrorCode()) {
                case 1062:
                    errorMsg = "Duplicate entry has been found. Please enter valid item Id to proceed.";
                    break;
                default:
                    errorMsg = "Item has been failed to add";
                    break;
            }

            JOptionPane.showMessageDialog(this,
                    errorMsg,
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            txtItemCode.requestFocusInWindow();
            txtItemCode.selectAll();
        } catch (Exception ex) {
            Logger.getLogger(AddCustomerFrom.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_bttonAddItemActionPerformed

    private void btnNewItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewItemActionPerformed
       clearFields();

        if (dtmItem.getRowCount() > 0) {
            itemDescription.getSelectionModel().clearSelection();
        }
        setEnable(true, buttonDelete,UpdateBtn);
        txtItemCode.requestFocusInWindow();                                 
    }//GEN-LAST:event_btnNewItemActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       clearFields();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void txtItemCodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtItemCodeKeyReleased
       doValidate();
    }//GEN-LAST:event_txtItemCodeKeyReleased

    private void txtDescriptionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescriptionKeyReleased
        doValidate();
    }//GEN-LAST:event_txtDescriptionKeyReleased

    private void txtUnitPriceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUnitPriceKeyReleased
       doValidate();
    }//GEN-LAST:event_txtUnitPriceKeyReleased

    private void txtQtyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQtyKeyReleased
        doValidate();
    }//GEN-LAST:event_txtQtyKeyReleased

    private void txtDescriptionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescriptionKeyPressed
         if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            bttonAddItem.doClick();
        }
    }//GEN-LAST:event_txtDescriptionKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField SearchItem;
    private javax.swing.JButton UpdateBtn;
    private javax.swing.JButton btnNewItem;
    private javax.swing.JButton bttonAddItem;
    private javax.swing.JButton buttonDelete;
    private javax.swing.JTable itemDescription;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtDescription;
    private javax.swing.JTextField txtItemCode;
    private javax.swing.JTextField txtItemName;
    private javax.swing.JTextField txtQty;
    private javax.swing.JTextField txtUnitPrice;
    // End of variables declaration//GEN-END:variables
private void ItemCode() {
        try {
            String customerId;
            customerId = IDGenerator.getNewID("Item", "itemCode", "I");
           txtItemCode.setText(customerId);
        } catch (SQLException ex) {
            Logger.getLogger(AddCustomerFrom.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddCustomerFrom.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    }

}
