/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.Login;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import entities.Evennement;
import entities.Galerie;
import entities.Session;
import entities.Utilisateur;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Callback;
import org.controlsfx.control.GridCell;
import org.controlsfx.control.GridView;
import org.controlsfx.control.cell.ColorGridCell;
//import static presentation.Login.Gallerie2Controller.idevent;
import services.EvennementServices;
import services.GalerieServices;
import com.teamdev.jxmaps.GeocoderCallback;
import com.teamdev.jxmaps.GeocoderRequest;
import com.teamdev.jxmaps.GeocoderResult;
import com.teamdev.jxmaps.GeocoderStatus;
import com.teamdev.jxmaps.InfoWindow;
import com.teamdev.jxmaps.Map;
import com.teamdev.jxmaps.MapReadyHandler;
import com.teamdev.jxmaps.MapStatus;
import com.teamdev.jxmaps.Marker;
import com.teamdev.jxmaps.javafx.MapView;
import javafx.scene.layout.BorderPane;


public class FXMLGRIDEVENTController implements Initializable {

    @FXML
    private AnchorPane acceuilpan;

    @FXML
    private JFXTabPane tabpane;

    @FXML
    private ScrollPane scrollEvent;

    @FXML
    private JFXButton Ajoutevent;

    @FXML
    private ScrollPane scrollEvent1;

   List<Evennement> listevt1 = new ArrayList<>(); 
    List<Evennement> listevt = new ArrayList<>();

