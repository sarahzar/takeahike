/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author asus-pc
 */
public class Galerie {
    
    
    private int idGallerie;
    private Evennement idEvt;
    private String image;
    private Utilisateur idUser;

    public Galerie() {
    }

    public Galerie(int idArticle, Evennement idEvt, String image, Utilisateur idUser) {
        this.idGallerie = idArticle;
        this.idEvt = idEvt;
        this.image = image;
        this.idUser = idUser;
    }

    public int getIdGallerie() {
        return idGallerie;
    }

    public void setIdGallerie(int idGallerie) {
        this.idGallerie = idGallerie;
    }

    

    public Evennement getIdEvt() {
        return idEvt;
    }

    public void setIdEvt(Evennement idEvt) {
        this.idEvt = idEvt;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Utilisateur getIdUser() {
        return idUser;
    }

    public void setIdUser(Utilisateur idUser) {
        this.idUser = idUser;
    }

    @Override
    public String toString() {
        return "Galerie{" + "idArticle=" + idGallerie + ", idEvt=" + idEvt + ", image=" + image + ", idUser=" + idUser + '}';
    }
    
    
    
    
    
}
