/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataConnexion.MyConnexion;
import entities.Evennement;
import entities.Galerie;
import entities.Utilisateur;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Atef
 */
public class GalerieServices implements interfaces.interfaceGalerie{

    @Override
    public void ajouterGalerie(Galerie g) {
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            java.util.Date date1 = new java.util.Date();
            System.out.println(dateFormat.format(date1));
            java.sql.Date sqlDate1 = new java.sql.Date(date1.getTime());
            PreparedStatement prep = MyConnexion.getInstance().getConexion().prepareStatement("insert into galerie values (?,?,?,?,?,?);");
            prep.setInt(1, g.getIdGallerie());
             prep.setString(2,g.getImage());
            prep.setInt(3,g.getIdEvt().getId() );
           
            prep.setString(4, g.getIdUser().getCin());
         //prep.setString(5,g.get );
//            prep.setString(6, );
            prep.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GalerieServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void supprimerGalerie(Galerie g) {
        try {
            PreparedStatement prep = MyConnexion.getInstance().getConexion().prepareStatement("delete from galerie where id = ?;");
            prep.setInt(1, g.getIdGallerie());
            prep.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GalerieServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void modifierGalerie(Galerie g) {
        //PreparedStatement prep = MyConnexion.getInstance().getConexion().prepareStatement("UPDATE galerie SET titre=?, description=? where id = ?");
        
    }

//    @Override
//    public List<Galerie> afficherGalerie() {
//        ArrayList<Galerie> Galeries = new ArrayList<>();
//       
//        try {
//            
//            Statement stm = MyConnexion.getInstance().getConexion().createStatement();
//            ResultSet result = stm.executeQuery("select * from galerie");
//
//            while (result.next()) {
//                Galerie g = new Galerie();
//                UtilisateurServices us = new UtilisateurServices();
//                EvennementServices es = new EvennementServices();
//                g.setIdGallerie(result.getInt(1));
//                g.setIdEvt(es.ChercherEventById(result.getInt(3)));
//                g.setIdUser(us.chercherCinUtilisateur(result.getString(4)) );
//                g.setImage(result.getString(5));
//                Galeries.add(g);
//            }
//            
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(GalerieServices.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    return Galeries ;}
//    
//}
    
@Override
    public List<Galerie> afficherGalerie() {
     ArrayList<Galerie> galeries=new ArrayList<>();
        try {
            Statement rm=MyConnexion.getInstance().getConexion().createStatement();
            ResultSet result=rm.executeQuery("select * from galerie");
            while(result.next()){
            
            Galerie g=new Galerie();
           
            Utilisateur user=Utilisateur.getInstance();
            Evennement ev=new Evennement();
        
            g.setImage(result.getString(2));
            ev.setId(result.getInt(3));



            user.setCin(result.getString(4));
              
              
              
               g.setIdEvt(ev);
               g.setIdUser(user);
            galeries.add(g);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(GalerieServices.class.getName()).log(Level.SEVERE, null, ex);
        }
      
         
     return galeries;
    }
}
    