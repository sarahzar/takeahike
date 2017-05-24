package takeahike;

import Services.EvennementServices;
import entities.Endroit;
import entities.Evennement;
import entities.Utilisateur;
import java.sql.Connection;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TakeaHike {
    
    static Connection connect;
       
    public static void main(String[] args) {       
                
                //Materiel m = new Materiel(7,"sacccc", "sac a dos", "07050203", 1, 20);
                //Materiel m1 = new Materiel("cc", "sac a dos", "07050203", 0, 5000);
                Utilisateur x = new Utilisateur("07050203");
                Endroit en = new Endroit(1);
              //Evennement e = new Evennement(1,"haha", 1, 2, "07050203", 1, "laal", 20.20, 20.20, 20.20, 20.20);
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            java.util.Date date1 = new java.util.Date();
            System.out.println(dateFormat.format(date1));
            java.sql.Date sqlDate1 = new java.sql.Date(date1.getTime());
             
              Evennement e = new Evennement("lala", sqlDate1, sqlDate1, 1, 10, x, en, "2zdzd2", 20.20, 2.1, 3.2, 2.2);
              //Evennement e3 = new Evennement("alala", 18, dateDebut = new Date(116,01,11), dateFin= new Date(117, 02, 11), 1, 10, "02143628", "ghjh", 2.1, 2.4, 3.5, 3.3);

                   /* Calendar c=Calendar.getInstance();
                    c.set(2016, 10, 10);
                    java.util.Date d=c.getTime();*/
                   // e.setDateDebut(d);
                    //e.setDateFin(d);
                //MaterielServices mat= new MaterielServices();
                //UtilisateurServices u = new UtilisateurServices();
               EvennementServices event = new EvennementServices();
                
               // mat.ajouterMateriel(m1);
                //mat.modifierMateriel(m);
                //System.out.println(mat.afficherMateriel());
                event.ajouterEvennement(e);
                System.out.println(event.afficherEvennement());
    }
}
