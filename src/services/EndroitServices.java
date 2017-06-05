
package services;
import entities.Endroit;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import dataConnexion.MyConnexion;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class EndroitServices implements interfaces.interfaceEndroit{

    @Override
    public void ajouterEndroit(Endroit a) {
        
         try {
            PreparedStatement ajout= MyConnexion.getInstance().getConexion().prepareStatement("insert into endroit values (?,?,?,?);");
            ajout.setInt(1, a.getId());
            ajout.setString(2, a.getNom());
            ajout.setString(3, a.getDescription());
            ajout.setString(4, a.getImage());
            ajout.executeUpdate();
            System.out.println("ajout ok");
        } catch (SQLException ex) {
            Logger.getLogger(EndroitServices.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void supprimerEndroit(Endroit a) {
        
        try {
            PreparedStatement supp= MyConnexion.getInstance().getConexion().prepareStatement("delete from endroit where id=?;");
            supp.setInt(1, a.getId());
            supp.executeUpdate();
            System.out.println("supp ok");
        } catch (SQLException ex) {
            Logger.getLogger(EndroitServices.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void modifierEndroit(Endroit a) {
        
        try {
            PreparedStatement modif = MyConnexion.getInstance().getConexion().prepareStatement("update endroit set nom=? , Description=? where id=?;");
            modif.setString(1, a.getNom());
            modif.setString(2, a.getDescription());
            modif.setInt(3, a.getId());

            modif.executeUpdate();
            System.out.println("great");
        } catch (SQLException ex) {
            Logger.getLogger(EndroitServices.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public List<Endroit> afficherEndroit() {
        
        ArrayList<Endroit> endroits =new ArrayList<>();
        try {
            
            Statement stm = MyConnexion.getInstance().getConexion().createStatement();
            ResultSet result = stm.executeQuery("select * from endroit");
            while(result.next()){
                Endroit endr = new Endroit();
            endr.setId(result.getInt(1));
            endr.setNom(result.getString(2));
            endr.setDescription(result.getString(3));
            endr.setImage(result.getString(4));
            endroits.add(endr);
            
            }
        } catch (SQLException ex) {
            Logger.getLogger(EndroitServices.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return endroits;
        }
        
      public ObservableList<Endroit> displayAll() throws SQLException {
        
            Statement stm = MyConnexion.getInstance().getConexion().createStatement();
            ResultSet rs = stm.executeQuery("select * from endroit");
        ObservableList<Endroit> listends=FXCollections.observableArrayList();       
        
        try {
            
            while(rs.next()){
                Endroit e=new Endroit();
                e.setId(rs.getInt(1));
                e.setNom(rs.getString("nom"));
                e.setDescription(rs.getString("Description"));
                listends.add(e);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(EndroitServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listends;
    }

    @Override
    public Endroit rechercheById(int Id) {
        
        Endroit e = new Endroit();
        try {
            
            Statement stm = MyConnexion.getInstance().getConexion().createStatement();
            ResultSet result = stm.executeQuery("select * from endroit where id = \"" + Id + "\"");
            
            while (result.next()) {

                e.setId(result.getInt(1));
                e.setNom(result.getString(2));

            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(EndroitServices.class.getName()).log(Level.SEVERE, null, ex);
        }
          return e;
    }

    }



    

