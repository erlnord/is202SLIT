/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slitclient;

import beans.InformationBeanRemote;
import beans.ModuleBeanRemote;
import java.awt.Color;
import javax.ejb.EJB;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import slit.user.UserBeanRemote;


/**
 *
 * @author Erlend & company
 */
public class Main {
    
    @EJB(mappedName="ModuleBean")
    private static ModuleBeanRemote moduleInstance;
    
    @EJB(mappedName="UserBean")
    private static UserBeanRemote userInstance;
    
    @EJB
    private static InformationBeanRemote infoInstance;
    
    private static int UserType;
    private static int ModuleType;
    
    /**
     * @param args the command line arguments
     */
    
    public Main() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        new guiLogInWindow();
        }
    
    public static UserBeanRemote getUserBean() {
            return userInstance;
    }
    
    public static InformationBeanRemote getInformationBean() {
            return infoInstance;
    }
    
    public static ModuleBeanRemote getModuleBean() {
            return moduleInstance;
    }
    
    public static int getUserType() {
        return UserType;
    }

    public static void setUserType(int UserType) {
        Main.UserType = UserType;
    }
    
    public static int getModuleType() {
        return ModuleType;
    }

    public static void setModuleType(int ModuleType) {
        Main.ModuleType = ModuleType;
    }
    
    public static void main(String[] args) {
        
        //Kodesnutt for å fikse menubar på OS X.
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
                new Main();
            }
        });
    }
    
    public static void studentMainView() {
        // StudentMainView
        new StudentMainView();
    }
    
    public static void teacherMainView() {
        //TeacherMainView
        new TeacherMainView();
    }
    
    public static void TimePlan() {
        new TimePlan();
    }
    
    public static void Mail() {
        new Mail();
    }
    
    public static void SwingEmailSender() {
        SwingEmailSender ses = new SwingEmailSender();
        ses.setVisible(true);
    }
    
    public static void ModuleWindow() {
        new ModuleWindow();
    }

    public static void SettingsWindow() {
        new SettingsWindow();
    }

}