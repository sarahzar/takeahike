
package Services;

import Connection.myConnection;
import entities.Utilisateur;
import interfaces.interfaceUtilisateur;
import java.sql.Date;
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

public class UtilisateurServices implements interfaceUtilisateur {

    @Override
    public void ajouterUtilisateur(Utilisateur u) {
        
         try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            java.util.Date date1 = new java.util.Date();
            System.out.println(dateFormat.format(date1));
            java.sql.Date sqlDate1 = new java.sql.Date(date1.getTime());
            PreparedStatement prep = myConnection.getInstance().getConnect().prepareStatement("insert into utilisateur values (?,?,?,?,?,?,?,?,?,?,?,?,?);");
            prep.setString(1, u.getCin());
            prep.setInt(2, u.getType());
            prep.setString(3, u.getNom());
            prep.setString(4, u.getPrenom());
            prep.setString(5, u.getAdresse());
            prep.setString(6, u.getTelephone());
            prep.setString(7, u.getMail());
            prep.setString(8, u.getPassword());
            prep.setString(9, u.getLogin());
            prep.setInt(10, u.getConfirmer());
            prep.setInt(11, u.getEtat());
            prep.setDate(12, (Date) sqlDate1);
            prep.setDate(13, null);

            prep.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurServices.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void supprimerUtilisateur(Utilisateur u) {
            try {
            PreparedStatement prep = myConnection.getInstance().getConnect().prepareStatement("delete from utilisateur where cin = ?;");
            prep.setString(1, u.getCin());
            prep.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void modifierUtilisateur(Utilisateur u, String nom, String prenom, String adresse, String telephone) {
        try {
            PreparedStatement prep = myConnection.getInstance().getConnect().prepareStatement("UPDATE utilisateur SET nom=?, prenom=?, adresse=?, telephone=? where cin = ?");
            prep.setString(1, nom);
            prep.setString(2, prenom);
            prep.setString(3, adresse);
            prep.setString(4, telephone);
            prep.setString(5, u.getCin());
            prep.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }

    @Override
    public List<Utilisateur> afficherUtilisateur() {
         ArrayList<Utilisateur> utilisateurs = new ArrayList<>();
        try {

            Statement stm = myConnection.getInstance().getConnect().createStatement();
            ResultSet result = stm.executeQuery("select * from utilisateur");

            while (result.next()) {
                Utilisateur u = new Utilisateur();

                u.setCin(result.getString(1));
                u.setType(result.getInt(2));
                u.setNom(result.getString(3));
                u.setPrenom(result.getString(4));
                u.setAdresse(result.getString(5));
                u.setTelephone(result.getString(6));
                u.setMail(result.getString(7));
                u.setPassword(result.getString(8));
                u.setLogin(result.getString(9));
                u.setConfirmer(result.getInt(10));
                u.setEtat(result.getInt(11));
                u.setDateInscrit(result.getDate(12));
                u.setDateDeactivation(result.getDate(13));
                utilisateurs.add(u);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return utilisateurs;

    }

    @Override
    public void confirmerUtilisateur(Utilisateur u) {
        
        try {
            PreparedStatement prep = myConnection.getInstance().getConnect().prepareStatement("UPDATE utilisateur SET confirme=1 where cin = ?");
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
            PreparedStatement prep = myConnection.getInstance().getConnect().prepareStatement("UPDATE utilisateur SET etat=0, dateDesactivation=? where cin = ?");
            prep.setDate(1, (Date) sqlDate1);
            prep.setString(2, u.getCin());
            prep.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurServices.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public Utilisateur chercherCinUtilisateur(String cin) {
        
        Utilisateur u = new Utilisateur();
        try {
            Statement stm = myConnection.getInstance().getConnect().createStatement();
            ResultSet result = stm.executeQuery("select * from utilisateur where cin = \"" + cin + "\"");

            while (result.next()) {

                u.setCin(result.getString(1));
                u.setType(result.getInt(2));
                u.setNom(result.getString(3));
                u.setPrenom(result.getString(4));
                u.setAdresse(result.getString(5));
                u.setTelephone(result.getString(6));
                u.setMail(result.getString(7));
                u.setPassword(result.getString(8));
                u.setLogin(result.getString(9));
                u.setConfirmer(result.getInt(10));
                u.setEtat(result.getInt(11));
                u.setDateInscrit(result.getDate(12));
                u.setDateDeactivation(result.getDate(13));

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
            Statement stm = myConnection.getInstance().getConnect().createStatement();
            ResultSet result = stm.executeQuery("select * from utilisateur where type = 1");
            while (result.next()) {
                Utilisateur u = new Utilisateur();

                u.setCin(result.getString(1));
                u.setType(result.getInt(2));
                u.setNom(result.getString(3));
                u.setPrenom(result.getString(4));
                u.setAdresse(result.getString(5));
                u.setTelephone(result.getString(6));
                u.setMail(result.getString(7));
                u.setPassword(result.getString(8));
                u.setLogin(result.getString(9));
                u.setConfirmer(result.getInt(10));
                u.setEtat(result.getInt(11));
                u.setDateInscrit(result.getDate(12));
                u.setDateDeactivation(result.getDate(13));
                randonneurs.add(u);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return randonneurs;

    }

    
    
    
}
