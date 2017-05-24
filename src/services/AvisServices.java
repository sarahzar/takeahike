/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataConnexion.MyConnexion;
import entities.Article;
import entities.Avis;
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
public class AvisServices implements interfaces.interfaceAvis {
    public static AvisServices instance;
    private Statement st;
    private ResultSet rs;
    //private ObservableList observableList;


 
 public static AvisServices getInstance(){
        if(instance==null) 
            instance=new AvisServices();
        return instance;
    }

    @Override
    public void ajouterAvis(Avis a) {
        String req="insert into avis (commentaire,idArticle,idUser) values ('"+a.getCommentaire()+"',"+a.getIdArticle()+",'"+a.getIdUtilisateur()+"')";
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(AvisServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void supprimerAvis(Avis a) {
        String req="delete from avis where id="+a.getIdAvis();
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(AvisServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void supprimerAvis(int index) {
        String req="delete from avis where id="+index;
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(AvisServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void modifierAvis(Avis a) {
        String req="update avis set commentaire='"+a.getCommentaire()+"' where id="+a.getIdAvis();
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(AvisServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ObservableList<Avis> afficherAvis() {
        String req="select * from avis";
            List l = new ArrayList<>();
        try {
            rs=st.executeQuery(req);
            while (rs.next()) {
                Avis a= new Avis();
                Utilisateur us=Utilisateur.getInstance();
                Article ar=new Article();
                a.setIdAvis(rs.getInt(1));
                a.setCommentaire(rs.getString(2));
                a.setDatePublicationAvis(rs.getTimestamp(3));
                ar.setIdArticle(rs.getInt(4));
                us.setCin(rs.getString(5));
                l.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AvisServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        ObservableList<Avis> observableList = FXCollections.observableArrayList(l);
        return observableList;
    }
    
    public ObservableList<String> AfficherCommentaires(){
        String req="select * from avis";
            List l = new ArrayList<>();
        try {
            rs=st.executeQuery(req);
            while (rs.next()) {
                Avis a= new Avis();
                Utilisateur us=Utilisateur.getInstance();
                a.setIdAvis(rs.getInt(1));
                a.setCommentaire(rs.getString(2));
                a.setDatePublicationAvis(rs.getTimestamp(3));
                us.setCin(rs.getString(5));
                l.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AvisServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        ObservableList<String> observableList = FXCollections.observableArrayList(l);
        return observableList;
    }
    
}
