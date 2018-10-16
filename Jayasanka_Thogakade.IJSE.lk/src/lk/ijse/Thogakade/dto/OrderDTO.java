/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.Thogakade.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Viraj jayasanka
 */
public class OrderDTO extends SuperDTO implements Serializable {
     private String id;
     private String date;
     private String customerId;
     private ArrayList<OrderDetailDTO> orderDetail;

    public OrderDTO(String id, String date, String customerId) {
        this.id = id;
        this.date = date;
        this.customerId = customerId;
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

    /**
     * @return the orderDetail
     */
    public ArrayList<OrderDetailDTO> getOrderDetail() {
        return orderDetail;
    }

    /**
     * @param orderDetail the orderDetail to set
     */
    public void setOrderDetail(ArrayList<OrderDetailDTO> orderDetail) {
        this.orderDetail = orderDetail;
    }

    /**
     * @return the id
     */
   
   
}
