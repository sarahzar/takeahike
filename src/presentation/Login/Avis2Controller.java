/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fx;

import entities.Avis;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import services.AvisServices;

/**
 * FXML Controller class
 *
 * @author Atef
 */
public class Avis2Controller implements Initializable {

    @FXML
    private Button BtnAdd;

    @FXML
    private Button BtnDelete;

    @FXML
    private ListView<String> listBoxMain;

    @FXML
    private TextArea txtAddItem;

    @FXML
    private VBox VBoxMain;

    @FXML
    private Label LblAddText;

    @FXML
    private Label TitleLbl;

    @FXML
    private HBox HBox4Btns;
    
    public String replace( String s, String f, String r )
{
   if (s == null)  return s;
   if (f == null)  return s;
   if (r == null)  r = "";

   int index01 = s.indexOf( f );
   while (index01 != -1)
   {
      s = s.substring(0,index01) + r + s.substring(index01+f.length());
      index01 += r.length();
      index01 = s.indexOf( f, index01 );
   }
   return s;
}
    
    AvisServices av = new AvisServices();
    final ObservableList<String> listItems = av.AfficherCommentaires();
    
    @FXML
  private void addAction(ActionEvent action){
    listItems.add(txtAddItem.getText());
    //System.out.println("Add Button Pushed");
    String txt = replace(txtAddItem.getText(),"\'","\\\'");
    Avis a = new Avis(txt,1,"05480281");
    av.ajouterAvis(a);
  }
  
  
  @FXML
  private void deleteAction(ActionEvent action){
    int selectedItem = listBoxMain.getSelectionModel().getSelectedIndex();
    listItems.remove(selectedItem);
    //String itemToRemove = listBoxMain.getSelectionModel().getSelectedItem();
    ObservableList<String> ids;
    ids=listBoxMain.getSelectionModel().getSelectedItems();
    //Avis a = new Avis(itemToRemove,1,"05480281");
    //av.supprimerAvis(a);
    
  
      String[] strArray = ids.toString().split(" ");
      
      String strId = strArray[strArray.length -1];
      strId = strId.substring(0, strId.length()-1);
      
      System.out.println("ids "+  strId);
      
//      try {
//          for (String id : ids){
//      System.out.println(id);
//    }
//      } catch (Exception e) {
//          e.printStackTrace();
//      }
    
      //System.out.println(selectedItem);
   
  }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    listBoxMain.setItems(listItems);
    listBoxMain.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);    
    // Disable buttons to start
    BtnAdd.setDisable(true);
    //BtnDelete.setDisable(true);

    // Add a ChangeListener to TextField to look for change in focus
    txtAddItem.focusedProperty().addListener(new ChangeListener<Boolean>() {
      public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
        if(txtAddItem.isFocused()){
          BtnAdd.setDisable(false);
        }
     }
    });    

    // Add a ChangeListener to ListView to look for change in focus
    listBoxMain.focusedProperty().addListener(new ChangeListener<Boolean>() {
      @Override
      public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
        if(listBoxMain.isFocused()){
          BtnDelete.setDisable(false);
        }
     }
    }); 
    }    
    
}
