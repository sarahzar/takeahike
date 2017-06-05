/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.Login;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author asus-pc
 */
public class testMenuAdmin extends Application {
    
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("menuAdministrateur.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Utilisateur");
        stage.getIcons().add(new Image("logo.jpg"));
        stage.setResizable(false);
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        launch(args);
    }
    
}
