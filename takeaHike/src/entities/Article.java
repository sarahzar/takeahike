
package entities;

import java.util.Date;

public class Article {
    
    
    private int idArticle;
    private String titre;
    private String description;
    private Date datePublicationArticle;
    private Utilisateur User;
    private String image;

    public Article() {
    }

    public Article(int idArticle, String titre, String description, Date datePublicationArticle, Utilisateur User, String image) {
        this.idArticle = idArticle;
        this.titre = titre;
        this.description = description;
        this.datePublicationArticle = datePublicationArticle;
        this.User = User;
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

    public Utilisateur getUser() {
        return User;
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

    public void setUser(Utilisateur User) {
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

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Article{" + "idArticle=" + idArticle + ", titre" + titre + ", description=" + description + ", datePublicationArticle=" + datePublicationArticle + ", Utilisateur=" + User + ", image=" + image + '}';
    }
    
    
    
    
    
}
