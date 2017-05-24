
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
        this.idUtilisateur.setNom(idUtilisateur.getNom());
        this.idUtilisateur.setPrenom(idUtilisateur.getPrenom());
        this.idUtilisateur.setAdresse(idUtilisateur.getAdresse());
        this.idUtilisateur.setDateInscrit(idUtilisateur.getDateInscrit());
        this.idUtilisateur.setType(idUtilisateur.getType());
        this.idUtilisateur.setTelephone(idUtilisateur.getTelephone());
        this.idUtilisateur.setPassword(idUtilisateur.getPassword());
        this.idUtilisateur.setConfirmer(idUtilisateur.getConfirmer());
        this.idUtilisateur.setDateDeactivation(idUtilisateur.getDateDeactivation());
        this.idUtilisateur.setMail(idUtilisateur.getMail());
        this.idUtilisateur.setLogin(idUtilisateur.getLogin());
        this.idUtilisateur.setEtat(idUtilisateur.getEtat());
    }

    @Override
    public String toString() {
        return "Avis{" + "idAvis=" + idAvis + ", commentaire=" + commentaire + ", datePublicationAvis=" + datePublicationAvis + ", idArticle=" + idArticle + ", idUtilisateur=" + idUtilisateur + '}';
    }
    
    
    
}
