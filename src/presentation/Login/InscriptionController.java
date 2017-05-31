/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.Login;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import entities.Session;
import entities.Utilisateur;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import static presentation.Login.InscriptionValidation.textFieldNotEmpty;
import services.UtilisateurServices;
import static presentation.Login.InscriptionValidation.confirmerPassword;
import static presentation.Login.InscriptionValidation.verifierEmail;
import static presentation.Login.InscriptionValidation.verifierEntiers;
import static presentation.Login.InscriptionValidation.verifierPassword;
import static presentation.Login.InscriptionValidation.verifierString;
import java.util.UUID;


/**
 * FXML Controller class
 *
 * @author asus-pc
 */
public class InscriptionController implements Initializable {

     @FXML  // <== perhaps you had this missing??
        void keyPressed(KeyEvent event) {
            
            }
    
    
    @FXML
    private JFXPasswordField passwordActuel;
    
      @FXML
    private JFXPasswordField newPasswordConfirm;
      
      @FXML
    private JFXPasswordField newPassword;
    
    @FXML
    private Label lblTitle; 
    
    @FXML
    private Label lblModifierPassword;
    
    @FXML
    private Pane panePassword;
    
    @FXML
    private JFXButton jfbtnInscription;

    @FXML
    private JFXButton jfbtnAnnuler;
    
    @FXML
    private JFXButton jfbtnModifier;
    @FXML
    private JFXTextField txtnomUtilisateur;

    @FXML
    private Label lblmessageErreur;
    
     @FXML
    private Label lblNom;
      @FXML
    private Label lblPrenom;
      @FXML
    private Label lblCin;
      
      @FXML
    private Label lblDateNaissance;

    @FXML
    private Label lblPassword;

    @FXML
    private Label lblEmail;
     @FXML
    private Label lblLogin;
      @FXML
    private Label lblGouvernerat;


    @FXML
    private Label lblPasswordConfirm;

    

    @FXML
    private Label lblTelephone;


    @FXML
    private JFXTextField txtcinUtilisateur;

    @FXML
    private JFXTextField txtemailUtilisateur;

    @FXML
    private JFXTextField txttelephoneUtilisateur;

    @FXML
    private JFXTextField txtprenomUtilisateur;
    
    @FXML
    private JFXTextField txtloginUtilisateur;

    @FXML
    private ImageView logo;

    @FXML
    private JFXPasswordField pswpasswordUtilisateur;
    
    @FXML
    private JFXComboBox<String> cmbsexeUtilisateur;

    @FXML
    private JFXPasswordField pswconfirmPasswordUtilisateur;
    
     @FXML
    private DatePicker dateNaissanceUtilisateur;

