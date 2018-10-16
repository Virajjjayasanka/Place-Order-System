/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.Thogakade.dao;


import static com.mysql.jdbc.Util.cast;
import lk.ijse.Thogakade.dao.custom.OrderDAO;
import lk.ijse.Thogakade.dao.custom.OrderDetailDAO;
import lk.ijse.Thogakade.dao.custom.impl.AgentDAOImpl;
import lk.ijse.Thogakade.dao.custom.impl.BatchDAOImpl;
import lk.ijse.Thogakade.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.Thogakade.dao.custom.impl.ItemDAOImpl;
import lk.ijse.Thogakade.dao.custom.impl.LoginDAOImpl;
import lk.ijse.Thogakade.dao.custom.impl.OrderDAOImpl;
import lk.ijse.Thogakade.dao.custom.impl.OrderDetailDAOImpl;
import lk.ijse.Thogakade.dao.custom.impl.PayamentDAOImpl;
import lk.ijse.Thogakade.dao.custom.impl.SupplerOrderDAOImpl;
import sun.management.Agent;
/**
 *
 * @author Viraj jayasanka
 */
public class DAOFactory {
    
    public enum DAOTypes{
       CUSTOMER,ORDER,ORDERDEATAIL, PYAMENT,BATCH,ITEM,SUPPLER_ODER,ITEM_DEATAIL,SUPPLER_PAYMENT,AGENTDEATIL,GRN,DAMGE_ITEM,Login;
    }
    
    private static DAOFactory daoFactory;
    
    private DAOFactory(){
        
    }
    
    public static DAOFactory getInstance(){
        if (daoFactory == null){
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }
    
    public SuperDAO getDAO(DAOTypes daoType) {
        switch(daoType){
            case CUSTOMER :
              return new  CustomerDAOImpl();
            case ORDER:
                return new OrderDAOImpl();
            case ORDERDEATAIL:
              return new OrderDetailDAOImpl();
            case ITEM:
                return new ItemDAOImpl();
            case AGENTDEATIL:
                return new AgentDAOImpl();
            case SUPPLER_ODER:
                return new SupplerOrderDAOImpl();
            case BATCH:
                return new BatchDAOImpl();
            case PYAMENT:
                return  new PayamentDAOImpl();
            case Login:
               return new LoginDAOImpl();
            default:
                return null;
        }
    }
    
}