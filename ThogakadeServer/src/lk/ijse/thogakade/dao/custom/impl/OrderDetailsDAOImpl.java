/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.thogakade.dao.custom.impl;

import java.sql.Connection;
import lk.ijse.thogakade.dao.custom.OrderDetailsDAO;

/**
 *
 * @author User
 */
public class OrderDetailsDAOImpl implements OrderDetailsDAO{

    private Connection connection;
    private final String TABLE_NAME = "orderdetail";
    
    @Override
    public void setConnection(Connection connection) throws Exception {
        this.connection = connection;
    }    

     @Override
    public Connection getConnection() throws Exception {
        return this.connection;
    }   
}
