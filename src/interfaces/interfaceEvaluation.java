/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entities.Evaluation;
import java.util.List;

/**
 *
 * @author asus-pc
 */
public interface interfaceEvaluation {
    
     public void ajouterEvaluation(Evaluation e);
    public void supprimerEvaluation(Evaluation e);
    public void modifierEvaluation(Evaluation e);
    public List<Evaluation> afficherEvaluation();
    
    
    
}
