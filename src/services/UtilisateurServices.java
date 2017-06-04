/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Models.UtilisateursDetails;
import dataConnexion.MyConnexion;
import entities.Session;
import entities.Utilisateur;
import interfaces.interfaceUtilisateur;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import static java.time.temporal.TemporalQueries.localDate;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author asus-pc
 */
public class UtilisateurServices implements interfaceUtilisateur {

    @Override
    public void ajouterUtilisateur(Utilisateur u) {

        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            java.util.Date date1 = new java.util.Date();
            System.out.println(dateFormat.format(date1));
            java.sql.Date sqlDate1 = new java.sql.Date(date1.getTime());
            PreparedStatement prep = MyConnexion.getInstance().getConexion().prepareStatement("insert into utilisateur values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
            prep.setString(1, u.getCin());
            prep.setInt(2, u.getType());
            prep.setString(3, u.getNom());
            prep.setString(4, u.getPrenom());
            LocalDate ld = u.getDateNaissance();
            Date date = java.sql.Date.valueOf(ld);
            prep.setDate(5, date );
            prep.setString(6, u.getAdresse());
            prep.setString(7, u.getTelephone());
            prep.setString(8, u.getMail());
            prep.setString(9, u.getPassword());
            prep.setString(10, u.getLogin());
            prep.setInt(11, u.getConfirmer());
            prep.setInt(12, u.getEtat());
            prep.setDate(13, (Date) sqlDate1);
            prep.setDate(14, null);
            prep.setInt(15, u.getSexe());
            prep.setString(16, u.getCodeConfirmation());
            prep.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurServices.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void supprimerUtilisateur(Utilisateur u) {

        try {
            PreparedStatement prep = MyConnexion.getInstance().getConexion().prepareStatement("delete from utilisateur where cin = ?;");
            prep.setString(1, u.getCin());
            prep.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurServices.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void modifierUtilisateur(Utilisateur u, String nom, String prenom, String adresse, String telephone,String mail) {

        try {
            PreparedStatement prep = MyConnexion.getInstance().getConexion().prepareStatement("UPDATE utilisateur SET nom=?, prenom=?, adresse=?, telephone=?, mail=? where cin = ?");
            prep.setString(1, nom);
            prep.setString(2, prenom);
            prep.setString(3, adresse);
            prep.setString(4, telephone);
            prep.setString(5, mail);
            prep.setString(6, u.getCin());
            prep.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurServices.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void modifierPasswordUtilisateur (Utilisateur u, String password){
        try {
            PreparedStatement prep = MyConnexion.getInstance().getConexion().prepareStatement("UPDATE utilisateur SET password=? where cin = ?");
            prep.setString(1, password);
            prep.setString(2, u.getCin());
            prep.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ObservableList<Utilisateur> afficherUtilisateur() {
        ArrayList<Utilisateur> utilisateurs = new ArrayList<>();
        try {

            Statement stm = MyConnexion.getInstance().getConexion().createStatement();
            ResultSet result = stm.executeQuery("select * from utilisateur");

            while (result.next()) {
                Utilisateur u = new Utilisateur();
                u.setCin(result.getString(1));
                u.setType(result.getInt(2));
                u.setNom(result.getString(3));
                u.setPrenom(result.getString(4));
                u.setDateNaissance(result.getDate(5).toLocalDate());
                u.setAdresse(result.getString(6));
                u.setTelephone(result.getString(7));
                u.setMail(result.getString(8));
                u.setPassword(result.getString(9));
                u.setLogin(result.getString(10));
                u.setConfirmer(result.getInt(11));
                u.setEtat(result.getInt(12));
                u.setDateInscrit(result.getDate(13));
                u.setDateDeactivation(result.getDate(14));
                u.setSexe(result.getInt(15));
                u.setCodeConfirmation(result.getString(16));
                
                utilisateurs.add(u);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        ObservableList<Utilisateur> observableUtilisateurs=FXCollections.observableArrayList(utilisateurs);
        return observableUtilisateurs;
    }

    @Override
    public ObservableList<UtilisateursDetails> listeUtilisateurs() {
        ObservableList<UtilisateursDetails> liste= FXCollections.observableArrayList();
        try {

            Statement stm = MyConnexion.getInstance().getConexion().createStatement();
            ResultSet result = stm.executeQuery("select * from utilisateur");

            while (result.next()) {
                String dateDesactivation="";
                String type="";
                String etat="";
                String compte="";
                String cin=result.getString(1);
                String login=result.getString(10);
                String nom=result.getString(3);
                String prenom=result.getString(4);
                String email=result.getString(8);
                String telephone=result.getString(7);
                int etatBase=result.getInt(11);
                if(etatBase==0) etat="Non Confirmé";
                else etat="Confirmé";
                int compteBase=result.getInt(12);
                if(compteBase==0) compte="Désactivé";
                else compte="Activé";
                int typeBase=result.getInt(2);
                if(typeBase==0) type="Administrateur";
                else type="Randonneur";
                
                
                UtilisateursDetails u=new UtilisateursDetails(cin, login, nom, prenom, email, telephone, etat, compte,type);
                System.out.println("UserDetails"+u);
                liste.add(u);
                
            }

        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return liste;
    }

    
    @Override
    public void confirmerUtilisateur(Utilisateur u) {
        try {
            PreparedStatement prep = MyConnexion.getInstance().getConexion().prepareStatement("UPDATE utilisateur SET confirme=1 where cin = ?");
            prep.setString(1, u.getCin());
            prep.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void desactiverCompteUtilisateur(Utilisateur u) {
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            java.util.Date date1 = new java.util.Date();
            System.out.println(dateFormat.format(date1));
            java.sql.Date sqlDate1 = new java.sql.Date(date1.getTime());
            PreparedStatement prep = MyConnexion.getInstance().getConexion().prepareStatement("UPDATE utilisateur SET etat=0, dateDesactivation=? where cin = ?");
            prep.setDate(1, (Date) sqlDate1);
            prep.setString(2, u.getCin());
            System.out.println("MethodeDesactiver:   "+u);
            prep.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

     @Override
    public void activerCompteUtilisateur(Utilisateur u) {
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            java.util.Date date1 = new java.util.Date();
            System.out.println(dateFormat.format(date1));
            java.sql.Date sqlDate1 = new java.sql.Date(date1.getTime());
            PreparedStatement prep = MyConnexion.getInstance().getConexion().prepareStatement("UPDATE utilisateur SET etat=1 where cin = ?");
           
            prep.setString(1, u.getCin());
            
            prep.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    @Override
    public Utilisateur chercherCinUtilisateur(String cin) {

        Utilisateur u = new Utilisateur();
        System.out.println("user Methode chercher"+u);
        System.out.println("getUserSession: ----"+Session.getUser());
        try {
            Statement stm = MyConnexion.getInstance().getConexion().createStatement();
            ResultSet result = stm.executeQuery("select * from utilisateur where cin = \"" + cin + "\"");

            while (result.next()) {
                System.out.println("Cin Result:    "+result.getString(1));
                u.setCin(result.getString(1));
                u.setType(result.getInt(2));
                u.setNom(result.getString(3));
                u.setPrenom(result.getString(4));
                u.setDateNaissance(result.getDate(5).toLocalDate());
                u.setAdresse(result.getString(6));
                u.setTelephone(result.getString(7));
                u.setMail(result.getString(8));
                u.setPassword(result.getString(9));
                u.setLogin(result.getString(10));
                u.setConfirmer(result.getInt(11));
                u.setEtat(result.getInt(12));
                u.setDateInscrit(result.getDate(13));
                u.setDateDeactivation(result.getDate(14));
                u.setSexe(result.getInt(15));
                u.setCodeConfirmation(result.getString(16));
                System.out.println("Apres recherche: -------"+u);

            }

        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u;
    }

    @Override
    public List<Utilisateur> chercherRandonneurs() {
        ArrayList<Utilisateur> randonneurs = new ArrayList<>();
        try {
            Statement stm = MyConnexion.getInstance().getConexion().createStatement();
            ResultSet result = stm.executeQuery("select * from utilisateur where type = 1");
            while (result.next()) {
                Utilisateur u = Session.getUser();

                u.setCin(result.getString(1));
                u.setType(result.getInt(2));
                u.setNom(result.getString(3));
                u.setPrenom(result.getString(4));
                u.setAdresse(result.getString(6));
                u.setDateNaissance(result.getDate(5).toLocalDate());
                u.setTelephone(result.getString(7));
                u.setMail(result.getString(8));
                u.setPassword(result.getString(9));
                u.setLogin(result.getString(10));
                u.setConfirmer(result.getInt(11));
                u.setEtat(result.getInt(12));
                u.setDateInscrit(result.getDate(13));
                u.setDateDeactivation(result.getDate(14));
                u.setSexe(result.getInt(15));
                u.setCodeConfirmation(result.getString(16));
                randonneurs.add(u);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return randonneurs;
    }

    @Override
    public Utilisateur chercherLoginUtilisateur(String login) {
         Utilisateur u = new Utilisateur();
        try {
            Statement stm = MyConnexion.getInstance().getConexion().createStatement();
            ResultSet result = stm.executeQuery("select * from utilisateur where login = \"" + login + "\"");

            while (result.next()) {

                u.setCin(result.getString(1));
                u.setType(result.getInt(2));
                u.setNom(result.getString(3));
                u.setPrenom(result.getString(4));
                u.setDateNaissance(result.getDate(5).toLocalDate());
                u.setAdresse(result.getString(6));
                u.setTelephone(result.getString(7));
                u.setMail(result.getString(8));
                u.setPassword(result.getString(9));
                u.setLogin(result.getString(10));
                u.setConfirmer(result.getInt(11));
                u.setEtat(result.getInt(12));
                u.setDateInscrit(result.getDate(13));
                u.setDateDeactivation(result.getDate(14));
                u.setSexe(result.getInt(15));
                u.setCodeConfirmation(result.getString(16));

            }

        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u;
    }
}
