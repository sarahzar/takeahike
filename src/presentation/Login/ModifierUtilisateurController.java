/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.Login;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import entities.Session;
import entities.Utilisateur;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import services.UtilisateurServices;

/**
 * FXML Controller class
 *
 * @author asus-pc
 */
public class ModifierUtilisateurController implements Initializable {

    Utilisateur user= Session.getUser();
    
    @FXML
    private Button btnmodifierPassword;
    
     @FXML
    private JFXTextField txtnomUtilisateur;

    @FXML
    private JFXTextField txtemailUtilisateur;

    

    @FXML
    private JFXTextField txttelephoneUtilisateur;

    @FXML
    private JFXTextField txtprenomUtilisateur;
    
    @FXML
    private JFXPasswordField passwordUtilisateur;
    
    @FXML
    private Label lblPassword;

    @FXML
    private Button ModifierUtilisateur;
    
    @FXML
    void modifierUtilisateur(ActionEvent event) {
        UtilisateurServices us=new UtilisateurServices();
        String ps=us.chercherCinUtilisateur(user.getCin()).getPassword();
        if (!passwordUtilisateur.getText().equals(ps))
            lblPassword.setText("Mot de passe invalide!");
        else
        {
            lblPassword.setText("");
            us.modifierUtilisateur(user, txtnomUtilisateur.getText(), txtprenomUtilisateur.getText(), "", txttelephoneUtilisateur.getText(), txtemailUtilisateur.getText());
            
        }

    }
    
    @FXML
    void ouvrirModifierPassword(ActionEvent event) throws IOException {
        ModifierPasswordController mdfPassword =new ModifierPasswordController();
        mdfPassword.ouvrirModifierPasswordUtilisateur(event);
        ((Node)(event.getSource())).getScene().getWindow().hide();
        
    }


    @FXML
    void ouvrirModifierUtilisateur (ActionEvent event) throws IOException{
        
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("ModifierUtilisateur.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 900, 600);
            Stage stage = new Stage();
            stage.setTitle("Modifier le profil");
            stage.setScene(scene);
            stage.show();
            stage.setResizable(false);
            System.out.println(user.getPassword());
                        
    }
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        txtemailUtilisateur.setText(user.getMail());
        txtnomUtilisateur.setText(user.getNom());
        txtprenomUtilisateur.setText(user.getPrenom());
        txttelephoneUtilisateur.setText(user.getTelephone());
    }    
    
}
