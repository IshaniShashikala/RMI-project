/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.thogakade.controller.custom.impl;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observable;
import lk.ijse.thogakade.controller.ServerConnectorFactory;
import lk.ijse.thogakade.controller.custom.PlaceOrderController;
import lk.ijse.thogakade.dto.CustomerDTO;
import lk.ijse.thogakade.dto.ItemDTO;
import lk.ijse.thogakade.dto.OrderDTO;
import lk.ijse.thogakade.dto.OrderdetailDTO;
import lk.ijse.thogakade.dto.SuperDTO;
import lk.ijse.thogakade.observers.Observer;
import lk.ijse.thogakade.service.ServiceFactory;
import lk.ijse.thogakade.service.SuperService;
import lk.ijse.thogakade.service.custom.CustomerService;
import lk.ijse.thogakade.service.custom.OrderService;

/**
 *
 * @author User
 */
public class PlaceOrderControllerImpl implements PlaceOrderController {

    private OrderService orderService;

    public PlaceOrderControllerImpl() throws Exception{
        orderService = (OrderService) ServerConnectorFactory.getInstance().getService(ServiceFactory.ServiceTypes.ORDER);
    }

    @Override
    public boolean save(OrderDTO t) throws Exception {
        boolean result = orderService.save(t);
        return result;
    // return orderService.save(t);
    }

    @Override
    public boolean update(OrderDTO t) throws Exception {
        System.out.println("Controler");
        boolean result = orderService.update(t);
        return result;
        //return orderService.update(t);
    }

    @Override
    public boolean delete(String id) throws Exception {
         System.out.println("Welcomto controler Layer");
        boolean result = orderService.delete(id);
        return result;
        //return orderService.delete(id);
    }

    @Override
    public OrderDTO get(String id) throws Exception {
        OrderDTO order= orderService.getbyId(id);
        return order;
        //return orderService.getbyId(id);
    }

    @Override
    public ArrayList<OrderDTO> getAll() throws Exception {
        return orderService.get();
    }


    @Override
    public boolean reserve(String id) throws Exception {
        return orderService.reserve(id, orderService);
    }

    @Override
    public boolean release(String id) throws Exception {
        return orderService.reserve(id, orderService);
    }

    @Override
    public void registerObserver(Observer observer) throws RemoteException {
        orderService.registerObserver(observer);
    }

    @Override
    public void unregisterObserver(Observer observer) throws RemoteException {
        orderService.unregisterObserver(observer);}

    @Override
    public void notifyAllObservers() throws RemoteException {
        orderService.notifyAllObservers();
    }

   
}
