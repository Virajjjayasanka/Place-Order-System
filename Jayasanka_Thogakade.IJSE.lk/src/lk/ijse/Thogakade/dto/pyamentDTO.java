/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.Thogakade.dto;

import java.io.Serializable;

/**
 *  oderid VARCHAR(10)NOT NULL,
	paymentID VARCHAR(10)NOT NULL,
	paymentDate VARCHAR(10)NOT NULL,
	paymentTime Time,
	paymentAmount DECIMAL(6,2) NOT NULL,
	CONSTRAINT PRIMARY KEY (paymentID),
 * @author Viraj jayasanka
 */
public class pyamentDTO extends SuperDTO implements Serializable{
    private String oderid;
    private String paymentID;
    private String paymentDate;
    private double paymentAmount;
    
 
    public pyamentDTO() {
    }

    public pyamentDTO(String oderid, String paymentID, String paymentDate, double paymentAmount) {
        this.oderid = oderid;
        this.paymentID = paymentID;
        this.paymentDate = paymentDate;
        this.paymentAmount =paymentAmount;
    }

    /**
     * @return the oderid
     */
    public String getOderid() {
        return oderid;
    }

    /**
     * @param oderid the oderid to set
     */
    public void setOderid(String oderid) {
        this.oderid = oderid;
    }

    /**
     * @return the paymentID
     */
    public String getPaymentID() {
        return paymentID;
    }

    /**
     * @param paymentID the paymentID to set
     */
    public void setPaymentID(String paymentID) {
        this.paymentID = paymentID;
    }

    /**
     * @return the paymentDate
     */
    public String getPaymentDate() {
        return paymentDate;
    }

    /**
     * @param paymentDate the paymentDate to set
     */
    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    /**
     * @return the paymentAmount
     */
    public double getPaymentAmount() {
        return paymentAmount;
    }

    /**
     * @param paymentAmount the paymentAmount to set
     */
    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

}
