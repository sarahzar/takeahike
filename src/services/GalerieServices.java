/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataConnexion.MyConnexion;
import entities.Galerie;
import entities.Utilisateur;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Atef
 */
public class GalerieServices implements interfaces.interfaceGalerie{

    public static GalerieServices instance;
    private Statement st;
    private ResultSet rs;


 public GalerieServices() {
        MyConnexion cs=MyConnexion.getInstance();
        try {
            st=cs.getConexion().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(GalerieServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    @Override
    public void ajouterGalerie(Galerie g) {
        String req="INSERT INTO `galerie`(`image`, `idEvennement`, `idUser`) values ('"+g.getImage()+"',"+g.getIdEvt()+",'"+g.getIdUser()+"')";
        System.out.println(req);
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(GalerieServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void supprimerGalerie(Galerie g) {
        String req="delete from galerie where id="+g.getIdGallerie();
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(GalerieServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void modifierGalerie(Galerie g) {
        String req="update galerie set image='"+g.getImage()+"' where id="+g.getIdGallerie();
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(GalerieServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ObservableList<Galerie> afficherGalerie(int id) {
        
        
        UtilisateurServices us = new UtilisateurServices();
        String req="select * from galerie where idEvennement="+id;
            List l = new ArrayList<>();
        try {
            rs=st.executeQuery(req);
            while (rs.next()) {
                Galerie g= new Galerie();
                g.setIdGallerie(rs.getInt(1));
                g.setImage(rs.getString(2));
                g.setIdEvt(rs.getInt(3));
                g.setIdUser(rs.getString(4));
                l.add(g);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GalerieServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        ObservableList<Galerie> observableList = FXCollections.observableArrayList(l);
        return observableList;
    }

    @Override
    public List<Galerie> afficherGalerie() {
        ArrayList<Galerie> galeries=new ArrayList<>();
        try {
            Statement rm=MyConnexion.getInstance().getConexion().createStatement();
            ResultSet result=rm.executeQuery("select * from galerie");
            while(result.next()){
            
            Galerie g=new Galerie();
           
            Utilisateur user=new Utilisateur();
           // Evennement ev=new Evennement();
        
            g.setImage(result.getString(2));
           g.setIdEvt(result.getInt(3));



            user.setCin(result.getString(4));
              
              
              
               //g.setIdEvt(idevent);
               //g.setIdUser(user);
            galeries.add(g);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(GalerieServices.class.getName()).log(Level.SEVERE, null, ex);
        }
      
         
     return galeries;
    }
    
}
