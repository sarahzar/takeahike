
package Services;
import entities.Endroit;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Connection.myConnection;
import java.util.List;


public class EndroitServices implements interfaces.interfaceEndroit{

    @Override
    public void ajouterEndroit(Endroit a) {
        
         try {
            PreparedStatement ajout= myConnection.getInstance().getConnect().prepareStatement("insert into endroit values (?,?);");
            ajout.setInt(1, a.getId());
            ajout.setString(2, a.getNom());
            ajout.executeUpdate();
            System.out.println("ajout ok");
        } catch (SQLException ex) {
            Logger.getLogger(EndroitServices.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void supprimerEndroit(Endroit a) {
        
        try {
            PreparedStatement supp= myConnection.getInstance().getConnect().prepareStatement("delete from endroit where id=?;");
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
            PreparedStatement modif = myConnection.getInstance().getConnect().prepareStatement("update endroit set nom=? where id=?;");
            modif.setString(1, a.getNom());
            modif.setInt(2, a.getId());

            modif.executeUpdate();
            System.out.println("great");
        } catch (SQLException ex) {
            Logger.getLogger(EndroitServices.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public List<Endroit> afficherAvis() {
        
        ArrayList<Endroit> endroits =new ArrayList<>();
        try {
            
            Statement stm = myConnection.getInstance().getConnect().createStatement();
            ResultSet result = stm.executeQuery("select * from endroit");
            while(result.next()){
                Endroit endr = new Endroit();
            endr.setId(result.getInt(1));
            endr.setNom(result.getString(2));
            endroits.add(endr);
            
            }
        } catch (SQLException ex) {
            Logger.getLogger(EndroitServices.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return endroits;
        }

    @Override
    public Endroit rechercheById(int Id) {
        
        Endroit e = new Endroit();
        try {
            
            Statement stm = myConnection.getInstance().getConnect().createStatement();
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



    

