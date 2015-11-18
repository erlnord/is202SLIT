/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slitclient;

import java.awt.Color;
import javax.ejb.EJB;
import javax.swing.*;
import service.messageBeanRemote;

/**
 *
 * @author Erlend & company
 */
public class Main {
    
    @EJB (name="messageBean")
    private static messageBeanRemote messageInstance;

    /**
     * @param args the command line arguments
     */
    
    public Main() {
        Boolean result = messageInstance.addMessage("Dette er en test");
        System.out.println("Result: " +result);
        
        // TODO code application logic here
        
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        guiLogInWindow logIn = new guiLogInWindow();
        logIn.setVisible(true);
        logIn.setSize(600,150);
        logIn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        logIn.setBackground(Color.WHITE);
        // Plasserer applikasjonen midt på skjermen
        logIn.setLocationRelativeTo(null);
        
    }
    
    public static void main(String[] args) {
        
        //Kodesnutt for å fikse menubar på Mac OS X.
        try {
                System.setProperty("apple.laf.useScreenMenuBar", "true");
                System.setProperty("com.apple.mrj.application.apple.menu.about.name", "Test");
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            }
            catch(ClassNotFoundException e) {
                System.out.println("ClassNotFoundException: " + e.getMessage());
            }
            catch(InstantiationException e) {
                System.out.println("InstantiationException: " + e.getMessage());
            }
            catch(IllegalAccessException e) {
                System.out.println("IllegalAccessException: " + e.getMessage());
            }
            catch(UnsupportedLookAndFeelException e) {
                System.out.println("UnsupportedLookAndFeelException: " + e.getMessage());
            }
            javax.swing.SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    new Main(); //Her kjøres konstruktøren
                }
        });
    }
    
    public static void studentMainView() {
        // StudentMainView
        StudentMainView smw = new StudentMainView();
        smw.frame.setVisible(true);
        smw.frame.setSize(1300,768);
        smw.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        smw.frame.setBackground(Color.WHITE);
        smw.frame.setLocationRelativeTo(null);
    }
    
    public static void teacherMainView() {
        //TeacherMainView
        TeacherMainView tmw = new TeacherMainView();
        tmw.frame.setVisible(true);
        tmw.frame.setSize(1300,768);
        tmw.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tmw.frame.setBackground(Color.WHITE);
        tmw.frame.setLocationRelativeTo(null);
    }
        

}