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
public class Materiel {
    
    private int idMateriel;
    private String nomMateriel;
    private String description;
    private Utilisateur User;
    private int Type;
    private float prix;
    private String image;
    
    
    public Materiel() {
    }

    public Materiel(int idMateriel) {
        this.idMateriel = idMateriel;
    }
    
    
    

    public Materiel(int idMateriel, String nomMateriel, String description, Utilisateur User, int Type, float prix, String image) {
        this.idMateriel = idMateriel;
        this.nomMateriel = nomMateriel;
        this.description = description;
        this.User = User;
        this.Type = Type;
        this.prix = prix;
        this.image =  image;
    }

    public Materiel(String nomMateriel, String description, Utilisateur User, int Type, float prix, String image) {
        this.nomMateriel = nomMateriel;
        this.description = description;
        this.User = User;
        this.Type = Type;
        this.prix = prix;
        this.image = image;
    }

    
    public int getIdMateriel() {
        return idMateriel;
    }

    public void setIdMateriel(int idMateriel) {
        this.idMateriel = idMateriel;
    }

    public String getNomMateriel() {
        return nomMateriel;
    }

    public void setNomMateriel(String nomMateriel) {
        this.nomMateriel = nomMateriel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIdUser(Utilisateur User) {
        
        this.User = User;
//        this.User.setNom(User.getNom());
//        this.User.setPrenom(User.getPrenom());
//        this.User.setAdresse(User.getAdresse());
//        this.User.setDateInscrit(User.getDateInscrit());
//        this.User.setType(User.getType());
//        this.User.setTelephone(User.getTelephone());
//        this.User.setPassword(User.getPassword());
//        this.User.setConfirmer(User.getConfirmer());
//        this.User.setDateDeactivation(User.getDateDeactivation());
//        this.User.setMail(User.getMail());
//        this.User.setLogin(User.getLogin());
//        this.User.setEtat(User.getEtat());
//        this.User.setDateDeNaissance(User.getDateDeNaissance());
//        this.User.setGouvernorat(User.getGouvernorat());
                
    }
    
    public Utilisateur getUser() {
        return User;
    }

    public int getType() {
        return Type;
    }

    public void setType(int Type) {
        this.Type = Type;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
        
    }

    @Override
    public String toString() {
        return "Materiel{" + "idMateriel=" + idMateriel + ", nomMateriel=" + nomMateriel + ", description=" + description + ", User=" + User + ", Type=" + Type + ", prix=" + prix + ", image=" + image + '}';
    }

    
        
    
    
        
        
    
    
}
