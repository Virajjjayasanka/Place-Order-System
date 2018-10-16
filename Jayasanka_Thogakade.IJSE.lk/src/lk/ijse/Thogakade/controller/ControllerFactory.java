/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.Thogakade.controller;

import lk.ijse.Thogakade.controller.custom.AgentController;
import lk.ijse.Thogakade.controller.custom.OrderController;
import lk.ijse.Thogakade.controller.custom.OrderDetailController;
import lk.ijse.Thogakade.controller.custom.impl.AgentControllerImpl;
import lk.ijse.Thogakade.controller.custom.impl.BatchControllerImpl;
import lk.ijse.Thogakade.controller.custom.impl.CustomerControllerImpl;
import lk.ijse.Thogakade.controller.custom.impl.ItemControllerImpl;
import lk.ijse.Thogakade.controller.custom.impl.LogingControllerImpl;
import lk.ijse.Thogakade.controller.custom.impl.OderControllerImpl;
import lk.ijse.Thogakade.controller.custom.impl.OderDetatilControllerImpl;
import lk.ijse.Thogakade.controller.custom.impl.PaymentControllerImpl;
import lk.ijse.Thogakade.controller.custom.impl.SupplerOrderControllerImpl;
import lk.ijse.Thogakade.dao.custom.impl.OrderDAOImpl;
import lk.ijse.Thogakade.dao.custom.impl.OrderDetailDAOImpl;
import net.sf.jasperreports.components.items.ItemCompiler;

/**
 *
 * @author Viraj jayasanka
 */
public class ControllerFactory {
    public enum ControllerTypes{
        CUSTOMER,ORDER,ORDERDETAIL, PYAMENT,BATCH,ITEM,SUPPLER_ODER,ITEM_DEATAIL,SUPPLER_PAYMENT,AGENTDEATIL,GRN,DAMGE_ITEM,Login;
       // CUSTOMER, ITEM, ORDER, ORDER_DETAIL;
    }
    
    private static ControllerFactory ctrlFactory;
    
    private ControllerFactory(){
        
    }
    
    public static ControllerFactory getInstance(){
        if (ctrlFactory == null){
            ctrlFactory = new ControllerFactory();
        }
        return ctrlFactory;
    }
    
    public SuperController getController(ControllerTypes controllerTypes) {
        switch (controllerTypes){
            case CUSTOMER:
                  return new CustomerControllerImpl();
            case ORDER:
                return new OderControllerImpl();
            case ORDERDETAIL:
              return new OderDetatilControllerImpl();
            case ITEM:
                return new ItemControllerImpl();
            case AGENTDEATIL:
                return new AgentControllerImpl();
            case SUPPLER_ODER:
                return new SupplerOrderControllerImpl();
            case BATCH:
                return new BatchControllerImpl();
            case PYAMENT:
                return new PaymentControllerImpl();
            case Login:
                return new LogingControllerImpl();
            default:
                return null;
        }
    }
}
