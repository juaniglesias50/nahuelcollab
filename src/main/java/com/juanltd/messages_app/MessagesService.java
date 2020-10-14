/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juanltd.messages_app;

import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Administrador
 */
public class MessagesService {
    
    public static void createMessage(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe tu mensaje.");
        String msg = sc.nextLine();
        System.out.println("Escribe tu nombre.");
        String name = sc.nextLine();
        
        Messages full_message = new Messages();
        full_message.setMessage(msg);
        full_message.setMessage_author(name);
        MessagesDAO.createMessageDB(full_message);        
        
    }
    public static void showMessages(){
        Map<Integer, Messages> message_list = MessagesDAO.readMessagesDB();
        for (int i=0;i<message_list.size();i++){
            System.out.println("ID: " + message_list.get(i).getMessage_id());
            System.out.println("Mensaje: " + message_list.get(i).getMessage());
            System.out.println("Autor: " + message_list.get(i).getMessage_author());
            System.out.println("Fecha: " + message_list.get(i).getMessage_date());            
        }
          
        
        
    }
    public static void deleteMessage(){
        
    }
    public static void editMessage(){
        
    }
   
}
