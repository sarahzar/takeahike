/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.Login;

import dataConnexion.MyConnexion;
import entities.Article;
import java.awt.Rectangle;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.input.KeyCombination.Modifier;
import javafx.scene.layout.Background;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;
import static javax.management.Query.plus;
import javax.swing.JLabel;
import services.ArticleServices;
 
public class TestListView extends Application {
    
 
       
    
    public static final ObservableList names = 
        FXCollections.observableArrayList();
    public static final ObservableList   data =
        FXCollections.observableArrayList();
       
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        try {
            primaryStage.setTitle("Afiicher Articles");
            
            final Label titre = new Label("Les articles les plus récents");
            titre.setVisible(true);
            
            final ListView listView = new ListView(data);
            listView.setPrefSize(20000, 10000);
            listView.setEditable(true);
            listView.setBackground(Background.EMPTY);
            names.addAll(
                    "Modifier", "Supprimer","Afficher Détails"
                    
            );
            
            Statement stm = MyConnexion.getInstance().getConexion().createStatement();
            ResultSet result = stm.executeQuery("select * from article");
            while (result.next()) {
                
                ArticleServices as= new ArticleServices();
                Article a = new Article();
                //a.setTitre(result.getString(2));
                data.add(result.getString(2));
            }
            

            listView.setItems(data);
            listView.setCellFactory(ComboBoxListCell.forListView(names));
        
            
            
           
            
            StackPane root = new StackPane();
            root.getChildren().add(listView);
            primaryStage.setScene(new Scene(root, 1200, 1200));
            primaryStage.show();
        } catch (SQLException ex) {
            Logger.getLogger(TestListView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
