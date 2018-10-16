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
public class SupplerOrderDTO extends SuperDTO implements Serializable {
    private String id;
    private String name;
    private String date;
    private int SpplerOrderQTY;
   
  
 
    public SupplerOrderDTO() {
    }

    public SupplerOrderDTO(String id, String name,String date,int SpplerOrderQTY) {
        this.id = id;
        this.name = name;
        this.date =date;
        this.SpplerOrderQTY=SpplerOrderQTY;
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
     * @return the SpplerOrderQTY
     */
    public int getSpplerOrderQTY() {
        return SpplerOrderQTY;
    }

    /**
     * @param SpplerOrderQTY the SpplerOrderQTY to set
     */
    public void setSpplerOrderQTY(int SpplerOrderQTY) {
        this.SpplerOrderQTY = SpplerOrderQTY;
    }

   

}
