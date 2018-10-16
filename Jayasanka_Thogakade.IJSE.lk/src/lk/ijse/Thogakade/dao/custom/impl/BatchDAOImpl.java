/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.Thogakade.dao.custom.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import lk.ijse.Thogakade.dao.custom.BatchDAO;
import lk.ijse.Thogakade.dao.custom.CustomerDAO;
import lk.ijse.Thogakade.dto.CustomerDTO;
import lk.ijse.Thogakade.dto.batchDTO;
import lk.ijse.Thogakde.db.ConnectionFactory;

/**
 *
 * @author Viraj jayasanka
 */
public class BatchDAOImpl implements BatchDAO{

     private Connection connection;

    public BatchDAOImpl() {
        connection = ConnectionFactory.getInstance().getConnection();
    }
    
    @Override
    public boolean add(batchDTO BatchDTO) throws Exception {
        String sql = "INSERT INTO Batch VALUES (?,?,?,?);";

        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, BatchDTO.getItemCode());
        pstm.setString(2, BatchDTO.getBatchID());
        pstm.setString(3, BatchDTO.getBtchItemExperDate());
        pstm.setString(4, BatchDTO.getBatchItemMFDDate());
        

        int result = pstm.executeUpdate();

        return (result > 0);
    }

    @Override
    public boolean update(batchDTO BatchDTO) throws Exception {
         String sql = "UPDATE Batch SET itemCode=?,btchItemExperDate=?,batchItemMFDDate=? WHERE batchID =?";

        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, BatchDTO.getItemCode());
        pstm.setString(2, BatchDTO.getBtchItemExperDate());
        pstm.setString(3, BatchDTO.getBatchItemMFDDate());
        pstm.setString(4, BatchDTO.getBatchID());

        int result = pstm.executeUpdate();

        return (result > 0);
    }

    @Override
    public boolean delete(String key) throws Exception {
        String sql = "DELETE FROM Batch WHERE batchID ='" + key + "'";

        Statement stm = connection.createStatement();
        int affectedRows = stm.executeUpdate(sql);

        return (affectedRows > 0);
    }

    @Override
    public batchDTO search(String key) throws Exception {
         String sql = "SELECT * FROM Batch WHERE batchID = '" + key + "'";

        batchDTO batch = null;

        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if (rst.next()) {
            batch = new batchDTO(rst.getString("itemCode"),
                    rst.getString("batchID"),
                    rst.getString("btchItemExperDate"),
                    rst.getString("batchItemMFDDate"));
                   

        }
        return batch;
    }

    @Override
    public ArrayList<batchDTO> getAll() throws Exception {
       String sql = "SELECT * FROM Batch";

        ArrayList<batchDTO> albatch = null;

        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        while (rst.next()) {
            if (albatch == null) {
                albatch = new ArrayList<>();
            }
            batchDTO dto = new batchDTO(
                    rst.getString("itemCode"),
                    rst.getString("batchID"),
                    rst.getString("btchItemExperDate"),
                    rst.getString("batchItemMFDDate"));
                    
            albatch.add(dto);
        }
        return albatch;
    }
    
}
