/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package takeahike;

import entities.Evennement;
import entities.Galerie;
import entities.Utilisateur;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import presentation.Login.Gallerie2Controller;
import services.EvennementServices;
import services.GalerieServices;
import services.UtilisateurServices;

/**
 *
 * @author asus-pc
 */
public class TakeaHike {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Utilisateur u = new Utilisateur("968574", 0, "balti", "oumaima",null, "Tunis", "71457548", "balti@gmail.com", "password", "login1", 0, 1,1);
//        Utilisateur u2 = new Utilisateur("9868574", 0, "balti1", "oumaima1",null, "Tunis1", "71457848", "balti@gmail.com", "password", "login1", 0, 1,0);
//        Utilisateur u4 = new Utilisateur("11112", 1, "user2", "user2",null, "Tunis1", "78459", "balti@gmail.com", "password", "login2", 0, 1,1);
//        UtilisateurServices us = new UtilisateurServices();
//       // us.ajouterUtilisateur(u4);
//        //us.supprimerUtilisateur(u2);
//        System.out.println(us.afficherUtilisateur());
//        //us.modifierUtilisateur(u, "user1", "user1", "Marsa", "71458963");
//        System.out.println(us.afficherUtilisateur());
//        us.confirmerUtilisateur(u);
//        System.out.println(us.afficherUtilisateur());
//        us.desactiverCompteUtilisateur(u);
//        System.out.println(us.afficherUtilisateur());
//        System.out.println("Résultat de la recherche: " + us.chercherCinUtilisateur("11111"));
//        System.out.println("Liste des randonneurs:" + us.chercherRandonneurs());
//        System.out.println(us.chercherLoginUtilisateur("oumaima"));
        
       //Utilisateur user = new Utilisateur("12345678", 1, null, null, LocalDate.MIN, null, null, null, null, null, 1, 1, 1, null);
        //Galerie gg = new Galerie(5, "kkkk", user);
        
//        Utilisateur user = new Utilisateur();
//        user.setCin("12345602");
//        
//        Galerie g=new Galerie();
//        g.setIdUser(user.getCin());
//        g.setIdEvt(5);
//        GalerieServices gs = new GalerieServices();
//        
                //gs.ajouterGalerie(g.getIdEvt(),"test",g.getIdUser().getCin());
                
                 EvennementServices es = new EvennementServices();
        List<Evennement> evtlist = new ArrayList<>();
        evtlist = (ArrayList<Evennement>) es.afficherEvennementorganise();
        
                
                  List<String> listimage = new ArrayList<>();  
                  Evennement e=es.ChercherEventById(6);
                  Galerie g=new Galerie();
                   Galerie g2=new Galerie();
                  g.setIdEvt(e.getId());
                   g2.setIdEvt(e.getId());
                  
                  g.setImage("img/kesra.jpg");
                  g2.setImage("img/dogga.jpg");
                  e.getGllist().add(g);
                  e.getGllist().add(g2);
                  
                 int size=e.getGllist().size();
                 for(int s=0;s<size;s++){
                 listimage.add(e.getGllist().get(s).getImage());
                  
                 }
                 for(int s=0;s<size;s++){
                System.out.println(listimage.get(s));
                  
                 }
        System.out.println("hello");
    }

}
