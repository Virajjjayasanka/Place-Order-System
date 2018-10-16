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
import lk.ijse.Thogakade.dao.custom.LoginDAO;
import lk.ijse.Thogakade.dto.LoginDTO;
import lk.ijse.Thogakde.db.ConnectionFactory;

/**
 *
 * @author Viraj jayasanka
 */
public class LoginDAOImpl  implements LoginDAO{
    private Connection connection;

    public LoginDAOImpl() {
        connection = ConnectionFactory.getInstance().getConnection();
    }
    
    @Override
    public boolean add(LoginDTO t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(LoginDTO t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String key) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LoginDTO search(String key) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<LoginDTO> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LoginDTO searchLogin(String userName, String password) throws Exception {
       System.out.println(userName);
        String sql = "select * from login where username='"+userName+"' AND password ='"+password+"'";

        LoginDTO login = null;

        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if (rst.next()) {

            login = new LoginDTO(rst.getString("username"),
                    rst.getString("password"));
        }
        return login;
    }

    @Override
    public boolean updateLogin(LoginDTO dTO) throws Exception {
       String sql = "UPDATE login set password = ? WHERE username= ?";

        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(2, dTO.getUserName());
        pstm.setString(1, dTO.getPassword());
        
        int result = pstm.executeUpdate();
        return (result > 0);
    }

    @Override
    public boolean addLogin(LoginDTO dTO) throws Exception {
         String sql = "INSERT INTO login VALUES(?,?)";

        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, dTO.getUserName());
        pstm.setString(2, dTO.getPassword());
        int result = pstm.executeUpdate();

        return (result > 0);
    }

    @Override
    public boolean deleteLogin(String userName) throws Exception {
        String sql = "DELETE FROM login WHERE username ='" + userName + "'";

        Statement stm = connection.createStatement();
        int affectedRows = stm.executeUpdate(sql);

        return (affectedRows > 0);
    }
    
}
