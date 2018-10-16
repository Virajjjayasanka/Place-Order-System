/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.Thogakade.dao;

import java.util.ArrayList;
import lk.ijse.Thogakade.dto.SuperDTO;

/**
 *
 * @author Viraj jayasanka
 */
public interface SuperDAO<T extends SuperDTO> {

    public boolean add(T t) throws Exception;

    public boolean update(T t) throws Exception;

    public boolean delete(String key) throws Exception;

    public T search(String key) throws Exception;

    public ArrayList<T> getAll() throws Exception;

}
