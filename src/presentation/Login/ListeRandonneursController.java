/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.Login;

import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import entities.Utilisateur;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import entities.Utilisateur;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import services.UtilisateurServices;

/**
 * FXML Controller class
 *
 * @author asus-pc
 */
public class ListeRandonneursController implements Initializable {
    @FXML
    private JFXTreeTableView<?> jfxTreeRandonneurs;

    UtilisateurServices us=new UtilisateurServices ();
    ObservableList<Utilisateur> users = us.afficherUtilisateur();
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        JFXTreeTableColumn<Utilisateur, String> nomUtilisateur = new JFXTreeTableColumn<>("Nom");
        JFXTreeTableColumn<Utilisateur, String> prenomUtilisateur = new JFXTreeTableColumn<>("Prenom");
    }  
    
    
    
}
