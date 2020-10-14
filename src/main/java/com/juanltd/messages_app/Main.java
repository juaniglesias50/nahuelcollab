/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juanltd.messages_app;

import java.sql.Connection;

/**
 *
 * @author Administrador
 */
public class Main {

    public static void main(String[] args) {

        Conn connectionOne = new Conn();

        try(Connection cnct = connectionOne.get_connection()){
            
        }catch(Exception e){
            System.out.println(e);
        }

    }

}
