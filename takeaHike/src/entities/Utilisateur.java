/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Date;

/**
 *
 * @author asus-pc
 */
public class Utilisateur {
    
    private String cin;
    private int type;
    private String nom;
    private String prenom;
    private String adresse;
    private String telephone;
    private String mail;
    private String password;
    private String login;
    private int confirmer;
    private int etat;
    private Date dateInscrit;
    private Date dateDeactivation;

    public Utilisateur() {
    }

    public Utilisateur(String cin, int type, String nom, String prenom, String adresse, String telephone, String mail, String password, String login, int confirmer, int etat, Date dateInscrit, Date dateDeactivation) {
        this.cin = cin;
        this.type = type;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.telephone = telephone;
        this.mail = mail;
        this.password = password;
        this.login = login;
        this.confirmer = confirmer;
        this.etat = etat;
        this.dateInscrit = dateInscrit;
        this.dateDeactivation = dateDeactivation;
    }

    public Utilisateur(String cin) {
        this.cin = cin;
    }
        
    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getConfirmer() {
        return confirmer;
    }

    public void setConfirmer(int confirmer) {
        this.confirmer = confirmer;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public Date getDateInscrit() {
        return dateInscrit;
    }

    public void setDateInscrit(Date dateInscrit) {
        this.dateInscrit = dateInscrit;
    }

    public Date getDateDeactivation() {
        return dateDeactivation;
    }

    public void setDateDeactivation(Date dateDeactivation) {
        this.dateDeactivation = dateDeactivation;
    }

    @Override
    public String toString() {
        return "Utilisateur{" + "cin=" + cin + ", type=" + type + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", telephone=" + telephone + ", mail=" + mail + ", password=" + password + ", login=" + login + ", confirmer=" + confirmer + ", etat=" + etat + ", dateInscrit=" + dateInscrit + ", dateDeactivation=" + dateDeactivation + '}';
    }
    
    
    
    
    
    
    
    
}
