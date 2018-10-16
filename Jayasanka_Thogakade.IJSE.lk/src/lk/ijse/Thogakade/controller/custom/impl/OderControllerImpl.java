/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.Thogakade.controller.custom.impl;

import java.sql.Connection;
import java.util.ArrayList;
import lk.ijse.Thogakade.controller.custom.CustomerController;
import lk.ijse.Thogakade.controller.custom.OrderController;
import lk.ijse.Thogakade.dao.DAOFactory;
import lk.ijse.Thogakade.dao.custom.CustomerDAO;
import lk.ijse.Thogakade.dao.custom.ItemDAO;
import lk.ijse.Thogakade.dao.custom.OrderDAO;
import lk.ijse.Thogakade.dao.custom.OrderDetailDAO;
import lk.ijse.Thogakade.dto.CustomerDTO;
import lk.ijse.Thogakade.dto.OrderDTO;
import lk.ijse.Thogakade.dto.OrderDetailDTO;
import lk.ijse.Thogakde.db.ConnectionFactory;

/**
 *
 * @author Viraj jayasanka
 */
public class OderControllerImpl implements OrderController{
      
    private CustomerDAO customerDAO;
    private ItemDAO itemDAO;
    private OrderDAO orderDAO;
    private OrderDetailDAO orderDetailDAO;
    
    public OderControllerImpl() {
        customerDAO = (CustomerDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CUSTOMER);
        itemDAO = (ItemDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ITEM);
        orderDAO = (OrderDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ORDER);
        orderDetailDAO = (OrderDetailDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ORDERDEATAIL);
    }
   
 

    @Override
    public boolean add(OrderDTO dto, ArrayList<OrderDetailDTO> alOrderDetails) throws Exception {
         Connection connection = ConnectionFactory.getInstance().getConnection();
        
        connection.setAutoCommit(false);
        
        boolean result = orderDAO.add(dto);
        
        if (result){
            
            for (OrderDetailDTO alOrderDetail : alOrderDetails) {
                alOrderDetail.setUnitPrice(alOrderDetail.getUnitPrice().setScale(2));
                result = orderDetailDAO.add(alOrderDetail);
                if (!result){
                    itemDAO.updateStock(alOrderDetail);
                    connection.rollback();
                    connection.setAutoCommit(true);
                    return false;
                }
            }
            
            connection.setAutoCommit(true);
            return true;
            
        }else{
            connection.setAutoCommit(true);
            return false;
        }
    }

    @Override
    public boolean add(OrderDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(OrderDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String key) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public OrderDTO search(String key) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<OrderDTO> getAll() throws Exception {
        
        return  orderDAO.getAll();
    }

        
    }

    
    

