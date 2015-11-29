/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slitclient;

import java.awt.Color;
// import javax.ejb.EJB;
import javax.swing.JFrame;
import javax.swing.UIManager;


/**
 *
 * @author Erlend & company
 */
public class Main {
    
    /**
    @EJB (name="UserFacade")
    private static UserFacadeRemote userInstance;
    * /
    /**
     * @param args the command line arguments
     */
    
    public Main() {
        
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

        //Boolean result = userInstance.addUrne(2, 1, "Urne", "Larsen", "Urne2000", "Urne1234", "urne@urnemail.com");
        //System.out.println("Result: "+result);
        
        
        //Kodesnutt for å fikse menubar på Mac OS X.
        new Main();
                
    }
        
    
    public static void studentMainView() {
        // StudentMainView
        StudentMainView smw = new StudentMainView();
        
    }
    
    public static void teacherMainView() {
        //TeacherMainView
        TeacherMainView tmw = new TeacherMainView();
        
    }
       
    public static void studentBooking() {
        StudentBooking sb = new StudentBooking();
    }
    
    public static void teacherBooking() {
        TeacherBooking tb = new TeacherBooking();
    }
    
    public static void Mail() {
        Mail mail = new Mail();
        
    }
    
    public static void ModuleWindow() {
        ModuleWindow mw = new ModuleWindow();
    }

    public static void SettingsWindow() {
        SettingsWindow sw = new SettingsWindow();
    }
    
    public static void SwingEmailSender() {
        SwingEmailSender ses = new SwingEmailSender();
        ses.setVisible(true);
    }
}   
