/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.Thogakade.dao.custom.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import lk.ijse.Thogakade.dao.custom.ItemDAO;
import lk.ijse.Thogakade.dto.CustomerDTO;
import lk.ijse.Thogakade.dto.ItemDTO;
import lk.ijse.Thogakade.dto.OrderDetailDTO;
import lk.ijse.Thogakde.db.ConnectionFactory;

/**
 *
 * @author Viraj jayasanka
 */
public class ItemDAOImpl implements ItemDAO {

    private Connection connection;

    public ItemDAOImpl() {
        connection = ConnectionFactory.getInstance().getConnection();

    }

    @Override
    public boolean add(ItemDTO itemDTO) throws Exception {
        String sql = "INSERT INTO Item VALUES (?,?,?,?,?,?);";

        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, itemDTO.getCode());
        pstm.setString(2, itemDTO.getName());
        pstm.setString(3, itemDTO.getDescription());
        pstm.setInt(4, itemDTO.getQtyOnHand());
        pstm.setBigDecimal(5, itemDTO.getUnitPrice());
        pstm.setString(6, itemDTO.getDate());

        int result = pstm.executeUpdate();

        return (result > 0);
    }

    @Override
    public boolean update(ItemDTO itemDTO) throws Exception {
        
        String sql = "UPDATE item SET ItemName=? , itemDescription=? ,itemQTYHand=?,itemUnitPrice=? ,itemDate=? WHERE itemCode =? ";

        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, itemDTO.getName());
        pstm.setString(2, itemDTO.getDescription());
        pstm.setInt(3, itemDTO.getQtyOnHand());
        pstm.setBigDecimal(4, itemDTO.getUnitPrice());
        pstm.setString(5, itemDTO.getDate());
         pstm.setString(6, itemDTO.getCode());

        int result = pstm.executeUpdate();

      return (result > 0);
    }

    @Override
    public boolean delete(String code) throws Exception {
        String sql = "DELETE FROM item WHERE code ='" + code + "'";

        Statement stm = connection.createStatement();
        int affectedRows = stm.executeUpdate(sql);

        return (affectedRows > 0);
    }

    @Override
    public ItemDTO search(String key) throws Exception {
        String sql = "SELECT * FROM ITEM WHERE itemCode = '" + key + "'";

        CustomerDTO customer = null;

        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if (rst.next()) {
            ItemDTO itemDTO = new ItemDTO();
            itemDTO.setCode(rst.getString("itemCode"));
            itemDTO.setName(rst.getString("itemName"));
            itemDTO.setDescription(rst.getString("itemDescription"));
            itemDTO.setQtyOnHand(rst.getInt("itemQTYHand"));
            itemDTO.setUnitPrice(rst.getBigDecimal("itemUnitPrice"));
            itemDTO.setDate(rst.getString(" itemDate"));

            return itemDTO;
        }
        return null;
    }

    @Override
    public ArrayList<ItemDTO> getAll() throws Exception {
        String sql = "SELECT * FROM Item";

        ArrayList<ItemDTO> alItem = null;

        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        while (rst.next()) {
            if (alItem == null) {
                alItem = new ArrayList<>();
            }
            ItemDTO itemDTO = new ItemDTO();
            itemDTO.setCode(rst.getString("itemCode"));
            itemDTO.setName(rst.getString("itemName"));
            itemDTO.setDescription(rst.getString("itemDescription"));
            itemDTO.setQtyOnHand(rst.getInt("itemQTYHand"));
            itemDTO.setUnitPrice(rst.getBigDecimal("itemUnitPrice"));
            itemDTO.setDate(rst.getString("itemDate"));
            alItem.add(itemDTO);
        }
        return alItem;
    }

    @Override
    public ItemDTO searchItemName(String name) throws Exception {
        String sql = "SELECT * FROM ITEM WHERE description = '" + name + "'";

        ItemDTO itemDTO = null;

        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if (rst.next()) {
            itemDTO = new ItemDTO();
            itemDTO.setCode(rst.getString(1));
            itemDTO.setName(rst.getString(2));
            itemDTO.setDescription(rst.getString(3));
            itemDTO.setUnitPrice(rst.getBigDecimal(4));
            itemDTO.setQtyOnHand(rst.getInt(5));
            System.out.println("asd");
            return itemDTO;
        }
        return null;
    }

    @Override
    public ItemDTO searchItem(String ID) throws Exception {
        
        String sql = "SELECT \n" +
"* FROM ITEM WHERE itemCode = '" + ID + "'";
        ItemDTO item = null;

        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if (rst.next()) {
            item = new ItemDTO(rst.getString("itemCode"),
                    rst.getString("itemName"),
                    rst.getString("itemDescription"),
                    rst.getInt("itemQTYHand"),
                    rst.getBigDecimal("itemUnitPrice"),
                    rst.getString("itemDate"));

        }
        return item;
 }

    @Override
    public void updateStock(OrderDetailDTO alOrderDetail) {
        try {
            String sql = "UPDATE item SET qtyOnHand=qtyOnHand-? WHERE itemCode =? ";
            
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setInt(1, alOrderDetail.getQty());
            pstm.setString(2, alOrderDetail.getItemCode());
            
            
            int result = pstm.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ItemDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    
  
    }

}
