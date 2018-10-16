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
import lk.ijse.Thogakade.dao.custom.OrderDetailDAO;
import lk.ijse.Thogakade.dto.OrderDetailDTO;
import lk.ijse.Thogakde.db.ConnectionFactory;

/**
 *
 * @author Viraj jayasanka
 */
public class OrderDetailDAOImpl implements OrderDetailDAO{
     private Connection connection;
    
    public OrderDetailDAOImpl(){
        connection = ConnectionFactory.getInstance().getConnection();
    }
   
    @Override
    public boolean add(OrderDetailDTO t) throws Exception {
        String sql = "INSERT INTO OrderDetil VALUES (?,?,?,?,?)";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, t.getOrderId());
        pstm.setString(2, t.getItemCode());
        pstm.setString(3,t.getItemDescription());
        pstm.setBigDecimal(4, t.getUnitPrice());
        pstm.setInt(5, t.getQty());
        int affectedRows = pstm.executeUpdate();
        return (affectedRows > 0);
    }

    @Override
    public boolean update(OrderDetailDTO t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String key) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public OrderDetailDTO search(String key) throws Exception {
    String sql = "SELECT * FROM orderdetil WHERE oderid = '" + key + "'";

        OrderDetailDTO order = null;

        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if (rst.next()) {
            order = new OrderDetailDTO(rst.getString("oderid"),
                    rst.getString("itemCode"),
                    rst.getString("Description"),
                    rst.getBigDecimal("unitPrice"),
                    rst.getInt("itemQTYHand"));

        }
        return order;
    }

    @Override
    public ArrayList<OrderDetailDTO> getAll() throws Exception {
         String sql = "SELECT * FROM orderdetil";

        ArrayList<OrderDetailDTO> alOrderD = null;

        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        while (rst.next()) {
            if (alOrderD == null) {
                alOrderD = new ArrayList<>();
            }
            OrderDetailDTO dto = new OrderDetailDTO(
                    rst.getString("oderid"),
                    rst.getString("itemCode"),
                    rst.getString("Description"),
                    rst.getBigDecimal("unitPrice"),
                    rst.getInt("itemQTYHand"));
                     
                    
            alOrderD.add(dto);
        }
        return alOrderD;

    }
    
    //implements CustomerDAO
}
