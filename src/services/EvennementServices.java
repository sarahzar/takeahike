package services;

import dataConnexion.MyConnexion;
import entities.Evennement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EvennementServices implements interfaces.interfaceEvennement {
        Connection connect = MyConnexion.getInstance().getConexion();
        
    @Override
    public void ajouterEvennement(Evennement e) {
        
            try {
            PreparedStatement insert = connect.prepareStatement("INSERT INTO evennement  VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?);");
            insert.setInt(1, e.getId());
            insert.setString(2, e.getNom());
            insert.setInt(3, e.getIdEndroit().getId());
            LocalDate ld = e.getDateDebut();
            Date date = java.sql.Date.valueOf(ld);
            insert.setDate(4, date);

            LocalDate ldd = e.getDateFin();
            Date datee = java.sql.Date.valueOf(ldd);
            insert.setDate(5, datee);

            insert.setInt(6, e.getDifficulte());
            insert.setInt(7, e.getNbrPlaces());
            insert.setString(8, e.getIdResponsable().getCin());
            insert.setString(9, e.getDescription());
            insert.setDouble(10, e.getLattitudePOintArrivee());
            insert.setDouble(11, e.getLattitudePOintDepart());
            insert.setDouble(12, e.getLongitudePOintArrivee());
            insert.setDouble(13, e.getLongitudePOintDepart());

            insert.executeUpdate();
            System.out.println("Insertion Done !");
        } catch (SQLException ex) {
            Logger.getLogger(EvennementServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void supprimerEvennement(Evennement e) {
        
            try {
                PreparedStatement delete = connect.prepareStatement("DELETE FROM evennement WHERE id=?;");
                delete.setInt(1, e.getId());
                delete.executeUpdate();
                System.out.println("Delete is Done !");
            } catch (SQLException ex) {
                Logger.getLogger(EvennementServices.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @Override
    public void modifierEvennement(Evennement e) {
            try {
                PreparedStatement update = connect.prepareStatement("UPDATE evennement SET nom=?,idEndroit=?,dateDebut=?,dateFin=?,difficulte=?,nbrPlaces=?,idResponsable=?,description=?,longititudepointDepart=?,lattitudepointDepart=?,longitudePointArrivee=?,lattitudePointArrivee=?  WHERE id=?;");
                
                update.setString(1, e.getNom());
                update.setInt(2, e.getIdEndroit().getId());
                
                LocalDate ld = e.getDateDebut();
                Date date = java.sql.Date.valueOf(ld);
                update.setDate(3, date );
                
                LocalDate ldd = e.getDateFin();
                Date datee = java.sql.Date.valueOf(ldd);
                update.setDate(4, datee );
//        update.setDate(3, (Date) e.getDateDebut().);
   //             update.setDate(4, (Date) e.getDateFin());
                update.setInt(5, e.getDifficulte());
                update.setInt(6, e.getNbrPlaces());
                update.setString(7, e.getIdResponsable().getCin());
                update.setString(8, e.getDescription());
                update.setDouble(9, e.getLongitudePOintDepart());
                update.setDouble(10, e.getLattitudePOintDepart());
                update.setDouble(11, e.getLongitudePOintArrivee());
                update.setDouble(12, e.getLattitudePOintArrivee());
                update.setInt(13, e.getId());
                update.executeUpdate();
            System.out.println("great");
                
            } catch (SQLException ex) {
                Logger.getLogger(EvennementServices.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        
    }

     @Override
    public ArrayList<Evennement> afficherEvennementAvenir() {

        ArrayList<Evennement> evennements = new ArrayList<>();

        try {

            Statement stm = MyConnexion.getInstance().getConexion().createStatement();
            UtilisateurServices us = new UtilisateurServices();
            EndroitServices es = new EndroitServices();
            ResultSet result = stm.executeQuery("SELECT * FROM `evennement` WHERE `dateDebut` > SYSDATE() ");
            while (result.next()) {
                Evennement evt = new Evennement();
                evt.setId(result.getInt(1));
                evt.setNom(result.getString(2));
                evt.setIdEndroit(es.rechercheById(result.getInt(3)));

                evt.setDateDebut(result.getDate(4).toLocalDate());
                evt.setDateFin(result.getDate(5).toLocalDate());
                evt.setDifficulte(result.getInt(6));
                evt.setNbrPlaces(result.getInt(7));
                evt.setIdResponsable(us.chercherCinUtilisateur(result.getString(8)));
                evt.setDescription(result.getString(9));
                evt.setLongitudePOintDepart(result.getDouble(10));
                evt.setLattitudePOintDepart(result.getDouble(11));
                evt.setLongitudePOintArrivee(result.getDouble(12));
                evt.setLattitudePOintArrivee(result.getDouble(13));

                evennements.add(evt);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EvennementServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return evennements;
    }

    @Override
    public ArrayList<Evennement> afficherEvennementorganise() {

        ArrayList<Evennement> evennements = new ArrayList<>();

        try {

            Statement stm = MyConnexion.getInstance().getConexion().createStatement();
            UtilisateurServices us = new UtilisateurServices();
            EndroitServices es = new EndroitServices();
            ResultSet result = stm.executeQuery("SELECT * FROM `evennement` WHERE `dateDebut` < SYSDATE() ");
            while (result.next()) {
                Evennement evt = new Evennement();
                evt.setId(result.getInt(1));
                evt.setNom(result.getString(2));
                evt.setIdEndroit(es.rechercheById(result.getInt(3)));

                evt.setDateDebut(result.getDate(4).toLocalDate());
                evt.setDateFin(result.getDate(5).toLocalDate());
                evt.setDifficulte(result.getInt(6));
                evt.setNbrPlaces(result.getInt(7));
                evt.setIdResponsable(us.chercherCinUtilisateur(result.getString(8)));
                evt.setDescription(result.getString(9));
                evt.setLongitudePOintDepart(result.getDouble(10));
                evt.setLattitudePOintDepart(result.getDouble(11));
                evt.setLongitudePOintArrivee(result.getDouble(12));
                evt.setLattitudePOintArrivee(result.getDouble(13));

                evennements.add(evt);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EvennementServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return evennements;
    }

    @Override
    public Evennement ChercherEventById(int id) {

        Evennement e = new Evennement();
        UtilisateurServices us = new UtilisateurServices();
        EndroitServices endroit = new EndroitServices();
        try {

            Statement stm = MyConnexion.getInstance().getConexion().createStatement();
            ResultSet result = stm.executeQuery("select * from evennement where id = \"" + id + "\"");

            while (result.next()) {

                e.setId(result.getInt(1));
                e.setNom(result.getString(2));
                e.setDateDebut(result.getDate(3).toLocalDate());
                e.setDateFin(result.getDate(4).toLocalDate());
                e.setDifficulte(result.getInt(5));
                e.setNbrPlaces(result.getInt(6));
                e.setIdResponsable(us.chercherCinUtilisateur(result.getString(7)));
                e.setIdEndroit(endroit.rechercheById(result.getInt(8)));
                e.setDescription(result.getString(9));
                e.setLongitudePOintDepart(result.getDouble(10));
                e.setLattitudePOintDepart(result.getDouble(11));
                e.setLongitudePOintArrivee(result.getDouble(12));
                e.setLattitudePOintArrivee(result.getDouble(13));

            }

        } catch (SQLException ex) {
            Logger.getLogger(EvennementServices.class.getName()).log(Level.SEVERE, null, ex);
        }

        return e;
    }
}

