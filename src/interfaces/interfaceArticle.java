/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entities.Article;
import java.util.List;

/**
 *
 * @author asus-pc
 */
public interface interfaceArticle {
    
     public void ajouterArticle(Article a);
    public void supprimerArticle(Article a);
    public void modifierArticle(Article a);
    public List<Article> afficherArticle();
    public Article chercherArticleById(int id);
    
    
    
    
}
