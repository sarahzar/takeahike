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
    private int idEvt;
    private String image;
    private String idUser;

    public Galerie() {
    }

    public Galerie(int idGallerie, int idEvt, String image, String idUser) {
        this.idGallerie = idGallerie;
        this.idEvt = idEvt;
        this.image = image;
        this.idUser = idUser;
    }

    public Galerie(int idEvt, String image, String idUser) {
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

    

    public int getIdEvt() {
        return idEvt;
    }

    public void setIdEvt(int idEvt) {
        this.idEvt = idEvt;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    @Override
    public String toString() {
        return "Galerie{" + "idGallerie=" + idGallerie + ", idEvt=" + idEvt + ", image=" + image + ", idUser=" + idUser + '}';
    }
    
    
    
    
    
}
