/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.thogakade.controller;

import java.rmi.RemoteException;
import java.util.ArrayList;

import lk.ijse.thogakade.dto.SuperDTO;
import lk.ijse.thogakade.observers.Observer;
import lk.ijse.thogakade.observers.Subject;

/**
 *
 * @author User
 */
public interface SuperController<T extends SuperDTO> extends Subject {
    
    public boolean reserve(String id)throws Exception;
    
    public boolean release(String id) throws Exception;
       
    public boolean save(T t) throws Exception;

    public boolean update(T t) throws Exception;

    public boolean delete(String id) throws Exception;

    public T get(String id) throws Exception;

    public ArrayList<T> getAll() throws Exception;
}
