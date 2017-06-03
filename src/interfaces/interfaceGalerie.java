/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;
import entities.Galerie;
import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author asus-pc
 */
public interface interfaceGalerie {
     public void ajouterGalerie(Galerie g);
    public void supprimerGalerie(Galerie g);
    public void modifierGalerie(Galerie g);
    public List<Galerie> afficherGalerie();
    public ObservableList<Galerie> afficherGalerie(int id);
}
