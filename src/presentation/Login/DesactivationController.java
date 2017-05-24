/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.Login;

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
import javafx.stage.Stage;
import services.UtilisateurServices;

/**
 * FXML Controller class
 *
 * @author asus-pc
 */
public class DesactivationController implements Initializable {

    Utilisateur user=Utilisateur.getInstance();
    @FXML
    private Button btnNon;

    @FXML
    private Button btnOui;

    @FXML
    void desactiverCompte(ActionEvent event) {
        
        UtilisateurServices us=new UtilisateurServices();
        us.desactiverCompteUtilisateur(user);        
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
