/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.Login;

import services.MaterielServices;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;


public class FXMLtestFridController implements Initializable {
 
 

    @FXML
    private ScrollPane sx;

     @FXML
    private AnchorPane pnn;
          
          
     @FXML
    private MenuBar menubar;
    
  @FXML
    private Menu btacc;

    @FXML
    private Menu btmat;
    
    public void grid()
    {
                    menubar.getMenus().clear();
                    GridPane gridee = new GridPane();
                    Pane panepane = new Pane();
                    panepane.translateYProperty().set(150);
                    gridee.prefHeight(900);
                    gridee.prefWidth(600);
                    gridee.setHgap(30);
                    gridee.setVgap(10);
                    gridee.setStyle("-fx-background-color: #004e3e;");
                    sx.setContent(gridee);
                    
                    MaterielServices ms = new MaterielServices();
                    
                    int x = ms.afficherMateriel().size();
                    int i=0,j=0,nb=0;
                    
                    Menu btacc= new Menu("Acceuil");
                    Menu btaff = new Menu("Afficher");
                    Menu btmat = new Menu("Materiels");
                    Menu btevent = new Menu("Evennements");
                    Menu btapro = new Menu("A propos");
                    
                    btaff.setOnAction((event)->
                    {
                    sx.setVisible(true);
                    panepane.setVisible(false);
                    grid();
                    });  
                     
                    menubar.getMenus().addAll(btacc,btevent,btmat,btapro);
                    btacc.getItems().add(btaff);
                    for(i=0;i<x;i=i+2)     
                    {
                        for(j=0;j<2;j++)
                            {
                                if(nb+1<=x)
                                {
                                Label lab = new Label(ms.afficherMateriel().get(nb).getNomMateriel());
                                lab.translateYProperty().set(20);
                                lab.translateXProperty().set(200);
                                lab.textFillProperty().set(Color.SLATEGREY);
                                
                                Label lab2 = new Label(ms.afficherMateriel().get(nb).getDescription());
                                lab2.translateYProperty().set(70);
                                lab2.translateXProperty().set(200);
                                lab2.textFillProperty().set(Color.TOMATO);
                                
                                Label lab3 = new Label(ms.afficherMateriel().get(nb).getUser().getPrenom());
                                lab3.translateYProperty().set(120);
                                lab3.translateXProperty().set(200);
                                lab3.textFillProperty().set(Color.LIME);

                                Button btnplus = new JFXButton();
                                btnplus.setText("Voir Plus");
                                btnplus.translateYProperty().set(170);
                                btnplus.translateXProperty().set(320);
                                
                                Pane pane = new Pane();
                                
                                pane.getChildren().addAll(lab,lab2,lab3,btnplus);
                                pane.setPrefSize(400,200);
                                pane.translateXProperty().set(25);
                                pane.translateYProperty().set(5);
                                pane.setStyle("-fx-background-color:white; -fx-border-color: #CADAE3");
                                
                                JFXTextArea detmat=new JFXTextArea();   
                                detmat.setText((ms.afficherMateriel().get(nb).getDescription()));
                                detmat.setEditable(false);
                                
                                Pane paa= new Pane() ;
                                 
                                 
                                paa.getChildren().addAll(detmat);
                                 
                                gridee.add(pane, j, i);
                                panepane.setDisable(true);
                                btnplus.setOnAction((event)->{
                                
                                sx.setVisible(false);
                                panepane.setDisable(false);
                                panepane.getChildren().addAll(paa);
                                pnn.getChildren().addAll(panepane);
                                
                                });
                                
                            }
                                nb++;
                            }
                        j=i+j;
                    }
    }

    @Override
    public void initialize  (URL url, ResourceBundle rb) {
                    
                   grid();
        }
}
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    

//                        Stage primaryStage = null;
//
//
//
//                                    Button button1 = new Button("Button 1");
//                                    Button button2 = new Button("Button 2");
//                                    Button button3 = new Button("Button 3");
//                                    Button button4 = new Button("Button 4");
//                                    Button button5 = new Button("Button 5");
//                                    Button button6 = new Button("Button 6");
//
//                                    GridPane gridPane = new GridPane();
//
//                                    gridPane.add(button1, 0, 0, 1, 1);
//                                    gridPane.add(button2, 1, 0, 1, 1);
//                                    gridPane.add(button3, 2, 0, 1, 1);
//                                    gridPane.add(button4, 0, 1, 1, 1);
//                                    gridPane.add(button5, 1, 1, 1, 1);
//                                    gridPane.add(button6, 2, 1, 1, 1);







//                        
//                        GridLayout ex = new GridLayout(0, 2);
//                        ex.addLayoutComponent(name, comp);
//         
//                    scroll.autosize();
//                    scroll.setVisible(true);
//                    scroll.isPannable();

        
//        GridView gridmate= new GridView();
//            
//        
//       
//        Pane panex = new Pane();
//      
//        panex.backgroundProperty().set(new Background(new BackgroundFill(Color.PINK, CornerRadii.EMPTY, Insets.EMPTY)));
//        
//        
//        gridmate.setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));
//        
    
        
        
       
        
                

        
    

