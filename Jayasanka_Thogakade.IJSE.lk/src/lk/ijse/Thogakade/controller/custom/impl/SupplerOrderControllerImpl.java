/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.Thogakade.controller.custom.impl;

import java.util.ArrayList;
import lk.ijse.Thogakade.controller.custom.CustomerController;
import lk.ijse.Thogakade.controller.custom.SupplerOderController;
import lk.ijse.Thogakade.dao.DAOFactory;
import lk.ijse.Thogakade.dao.custom.CustomerDAO;
import lk.ijse.Thogakade.dao.custom.SupplerOrderDAO;
import lk.ijse.Thogakade.dto.CustomerDTO;
import lk.ijse.Thogakade.dto.SupplerOrderDTO;

/**
 *
 * @author Viraj jayasanka
 */
public class SupplerOrderControllerImpl  implements SupplerOderController {
    private SupplerOrderDAO supplerOrderDAO;
    
     public SupplerOrderControllerImpl() {
            supplerOrderDAO =(SupplerOrderDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.SUPPLER_ODER);
     }
    @Override
    public boolean add(SupplerOrderDTO supplerOrderDTO) throws Exception {
       return supplerOrderDAO.add(supplerOrderDTO);
    }

    @Override
    public boolean update(SupplerOrderDTO supplerOrderDTO) throws Exception {
             return supplerOrderDAO.update(supplerOrderDTO);   

    }

    @Override
    public boolean delete(String key) throws Exception {
        return supplerOrderDAO.delete(key);
    }

    @Override
    public SupplerOrderDTO search(String key) throws Exception {
         return supplerOrderDAO.search(key);
    }

    @Override
    public ArrayList<SupplerOrderDTO> getAll() throws Exception {
        return supplerOrderDAO.getAll();
    }

   
}
