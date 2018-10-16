/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.Thogakade.dao.custom;

import lk.ijse.Thogakade.dao.SuperDAO;
import lk.ijse.Thogakade.dto.CustomerDTO;
import lk.ijse.Thogakade.dto.ItemDTO;
import lk.ijse.Thogakade.dto.OrderDetailDTO;

/**
 *
 * @author Viraj jayasanka
 */
public interface ItemDAO extends SuperDAO<ItemDTO> {

    public ItemDTO searchItemName(String name) throws Exception;

    public ItemDTO searchItem(String ID) throws Exception;

    public void updateStock(OrderDetailDTO alOrderDetail);
    
    
}
