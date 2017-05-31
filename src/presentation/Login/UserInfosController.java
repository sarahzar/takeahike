/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.Login;

import com.jfoenix.controls.JFXComboBox;
import entities.Session;
import entities.Utilisateur;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import services.UtilisateurServices;

/**
 * FXML Controller class
 *
 * @author asus-pc
 */
public class UserInfosController implements Initializable {

     Utilisateur user=Session.getUser();

//    public static Utilisateur getUser() {
//        return user;
//    }
//
//    public static void setUser(Utilisateur user) {
//        UserInfosController.user = user;
//    }
    
    @FXML
    private ImageView imagev;
    
    @FXML
    private Label nomPrenomUser;

    @FXML
    private ImageView photoProfilUserM;
    
     @FXML
    private ImageView photoProfilUserF;
    
    @FXML
    private JFXComboBox<String> cmbprofilUser;

    @FXML
    private JFXComboBox<String> cmbrandosUser;
    
    
    @FXML
    void ouvrirUserInfos(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
             fxmlLoader.setLocation(getClass().getResource("UserInfos.fxml"));
             Scene scene = new Scene(fxmlLoader.load(), 900, 600);
             Stage stage = new Stage();
             stage.setTitle("User");
             stage.setScene(scene);
             
             stage.show();
             stage.setResizable(false);
             

    }
    
      @FXML
    void verifierInscription(ActionEvent event) throws IOException {
        int choix= cmbprofilUser.getSelectionModel().getSelectedIndex();
        InscriptionController insc =new InscriptionController();
        ProfilController pf =new ProfilController();
        ModifierUtilisateurController mdf =new ModifierUtilisateurController();
          if (choix==0)
          {
              pf.ouvrirProfil(event);
          }
          if (choix==1)
          {
             mdf.ouvrirModifierUtilisateur(event);
          }
          
    }

    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cmbrandosUser.getItems().addAll("Organisées", "Visitées");
        cmbprofilUser.getItems().addAll("Voir", "Modifier");
        
        //int s=UserInfosController.user.getSexe();
        int s=user.getSexe();
        if(s==0)
        imagev.setImage(new Image("presentation/profil.jpg"));
        else imagev.setImage(new Image("presentation/profilF.png"));
        
        nomPrenomUser.setText(user.getNom()+" "+user.getPrenom());
    }    
    
}
