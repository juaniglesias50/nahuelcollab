/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juanltd.messages_app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Administrador
 */
public class Conn {
    
    public Connection get_connection(){
        Connection connection  = null;  
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/messages_app", "root","");
            if(connection != null){
                System.out.print("Conexión exitosa!");                      
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return connection;
        
    }
    
}
