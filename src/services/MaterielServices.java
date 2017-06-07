
package services;

import dataConnexion.MyConnexion;
import entities.Materiel;
import entities.Session;
import entities.Utilisateur;
import interfaces.interfaceMateriel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class MaterielServices implements interfaceMateriel  {

        //Connection connect = myConnexion.getInstance().getConnect();
   Utilisateur u=Session.getUser();
    @Override
    public void ajouterMateriel(Materiel m) {
     
            try {
                PreparedStatement insert = MyConnexion.getInstance().getConexion().prepareStatement("INSERT INTO materiel VALUES (?,?,?,?,?,?,?);");
                insert.setInt(1, m.getIdMateriel());
                insert.setString(2, m.getNomMateriel());
                insert.setString(3, m.getDescription());
                insert.setFloat(4, m.getPrix());
                insert.setString(5, u.getCin());
                insert.setInt(6, m.getType());
                insert.setString(7, m.getImage());
                
                insert.executeUpdate();
                
                
                System.out.println("Insertion Done !");
            } catch (SQLException ex) {
                
                
                                    Alert alerte = new Alert(AlertType.ERROR);
                                    alerte.setTitle("Take a Hike");
                                    alerte.setHeaderText(null);
                                    alerte.setContentText("Erreur!");
                                    alerte.showAndWait();
                Logger.getLogger(MaterielServices.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @Override
    public void supprimerMateriel(Materiel m) {
        
            try {
                PreparedStatement delete = MyConnexion.getInstance().getConexion().prepareStatement("DELETE FROM materiel WHERE id=?;");
                delete.setInt(1, m.getIdMateriel());
                delete.executeUpdate();
                System.out.println("Delete is Done !");
            } catch (SQLException ex) {
                Logger.getLogger(MaterielServices.class.getName()).log(Level.SEVERE, null, ex);
            }

    }

    @Override
    public void modifierMateriel(Materiel m) {
        
        
        
            try {
                PreparedStatement update = MyConnexion.getInstance().getConexion().prepareStatement("UPDATE materiel SET nom=?,description=?,prix=?,type=?,`image`=? WHERE id=?;");
                
                update.setString(1, m.getNomMateriel());
                update.setString(2, m.getDescription());
                update.setFloat(3, m.getPrix());
                update.setString(4, u.getCin());
                update.setInt(4, m.getType());
                update.setString(5, m.getImage());
                update.setInt(6, m.getIdMateriel());
                update.executeUpdate();
                System.out.println("Update Done !");
            } catch (SQLException ex) {
                Logger.getLogger(MaterielServices.class.getName()).log(Level.SEVERE, null, ex);
            }

    }

    
    @Override
    public ArrayList<Materiel> afficherMateriel() {
        ArrayList<Materiel> materiels = new ArrayList<>();
            
            
            
            try {               
                Statement stm=MyConnexion.getInstance().getConexion().createStatement();
                UtilisateurServices us = new UtilisateurServices();
                
                ResultSet result= stm.executeQuery("select * from materiel;");
                
                while(result.next()){
                
                Materiel m = new Materiel();
                
                m.setIdMateriel(result.getInt(1));
                m.setNomMateriel(result.getString(2));
                m.setDescription(result.getString(3));
                m.setPrix(result.getFloat(4));
                m.setIdUser(us.chercherCinUtilisateur(result.getString(5)));
                m.setType(result.getInt(6));
                m.setImage(result.getString(7));
                
                materiels.add(m);
                
                }
            } 
            catch (SQLException ex) 
                {Logger.getLogger(MaterielServices.class.getName()).log(Level.SEVERE, null, ex);}
                
        return materiels;            
}
    
}       
            
          

