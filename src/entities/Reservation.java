/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Date;

/**
 *
 * @author USER
 */
public class Reservation {
    
    
    private int idReservation;
    private Evennement idEvennement;
    private Utilisateur idUtilisateur;
    private Date dateReservation;

    public Reservation() {
    }
    
    
    

    public Reservation(int idReservation, Evennement idEvennement, Utilisateur idUtilisateur, Date dateReservation) {
        this.idReservation = idReservation;
        this.idEvennement = idEvennement;
        this.idUtilisateur = idUtilisateur;
        this.dateReservation = dateReservation;
    }

    public int getIdReservation() {
        return idReservation;
    }

    public Evennement getIdEvennement() {
        return idEvennement;
    }

    public Utilisateur getIdUtilisateur() {
        return idUtilisateur;
    }

    public Date getDateReservation() {
        return dateReservation;
    }

    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
    }

    public void setIdEvennement(Evennement idEvennement) {
        this.idEvennement = idEvennement;
    }

    public void setIdUtilisateur(Utilisateur idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public void setDateReservation(Date dateReservation) {
        this.dateReservation = dateReservation;
    }

    @Override
    public String toString() {
        return "Reservation{" + "idReservation=" + idReservation + ", idEvennement=" + idEvennement + ", idUtilisateur=" + idUtilisateur + ", dateReservation=" + dateReservation + '}';
    }
    
    
    
}
