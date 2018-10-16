/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.Thogakade.dto;

import java.io.Serializable;

/**
 *  itemCode VARCHAR(20)NOT NULL,
	batchID VARCHAR(20)NOT NULL,
        btchItemExperDate VaraChar(10)Not null,
	batchItemMFDDate VARCHAR(10)NOT NULL,
 * @author Viraj jayasanka
 */
public class batchDTO extends SuperDTO implements Serializable{
    private String ItemCode;
    private String batchID;
    private String btchItemExperDate;
    private String batchItemMFDDate;
    
 
    public batchDTO() {
    }

    public batchDTO(String ItemCode, String batchID, String btchItemExperDate,String batchItemMFDDate) {
        this.ItemCode = ItemCode;
        this.batchID = batchID;
        this.btchItemExperDate = btchItemExperDate;
        this.batchItemMFDDate =batchItemMFDDate;
        
    }

    /**
     * @return the ItemCode
     */
    public String getItemCode() {
        return ItemCode;
    }

    /**
     * @param ItemCode the ItemCode to set
     */
    public void setItemCode(String ItemCode) {
        this.ItemCode = ItemCode;
    }

    /**
     * @return the batchID
     */
    public String getBatchID() {
        return batchID;
    }

    /**
     * @param batchID the batchID to set
     */
    public void setBatchID(String batchID) {
        this.batchID = batchID;
    }

    /**
     * @return the btchItemExperDate
     */
    public String getBtchItemExperDate() {
        return btchItemExperDate;
    }

    /**
     * @param btchItemExperDate the btchItemExperDate to set
     */
    public void setBtchItemExperDate(String btchItemExperDate) {
        this.btchItemExperDate = btchItemExperDate;
    }

    /**
     * @return the batchItemMFDDate
     */
    public String getBatchItemMFDDate() {
        return batchItemMFDDate;
    }

    /**
     * @param batchItemMFDDate the batchItemMFDDate to set
     */
    public void setBatchItemMFDDate(String batchItemMFDDate) {
        this.batchItemMFDDate = batchItemMFDDate;
    }

}
