/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slitclient;

import java.awt.Cursor;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 *
 * @author Erlend
 */
public abstract class ButtonMenu {
    // Lager hovedknappene, som blir brukt til Ã¥ manÃ¸vrere seg rundt 
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
    
    // Lager "Fil"-delen av menyen og alt som hÃ¸rer til
    JMenu fileMenu = new JMenu("Fil");
    JMenu openFile = new JMenu("Ã…pne");
    JMenuItem fromLocal = new JMenuItem("Lokalt lagret");
    JMenuItem fromCloud = new JMenuItem("Fra sky");
    JMenuItem saveFile = new JMenuItem("Lagre");
    JMenuItem saveAsFile = new JMenuItem("Lagre Som");
    JMenuItem exitApplication = new JMenuItem("Avslutt applikasjonen");
    
    // Lager "Kontakt"-delen av menyen og alt som hÃ¸rer til
    JMenu contactMenu = new JMenu("Kontakt");
    
    // Lager "Hjelp"-delen av menyen og alt som hÃ¸rer til
    JMenu helpMenu = new JMenu("Hjelp");
    
    public ButtonMenu(){
        
        // Initialiserer top JPanel
        topPanel.setLayout(new GridLayout(1, 5, 10, 10));
        
        // Initialiserer infoBtn
        infoBtn.setBorderPainted(false); // Slipper Ã¥ se linjene til knappen
        infoBtn.setFocusPainted(false); // Slipper Ã¥ se knappen i bakgrunnen
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
    }
}
