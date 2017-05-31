/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.Login;

import com.jfoenix.controls.JFXPasswordField;
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
import static presentation.Login.InscriptionValidation.textFieldNotEmpty;
import services.UtilisateurServices;

/**
 * FXML Controller class
 *
 * @author asus-pc
 */
public class ModifierPasswordController implements Initializable {

    Utilisateur user= Session.getUser();
    @FXML
    private JFXPasswordField newPasswordConfirm;

    @FXML
    private Label lblNewPassword;

    @FXML
    private JFXPasswordField passwordActuel;

    @FXML
    private JFXPasswordField newPassword;

    @FXML
    private Label lblpasswordActuel;

    @FXML
    private Label lblNewPasswordConfirm;

    @FXML
    private Button btnValider;

    @FXML
    void modifierPassword(ActionEvent event) throws IOException {
        boolean passwordValidation =textFieldNotEmpty(newPassword, lblNewPassword, "Le mot de passe est obligatoire!");
        boolean verifierPasswordActuel =user.getPassword().equals(passwordActuel.getText());
        if (!verifierPasswordActuel)
            lblpasswordActuel.setText("Mot de passe incorrect!");
        else 
            lblpasswordActuel.setText("");
        boolean verifierPassword = newPassword.getText().equals(newPasswordConfirm.getText());
        if (!verifierPassword)
            lblNewPasswordConfirm.setText("Mot de passe incorrect!");
        else 
            lblNewPasswordConfirm.setText("");
        if (passwordValidation && verifierPassword && verifierPasswordActuel)
        {
        UtilisateurServices us=new UtilisateurServices();
        us.modifierPasswordUtilisateur(user, newPassword.getText());
        ModifierUtilisateurController mdf=new ModifierUtilisateurController();
        mdf.ouvrirModifierUtilisateur(event);
         ((Node)(event.getSource())).getScene().getWindow().hide();
        }

    }
    
    @FXML
    void ouvrirModifierPasswordUtilisateur (ActionEvent event) throws IOException{
        
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("ModifierPassword.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            Stage stage = new Stage();
            stage.setTitle("Modifier le mot de passe");
            stage.setScene(scene);
            stage.show();
            stage.setResizable(false);
                        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
