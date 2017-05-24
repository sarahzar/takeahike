
package entities;

import java.util.Date;

public class Evennement {
    
    private int id ;
    private String nom ;
    private Date dateDebut  ;
    private Date dateFin ;
    private int difficulte;
    private int nbrPlaces ;
    private Utilisateur idResponsable ;
    private Endroit idEndroit ;
    private String description ;
    private Double longitudePOintDepart;
    private Double lattitudePOintDepart;
    private Double longitudePOintArrivee;
    private Double lattitudePOintArrivee;
    

    public Evennement() {
    }

    public Evennement(int id, String nom, Date dateDebut, Date dateFin, int difficulte, int nbrPlaces, Utilisateur idResponsable, Endroit idEndroit, String description, Double longitudePOintDepart, Double lattitudePOintDepart, Double longitudePOintArrivee, Double lattitudePOintArrivee) {
        this.id = id;
        this.nom = nom;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.difficulte = difficulte;
        this.nbrPlaces = nbrPlaces;
        this.idResponsable = idResponsable;
        this.idEndroit = idEndroit;
        this.description = description;
        this.longitudePOintDepart = longitudePOintDepart;
        this.lattitudePOintDepart = lattitudePOintDepart;
        this.longitudePOintArrivee = longitudePOintArrivee;
        this.lattitudePOintArrivee = lattitudePOintArrivee;
    }

    public Evennement(String nom, Date dateDebut, Date dateFin, int difficulte, int nbrPlaces, Utilisateur idResponsable, Endroit idEndroit, String description, Double longitudePOintDepart, Double lattitudePOintDepart, Double longitudePOintArrivee, Double lattitudePOintArrivee) {
        this.nom = nom;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.difficulte = difficulte;
        this.nbrPlaces = nbrPlaces;
        this.idResponsable = idResponsable;
        this.idEndroit = idEndroit;
        this.description = description;
        this.longitudePOintDepart = longitudePOintDepart;
        this.lattitudePOintDepart = lattitudePOintDepart;
        this.longitudePOintArrivee = longitudePOintArrivee;
        this.lattitudePOintArrivee = lattitudePOintArrivee;
    }

    public Evennement(int id) {
        this.id = id;
    }

    

    

    

    public Double getLongitudePOintDepart() {
        return longitudePOintDepart;
    }

    public Double getLattitudePOintDepart() {
        return lattitudePOintDepart;
    }

    public Double getLongitudePOintArrivee() {
        return longitudePOintArrivee;
    }

    public Double getLattitudePOintArrivee() {
        return lattitudePOintArrivee;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public int getDifficulte() {
        return difficulte;
    }

    public void setDifficulte(int difficulte) {
        this.difficulte = difficulte;
    }

    public int getNbrPlaces() {
        return nbrPlaces;
    }

    public void setNbrPlaces(int nbrPlaces) {
        this.nbrPlaces = nbrPlaces;
    }

    public Utilisateur getIdResponsable() {
        return idResponsable;
    }

    public void setIdResponsable(Utilisateur idResponsable) {
        this.idResponsable = idResponsable;
        this.idResponsable.setNom(idResponsable.getNom());
        this.idResponsable.setPrenom(idResponsable.getPrenom());
        this.idResponsable.setAdresse(idResponsable.getAdresse());
        this.idResponsable.setDateInscrit(idResponsable.getDateInscrit());
        this.idResponsable.setType(idResponsable.getType());
        this.idResponsable.setTelephone(idResponsable.getTelephone());
        this.idResponsable.setPassword(idResponsable.getPassword());
        this.idResponsable.setConfirmer(idResponsable.getConfirmer());
        this.idResponsable.setDateDeactivation(idResponsable.getDateDeactivation());
        this.idResponsable.setMail(idResponsable.getMail());
        this.idResponsable.setLogin(idResponsable.getLogin());
        this.idResponsable.setEtat(idResponsable.getEtat());
    }

    public Endroit getIdEndroit() {
        return idEndroit;
    }

    public void setIdEndroit(Endroit idEndroit) {
        this.idEndroit = idEndroit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLongitudePOintDepart(Double longitudePOintDepart) {
        this.longitudePOintDepart = longitudePOintDepart;
    }

    public void setLattitudePOintDepart(Double lattitudePOintDepart) {
        this.lattitudePOintDepart = lattitudePOintDepart;
    }

    public void setLongitudePOintArrivee(Double longitudePOintArrivee) {
        this.longitudePOintArrivee = longitudePOintArrivee;
    }

    public void setLattitudePOintArrivee(Double lattitudePOintArrivee) {
        this.lattitudePOintArrivee = lattitudePOintArrivee;
    }

    @Override
    public String toString() {
        return "Evennement{" + "id=" + id + ", nom=" + nom + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", difficulte=" + difficulte + ", nbrPlaces=" + nbrPlaces + ", idResponsable=" + idResponsable + ", idEndroit=" + idEndroit + ", description=" + description + ", longitudePOintDepart=" + longitudePOintDepart + ", lattitudePOintDepart=" + lattitudePOintDepart + ", longitudePOintArrivee=" + longitudePOintArrivee + ", lattitudePOintArrivee=" + lattitudePOintArrivee + '}';
    }

    
    
    
    
}
