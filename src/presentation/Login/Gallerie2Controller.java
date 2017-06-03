/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.Login;

import entities.Galerie;
import entities.Session;
import entities.Utilisateur;
import services.GalerieServices;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

import javafx.stage.FileChooser;

import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
//import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;

import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.util.EntityUtils;
import static presentation.Login.FXMLGRIDEVENTController.idevent;
import services.EvennementServices;

/**
 * FXML Controller class
 *
 * @author Atef
 */
public class Gallerie2Controller implements Initializable {

    @FXML
    TextField path;

    protected Window primaryStage;
    File file;

    @FXML
    private ImageView img;
    
    
    
            
    @FXML
    protected void processBrowse(ActionEvent event) {
        
        
            
        FileChooser chooser = new FileChooser();
        //file=(File) chooser.showOpenMultipleDialog(primaryStage);

        file = chooser.showOpenDialog(primaryStage);
        if (file != null) {
            try {
                String str = file.getCanonicalPath();

                str = str.replace('\\', '/');

                path.setText(str);

            } catch (IOException e) {

                e.printStackTrace();

            }

            System.out.println(file.toURI().toString());
            Image g = new Image(file.toURI().toString());
            img.setImage(g);

        } else {

            path.setText("Cancelled");

        }

    }

   

    @FXML
    protected void processUpload(ActionEvent event) throws IOException {

        //String target="C:\\ftpFiles\\";
        String fileName = file.getPath();
        EvennementServices es = new EvennementServices();
        Utilisateur user=Session.getUser();
        
        //String fileName = "C:/wamp64/www/Nouveaudossier/1.jpg";
        if (file != null) {

            HttpClient httpclient = new DefaultHttpClient();
            httpclient.getParams().setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);

            HttpPost httppost = new HttpPost("http://localhost/takeahike/upload.php");
            //File file = new File("C:/wamp64/www/Nouveaudossier/1.jpg");

            MultipartEntityBuilder builder = MultipartEntityBuilder.create();

            /* example for setting a HttpMultipartMode */
            builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);

            /* example for adding an image part */
            FileBody fileBody = new FileBody(new File(fileName)); //image should be a String
            builder.addPart("my_file", fileBody);

            HttpEntity entity = builder.build();
            httppost.setEntity(entity);
            System.out.println("executing request " + httppost.getRequestLine());
            HttpResponse response = httpclient.execute(httppost);
            HttpEntity resEntity = response.getEntity();
            String responseContent=EntityUtils.toString(response.getEntity());

            System.out.println(response.getStatusLine());
            System.out.println(responseContent);
            if (resEntity != null) {
                //if(Objects.equals("Upload failed!!", responseContent)){
                if (responseContent.equalsIgnoreCase("Upload failed!!")) {
                    Alert a = new Alert(Alert.AlertType.ERROR);
                    a.setTitle("Upload Image");
                     a.setHeaderText(null);
                     a.setContentText("Upload Failed!!");
                   
                   
                    a.showAndWait();
                }else {
                    GalerieServices ga = new GalerieServices();
                    System.out.println(user.getCin());
                    Galerie g = new Galerie(idevent, responseContent, user.getCin());
                    ga.ajouterGalerie(g);
                    Alert a = new Alert(Alert.AlertType.INFORMATION);
                   
                    a.setTitle("Upload Image");
                     a.setHeaderText(null);
                     a.setContentText("Upload Done!!");
                    a.showAndWait();
                    System.out.println(EntityUtils.toString(resEntity));
                }
            }
            if (resEntity != null) {
                resEntity.consumeContent();
            }

            httpclient.getConnectionManager().shutdown();

        }

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
