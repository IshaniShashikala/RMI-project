


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.thogakade.controller.custom.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import lk.ijse.thogakade.controller.ServerConnectorFactory;
import lk.ijse.thogakade.controller.custom.CustomerController;
import lk.ijse.thogakade.dto.CustomerDTO;
import lk.ijse.thogakade.observers.Observer;
import lk.ijse.thogakade.service.ServiceFactory;
import lk.ijse.thogakade.service.custom.CustomerService;

/**
 *
 * @author User
 */
public class CustomerControllerImpl implements CustomerController{

    private CustomerService customerService;

    
    public CustomerControllerImpl() throws Exception {
                 
        customerService = (CustomerService) ServerConnectorFactory.getInstance().getService(ServiceFactory.ServiceTypes.CUSTOMER);
    }
    
    
    
    @Override
    public boolean save(CustomerDTO t) throws Exception {
        boolean result = customerService.save(t);
        return result;
    }
    
    

    @Override
    public boolean update(CustomerDTO t) throws Exception {
        System.out.println("Controler");
        boolean result = customerService.update(t);
        return result;
    }

    @Override
    public boolean delete(String id) throws Exception {
        System.out.println("Welcomto controler Layer");
        boolean result = customerService.delete(id);
        return result;
    }

    @Override
    public CustomerDTO get(String id) throws Exception {
        CustomerDTO customer = customerService.getbyId(id);
        return  customer;
    }

    @Override
    public ArrayList<CustomerDTO> getAll() throws Exception {
        return customerService.get();
    }

    @Override
    public boolean reserve(String id) throws Exception {
         return customerService.reserve(id, customerService);

    }

    @Override
    public boolean release(String id) throws Exception {
       return customerService.reserve(id, customerService);
    }

    @Override
    public void registerObserver(Observer observer) throws RemoteException {
        customerService.registerObserver(observer);
    }

    @Override
    public void unregisterObserver(Observer observer) throws RemoteException {
        customerService.unregisterObserver(observer);
    }


    @Override
    public void notifyAllObservers() throws RemoteException {
        customerService.notifyAllObservers();
    }




   
}
