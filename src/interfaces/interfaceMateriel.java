/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;
import entities.Materiel;
import java.util.List;

/**
 *
 * @author asus-pc
 */
public interface interfaceMateriel {
    public void ajouterMateriel(Materiel m);
    public void supprimerMateriel(Materiel m);
    public void modifierMateriel(Materiel m);
    public List<Materiel> afficherMateriel();
    
    
}
