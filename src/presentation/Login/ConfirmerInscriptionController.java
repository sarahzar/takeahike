/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.Login;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import entities.Utilisateur;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import services.UtilisateurServices;
import entities.Utilisateur;
import entities.Session;

/**
 * FXML Controller class
 *
 * @author asus-pc
 */
public class ConfirmerInscriptionController implements Initializable {
    
    public static String cinC;

    public static String getCinC() {
        return cinC;
    }

    public static void setCinC(String cinC) {
        ConfirmerInscriptionController.cinC = cinC;
    }
    
    @FXML
    private Label lblErreur;
    
    @FXML
    private JFXButton envoiMail;

    @FXML
    private JFXPasswordField codeMail;

    @FXML
    void confirmerInscription(ActionEvent event) {
        UtilisateurServices us= new UtilisateurServices();
        Utilisateur u;
        Utilisateur user=Session.getUser();
        if (user==null)
        {
            System.out.println("\nChercherconfirmerInscription      ---");
            System.out.println(cinC);
             u=us.chercherCinUtilisateur(cinC);
             Session.setUser(u);
             System.out.println("-----Apres recherche dans confirmer---"+u);
             System.out.println("singleton=null");
        }
        else
        {
             u=user;
              System.out.println("singleton!=null");
        }
        
            //System.out.println("u: "+u);
           if (codeMail.getText().equals(u.getCodeConfirmation()))
           { //System.out.println("OOOOOOOOOOk");
            try {
                us.confirmerUtilisateur(u);
                
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("testMenu.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 1090, 600);
                Stage stage = new Stage();
                stage.setTitle("Take a Hike");
                stage.setScene(scene);
                stage.show();
                stage.setResizable(false);
                
                ((Node)(event.getSource())).getScene().getWindow().hide();
            } catch (IOException ex) {
                Logger.getLogger(ConfirmerInscriptionController.class.getName()).log(Level.SEVERE, null, ex);
            }
           }
           else
               lblErreur.setVisible(true);
                //System.out.println("Nooooooooooo");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
