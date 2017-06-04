/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.Login;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import entities.Session;
import entities.Utilisateur;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author asus-pc
 */
public class AccueilAdminController implements Initializable {

   @FXML
    private AnchorPane anchorpane2;
      
       

    @FXML
    private JFXDrawer drawer;

    @FXML
    private JFXHamburger hamburger;
    
     Utilisateur user =Session.getUser();
    
     @FXML
    private Label userLabel;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        userLabel.setText(Session.getUser().getNom()+" "+Session.getUser().getPrenom());
       
           
       try {
           VBox box = FXMLLoader.load(getClass().getResource("menuAdministrateur.fxml"));          
           drawer.setSidePane(box);
           AnchorPane content = FXMLLoader.load(getClass().getResource("Utilisateurs.fxml"));
            JFXButton b=(JFXButton)box.getChildren().get(1);
            AnchorPane content2 = FXMLLoader.load(getClass().getResource("statistiquesAge.fxml"));
            JFXButton c=(JFXButton)box.getChildren().get(2);
//           AnchorPane content3 = FXMLLoader.load(getClass().getResource("FXMLAjoutArticle.fxml"));
//           AnchorPane content4 = FXMLLoader.load(getClass().getResource("Profil.fxml"));
//           
//           System.out.println(b.getText());
//           
           b.addEventHandler(MouseEvent.MOUSE_CLICKED, (a)-> {
               
               anchorpane2.getChildren().setAll(content);
               
           });
//           
           c.addEventHandler(MouseEvent.MOUSE_CLICKED, (a)-> {
               
               anchorpane2.getChildren().setAll(content2);
               
           });
//           
//           e.addEventHandler(MouseEvent.MOUSE_CLICKED, (a)-> {
//               
//               anchorpane2.getChildren().setAll(content3);
//               
//           });
//           
//           f.addEventHandler(MouseEvent.MOUSE_CLICKED, (a)-> {
//               
//               anchorpane2.getChildren().setAll(content4);
//               
//           });
           /*       for (Node node : box.getChildren()) {
           if (node.getAccessibleText()!= null)
           {
           node.addEventHandler(MouseEvent.MOUSE_CLICKED, (e)-> {
           switch (node.getAccessibleText())
           {
           case "Material_One":  anchorpane2.getChildren().setAll(content);
           break;
           case "Material_Two":  anchorpane2.getChildren().setAll(content2);
           break;
           case "Material_Three":  anchorpane2.getChildren().setAll(content3);
           break;
           case "Material_Four":  anchorpane2.getChildren().setAll(content4);
           break;
           
           }
           });
           }
           
           }
           */
           drawer.open();
           HamburgerBackArrowBasicTransition transition = new HamburgerBackArrowBasicTransition(hamburger);
           
           transition.setRate(-1);
           hamburger.addEventHandler(MouseEvent.MOUSE_PRESSED,(k)->{
               transition.setRate(transition.getRate()*-1);
               transition.play();
               if(drawer.isShown())
               {
                   drawer.close();
               }else
                   drawer.open();
               
           });
       } catch (IOException ex) {
           Logger.getLogger(AccueilAdminController.class.getName()).log(Level.SEVERE, null, ex);
       }
   
       
    }    
    
}
