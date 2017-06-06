/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.Login;




import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import entities.Endroit;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import static presentation.Login.VerifEvent.textAreaNotEmpty;
import static presentation.Login.VerifEvent.textFieldNotEmpty;
import static presentation.Login.VerifEvent.verifierString;
import services.EndroitServices;


/**
 *
 * @author achre
 */
public class EndroitController implements Initializable {
    
    
    @FXML
    private JFXTextArea Descriptio;
    @FXML
        private JFXTextField nomEndroit;

    @FXML
    private JFXButton ajouterEndroit;
  
   @FXML
    private Label labdescription;

    @FXML
    private Label labURL;
    @FXML
    private Label labnom;

    @FXML
    private JFXTextField url;
    
    @FXML
    private Label laberreur;

    @FXML
    void ajouterEndroit(ActionEvent event) {
    EndroitServices es = new EndroitServices();
    Endroit a = new Endroit();
    
    boolean verif = true;
    boolean verifnomevent=textFieldNotEmpty(nomEndroit,labnom,"le nom est obligatoire");
    boolean verifurl = textFieldNotEmpty(url, labURL, "le URL est obligatoire");
    boolean verifdesciption= textAreaNotEmpty(Descriptio, labdescription,"la desciption est obligatoire");
    if (verifnomevent)
        {
            boolean verifnomverif =verifierString(nomEndroit, labnom, "Pas d'entiers!");
                verif=verifnomverif;
        }
    if(verif && verifnomevent){
        
    
    String nom=nomEndroit.getText();
    String description= Descriptio.getText();
    String path=url.getText();
    a.setDescription(description);
    a.setNom(nom);
    a.setImage(path);
    es.ajouterEndroit(a);
    
     laberreur.setText("Ajout effectué avec succes");
    }
else laberreur.setText("Verifier les champs");
}
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
   
    }    
    
}
