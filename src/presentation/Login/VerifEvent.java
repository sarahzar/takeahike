/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.Login;

import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


/**
 *
 * @author achre
 */
public class VerifEvent {
 
     public static boolean textFieldNotEmpty (TextField tf) {
        boolean b =false;
        if ((tf.getText() != null) &&(!tf.getText().isEmpty()))
            b=true;
        
        return b;
    }
       public static boolean textAreaNotEmpty (TextArea ta) {
        boolean b =false;
        if ((ta.getText() != null) &&(!ta.getText().isEmpty()))
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
           public static boolean textAreaNotEmpty (TextArea ta, Label l, String sValidationText) {
        boolean b =true;
        String errorText="";
        if (!textAreaNotEmpty(ta))
        {
            b=false;
            errorText=sValidationText;
            
        }
        l.setText(errorText);
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
      
         public static boolean verifnbr (TextField tf, Label l, String messageErreur)
    {
        String s="";
        boolean b=true;
        if((!tf.getText().matches("^[0-9]*$"))) 
            {
                b=false;
                s=messageErreur;
            }
        l.setText(s);
        return b;
   
    }
    public static boolean verifdouble (TextField tf, Label l, String messageErreur)
    {
        String s="";
        boolean b=true;
        if((!tf.getText().matches("^[0-9]*.[0-9]*$")) || (tf.getText().matches("^[0-9]*$")))
            {
                b=false;
                s=messageErreur;
            }
        l.setText(s);
        return b;
   
    }
}
