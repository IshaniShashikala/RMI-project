/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.thogakade.server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import lk.ijse.thogakade.service.impl.ServiceFactoryImpl;

/**
 *
 * @author User
 */
public class StartServer {

    
    public StartServer() {
         try {
            Registry registry = LocateRegistry.createRegistry(5050);
            System.out.println("Server Strating..");

            registry.rebind("ThogakadeServer", ServiceFactoryImpl.getInstance());
        } catch (Exception ex) {
            Logger.getLogger(StartServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
        
        
    
        
    
       

//    }

}
