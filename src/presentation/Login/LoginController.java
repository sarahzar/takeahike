/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.Login;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import entities.Session;
import entities.Utilisateur;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.GroupLayout;
import services.UtilisateurServices;
import testFx.FXMLDocumentController;

/**
 * FXML Controller class
 *
 * @author asus-pc
 */
public class LoginController implements Initializable {

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
    private AnchorPane anchorpaneLogin=new AnchorPane();


    @FXML
    void connexionUtilisateur(ActionEvent event) throws IOException {
         
              Utilisateur u = new Utilisateur();
              String login = Login.getText();
              String password = Password.getText();
              UtilisateurServices us = new UtilisateurServices();
              u = us.chercherLoginUtilisateur(login);
              
              
              
              
              
              
              if ((login.equals(u.getLogin())) && (password.equals(u.getPassword())))
              {
                  Session.setUser(u);
                  System.out.println("Bienvenue!");
                  invalid.setText("Bienvenue!");
                  invalid.setTextFill(Color.web("#5e2b0e"));
                  if (u.getType()==0) 
                  {
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("accueilAdmin.fxml"));
                    Scene scene = new Scene(fxmlLoader.load(), 1090, 600);
                    Stage stage = new Stage();
                    stage.setTitle("Tableau de bord");
                    stage.setScene(scene);
                    stage.show();
                    stage.setResizable(false);
                    ((Node)(event.getSource())).getScene().getWindow().hide();
                  }
                  else if ((u.getEtat()==1)&&(u.getConfirmer()==1) && (u.getType()==1))
                  {
                      
                    
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("testMenu.fxml"));
                    Scene scene = new Scene(fxmlLoader.load(), 1090, 600);
                    Stage stage = new Stage();
                    stage.setTitle("Take a Hike");
                    stage.setScene(scene);
                    stage.show();
                    stage.setResizable(false);
                    ((Node)(event.getSource())).getScene().getWindow().hide();
                  }
                  
                  else if (u.getEtat()!=1) 
                  {
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("CompteDesactive.fxml"));
                    Scene scene = new Scene(fxmlLoader.load(), 600, 400);
                    Stage stage = new Stage();
                    stage.setTitle("Compte Désactivé");
                    stage.setScene(scene);
                    stage.show();
                    stage.setResizable(false);
                    ((Node)(event.getSource())).getScene().getWindow().hide();
                  }
                  else if(u.getConfirmer()!=1)
                  {
                     FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("confirmerInscription.fxml"));
                    Scene scene = new Scene(fxmlLoader.load(), 600, 400);
                    Stage stage = new Stage();
                    stage.setTitle("Confirmer votre compte");
                    stage.setScene(scene);
                    stage.show();
                    stage.setResizable(false);
                    ((Node)(event.getSource())).getScene().getWindow().hide(); 
                  }
                  
                  //UserInfosController ui = new UserInfosController();
                  
                  //ui.setUser(u);
                  
                 
                
                
              }
              else
              {
                 System.out.println("Echec!");
                 invalid.setText("Nom d'utilisateur ou mot de passe invalide!");
                 invalid.setTextFill(Color.web("#da0c0c"));
              }
                  
              
          

    }
    @FXML
    void ouvrirInscription(ActionEvent event) {
      try {
             
             FXMLLoader fxmlLoader = new FXMLLoader();
             fxmlLoader.setLocation(getClass().getResource("Inscription_1.fxml"));
             Scene scene = new Scene(fxmlLoader.load(), 900, 600);
             Stage stage = new Stage();
             stage.setTitle("Inscription");
             stage.setScene(scene);
             
             stage.show();
             stage.setResizable(false);
             ((Node)(event.getSource())).getScene().getWindow().hide();
             
             
            
             
         } catch (IOException ex) {
             Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
         }
         
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         
        //loadSplashScreen(); 
        logo.setVisible(true);
        
    }
//    private void loadSplashScreen () 
//        {
//         
//         try {
//             StackPane pane = FXMLLoader.load(getClass().getResource(("SplashFXML.fxml")));
//             anchorpaneLogin.getChildren().setAll(pane);
//             
//             FadeTransition fadeIn = new FadeTransition(Duration.seconds(3), pane);
//             fadeIn.setFromValue(0);
//             fadeIn.setToValue(1);
//             fadeIn.setCycleCount(1);
//             
//             FadeTransition fadeOut = new FadeTransition(Duration.seconds(3), pane);
//             fadeOut.setFromValue(1);
//             fadeOut.setToValue(0);
//             fadeOut.setCycleCount(1);
//             fadeIn.play();
//
//            fadeIn.setOnFinished((e) -> {
//                fadeOut.play();
//            });
//
//            fadeOut.setOnFinished((e) -> {
//                try {
//                    AnchorPane parentContent = FXMLLoader.load(getClass().getResource(("Login.fxml")));
//                    anchorpaneLogin.getChildren().setAll(parentContent);
//
//                } catch (IOException ex) {
//                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            });
//
//             
//             
//         } catch (IOException ex) {
//             Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
//         }
//            
//         
//        }    
    
      
    
}
