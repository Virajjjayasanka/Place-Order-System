/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.Thogakade.dao.custom.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import lk.ijse.Thogakade.dao.custom.AgentDAO;
import lk.ijse.Thogakade.dto.AgentDTO;
import lk.ijse.Thogakade.dto.CustomerDTO;
import lk.ijse.Thogakde.db.ConnectionFactory;

/**
 *
 * @author Viraj jayasanka
 */
public class AgentDAOImpl implements AgentDAO{
    //implements CustomerDAO
     private Connection connection;
    
     public AgentDAOImpl() {
        connection = ConnectionFactory.getInstance().getConnection();

     }

    @Override
    public boolean add(AgentDTO agentDTO) throws Exception {
        String sql = "INSERT INTO Agent VALUES (?,?,?,?);";
        
        PreparedStatement pstm = connection.prepareStatement(sql);   
        pstm.setString(1, agentDTO.getId());
        pstm.setString(2, agentDTO.getName());
        pstm.setString(3,agentDTO.getTelePoneNO());
        pstm.setString(4,agentDTO.getCompany());
        int result = pstm.executeUpdate(); 
        return (result > 0);
    }

    @Override
    public boolean update(AgentDTO agentDTO) throws Exception {
    String sql = "UPDATE  Agent SET agentTelePone_NO=?,name=?, WHERE agentID =?";
        
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1,agentDTO.getCompany());
        pstm.setString(2,agentDTO.getTelePoneNO());
        pstm.setString(3, agentDTO.getName());
        pstm.setString(4, agentDTO.getId());        
        int result = pstm.executeUpdate();
        return (result > 0);    
          }

    @Override
    public boolean delete(String key) throws Exception {
       String sql = "DELETE FROM  Agent WHERE agentID ='" + key + "'";
        
        Statement stm = connection.createStatement();
        int affectedRows = stm.executeUpdate(sql);

        return (affectedRows > 0);
    }

    @Override
    public AgentDTO search(String key) throws Exception {
 String sql = "SELECT * FROM Agent WHERE agentID = '" + key + "'";
        
        AgentDTO agent = null;
        
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if (rst.next()){
            agent  = new  AgentDTO(rst.getString("agentID"),
                    rst.getString("agentName"),
                    rst.getString("agentTelePone_NO"),
                    rst.getString("agentCompany"));
                    
        }
        return agent;
        }

    @Override
    public ArrayList<AgentDTO> getAll() throws Exception {
 String sql = "SELECT * FROM Agent";
        
        ArrayList<AgentDTO> alAgent = null;
        
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        while(rst.next()){
            if (alAgent == null){
                alAgent = new ArrayList<>();
            }
            AgentDTO dto = new AgentDTO(
                    rst.getString("agentID"),
                    rst.getString("agentName"),
                    rst.getString("agentTelePone_NO"),
                    rst.getString("agentCompany"));
            alAgent.add(dto);
        }
        return alAgent;
    
    
    }    
}