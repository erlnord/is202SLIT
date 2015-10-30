/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slitclient;

import java.awt.Color;
import javax.swing.*;
import javax.swing.UIManager;

/**
 *
 * @author Erlend
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Log-in Window
        LogInWindow logIn = new LogInWindow();
        logIn.setVisible(true);
        logIn.setSize(550,150);
        logIn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        logIn.setBackground(Color.WHITE);
        
        
        
        
       // StudentMainView studentTest = new StudentMainView();
       // studentTest.setVisible(true);
       // studentTest.setSize(800,600);
       // studentTest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
    
}
