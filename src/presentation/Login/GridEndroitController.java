/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.Login;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import entities.Endroit;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import services.EndroitServices;

/**
 * FXML Controller class
 *
 * @author achre
 */
public class GridEndroitController implements Initializable {
@FXML
    private AnchorPane Endroitaffich;
    @FXML
    private ScrollPane ScrolEndr;

    @FXML
    private Pane ajoutEndr;

    @FXML
    private JFXButton creerendr;
    
    public void listeEndroit (){
        JFXButton btaff = new JFXButton("<<");
        btaff.translateXProperty().set(100);
        btaff.translateYProperty().set(50);
        
        JFXButton suppendroit = new JFXButton("Supprimer");
                    suppendroit.translateXProperty().set(740);
                    suppendroit.translateYProperty().set(50);
        
        GridPane gridee = new GridPane();
        Pane detailspan = new Pane();
        detailspan.translateYProperty().set(100);
        gridee.prefHeight(1000);
        gridee.prefWidth(600);

        gridee.setHgap(50);
        gridee.setVgap(10);
        gridee.setStyle("-fx-background-color : white ;");
        ScrolEndr.setContent(gridee);
        EndroitServices ens = new EndroitServices();
    int x = ens.afficherEndroit().size();
        int i = 0, j = 0, nb = 0;
        
        btaff.setOnAction((event)
                -> {
            ScrolEndr.setVisible(true);

            ajoutEndr.setVisible(true);
            detailspan.setVisible(false);
            btaff.setVisible(false);
            suppendroit.setVisible(false);
            listeEndroit();
        });
        
        for (j = 0; j < x; j = j + 2) {
            for (i = 0; i < 2; i++) {

                if (nb + 1 <= x) {

                    Label lab = new Label(ens.afficherEndroit().get(nb).getNom());
                    lab.translateYProperty().set(5);
                    lab.translateXProperty().set(150);
                    lab.textFillProperty().set(Color.BLACK);
                    lab.setFont(Font.font("Verdana", FontPosture.ITALIC, 20));
                          
                    

                    
                    ImageView image = new ImageView(ens.afficherEndroit().get(nb).getImage());
                    
                    image.translateXProperty().set(5);
                    image.translateYProperty().set(35);

                    image.setFitWidth(380);
                    image.setFitHeight(160);
                    
                    Button btnplus = new JFXButton();
                    btnplus.setText("Voir Plus");
                    btnplus.translateYProperty().setValue(200);
                    btnplus.translateXProperty().set(300);
                    btnplus.setStyle("-fx-border-color: blue");
                    
                    Pane pane = new Pane();

                    pane.getChildren().addAll(image, lab,  btnplus);
                    pane.setPrefSize(400, 230);
                    pane.translateXProperty().set(5);
                    pane.setStyle("-fx-background-color: white; -fx-border-color: black");
                    
                    // details 
                    int idendroit = ens.afficherEndroit().get(nb).getId();
                    
                    JFXTextArea description = new JFXTextArea();
                    description.translateYProperty().set(270);
                    description.translateXProperty().set(250);
                    description.setText(ens.afficherEndroit().get(nb).getDescription());
                    description.setEditable(false);
                    
                    Label Nom = new Label("Nom Endroit :  ");
                    Nom.translateXProperty().set(100);
                    Nom.translateYProperty().set(50);
                    Nom.setFont(Font.font("Verdana", FontPosture.ITALIC, 20));
                    
                    Label nome = new Label();
                    
                    nome.translateXProperty().set(250);
                    nome.translateYProperty().set(50);
                    nome.setText(ens.afficherEndroit().get(nb).getNom());
                    nome.setFont(Font.font("Verdana", FontPosture.ITALIC, 20));
                    Pane padetails = new Pane();
                    padetails.getChildren().addAll(nome,description,Nom);
                    detailspan.setVisible(true);
                    
            gridee.add(pane,i,j);
            btnplus.setOnAction((value) -> {
                ScrolEndr.setVisible(false);

                        ajoutEndr.setVisible(false);
                        
                        detailspan.setDisable(false);
                        detailspan.getChildren().addAll(padetails);
            
            suppendroit.setOnAction((ensupp)->{
                                    
                                 Endroit e = new Endroit(idendroit);
                               ens.supprimerEndroit(e);
                                ScrolEndr.setVisible(true);
                                
                                ajoutEndr.setVisible(true);
                                btaff.setVisible(false);
                                
                                suppendroit.setVisible(false);
                                
                                padetails.setVisible(false);
                                listeEndroit();
                                });
            Endroitaffich.getChildren().addAll(btaff,detailspan,suppendroit);
        });
            }
                nb++;
            }
            i=j+i;
        }
    }
    
    @FXML
    void CreerEndroit(ActionEvent event) throws IOException {
Parent root = FXMLLoader.load(getClass().getResource("Endroit.fxml"));
        Scene scene = new Scene(root, 900, 600);
        Stage stage = new Stage();
        stage.setTitle("Ajouter un evennement");
        stage.setScene(scene);
        stage.show();

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listeEndroit();
    }    
    
}

