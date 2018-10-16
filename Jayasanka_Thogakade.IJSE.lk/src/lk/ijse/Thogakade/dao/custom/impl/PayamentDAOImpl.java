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
import lk.ijse.Thogakade.controller.custom.PaymentController;
import lk.ijse.Thogakade.dao.custom.PayamentDAO;
import lk.ijse.Thogakade.dto.CustomerDTO;
import lk.ijse.Thogakade.dto.OrderDTO;
import lk.ijse.Thogakade.dto.OrderDetailDTO;
import lk.ijse.Thogakade.dto.pyamentDTO;
import lk.ijse.Thogakde.db.ConnectionFactory;

/**
 *
 * @author Viraj jayasanka
 */
public class PayamentDAOImpl implements PayamentDAO{
     private Connection connection;

    public PayamentDAOImpl() {
        connection = ConnectionFactory.getInstance().getConnection();
    }
    @Override
    public boolean add(pyamentDTO PyamentDTO) throws Exception {
         String sql = "INSERT INTO Payment VALUES (?,?,?,?);";

        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, PyamentDTO.getOderid());
        pstm.setString(2, PyamentDTO.getPaymentDate());
        pstm.setString(3, PyamentDTO.getPaymentID());
        pstm.setDouble(4, PyamentDTO.getPaymentAmount());
        int result = pstm.executeUpdate();

        return (result > 0);
    }

    @Override
    public boolean update(pyamentDTO t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String key) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public pyamentDTO search(String key) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<pyamentDTO> getAll() throws Exception {
         return null;
     
    
}
}
