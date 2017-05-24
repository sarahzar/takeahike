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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author asus-pc
 */
public class ProfilController implements Initializable {
    
    Utilisateur user=Utilisateur.getInstance();
   String login;
    
    @FXML
    private Label typeUtilisateur;

    @FXML
    private Label telephoneUtilisateur;

    @FXML
    private Label loginUtilisateur;

    @FXML
    private Button desactiverUtilisateur;

    @FXML
    private Label dtnUtilisateur;

    @FXML
    private Label etatCompteUtilisateur;

    @FXML
    private Label emailUtilisateur;

    @FXML
    private Label nomUtilisateur;

    @FXML
    private Label dtnInscrUtilisateur;

    @FXML
    private Label cinUtilisateur;

    @FXML
    private Label prenomUtilisateur;

    @FXML
    private Button btnouvrirModifierUtilisateur;
    
     @FXML
    private AnchorPane anchorpane2;

    @FXML
    void ouvrirModificationUtilisateur(ActionEvent event) throws IOException {
        ModifierUtilisateurController mdf=new ModifierUtilisateurController();
        mdf.ouvrirModifierUtilisateur(event);
        ((Node)(event.getSource())).getScene().getWindow().hide();

    }
    
    @FXML
    void ouvrirDesactivationVerif(ActionEvent event) throws IOException {
        DesactivationController des=new DesactivationController();
        des.ouvrirDesactivation(event);
        //((Node)(event.getSource())).getScene().getWindow().hide();

    }
    
    
     @FXML
    void ouvrirProfil (ActionEvent event) throws IOException{
        
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("Profil.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 900, 600);
            Stage stage = new Stage();
            stage.setTitle("Profil");
            stage.setScene(scene);
            stage.show();
            stage.setResizable(false);
                        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       
        
        
        
        
        loginUtilisateur.setText(user.getLogin());
        cinUtilisateur.setText(user.getCin());
        nomUtilisateur.setText(user.getNom());
        prenomUtilisateur.setText(user.getPrenom());
        dtnUtilisateur.setText(user.getDateNaissance().toString());
        telephoneUtilisateur.setText(user.getTelephone());
        emailUtilisateur.setText(user.getMail());
        dtnInscrUtilisateur.setText(user.getDateInscrit().toString());
        if (user.getEtat()== 0)
            etatCompteUtilisateur.setText("Désactivé");
        else
            etatCompteUtilisateur.setText("Activé");
        if (user.getType()== 0)
            typeUtilisateur.setText("Administrateur");
        else
            typeUtilisateur.setText("Randonneur");
                
    }    
    
}
