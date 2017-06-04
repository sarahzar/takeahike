/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.Login;

import Models.UtilisateursDetails;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import entities.Utilisateur;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import services.UtilisateurServices;

/**
 * FXML Controller class
 *
 * @author asus-pc
 */
public class UtilisateursController implements Initializable {

    @FXML
    private TableView<UtilisateursDetails> tableUsers;

    @FXML
    private TableColumn<UtilisateursDetails, String> columnCIN;

    @FXML
    private TableColumn<UtilisateursDetails, String> columnLogin;

    @FXML
    private TableColumn<UtilisateursDetails, String> columnNom;

    @FXML
    private TableColumn<UtilisateursDetails, String> columnPrenom;

    @FXML
    private TableColumn<UtilisateursDetails, String> columnEmail;

    @FXML
    private TableColumn<UtilisateursDetails, String> columnTelephone;

    @FXML
    private TableColumn<UtilisateursDetails, String> columnEtat;

    @FXML
    private TableColumn<UtilisateursDetails, String> columnCompte;
    
    @FXML
    private TableColumn<UtilisateursDetails, String> columnType;

    @FXML
    private TableColumn<UtilisateursDetails, Date> columnDateDesactivation;
    
    private ObservableList<UtilisateursDetails> data = FXCollections.observableArrayList();
    
     @FXML
    private JFXButton btnAjouter;
      @FXML
    private JFXButton btnDesactiver;
      
       @FXML
    private JFXButton btnActiver;

    @FXML
    private JFXTextField cinRecherche;

    @FXML
    private JFXTextField loginRecherche;
    
    public  void refresh() {
        data.clear();
        UtilisateurServices us=new UtilisateurServices();
        data=us.listeUtilisateurs();
        tableUsers.setItems(data);
        
        
    }

    @FXML
    void desactiverUser(ActionEvent event) {
        UtilisateursDetails u=tableUsers.getSelectionModel().getSelectedItem();
       
        UtilisateurServices us=new UtilisateurServices();
        Utilisateur selectedUser= us.chercherCinUtilisateur( u.getCin());
        us.desactiverCompteUtilisateur(selectedUser);
        refresh();

    }
    
    @FXML
    void activerUser(ActionEvent event) {
        UtilisateursDetails u=tableUsers.getSelectionModel().getSelectedItem();
       
        UtilisateurServices us=new UtilisateurServices();
        Utilisateur selectedUser= us.chercherCinUtilisateur( u.getCin());
        us.activerCompteUtilisateur(selectedUser);
        System.out.println(selectedUser);

    }

    @FXML
    void ouvrirInscription(ActionEvent event) throws IOException {
        System.out.println("Adddddddd: ---------"+InscriptionController.getAdmin());
       InscriptionController.setAdmin(0);
       System.out.println("Adddddddd: ---------"+InscriptionController.getAdmin());
       InscriptionController is =new  InscriptionController();
       is.ouvrirInscription(event);
       
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //System.out.println("DATA----------->  "+data);
        columnCIN.setCellValueFactory(new PropertyValueFactory<>("cin"));
        columnLogin.setCellValueFactory(new PropertyValueFactory<>("login"));
        columnNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        columnPrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        columnEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        columnTelephone.setCellValueFactory(new PropertyValueFactory<>("telephone"));
        columnEtat.setCellValueFactory(new PropertyValueFactory<>("etat"));

        columnCompte.setCellValueFactory(new PropertyValueFactory<>("compte"));
        columnType.setCellValueFactory(new PropertyValueFactory<>("type"));
        //columnDateDesactivation.setCellValueFactory(new PropertyValueFactory<>("dateDesactivation"));
        
        //tableUsers.setItems(null);
        refresh();
        //tableUsers.setItems(data);
        
                
    }    
    
}
