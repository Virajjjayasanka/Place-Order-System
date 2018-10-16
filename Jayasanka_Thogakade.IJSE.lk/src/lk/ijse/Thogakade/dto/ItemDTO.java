/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.Thogakade.dto;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 *itemCode VARCHAR(20)NOT NULL,
	itemQTYHand INT(100) NOT NULL,
	itemDate VARCHAR(10)NOT NULL,
	itemUnitPrice DECIMAL(6,2) NOT NULL,
	itemDescription VARCHAR(50) NOT NULL,
	CONSTRAINT PRIMARY KEY (itemCode)
 * @author Viraj jayasankav
 */
public class ItemDTO extends SuperDTO implements Serializable {
    private String code;
    private String name;
    private String description;
    private Integer qtyOnHand;
    private BigDecimal unitPrice;
    private String Date;
    
    private String customerId;

    public ItemDTO() {
        
    }

    public ItemDTO(String code, String name, String description, Integer qtyOnHand, BigDecimal unitPrice, String Date) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.qtyOnHand = qtyOnHand;
        this.unitPrice = unitPrice;
        this.Date = Date;
    }

    public ItemDTO(String code, String name, String description, Integer qtyOnHand, BigDecimal unitPrice, String Date, String customerId) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.qtyOnHand = qtyOnHand;
        this.unitPrice = unitPrice;
        this.Date = Date;
        this.customerId = customerId;
    }
   

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
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
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the qtyOnHand
     */
    public Integer getQtyOnHand() {
        return qtyOnHand;
    }

    /**
     * @param qtyOnHand the qtyOnHand to set
     */
    public void setQtyOnHand(Integer qtyOnHand) {
        this.qtyOnHand = qtyOnHand;
    }

    /**
     * @return the unitPrice
     */
    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    /**
     * @param unitPrice the unitPrice to set
     */
    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * @return the Date
     */
    public String getDate() {
        return Date;
    }

    /**
     * @param Date the Date to set
     */
    public void setDate(String Date) {
        this.Date = Date;
    }

    /**
     * @return the customerId
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * @param customerId the customerId to set
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    
   
}
