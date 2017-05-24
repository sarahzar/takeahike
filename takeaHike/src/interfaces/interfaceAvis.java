/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entities.Article;
import entities.Avis;
import java.util.List;

/**
 *
 * @author asus-pc
 */
public interface interfaceAvis {
    
    public void ajouterAvis(Avis a);
    public void supprimerAvis(Avis a);
    public void modifierAvis(Avis a);
    public List<Avis> afficherAvis();
    
}
