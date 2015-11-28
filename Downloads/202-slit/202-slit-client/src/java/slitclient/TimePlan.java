/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slitclient;

/**
 *
 * @author Trygve Åse Lunde
 */

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebView;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author larsmartin
 */
public class TimePlan {
    
    private static void initAndShowGUI() {
             // This method is invoked on Swing thread
             JFrame frame = new JFrame("FX");
             final JFXPanel fxPanel = new JFXPanel();
             frame.add(fxPanel);
             frame.setVisible(true);

             Platform.runLater(new Runnable() {
                 @Override
                 public void run() {
                     initFX(fxPanel);
                 }
             });
    }
    private static void initFX(JFXPanel fxPanel) {
             // This method is invoked on JavaFX thread
        
        
            WebView webView = new WebView(); webView.getEngine()
                    .load("https://docs.google.com/spreadsheets/d/1ZsvxJt0rim57lH7f_8GmD9AbNya6GllSaFVye8b-0Cg/pubhtml?gid=0&single=true");
            fxPanel.setScene(new Scene(webView)); fxPanel.setVisible(true);
            
         }
    
    /*
    public void start(final Stage stage) throws Exception {
        WebView webView = new WebView(); webView.getEngine()
                .load("https://docs.google.com/spreadsheets/d/1ZsvxJt0rim57lH7f_8GmD9AbNya6GllSaFVye8b-0Cg/pubhtml?gid=0&single=true");
        stage.setScene(new Scene(webView)); stage.show();
    }*/
    
    public static void main(String[] args) {
             SwingUtilities.invokeLater(new Runnable() {
                 @Override
                 public void run() {
                     initAndShowGUI();
                 }
             });
         }
    
}

