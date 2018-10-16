/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.Thogakade.controller.custom.impl;

import java.util.ArrayList;
import lk.ijse.Thogakade.controller.custom.ItemController;
import lk.ijse.Thogakade.dao.DAOFactory;
import lk.ijse.Thogakade.dao.custom.ItemDAO;
import lk.ijse.Thogakade.dto.ItemDTO;

/**
 *
 * @author Viraj jayasanka
 */
public class ItemControllerImpl implements ItemController {

    private ItemDAO itemDAO;

    public ItemControllerImpl() {
        itemDAO = (ItemDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ITEM);

    }

    @Override
    public boolean add(ItemDTO itemDTO) throws Exception {
        return itemDAO.add(itemDTO);
    }

    @Override
    public boolean update(ItemDTO itemDTO) throws Exception {
        return itemDAO.update(itemDTO);
    }

    @Override
    public boolean delete(String key) throws Exception {
        return itemDAO.delete(key);
    }

    @Override
    public ItemDTO search(String key) throws Exception {
        return itemDAO.search(key);
    }

    @Override
    public ArrayList<ItemDTO> getAll() throws Exception {
        return itemDAO.getAll();
    }

    @Override
    
    
    public ItemDTO searchItemName(String name) throws Exception {
        return itemDAO.searchItemName(name);
    }

    @Override
    public ItemDTO searchItem(String ID) throws Exception {
        return itemDAO.searchItem(ID);
    }
}
