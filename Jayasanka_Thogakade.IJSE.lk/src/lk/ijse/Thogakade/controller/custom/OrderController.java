/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.Thogakade.controller.custom;

import java.util.ArrayList;
import lk.ijse.Thogakade.controller.SuperController;
import lk.ijse.Thogakade.dao.SuperDAO;
import lk.ijse.Thogakade.dto.OrderDTO;
import lk.ijse.Thogakade.dto.OrderDetailDTO;
import lk.ijse.Thogakade.dto.SuperDTO;

/**
 *
 * @author Viraj jayasanka
 */
public interface OrderController extends SuperController<OrderDTO>{
     public boolean add(OrderDTO dto, ArrayList<OrderDetailDTO> alOrderDetails) throws Exception;
}
