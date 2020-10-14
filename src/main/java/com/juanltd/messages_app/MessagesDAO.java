/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juanltd.messages_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Administrador
 */
public class MessagesDAO {
    
    public static void createMessageDB (Messages message){
        Connect db_connect = new Connect();
        try(Connection conn = db_connect.get_connection()){
            PreparedStatement ps = null;
            try{
                String query = "INSERT INTO `messages` (message, message_author) VALUES (?, ?)";
                ps = conn.prepareStatement(query);
                ps.setString(1, message.getMessage());
                ps.setString(2, message.getMessage_author());
                ps.executeUpdate();
                System.out.println("Mensaje creado correctamente.");
            }catch(SQLException ex){
                System.out.println(ex);
            }            
        }catch(SQLException e){
            System.out.println(e);            
        }
    }
    
    public static Map<Integer, Messages> readMessagesDB(){
        Connect db_connect = new Connect();        
        Map<Integer, Messages> messages_list = new HashMap<Integer, Messages>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try(Connection conn = db_connect.get_connection()){
            String query = "SELECT * FROM messages";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            int i = 0;
            
            //mientras haya filas en el ResultSet, vamos
            //colocando en cada mensaje
            while (rs.next()){          
                //limpiamos el objecto para ponerle nueva info
                Messages result = new Messages();
                result.setMessage_id(rs.getInt("message_id"));
                result.setMessage(rs.getString("message"));
                result.setMessage_author(rs.getString("message_author"));
                result.setMessage_date(rs.getString("message_date"));
                messages_list.put(i, result);
                i++;
            }            
          
        }catch(SQLException e){
            System.out.println("No se pudieron recuperar los datos.");
            System.out.println(e);            
        }
        
        return messages_list;
    }
    
    
    public static void deleteMessagesDB(){
        
    }
    
    public static void updateMessageDB(Messages message){
        
    }
    
}
