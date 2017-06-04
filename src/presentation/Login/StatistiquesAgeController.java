/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.Login;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import services.UtilisateurServices;

/**
 * FXML Controller class
 *
 * @author asus-pc
 */
public class StatistiquesAgeController implements Initializable {

      @FXML
    private BarChart<String, Integer> barchart;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        XYChart.Series<String, Integer> series= new XYChart.Series<>();
        UtilisateurServices us= new UtilisateurServices();
        series=us.ageRandonneurs();
        barchart.getData().add(series);
    }    
    
}
