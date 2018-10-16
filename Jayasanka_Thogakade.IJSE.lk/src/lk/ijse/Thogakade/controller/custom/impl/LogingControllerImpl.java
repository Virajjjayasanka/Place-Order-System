/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.Thogakade.controller.custom.impl;

import java.util.ArrayList;
import lk.ijse.Thogakade.controller.custom.LoginController;
import lk.ijse.Thogakade.dao.DAOFactory;
import lk.ijse.Thogakade.dao.custom.LoginDAO;
import lk.ijse.Thogakade.dto.LoginDTO;

/**
 *
 * @author Viraj jayasanka
 */
public class LogingControllerImpl implements LoginController {
     private LoginDAO loginDAO;

    public LogingControllerImpl() {
        loginDAO =(LoginDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.Login);
    }
    @Override
    public boolean add(LoginDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(LoginDTO dto) throws Exception {
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
         return loginDAO.searchLogin(userName, password);
    }

    @Override
    public boolean updateLogin(LoginDTO dTO) throws Exception {
        return loginDAO.updateLogin(dTO);
    }

    @Override
    public boolean addLogin(LoginDTO dTO) throws Exception {
        return loginDAO.addLogin(dTO); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteLogin(String userName) throws Exception {
       return loginDAO.deleteLogin(userName);//To change body of generated methods, choose Tools | Templates.
    }
    
}
