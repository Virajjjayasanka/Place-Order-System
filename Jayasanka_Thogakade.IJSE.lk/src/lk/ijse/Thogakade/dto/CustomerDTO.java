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
public class CustomerDTO extends SuperDTO implements Serializable {


    private String id;
    private String name;
    private String address;
    private String date;
    private String telePoneNO;
 
    public CustomerDTO() {
    }

    public CustomerDTO(String id, String name, String address,String date,String telePoneNO) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.date =date;
        this.telePoneNO=telePoneNO;
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
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
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

   
}
