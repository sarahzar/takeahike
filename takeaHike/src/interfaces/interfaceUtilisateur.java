/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entities.Utilisateur;
import java.util.List;

/**
 *
 * @author asus-pc
 */
public interface interfaceUtilisateur {
    
    
    public void ajouterUtilisateur(Utilisateur u);
    public void supprimerUtilisateur(Utilisateur u);
    public void modifierUtilisateur(Utilisateur u, String nom, String prenom, String adresse, String telephone);
    public List<Utilisateur> afficherUtilisateur();
    public void confirmerUtilisateur (Utilisateur u);
    public void desactiverCompteUtilisateur (Utilisateur u);
    public Utilisateur chercherCinUtilisateur (String cin);
    public List<Utilisateur> chercherRandonneurs();
    
    
    
    
    
    
}
