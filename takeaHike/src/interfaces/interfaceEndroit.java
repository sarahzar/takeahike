/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entities.Endroit;
import java.util.List;

/**
 *
 * @author asus-pc
 */
public interface interfaceEndroit {
       public void ajouterEndroit(Endroit a);
    public void supprimerEndroit(Endroit a);
    public void modifierEndroit(Endroit a);
    public List<Endroit> afficherAvis();
    public Endroit rechercheById(int Id);
    
}
