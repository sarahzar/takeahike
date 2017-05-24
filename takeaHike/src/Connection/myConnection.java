package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class myConnection {
    private String url,pwd,login;
    private Connection connect;
    private static myConnection instance=null;

    public myConnection() {
        
        
        try {
            url="jdbc:mysql://localhost:3306/takeahike";
            login="root";
            pwd="";
            connect  = DriverManager.getConnection(url, login, pwd);
            System.out.println("Connection Done !");
        } catch (SQLException ex) {
            Logger.getLogger(myConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection getConnect() {
        return connect;
    }

    public static myConnection getInstance() {
        
        
        if(instance==null)
            
            instance= new myConnection();
        
        return instance;
    }
    
    
    
    
}
