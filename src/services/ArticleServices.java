/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataConnexion.MyConnexion;
import entities.Article;
import entities.Utilisateur;
import interfaces.interfaceArticle;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hayfa
 */
public class ArticleServices implements interfaceArticle{

    @Override
    public void ajouterArticle(Article a) {
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            java.util.Date date1 = new java.util.Date();
            System.out.println(dateFormat.format(date1));
            java.sql.Date sqlDate1 = new java.sql.Date(date1.getTime());
            PreparedStatement prep = MyConnexion.getInstance().getConexion().prepareStatement("insert into article values (?,?,?,?,?,?);");
            prep.setInt(1, a.getIdArticle());
            prep.setString(2, a.getTitre());
            prep.setString(3,a.getDescription());
            prep.setDate(4, (Date) a.getDatePublication());
            prep.setString(5, a.getIdUtilisateur().getCin() );
            prep.setString(6, a.getImage() );
            prep.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ArticleServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void supprimerArticle(Article a) {
        try {
            PreparedStatement prep = MyConnexion.getInstance().getConexion().prepareStatement("delete from article where id = ?;");
            prep.setInt(1, a.getIdArticle());
            prep.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ArticleServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void modifierArticle(Article a) {
        try {
            PreparedStatement prep = MyConnexion.getInstance().getConexion().prepareStatement("UPDATE article SET titre=?, description=? where id = ?");
            prep.setString(2, a.getTitre());
            prep.setString(3,a.getDescription());
            prep.setString(5, a.getIdUtilisateur().getCin());
            prep.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ArticleServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Article> afficherArticle() {
        
        
        
        
         ArrayList<Article> Articles = new ArrayList<>();
        try {

            Statement stm = MyConnexion.getInstance().getConexion().createStatement();
            ResultSet result = stm.executeQuery("select * from article");

            while (result.next()) {
                Article a = new Article();
                UtilisateurServices us = new UtilisateurServices();
                a.setIdArticle(result.getInt(1));
                a.setTitre(result.getString(2));
                a.setDescription(result.getString(3));
             a.setDatePublication(result.getDate(4));
             a.setIdUtilisateur(us.chercherCinUtilisateur(result.getString(5)));
             a.setImage(result.getString(6));
                Articles.add(a);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Articles;
    }

    @Override
    public Article chercherArticleById(int id) {
        Article a = new Article();
       
        try {
            
            
            Statement stm = MyConnexion.getInstance().getConexion().createStatement();
            ResultSet result = stm.executeQuery("select * from article where id = \"" + id + "\"");
            
            while (result.next()) {
                
               UtilisateurServices us = new UtilisateurServices();
                a.setIdArticle(result.getInt(1));
                a.setTitre(result.getString(2));
                a.setDescription(result.getString(3));
                a.setDatePublication(result.getDate(4));
                a.setIdUtilisateur(us.chercherCinUtilisateur(result.getString(5)));
                
                a.setImage(result.getString(6));
                
                }

        } catch (SQLException ex) {
            Logger.getLogger(ArticleServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }    }
            
         
       
     

