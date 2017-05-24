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
public class Login extends Application {
    
    
    @Override
    public void start(Stage stage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        //Scene scene = new Scene(root);
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 419, 495);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Connectez-vous");
        stage.getIcons().add(new Image("presentation/logoTakeAHike_Blanc.png"));
        stage.setResizable(false);
        //stage.setFullScreen(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        launch(args);
    }
    
}
