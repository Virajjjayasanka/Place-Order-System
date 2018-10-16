/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.Thogakade.dto;

import java.io.Serializable;

/**
 *
 * @author Viraj jayasanka
 */
public class AgentDTO extends SuperDTO implements Serializable{
    private String id;
    private String name;
    private String telePoneNO;
    private String Company;
 
    public AgentDTO() {
    }

    public AgentDTO(String id, String name,String telePoneNO, String Company) {
        this.id = id;
        this.name = name;
        this.telePoneNO=telePoneNO;
        this.Company= Company;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the telePoneNO
     */
    public String getTelePoneNO() {
        return telePoneNO;
    }

    /**
     * @param telePoneNO the telePoneNO to set
     */
    public void setTelePoneNO(String telePoneNO) {
        this.telePoneNO = telePoneNO;
    }

    /**
     * @return the Company
     */
    public String getCompany() {
        return Company;
    }

    /**
     * @param Company the Company to set
     */
    public void setCompany(String Company) {
        this.Company = Company;
    }

   
}
