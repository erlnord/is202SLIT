package slitclient;

import beans.BookingBeanRemote;
import beans.DeliveryBeanRemote;
import slitclient.mainview.TeacherMainView;
import slitclient.mainview.StudentMainView;
import slitclient.mail.Mail;
import slitclient.module.ModuleWindow;
import slitclient.mail.SwingEmailSender;
import beans.InformationBeanRemote;
import beans.ModuleBeanRemote;
import beans.NotificationBeanRemote;
import javax.ejb.EJB;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.jboss.weld.context.ejb.Ejb;
import slit.user.UserBeanRemote;
import slitclient.mail.NotificationWindow;


/**
 *
 * @author Erlend & company
 * 
 * Main-klasse for prosjektet 202-slit
 */
public class Main {
    
    // Injecter ModuleBean
    @EJB(name="ModuleBean")
    private static ModuleBeanRemote moduleInstance;
    
    // Injecter BookingBean
    @EJB(name="BookingBean")
    private static BookingBeanRemote BookingInstance;
    
    // Injecter UserBean
    @EJB(name="UserBean")
    private static UserBeanRemote userInstance;
    
    // Injecter InformationBean
    @EJB(name="InformationBean")
    private static InformationBeanRemote infoInstance;
    
    // Injecter DeliveryBean
    @EJB(name="DeliveryBean")
    private static DeliveryBeanRemote deliveryInstance;
    
    // Injecter NotificationBean
    @EJB(name="NotificationBean")
    private static NotificationBeanRemote notificationInstance;
    
    // Variabler som blir lagret i main og brukt flere steder i programmet
    private static int CurrentUserID;
    private static int ModuleType;
    private static int UserType;
    private static String userMail;

    
    /**
     * Constructor for main
     */
    
    public Main() {
        // Setter lookAndFeel til systemets default
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Oppretter et guiLogInWindow, det første vinduet i applikasjonen
        new guiLogInWindow();
        }
    
    // Returnerer en instans av bruker
    public static UserBeanRemote getUserBean() {
            return userInstance;
    }
    
    // Returnerer en instans av booking
    public static BookingBeanRemote getBookingBean() {
        return BookingInstance;
    }
    
    // Returnerer en instans av levering
    public static DeliveryBeanRemote getDeliveryBean() {
        return deliveryInstance;
    }
    
    // Returnerer en instans av informasjon
    public static InformationBeanRemote getInformationBean() {
            return infoInstance;
    }
    
    // Returnerer en instans av modul
    public static ModuleBeanRemote getModuleBean() {
            return moduleInstance;
    }
    
    // Returnerer en instans av notifikasjon
    public static NotificationBeanRemote getNotificationBean() {
        return notificationInstance;
    }
    
    // Getter-metode for userType
    public static int getUserType() {
        return UserType;
    }
    
    // Setter-metode for userType
    public static void setUserType(int UserType) {
        Main.UserType = UserType;
    }
    
    // Getter-metode for brukeren som er innlogget sin unike ID
    public static int getCurrentUserID() {
        return CurrentUserID;
    }
    
    // Getter-metode for brukeren som er innlogget sin e-post
    public static String getUserMail() {
        return userMail;
    }
    
    // Setter-metode for brukeren som er innlogget sin e-post
    public static void setUserMail(String userMail) {
        Main.userMail = userMail;
    }
    
    // Setter-metode for innlogget bruker sin unike ID
    public static void setCurrentUserID(int CurrentUserID) {
        Main.CurrentUserID = CurrentUserID;
    }
    
    // Getter-metode for modultype
    public static int getModuleType() {
        return ModuleType;
    }
    
    // Setter-metode for modultype
    public static void setModuleType(int ModuleType) {
        Main.ModuleType = ModuleType;
    }
    
    // Metoden Main, som initialiserer programmet
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
                
                // Kjører main
                public void run() {
                new Main();
            }
        });
    }
    
    // Oppretter et vindu av studentMainView
    public static void studentMainView() {
        // StudentMainView
        new StudentMainView();
    }
    
    // Oppretter et vindu av teacherMainView
    public static void teacherMainView() {
        //TeacherMainView
        new TeacherMainView();
    }
    
    // Oppretter et vindu av StudentBooking
    public static void StudentBooking() {
        new StudentBooking();
    }
    
    // Oppretter et vindu av TeacherBooking
    public static void TeacherBooking() {
        new TeacherBooking();
    }
    
    // Oppretter et vindu av Mail, og prøver å ignorere SSL
    public static void Mail() {
        new Mail();
        System.setProperty("javax.net.ssl.trustStore","JAVA_HOME\\lib\\security\\cacerts");
        System.setProperty("javax.net.ssl.trustStorePassword","changeit");
    }
    
    // Oppretter et vindu av SwingEmaiLSender
    public static void SwingEmailSender() {
        SwingEmailSender ses = new SwingEmailSender();
        ses.setVisible(true);
    }
    
    // Oppretter et vindu av ModuleWindow
    public static void ModuleWindow() {
        new ModuleWindow();
    }
    
    // Oppretter et vindu av SettingsWindow
    public static void SettingsWindow() {
        new SettingsWindow();
    }
    
    // Oppretter et vindu av NotificationWindow
    public static void NotificationWindow() {
        NotificationWindow nw = new NotificationWindow();
        nw.setVisible(true);
    }

}