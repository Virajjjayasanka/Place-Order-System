/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.Thogakade.controller.custom.impl;

import java.util.ArrayList;
import lk.ijse.Thogakade.controller.custom.PaymentController;
import lk.ijse.Thogakade.dao.DAOFactory;
import lk.ijse.Thogakade.dao.custom.OrderDetailDAO;
import lk.ijse.Thogakade.dao.custom.PayamentDAO;
import lk.ijse.Thogakade.dto.pyamentDTO;

/**
 *
 * @author Viraj jayasanka
 */
public class PaymentControllerImpl implements PaymentController{
    private PayamentDAO payamentDAO; 
    public PaymentControllerImpl() {
    payamentDAO = (PayamentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.PYAMENT);
    }
    @Override
    public boolean add(pyamentDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(pyamentDTO dto) throws Exception {
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
       return  payamentDAO.getAll();
    }
   
}
