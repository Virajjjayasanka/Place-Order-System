/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.Thogakade.controller.custom.impl;

import java.util.ArrayList;
import lk.ijse.Thogakade.controller.custom.BatchController;
import lk.ijse.Thogakade.dao.DAOFactory;
import lk.ijse.Thogakade.dao.custom.BatchDAO;
import lk.ijse.Thogakade.dto.batchDTO;

/**
 *
 * @author Viraj jayasanka
 */
public class BatchControllerImpl implements BatchController{
    
     private BatchDAO batchDAO;
    
     public BatchControllerImpl() {
            batchDAO =(BatchDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.BATCH);
     }
    @Override
    public boolean add(batchDTO BatchDTO) throws Exception {
        return batchDAO.add(BatchDTO);
    }

    @Override
    public boolean update(batchDTO BatchDTO) throws Exception {
         return batchDAO.update(BatchDTO);   
    }

    @Override
    public boolean delete(String key) throws Exception {
       return batchDAO.delete(key);
    }

    @Override
    public batchDTO search(String key) throws Exception {
         return batchDAO.search(key);
    }

    @Override
    public ArrayList<batchDTO> getAll() throws Exception {
        return batchDAO.getAll();
    }
    
}
