/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.Login;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class testAvis extends Application {
    
    
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader root = new FXMLLoader(getClass().getResource("Avis2.fxml"));
        //root.setController(new AvisController());
      
        Pane scene = root.load();
        
        Scene h = new Scene(scene);
        //scene.getStylesheets().add(getClass().getResource("Gallerie2.css").toExternalForm());
        stage.setScene(h);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}