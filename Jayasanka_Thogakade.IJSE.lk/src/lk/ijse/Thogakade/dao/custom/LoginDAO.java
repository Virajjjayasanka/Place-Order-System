/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.Thogakade.dao.custom;

import lk.ijse.Thogakade.dao.SuperDAO;
import lk.ijse.Thogakade.dto.LoginDTO;

/**
 *
 * @author Viraj jayasanka
 */
public interface LoginDAO extends SuperDAO<LoginDTO>{
    public LoginDTO searchLogin(String userName, String password) throws Exception;

    public boolean updateLogin(LoginDTO dTO) throws Exception;

    public boolean addLogin(LoginDTO dTO) throws Exception;

    public boolean deleteLogin(String userName) throws Exception;
}
