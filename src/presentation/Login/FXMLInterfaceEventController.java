
package presentation.Login;

import services.EndroitServices;
import services.EvennementServices;
import services.MaterielServices;
import services.UtilisateurServices;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import entities.Evennement;
import entities.Materiel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import entities.Endroit;
import entities.Session;
import entities.Utilisateur;
import java.time.LocalDate;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FXMLInterfaceEventController implements Initializable {
  @FXML
    private JFXTextField nbrplace;

    @FXML
    private JFXButton btok;

    @FXML
    private JFXTextField lpd;

    @FXML
    private JFXComboBox<String> endroit;

    @FXML
    private JFXTextField apa;

    @FXML
    private JFXTextField apd;

    @FXML
    private DatePicker datedebut;

    @FXML
    private JFXTextField diff;

    @FXML
    private DatePicker datefin;

    @FXML
    private JFXTextField lpa;

    @FXML
    private JFXTextField nom;

    @FXML
    private JFXTextArea desc;
    
     
     ArrayList<Endroit> endro=new ArrayList<>();
     //Utilisateur u = Session.getUser();
    @FXML
    void ajoutEvent(ActionEvent event) {
        EvennementServices es= new EvennementServices();
        UtilisateurServices us = new UtilisateurServices();
        Utilisateur user = Session.getUser();
        Evennement ev = new Evennement();
        Endroit e = new Endroit();
        EndroitServices ee = new EndroitServices();
        
        String Nom = nom.getText();
        int endr = endroit.getSelectionModel().getSelectedIndex();
        int x = endro.get(endr).getId();
        LocalDate dated = datedebut.getValue();
        LocalDate datedf = datefin.getValue();
        int nbrp = Integer.parseInt(nbrplace.getText());
        String description=desc.getText();
        Double lpde=Double.parseDouble(lpd.getText());
        Double lpaa=Double.parseDouble(lpa.getText());
        Double apde=Double.parseDouble(apd.getText());
        Double apaa=Double.parseDouble(apa.getText());
        int def = Integer.parseInt(diff.getText());
        
        ev.setNom(Nom);
        ev.setIdEndroit(ee.rechercheById(x));
        ev.setDifficulte(def);
        ev.setDescription(description);
        ev.setNbrPlaces(nbrp);
        ev.setDateDebut(dated);
        ev.setDateFin(datedf);
        ev.setLongitudePOintDepart(lpde);
        ev.setLongitudePOintArrivee(lpaa);
        ev.setLattitudePOintDepart(apde);
        ev.setLattitudePOintArrivee(apaa);
        ev.setIdResponsable(user);        
        
        es.ajouterEvennement(ev);
              
            }
        
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        EndroitServices ens=new EndroitServices();
       //   ArrayList<Endroit> endro=new ArrayList<>();
        endro=(ArrayList<Endroit>)ens.afficherEndroit();
          ArrayList<String> endrocombo=new ArrayList<>();
        for(Endroit ed:endro){
        endrocombo.add(ed.getNom());
        }
        ObservableList<String> names=FXCollections.observableArrayList(endrocombo);
       endroit.setItems(names);
        
        
    }    
    
}
