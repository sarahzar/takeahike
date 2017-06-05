/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.Login;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import services.UtilisateurServices;

/**
 * FXML Controller class
 *
 * @author asus-pc
 */
public class HommeFemmeController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private PieChart pieChart;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        UtilisateurServices us= new UtilisateurServices();
        ObservableList<PieChart.Data> sexe=us.hommeFemme();
        pieChart.setData(sexe);
    }    
    
}
