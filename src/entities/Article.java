
package entities;

import java.util.Date;

public class Article {
    
    
    private int idArticle;
    private String titre;
    private String description;
    private Date datePublicationArticle;
    private Utilisateur idUtilisateur;
    private String image;

    public Article() {
    }

    public Article(int idArticle, String titre, String description, Date datePublicationArticle, Utilisateur idUtilisateur, String image) {
        this.idArticle = idArticle;
        this.titre = titre;
        this.description = description;
        this.datePublicationArticle = datePublicationArticle;
        this.idUtilisateur = idUtilisateur;
        this.image = image;
    }

    public int getIdArticle() {
        return idArticle;
    }

    public String getTitre() {
        return titre;
    }

    public String getDescription() {
        return description;
    }

    public Date getDatePublication() {
        return datePublicationArticle;
    }

    public Utilisateur getIdUtilisateur() {
        return idUtilisateur;
    }

    public String getImage() {
        return image;
    }

    public void setIdArticle(int idArticle) {
        this.idArticle = idArticle;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDatePublication(Date datePublicationArticle) {
        this.datePublicationArticle = datePublicationArticle;
    }

    public void setIdUtilisateur(Utilisateur idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Article{" + "idArticle=" + idArticle + ", titre" + titre + ", description=" + description + ", datePublicationArticle=" + datePublicationArticle + ", idUtilisateur=" + idUtilisateur + ", image=" + image + '}';
    }
    
    
    
    
    
}
