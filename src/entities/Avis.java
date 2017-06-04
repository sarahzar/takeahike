
package entities;

import java.util.Date;

public class Avis {
    
    
    private int idAvis;
    private String commentaire;
    private Date datePublicationAvis;
    private int idArticle;
    private String idUtilisateur;

    public Avis() {
    }

    public Avis(int idAvis, String commentaire, Date datePublicationAvis, int idArticle, String idUtilisateur) {
        this.idAvis = idAvis;
        this.commentaire = commentaire;
        this.datePublicationAvis = datePublicationAvis;
        this.idArticle = idArticle;
        this.idUtilisateur = idUtilisateur;
    }

    public Avis(String commentaire, int idArticle, String idUtilisateur) {
        this.commentaire = commentaire;
        this.idArticle = idArticle;
        this.idUtilisateur = idUtilisateur;
    }
    
    

    public Avis(int idAvis) {
        this.idAvis = idAvis;
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

    public int getIdArticle() {
        return idArticle;
    }

    public String getIdUtilisateur() {
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

    public void setIdArticle(int idArticle) {
        this.idArticle = idArticle;
    }

    public void setIdUtilisateur(String idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    @Override
    public String toString() {
        return  commentaire + "\n publié le " + datePublicationAvis + " par " + idUtilisateur;
    }
    
    
    
}
