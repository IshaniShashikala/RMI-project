/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.thogakade.controller.custom.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Observable;
import lk.ijse.thogakade.controller.ServerConnectorFactory;
import lk.ijse.thogakade.controller.custom.ItemController;
import lk.ijse.thogakade.dto.ItemDTO;
import lk.ijse.thogakade.observers.Observer;
import lk.ijse.thogakade.service.ServiceFactory;
import lk.ijse.thogakade.service.SuperService;
import lk.ijse.thogakade.service.custom.ItemService;

/**
 *
 * @author User
 */
public class ItemControlerImpl implements ItemController {

    private ItemService itemService;

    public ItemControlerImpl() throws Exception {
//        itemService = (ItemService) ServerConnectorFactory.getInstance().getService(ServiceFactory.ServiceTypes.ITEM);
        itemService = (ItemService) ServerConnectorFactory.getInstance().getService(ServiceFactory.ServiceTypes.ITEM);
    }

    @Override
    public boolean save(ItemDTO t) throws Exception {
         boolean result = itemService.save(t);
         return result;
        //return itemService.save(t);
    }

    @Override
    public boolean update(ItemDTO t) throws Exception {
        System.out.println("Controler");
        boolean result = itemService.update(t);
        return result;
        //return itemService.update(t);
    }

    @Override
    public boolean delete(String id) throws Exception {
        System.out.println("Welcomto controler Layer");
        boolean result= itemService.delete(id);
        return result;
        //return itemService.delete(id);
    }

    @Override
    public ItemDTO get(String id) throws Exception {
        ItemDTO item = itemService.getbyId(id);
        return item;
        //return itemService.getbyId(id);
    }

    @Override
    public ArrayList<ItemDTO> getAll() throws Exception {
        return itemService.get();
    }

    @Override
    public boolean reserve(String id) throws Exception {
        return itemService.reserve(id, itemService);
    }

    @Override
    public boolean release(String id) throws Exception {
        return itemService.reserve(id, itemService);
    }

    @Override
    public void registerObserver(Observer observer) throws RemoteException {
        itemService.registerObserver(observer);
    }

    @Override
    public void unregisterObserver(Observer observer) throws RemoteException {
        itemService.unregisterObserver(observer);
    }

    @Override
    public void notifyAllObservers() throws RemoteException {
        itemService.notifyAllObservers();
    }

}
