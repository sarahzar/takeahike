/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.Login;

import services.EndroitServices;
import services.EvennementServices;
import services.UtilisateurServices;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import entities.Endroit;
import entities.Evennement;
import entities.Utilisateur;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;

/**
 * FXML Controller class
 *
 * @author achre
 */
public class FXMLmodifeventController implements Initializable {

    @FXML
    private JFXTextField nbrplace;

    @FXML
    private JFXTextField lata;

    @FXML
    private JFXButton modifev;

    @FXML
    private DatePicker datedeb;

    @FXML
    private JFXComboBox<String> idend;

    @FXML
    private JFXTextField latd;

       @FXML
    private JFXTextArea desc;

    @FXML
    private DatePicker datefin;

    @FXML
    private JFXTextField id;

    @FXML
    private JFXTextField nom;

    @FXML
    private JFXTextField lngd;
@FXML
    private JFXTextField difficulte;
    @FXML
    private JFXTextField lnga;
    //Utilisateur u = Session.getUser();

     @FXML
    void modifierevent(ActionEvent event) {

       EvennementServices es= new EvennementServices();
        UtilisateurServices us = new UtilisateurServices();
        
        Evennement ev = new Evennement();
        Endroit e = new Endroit();
        EndroitServices ee = new EndroitServices();
        int idevent=Integer.parseInt(id.getText());
        String Nom = nom.getText();
        String endr = idend.getSelectionModel().getSelectedItem();
        LocalDate dated = datedeb.getValue();
        LocalDate datedf = datefin.getValue();
        int nbrp = Integer.parseInt(nbrplace.getText());
        String description=desc.getText();
        Double lpde=Double.parseDouble(lngd.getText());
        Double lpaa=Double.parseDouble(lnga.getText());
        Double apde=Double.parseDouble(latd.getText());
        Double apaa=Double.parseDouble(lata.getText());
        int def = Integer.parseInt(difficulte.getText());
         
        ev.setId(idevent);
        ev.setNom(Nom);
        ev.setIdEndroit(ee.rechercheById(22));
        ev.setDifficulte(def);
        ev.setDescription(description);
        ev.setNbrPlaces(nbrp);
        ev.setDateDebut(dated);
        ev.setDateFin(datedf);
        ev.setLongitudePOintDepart(lpde);
        ev.setLongitudePOintArrivee(lpaa);
        ev.setLattitudePOintDepart(apde);
        ev.setLattitudePOintArrivee(apaa);
        ev.setIdResponsable(us.chercherCinUtilisateur("02143628"));
    es.modifierEvennement(ev);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        EndroitServices ens=new EndroitServices();
          ArrayList<Endroit> endro=new ArrayList<>();
        endro=(ArrayList<Endroit>)ens.afficherEndroit();
          ArrayList<String> endrocombo=new ArrayList<>();
        for(Endroit ed:endro){
        endrocombo.add(ed.getNom());
        }
        ObservableList<String> names=FXCollections.observableArrayList(endrocombo);
       idend.setItems(names);
        
        
    }
}    
    


