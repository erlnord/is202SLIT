/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slitclient;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Erlend
 */
public abstract class ButtonMenu {
    // Lager hovedknappene, som blir brukt til ÃƒÂ¥ manÃƒÂ¸vrere seg rundt 
    // i systemet. Bruker bilder som ikoner.
    // Initialiserer infoBtn
    protected ImageIcon infoImg = new ImageIcon(getClass().getResource("/images/info.jpg"));
    protected JButton infoBtn = new JButton(infoImg);
    
    // Initialiserer bookingBtn
    protected ImageIcon bookingImg = new ImageIcon(getClass().getResource("/images/booking.jpg"));
    protected JButton bookingBtn = new JButton(bookingImg);
    
    // Initialiserer moduleBtn
    protected ImageIcon moduleImg = new ImageIcon(getClass().getResource("/images/module.jpg"));
    protected JButton moduleBtn = new JButton(moduleImg);
    
    // Initialiserer mailBtn
    protected ImageIcon mailImg = new ImageIcon(getClass().getResource("/images/mail.jpg"));
    protected JButton mailBtn = new JButton(mailImg);
    
    // Initialiserer settingsBtn
    protected ImageIcon settingsImg = new ImageIcon(getClass().getResource("/images/settings.jpg"));
    protected JButton settingsBtn = new JButton(settingsImg);
    
    protected JPanel topPanel = new JPanel();
    
      // Lager en menylinje
    protected JMenuBar menuBar = new JMenuBar();
    
    // Lager "Fil"-delen av menyen og alt som hÃƒÂ¸rer til
    protected JMenu fileMenu = new JMenu("Fil");
    protected JMenu openFile = new JMenu("Ãƒâ€¦pne");
    protected JMenuItem fromLocal = new JMenuItem("Lokalt lagret");
    protected JMenuItem fromCloud = new JMenuItem("Fra sky");
    protected JMenuItem saveFile = new JMenuItem("Lagre");
    protected JMenuItem saveAsFile = new JMenuItem("Lagre Som");
    protected JMenuItem exitApplication = new JMenuItem("Avslutt applikasjonen");
    protected JMenuItem logOut = new JMenuItem("Logg ut");
    
    // Lager "Kontakt"-delen av menyen og alt som hÃƒÂ¸rer til
    protected JMenu contactMenu = new JMenu("Kontakt");
    
    // Lager "Hjelp"-delen av menyen og alt som hÃƒÂ¸rer til
    protected JMenu helpMenu = new JMenu("Hjelp");
    protected JMenuItem changeUser = new JMenuItem("Bytt brukertype");
    
