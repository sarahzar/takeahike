/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entities.Evennement;
import java.util.ArrayList;


/**
 *
 * @author asus-pc
 */
public interface interfaceEvennement {
    
     public void ajouterEvennement(Evennement e);
    public void supprimerEvennement(Evennement e);
    public void modifierEvennement(Evennement e);
    public ArrayList<Evennement> afficherEvennement();
    public Evennement ChercherEventById(int id);
    
    
    
}
