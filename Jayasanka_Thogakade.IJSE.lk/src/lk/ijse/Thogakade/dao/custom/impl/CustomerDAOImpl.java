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
import lk.ijse.Thogakade.dto.CustomerDTO;
import lk.ijse.Thogakde.db.ConnectionFactory;

/**
 *
 * @author Viraj jayasanka
 */
public class CustomerDAOImpl implements CustomerDAO {

    private Connection connection;

    public CustomerDAOImpl() {
        connection = ConnectionFactory.getInstance().getConnection();
    }

    @Override
    public boolean add(CustomerDTO customerDTO) throws Exception {
        String sql = "INSERT INTO Customer VALUES (?,?,?,?,?);";

        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, customerDTO.getId());
        pstm.setString(2, customerDTO.getName());
        pstm.setString(3, customerDTO.getAddress());
        pstm.setString(4, customerDTO.getTelePoneNO());
        pstm.setString(5, customerDTO.getDate());

        int result = pstm.executeUpdate();

        return (result > 0);

    }

    @Override
    public boolean update(CustomerDTO customerDTO) throws Exception {
        String sql = "UPDATE Customer SET AddDate=?,cutomerTelepone_NO=?,customerName=?, customerAdderss=? WHERE customerID =?";

        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, customerDTO.getDate());
        pstm.setString(2, customerDTO.getTelePoneNO());
        pstm.setString(3, customerDTO.getName());
        pstm.setString(4, customerDTO.getAddress());
        pstm.setString(5, customerDTO.getId());

        int result = pstm.executeUpdate();

        return (result > 0);
    }

    @Override
    public boolean delete(String key) throws Exception {
        String sql = "DELETE FROM Customer WHERE customerID ='" + key + "'";

        Statement stm = connection.createStatement();
        int affectedRows = stm.executeUpdate(sql);

        return (affectedRows > 0);
    }

    @Override
    public CustomerDTO search(String key) throws Exception {
        String sql = "SELECT * FROM Customer WHERE customerID = '" + key + "'";

        CustomerDTO customer = null;

        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if (rst.next()) {
            customer = new CustomerDTO(rst.getString("customerID"),
                    rst.getString("customerName"),
                    rst.getString("customerAdderss"),
                    rst.getString("cutomerTelepone_NO"),
                    rst.getString("AddDate"));

        }
        return customer;

    }

    @Override
    public ArrayList<CustomerDTO> getAll() throws Exception {
        String sql = "SELECT * FROM Customer";

        ArrayList<CustomerDTO> alCustomer = null;

        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        while (rst.next()) {
            if (alCustomer == null) {
                alCustomer = new ArrayList<>();
            }
            CustomerDTO dto = new CustomerDTO(
                    rst.getString("customerID"),
                    rst.getString("customerName"),
                    rst.getString("customerAdderss"),
                    rst.getString("cutomerTelepone_NO"),
                    rst.getString("AddDate"));
            alCustomer.add(dto);
        }
        return alCustomer;

    }

   
}