    @FXML
    private Pane ajoutpane;

    
    public void Event() {
        Utilisateur user = Session.getUser();
        Stage newStage = new Stage();

    
      
//        back.getHeight(5);
//        back.getWidth(5);
        JFXButton btaff = new JFXButton("<<");
        btaff.translateXProperty().set(100);
        btaff.translateYProperty().set(50);
        
        JFXButton modifevt = new JFXButton("Modifier");
                    modifevt.translateXProperty().set(650);
                    modifevt.translateYProperty().set(50);
                    
                    JFXButton update = new JFXButton("Enregistrer");
                    update.translateXProperty().set(600);
                    update.translateYProperty().set(550);
                    update.setVisible(false);
                    
                    JFXButton suppevt = new JFXButton("Supprimer");
                    suppevt.translateXProperty().set(740);
                    suppevt.translateYProperty().set(50);
        
        GridPane gridee = new GridPane();
        Pane detailspan = new Pane();
        detailspan.translateYProperty().set(100);
        gridee.prefHeight(900);
        gridee.prefWidth(600);

        gridee.setHgap(40);
        gridee.setVgap(10);
        gridee.setStyle("-fx-background-color : white ;");
        scrollEvent.setContent(gridee);

       EvennementServices es = new EvennementServices();
      List<Evennement> evtlist = new ArrayList<>();
       evtlist = (ArrayList<Evennement>) es.afficherEvennementAvenir();

        int x = es.afficherEvennementAvenir().size();
        int i = 0, j = 0, nb = 0;

        //remplir la liste des galeries de chaque evennement dans la liste                    
        GalerieServices gservice = new GalerieServices();
        List<Galerie> galeries = new ArrayList<>();
        galeries = (ArrayList<Galerie>) gservice.afficherGalerie();

        EvennementServices evtservice = new EvennementServices();
       // List<Evennement> listevt = new ArrayList<>();
        listevt = (ArrayList<Evennement>) evtservice.afficherEvennementAvenir();

        List<ImageView> imglist = new ArrayList<>();
        for (int z = 0; z < listevt.size(); z++) {

            for (int h = 0; h < galeries.size(); h++) {
                if (listevt.get(z).getId() == galeries.get(h).getIdEvt()) {
                    listevt.get(z).getGllist().add(galeries.get(h));

                }

            }
        }
        btaff.setOnAction((event)
                -> {
            scrollEvent.setVisible(true);
            tabpane.setVisible(true);
            ajoutpane.setVisible(true);
            detailspan.setVisible(false);
            btaff.setVisible(false);
            update.setVisible(false);
            suppevt.setVisible(false);
            modifevt.setVisible(false);
            Event();
        });

        //parcour de la liste des evnnements et affichage des pannes
        
        for (i = 0; i < x; i = i + 2) {
            for (j = 0; j < 2; j++) {

                if (nb + 1 <= x) {
                    int idevent = es.afficherEvennementorganise().get(nb).getId();
                    Label lab = new Label(es.afficherEvennementAvenir().get(nb).getNom());
                    lab.translateYProperty().set(25);
                    lab.translateXProperty().set(200);
                    lab.textFillProperty().set(Color.BLACK);

                    Label lab2 = new Label(es.afficherEvennementAvenir().get(nb).getIdEndroit().getNom());
                    lab2.translateYProperty().set(50);
                    lab2.translateXProperty().set(200);
                    lab2.textFillProperty().set(Color.BLACK);

                    Label lab3 = new Label(String.valueOf(es.afficherEvennementAvenir().get(nb).getDateDebut()));
                    lab3.translateYProperty().set(75);
                    lab3.translateXProperty().set(200);
                    lab3.textFillProperty().set(Color.BLACK);

                    Label lab4 = new Label(String.valueOf(es.afficherEvennementAvenir().get(nb).getDateFin()));
                    lab4.translateYProperty().set(100);
                    lab4.translateXProperty().set(200);
                    lab4.textFillProperty().set(Color.BLACK);

                    Button btn = new JFXButton();
                    btn.setText("Voir Plus");
                    btn.translateYProperty().setValue(170);
                    btn.translateXProperty().set(330);
                    btn.setStyle("-fx-border-color: blue");

                    //création d'une liste d'image  
                    imglist.add(new ImageView(new Image("http://localhost/takeahike/img/"+listevt.get(nb).getGllist().get(0).getImage())));
                    imglist.get(nb).translateXProperty().setValue(5);
                    imglist.get(nb).translateYProperty().setValue(5);

                    imglist.get(nb).setFitWidth(170);
                    imglist.get(nb).setFitHeight(170);
                    Pane pane = new Pane();

                    pane.getChildren().addAll(imglist.get(nb), lab, lab2, lab3, lab4, btn);
                    pane.setPrefSize(450, 200);
                    pane.translateXProperty().set(25);
                    pane.setStyle("-fx-background-color: white; -fx-border-color: black");

                    //Affichage du details evennement
                    
                        
                    
                    
                   
                    
                    JFXTextArea description = new JFXTextArea();
                    description.translateYProperty().set(270);
                    description.translateXProperty().set(350);
                    description.setText(es.afficherEvennementAvenir().get(nb).getDescription());
                    description.setEditable(false);
                    
                    Label Nom = new Label("Nom Rando :  ");
                    Nom.translateXProperty().set(100);
                    Nom.translateYProperty().set(50);

                    Label nome = new Label();
                    
                    nome.translateXProperty().set(170);
                    nome.translateYProperty().set(50);
                    nome.setText(es.afficherEvennementAvenir().get(nb).getNom());

                    Label endroit = new Label("Endroit :  ");
                    endroit.translateXProperty().set(100);
                    endroit.translateYProperty().set(100);

                    Label endr = new Label();

                    endr.translateXProperty().set(170);
                    endr.translateYProperty().set(100);
                    endr.setText(es.afficherEvennementAvenir().get(nb).getIdEndroit().getNom());
                    
                    Label dated=new Label("Date Debut : ");
                    dated.translateYProperty().set(150);
                    dated.translateXProperty().set(100);
                    
                    
                    Label dt=new Label();
                    dt.translateYProperty().set(150);
                    dt.translateXProperty().set(170);
                    dt.setText(String.valueOf(es.afficherEvennementAvenir().get(nb).getDateDebut()));
                    
                    Label datef=new Label("Date Fin : ");
                    datef.translateYProperty().set(180);
                    datef.translateXProperty().set(100);
                    
                    Label df=new Label();
                    df.translateYProperty().set(180);
                    df.translateXProperty().set(170);
                    df.setText(String.valueOf(es.afficherEvennementAvenir().get(nb).getDateFin()));
                    
                      Label nbr=new Label("Nombre de places :"); 
                    nbr.translateXProperty().set(100);
                    nbr.translateYProperty().set(240);
                    
                    Label nbrpl=new Label();
                    nbrpl.translateYProperty().set(240);
                    nbrpl.translateXProperty().set(210);
                    nbrpl.setText(String.valueOf(es.afficherEvennementAvenir().get(nb).getNbrPlaces()));
                    
                    JFXTextField places = new JFXTextField();
                    places.translateYProperty().set(240);
                    places.translateXProperty().set(210);
                    places.setText(String.valueOf(es.afficherEvennementAvenir().get(nb).getNbrPlaces()));
                    places.setVisible(false);
                    places.isLabelFloat();
                    places.setPrefWidth(175);
                    
                    
                    
                    Label diff=new Label("Difficulté : ");
                    diff.translateXProperty().set(100);
                    diff.translateYProperty().set(210);
                    
                    JFXComboBox<String> dif=new JFXComboBox();
                    dif.translateXProperty().set(170);
                    dif.translateYProperty().set(170);
                    dif.getItems().add("Facile");
                    dif.getItems().add("Moyen");
                    dif.getItems().add("Difficile");
                    dif.getItems().add("Très Difficile");
                    dif.setVisible(false);
                    
                    Label typdiff = new Label();
                                typdiff.translateXProperty().set(170);
                                typdiff.translateYProperty().set(210);
                                if(es.afficherEvennementAvenir().get(nb).getDifficulte()==0)
                                {
                                    typdiff.setText("Facile");
                                    dif.setValue("Facile");
                                }
                                else if(es.afficherEvennementAvenir().get(nb).getDifficulte()==1)
                                {
                                    typdiff.setText("Moyen");
                                    dif.setValue("Moyen");
                                }
                                else if(es.afficherEvennementAvenir().get(nb).getDifficulte()==2)
                                {
                                    typdiff.setText("Difficile");
                                    dif.setValue("Difficile");
                                }
                                else if(es.afficherEvennementAvenir().get(nb).getDifficulte()==3)
                                {
                                    typdiff.setText("Très Difficile");
                                    dif.setValue("Très Difficile");
                                }
                               
                    
                    Pane padetails = new Pane();
                    JFXButton photos = new JFXButton("photo");
                    photos.translateXProperty().set(120);
                    photos.setOnAction((event) -> {
                        try {
                            Stage stage= new  Stage();
                            FXMLLoader fxmlLoader = new FXMLLoader();
                            fxmlLoader.setLocation(getClass().getResource("UploadApp.fxml"));
                            Scene scene = new Scene(fxmlLoader.load(), 419, 495);
                            stage.setScene(scene);
                            stage.show();
                        } catch (IOException ex) {
                            Logger.getLogger(FXMLGRIDEVENTController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                            
                    });
                //test image   ********************************************************   
                   
                     FlowPane flow = new FlowPane();
                     flow.setPrefWrapLength(300); 
                      flow.setPrefHeight(150);
                    flow.setPrefWidth(463);
                    flow.setTranslateX(350);
                    flow.setTranslateY(75); 
                 //  flow.setStyle("-fx-background-color: white; -fx-border-color: black");
                     List<ImageView> imgliste=new ArrayList<>();
                     for(int m=0;m<listevt.get(nb).getGllist().size();m++){
                         if(m<=2){
               //  imgliste.add(new ImageView(new Image(listevt.get(nb).getGllist().get(m).getImage())));
                imgliste.add(new ImageView(new Image("http://localhost/takeahike/img/"+listevt.get(nb).getGllist().get(m).getImage())));
                     
                  imgliste.get(m).translateXProperty().setValue(5);
                
                     imgliste.get(m).setFitHeight(250);
                     imgliste.get(m).setFitWidth(200);
                    imgliste.get(m).setFitWidth(150);
                     imgliste.get(m).setFitHeight(135); 
                      
                      flow.getChildren().add(imgliste.get(m));
                         }
                     }
                
                      
                   // System.out.println("taille de liste "+listevt.get(0).getGllist().size());
                   
             //  *************************************************************     
                      //*******************************Map***************************** 
                
                //**final MapView mapView = new MapView();

//        mapView.setOnMapReadyHandler(new MapReadyHandler() {
//            @Override
//            public void onMapReady(MapStatus status) {
//                if (status == MapStatus.MAP_STATUS_OK) { 
//                    final Map map = mapView.getMap();
//                    map.setZoom(13.0);
//                    GeocoderRequest request = new GeocoderRequest();
//                    request.setAddress(endr.getText()+" ,TN");
//                    
//                    System.out.println(endr.getText());
//                    //request.setAddress("Rue de Royaume d'Arabie Saoudite، Tunis 1002, TN");
//
//                    mapView.getServices().getGeocoder().geocode(request, new GeocoderCallback(map) {
//                        @Override
//                        public void onComplete(GeocoderResult[] result, GeocoderStatus status) {
//                            if (status == GeocoderStatus.OK) {
//                                map.setCenter(result[0].getGeometry().getLocation());
//                                Marker marker = new Marker(map);
//                                marker.setPosition(result[0].getGeometry().getLocation());
//                                
//                                 
//
//                                final InfoWindow window = new InfoWindow(map);
//                              //  window.setContent("Hello, World!");
//                               // window.open(map, marker);
//                                
//                            }
//                        }
//                    });
//                }
//            }
//        });
//                
//                
//          BorderPane map=new BorderPane(mapView) ;  
//          map.setTranslateX(30);
//          map.setTranslateY(120); 
//          map.setPrefWidth(250);
//          map.setPrefHeight(250);
               
//                
                
               
                    
                    padetails.getChildren().addAll(flow,description, Nom, nome, endroit, endr,dated,dt,datef,df,diff,typdiff,dif,photos,nbr,nbrpl,places);
                    gridee.add(pane, j, i);
                    detailspan.setDisable(true);
                    btn.setOnAction((event) -> {
                            System.out.println(idevent);
                        scrollEvent.setVisible(true);

                        ajoutpane.setVisible(false);
                        tabpane.setVisible(false);
                        detailspan.setDisable(false);
                        detailspan.getChildren().addAll(padetails);
                        
                         
           
                        System.out.println("taille de liste "+listevt.get(0).getGllist().size());
                        
                        
                        
                          modifevt.setOnAction((ev) -> {
                            
                        nome.setVisible(true);
                        endr.setVisible(true);
                        nbrpl.setVisible(false);
                        dt.setVisible(true);
                        df.setVisible(true);
                        typdiff.setVisible(true);
                        dif.setVisible(false);
                        description.setEditable(true);
                        places.setVisible(true);
                        
                        update.setVisible(true);

                    });
                          suppevt.setOnAction((evsupp)->{
                                    
                                Evennement e = new Evennement(idevent);
                                es.supprimerEvennement(e);
                                scrollEvent.setVisible(true);
                                tabpane.setVisible(true);
                                ajoutpane.setVisible(true);
                                btaff.setVisible(false);
                                modifevt.setVisible(false);
                                suppevt.setVisible(false);
                                update.setVisible(false);
                                padetails.setVisible(false);
                                Event();
                                });
                          update.setOnAction((modif) -> {
                              
                              Evennement e = new Evennement(idevent);
                              e.setNbrPlaces(Integer.parseInt(places.getText()));
                              e.setDescription(description.getText());
                              es.modifierEvennement(e);
                               scrollEvent.setVisible(true);
                                tabpane.setVisible(true);
                                ajoutpane.setVisible(true);
                                btaff.setVisible(false);
                                modifevt.setVisible(false);
                                suppevt.setVisible(false);
                                update.setVisible(false);
                                padetails.setVisible(false);
                                Event();
                          });
                        acceuilpan.getChildren().addAll(btaff, detailspan,modifevt,suppevt,update);

                    });

                }
                nb++;
            }
            j = i + j;
        }
    }

    public void Event2() {

         Utilisateur user = Session.getUser();
        Stage newStage = new Stage();

    
      
//        back.getHeight(5);
//        back.getWidth(5);
        JFXButton btaff = new JFXButton("<<");
        btaff.translateXProperty().set(100);
        btaff.translateYProperty().set(50);
        
        JFXButton modifevt = new JFXButton("Modifier");
                    modifevt.translateXProperty().set(650);
                    modifevt.translateYProperty().set(50);
                    
                    JFXButton update = new JFXButton("Enregistrer");
                    update.translateXProperty().set(600);
                    update.translateYProperty().set(550);
                    update.setVisible(false);
                    
                    JFXButton suppevt = new JFXButton("Supprimer");
                    suppevt.translateXProperty().set(740);
                    suppevt.translateYProperty().set(50);
        
        GridPane gridee = new GridPane();
        Pane detailspan = new Pane();
        detailspan.translateYProperty().set(100);
        gridee.prefHeight(900);
        gridee.prefWidth(600);

        gridee.setHgap(40);
        gridee.setVgap(10);
        gridee.setStyle("-fx-background-color : white ;");
        scrollEvent1.setContent(gridee);

       EvennementServices es = new EvennementServices();
      List<Evennement> evtlist1 = new ArrayList<>();
       evtlist1 = (ArrayList<Evennement>) es.afficherEvennementorganise();

        int x = es.afficherEvennementorganise().size();
        int i = 0, j = 0, nb = 0;

        //remplir la liste des galeries de chaque evennement dans la liste                    
        GalerieServices gservice = new GalerieServices();
        List<Galerie> galeries = new ArrayList<>();
        galeries = (ArrayList<Galerie>) gservice.afficherGalerie();

        EvennementServices evtservice = new EvennementServices();
       // List<Evennement> listevt = new ArrayList<>();
        listevt1 = (ArrayList<Evennement>) evtservice.afficherEvennementorganise();

        List<ImageView> imglist = new ArrayList<>();
        for (int z = 0; z < listevt1.size(); z++) {

            for (int h = 0; h < galeries.size(); h++) {
                if (listevt1.get(z).getId() == galeries.get(h).getIdEvt()) {
                    listevt1.get(z).getGllist().add(galeries.get(h));

                }

            }
        }
        btaff.setOnAction((event)
                -> {
            scrollEvent1.setVisible(true);
            tabpane.setVisible(true);
            ajoutpane.setVisible(true);
            detailspan.setVisible(false);
            btaff.setVisible(false);
            update.setVisible(false);
            suppevt.setVisible(false);
            modifevt.setVisible(false);
            Event2();
        });

        //parcour de la liste des evnnements et affichage des pannes
        
        for (i = 0; i < x; i = i + 2) {
            for (j = 0; j < 2; j++) {

                if (nb + 1 <= x) {
                    int idevent = es.afficherEvennementorganise().get(nb).getId();
                    Label lab = new Label(es.afficherEvennementorganise().get(nb).getNom());
                    lab.translateYProperty().set(25);
                    lab.translateXProperty().set(200);
                    lab.textFillProperty().set(Color.BLACK);

                    Label lab2 = new Label(es.afficherEvennementorganise().get(nb).getIdEndroit().getNom());
                    lab2.translateYProperty().set(50);
                    lab2.translateXProperty().set(200);
                    lab2.textFillProperty().set(Color.BLACK);

                    Label lab3 = new Label(String.valueOf(es.afficherEvennementorganise().get(nb).getDateDebut()));
                    lab3.translateYProperty().set(75);
                    lab3.translateXProperty().set(200);
                    lab3.textFillProperty().set(Color.BLACK);

                    Label lab4 = new Label(String.valueOf(es.afficherEvennementorganise().get(nb).getDateFin()));
                    lab4.translateYProperty().set(100);
                    lab4.translateXProperty().set(200);
                    lab4.textFillProperty().set(Color.BLACK);

                    Button btn = new JFXButton();
                    btn.setText("Voir Plus");
                    btn.translateYProperty().setValue(170);
                    btn.translateXProperty().set(330);
                    btn.setStyle("-fx-border-color: blue");

                    //création d'une liste d'image  
                    imglist.add(new ImageView(new Image("http://localhost/takeahike/img/"+listevt1.get(nb).getGllist().get(0).getImage())));
                    imglist.get(nb).translateXProperty().setValue(5);
                    imglist.get(nb).translateYProperty().setValue(5);

                    imglist.get(nb).setFitWidth(170);
                    imglist.get(nb).setFitHeight(170);
                    Pane pane = new Pane();

                    pane.getChildren().addAll(imglist.get(nb), lab, lab2, lab3, lab4, btn);
                    pane.setPrefSize(450, 200);
                    pane.translateXProperty().set(25);
                    pane.setStyle("-fx-background-color: white; -fx-border-color: black");

                    //Affichage du details evennement
                    
                        
                    
                    
                   
                    
                    JFXTextArea description = new JFXTextArea();
                    description.translateYProperty().set(270);
                    description.translateXProperty().set(350);
                    description.setText(es.afficherEvennementorganise().get(nb).getDescription());
                    description.setEditable(false);
                    
                    Label Nom = new Label("Nom Rando :  ");
                    Nom.translateXProperty().set(100);
                    Nom.translateYProperty().set(50);

                    Label nome = new Label();
                    
                    nome.translateXProperty().set(170);
                    nome.translateYProperty().set(50);
                    nome.setText(es.afficherEvennementorganise().get(nb).getNom());

                    Label endroit = new Label("Endroit :  ");
                    endroit.translateXProperty().set(100);
                    endroit.translateYProperty().set(100);

                    Label endr = new Label();

                    endr.translateXProperty().set(170);
                    endr.translateYProperty().set(100);
                    endr.setText(es.afficherEvennementorganise().get(nb).getIdEndroit().getNom());
                    
                    Label dated=new Label("Date Debut : ");
                    dated.translateYProperty().set(150);
                    dated.translateXProperty().set(100);
                    
                    
                    Label dt=new Label();
                    dt.translateYProperty().set(150);
                    dt.translateXProperty().set(170);
                    dt.setText(String.valueOf(es.afficherEvennementorganise().get(nb).getDateDebut()));
                    
                    Label datef=new Label("Date Fin : ");
                    datef.translateYProperty().set(180);
                    datef.translateXProperty().set(100);
                    
                    Label df=new Label();
                    df.translateYProperty().set(180);
                    df.translateXProperty().set(170);
                    df.setText(String.valueOf(es.afficherEvennementorganise().get(nb).getDateFin()));
                    
                      Label nbr=new Label("Nombre de places :"); 
                    nbr.translateXProperty().set(100);
                    nbr.translateYProperty().set(240);
                    
                    Label nbrpl=new Label();
                    nbrpl.translateYProperty().set(240);
                    nbrpl.translateXProperty().set(210);
                    nbrpl.setText(String.valueOf(es.afficherEvennementorganise().get(nb).getNbrPlaces()));
                    
                    JFXTextField places = new JFXTextField();
                    places.translateYProperty().set(240);
                    places.translateXProperty().set(210);
                    places.setText(String.valueOf(es.afficherEvennementorganise().get(nb).getNbrPlaces()));
                    places.setVisible(false);
                    places.isLabelFloat();
                    places.setPrefWidth(175);
                    
                    
                    
                    Label diff=new Label("Difficulté : ");
                    diff.translateXProperty().set(100);
                    diff.translateYProperty().set(210);
                    
                    JFXComboBox<String> dif=new JFXComboBox();
                    dif.translateXProperty().set(170);
                    dif.translateYProperty().set(170);
                    dif.getItems().add("Facile");
                    dif.getItems().add("Moyen");
                    dif.getItems().add("Difficile");
                    dif.getItems().add("Très Difficile");
                    dif.setVisible(false);
                    
                    Label typdiff = new Label();
                                typdiff.translateXProperty().set(170);
                                typdiff.translateYProperty().set(210);
                                if(es.afficherEvennementorganise().get(nb).getDifficulte()==0)
                                {
                                    typdiff.setText("Facile");
                                    dif.setValue("Facile");
                                }
                                else if(es.afficherEvennementorganise().get(nb).getDifficulte()==1)
                                {
                                    typdiff.setText("Moyen");
                                    dif.setValue("Moyen");
                                }
                                else if(es.afficherEvennementorganise().get(nb).getDifficulte()==2)
                                {
                                    typdiff.setText("Difficile");
                                    dif.setValue("Difficile");
                                }
                                else if(es.afficherEvennementorganise().get(nb).getDifficulte()==3)
                                {
                                    typdiff.setText("Très Difficile");
                                    dif.setValue("Très Difficile");
                                }
                               
                    
                    Pane padetails = new Pane();
                    JFXButton photos = new JFXButton("photo");
                    photos.translateXProperty().set(120);
                    photos.setOnAction((event) -> {
                        try {
                            Stage stage= new  Stage();
                            FXMLLoader fxmlLoader = new FXMLLoader();
                            fxmlLoader.setLocation(getClass().getResource("UploadApp.fxml"));
                            Scene scene = new Scene(fxmlLoader.load(), 419, 495);
                            stage.setScene(scene);
                            stage.show();
                        } catch (IOException ex) {
                            Logger.getLogger(FXMLGRIDEVENTController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                            
                    });
                //test image   ********************************************************   
                   
                     FlowPane flow = new FlowPane();
                     flow.setPrefWrapLength(300); 
                      flow.setPrefHeight(150);
                    flow.setPrefWidth(463);
                    flow.setTranslateX(350);
                    flow.setTranslateY(75); 
                 //  flow.setStyle("-fx-background-color: white; -fx-border-color: black");
                     List<ImageView> imgliste=new ArrayList<>();
                     for(int m=0;m<listevt1.get(nb).getGllist().size();m++){
                         if(m<=2){
               //  imgliste.add(new ImageView(new Image(listevt.get(nb).getGllist().get(m).getImage())));
                imgliste.add(new ImageView(new Image("http://localhost/takeahike/img/"+listevt1.get(nb).getGllist().get(m).getImage())));
                     
                  imgliste.get(m).translateXProperty().setValue(5);
                
                     imgliste.get(m).setFitHeight(250);
                     imgliste.get(m).setFitWidth(200);
                    imgliste.get(m).setFitWidth(150);
                     imgliste.get(m).setFitHeight(135); 
                      
                      flow.getChildren().add(imgliste.get(m));
                         }
                     }
                
                      
                   // System.out.println("taille de liste "+listevt.get(0).getGllist().size());
                   
             //  *************************************************************     
                      //*******************************Map***************************** 
                
                //**final MapView mapView = new MapView();

//        mapView.setOnMapReadyHandler(new MapReadyHandler() {
//            @Override
//            public void onMapReady(MapStatus status) {
//                if (status == MapStatus.MAP_STATUS_OK) { 
//                    final Map map = mapView.getMap();
//                    map.setZoom(13.0);
//                    GeocoderRequest request = new GeocoderRequest();
//                    request.setAddress(endr.getText()+" ,TN");
//                    
//                    System.out.println(endr.getText());
//                    //request.setAddress("Rue de Royaume d'Arabie Saoudite، Tunis 1002, TN");
//
//                    mapView.getServices().getGeocoder().geocode(request, new GeocoderCallback(map) {
//                        @Override
//                        public void onComplete(GeocoderResult[] result, GeocoderStatus status) {
//                            if (status == GeocoderStatus.OK) {
//                                map.setCenter(result[0].getGeometry().getLocation());
//                                Marker marker = new Marker(map);
//                                marker.setPosition(result[0].getGeometry().getLocation());
//                                
//                                 
//
//                                final InfoWindow window = new InfoWindow(map);
//                              //  window.setContent("Hello, World!");
//                               // window.open(map, marker);
//                                
//                            }
//                        }
//                    });
//                }
//            }
//        });
//                
//                
//          BorderPane map=new BorderPane(mapView) ;  
//          map.setTranslateX(30);
//          map.setTranslateY(120); 
//          map.setPrefWidth(250);
//          map.setPrefHeight(250);
               
//                
                
               
                    
                    padetails.getChildren().addAll(flow,description, Nom, nome, endroit, endr,dated,dt,datef,df,diff,typdiff,dif,photos,nbr,nbrpl,places);
                    gridee.add(pane, j, i);
                    detailspan.setDisable(true);
                    btn.setOnAction((event) -> {
                            System.out.println(idevent);
                        scrollEvent1.setVisible(true);

                        ajoutpane.setVisible(false);
                        tabpane.setVisible(false);
                        detailspan.setDisable(false);
                        detailspan.getChildren().addAll(padetails);
                        
                         
           
                        System.out.println("taille de liste "+listevt1.get(0).getGllist().size());
                        
                        
                        
                          modifevt.setOnAction((ev) -> {
                            
                        nome.setVisible(true);
                        endr.setVisible(true);
                        nbrpl.setVisible(false);
                        dt.setVisible(true);
                        df.setVisible(true);
                        typdiff.setVisible(true);
                        dif.setVisible(false);
                        description.setEditable(true);
                        places.setVisible(true);
                        
                        update.setVisible(true);

                    });
                          suppevt.setOnAction((evsupp)->{
                                    
                                Evennement e = new Evennement(idevent);
                                es.supprimerEvennement(e);
                                scrollEvent1.setVisible(true);
                                tabpane.setVisible(true);
                                ajoutpane.setVisible(true);
                                btaff.setVisible(false);
                                modifevt.setVisible(false);
                                suppevt.setVisible(false);
                                update.setVisible(false);
                                padetails.setVisible(false);
                                Event2();
                                });
                          update.setOnAction((modif) -> {
                              
                              Evennement e = new Evennement(idevent);
                              e.setNbrPlaces(Integer.parseInt(places.getText()));
                              e.setDescription(description.getText());
                              es.modifierEvennement(e);
                               scrollEvent1.setVisible(true);
                                tabpane.setVisible(true);
                                ajoutpane.setVisible(true);
                                btaff.setVisible(false);
                                modifevt.setVisible(false);
                                suppevt.setVisible(false);
                                update.setVisible(false);
                                padetails.setVisible(false);
                                Event2();
                          });
                        acceuilpan.getChildren().addAll(btaff, detailspan,modifevt,suppevt,update);

                    });

                }
                nb++;
            }
            j = i + j;
        }
    }

    @FXML
    void AjoutEvennement(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("FXMLInterfaceEvent.fxml"));
        Scene scene = new Scene(root, 900, 600);
        Stage stage = new Stage();
        stage.setTitle("Ajouter un evennement");
        stage.setScene(scene);
        stage.show();

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Event();

        Event2();
    }
} 
