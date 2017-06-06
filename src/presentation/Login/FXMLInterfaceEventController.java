
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
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import entities.Endroit;
import entities.Session;
import entities.Utilisateur;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import static presentation.Login.VerifEvent.textAreaNotEmpty;
import static presentation.Login.VerifEvent.textFieldNotEmpty;
import static presentation.Login.VerifEvent.verifdouble;
import static presentation.Login.VerifEvent.verifierString;
import static presentation.Login.VerifEvent.verifnbr;

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
    @FXML
    private Label lblnom;

    @FXML
    private Label lablendroit;

    @FXML
    private Label labeldateD;

    @FXML
    private Label labeldateF;

    @FXML
    private Label labelnbpl;

    @FXML
    private Label labdeficute;

    @FXML
    private Label labdesc;

    @FXML
    private Label longitude;

    @FXML
    private Label labLatitudedep;

    @FXML
    private Label longar;

    @FXML
    private Label lattitudearr;
     @FXML
    private Label laberreur;
     
    @FXML
    private JFXButton btpic;
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
        
        boolean verif=true;
        boolean verifnomevent=textFieldNotEmpty(nom,lblnom,"le nom est obligatoire");
        boolean verifnombreplace=textFieldNotEmpty(nbrplace, labelnbpl, "nombre place obligatoire");
        boolean verifdescription=textAreaNotEmpty(desc, labdesc, "Description es obligatoire");
        boolean verifdifficulte=textFieldNotEmpty(diff, labdeficute, "difficulté est obligatoire ");
        boolean veriflongitudeptd=textFieldNotEmpty(lpd, longitude, "longitude depart est obligatoire");
        boolean veriflattitudeptd=textFieldNotEmpty(apd, labLatitudedep, "lattitude depart est obligatoire");
        boolean veriflongitudepta=textFieldNotEmpty(lpa, longar, "longitude arrivée est obligatoire");
        boolean veriflattitudepta=textFieldNotEmpty(apd, lattitudearr, "lattitude arrivée est obligatoire");
        
        if (verifnomevent)
        {
            boolean verifnomverif =verifierString(nom, lblnom, "Pas d'entiers!");
                verif=verifnomverif;
        }
        if (verifnombreplace)
        {
            boolean nbrplaceverif=verifnbr(nbrplace, labelnbpl, "invalide");
            verif=nbrplaceverif;
        }
        if (verifdifficulte)
        {
            boolean diffverif=verifnbr(diff, labdeficute, "invalide");
            verif=diffverif;
        }
        if (veriflongitudeptd)
        {
          boolean verifllongdep=verifdouble(lpd, longitude, "invalide");
          verif=verifllongdep;
           
        }
        if (veriflattitudeptd)
        {
             boolean veriflattptd=verifdouble(apd, labLatitudedep, "invalide");
          verif=veriflattptd;
           
        }
        if (veriflongitudepta)
        {
          boolean verifllongdar=verifdouble(lpa, longar, "invalide");
          verif=verifllongdar;  
           
        }
        if (veriflattitudepta)
        {
          boolean veriflattdar=verifdouble(lpa, lattitudearr, "invalide");
          verif=veriflattdar;  
           
        }
//            if (datedebut.getValue()==null)
//        {
//            labeldateD.setText("La date debut est obligatoire");
//        }
//            else
//            {
//                LocalDate now = LocalDate.now();
//            Period p = Period.between(datedebut.getValue() , now);
//            if (p.getYears())
//                
//            }
//               if (datefin.getValue()==null)
//        {
//            labeldateF.setText("La date debut est obligatoire");
//        } 
//               else
//               {
//                 LocalDate now = LocalDate.now();
//            Period p = Period.between(datefin.getValue() , now);  
//               }
               
               if(verif && verifnomevent && verifnombreplace && veriflattitudepta && verifdifficulte && veriflongitudeptd && veriflattitudeptd && veriflongitudepta)
               {
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
              laberreur.setText("Ajout effectué avec succes");
            }
               else laberreur.setText("Verifier les champs");
    }
    
    @FXML
    void ajoutphoto(ActionEvent event) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("UploadApp.fxml"));
        Scene scene = new Scene(root, 900, 600);
        Stage stage = new Stage();
        stage.setTitle("Ajouter photos");
        stage.setScene(scene);
        stage.show();
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
