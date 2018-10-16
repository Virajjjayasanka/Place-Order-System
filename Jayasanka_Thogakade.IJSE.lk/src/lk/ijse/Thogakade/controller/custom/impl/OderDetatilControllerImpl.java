/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.Thogakade.controller.custom.impl;

import java.util.ArrayList;
import lk.ijse.Thogakade.controller.custom.OrderController;
import lk.ijse.Thogakade.controller.custom.OrderDetailController;
import lk.ijse.Thogakade.dao.DAOFactory;
import lk.ijse.Thogakade.dao.custom.OrderDetailDAO;
import lk.ijse.Thogakade.dao.custom.PayamentDAO;
import lk.ijse.Thogakade.dto.OrderDTO;
import lk.ijse.Thogakade.dto.OrderDetailDTO;

/**
 *
 * @author Viraj jayasanka
 */
public class OderDetatilControllerImpl implements OrderDetailController{
    private OrderDetailDAO detailDAO;
    public OderDetatilControllerImpl() {
    detailDAO = (OrderDetailDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ORDERDEATAIL);
    }

    @Override
    public boolean add(OrderDetailDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(OrderDetailDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String key) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public OrderDetailDTO search(String key) throws Exception {
        return detailDAO .search(key);
    }

    @Override
    public ArrayList<OrderDetailDTO> getAll() throws Exception {
         return detailDAO.getAll();
    }
  
}
