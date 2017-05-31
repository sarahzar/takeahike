/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.Login;

import entities.Session;
import entities.Utilisateur;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import services.UtilisateurServices;

/**
 * FXML Controller class
 *
 * @author asus-pc
 */
public class DesactivationController implements Initializable {

    
    @FXML
    private Button btnNon;

    @FXML
    private Button btnOui;

    @FXML
    void desactiverCompte(ActionEvent event) throws IOException {
        
        UtilisateurServices us=new UtilisateurServices();
        Utilisateur user=Session.getUser();
        System.out.println("Desactiver:   "+user);
        us.desactiverCompteUtilisateur(user); 
        System.out.println("Desactiver:   "+user);
        LoginController lc =new LoginController();
        ((Node)(event.getSource())).getScene().getWindow().hide();
        TestMenuController tsm=new TestMenuController();
        
        
        Platform.exit();
        
        
        

    }

    @FXML
    void fermerFenetre(ActionEvent event) {
        ((Node)(event.getSource())).getScene().getWindow().hide();

    }
    
    @FXML
    void ouvrirDesactivation(ActionEvent event) throws IOException{
        
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("Desactivation.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            Stage stage = new Stage();
            stage.setTitle("Désactivation du compte");
            stage.setScene(scene);
            stage.show();
            stage.setResizable(false);
                        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
