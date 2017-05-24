
package Services;

import Connection.myConnection;
import entities.Materiel;
import entities.Utilisateur;
import Services.UtilisateurServices;
import interfaces.interfaceMateriel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MaterielServices implements interfaceMateriel  {

        Connection connect = myConnection.getInstance().getConnect();

    @Override
    public void ajouterMateriel(Materiel m) {
        
            try {
                PreparedStatement insert = connect.prepareStatement("INSERT INTO materiel VALUES (?,?,?,?,?,?);");
                insert.setInt(1, m.getIdMateriel());
                insert.setString(2, m.getNomMateriel());
                insert.setString(3, m.getDescription());
                insert.setFloat(4, m.getPrix());
                insert.setString(5, m.getUser().getCin());
                insert.setInt(6, m.getType());
                
                insert.executeUpdate();
                System.out.println("Insertion Done !");
            } catch (SQLException ex) {
                Logger.getLogger(MaterielServices.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @Override
    public void supprimerMateriel(Materiel m) {
        
            try {
                PreparedStatement delete = connect.prepareStatement("DELETE FROM materiel WHERE id=?;");
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
                PreparedStatement update = connect.prepareStatement("UPDATE materiel SET nom=?,description=?,prix=?,type=? WHERE id=?;");
                
                update.setString(1, m.getNomMateriel());
                update.setString(2, m.getDescription());
                update.setFloat(3, m.getPrix());
                update.setString(4, m.getUser().getCin());
                update.setInt(4, m.getType());
                update.setInt(5, m.getIdMateriel());
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
                Statement stm=connect.createStatement();
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
                
                materiels.add(m);
                
                }
            } 
            catch (SQLException ex) 
                {Logger.getLogger(MaterielServices.class.getName()).log(Level.SEVERE, null, ex);}
                
        return materiels;            
}
    
}       
            
          

