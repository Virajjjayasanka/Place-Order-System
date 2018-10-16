/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.Thogakade.dao.custom.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import lk.ijse.Thogakade.dao.custom.CustomerDAO;
import lk.ijse.Thogakade.dao.custom.OrderDAO;
import lk.ijse.Thogakade.dto.OrderDTO;
import lk.ijse.Thogakde.db.ConnectionFactory;

/**
 *  private Connection connection;
        public OrderDAOImpl(){
        connection = ConnectionFactory.getInstance().getConnection();
 * @author Viraj jayasanka
 */
public class OrderDAOImpl implements OrderDAO{
    private Connection connection;
        public OrderDAOImpl(){
        connection = ConnectionFactory.getInstance().getConnection();
        }   
    @Override
    public boolean add(OrderDTO t) throws Exception {
        String sql = "INSERT INTO Orders VALUES(?,?,?)";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, t.getId());
        pstm.setString(2, t.getDate());
        pstm.setString(3, t.getCustomerId());
        
        int affectedRows = pstm.executeUpdate();
        return (affectedRows > 0);
    
    }

    @Override
    public boolean update(OrderDTO t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String key) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public OrderDTO search(String key) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<OrderDTO> getAll() throws Exception {
        String sql = "SELECT * FROM orders";

        ArrayList<OrderDTO> alOrders = null;

        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        while (rst.next()) {
            if (alOrders == null) {
                alOrders = new ArrayList<>();
            }
            OrderDTO dto = new OrderDTO(
                    rst.getString("oderid"),
                    rst.getString("date"),
                    rst.getString("customerID"));
                    
            alOrders.add(dto);
        }
        return alOrders;

    }

    
    
}
