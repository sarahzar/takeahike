/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.Login;

import services.MaterielServices;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import entities.Materiel;
import entities.Session;
import entities.Utilisateur;
import static java.lang.Float.parseFloat;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import reporting.Report;


public class FXMLtestFridController implements Initializable {
 
 

    @FXML
    private ScrollPane sx;

     @FXML
    private AnchorPane pnn;
          
          
     @FXML
    private JFXButton btajout;
    
  String defimg="/img/tabarka.jpg";
    
    public void grid()
    {
                    
                    Utilisateur user=Session.getUser();
                    Stage newStage = new Stage();
        
                    JFXButton btaff = new JFXButton("");
                    btaff.translateXProperty().set(830);
                    btaff.translateYProperty().set(50);
                    Image icoaff = new Image("/img/icons8-Back-64.png");
                    ImageView icoafff = new ImageView(icoaff);
                    icoafff.setFitHeight(30);
                    icoafff.setFitWidth(30);
                    btaff.setGraphic(icoafff); 
                    
                    
                    JFXButton modifmat = new JFXButton("");
                    modifmat.translateXProperty().set(750);
                    modifmat.translateYProperty().set(50);
                    Image icomodif = new Image("/img/icons8-Available Updates-64.png");
                    ImageView icomodiff = new ImageView(icomodif);
                    icomodiff.setFitHeight(30);
                    icomodiff.setFitWidth(30);
                    modifmat.setGraphic(icomodiff);
                    
                    
                    
                    JFXButton suppmat = new JFXButton("");
                    suppmat.translateXProperty().set(790);
                    suppmat.translateYProperty().set(50);
                    Image icosupp = new Image("/img/icons8-Effacer-40.png");
                    ImageView icosuppp = new ImageView(icosupp);
                    icosuppp.setFitHeight(30);
                    icosuppp.setFitWidth(30);
                    suppmat.setGraphic(icosuppp);
                    
                    
                    JFXButton mailmat = new JFXButton("");
                    mailmat.translateXProperty().set(710);
                    mailmat.translateYProperty().set(50);
                    mailmat.setVisible(false);
                    Image icomail = new Image("/img/icons8-Message-64.png");
                    ImageView icomaill = new ImageView(icomail);
                    icomaill.setFitHeight(30);
                    icomaill.setFitWidth(30);
                    mailmat.setGraphic(icomaill);
                    
                    
                    JFXButton pdf = new JFXButton("");
                    pdf.translateXProperty().set(670);
                    pdf.translateYProperty().set(50);
                    pdf.setVisible(false);
                    Image icopdf = new Image("/img/icons8-PDF-64.png");
                    ImageView icopdff = new ImageView(icopdf);
                    icopdff.setFitHeight(30);
                    icopdff.setFitWidth(30);
                    pdf.setGraphic(icopdff);
                    
                    Image icoajout = new Image("/img/icons8-Add-64.png");
                    ImageView icoajoutt = new ImageView(icoajout);
                    icoajoutt.setFitHeight(30);
                    icoajoutt.setFitWidth(30);
                    btajout.setGraphic(icoajoutt);
                                
                    JFXButton okupdate = new JFXButton("");
                    okupdate.translateXProperty().set(660);
                    okupdate.translateYProperty().set(490);
                    okupdate.setVisible(false);
                    Image icook = new Image("/img/icons8-Coche-64.png");
                    ImageView icookk = new ImageView(icook);
                    icookk.setFitHeight(30);
                    icookk.setFitWidth(30);
                    okupdate.setGraphic(icookk);
                    
                    
                    
                    JFXButton cancelupdate = new JFXButton("");
                    cancelupdate.translateXProperty().set(700);
                    cancelupdate.translateYProperty().set(490);
                    cancelupdate.setVisible(false);
                    Image icocancel = new Image("/img/icons8-Annuler-64.png");
                    ImageView icocancell = new ImageView(icocancel);
                    icocancell.setFitHeight(30);
                    icocancell.setFitWidth(30);
                    cancelupdate.setGraphic(icocancell);
                    
                    
                    
                    GridPane gridee = new GridPane();
                    Pane panepane = new Pane();
                    panepane.setStyle("-fx-background-color:  white;");
                    panepane.translateYProperty().set(150);
                    gridee.prefHeight(900);
                    gridee.prefWidth(600);
                    gridee.setHgap(30);
                    gridee.setVgap(10);
                    gridee.setStyle("-fx-background-color:  #48B8AC;");
                    sx.translateYProperty().set(19);
                    sx.setContent(gridee);
                    
                    MaterielServices ms = new MaterielServices();
                    
                    int x = ms.afficherMateriel().size();
                    int i=0,j=0,nb=0;
                    
                    
                    
                    btaff.setOnAction((event)->
                    {
                    sx.setVisible(true);
                    panepane.setVisible(false);
                    btaff.setVisible(false);
                    modifmat.setVisible(false);
                    suppmat.setVisible(false);
                    okupdate.setVisible(false);
                    cancelupdate.setVisible(false);
                    btajout.setVisible(true);
                    mailmat.setVisible(false);
                    pdf.setVisible(false);
                    grid();
                    });  
                    
                    Pane paneajouut = new Pane();
                    paneajouut.setPrefSize(900, 600);
                    JFXButton okajout = new JFXButton("Valider");
                    okajout.translateXProperty().set(515);
                    okajout.translateYProperty().set(480);
                    okajout.setPrefWidth(150);
                    okajout.setGraphic(icookk);
                   
                    
                    
                    
                    JFXButton annuleajout = new JFXButton("Annuler");
                    annuleajout.translateXProperty().set(300);
                    annuleajout.translateYProperty().set(480);
                    annuleajout.setPrefWidth(150);
                    annuleajout.setGraphic(icocancell);
                    
                    
                    
                    Label labnomajout = new Label("Nom                 :");
                    labnomajout.translateXProperty().set(200);
                    labnomajout.translateYProperty().set(100);
                    
                    labnomajout.setStyle("-fx-font-size:15;");
                    
                    JFXTextField flabnomajout = new JFXTextField();
                    flabnomajout.translateXProperty().set(400);
                    flabnomajout.translateYProperty().set(90);
                    flabnomajout.setPrefWidth(175);
                    
                    Label typematajout = new Label("Materiel pour   :");
                    
                    typematajout.translateXProperty().set(200);
                    typematajout.translateYProperty().set(200);  
                    
                    typematajout.setStyle("-fx-font-size:15;");
                    
                    JFXComboBox<String> ftypematajout = new JFXComboBox();
                    
                    ftypematajout.translateXProperty().set(400);
                    ftypematajout.translateYProperty().set(190);
                    ftypematajout.getItems().add("Materiel pour location");
                    ftypematajout.getItems().add("Materiel pour vente");
                    
                    
                    
                    Label labpriajout = new Label("Prix                   :");
                    
                    labpriajout.translateXProperty().set(200);
                    labpriajout.translateYProperty().set(150);
                    
                    labpriajout.setStyle("-fx-font-size:15;");
                    
                    
                    
                    JFXTextField flabpriajout = new JFXTextField();
                    
                    flabpriajout.translateXProperty().set(400);
                    flabpriajout.translateYProperty().set(140);
                    flabpriajout.setPrefWidth(175);
                    
                    Label desa = new Label("Description du materiel");
                    
                    desa.translateXProperty().set(200);
                    desa.translateYProperty().set(250);
                    
                    desa.setStyle("-fx-font-size:15;");
                    
                    JFXTextArea detmatajout=new JFXTextArea();
                    
                    detmatajout.translateXProperty().set(200);
                    detmatajout.translateYProperty().set(290);
                    
                    
                    detmatajout.setStyle("-fx-text-area-background: #585466;-fx-background-color:white; -fx-text-area-background :white;" );
                    
                    btajout.setOnAction((eajout)->
                    {
                        
                                    
                                    Scene stageScene = new Scene(paneajouut, 900, 600);
                                    newStage.setScene(stageScene);
                                    newStage.show();
                                    
                         
                  
                    });
//                    
                    
                     okajout.setOnAction((okadd)->
                    {
                         String nomadd;  nomadd=flabnomajout.getText();
                         String desadd;  desadd=detmatajout.getText();
                         int typeadd; typeadd=ftypematajout.getSelectionModel().getSelectedIndex();
                         float priadd; priadd=parseFloat(flabpriajout.getText());
                    
                         Materiel m = new Materiel(nomadd, desadd, user, typeadd, priadd,defimg);
                         ms.ajouterMateriel(m);
                         newStage.close();
                         grid();
                         
                         
                    });
                    
                    
                     annuleajout.setOnAction((okadd)->
                    {
                         newStage.close();
                         grid();
                         
                         
                    });
                     
                    paneajouut.getChildren().addAll(annuleajout,okajout,labnomajout,typematajout,labpriajout,detmatajout,flabnomajout,ftypematajout,flabpriajout,desa);
                    paneajouut.setStyle("-fx-background-color: beige; -fx-border-color: #CADAE3");
                    
                    
                    for(i=0;i<x;i=i+2)     
                    {
                        for(j=0;j<2;j++)
                            {
                                if(nb+1<=x)
                                {
                                Label lab = new Label(ms.afficherMateriel().get(nb).getNomMateriel());
                                String nommatpdf = ms.afficherMateriel().get(nb).getNomMateriel();
                                lab.translateYProperty().set(20);
                                lab.translateXProperty().set(200);
                                lab.textFillProperty().set(Color.LIGHTSEAGREEN);
                                lab.setFont(Font.font("Cambria", 18));
                                lab.setOnMouseEntered(new EventHandler<MouseEvent>() {
                                        @Override public void handle(MouseEvent e) {
                                            lab.setScaleX(1.1);
                                            lab.setScaleY(1.1);
                                        }
                                    });
                                
                                lab.setOnMouseExited(new EventHandler<MouseEvent>() {
                                        @Override public void handle(MouseEvent e) {
                                            lab.setScaleX(1);
                                            lab.setScaleY(1);
                                        }
                                    });
                                
                                
                                Label lab2 = new Label(ms.afficherMateriel().get(nb).getDescription());
                                lab2.setPrefSize(150, 40);
                                lab2.setWrapText(true);
                                lab2.setFont(Font.font("Cambria", 14));
                                String descpdf = ms.afficherMateriel().get(nb).getDescription();
                                lab2.translateYProperty().set(70);
                                lab2.translateXProperty().set(200);
                                lab2.textFillProperty().set(Color.SLATEGREY);
                                
                                
                                
                                Label lab3 = new Label(ms.afficherMateriel().get(nb).getUser().getPrenom());
                                lab3.setFont(Font.font("Cambria", 14));
                                String nomuserpdf = ms.afficherMateriel().get(nb).getUser().getNom();
                                String prenomuserpdf = ms.afficherMateriel().get(nb).getUser().getPrenom();
                                String adressuserpdf = ms.afficherMateriel().get(nb).getUser().getAdresse();
                                String teluserpdf = ms.afficherMateriel().get(nb).getUser().getTelephone();
                                String mailuserpdf = ms.afficherMateriel().get(nb).getUser().getMail();
                                        
                                lab3.translateYProperty().set(120);
                                lab3.translateXProperty().set(200);
                                lab3.textFillProperty().set(Color.SLATEGREY);
                                
                                    Image image =new Image(ms.afficherMateriel().get(nb).getImage());
                                    
                            // Image image =new Image(defimg);       
                                    Circle c =new Circle();
                                    c.setRadius(43);
                                    c.translateXProperty().set(40);
                                    c.translateYProperty().set(40);
                                    c.setFill(new ImagePattern(image));
                                

                                Button btnplus = new JFXButton();
                                btnplus.setText("Voir Plus");
                                btnplus.translateYProperty().set(170);
                                btnplus.translateXProperty().set(320);
                                
                                Pane pane = new Pane();
                                
                                pane.getChildren().addAll(c,lab,lab2,lab3,btnplus);
                                pane.setPrefSize(400,200);
                                pane.translateXProperty().set(25);
                                //pane.translateYProperty().set(5);
                                pane.setStyle("-fx-background-color:white; -fx-border-color: #CADAE3");
                                pane.setOnMouseEntered(new EventHandler<MouseEvent>() {
                                        @Override public void handle(MouseEvent e) {
                                            pane.setScaleX(1.03);
                                            pane.setScaleY(1.07);
                                        }
                                    });
                                
                                pane.setOnMouseExited(new EventHandler<MouseEvent>() {
                                        @Override public void handle(MouseEvent e) {
                                            pane.setScaleX(1);
                                            pane.setScaleY(1);
                                        }
                                    });
                                
                                
                                int idmat = ms.afficherMateriel().get(nb).getIdMateriel();
                                
                                Label labnom = new Label("Nom     :");
                                labnom.translateXProperty().set(100);
                                
                                Label nommat = new Label();
                                
                                nommat.translateXProperty().set(170);
                                nommat.setText(ms.afficherMateriel().get(nb).getNomMateriel());
                                
                                JFXTextField fnommat = new JFXTextField();
                                fnommat.translateXProperty().set(170);
                                fnommat.setPrefWidth(175);
                                fnommat.setText(ms.afficherMateriel().get(nb).getNomMateriel());
                                fnommat.setVisible(false);
                                
                                Label des = new Label("Description du materiel");
                                des.translateXProperty().set(100);
                                des.translateYProperty().set(150);

                                JFXTextArea detmat=new JFXTextArea();   
                                detmat.setText((ms.afficherMateriel().get(nb).getDescription()));
                                String dete=(ms.afficherMateriel().get(nb).getDescription());
                                detmat.setEditable(false);
                                detmat.translateXProperty().set(100);
                                detmat.translateYProperty().set(190);
                                detmat.setStyle("-fx-text-area-background: #585466;-fx-background-color:white; -fx-text-area-background :white;" );
                                
                                Label labpri = new Label("Prix       :");
                                labpri.translateXProperty().set(100);
                                labpri.translateYProperty().set(50);
                                
                                JFXTextField fprimat = new JFXTextField();
                                fprimat.translateXProperty().set(170);
                                fprimat.translateYProperty().set(50);
                                fprimat.setText(String.valueOf(ms.afficherMateriel().get(nb).getPrix()));
                                fprimat.isLabelFloat();
                                fprimat.setPrefWidth(175);
                                fprimat.setVisible(false);
                                
                                Label prixmat = new Label();
                                prixmat.translateXProperty().set(170);
                                prixmat.translateYProperty().set(50);
                                prixmat.setText(String.valueOf(ms.afficherMateriel().get(nb).getPrix()));
                                String prixmatpdf = String.valueOf(ms.afficherMateriel().get(nb).getPrix());
                                      
                                Label labtype = new Label("Type     :");
                                labtype.translateXProperty().set(100);
                                labtype.translateYProperty().set(100);
                                
                                JFXComboBox<String> ftypemat = new JFXComboBox();
                                ftypemat.translateXProperty().set(170);
                                ftypemat.translateYProperty().set(100);
                                ftypemat.getItems().add("Materiel pour location");
                                ftypemat.getItems().add("Materiel pour vente");
                                ftypemat.setVisible(false);

                                Label typemat = new Label();
                                typemat.translateXProperty().set(170);
                                typemat.translateYProperty().set(100);
                                
                                String imgmat=ms.afficherMateriel().get(nb).getImage();
                                
                                int typetest = ms.afficherMateriel().get(nb).getType();
                                if(ms.afficherMateriel().get(nb).getType()==0)
                                {
                                    typemat.setText("Materiel pour location");
                                    ftypemat.setValue("Materiel pour location"); 
                                    
                                }
                                else if(ms.afficherMateriel().get(nb).getType()==1)
                                {
                                    typemat.setText("Materiel pour vente");
                                    ftypemat.setValue("Materiel pour vente");
                                }
                                
                                
                                
                                
                                Pane paa= new Pane() ;
                               
                                 
                                 
                                paa.getChildren().addAll(labnom,nommat,des,detmat,labpri,prixmat,labtype,typemat,fnommat, ftypemat,fprimat);
                                
                               
                                
                                gridee.add(pane, j, i);
                                panepane.setDisable(true);
                                
                                
                                
                                
                                btnplus.setOnAction((event)->{
                                btajout.setVisible(false);
                                sx.setVisible(false);
                                panepane.setDisable(false);
                                panepane.getChildren().addAll(paa);
                                mailmat.setVisible(true);
                                pdf.setVisible(true);
                                
                                modifmat.setOnAction((e)->{
                                    mailmat.setVisible(false);
                                    nommat.setVisible(false);
                                    typemat.setVisible(false);
                                    prixmat.setVisible(false);
                                    pdf.setVisible(false);
                                    
                                    fnommat.setVisible(true);
                                    ftypemat.setVisible(true);
                                    fprimat.setVisible(true);
                                    detmat.setEditable(true);
                                    cancelupdate.setVisible(true);
                                    okupdate.setVisible(true);
                                    
                                });
                                
                                cancelupdate.setOnAction((e)->{
                                
                                    nommat.setVisible(true);
                                    typemat.setVisible(true);
                                    prixmat.setVisible(true);
                                    detmat.setText(dete);
                                    mailmat.setVisible(true);
                                    pdf.setVisible(true);
                                    
                                    fnommat.setVisible(false);
                                    ftypemat.setVisible(false);
                                    fprimat.setVisible(false);
                                    detmat.setEditable(false);
                                    cancelupdate.setVisible(false);
                                    okupdate.setVisible(false);
                                    
                                    
                                  
                                
                                
                                });
                                
                                
                                
                                
                                
                                
                                okupdate.setOnAction((emodif)->{
                                Materiel m = new Materiel(idmat, fnommat.getText(), detmat.getText(), user, 0, parseFloat(fprimat.getText()), imgmat);
                             
                                    m.setNomMateriel(fnommat.getText());
                                    m.setDescription(detmat.getText());
                                    m.setPrix(parseFloat(fprimat.getText()));
                                    m.setType(ftypemat.getSelectionModel().getSelectedIndex());
                                    ms.modifierMateriel(m);
                                    sx.setVisible(true);
                                    panepane.setVisible(false);
                                    btaff.setVisible(false);
                                    modifmat.setVisible(false);
                                    suppmat.setVisible(false);
                                    okupdate.setVisible(false);
                                    cancelupdate.setVisible(false);
                                    grid();
                                });
                                
                                
                                suppmat.setOnAction((esupp)->{
                                    
                                Materiel m = new Materiel(idmat);
                                ms.supprimerMateriel(m);
                                sx.setVisible(true);
                                panepane.setVisible(false);
                                btaff.setVisible(false);
                                modifmat.setVisible(false);
                                suppmat.setVisible(false);
                                okupdate.setVisible(false);
                                pdf.setVisible(false);
                                mailmat.setVisible(false);
                                btajout.setVisible(true);
                                grid();
                                });
                                
                                
                                mailmat.setOnAction((e)->{
                                    
                                    try {
                                        Mail mailmatt = new Mail();
                                        String[] atch = new String[100];
                                        atch[0] = "C:\\Users\\monta\\Documents\\NetBeansProjects\\Versiongit\\takeahike\\src\\reporting\\report1.jrxml";
                                        mailmatt.sendmailattach("TakeAHikeTunisia@gmail.com", "SixiemeSens1CINFO2", "montassar.touil@esprit.tn", "haha", "hihi",atch,1);
                                        
                                        
                                    } catch (Exception ex) {
                                        Logger.getLogger(FXMLtestFridController.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                       

                                });
                                
                                
                                pdf.setOnAction((e)->{
                                    
                                    Report rep = new Report();
                                    String url="C:\\Users\\monta\\Documents\\NetBeansProjects\\Versiongit\\takeahike\\src\\reporting\\report1.jrxml";
                                    Map mp=new HashMap();
                                    mp.put("nom", nommatpdf);
                                    mp.put("prix", prixmatpdf);
                                    
                                            if(typetest==0)
                                        {
                                            mp.put("type", "Materiel pour location");

                                        }
                                        else if(typetest==1)
                                        {
                                            mp.put("type", "Materiel pour vente");
                                        }
                                            
                                    mp.put("desc", descpdf);
                                    mp.put("Nomuser", nomuserpdf);
                                    mp.put("prenomuser", prenomuserpdf);
                                    mp.put("adresseuser", adressuserpdf);
                                    mp.put("teluser", teluserpdf);
                                    mp.put("mailuser", mailuserpdf);
                                    rep.showReport(url,mp );
                                });
                                
                                
                                
                                pnn.getChildren().addAll(panepane,btaff,modifmat,suppmat,okupdate,cancelupdate,mailmat,pdf);
                                
                                });
                                
                                
                                
                                                         
                                
                            }
                                nb++;
                                
                                
                            }
                        j=i+j;
                    }
    }

    
    
    
    @Override
    public void initialize  (URL url, ResourceBundle rb) {
                    
                   grid();
        }
}