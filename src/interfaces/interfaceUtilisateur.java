/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import Models.UtilisateursDetails;
import entities.Utilisateur;
import java.util.List;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;

/**
 *
 * @author asus-pc
 */
public interface interfaceUtilisateur {
    
    
    public void ajouterUtilisateur(Utilisateur u);
    public void supprimerUtilisateur(Utilisateur u);
    public void modifierUtilisateur(Utilisateur u, String nom, String prenom, String adresse, String telephone, String mail);
    public void modifierPasswordUtilisateur (Utilisateur u, String password);
    public ObservableList<Utilisateur> afficherUtilisateur();
    public ObservableList<UtilisateursDetails> listeUtilisateurs();
    public void confirmerUtilisateur (Utilisateur u);
    public void desactiverCompteUtilisateur (Utilisateur u);
    public void activerCompteUtilisateur(Utilisateur u);
    public XYChart.Series<String, Integer> ageRandonneurs();
    public Utilisateur chercherCinUtilisateur (String cin);
    public Utilisateur chercherLoginUtilisateur (String login);
    public List<Utilisateur> chercherRandonneurs();
    
    
    
    
    
}
