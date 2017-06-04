/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.Login;

import Models.UtilisateursDetails;
import entities.Utilisateur;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
    
    private ObservableList<UtilisateursDetails> data;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        UtilisateurServices us=new UtilisateurServices();
        data=us.listeUtilisateurs();
        System.out.println("DATA----------->  "+data);
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
        
        tableUsers.setItems(null);
        tableUsers.setItems(data);
        
                
    }    
    
}
