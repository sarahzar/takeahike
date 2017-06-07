/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reporting;

import dataConnexion.MyConnexion;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author monta
 */
public class Report {
    
      public void showReport(String url,Map map)
    {
     
          try {
              JasperReport jasper = JasperCompileManager.compileReport(url);
              
              JasperPrint jasperprint = JasperFillManager.fillReport(jasper,map,MyConnexion.getInstance().getConexion());
              JRViewer view = new JRViewer(jasperprint);
              view.setOpaque(true);
              view.setVisible(true);
              JFrame  frm = new JFrame();
              frm.add(view);
              frm.setSize(900, 550);
              frm.setVisible(true);
              System.out.println("Done exporting reports to pdf");
          } catch (JRException ex) {
              Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
          }
              
    }
    
}
