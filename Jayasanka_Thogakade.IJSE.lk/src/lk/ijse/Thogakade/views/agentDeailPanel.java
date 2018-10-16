/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.Thogakade.views;

import com.sun.glass.events.KeyEvent;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
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
import lk.ijse.Thogakade.controller.custom.AgentController;
import lk.ijse.Thogakade.dto.AgentDTO;

/**
 * private CustomerController ctrlCustomer;
     private DefaultTableModel dtmCustomer;
 * @author Viraj jayasanka
 */
public class agentDeailPanel extends javax.swing.JPanel {
    private AgentController agentController;
    private DefaultTableModel dtmAgent;
            
    /**
     * Creates new form agentDeailPanel
     */
    public agentDeailPanel() {
        initComponents();
        agentController = (AgentController)ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.AGENTDEATIL);
       // ctrlAgent = (AgentController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.AGENTDEATIL);
        dtmAgent = (DefaultTableModel) AddAgentTabel.getModel();
        setEnable(false);
        loadData();
        handleEvents();
        AgentID();
    }
    
    
     private void handleEvents() {

        AddAgentTabel.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                if (AddAgentTabel.getSelectedRowCount() <= 0) {
                    return;
                }

                String agentId = dtmAgent.getValueAt(AddAgentTabel.getSelectedRow(), 0).toString();
                try {
                    AgentDTO agent =agentController.search(agentId);

                    if (agent != null) {
                        txtAgentId.setText(agent.getId());
                        txtNamerName.setText(agent.getName());
                        txtAgentTelePoneNo.setText(agent.getTelePoneNO());
                        txtCompanyName.setText(agent.getCompany());
                    }
                    setEnable(true, btnAddAgent, txtAgentId);
                    

                } catch (Exception ex) {
                    Logger.getLogger(agentDeailPanel.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

    }
    
     //SetEnEnabele 
     private void setEnable(boolean enable, JComponent... cmp) {
        txtAgentId.setEnabled(enable);
        txtNamerName.setEnabled(enable);
        txtAgentTelePoneNo.setEnabled(enable);
        txtCompanyName.setEnabled(enable);
        btnAddAgent.setEnabled(enable);
        btnDelete.setEnabled(enable);
        btnRemove.setEnabled(enable);
        for (JComponent jcmp : cmp) {
            jcmp.setEnabled(!enable);
        }
    }
     private void doValidate() {
        String agentId = txtAgentId.getText();
        String agentName = txtNamerName.getText();
        String agentTelePoneNo = txtAgentTelePoneNo.getText(); 
        String agentCompany = txtCompanyName.getText();
        btnAddAgent.setEnabled(false);
        //btnAddAgent.setEnabled(false);
        //btnRemove.setEnabled(false);


        if (!agentId.isEmpty()) {
            if (agentName.matches("[A-Za-z ]+")) {
                if (!agentTelePoneNo.isEmpty()) {
                    if(!agentCompany.isEmpty()){
                    btnAddAgent.setEnabled(true);
                     }
                }
            }
        }
     }
    //clearFields
      private void clearFields() {
     //   txtCustomerId.setText("");
        txtNamerName.setText("");
          txtAgentTelePoneNo.setText("");
          txtCompanyName.setText("");
        
    }


//loadData
     private void loadData() {

        dtmAgent.setRowCount(0);

        try {
            ArrayList<AgentDTO> allAgents = agentController.getAll();

            if (allAgents == null) {
                return;
            }

            for (AgentDTO agent : allAgents) {
                Object[] rowData = {
                    agent.getId(),
                    agent.getName(),
                    agent.getTelePoneNO(),
                    agent.getCompany(),
                };
                dtmAgent.addRow(rowData);
            }
        } catch (Exception ex) {
            Logger.getLogger(agentDeailPanel.class.getName()).log(Level.SEVERE, null, ex);
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
        btnDelete = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtAgentId = new javax.swing.JTextField();
        txtNamerName = new javax.swing.JTextField();
        txtAgentTelePoneNo = new javax.swing.JTextField();
        btnAddAgent = new javax.swing.JButton();
        jTextField6 = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        AddAgentTabel = new javax.swing.JTable();
        btnRemove = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtCompanyName = new javax.swing.JTextField();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Sinhala-Lasitha-1", 3, 36)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/Thogakade/icons/AgentADDFROM image.png"))); // NOI18N
        jLabel1.setText("AGENT DEATILS ");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 470, 80));

        btnDelete.setBackground(new java.awt.Color(255, 51, 51));
        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/Thogakade/icons/delete customer ican1.png"))); // NOI18N
        btnDelete.setText("DELETE");
        btnDelete.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 610, 200, 40));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/Thogakade/icons/update Customer.png"))); // NOI18N
        jButton2.setText("UPDATE");
        jButton2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 310, 190, 40));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setText("VIEW ALL ");
        add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 310, 220, 40));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 1080, 20));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Tele Pone No");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("SEARCH AGENT ID");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Agent Id");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Agent Name");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, -1, -1));

        txtAgentId.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtAgentId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAgentIdKeyReleased(evt);
            }
        });
        add(txtAgentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 130, 280, 30));

        txtNamerName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtNamerName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNamerNameKeyReleased(evt);
            }
        });
        add(txtNamerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 180, 280, 30));

        txtAgentTelePoneNo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtAgentTelePoneNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAgentTelePoneNoActionPerformed(evt);
            }
        });
        txtAgentTelePoneNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAgentTelePoneNoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAgentTelePoneNoKeyReleased(evt);
            }
        });
        add(txtAgentTelePoneNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 230, 280, 30));

        btnAddAgent.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAddAgent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/Thogakade/icons/Add button ican 4.png"))); // NOI18N
        btnAddAgent.setText("ADD AGENT");
        btnAddAgent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddAgentActionPerformed(evt);
            }
        });
        add(btnAddAgent, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 200, 440, 40));
        add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 320, 280, 30));
        add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 1080, 10));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/Thogakade/icons/search customer 1.png"))); // NOI18N
        add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 310, 60, 40));

        AddAgentTabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Agent Id", "agentName", "Tele Pone No", "Agent Compane Name"
            }
        ));
        AddAgentTabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddAgentTabelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(AddAgentTabel);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, 1020, 230));

        btnRemove.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnRemove.setText("REMOVE");
        add(btnRemove, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 610, 210, 40));

        btnNew.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/Thogakade/icons/New Btn Ican.png"))); // NOI18N
        btnNew.setText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });
        add(btnNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 20, 260, 40));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Agent Compane Name");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 140, -1, -1));

        txtCompanyName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCompanyNameActionPerformed(evt);
            }
        });
        add(txtCompanyName, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 130, 280, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void txtAgentTelePoneNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAgentTelePoneNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAgentTelePoneNoActionPerformed

    private void AddAgentTabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddAgentTabelMouseClicked
        int r = AddAgentTabel.getSelectedRow();
           String AgentID = AddAgentTabel.getValueAt(r, 0).toString();
            String AgentName = AddAgentTabel.getValueAt(r, 1).toString();
              String AgentTelePoneNo = AddAgentTabel.getValueAt(r, 2).toString();
              String AgentCompany = AddAgentTabel.getValueAt(r, 3).toString();
              
               txtAgentId.setText(AgentID);
               txtNamerName.setText(AgentName);
               txtAgentTelePoneNo.setText(AgentTelePoneNo);
               txtCompanyName.setText(AgentCompany);
    }//GEN-LAST:event_AddAgentTabelMouseClicked

    private void btnAddAgentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddAgentActionPerformed
       AgentDTO agentDTO = new AgentDTO(
                txtAgentId.getText(),
                txtNamerName.getText(),
                txtAgentTelePoneNo.getText(),
                txtCompanyName.getText());


        try {
            
            boolean result = false;
            if (txtAgentId.isEnabled()){
                result = agentController.add(agentDTO);                
            }else{
                result =agentController.update(agentDTO);
            }
            if (result) {
                AgentID();
                loadData();
                clearFields();
                setEnable(false);
                btnNew.requestFocusInWindow();
                JOptionPane.showMessageDialog(this, "Agent Add success");
            } else {
                JOptionPane.showMessageDialog(this,
                        "agent has been failed to add",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                txtAgentId.requestFocusInWindow();
                txtAgentId.selectAll();
            }
        } catch (SQLException ex) {
            String errorMsg;
              switch (ex.getErrorCode()) {
                case 1062:
                    errorMsg = "Duplicate entry has been found. Please enter valid Agent Id to proceed.";
                    break;
                default:
                    errorMsg = "Agent has been failed to add";
                    break;
            }

            JOptionPane.showMessageDialog(this,
                    errorMsg,
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
               
            txtAgentId.requestFocusInWindow();
            txtAgentId.selectAll();
        } catch (Exception ex) {
            Logger.getLogger(agentDeailPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        
    }//GEN-LAST:event_btnAddAgentActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
         clearFields();

        if (dtmAgent.getRowCount() > 0) {
            AddAgentTabel.getSelectionModel().clearSelection();
        }
        setEnable(true,btnDelete);
        txtAgentId.requestFocusInWindow();
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
       String agentId = dtmAgent.getValueAt(AddAgentTabel.getSelectedRow(), 0).toString();
        try {
            boolean deleted = agentController.delete(agentId);
            if (deleted) {
                clearFields();
                setEnable(false);
                loadData();
                AddAgentTabel.clearSelection();
                btnNew.requestFocusInWindow();
                JOptionPane.showMessageDialog(this, "Deleted");
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
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void txtAgentIdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAgentIdKeyReleased
        doValidate();
    }//GEN-LAST:event_txtAgentIdKeyReleased

    private void txtNamerNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNamerNameKeyReleased
         doValidate();
    }//GEN-LAST:event_txtNamerNameKeyReleased

    private void txtAgentTelePoneNoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAgentTelePoneNoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnAddAgent.doClick();
        }
    }//GEN-LAST:event_txtAgentTelePoneNoKeyPressed

    private void txtAgentTelePoneNoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAgentTelePoneNoKeyReleased
       // doValidate();
    }//GEN-LAST:event_txtAgentTelePoneNoKeyReleased

    private void txtCompanyNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCompanyNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCompanyNameActionPerformed

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
                new agentDeailPanel().setVisible(true);
            }
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable AddAgentTabel;
    private javax.swing.JButton btnAddAgent;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField txtAgentId;
    private javax.swing.JTextField txtAgentTelePoneNo;
    private javax.swing.JTextField txtCompanyName;
    private javax.swing.JTextField txtNamerName;
    // End of variables declaration//GEN-END:variables

private void AgentID() {
        try {
            String agentID;
            agentID = IDGenerator.getNewID("Agent", "agentID", "A");
            txtAgentId.setText(agentID);
        } catch (SQLException ex) {
            Logger.getLogger(AddCustomerFrom.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddCustomerFrom.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    }
}


