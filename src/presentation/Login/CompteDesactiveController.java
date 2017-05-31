/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.Login;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import static com.sun.javafx.animation.TickCalculation.sub;
import entities.Utilisateur;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.concurrent.Task;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javax.mail.*;
import entities.Session;

/**
 * FXML Controller class
 *
 * @author asus-pc
 */
public class CompteDesactiveController implements Initializable {

    Utilisateur user =Session.getUser();
     @FXML
    private JFXButton envoiMail;

    @FXML
    private JFXPasswordField  passwordMail;
    

    @FXML
    void envoyerMail(ActionEvent event) {
        
        Task sendingMessage = new Task<Void>() {
            @Override
            protected Void call() throws Exception {

                Mail mail = new Mail();

                /* Enter your gmail here and google how to enable less secure account in your gmail for successful execution of sending mails   
                 * replace it with the your_sender@email.com below and ayour password at your_password then recepient mail where you want your 
                 * mail to be sent , the subject of your mail and the message
                 */
                mail.sendMail(user.getMail(), passwordMail.getText(), "oumaima.balti@esprit.tn", "Demande d'activation du compte", "Le membre dont l'id= "+user.getCin()+" demande l'activation de son compte.");

                return null;
            }
        };

        new Thread(sendingMessage).start();
        
    }
//        Properties props =new Properties();
//        props.put("mail.smtp.host", "smtp.gmail.com");
//        props.put("mail.smtp.socketFactory.port", "465");
//        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.port", "465");
//        
//        Session session= Session.getDefaultInstance(props, 
//                new javax.mail.Authenticator() {
//                    protected PasswordAuthentication getpPasswordAuthentication(){
//                        return new PasswordAuthentication(user.getMail(),"0251019940");
//                    }
//                }
//                
//                );
//        try {}catch(Exception e){
//            JOption
//        }
//        
//    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
