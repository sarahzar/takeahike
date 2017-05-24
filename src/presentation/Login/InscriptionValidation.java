/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.Login;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author asus-pc
 */
public class InscriptionValidation {
    public static boolean textFieldNotEmpty (TextField tf) {
        boolean b =false;
        if ((tf.getText() != null) &&(!tf.getText().isEmpty()))
            b=true;
        
        return b;
    }
    
    public static boolean textFieldNotEmpty (TextField tf, Label l, String sValidationText) {
        boolean b =true;
        String errorText="";
        if (!textFieldNotEmpty(tf))
        {
            b=false;
            errorText=sValidationText;
            
        }
        l.setText(errorText);
        return b;
    }
    
    public static boolean confirmerPassword (TextField password, TextField confirm, Label l, String messageError)
    {
        String s="";
        boolean b=true;
        if (!password.getText().equals(confirm.getText()))
        {
            b=false;
            s=messageError;
        }
        l.setText(s);
       return b; 
    }
    
    
    public static boolean verifierEmail (TextField email,Label l, String messageErreur)
    {
        boolean b;
        String s="";
        String masque = "^[a-zA-Z]+[a-zA-Z0-9\\._-]*[a-zA-Z0-9]@[a-zA-Z]+[a-zA-Z0-9\\._-]*[a-zA-Z0-9]+\\.[a-zA-Z]{2,4}$";
        Pattern pattern = Pattern.compile(masque);
        Matcher controler = pattern.matcher(email.getText());
        if (controler.matches()){
            b=true;
         } else{
            s=messageErreur;
            b=false;
         }
        l.setText(s);
        return b;
         }
    
    public static boolean verifierString (TextField tf, Label l, String messageErreur)
    {
        String s="";
        boolean b=true;
        if(!tf.getText().matches("^[a-zA-Z]*$"))
            {
                b=false;
                s=messageErreur;
            }
        l.setText(s);
        return b;
   
    }
    
    public static boolean verifierPassword (TextField tf, Label l, String messageErreur)
    {
        String s="";
        boolean b=true;
        if(!tf.getText().matches("^[a-zA-Z0-9]*$"))
            {
                b=false;
                s=messageErreur;
            }
        l.setText(s);
        return b;
   
    }
    
    public static boolean verifierEntiers (TextField tf, Label l, String messageErreur)
    {
        String s="";
        boolean b=true;
        if((!tf.getText().matches("^[0-9]*$"))||(tf.getText().length()!=8))
            {
                b=false;
                s=messageErreur;
            }
        l.setText(s);
        return b;
   
    }
    
}
