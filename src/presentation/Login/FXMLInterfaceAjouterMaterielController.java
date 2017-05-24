/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.Login;


import services.MaterielServices;
import services.UtilisateurServices;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import entities.Materiel;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author monta
 */
public class FXMLInterfaceAjouterMaterielController implements Initializable {
    
    
     @FXML
    private JFXTextField textNom;

    @FXML
    private JFXTextArea textdescription;

    @FXML
    private JFXTextField textprix;

    @FXML
    private Pane ref3;

    @FXML
    private Pane ref2;

    @FXML
    private JFXTextField textimg;

    @FXML
    private JFXComboBox<String> texttype;

    @FXML
    private Pane panelmat;

    @FXML
    private Pane ref1;
    
    //String s = (String) texttype.getSelectionModel().getSelectedItem();
  
    
    
    
    @FXML
    void ajoutMateriel(ActionEvent event) throws IOException {
        System.out.println("Ajout");
        MaterielServices ms = new MaterielServices();
        UtilisateurServices us = new UtilisateurServices();
        Materiel m = new Materiel();
        String nom=textNom.getText();
        int prix=Integer.parseInt(textprix.getText());
        String description=textdescription.getText();
        String image=textimg.getText();
        int type = texttype.getSelectionModel().getSelectedIndex();
        System.out.println(type);
        //int type=Integer.parseInt(s);


        m.setNomMateriel(nom);
        m.setDescription(description);
        m.setPrix(prix);
        m.setImage(image);
        m.setType(type);
        m.setIdUser(us.chercherCinUtilisateur("01010101"));

        ms.ajouterMateriel(m);
        
        
        Parent root = FXMLLoader.load(getClass().getResource("/presentation/Done.fxml"));
       
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
        
            } 
    
    @FXML
    
            
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        texttype.getItems().addAll("Louer","vente");
    }    
    
}
