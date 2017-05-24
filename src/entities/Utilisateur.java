/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.time.LocalDate;
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
    private LocalDate dateNaissance;
    private String adresse;
    private String telephone;
    private String mail;
    private String password;
    private String login;
    private int confirmer;
    private int etat;
    private Date dateInscrit;
    private Date dateDeactivation;
    private int sexe;
    private String codeConfirmation;
    private static Utilisateur instance=null;

    private Utilisateur() {
    }
    
    public static Utilisateur getInstance (){
        if (instance == null)
            instance =new Utilisateur ();
        return instance;
    }

    public Utilisateur(String cin, int type, String nom, String prenom,LocalDate dateNaissance, String adresse, String telephone, String mail, String password, String login, int confirmer, int etat, int sexe, String codeConfirmation) {
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
        this.dateNaissance=dateNaissance;
        this.sexe=sexe;
        this.codeConfirmation=codeConfirmation;
        
    }

    public String getCodeConfirmation() {
        return codeConfirmation;
    }

    public void setCodeConfirmation(String codeConfirmation) {
        this.codeConfirmation = codeConfirmation;
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

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
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

    public void setTelephone(String  telephone) {
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

    public int getSexe() {
        return sexe;
    }

    public void setSexe(int sexe) {
        this.sexe = sexe;
    }

    @Override
    public String toString() {
        return "Utilisateur{" + "cin=" + cin + ", type=" + type + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance + ", adresse=" + adresse + ", telephone=" + telephone + ", mail=" + mail + ", password=" + password + ", login=" + login + ", confirmer=" + confirmer + ", etat=" + etat + ", dateInscrit=" + dateInscrit + ", dateDeactivation=" + dateDeactivation + ", sexe=" + sexe + ", codeConfirmation=" + codeConfirmation + '}';
    }

    
    

   
    
    
    
    
    
    
    
}
