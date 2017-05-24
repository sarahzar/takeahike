/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.Login;

import services.EvennementServices;
import services.GalerieServices;
import services.MaterielServices;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import entities.Evennement;
import entities.Galerie;
import entities.Materiel;
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
import javafx.fxml.Initializable;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Callback;
import org.controlsfx.control.GridCell;
import org.controlsfx.control.GridView;
import org.controlsfx.control.cell.ColorGridCell;


public class FXMLGRIDEVENTController implements Initializable {
 
 
    @FXML
    private MenuBar Menu;
    @FXML
    private Pane panepane;

    @FXML
    private ScrollPane sx;

    @FXML
    private AnchorPane anchor;
          
          

    @FXML
    private GridPane grid;

    
    @FXML
    private Label labell;
   
public void Event (){
GridPane gridee = new GridPane();
//                  
                    
                    
                    gridee.prefHeight(900);
                    gridee.prefWidth(600);
           
                    gridee.setHgap(30);
                    gridee.setVgap(10);
                    gridee.setStyle("-fx-background-color : #004e3e ;");
                    sx.fitToWidthProperty().set(true);
                    sx.setContent(gridee);
                    
                    EvennementServices ms = new EvennementServices();
                    List<Evennement> evtlist=new ArrayList<>();
                    evtlist=(ArrayList<Evennement>)ms.afficherEvennement();
                    int x = ms.afficherEvennement().size();
                    int i=0,j=0,nb=0;
                    
                    Menu btnAccueil = new Menu("Accueil");
                    Menu btnEvennement = new Menu("Evennement");
                    Menu btnMateriel = new Menu("Materiel");
                    Menu btnApropos = new Menu("A Propos");
                            
                       Menu.getMenus().addAll(btnAccueil,btnEvennement,btnMateriel,btnApropos);
                         
                       
   //remplir la liste des galeries de chaque evennement dans la liste                    
                       GalerieServices gservice=new GalerieServices();
                   List<Galerie> galeries=new ArrayList<>();
                  galeries=(ArrayList<Galerie>)gservice.afficherGalerie();
   
   
   EvennementServices evtservice=new  EvennementServices();
                   List<Evennement> listevt=new ArrayList<>();
                  listevt=(ArrayList<Evennement>)evtservice.afficherEvennement();
                  
                  List<ImageView> imglist=new ArrayList<>();
                  
      
                  
                   for(int z=0;z<evtlist.size();z++){
                       
                       for(int h=0;h<galeries.size();h++){
                  if(evtlist.get(z).getId()==galeries.get(h).getIdEvt().getId()) {
                   listevt.get(z).getGllist().add(galeries.get(h));
                   
                  }  
     
          System.out.println(listevt.get(z).getId());
       System.out.println(galeries.get(h).getIdEvt().getId());  
        }
                   }
           
            
     //parcour de la liste des evnnements et affichage des pannes               
                    
                   for(i=0;i<x;i=i+2)
                       
                    {
                        for(j=0;j<2;j++)

                            {
                                
                                if(nb+1<=x){
                               
                                Label lab = new Label(ms.afficherEvennement().get(nb).getNom());
                                lab.translateYProperty().set(25);
                                lab.translateXProperty().set(200);
                                lab.textFillProperty().set(Color.BLACK);
                                
                                Label lab2 = new Label(ms.afficherEvennement().get(nb).getIdEndroit().getNom());
                                lab2.translateYProperty().set(50);
                                lab2.translateXProperty().set(200);
                                lab2.textFillProperty().set(Color.BLACK);
                                
                                Label lab3 = new Label(String.valueOf(ms.afficherEvennement().get(nb).getDateDebut()));
                                lab3.translateYProperty().set(75);
                                lab3.translateXProperty().set(200);
                                lab3.textFillProperty().set(Color.BLACK);
                                
                                Label lab4 = new Label(String.valueOf(ms.afficherEvennement().get(nb).getDateFin()));
                                lab4.translateYProperty().set(100);
                                lab4.translateXProperty().set(200);
                                lab4.textFillProperty().set(Color.BLACK);
                                
                                    Button btn = new JFXButton();
                                    btn.setText("Voir Plus");
                                   // btn.eventDispatcherProperty();
                                    btn.translateYProperty().setValue(170);
                                    btn.translateXProperty().set(330);
                                    btn.setStyle("-fx-border-color: blue");
                                    
                                    
                                    EvennementServices es = new EvennementServices();
                                    
                                    JFXTextArea details=new JFXTextArea();
                                    details.setText(es.afficherEvennement().get(nb).getDescription());
                                    Pane paa= new Pane() ;
                                    paa.getChildren().addAll(details);
                                    
                                    btn.setOnAction((event) -> {
                                        
                                        
                                        
                                        if(btn.isHover()){
                                        
                                     sx.setVisible(false);
                                     panepane.setDisable(false);
                                 }
                                   
                                       Evennement e = new Evennement();
      
        
        
        
        
        

      panepane.getChildren().add(paa);
                                   
                                    });
//création d'une liste d'image                              

System.out.println(nb+listevt.get(nb).getGllist().get(0).getImage());
imglist.add(new ImageView(new Image(listevt.get(nb).getGllist().get(0).getImage())));
                               imglist.get(nb).translateXProperty().setValue(5);
                               imglist.get(nb).setFitWidth(170);
                               imglist.get(nb).setFitHeight(170); 

//création d'un pane et affectation des composants
                               Pane pane = new Pane();
                            
                                pane.getChildren().addAll(imglist.get(nb),lab,lab2,lab3,lab4,btn);
                                pane.setPrefSize(400,200);
                                pane.translateXProperty().set(25);
                                pane.translateYProperty().set(20);
                                pane.setStyle("-fx-background-color: white; -fx-border-color: black");
                                
                                
                                
                                gridee.add(pane, j, i);
                               
                                
                            }
                                nb++;
                            }
                        j=i+j;
                    }
        

}                  
  

    @Override
    public void initialize  (URL url, ResourceBundle rb) {
        Event ();
}
}

                
        
                    
  