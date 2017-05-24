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
    
    
    private int idArticle;
    private Evennement idEvt;
    private String image;
    private Utilisateur User;

    public Galerie() {
    }

    public Galerie(int idArticle, Evennement idEvt, String image, Utilisateur User) {
        this.idArticle = idArticle;
        this.idEvt = idEvt;
        this.image = image;
        this.User = User;
    }

    public int getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(int idArticle) {
        this.idArticle = idArticle;
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
        return User;
    }

    public void setIdUser(Utilisateur idUser) {
        this.User = User;
        this.User.setNom(User.getNom());
        this.User.setPrenom(User.getPrenom());
        this.User.setAdresse(User.getAdresse());
        this.User.setDateInscrit(User.getDateInscrit());
        this.User.setType(User.getType());
        this.User.setTelephone(User.getTelephone());
        this.User.setPassword(User.getPassword());
        this.User.setConfirmer(User.getConfirmer());
        this.User.setDateDeactivation(User.getDateDeactivation());
        this.User.setMail(User.getMail());
        this.User.setLogin(User.getLogin());
        this.User.setEtat(User.getEtat());
    }

    @Override
    public String toString() {
        return "Galerie{" + "idArticle=" + idArticle + ", idEvt=" + idEvt + ", image=" + image + ", idUser=" + User + '}';
    }
    
    
    
    
    
}
