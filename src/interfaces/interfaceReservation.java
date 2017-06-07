/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entities.Evennement;
import entities.Reservation;
import entities.Utilisateur;
import java.util.Date;
import java.util.List;

/**
 *
 * @author USER
 */
public interface interfaceReservation {
    
    
     public int ajouterReservation(Reservation res);
     public int supprimerReservation(String cin,int id,java.sql.Date resdate);
     public List<Reservation> rechercherUtilisateurReservation(String cin);
     public List<Reservation> rechercherReservationParDate(Date date);
     public List<Reservation> rechercherReservationParEvennement(String nomEvennement,String cin);
     public List<Reservation> afficherReservations();
     public List<Evennement> listEvennements();
     public Evennement getEventById(int id) ;
     public Date gerReservationDate(String cin,int id);
     public Reservation getReseravation(int idevt,String cin,Date dateres);
    
}
