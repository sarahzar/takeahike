
package entities;

import java.util.Date;

public class Avis {
    
    
    private int idAvis;
    private String commentaire;
    private Date datePublicationAvis;
    private Article idArticle;
    private Utilisateur idUtilisateur;

    public Avis() {
    }

    public Avis(int idAvis, String commentaire, Date datePublicationAvis, Article idArticle, Utilisateur idUtilisateur) {
        this.idAvis = idAvis;
        this.commentaire = commentaire;
        this.datePublicationAvis = datePublicationAvis;
        this.idArticle = idArticle;
        this.idUtilisateur = idUtilisateur;
    }

    public int getIdAvis() {
        return idAvis;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public Date getDatePublicationAvis() {
        return datePublicationAvis;
    }

    public Article getIdArticle() {
        return idArticle;
    }

    public Utilisateur getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdAvis(int idAvis) {
        this.idAvis = idAvis;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public void setDatePublicationAvis(Date datePublicationAvis) {
        this.datePublicationAvis = datePublicationAvis;
    }

    public void setIdArticle(Article idArticle) {
        this.idArticle = idArticle;
    }

    public void setIdUtilisateur(Utilisateur idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    @Override
    public String toString() {
        return "Avis{" + "idAvis=" + idAvis + ", commentaire=" + commentaire + ", datePublicationAvis=" + datePublicationAvis + ", idArticle=" + idArticle + ", idUtilisateur=" + idUtilisateur + '}';
    }
    
    
    
}
