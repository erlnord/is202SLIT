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
    ImageIcon infoImg = new ImageIcon(getClass().getResource("/images/info.jpg"));
    JButton infoBtn = new JButton(infoImg);
    
    // Initialiserer bookingBtn
    ImageIcon bookingImg = new ImageIcon(getClass().getResource("/images/booking.jpg"));
    JButton bookingBtn = new JButton(bookingImg);
    
    // Initialiserer moduleBtn
    ImageIcon moduleImg = new ImageIcon(getClass().getResource("/images/module.jpg"));
    JButton moduleBtn = new JButton(moduleImg);
    
    // Initialiserer mailBtn
    ImageIcon mailImg = new ImageIcon(getClass().getResource("/images/mail.jpg"));
    JButton mailBtn = new JButton(mailImg);
    
    // Initialiserer settingsBtn
    ImageIcon settingsImg = new ImageIcon(getClass().getResource("/images/settings.jpg"));
    JButton settingsBtn = new JButton(settingsImg);
    
    JPanel topPanel = new JPanel();
    
      // Lager en menylinje
    JMenuBar menuBar = new JMenuBar();
    
    // Lager "Fil"-delen av menyen og alt som hÃƒÂ¸rer til
    JMenu fileMenu = new JMenu("Fil");
    JMenu openFile = new JMenu("Ãƒâ€¦pne");
    JMenuItem fromLocal = new JMenuItem("Lokalt lagret");
    JMenuItem fromCloud = new JMenuItem("Fra sky");
    JMenuItem saveFile = new JMenuItem("Lagre");
    JMenuItem saveAsFile = new JMenuItem("Lagre Som");
    JMenuItem exitApplication = new JMenuItem("Avslutt applikasjonen");
    
    // Lager "Kontakt"-delen av menyen og alt som hÃƒÂ¸rer til
    JMenu contactMenu = new JMenu("Kontakt");
    
    // Lager "Hjelp"-delen av menyen og alt som hÃƒÂ¸rer til
    JMenu helpMenu = new JMenu("Hjelp");
    JMenuItem changeUser = new JMenuItem("Bytt brukertype");
    
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
        
        /*
        bookingBtn.addActionListener ((ActionEvent e) -> {
            for (java.awt.Window win : java.awt.Dialog.getWindows()) {
                win.dispose();
            }
            for (java.awt.Frame frame : java.awt.Frame.getFrames()) {
                frame.dispose();
            }
            
            if (Main.getUserType() == 1) {
                Main.TimePlan();
            } else {
                Main.TimePlan();
            }
        });*/
        
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
