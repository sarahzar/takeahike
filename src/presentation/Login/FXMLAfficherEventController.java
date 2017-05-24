/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.Login;

import services.EvennementServices;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author monta
 */
public class FXMLAfficherEventController implements Initializable {

//    
//       @FXML
//    private Pane paneevent1;
//
//    @FXML
//    private ImageView imgevent1;
//
//    @FXML
//    private Label labvoirplus;
//
//    @FXML
//    private Label labdatdeb;
//
//    @FXML
//    private Label labdatfin;
//
//    @FXML
//    private Label labendroit;
//
//    @FXML
//    private Pane paneevent2;
//
//    @FXML
//    private Label labnom;
//
//    @FXML
//    void e10505(ActionEvent event) {
//
//    }
//
//    @FXML
//    void f20b0b(ActionEvent event) {
//
//    }

//    @FXML
//    void f20b0b(ActionEvent event) {
//
//    }
//
//    @FXML
//    void f20b0b(ActionEvent event) {
//
//    }
 @FXML
    private Label labdatefin4;

    @FXML
    private Label labdatefin2;

    @FXML
    private ImageView imgrasangela;

    @FXML
    private Label labnom4;

    @FXML
    private Label labDatefin;

    @FXML
    private Label labdatedebut2;

    @FXML
    private JFXButton det3;

    @FXML
    private Label labdatedebut4;

    @FXML
    private JFXButton det4;

    @FXML
    private JFXButton det1;

    @FXML
    private JFXButton det2;

    @FXML
    private Label labnome1;

    @FXML
    private Label labnome2;

    @FXML
    private Label labnome3;

    @FXML
    private Label datefin3;

    @FXML
    private Label labend1;

    @FXML
    private Label labendroit3;

    @FXML
    private ImageView imgindrahem;

    @FXML
    private Label labendroit2;

    @FXML
    private Label labdateDebut;

    @FXML
    private Label labendroit4;

    @FXML
    private ImageView imgtabledujugharta;

    @FXML
    private ImageView imgkesra;

    @FXML
    private Label datedebut3;
    
    @FXML
    void ouvrirDetails(ActionEvent event) throws IOException {
        
        FXMLLoader fxmlLoader = new FXMLLoader();
             fxmlLoader.setLocation(getClass().getResource("detailsaindrahem.fxml"));
             Scene scene = new Scene(fxmlLoader.load(), 900, 600);
             Stage stage = new Stage();
             stage.setTitle("details");
             stage.setScene(scene);
             
             stage.show();
             stage.setResizable(false);
             ((Node)(event.getSource())).getScene().getWindow().hide();

    }

    @FXML
    void Detailkesra(ActionEvent event) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader();
             fxmlLoader.setLocation(getClass().getResource("Detailskesra.fxml"));
             Scene scene = new Scene(fxmlLoader.load(), 900, 600);
             Stage stage = new Stage();
             stage.setTitle("Details");
             stage.setScene(scene);
             
             stage.show();
             stage.setResizable(false);
             ((Node)(event.getSource())).getScene().getWindow().hide();
    }
       @FXML
    void DetailTableduJugortha(ActionEvent event) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader();
             fxmlLoader.setLocation(getClass().getResource("Detailstablejugortha.fxml"));
             Scene scene = new Scene(fxmlLoader.load(), 900, 600);
             Stage stage = new Stage();
             stage.setTitle("Details");
             stage.setScene(scene);
             
             stage.show();
             stage.setResizable(false);
             ((Node)(event.getSource())).getScene().getWindow().hide();
    }
       @FXML
    void DetailBniMtir(ActionEvent event) throws IOException {
FXMLLoader fxmlLoader = new FXMLLoader();
             fxmlLoader.setLocation(getClass().getResource("DetailsBniMtir.fxml"));
             Scene scene = new Scene(fxmlLoader.load(), 900, 600);
             Stage stage = new Stage();
             stage.setTitle("Details");
             stage.setScene(scene);
             
             stage.show();
             stage.setResizable(false);
             ((Node)(event.getSource())).getScene().getWindow().hide();
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        imgrasangela.setImage(new Image("img/bnimtir2.jpg"));
         imgkesra.setImage(new Image("img/kesra.jpg"));
         imgtabledujugharta.setImage(new Image("img/table du jugortha.jpg"));
         imgindrahem.setImage(new Image("img/ain drahem.jpg"));
         EvennementServices ms = new EvennementServices();
         
            labnome1.setText(ms.afficherEvennement().get(2).getNom());
            labend1.setText(ms.afficherEvennement().get(2).getIdEndroit().getNom());
            labdateDebut.setText(String.valueOf(ms.afficherEvennement().get(2).getDateDebut()));
            labDatefin.setText(String.valueOf(ms.afficherEvennement().get(2).getDateDebut()));
    
            labnome2.setText(ms.afficherEvennement().get(0).getNom());
       labendroit2.setText(ms.afficherEvennement().get(0).getIdEndroit().getNom());
   labdatedebut2.setText(String.valueOf(ms.afficherEvennement().get(0).getDateDebut()));
   labdatefin2.setText(String.valueOf(ms.afficherEvennement().get(0).getDateFin()));
   
   labnome3.setText(ms.afficherEvennement().get(3).getNom());
       labendroit3.setText(ms.afficherEvennement().get(3).getIdEndroit().getNom());
   datedebut3.setText(String.valueOf(ms.afficherEvennement().get(3).getDateDebut()));
   datefin3.setText(String.valueOf(ms.afficherEvennement().get(3).getDateFin()));
   
    labnom4.setText(ms.afficherEvennement().get(1).getNom());
       labendroit4.setText(ms.afficherEvennement().get(1).getIdEndroit().getNom());
   labdatedebut4.setText(String.valueOf(ms.afficherEvennement().get(1).getDateDebut()));
   labdatefin4.setText(String.valueOf(ms.afficherEvennement().get(1).getDateFin()));
   
   
    }
    
}
