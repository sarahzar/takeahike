package presentation.Login;







import com.jfoenix.controls.JFXButton;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import entities.Article;
import entities.Utilisateur;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import services.ArticleServices;
import services.UtilisateurServices;


/**
 *
 * @author achre
 */
public class FXMLAjoutArticleController implements Initializable {
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    
    
     
    @FXML
    private JFXTextField titre;

    @FXML
    private JFXTextArea description;

    @FXML
    private JFXButton AjoutArticle;

    @FXML
    void AjoutArticle(ActionEvent event) {
        Utilisateur u=Utilisateur.getInstance();
  //Utilisateur u = new Utilisateur("98688574", 0, "balti1", "oumaima1", "Tunis1", "71457848", "balti@gmail.com", "password", "login1", 0, 1);      UtilisateurServices us = new UtilisateurServices();
      //us.ajouterUtilisateur(u);
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            java.util.Date date1 = new java.util.Date();
            java.sql.Date sqlDate1 = new java.sql.Date(date1.getTime());
        
        
        Article e = new Article(0,titre.getText(),description.getText(),sqlDate1,u,"c:/hello");
        ArticleServices as= new ArticleServices();
        as.ajouterArticle(e);
        
        

}

    

    
}
