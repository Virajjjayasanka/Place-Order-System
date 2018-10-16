/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.Thogakade.controller.custom;

import static javafx.scene.input.KeyCode.T;
import lk.ijse.Thogakade.controller.SuperController;
import lk.ijse.Thogakade.dto.ItemDTO;

/**
 *
 * @author Viraj jayasanka
 */
public interface ItemController extends SuperController<ItemDTO>{
    // extends SuperController<CustomerDTO>
    public ItemDTO searchItemName(String name) throws Exception;
    
    public ItemDTO searchItem(String ID) throws Exception;
   
}
