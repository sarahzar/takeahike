/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testFx;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import dataConnexion.MyConnexion;
import entities.Session;
import entities.Utilisateur;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import services.UtilisateurServices;

/**
 *
 * @author asus-pc
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private ImageView logo;
     @FXML
    private JFXButton jfbtnInscription;

    @FXML
    private Label invalid;
      @FXML
    private JFXButton jfbtnConnexion;

    @FXML
    private JFXTextField Login;

    @FXML
    private JFXPasswordField Password;
      @FXML
    private JFXTextField jfxText3;


    @FXML
    void connexionUtilisateur(ActionEvent event) {
         
              Utilisateur u = Session.getUser();
              String login = Login.getText();
              String password = Password.getText();
              UtilisateurServices us = new UtilisateurServices();
              u = us.chercherLoginUtilisateur(login);
              if ((login.equals(u.getLogin())) && (password.equals(u.getPassword())))
              {
                  System.out.println("Bienvenue!");
                  invalid.setText("Bienvenue!");
                  invalid.setTextFill(Color.web("#5e2b0e"));
                  
              }
              else
              {
                 System.out.println("Echec!");
                 invalid.setText("Nom d'utilisateur ou mot de passe invalide!");
              }
                  
              
          

    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
