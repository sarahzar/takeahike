/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


/**
 *
 * @author asus-pc
 */
public class UtilisateursDetails {
    private StringProperty cin;
    private StringProperty login;
    private StringProperty nom;
    private StringProperty prenom;
    private StringProperty email;
    private StringProperty telephone;
    private StringProperty  etat;
    private StringProperty  compte;
    private StringProperty  type;
    private StringProperty dateDesactivation;

//    //Default constructor
//    public UserDetails(String nom, String prenom, String department) {
//        this.name = new SimpleStringProperty(name);
//        this.email = new SimpleStringProperty(email);
//        this.department = new SimpleStringProperty(department);
//    }

    public UtilisateursDetails(String cin, String login, String nom, String prenom, String email, String telephone, String etat, String compte, String type) {
        this.cin = new SimpleStringProperty(cin);
        this.login = new SimpleStringProperty(login);
        this.nom = new SimpleStringProperty(nom);
        this.prenom = new SimpleStringProperty(prenom);
        this.email = new SimpleStringProperty(email);
        this.telephone = new SimpleStringProperty(telephone);
        this.etat = new SimpleStringProperty(etat);
        this.compte = new SimpleStringProperty(compte);
        this.type = new SimpleStringProperty(type);
        
        
    }

    
    
    //Getters
    public String getNom() {
        return nom.get();
    }
    public String getPrenom() {
        return prenom.get(); }
    
    public String getCin() {
        return cin.get();
    }
    public String getLogin() {
        return login.get();
    }

    public String getEmail() {
        return email.get();
    }

    public String getTelephone() {
        return telephone.get();
    }
    
    public String getEtat() {
        return etat.get();
    }
    
    public String getCompte() {
        return compte.get();
    }
    public String getType() {
        return type.get();
    }
    
    public String getDateDesactivation() {
        return dateDesactivation.get();
    }

    //Setters
    public void setCin(String value) {
        cin.set(value);
    }
    
    public void setLogin(String value) {
        login.set(value);
    }
    
    public void setNom(String value) {
        nom.set(value);
    }
    
    public void setPrenom(String value) {
        prenom.set(value);
    }
    public void setEmail(String value) {
        email.set(value);
    }
    
    public void setTelephone(String value) {
        telephone.set(value);
    }
    
    public void setEtat(String value) {
        etat.set(value);
    }
    
    public void setCompte(String value) {
        compte.set(value);
    }
    
    public void setType(String value) {
        type.set(value);
    }
    
    public void setDateDesactivation(String value) {
        dateDesactivation.set(value);
    }


    //Property values
    
    public StringProperty cinProperty() {
        return cin;
    }
    public StringProperty loginProperty() {
        return login;
    }
    
    public StringProperty nomProperty() {
        return nom;
    }
    
    public StringProperty prenomProperty() {
        return prenom;
    }
    public StringProperty emailProperty() {
        return email;
    }
    
    public StringProperty telephoneProperty() {
        return telephone;
    }
    
    public StringProperty etatProperty() {
        return etat;
    }

     public StringProperty compteProperty() {
        return compte;
    }
     
     public StringProperty typeProperty() {
        return type;
    }
     
      public StringProperty dateDesactivationProperty() {
        return dateDesactivation;
    }

    @Override
    public String toString() {
        return "UtilisateursDetails{" + "cin=" + cin + ", login=" + login + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", telephone=" + telephone + ", etat=" + etat + ", compte=" + compte + ", type=" + type + ", dateDesactivation=" + dateDesactivation + '}';
    }


   
}
