/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataConnexion.MyConnexion;
import entities.Evaluation;
import entities.Evennement;
import entities.Reservation;
import entities.Utilisateur;
import interfaces.interfaceReservation;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class reservationService implements  interfaceReservation{

    @Override
    public int ajouterReservation(Reservation res) {
        PreparedStatement prepare;
        int resulta=0;
           try {
                 java.util.Date date1 = new java.util.Date();
                 java.sql.Date sqlDate1 = new java.sql.Date(date1.getTime());
            prepare = MyConnexion.getInstance().getConexion().prepareStatement("insert into reservation(idEvennement,idUser,dateReservation) values(?,?,?);");
            prepare.setInt(1, res.getIdEvennement().getId());
            prepare.setString(2, res.getIdUtilisateur().getCin());
            prepare.setDate(3, (Date)sqlDate1);
          
          
        resulta=  prepare.executeUpdate();
          System.out.println("succes ajout");
        } catch (SQLException ex) {
            Logger.getLogger(reservationService.class.getName()).log(Level.SEVERE, null, ex);
        }   
      System.out.println(resulta);
           return resulta;  
        
    }

    @Override
    public int supprimerReservation(String cin,int id,Date resdate) {
             int resultat=0;
          try {
             PreparedStatement prepareDelete= MyConnexion.getInstance().getConexion().prepareStatement("delete from reservation where idUser=? and idEvennement=? and dateReservation=?;");
         prepareDelete.setString(1, cin);
          prepareDelete.setInt(2, id);
          prepareDelete.setDate(3, resdate);
          
         resultat= prepareDelete.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(reservationService.class.getName()).log(Level.SEVERE, null, ex);
        }
          return resultat;
    }

    @Override
    public List<Reservation> afficherReservations() {
              ArrayList<Reservation> reservations=new ArrayList<>();
        try {
            Statement rm=MyConnexion.getInstance().getConexion().createStatement();
            ResultSet result=rm.executeQuery("select * from reservation ");
            while(result.next()){
            
            Reservation res=new Reservation();
            Evennement e=new Evennement();
            Utilisateur user=new Utilisateur();
            
            e.setId(result.getInt(2));
            user.setCin(result.getString(3));
            res.setDateReservation(result.getDate(4));
          
             
             
               res.setIdEvennement(e);
               res.setIdUtilisateur(user);
               
            reservations.add(res);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(reservationService.class.getName()).log(Level.SEVERE, null, ex);
        }
      
         
     return reservations;
    }
    
    


    @Override
    public List<Reservation> rechercherUtilisateurReservation(String cin) {
         ArrayList<Reservation> reservations=new ArrayList<>();
         Utilisateur usr=new Utilisateur();
        try {
            Statement rm=MyConnexion.getInstance().getConexion().createStatement();
            ResultSet result=rm.executeQuery("select nom,dateDebut,dateFin,dateReservation from reservation left join evennement on (reservation.idEvennement=evennement.id) where idUser='"+cin+"' order by dateReservation asc");
            while(result.next()){
            
           Reservation res=new Reservation();
            Evennement e=new Evennement();
            Utilisateur user=new Utilisateur();
            
            e.setNom(result.getString(1));
            e.setDateDebut(result.getDate(2).toLocalDate());
          e.setDateFin(result.getDate(3).toLocalDate());
            res.setDateReservation(result.getDate(4));
             
             
               res.setIdEvennement(e);
               res.setIdUtilisateur(user);
               
            reservations.add(res);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(reservationService.class.getName()).log(Level.SEVERE, null, ex);
        }
      
         
     return reservations;
    }

    @Override
    public List<Reservation> rechercherReservationParDate(java.util.Date date) {
        ArrayList<Reservation> reservations=new ArrayList<>();
         Utilisateur usr=new Utilisateur();
        try {
            Statement rm=MyConnexion.getInstance().getConexion().createStatement();
            ResultSet result=rm.executeQuery("select nom,dateDebut,dateFin,dateReservation from reservation left join evennement on (reservation.idEvennement=evennement.id) where dateReservation='"+date+"' ");
            while(result.next()){
            
            Reservation res=new Reservation();
            Evennement e=new Evennement();
            Utilisateur user=new Utilisateur();
            
            e.setNom(result.getString(1));
      e.setDateDebut(result.getDate(2).toLocalDate());
        e.setDateFin(result.getDate(3).toLocalDate());
            res.setDateReservation(result.getDate(4));
             
             
               res.setIdEvennement(e);
               res.setIdUtilisateur(user);
               
            reservations.add(res);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(reservationService.class.getName()).log(Level.SEVERE, null, ex);
        }
      
         
     return reservations;
    }

    @Override
    public List<Reservation> rechercherReservationParEvennement(String nomEvennement,String cin) {
       ArrayList<Reservation> reservations=new ArrayList<>();
         Utilisateur usr=new Utilisateur();
        try {
            Statement rm=MyConnexion.getInstance().getConexion().createStatement();
            ResultSet result=rm.executeQuery("select nom,dateDebut,dateFin,dateReservation from reservation left join evennement on (reservation.idEvennement=evennement.id) where evennement.nom='"+nomEvennement+"' and idUser="+cin+" order by dateReservation asc");
            while(result.next()){
            
            Reservation res=new Reservation();
            Evennement e=new Evennement();
            Utilisateur user=new Utilisateur();
            
            e.setNom(result.getString(1));
            e.setDateDebut(result.getDate(2).toLocalDate());
            e.setDateFin(result.getDate(3).toLocalDate());
            res.setDateReservation(result.getDate(4));
             
             
               res.setIdEvennement(e);
               res.setIdUtilisateur(user);
               
            reservations.add(res);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(reservationService.class.getName()).log(Level.SEVERE, null, ex);
        }
      
         
     return reservations;
    }

    /**
     *
     * @return
     */
   

    @Override
    public List<Evennement> listEvennements() {
         ArrayList<Evennement> events=new ArrayList<>();
         Utilisateur usr=new Utilisateur();
        try {
            Statement rm=MyConnexion.getInstance().getConexion().createStatement();
            ResultSet result=rm.executeQuery("select nom from evennement");
            while(result.next()){
            
            
            Evennement e=new Evennement();
            
           
           
            e.setNom(result.getString(1));
          
             events.add(e);
             
              
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(reservationService.class.getName()).log(Level.SEVERE, null, ex);
        }
      
         
     return events;
    }

    @Override
    public Evennement getEventById(int id) {
        Evennement e=new Evennement();
         try {
            Statement rm=MyConnexion.getInstance().getConexion().createStatement();
            ResultSet result=rm.executeQuery("select * from evennement where id="+id+" ");
            while(result.next()){
           e.setId(result.getInt(1));
            e.setNom(result.getString(2));
             e.setDateDebut(result.getDate(4).toLocalDate());
              e.setDateFin(result.getDate(5).toLocalDate());
              e.setDifficulte(result.getInt(6));
              e.setDescription(result.getString(9));
            
             
             
              
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(reservationService.class.getName()).log(Level.SEVERE, null, ex);
        }
      
         
     return e;
    }

    @Override
    public java.util.Date gerReservationDate(String cin, int id) {
       Reservation res=new Reservation();
         try {
            Statement rm=MyConnexion.getInstance().getConexion().createStatement();
            ResultSet result=rm.executeQuery("select dateReservation from reservation where idUser='"+cin+"' and idEvennement="+id+" and dateReservation >= all(select dateReservation from reservation where idUser='"+cin+"' and idEvennement="+id+") ");
            while(result.next()){
           res.setDateReservation(result.getDate(1));
            
             
             
              
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(reservationService.class.getName()).log(Level.SEVERE, null, ex);
        }
      
         System.out.println(res.getDateReservation());
         
     return res.getDateReservation();
    }

    @Override
    public Reservation getReseravation(int idevt,String cin,java.util.Date dateres) {
        Reservation res=new Reservation();
         try {
            Statement rm=MyConnexion.getInstance().getConexion().createStatement();
            ResultSet result=rm.executeQuery("select * from reservation where idEvennement="+idevt+" and idUser='"+cin+"' and dateReservation='"+dateres+"' ");
            while(result.next()){
            
            
            Evennement e=new Evennement();
            Utilisateur user=new Utilisateur();
            
            e.setId(result.getInt(2));
            user.setCin(result.getString(3));
            res.setDateReservation(result.getDate(4));
          
             
             
               res.setIdEvennement(e);
               res.setIdUtilisateur(user);
               
           
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(reservationService.class.getName()).log(Level.SEVERE, null, ex);
        }
      
         
     return res;
        
    }
}
