/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.Thogakade.controller.custom.impl;

import java.util.ArrayList;
import lk.ijse.Thogakade.controller.custom.AgentController;
import lk.ijse.Thogakade.dao.DAOFactory;
import lk.ijse.Thogakade.dao.custom.AgentDAO;
import lk.ijse.Thogakade.dao.custom.CustomerDAO;
import lk.ijse.Thogakade.dto.AgentDTO;

/**
 *
 * @author Viraj jayasanka
 */
public class AgentControllerImpl implements AgentController{
    //implements CustomerController
    private AgentDAO agentDAO;
    
     public AgentControllerImpl() {
            agentDAO =(AgentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.AGENTDEATIL);
    
        }

    @Override
    public boolean add(AgentDTO agentDTO) throws Exception {
          return agentDAO.add(agentDTO);
    }

    @Override
    public boolean update(AgentDTO agentDTO) throws Exception {
         return agentDAO.update(agentDTO);   
    }

    @Override
    public boolean delete(String key) throws Exception {
        return agentDAO.delete(key);
    }

    @Override
    public AgentDTO search(String key) throws Exception {
         return agentDAO.search(key);
    }

    @Override
    public ArrayList<AgentDTO> getAll() throws Exception {
        return agentDAO.getAll();
    }
}
