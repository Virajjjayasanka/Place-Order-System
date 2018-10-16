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
import lk.ijse.Thogakade.dao.custom.CustomerDAO;
import lk.ijse.Thogakade.dao.custom.SupplerOrderDAO;
import lk.ijse.Thogakade.dto.CustomerDTO;
import lk.ijse.Thogakade.dto.OrderDetailDTO;
import lk.ijse.Thogakade.dto.SupplerOrderDTO;
import lk.ijse.Thogakde.db.ConnectionFactory;

/**
 *
 * @author Viraj jayasanka
 */
public class SupplerOrderDAOImpl implements SupplerOrderDAO {
      private Connection connection;

    public SupplerOrderDAOImpl() {
        connection = ConnectionFactory.getInstance().getConnection();
    }

    @Override
    public boolean add(SupplerOrderDTO supplerOrder) throws Exception {
          String sql = "INSERT INTO SupplerOrders VALUES (?,?,?,?);";

        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, supplerOrder.getId());
        pstm.setString(2, supplerOrder.getName());
        pstm.setString(3, supplerOrder.getDate());
        pstm.setInt(4, supplerOrder.getSpplerOrderQTY());

        int result = pstm.executeUpdate();

        return (result > 0);
    }

    @Override
    public boolean update(SupplerOrderDTO supplerOrder) throws Exception {
        String sql = "UPDATE SupplerOrders SET SuOr_Name=?,suOR_Date=?,SuOr_QTY=? WHERE suOr_ID =?";

        PreparedStatement pstm = connection.prepareStatement(sql);

        
        pstm.setString(1, supplerOrder.getName());
        pstm.setString(2, supplerOrder.getDate());
        pstm.setInt(3, supplerOrder.getSpplerOrderQTY());
        pstm.setString(4, supplerOrder.getId());
        int result = pstm.executeUpdate();
        

        return (result > 0);
    }

    @Override
    public boolean delete(String key) throws Exception {
        String sql = "DELETE FROM SupplerOrders WHERE customerID ='" + key + "'";

        Statement stm = connection.createStatement();
        int affectedRows = stm.executeUpdate(sql);

        return (affectedRows > 0);
    }

    @Override
    public SupplerOrderDTO search(String key) throws Exception {
        String sql = "SELECT * FROM SupplerOrders WHERE suOr_ID = '" + key + "'";

        SupplerOrderDTO suppler = null;

        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if (rst.next()) {
            suppler = new SupplerOrderDTO(rst.getString("suOr_ID"),
                    rst.getString("SuOr_Name"),
                    rst.getString("suOR_Date"),
                    rst.getInt("SuOr_QTY"));
                    

        }
        return suppler;

    }

    @Override
    public ArrayList<SupplerOrderDTO> getAll() throws Exception {
         String sql = "SELECT * FROM SupplerOrders";

        ArrayList<SupplerOrderDTO> alSuppler = null;

        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        while (rst.next()) {
            if (alSuppler == null) {
                alSuppler = new ArrayList<>();
            }
            SupplerOrderDTO dto = new SupplerOrderDTO(
                    rst.getString("suOr_ID"),
                    rst.getString("SuOr_Name"),
                    rst.getString("suOR_Date"),
                    rst.getInt("SuOr_QTY"));
                  
            alSuppler.add(dto);
        }
        return alSuppler;

    }
    }
    
    

