
package entities;

import java.util.Date;

public class Evaluation {
    private int idEvaluation;
    private int note;
    private String commentaire;
    private Date dateEvaluation;
    private Evennement idEvennement;
    private Utilisateur idUtilisateur;

    public Evaluation(int idEvaluation, int note, String commentaire, Date dateEvaluation, Evennement idEvennement, Utilisateur idUtilisateur) {
        this.idEvaluation = idEvaluation;
        this.note = note;
        this.commentaire = commentaire;
        this.dateEvaluation = dateEvaluation;
        this.idEvennement = idEvennement;
        this.idUtilisateur = idUtilisateur;
        
                 }

    public Evaluation() {
    }

    public int getIdEvaluation() {
        return idEvaluation;
    }

    public int getNote() {
        return note;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public Date getDateEvaluation() {
        return dateEvaluation;
    }

    public Evennement getIdEvennement() {
        return idEvennement;
    }

    public Utilisateur getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdEvaluation(int idEvaluation) {
        this.idEvaluation = idEvaluation;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public void setDateEvaluation(Date dateEvaluation) {
        this.dateEvaluation = dateEvaluation;
    }

    public void setIdEvennement(Evennement idEvennement) {
        this.idEvennement = idEvennement;
    }

    public void setIdUtilisateur(Utilisateur idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    @Override
    public String toString() {
        return "Evaluation{" + "idEvaluation=" + idEvaluation + ", note=" + note + ", commentaire=" + commentaire + ", dateEvaluation=" + dateEvaluation + ", idEvennement=" + idEvennement + ", idUtilisateur=" + idUtilisateur + '}';
    }
    
    
    
}