    @FXML
    void verifierNom(ActionEvent event) {
        String nom =txtnomUtilisateur.getText();
        lblmessageErreur.setText("Hello!");
        System.out.println(nom+" ok");
    }
    
    
    @FXML
    void ouvrirInscription (ActionEvent event) throws IOException{
        
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("Inscription_1.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 900, 600);
            Stage stage = new Stage();
            stage.setTitle("Inscription");
            stage.setScene(scene);
            stage.show();
            stage.setResizable(false);
                        
    }
    
    
     
    @FXML
    void inscrireUtilisateur(ActionEvent event) throws IOException {
        
         UtilisateurServices us =new UtilisateurServices();
        boolean verif=true;
        boolean nomValidation =textFieldNotEmpty(txtnomUtilisateur, lblNom, "Le nom est obligatoire!");
        boolean prenomValidation =textFieldNotEmpty(txtprenomUtilisateur, lblPrenom, "Le prénom est obligatoire!");
        boolean cinValidation =textFieldNotEmpty(txtcinUtilisateur, lblCin, "Le CIN est obligatoire!");
        boolean loginValidation =textFieldNotEmpty(txtloginUtilisateur, lblLogin, "Le login est obligatoire!");
        boolean passwordValidation =textFieldNotEmpty(pswpasswordUtilisateur, lblPassword, "Le mot de passe est obligatoire!");
        boolean telephoneValidation =textFieldNotEmpty(txttelephoneUtilisateur, lblTelephone, "Le numéro de téléphone est obligatoire!");
        boolean confirmPassword = confirmerPassword(pswpasswordUtilisateur, pswconfirmPasswordUtilisateur, lblPasswordConfirm,"Les mots de passe ne sont pas identiques!");
        boolean verifEmail = verifierEmail(txtemailUtilisateur, lblEmail, "L'email n'est pas valide!");
        if (nomValidation)
        {       boolean nomverif =verifierString(txtnomUtilisateur, lblNom, "Pas d'entiers!");
                verif=nomverif;                
        }
        if (prenomValidation)
        {       boolean prenomverif =verifierString(txtprenomUtilisateur, lblPrenom, "Pas d'entiers!");
                verif=prenomverif;                
        }
        if (telephoneValidation)
        {       boolean telephoneverif =verifierEntiers(txttelephoneUtilisateur, lblTelephone, "Invalide!");
                verif=telephoneverif;                
        }
        
        if (loginValidation)
        {
            if (us.chercherLoginUtilisateur(txtloginUtilisateur.getText()).getLogin()!=null)
                    
                {   
                    verif=false;
                    lblLogin.setText("Existe déjà!");
                }
        }
        if (passwordValidation)
        {       boolean passwordverif =verifierPassword(txtcinUtilisateur, lblCin, "Invalide!");
                verif=passwordverif;                
        }
        if (dateNaissanceUtilisateur.getValue()==null)
        {
            lblDateNaissance.setText("La date de naissance est obligatoire");
        }
        else
        {
            LocalDate now = LocalDate.now();
            Period p = Period.between(dateNaissanceUtilisateur.getValue(), now);
            
           
            
            if(p.getYears()<18)
                lblDateNaissance.setText("Age <18");
        }
        if (cinValidation)
        {       boolean cinverif =verifierEntiers(txtcinUtilisateur, lblCin, "Invalide!");
                verif=cinverif; 
                if (us.chercherCinUtilisateur(txtcinUtilisateur.getText()).getCin()!=null)
                    
                {   
                    verif=false;
                    lblCin.setText("Existe déjà!");
                }
        }
        
        
        if (nomValidation  && verif && verifEmail && confirmPassword && prenomValidation && cinValidation && loginValidation && passwordValidation  && telephoneValidation)
            
        {
        
        String nom = txtnomUtilisateur.getText();
        String prenom =txtprenomUtilisateur.getText();
        String cin =txtcinUtilisateur.getText();
        String email =txtemailUtilisateur.getText();
        String password = pswpasswordUtilisateur.getText();
        String login = txtloginUtilisateur.getText();
        String telephone = txttelephoneUtilisateur.getText();
        String adresse = "Tunis";
        LocalDate dateNaissance =  dateNaissanceUtilisateur.getValue();
        int sexe= cmbsexeUtilisateur.getSelectionModel().getSelectedIndex();
        
        String code=UUID.randomUUID().toString();
            System.out.println("Code: "+code);
        Utilisateur u =new Utilisateur(cin, 1, nom, prenom,dateNaissance, adresse, telephone, email, password, login, 0, 1,sexe,code);
       
       
        us.ajouterUtilisateur(u);
        System.out.println("yes!");
        lblmessageErreur.setText("Bienvenue!");
        ConfirmerInscriptionController ci=new ConfirmerInscriptionController();
        ci.setCinC(cin);
        
        
        Task sendingMessage = new Task<Void>() {
            @Override
            protected Void call() throws Exception {

                Mail mail = new Mail();

                /* Enter your gmail here and google how to enable less secure account in your gmail for successful execution of sending mails   
                 * replace it with the your_sender@email.com below and ayour password at your_password then recepient mail where you want your 
                 * mail to be sent , the subject of your mail and the message
                 */
                mail.sendMail("TakeAHikeTunisia@gmail.com", "SixiemeSens1CINFO2", u.getMail(), "Confirmation de l'inscription", "Bienvenue "+u.getPrenom()+" "+u.getNom()+", \nTake a Hike vous remercie pour votre confiance. Le code de confirmation de votre inscription est: "+code+" \nPartez en aventure!");

                return null;
            }
        };

        new Thread(sendingMessage).start();
        
        
        lblmessageErreur.setTextFill(Color.web("#5e2b0e"));
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("confirmerInscription.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage stage = new Stage();
        stage.setTitle("Confirmer votre inscription");
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
        ((Node)(event.getSource())).getScene().getWindow().hide();
        
        }
        else lblmessageErreur.setText("Merci de vérifier les champs");

    }
    
    @FXML
    void modifierUtilisateur(ActionEvent event) {
        UtilisateurServices us =new UtilisateurServices();
         boolean nomverif =verifierString(txtnomUtilisateur, lblNom, "Pas d'entiers!");
         boolean prenomverif =verifierString(txtprenomUtilisateur, lblPrenom, "Pas d'entiers!");
         boolean telephoneverif =verifierEntiers(txttelephoneUtilisateur, lblTelephone, "Invalide!");
         if (nomverif && prenomverif && telephoneverif)
         {
             us.modifierUtilisateur(Session.getUser(), txtnomUtilisateur.getText(), txtprenomUtilisateur.getText(), "Tunis", txttelephoneUtilisateur.getText(), txtemailUtilisateur.getText());
             System.out.println("Modification done");
         }
             

    }
    
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Utilisateur user= Session.getUser();
        cmbsexeUtilisateur.getItems().addAll("Homme","Femme");
             
            
         
             
    }    
    
}