    public ButtonMenu(){
        
        // Initialiserer top JPanel
        topPanel.setLayout(new GridLayout(1, 5, 10, 10));
        topPanel.setBackground(Color.WHITE);
        
        // Initialiserer infoBtn
        infoBtn.setBorderPainted(false); // Slipper ÃƒÂ¥ se linjene til knappen
        infoBtn.setFocusPainted(false); // Slipper ÃƒÂ¥ se knappen i bakgrunnen
        infoBtn.setContentAreaFilled(false);
        infoBtn.setSize(1, 1);
        infoBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        topPanel.add(infoBtn);
        
        // Initialiserer bookingBtn
        bookingBtn.setBorderPainted(false);
        bookingBtn.setFocusPainted(false);
        bookingBtn.setContentAreaFilled(false);
        bookingBtn.setSize(1, 1);
        bookingBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        topPanel.add(bookingBtn);
        
        // Initialiserer moduleBtn
        moduleBtn.setBorderPainted(false);
        moduleBtn.setFocusPainted(false);
        moduleBtn.setContentAreaFilled(false);
        moduleBtn.setSize(1, 1);
        moduleBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        topPanel.add(moduleBtn);
        
        // Initialiserer mailBtn
        mailBtn.setBorderPainted(false);
        mailBtn.setFocusPainted(false);
        mailBtn.setContentAreaFilled(false);
        mailBtn.setSize(1, 1);
        mailBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        topPanel.add(mailBtn);
        
        // Initialiserer settingsBtn
        settingsBtn.setBorderPainted(false);
        settingsBtn.setFocusPainted(false);
        settingsBtn.setContentAreaFilled(false);
        settingsBtn.setSize(1, 1);
        settingsBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        topPanel.add(settingsBtn);
        
         // Legger til fil-menyen i menylinja, og legger til menyelementer
        menuBar.add(fileMenu);
        fileMenu.add(openFile);
        openFile.add(fromLocal);
        openFile.add(fromCloud);
        fileMenu.add(saveFile);
        fileMenu.add(saveAsFile);
        fileMenu.add(logOut);
        fileMenu.add(exitApplication);
        
        // Legger til kontakt-menyen i menylinja, og legger til elementer
        menuBar.add(contactMenu);
        
        // Legger til hjelp-menyen i menylinja, og legger til elementer
        menuBar.add(helpMenu);
        helpMenu.add(changeUser);
        
         /**
         * Legger til en actionListener som avslutter applikasjonen
         * dersom man trykker pÃƒÂ¥ "avslutt" i menyen.
         * SpÃƒÂ¸r ogsÃƒÂ¥ brukeren om han/hun er sikker pÃƒÂ¥ at applikasjonen skal
         * avsluttes.
         */
        exitApplication.addActionListener(new ActionListener() {
            String message = "Where were you when application was kill?";
            String title = "Avslutt applikasjon";
            @Override
            public void actionPerformed(ActionEvent e) {
                    int reply = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
                    if (reply == JOptionPane.YES_OPTION) {
                        JOptionPane.showMessageDialog(null, "Application is kill RIP.");
                        System.exit(0);
                    }
            }
        }); 
        
        logOut.addActionListener(new ActionListener() {
            String message = "Vil du logge ut?";
            String title = "Logg ut";
            @Override
            public void actionPerformed(ActionEvent e) {
                    int reply = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
                    if (reply == JOptionPane.YES_OPTION) {
                        JOptionPane.showMessageDialog(null, "Du har nå logget av systemet.");
                        Main.setUserType(0);
                        for (java.awt.Frame frame : java.awt.Frame.getFrames()) {
                            frame.dispose();
                        }
                        new guiLogInWindow();
                        
                    }
            }
        }); 
        
        changeUser.addActionListener(new ActionListener() {
            String message = "Vil du bytte brukertype?";
            String title = "Brukerbytte";
            @Override
            public void actionPerformed(ActionEvent e) {
                    int reply = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
                    if (reply == JOptionPane.YES_OPTION) {
                        if (Main.getUserType() == 1) {
                            Main.setUserType(2);
                            JOptionPane.showMessageDialog(null, "Brukertype er nå 'teacher'.");
                        } else {
                            Main.setUserType(1);
                            JOptionPane.showMessageDialog(null, "Brukertype er nå 'student'.");
                        }
                    }
            }
        }); 
        
        // ActionListeners for knappene.
        // Hver actionlistener har en for-løkke som lukker alle åpne frames
        // Før den kaller en metode i main som oppretter en ny frame for hver av
        // vinduene. 
        infoBtn.addActionListener ((ActionEvent e) -> {
            for (java.awt.Window win : java.awt.Dialog.getWindows()) {
                win.dispose();
            }
            for (java.awt.Frame frame : java.awt.Frame.getFrames()) {
                frame.dispose();
            }
            
            if (Main.getUserType() == 1) {
                Main.studentMainView();
            } else {
                Main.teacherMainView();
            }
        });
        
        
        bookingBtn.addActionListener ((ActionEvent e) -> {
            for (java.awt.Window win : java.awt.Dialog.getWindows()) {
                win.dispose();
            }
            for (java.awt.Frame frame : java.awt.Frame.getFrames()) {
                frame.dispose();
            }
            
            if (Main.getUserType() == 1) {
                Main.StudentBooking();
            } else {
                Main.TeacherBooking();
            }
        });
        
        mailBtn.addActionListener((ActionEvent e) -> {
            for (java.awt.Window win : java.awt.Dialog.getWindows()) {
                win.dispose();
            }
            for (java.awt.Frame frame : java.awt.Frame.getFrames()) {
                frame.dispose();
            }
            
            if (Main.getUserType() == 1) {
                Main.Mail();
            } else {
                Main.Mail();
            }
        });
        
        settingsBtn.addActionListener ((ActionEvent e) -> {
            for (java.awt.Window win : java.awt.Dialog.getWindows()) {
                win.dispose();
            }
            for (java.awt.Frame frame : java.awt.Frame.getFrames()) {
                frame.dispose();
            }
            
            if (Main.getUserType() == 1) {
                Main.SettingsWindow();
            } else {
                Main.SettingsWindow();
            }
        });
        
        moduleBtn.addActionListener ((ActionEvent e) -> {
            for (java.awt.Window win : java.awt.Dialog.getWindows()) {
                win.dispose();
            }
            for (java.awt.Frame frame : java.awt.Frame.getFrames()) {
                frame.dispose();
            }
            
            if (Main.getUserType() == 1) {
                Main.ModuleWindow();
            } else {
                Main.ModuleWindow();
            }
        });
    }
}   
