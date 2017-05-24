/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataConnexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author asus-pc
 */
public class MyConnexion {
    private static MyConnexion instance = null;
private Connection con;
    private String url="jdbc:mysql://localhost:3306/takeahike_2";
    private String pwd="";
    private String login="root";
   
    private MyConnexion() {
        try {
            con= DriverManager.getConnection(url, login, pwd);
            System.out.println("connexion ok");
        } catch (SQLException ex) {
            Logger.getLogger(MyConnexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public static MyConnexion getInstance() {

        if (instance == null) {
            instance = new MyConnexion();
        }

        return instance;

    }

    public Connection getConexion() {
        return con;
    }

    
}
